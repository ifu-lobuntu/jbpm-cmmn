package org.jbpm.cmmn.task.workitems;

import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.task.additional.commands.AddPlannedTaskCommand;
import org.jbpm.cmmn.task.additional.commands.CreateTaskCommand;
import org.jbpm.services.task.impl.model.GroupImpl;
import org.jbpm.services.task.impl.model.I18NTextImpl;
import org.jbpm.services.task.impl.model.TaskDataImpl;
import org.jbpm.services.task.impl.model.UserImpl;
import org.jbpm.services.task.utils.OnErrorAction;
import org.jbpm.services.task.wih.LocalHTWorkItemHandler;
import org.jbpm.services.task.wih.util.HumanTaskHandlerHelper;
import org.jbpm.services.task.wih.util.PeopleAssignmentHelper;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.task.model.I18NText;
import org.kie.api.task.model.OrganizationalEntity;
import org.kie.api.task.model.PeopleAssignments;
import org.kie.api.task.model.Task;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.kie.internal.task.api.InternalTaskService;
import org.kie.internal.task.api.TaskModelProvider;
import org.kie.internal.task.api.model.InternalPeopleAssignments;
import org.kie.internal.task.api.model.InternalTask;
import org.kie.internal.task.api.model.InternalTaskData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CaseTaskWorkItemHandler extends LocalHTWorkItemHandler {
	private Logger logger = LoggerFactory.getLogger(CaseTaskWorkItemHandler.class);

	@Override
	protected Task createTaskBasedOnWorkItemParams(KieSession session, WorkItem workItem) {
		InternalTask task = (InternalTask) TaskModelProvider.getFactory().newTask();
		String taskName = (String) workItem.getParameter(WorkItemParameters.TASK_NODE_NAME);
		
		if (taskName != null) {
			List<I18NText> names = new ArrayList<I18NText>();
			names.add(new I18NTextImpl("en-UK", taskName));
			task.setNames(names);
			task.setName(taskName);
		}
		// this should be replaced by FormName filled by designer
		// TaskName shouldn't be trimmed if we are planning to use that for the task lists
		String formName = (String) workItem.getParameter("TaskName");
		if (formName != null) {
			task.setFormName(formName);
		}

		String comment = (String) workItem.getParameter(WorkItemParameters.COMMENT);
		if (comment == null) {
			comment = "";
		}
		List<I18NText> descriptions = new ArrayList<I18NText>();
		descriptions.add(new I18NTextImpl("en-UK", comment));
		task.setDescriptions(descriptions);
		List<I18NText> subjects = new ArrayList<I18NText>();
		subjects.add(new I18NTextImpl("en-UK", comment));
		task.setSubjects(subjects);
		task.setSubject(comment);
		String priorityString = (String) workItem.getParameter("Priority");
		int priority = 0;
		if (priorityString != null) {
			try {
				priority = new Integer(priorityString);
			} catch (NumberFormatException e) {
				// do nothing
			}
		}
		task.setPriority(priority);
		InternalTaskData taskData = new TaskDataImpl();
		taskData.setWorkItemId(workItem.getId());
		taskData.setProcessInstanceId(workItem.getProcessInstanceId());
		if (session != null && session.getProcessInstance(workItem.getProcessInstanceId()) != null) {
			taskData.setProcessId(session.getProcessInstance(workItem.getProcessInstanceId()).getProcess().getId());
			String deploymentId = ((WorkItemImpl) workItem).getDeploymentId();
			taskData.setDeploymentId(deploymentId);
		}
		if (session != null && (session instanceof KieSession)) {
			taskData.setProcessSessionId(((KieSession) session).getId());
		}
		taskData.setSkipable(!"false".equals(workItem.getParameter("Skippable")));
		Long parentId = (Long) workItem.getParameter(WorkItemParameters.PARENT_WORK_ITEM_ID);
		if (parentId != null) {
			RuntimeEngine runtime = getRuntimeManager().getRuntimeEngine(ProcessInstanceIdContext.get(workItem.getProcessInstanceId()));
			taskData.setParentId(runtime.getTaskService().getTaskByWorkItemId(parentId).getId());
		}

		String createdBy = (String) workItem.getParameter("CreatedBy");
		if (createdBy != null && createdBy.trim().length() > 0) {
			taskData.setCreatedBy(new UserImpl(createdBy));
		}
		PeopleAssignmentHelper peopleAssignmentHelper = new PeopleAssignmentHelper() {
			@Override
			protected void assignBusinessAdministrators(WorkItem workItem, PeopleAssignments peopleAssignments) {
				String businessAdministratorIds = (String) workItem.getParameter(BUSINESSADMINISTRATOR_ID);
				List<OrganizationalEntity> businessAdministrators = peopleAssignments.getBusinessAdministrators();
				if (!hasAdminAssigned(businessAdministrators)) {
					UserImpl administrator = new UserImpl("Administrator");
					businessAdministrators.add(administrator);
					GroupImpl adminGroup = new GroupImpl("Administrators");
					businessAdministrators.add(adminGroup);
				}
				processPeopleAssignments(businessAdministratorIds, businessAdministrators, false);
			}
		};
		peopleAssignmentHelper.handlePeopleAssignments(workItem, task, taskData);

		InternalPeopleAssignments peopleAssignments = (InternalPeopleAssignments) task.getPeopleAssignments();
		if (workItem.getParameter(WorkItemParameters.INITIATOR) != null) {
			peopleAssignments.setTaskInitiator(new UserImpl((String) workItem.getParameter(WorkItemParameters.INITIATOR)));
		}
		List<OrganizationalEntity> businessAdministrators = peopleAssignments.getBusinessAdministrators();

		taskData.initialize();
		task.setTaskData(taskData);
		task.setDeadlines(HumanTaskHandlerHelper.setDeadlines(workItem, businessAdministrators, session.getEnvironment()));
		return task;
	}

	@Override
	public void executeWorkItem(final WorkItem workItem, WorkItemManager manager) {

		RuntimeEngine runtime = getRuntimeManager().getRuntimeEngine(ProcessInstanceIdContext.get(workItem.getProcessInstanceId()));
		KieSession ksessionById = runtime.getKieSession();

		final Task task = createTaskBasedOnWorkItemParams(ksessionById, workItem);
		final Map<String, Object> content = workItem.getParameters();
		try {
			InternalTaskService its = (InternalTaskService) runtime.getTaskService();
			if (Boolean.TRUE.equals(workItem.getParameter(WorkItemParameters.PLANNED))) {
				// Bypass assignment/claim. Keep in created state
				String discretionaryItemId = (String) workItem.getParameter(WorkItemParameters.DISCRETIONARY_ITEM_ID);
				String planItemName = (String) workItem.getParameter(WorkItemParameters.TASK_PLAN_ITEM_NAME);
				its.execute(new AddPlannedTaskCommand(content, task, discretionaryItemId,planItemName));
			} else {
				Boolean claimImmediately = (Boolean) workItem.getParameter(WorkItemParameters.CLAIM_IMMEDIATELY);
				if (claimImmediately != null) {
					// From CMMN
					if (claimImmediately) {
						long taskId = its.addTask(task, content);
						String actor = (String) workItem.getParameter(PeopleAssignmentHelper.ACTOR_ID);
						if (actor != null) {
							runtime.getTaskService().claim(taskId, actor);
							runtime.getTaskService().start(taskId, actor);
						} else {
							throw new IllegalArgumentException("An immediate claim was requested, but no Actor was specified");
						}
					} else {
						// Enablement or AutomaticActivation will be triggered elsewhere
						its.execute(new CreateTaskCommand(task, content));
					}
				} else {
					// From BPMN
					long taskId = its.addTask(task, content);
					if (isAutoClaim(workItem, task)) {
						String swimlaneActor = (String) workItem.getParameter("SwimlaneActorId");
						runtime.getTaskService().claim(taskId, swimlaneActor);
					}
				}
			}
			logger.debug("Task created Task[" + task.getName() +"].workItemId=" + task.getTaskData().getWorkItemId());

		} catch (Exception e) {
			if (action.equals(OnErrorAction.ABORT)) {
				manager.abortWorkItem(workItem.getId());
			} else if (action.equals(OnErrorAction.RETHROW)) {
				if (e instanceof RuntimeException) {
					throw (RuntimeException) e;
				} else {
					throw new RuntimeException(e);
				}
			} else if (action.equals(OnErrorAction.LOG)) {
				StringBuilder logMsg = new StringBuilder();
				logMsg.append(new Date()).append(": Error when creating task on task server for work item id ").append(workItem.getId());
				logMsg.append(". Error reported by task server: ").append(e.getMessage());
				logger.error(logMsg.toString(), e);
			}
		}
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// Nothing
	}
}
