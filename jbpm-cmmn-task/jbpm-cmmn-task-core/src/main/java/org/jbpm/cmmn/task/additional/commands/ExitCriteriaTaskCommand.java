package org.jbpm.cmmn.task.additional.commands;

import org.jbpm.services.task.exception.PermissionDeniedException;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.internal.task.api.model.InternalTaskData;

/**
 * This is not the same as the 'exit' transition in WS Human Task, as it is not initiated by a human. It is triggered by
 * the Process/Case Instance based on the exitCriteria becoming true;
 */
public class ExitCriteriaTaskCommand extends AbstractTaskCommand<Void> {
	private static final long serialVersionUID = -8257771889718694139L;

	public ExitCriteriaTaskCommand(long taskId) {
		super.taskId = taskId;
	}

	public Void execute() {
		Task task = getTaskById(taskId);
		InternalTaskData td = (InternalTaskData) task.getTaskData();
		if (task.getTaskData().getStatus() == Status.Exited || task.getTaskData().getStatus() == Status.Completed) {
			String errorMessage = "Tasks in the Exited or Completed status can be exited started. Task" + task.getId() + " is "
					+ task.getTaskData().getStatus();
			throw new PermissionDeniedException(errorMessage);
		}
		fireBeforeTaskExitCriteriaEvent(task);
		td.setStatus(Status.Exited);
		fireAfterTaskExitCriteriaEvent(task);
		return null;
	}

}
