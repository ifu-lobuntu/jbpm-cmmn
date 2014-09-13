package org.jbpm.cmmn.task.api.impl;

import java.util.Collection;

import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.task.api.PlanningService;
import org.jbpm.cmmn.task.model.PlannedTask;
import org.jbpm.cmmn.task.model.PlannedTaskSummary;
import org.jbpm.cmmn.task.model.PlanningTableInstance;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.task.api.InternalTaskService;

public class PlanningServiceImpl implements PlanningService {
	private InternalTaskService taskService;
	private RuntimeManager runtimeManager;

	public RuntimeManager getRuntimeManager() {
		return runtimeManager;
	}

	@Override
	public void setRuntimeManager(RuntimeManager runtimeManager) {
		this.runtimeManager = runtimeManager;
	}

	public void setTaskService(InternalTaskService taskService) {
		this.taskService = taskService;
	}


	@Override
	public void submitPlan(final long parentTaskId, final Collection<PlannedTask> plannedTasks, boolean resume) {
		taskService.execute(new SubmitPlanCommand(runtimeManager, plannedTasks, parentTaskId, resume));
	}
	@Override
	public PlanningTableInstance startPlanning(final long parentTaskId, String user, boolean suspend) {
		PlanningTableInstance result = new PlanningTableInstance(getPlannedItemsForParentTask(parentTaskId, true), getApplicableDiscretionaryItems(
				parentTaskId, user, suspend));
		return result;
	}

	private Collection<ApplicableDiscretionaryItem> getApplicableDiscretionaryItems(final long parentTaskId, final String user, boolean suspend) {
		return taskService.execute(new GetApplicableDiscretionaryItemsCommand(runtimeManager, parentTaskId, user, suspend));

	}

	private Collection<PlannedTaskSummary> getPlannedItemsForParentTask(final long parentTaskId, final boolean createMissing) {
		return taskService.execute(new GetPlannedItemsForParentTaskCommand(parentTaskId, createMissing));
	}


	@Override
	public PlannedTask preparePlannedTask(final long parentTaskId, final String discretionaryItemId) {
		return taskService.execute(new PreparePlannedTaskCommand(runtimeManager, discretionaryItemId, parentTaskId));
	}


	@Override
	public void makeDiscretionaryItemAvailable(final long parentTaskId, final String discretionaryItemId) {
		taskService.execute(new MakeDiscretionaryItemAvailableCommand(runtimeManager, discretionaryItemId, parentTaskId));
	}

	protected long getWorkItemId(long parentTaskId) {
		return taskService.getTaskById(parentTaskId).getTaskData().getWorkItemId();
	}

	@Override
	public PlannedTask getPlannedTaskById(final long id) {
		return taskService.execute(new AbstractPlanningCommand<PlannedTask>() {

			private static final long serialVersionUID = -6636279175990254543L;

			@Override
			public PlannedTask execute() {
				return find(PlannedTaskImpl.class, id);
			}
		});
	}
}
