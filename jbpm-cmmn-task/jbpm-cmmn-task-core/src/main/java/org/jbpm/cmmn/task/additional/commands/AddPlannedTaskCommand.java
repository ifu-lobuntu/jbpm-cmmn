package org.jbpm.cmmn.task.additional.commands;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.cmmn.task.api.impl.AbstractTaskCommand;
import org.jbpm.cmmn.task.internal.model.InternalPlannableTask;
import org.jbpm.cmmn.task.model.PlannableTask;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.task.api.model.InternalTaskData;

public class AddPlannedTaskCommand extends AbstractTaskCommand<PlannableTask> {
	private static final long serialVersionUID = 2919984132940815456L;
	private Map<String, Object> inputParameters;
	private Task task;
	private String discretionaryItemId;
	private String planItemName;

	public AddPlannedTaskCommand(Map<String, Object> inputParameters, InternalPlannableTask task, String discretionaryItemId, String planItemName) {
		super();
		this.inputParameters = inputParameters;
		this.task = task;
		this.discretionaryItemId = discretionaryItemId;
		this.planItemName=planItemName;
	}

	@Override
	public PlannableTask execute() {
		((InternalTaskData) task.getTaskData()).setStatus(Status.Created);
		taskId = getTaskInstanceService().addTask(task, (Map<String, Object>) null);
		task = getTaskById(taskId);
		((InternalTaskData) task.getTaskData()).setDocumentContentId(ensureContentPresent(task, -1, inputParameters, "Content"));
		((InternalTaskData) task.getTaskData()).setOutputContentId(ensureContentPresent(task, -1, new HashMap<String, Object>(), "Output"));
		InternalPlannableTask pt = (InternalPlannableTask) task;
		pt.setDiscretionaryItemId(discretionaryItemId);
		pt.setPlanItemName(planItemName);
		persist(pt);
		return pt;
	}
}