package org.jbpm.cmmn.flow.planitem;


import org.jbpm.cmmn.flow.common.PlanItemTransition;

public interface PlanItemOnPart extends OnPart{
    @Override
    PlanItemTransition getStandardEvent();
}

