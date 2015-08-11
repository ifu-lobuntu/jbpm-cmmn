package org.jbpm.cmmn.service.api.commands;

import org.jbpm.cmmn.common.PlanningTableContainerInstance;
import org.jbpm.cmmn.service.model.PlannableItem;

import java.util.Collection;

public class SubmitPlanCommand extends AbstractPlanningCommand<Void> {
	private static final long serialVersionUID = 7907971723514784829L;
	private final Collection<PlannableItem> plannedTasks;
	private boolean resume;
	private String planningTableContainerInstanceId;

	public SubmitPlanCommand(Collection<PlannableItem> plannedTasks, long processInstanceId, String planningTableContainerInstanceId, boolean resume) {
		super(processInstanceId,planningTableContainerInstanceId);
		this.plannedTasks = plannedTasks;
		this.resume = resume;
		this.planningTableContainerInstanceId=planningTableContainerInstanceId;
	}

	@Override
	public Void execute() {
		for (PlannableItem plannedTask : plannedTasks) {
			//1. For each discretionaryItem
			//1.1. If it has entryCriteria, make it available
			//1.2. If it has no entry criteria, create it
			//2. Apply user assignment
			//3. Apply due dates
			//3.1. If duration specified, calculate due dates based on preceding exitCritera
			//3.2. If due date is specified directly, set it.
			//3. Apply input parameters

		}
		if (resume) {
			PlanningTableContainerInstance p = getPlanningTableContainerInstance();
			p.resumeAfterPlanning();
		}
		return null;
	}

}