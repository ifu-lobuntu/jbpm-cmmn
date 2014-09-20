package org.jbpm.cmmn.task.additional.commands;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.cmmn.task.api.impl.AbstractTaskCommand;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.task.api.model.InternalTaskData;

public class CreateTaskCommand extends AbstractTaskCommand<Long> {

	private static final long serialVersionUID = 5765007237796573932L;
	private Task task;
	private Map<String, Object> inputParameters;

	public CreateTaskCommand(Task task, Map<String, Object> inputParmaeters) {
		super();
		this.task = task;
		this.inputParameters = inputParmaeters;
	}

	public Long execute() {
		fireBeforeTaskAddedEvent(task);
		((InternalTaskData) task.getTaskData()).setStatus(Status.Created);
		((InternalTaskData) task.getTaskData()).setDocumentContentId(ensureContentIdPresent(task, -1, inputParameters, "Content"));
		((InternalTaskData) task.getTaskData()).setOutputContentId(ensureContentIdPresent(task, -1, new HashMap<String, Object>(), "Output"));
		persist(task);
		fireAfterTaskAddedEvent(task);
		return (Long) task.getId();
	}
}
