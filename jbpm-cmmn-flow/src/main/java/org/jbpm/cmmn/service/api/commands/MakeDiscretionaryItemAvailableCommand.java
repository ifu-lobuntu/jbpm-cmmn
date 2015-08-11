package org.jbpm.cmmn.service.api.commands;

import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;

public class MakeDiscretionaryItemAvailableCommand extends AbstractPlanningCommand<Void> {
	private final String discretionaryItemId;
	private static final long serialVersionUID = -8445378L;

	public MakeDiscretionaryItemAvailableCommand(long processInstanceId, String planningTableContainerInstanceId,  String discretionaryItemId) {
		super(processInstanceId,planningTableContainerInstanceId);
		this.discretionaryItemId = discretionaryItemId;
	}

	@Override
	public Void execute() {
		PlanningTableContainerInstanceUtil.makeDiscretionaryItemAvailable(getPlanningTableContainerInstance(), discretionaryItemId);
		return null;
	}
}