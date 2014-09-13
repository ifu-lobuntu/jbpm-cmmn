package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.core.PlanItemTransition;

public class IllegalPlanItemStateException extends IllegalStateException {

	private static final long serialVersionUID = 1222L;
	PlanElementState state;
	PlanItemTransition transition;

	public IllegalPlanItemStateException(PlanElementState state, PlanItemTransition transition) {
		super("State " + state.name() + " does not support transition " + transition.name());
		this.state = state;
		this.transition = transition;
	}
}
