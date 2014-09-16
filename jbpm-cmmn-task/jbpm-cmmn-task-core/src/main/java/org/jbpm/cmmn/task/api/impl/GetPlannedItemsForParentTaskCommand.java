package org.jbpm.cmmn.task.api.impl;

import java.util.Collection;
import java.util.List;

import org.jbpm.cmmn.task.model.PlannableTask;
import org.jbpm.cmmn.task.model.PlannableTaskSummary;
import org.jbpm.services.task.utils.ClassUtil;
import org.kie.api.task.model.PeopleAssignments;

public class GetPlannedItemsForParentTaskCommand extends AbstractPlanningCommand<Collection<PlannableTask>> {
	private final long parentTaskId;
	private static final long serialVersionUID = -8445370954335088878L;

	public GetPlannedItemsForParentTaskCommand(long parentTaskId) {
		super();
		this.parentTaskId = parentTaskId;
	}

	@Override
	public Collection<PlannableTask> execute() {
		List<PlannableTask> result = (List<PlannableTask>) pm.queryWithParametersInTransaction("PlannableGetSubTasksByParentTaskId",
				pm.addParametersToMap("parentId", parentTaskId), ClassUtil.<List<PlannableTask>> castClass(List.class));
		for (PlannableTask p : result) {
			PeopleAssignments pa = p.getPeopleAssignments();
			pa.getBusinessAdministrators().size();
			pa.getPotentialOwners().size();
			if(pa.getTaskInitiator()!=null){
				pa.getTaskInitiator().getId();
			}
		}
		return result;
	}
}