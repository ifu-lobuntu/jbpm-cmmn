package org.jbpm.cmmn.task.additional.commands;

import org.jbpm.services.task.exception.PermissionDeniedException;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.task.api.model.InternalTaskData;

public class SuspendTaskFromParentCommand extends AbstractTaskCommand<Void> {
	private static final long serialVersionUID = -8257771889718694139L;

	public SuspendTaskFromParentCommand(long taskId, String user) {
		super.taskId = taskId;
		this.userId = user;
	}

	@Override
	public Void execute() {
		Task task = getTaskById(taskId);
		InternalTaskData td = (InternalTaskData) task.getTaskData();
		if (!(task.getTaskData().getStatus() == Status.Ready || task.getTaskData().getStatus() == Status.Reserved || task.getTaskData().getStatus() == Status.InProgress)) {
			String errorMessage = "Only tasks in the Ready, Reserved or InProgress status can be suspended from parent. Task" + task.getId() + " is "
					+ task.getTaskData().getStatus();
			throw new PermissionDeniedException(errorMessage);
		}
		fireBeforeTaskSuspendedFromParentEvent(task);
		td.setStatus(Status.Suspended);
		fireAfterTaskSuspendedFromParentEvent(task);
		return null;
	}

}
