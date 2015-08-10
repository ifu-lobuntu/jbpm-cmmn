package org.jbpm.cmmn.flow.definition;


import org.jbpm.cmmn.flow.common.PlanItemTransition;

public interface PlanItemStartTrigger extends StartTrigger{
    @Override
    PlanItemTransition getStandardEvent();
}

