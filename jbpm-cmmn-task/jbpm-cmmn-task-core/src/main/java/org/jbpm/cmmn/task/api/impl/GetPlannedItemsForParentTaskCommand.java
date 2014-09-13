package org.jbpm.cmmn.task.api.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.jbpm.cmmn.task.model.PlannedTaskSummary;
import org.kie.api.task.model.TaskSummary;

public class GetPlannedItemsForParentTaskCommand extends AbstractPlanningCommand<Collection<PlannedTaskSummary>> {
	private final long parentTaskId;
	private final boolean createMissing;
	private static final long serialVersionUID = -8445370954335088878L;

	public GetPlannedItemsForParentTaskCommand(long parentTaskId, boolean createMissing) {
		super();
		this.parentTaskId = parentTaskId;
		this.createMissing = createMissing;
	}

	@Override
	public Collection<PlannedTaskSummary> execute() {
		Collection<PlannedTaskSummary> result = new HashSet<PlannedTaskSummary>();
		List<TaskSummary> sts = getTaskQueryService().getSubTasksByParent(parentTaskId);
		for (TaskSummary taskSummary : sts) {
			PlannedTaskImpl pt = find(PlannedTaskImpl.class, taskSummary.getId());
			if (pt == null) {
				pt = new PlannedTaskImpl(getTaskById(taskSummary.getId()));
				if (createMissing) {
					persist(pt);
				}
			}
			result.add(new PlannedTaskSummaryImpl(pt));
		}
		return result;
	}
}