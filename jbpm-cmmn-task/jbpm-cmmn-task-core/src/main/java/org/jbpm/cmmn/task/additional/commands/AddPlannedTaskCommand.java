package org.jbpm.cmmn.task.additional.commands;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.cmmn.task.api.impl.AbstractTaskCommand;
import org.jbpm.cmmn.task.internal.model.InternalPlannedTask;
import org.jbpm.cmmn.task.model.PlannedTask;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.task.api.model.InternalTaskData;

public class AddPlannedTaskCommand extends AbstractTaskCommand<PlannedTask> {
	private static final long serialVersionUID = 2919984132940815456L;
	private Map<String, Object> inputParameters;
	private Task task;
	private String discretionaryItemId;

	public AddPlannedTaskCommand(Map<String, Object> inputParameters, Task task, String discretionaryItemId) {
		super();
		this.inputParameters = inputParameters;
		this.task = task;
		this.discretionaryItemId = discretionaryItemId;
	}

	@Override
	public PlannedTask execute() {
		((InternalTaskData) task.getTaskData()).setStatus(Status.Created);
		taskId = getTaskInstanceService().addTask(task, (Map<String, Object>) null);
		task = getTaskById(taskId);
		((InternalTaskData) task.getTaskData()).setDocumentContentId(ensureContentPresent(task, -1, inputParameters, "Content"));
		((InternalTaskData) task.getTaskData()).setOutputContentId(ensureContentPresent(task, -1, new HashMap<String, Object>(), "Output"));
		InternalPlannedTask pt = new PlannedTaskImpl(task);
		pt.setDiscretionaryItemId(discretionaryItemId);
		persist(pt);
		return pt;
	}
}