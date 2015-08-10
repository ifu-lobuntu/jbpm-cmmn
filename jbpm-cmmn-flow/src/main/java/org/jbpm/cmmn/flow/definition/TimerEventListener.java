package org.jbpm.cmmn.flow.definition;

import org.jbpm.workflow.core.Constraint;


public interface TimerEventListener extends PlanItemDefinition {
    Constraint getTimerExpression();

    void setTimerExpression(Constraint timerExpression);

    void setStartTrigger(StartTrigger part);

    StartTrigger getStartTrigger();
}
