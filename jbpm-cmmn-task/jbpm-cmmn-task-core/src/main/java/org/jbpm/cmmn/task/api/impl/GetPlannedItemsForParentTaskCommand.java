package org.jbpm.cmmn.task.api.impl;

import java.util.Collection;
import java.util.List;

import org.jbpm.cmmn.task.model.PlannableTaskSummary;
import org.jbpm.services.task.utils.ClassUtil;

public class GetPlannedItemsForParentTaskCommand extends AbstractPlanningCommand<Collection<PlannableTaskSummary>> {
	private final long parentTaskId;
	private static final long serialVersionUID = -8445370954335088878L;

	public GetPlannedItemsForParentTaskCommand(long parentTaskId) {
		super();
		this.parentTaskId = parentTaskId;
	}

	@Override
	public Collection<PlannableTaskSummary> execute() {
		return (List<PlannableTaskSummary>) pm.queryWithParametersInTransaction("PlannableGetSubTasksByParentTaskId",
				pm.addParametersToMap("parentId", parentTaskId), ClassUtil.<List<PlannableTaskSummary>> castClass(List.class));
	}
}