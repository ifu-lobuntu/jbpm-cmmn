package org.jbpm.cmmn.task.additional.commands;

import org.kie.api.task.model.Task;
import org.kie.internal.task.api.model.InternalTaskData;

import java.util.Map;

public class SetTaskInputCommand extends AbstractTaskCommand<Long> {

	private static final long serialVersionUID = 5765007237796573932L;
	Map<String, Object> inputAsMap;

	public SetTaskInputCommand(long taskId, Map<String, Object> inputAsMap) {
		super();
		this.taskId = taskId;
		this.inputAsMap = inputAsMap;
	}

	public Long execute() {
		Task task = getTaskById(taskId);
		InternalTaskData itd = (InternalTaskData) task.getTaskData();
		itd.setDocumentContentId(ensureContentIdPresent(task, itd.getOutputContentId(), inputAsMap, "Input"));
		return task.getId();
	}
}
