package org.jbpm.cmmn.task.additional.commands;

import java.util.Map;

import org.jbpm.cmmn.task.api.impl.AbstractTaskCommand;
import org.jbpm.services.task.exception.PermissionDeniedException;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.User;
import org.kie.internal.task.api.TaskModelProvider;
import org.kie.internal.task.api.model.InternalOrganizationalEntity;
import org.kie.internal.task.api.model.InternalTaskData;

/**
 * This is not the same as the 'claim' transition, as it is not initiated by a
 * human. It is triggered by the Process/Case Instance based on the absence or
 * negative result of the ManualActivationRule
 */
public class AutomaticallyStartTaskCommand extends AbstractTaskCommand<Void> {
	private static final long serialVersionUID = -8257771889718694139L;
	private Map<String, Object> updatedParameters;

	public AutomaticallyStartTaskCommand(long taskId, String user, Map<String, Object> map) {
		super();
		super.taskId = taskId;
		this.updatedParameters = map;
		this.userId = user;
	}

	public Void execute() {
		Task task = getTaskById(taskId);
		InternalTaskData td = (InternalTaskData) task.getTaskData();
		if (task.getTaskData().getStatus() != Status.Created && task.getTaskData().getStatus() != Status.Ready
				&& task.getTaskData().getStatus() != Status.Reserved) {
			String errorMessage = "Only tasks in the Created/Ready or Reserved status can be auomatically started. Task" + task.getId()
					+ " is " + task.getTaskData().getStatus();
			throw new PermissionDeniedException(errorMessage);
		}
		User user = TaskModelProvider.getTaskModelProviderService().getTaskModelFactory().newUser();
		((InternalOrganizationalEntity) user).setId(userId);
		fireBeforeTaskStartedAutomaticallyEvent(task);
		addContent(task.getId(), updatedParameters);
		td.setStatus(Status.InProgress);
		td.setActualOwner(user);
		fireAfterTaskStartedAutomaticallyEvent(task);

		return null;
	}

}
