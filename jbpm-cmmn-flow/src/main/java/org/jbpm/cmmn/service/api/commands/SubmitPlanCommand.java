package org.jbpm.cmmn.service.api.commands;

import java.util.Collection;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.WorkItemManager;
import org.drools.persistence.PersistenceContext;
import org.drools.persistence.PersistenceContextManager;
import org.drools.persistence.info.WorkItemInfo;
import org.jbpm.cmmn.common.CaseInstance;
import org.jbpm.cmmn.common.PlanningTableContainerInstance;
import org.jbpm.cmmn.service.api.commands.AbstractPlanningCommand;
import org.jbpm.cmmn.service.model.PlannableItem;
import org.jbpm.cmmn.task.model.PlannableItem;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.EnvironmentName;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.kie.internal.task.api.model.InternalTaskData;

public class SubmitPlanCommand extends AbstractPlanningCommand<Void> {
	private static final long serialVersionUID = 7907971723514784829L;
	private final Collection<PlannableItem> plannedTasks;
	private RuntimeManager runtimeManager;
	private boolean resume;

	public SubmitPlanCommand(RuntimeManager runtimeManager, Collection<PlannableItem> plannedTasks, long processId, String planningTableContainerInstanceId, boolean resume) {
		super(processId,planningTableContainerInstanceId);
		this.plannedTasks = plannedTasks;
		this.runtimeManager = runtimeManager;
		this.resume = resume;
	}

	@Override
	public Void execute() {
		Task parentTask = getTaskById(parentTaskId);
		long workItemId = parentTask.getTaskData().getWorkItemId();
		RuntimeEngine runtime = runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(parentTask.getTaskData().getProcessInstanceId()));
		CaseInstance ci = (CaseInstance) runtime.getKieSession().getProcessInstance(parentTask.getTaskData().getProcessInstanceId());
		for (PlannableItem plannedTask : plannedTasks) {
			Task oldTask = getTaskById(plannedTask.getId());
			try {
				merge(plannedTask);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addContent(plannedTask, plannedTask.getParameterOverrides());
			Task currentTask = oldTask;
			InternalTaskData td = (InternalTaskData) currentTask.getTaskData();
			td.setActualOwner(plannedTask.getTaskData().getActualOwner());
			if (!currentTask.getPeopleAssignments().getPotentialOwners().contains(td.getActualOwner())) {
				currentTask.getPeopleAssignments().getPotentialOwners().add(td.getActualOwner());
			}
			WorkItemManager wim = (WorkItemManager) runtime.getKieSession().getWorkItemManager();
			WorkItem wi = wim.getWorkItem(plannedTask.getTaskData().getWorkItemId());
			Environment env = runtime.getKieSession().getEnvironment();
			PersistenceContext pc = ((PersistenceContextManager) env.get(EnvironmentName.PERSISTENCE_CONTEXT_MANAGER)).getCommandScopedPersistenceContext();
			WorkItemInfo wii = pc.findWorkItemInfo(wi.getId());
			InternalKnowledgeBase irb =  ((InternalKnowledgeBase) runtime.getKieSession().getKieBase());
			wii.getWorkItem(env, irb).getParameters().putAll(plannedTask.getParameterOverrides());
			wii.setId(wi.getId());
			pc.merge(wii);
			ci.ensurePlanItemCreated(workItemId, plannedTask.getDiscretionaryItemId(), wi);
			if (td.getStatus() == Status.Created) {
				// // td.setStatus(Status.Ready);
			}
		}
		if (resume) {
			PlanningTableContainerInstance p = ci.findPlanningTableContainerInstance(workItemId);
			p.resumeAfterPlanning();

		}
		return null;
	}

}