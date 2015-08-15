package org.jbpm.cmmn.service.model;


import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.PlanElementState;

import java.io.Serializable;

public class PlannableItem implements Serializable{
    private String name;
    private long nodeInstanceId;
    private PlanElementState state;
    private PlanItemTransition[] supportedTransitions;
    public PlannableItem(String name, long nodeInstanceId, PlanElementState state, PlanItemTransition[] supportedTransitions) {
        this.name = name;
        this.nodeInstanceId = nodeInstanceId;
        this.state = state;
        this.supportedTransitions=supportedTransitions;
    }

    public PlannableItem() {
    }

    public PlanItemTransition[] getSupportedTransitions() {
        return supportedTransitions;
    }

    public String getName() {
        return name;
    }

    public long getNodeInstanceId() {
        return nodeInstanceId;
    }

    public PlanElementState getState() {
        return state;
    }
}
