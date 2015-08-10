package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.definition.StartTrigger;
import org.jbpm.workflow.core.Constraint;

public class TimerEventListenerImpl extends AbstractPlanItemDefinition implements org.jbpm.cmmn.flow.definition.TimerEventListener {

	private static final long serialVersionUID = 123L;
	private Constraint timerExpression;
	private StartTrigger startTrigger;

	@Override
	public Constraint getTimerExpression() {
		return timerExpression;
	}

	@Override
	public void setTimerExpression(Constraint timerExpression) {
		this.timerExpression = timerExpression;
	}

	@Override
	public void setStartTrigger(StartTrigger part) {
		this.startTrigger = part;
	}

	@Override
	public StartTrigger getStartTrigger() {
		return startTrigger;
	}

}
