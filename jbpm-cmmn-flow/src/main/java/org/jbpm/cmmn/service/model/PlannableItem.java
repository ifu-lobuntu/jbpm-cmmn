package org.jbpm.cmmn.service.model;


import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.PlanElementState;

import java.io.Serializable;

public class PlannableItem implements Serializable{
    private String name;
    private String uniqueId;
    private PlanElementState state;
    private PlanItemTransition[] supportedTransitions;
    public PlannableItem(String name, String uniqueId, PlanElementState state, PlanItemTransition[] supportedTransitions) {
        this.name = name;
        this.uniqueId = uniqueId;
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

    public String getUniqueId() {
        return uniqueId;
    }

    public PlanElementState getState() {
        return state;
    }
}
