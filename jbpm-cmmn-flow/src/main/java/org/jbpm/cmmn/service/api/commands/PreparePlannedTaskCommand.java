package org.jbpm.cmmn.service.api.commands;

import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;
import org.jbpm.cmmn.service.model.PlannedItem;

public class PreparePlannedTaskCommand extends AbstractPlanningCommand<PlannedItem> {
	private final String discretionaryItemId;

	private static final long serialVersionUID = -8445378L;

	public PreparePlannedTaskCommand(long processId, Long planningTableContainerInstanceId, String discretionaryItemId) {
		super(processId,planningTableContainerInstanceId);
		this.discretionaryItemId = discretionaryItemId;
	}

	@Override
	public PlannedItem execute() {
		return  createPlannableItem(PlanningTableContainerInstanceUtil.createPlannedTask(getPlanningTableContainerInstance(), discretionaryItemId));
	}
}