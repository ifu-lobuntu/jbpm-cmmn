package org.jbpm.cmmn.task.api.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.common.CaseInstance;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.task.model.TaskData;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;

public class GetApplicableDiscretionaryItemsCommand extends AbstractTaskCommand<Collection<ApplicableDiscretionaryItem>> {
	private final long parentTaskId;
	private RuntimeManager runtimeManager;
	private boolean suspend;
	private static final long serialVersionUID = -8445370954335088878L;

	public GetApplicableDiscretionaryItemsCommand(RuntimeManager rm, long parentTaskId, String user, boolean suspend) {
		this.parentTaskId = parentTaskId;
		this.userId = user;
		this.runtimeManager = rm;
		this.suspend = suspend;
	}

	@Override
	public Collection<ApplicableDiscretionaryItem> execute() {
		TaskData td = getTaskById(parentTaskId).getTaskData();
		RuntimeEngine runtime = runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(td.getProcessInstanceId()));
		CaseInstance ci = (CaseInstance) runtime.getKieSession().getProcessInstance(td.getProcessInstanceId());
		if (suspend) {
			taskContext.set("local:groups", taskContext.getUserGroupCallback().getGroupsForUser(getUserId(), null, null));
			getTaskInstanceService().suspend(parentTaskId, userId);
		}
		Collection<String> roles = ci.getCaseRoleNames();
		Set<String> usersRoles = new HashSet<String>();
		for (String role : roles) {
			Collection<String> roleAssignments = ci.getRoleAssignments(role);
			if (roleAssignments.contains(userId)) {
				usersRoles.add(role);
			}
		}
		// TODO optionally lookup from some RoleService
		return ci.getApplicableDiscretionaryItems(td.getWorkItemId(), usersRoles);
	}
}