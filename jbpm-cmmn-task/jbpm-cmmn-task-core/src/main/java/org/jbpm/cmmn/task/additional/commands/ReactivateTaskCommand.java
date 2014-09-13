package org.jbpm.cmmn.task.additional.commands;

import java.util.List;

import org.jbpm.cmmn.task.api.impl.AbstractTaskCommand;
import org.jbpm.services.task.commands.CommandsUtil;
import org.jbpm.services.task.exception.PermissionDeniedException;
import org.kie.api.task.model.OrganizationalEntity;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.User;
import org.kie.internal.task.api.model.InternalTaskData;

public class ReactivateTaskCommand extends AbstractTaskCommand<Void> {
	private static final long serialVersionUID = -8257771889718694139L;

	public ReactivateTaskCommand(long taskId, String userId) {
		super.taskId = taskId;
		super.userId = userId;
	}

	public Void execute() {
		Task task = getTaskById(taskId);
		InternalTaskData td = (InternalTaskData) task.getTaskData();
		if (task.getTaskData().getStatus() != Status.Failed && task.getTaskData().getStatus() != Status.Error) {
			String errorMessage = "Only tasks in the Error/Failed status can be reenabled. Task" + task.getId() + " is " + task.getTaskData().getStatus();
			throw new PermissionDeniedException(errorMessage);
		}
		User user = getTaskIdentityService().getUserById(userId);
		fireBeforeTaskReactivatedEvent(task);
		boolean adminAllowed = CommandsUtil.isAllowed(user, getGroupsIds(), (List<OrganizationalEntity>) task.getPeopleAssignments()
				.getBusinessAdministrators());
		boolean ownerAllowed = (task.getTaskData().getActualOwner() != null && task.getTaskData().getActualOwner().equals(user));
		if (!adminAllowed && !ownerAllowed) {
			String errorMessage = "The user" + user + "is not allowed to Reenable the task " + task.getId();
			throw new PermissionDeniedException(errorMessage);
		}
		td.setStatus(Status.InProgress);
		fireAfterTaskReactivatedEvent(task);

		return null;
	}
}
