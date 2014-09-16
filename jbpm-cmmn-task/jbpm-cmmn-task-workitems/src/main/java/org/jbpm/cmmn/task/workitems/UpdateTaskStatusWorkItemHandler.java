package org.jbpm.cmmn.task.workitems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.drools.core.process.instance.WorkItemHandler;
import org.drools.persistence.PersistenceContext;
import org.drools.persistence.PersistenceContextManager;
import org.drools.persistence.jpa.JpaPersistenceContext;
import org.drools.persistence.jpa.JpaPersistenceContextManager;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.PlanItemTransition;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.task.additional.commands.AutomaticallyStartTaskCommand;
import org.jbpm.cmmn.task.additional.commands.CompleteTaskCommand;
import org.jbpm.cmmn.task.additional.commands.ExitCriteriaTaskCommand;
import org.jbpm.cmmn.task.additional.commands.ResumeTaskFromParentCommand;
import org.jbpm.cmmn.task.additional.commands.SetTaskOutputCommand;
import org.jbpm.cmmn.task.additional.commands.SuspendTaskFromParentCommand;
import org.jbpm.services.task.commands.ActivateTaskCommand;
import org.jbpm.services.task.commands.ClaimTaskCommand;
import org.jbpm.services.task.commands.FailTaskCommand;
import org.jbpm.services.task.commands.SuspendTaskCommand;
import org.jbpm.services.task.commands.TaskCommand;
import org.jbpm.services.task.impl.model.GroupImpl;
import org.jbpm.services.task.wih.util.PeopleAssignmentHelper;
import org.kie.api.runtime.EnvironmentName;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.task.model.OrganizationalEntity;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.kie.internal.task.api.InternalTaskService;

public class UpdateTaskStatusWorkItemHandler implements WorkItemHandler {
	private RuntimeManager runtimeManager;

	public RuntimeManager getRuntimeManager() {
		return runtimeManager;
	}

	public void setRuntimeManager(RuntimeManager runtimeManager) {
		this.runtimeManager = runtimeManager;
	}

	@Override
	public void executeWorkItem(final WorkItem workItem, WorkItemManager manager) {
		RuntimeEngine runtime = getRuntimeManager().getRuntimeEngine(ProcessInstanceIdContext.get(workItem.getProcessInstanceId()));
		PersistenceContextManager pcm = (PersistenceContextManager) runtime.getKieSession().getEnvironment().get( EnvironmentName.PERSISTENCE_CONTEXT_MANAGER );
		if(pcm instanceof JpaPersistenceContextManager){
			JpaPersistenceContextManager jpcm=(JpaPersistenceContextManager) pcm;
			jpcm.getCommandScopedEntityManager().flush();//To force process persistence
		}

		final Long workItemId = (Long) workItem.getParameter(WorkItemParameters.WORK_ITEM_ID);
		final PlanItemTransition transition = (PlanItemTransition) workItem.getParameter(WorkItemParameters.TASK_TRANSITION);
		InternalTaskService its = (InternalTaskService) runtime.getTaskService();
		Task task = its.getTaskByWorkItemId(workItemId);
		long taskId = task.getId();
		String currentUserId = null;
		if (task.getTaskData().getActualOwner() != null) {
			currentUserId = task.getTaskData().getActualOwner().getId();
		} else {
			currentUserId = (String) workItem.getParameter(PeopleAssignmentHelper.ACTOR_ID);
		}
		TaskCommand<?> cmd = null;
		String gidString = (String) workItem.getParameter(PeopleAssignmentHelper.GROUP_ID);
		gidString = gidString == null ? "" : gidString;
		String[] groupIds = gidString.split(System.getProperty("org.jbpm.ht.user.separator", ","));
		if (transition == null) {
			if (Boolean.TRUE.equals(workItem.getParameter(WorkItemParameters.SET_OUTPUT))) {
				cmd = new SetTaskOutputCommand(task.getId(), workItem.getParameters());
			}
		} else {
			switch (transition) {
			case START:
				if (currentUserId == null) {
					currentUserId = findBestUserFromGroups(its, groupIds);
				}
				cmd = new AutomaticallyStartTaskCommand(taskId, currentUserId, workItem.getParameters());
				break;
			case EXIT:
				cmd = new ExitCriteriaTaskCommand(taskId);
				break;
			case FAULT:
				cmd = new FailTaskCommand(taskId, currentUserId, new HashMap<String, Object>());
				break;
			case PARENT_SUSPEND:
				cmd = new SuspendTaskFromParentCommand(taskId, currentUserId);
				break;
			case PARENT_RESUME:
				cmd = new ResumeTaskFromParentCommand(taskId, currentUserId);
				break;
			case SUSPEND:
				cmd = new SuspendTaskCommand(taskId, currentUserId);
				break;
			case COMPLETE:
				cmd = new CompleteTaskCommand(taskId, currentUserId, workItem.getParameters());
				break;
			case ENABLE:
				if (task.getTaskData().getStatus() == Status.Created) {
					cmd = new ActivateTaskCommand(taskId, "Administrator");
					cmd.setGroupsIds(Arrays.asList(groupIds));
					if (currentUserId != null) {
						its.execute(cmd);
					}
				}
				if (currentUserId != null) {
					cmd = new ClaimTaskCommand(taskId, currentUserId);
				}
				break;
			default:
			}
		}
		if (cmd != null) {
			cmd.setGroupsIds(Arrays.asList(groupIds));
			its.execute(cmd);
		}
		PlanElementState state = StatusConverter.convertStatus(its.getTaskById(taskId).getTaskData().getStatus());
		if (state.isTerminalState()) {
			manager.abortWorkItem(workItemId);
		}
	}

	private String findBestUserFromGroups(InternalTaskService its, String[] groupIds) {
		String currentUserId = "Administrator";
		// TODO this is very primitive, think of a better solution, make it configurable with a strategy, perhaps using
		// VDML data
		for (String string : groupIds) {
			Iterator<OrganizationalEntity> m = its.getUserInfo().getMembersForGroup(new GroupImpl(string));
			if (m != null && m.hasNext()) {
				currentUserId = m.next().getId();
				break;
			}
		}
		return currentUserId;
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// Nothing to abort
	}

}
