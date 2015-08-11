package org.jbpm.cmmn.flow.definition;

import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.node.EventNodeInterface;


public interface TimerEventListener extends PlanItemDefinition,EventNodeInterface {
    Constraint getTimerExpression();

    void setTimerExpression(Constraint timerExpression);

    void setStartTrigger(StartTrigger part);

    StartTrigger getStartTrigger();
}
