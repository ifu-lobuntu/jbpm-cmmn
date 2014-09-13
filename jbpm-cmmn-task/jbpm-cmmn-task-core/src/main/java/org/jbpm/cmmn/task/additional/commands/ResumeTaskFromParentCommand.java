package org.jbpm.cmmn.task.additional.commands;

import org.jbpm.cmmn.task.api.impl.AbstractTaskCommand;
import org.jbpm.services.task.exception.PermissionDeniedException;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.task.api.model.InternalTaskData;

public class ResumeTaskFromParentCommand extends AbstractTaskCommand<Void> {
	private static final long serialVersionUID = -8257771889718694139L;

	public ResumeTaskFromParentCommand(long taskId, String user) {
		super.taskId = taskId;
		this.userId = user;
	}

	public Void execute() {
		Task task = getTaskById(taskId);
		InternalTaskData td = (InternalTaskData) task.getTaskData();
		if (task.getTaskData().getStatus() != Status.Suspended) {
			String errorMessage = "Only tasks in the Suspeneded status can be suspended from parent. Task" + task.getId() + " is "
					+ task.getTaskData().getStatus();
			throw new PermissionDeniedException(errorMessage);
		}
		fireBeforeTaskResumedFromParentEvent(task);
		td.setStatus(td.getPreviousStatus());
		fireAfterTaskResumedFromParentEvent(task);
		return null;
	}
}
