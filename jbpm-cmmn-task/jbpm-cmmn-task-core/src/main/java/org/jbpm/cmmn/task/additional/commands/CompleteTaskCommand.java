package org.jbpm.cmmn.task.additional.commands;

import java.util.Map;

import org.jbpm.services.task.exception.PermissionDeniedException;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.User;
import org.kie.internal.task.api.model.InternalTaskData;

/**
 * 
 * Unlike the default implementation in jBPM, this one uses the Object strategies in the environment
 * 
 */
public class CompleteTaskCommand extends SetTaskOutputCommand {

	private static final long serialVersionUID = -1817334359933358605L;

	public CompleteTaskCommand(long taskId, String userId, Map<String, Object> data) {
		super(taskId, data);
		this.taskId = taskId;
		this.userId = userId;
	}

	public Long execute() {
		Task task = getTaskQueryService().getTaskInstanceById(taskId);
		if (task == null) {
			throw new IllegalStateException("There is no Task with the provided Id = " + taskId);
		}
		User user = getTaskIdentityService().getUserById(userId);
		fireBeforeTaskCompletedEvent(task);
		boolean operationAllowed = (task.getTaskData().getActualOwner() != null && task.getTaskData().getActualOwner().equals(user));
		if (!operationAllowed) {
			String errorMessage = "The user" + user + "is not allowed to Complete the task " + task.getId();
			throw new PermissionDeniedException(errorMessage);
		}
		if (task.getTaskData().getStatus().equals(Status.InProgress)) {
			// CHeck for potential Owner allowed (decorator?)
			((InternalTaskData) task.getTaskData()).setStatus(Status.Completed);
		}
		super.execute();

		fireAfterTaskCompletedEvent(task);

		return task.getId();
	}
}
