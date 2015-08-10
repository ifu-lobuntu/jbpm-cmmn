package org.jbpm.cmmn.task.additional.commands;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.task.api.model.InternalTask;
import org.kie.internal.task.api.model.InternalTaskData;

import java.util.HashMap;
import java.util.Map;

public class AddPlannedTaskCommand extends AbstractTaskCommand<Task> {
	private static final long serialVersionUID = 2919984132940815456L;
	private Map<String, Object> inputParameters;
	private Task task;
	private String discretionaryItemId;
	private String planItemName;

	public AddPlannedTaskCommand(Map<String, Object> inputParameters, Task task, String discretionaryItemId, String planItemName) {
		super();
		this.inputParameters = inputParameters;
		this.task = task;
		this.discretionaryItemId = discretionaryItemId;
		this.planItemName=planItemName;
	}

	@Override
	public Task execute() {
		((InternalTaskData) task.getTaskData()).setStatus(Status.Created);
		taskId = getTaskInstanceService().addTask(task, (Map<String, Object>) null);
		task = getTaskById(taskId);
		inputParameters.put(WorkItemParameters.DISCRETIONARY_ITEM_ID, discretionaryItemId);
		inputParameters.put(WorkItemParameters.TASK_PLAN_ITEM_NAME,planItemName);
		((InternalTaskData) task.getTaskData()).setDocumentContentId(ensureContentIdPresent(task, -1, inputParameters, "Content"));
		((InternalTaskData) task.getTaskData()).setOutputContentId(ensureContentIdPresent(task, -1, new HashMap<String, Object>(), "Output"));
		InternalTask pt = (InternalTask) task;

		persist(pt);
		return pt;
	}
}