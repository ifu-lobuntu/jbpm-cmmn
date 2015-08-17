package org.jbpm.cmmn.instance.impl;

import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.Stage;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.instance.*;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.process.instance.ContextInstanceContainer;
import org.jbpm.workflow.core.node.StartNode;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.jbpm.workflow.instance.impl.WorkflowProcessInstanceImpl;
import org.jbpm.workflow.instance.node.EventBasedNodeInstanceInterface;
import org.jbpm.workflow.instance.node.EventNodeInstanceInterface;
import org.kie.api.runtime.process.NodeInstance;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class StageInstance extends ControllableItemInstanceImpl<Stage> implements PlanItemInstanceContainer, EventNodeInstanceInterface, EventBasedNodeInstanceInterface, ContextInstanceContainer {

    private static final long serialVersionUID = 112341234123L;
    private AtomicLong counter;

    @Override
    public void internalTrigger(NodeInstance from, String type) {
        super.internalTrigger(from, type);
        noteInstantiation();
    }

    public AtomicLong getCounter() {
        return counter;
    }

    @Override
    public void setProcessInstance(WorkflowProcessInstance processInstance) {
        super.setProcessInstance(processInstance);
        this.counter = ((WorkflowProcessInstanceImpl) processInstance).internalGetNodeInstanceCounter();
    }

    @Override
    public void start() {
        super.start();
        triggerDefaultStart();
    }

    @Override
    public void manualStart() {
        super.manualStart();
        triggerDefaultStart();
    }

    private void triggerDefaultStart() {
        StartNode defaultStart = getItem().getDefinition().getDefaultStart();
        NodeInstance nodeInstance = getNodeInstance(defaultStart);
        ((org.jbpm.workflow.instance.NodeInstance) nodeInstance).trigger(null, null);
    }

    @Override
    public Collection<PlanItemInstance<?>> getChildren() {
        Set<PlanItemInstance<?>> result = new HashSet<PlanItemInstance<?>>();
        for (NodeInstance nodeInstance : getNodeInstances()) {
            if (nodeInstance instanceof PlanItemInstance) {
                result.add((PlanItemInstance<?>) nodeInstance);
            }
        }
        return result;
    }


    /***
     * PlanningTableContainer implementation
     **/
    @Override
    public PlanItemInstanceContainer getPlanItemInstanceCreator() {
        return this;
    }


    @Override
    public NodeInstance getPlanningContextNodeInstance() {
        return this;
    }

    @Override
    public PlanningTable getPlanningTable() {
        return getItem().getDefinition().getPlanningTable();
    }

    /***
     * PlanItemInstanceContainer implementation
     ***/
    @Override
    public PlanItemContainer getPlanItemContainer() {
        return getItem().getDefinition();
    }

    @Override
    public void populateSubscriptionsActivatedByParameters(SubscriptionContext sc) {
        PlanItemInstanceContainerUtil.populateSubscriptionsActivatedByParametersOfContainedTasks(this, sc);
    }

    @Override
    public void addSubscribingCaseParameters(Set<org.jbpm.cmmn.flow.core.CaseParameter> params) {
        PlanItemInstanceContainerUtil.addSubscribingCaseParameters(params, this);
    }

    @Override
    public void addCaseFileItemOnPartsForParameters(Collection<org.jbpm.cmmn.flow.core.CaseParameter> items, Map<OnPartInstance, OnPartInstanceSubscription> onCaseFileItemParts) {
        PlanItemInstanceContainerUtil.addCaseFileItemOnPartsForParameters(items, this, onCaseFileItemParts);
    }

    @Override
    public void resumeAfterPlanning() {
        if (getPlanElementState() == PlanElementState.SUSPENDED) {
            reactivate();
        }
    }

}
