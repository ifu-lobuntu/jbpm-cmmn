package org.jbpm.cmmn.instance.impl;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.casemgmt.role.RoleInstance;
import org.jbpm.casemgmt.role.impl.RoleInstanceImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.instance.*;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.ruleflow.instance.RuleFlowProcessInstance;
import org.kie.api.runtime.process.NodeInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CaseInstanceImpl extends RuleFlowProcessInstance implements CaseInstance {
    private static Logger logger = LoggerFactory.getLogger(CaseInstanceImpl.class);
    private static final long serialVersionUID = 8715128915363796623L;
    private PlanElementState planElementState = PlanElementState.ACTIVE;
    private transient int signalCount = 0;
    private transient boolean shouldUpdateSubscriptions = false;
    private transient NodeInstance planningContextNodeInstance;

    public CaseImpl getCase() {
        return (CaseImpl) getProcess();
    }

    public void addRoleAssignment(String role, String userId) {
        getRoleInstance(role).addRoleAssignment(userId);
    }

    @Override
    public Map<String, Object> getResult() {
        Map<String, Object> result = new HashMap<String, Object>();
        for (CaseParameter cp : getCase().getOutputParameters()) {
            Object variable = ExpressionUtil.readFromBindingRefinement(cp, this, null);
            result.put(cp.getName(), variable);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public RoleInstance getRoleInstance(String role) {
        Map<String, RoleInstance> roleInstanceMap = (Map<String, RoleInstance>) getVariable("CaseRoles");
        if (roleInstanceMap == null) {
            roleInstanceMap = new HashMap<String, RoleInstance>();
            setVariable("CaseRoles", roleInstanceMap);
        }
        RoleInstance roleInstance = roleInstanceMap.get(role);
        if (roleInstance == null) {
            roleInstanceMap.put(role, roleInstance = new RoleInstanceImpl(role));
        }
        return roleInstance;
    }

    public void markSubscriptionsForUpdate() {
        this.shouldUpdateSubscriptions = true;
    }

    @Override
    public void signalEvent(String type, Object event) {
        signalCount++;
        if (event instanceof PlanItemTransition) {
            PlanItemTransition transition = (PlanItemTransition) event;
            if (transition != null) {
                if (getPlanElementState().isTerminalState() && transition == PlanItemTransition.TERMINATE) {
                    logger.info("ignore - called from task service: " + WorkItemParameters.TRANSITION);
                } else if (transition == PlanItemTransition.COMPLETE) {
                    if (canComplete()) {
                        transition.invokeOn(this);
                    } else {
                        // TODO what now?
                    }
                } else {
                    transition.invokeOn(this);
                }
            }
        } else {
            super.signalEvent(type, event);
        }
        signalCount--;
        if (shouldUpdateSubscriptions && signalCount == 0) {
            //only update subscriptions when initial signalEvent call has completed
            updateSubscriptions();
        }
    }

    public org.jbpm.workflow.instance.NodeInstance getFirstNodeInstance(final long nodeId) {
        // level logic not relevant.
        for (NodeInstance ni : this.getNodeInstances()) {
            if (ni.getNodeId() == nodeId) {
                return (org.jbpm.workflow.instance.NodeInstance) ni;
            }
        }
        return null;
    }

    public String getCaseOwner() {
        return (String) getVariable(WorkItemParameters.CASE_OWNER);
    }

    public String getInitiator() {
        return (String) getVariable(WorkItemParameters.INITIATOR);
    }

    @Override
    public void start(String trigger) {
        super.start(trigger);
        updateSubscriptions();
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    protected void updateSubscriptions() {
        SubscriptionManager subscriptionManager = (SubscriptionManager) getKnowledgeRuntime().getEnvironment()
                .get(SubscriptionManager.ENV_NAME);
        if (subscriptionManager != null) {
            CaseInstanceImpl caseInstance = this;
            SubscriptionPersistenceContext persistence = subscriptionManager.getObjectPersistence(caseInstance);
            SubscriptionContext sc = new SubscriptionContext(this, new HashSet<Object>(), new HashMap<CaseFileItem, Collection<Object>>());
            ExpressionUtil.populateSubscriptionsActivatedByParameters(sc, getCase().getInputParameters());
            populateSubscriptionsActivatedByParameters(sc);
            subscriptionManager.updateSubscriptions(caseInstance, sc.getSubscriptions(), sc.getParentSubscriptions(), persistence);
        }
        shouldUpdateSubscriptions = false;

    }

    public Set<OnPartInstanceSubscription> findOnPartInstanceSubscriptions() {
        Set<org.jbpm.cmmn.flow.core.CaseParameter> params = new HashSet<org.jbpm.cmmn.flow.core.CaseParameter>();
        params.addAll(getCase().getInputParameters());
        addSubscribingCaseParameters(params);
        Map<OnPartInstance, OnPartInstanceSubscription> onCaseFileItemParts = new HashMap<OnPartInstance, OnPartInstanceSubscription>();
        addCaseFileItemOnPartsForParameters(params, onCaseFileItemParts);
        return new HashSet<OnPartInstanceSubscription>(onCaseFileItemParts.values());

    }

    @Override
    public void setState(int state) {
        super.setState(state);
        if (state == STATE_SUSPENDED) {
            suspend();
        } else if (state == STATE_ACTIVE
                && (getPlanElementState().isSemiTerminalState(this) || getPlanElementState() == PlanElementState.SUSPENDED)) {
            reactivate();
        }
    }

       // ****PlanItemInstanceContainerLifecycle implementation*****//
    @Override
    public void addCaseFileItemOnPartsForParameters(Collection<org.jbpm.cmmn.flow.core.CaseParameter> items,
                                                    Map<OnPartInstance, OnPartInstanceSubscription> onCaseFileItemParts) {
        PlanItemInstanceContainerUtil.addCaseFileItemOnPartsForParameters(items, this, onCaseFileItemParts);
    }

    @Override
    public void addSubscribingCaseParameters(Set<org.jbpm.cmmn.flow.core.CaseParameter> params) {
        PlanItemInstanceContainerUtil.addSubscribingCaseParameters(params, this);
    }

    @Override
    public void populateSubscriptionsActivatedByParameters(SubscriptionContext sc) {
        PlanItemInstanceContainerUtil.populateSubscriptionsActivatedByParametersOfContainedTasks(this, sc);
    }

    @Override
    public ControllableItemInstance<?> findNodeForWorkItem(long id) {
        return PlanItemInstanceContainerUtil.findNodeForWorkItem(this, id);
    }

    @Override
    public PlanningTableContainerInstance findPlanningTableContainerInstance(long containerWorkItemId) {
        return PlanItemInstanceContainerUtil.findPlanElementWithPlanningTable(this, containerWorkItemId);
    }

    @Override
    public Collection<? extends PlanItemInstance<?>> getChildren() {
        return PlanItemInstanceContainerUtil.getChildren(this);
    }

    @Override
    public boolean canComplete() {
        return PlanItemInstanceContainerUtil.canComplete(this);
    }

    @Override
    public PlanItemContainer getPlanItemContainer() {
        return getCase();
    }

    @Override
    public PlanningTable getPlanningTable() {
        return getCase().getPlanningTable();
    }

    @Override
    public NodeInstance getPlanningContextNodeInstance() {
        if (this.planningContextNodeInstance == null) {
            this.planningContextNodeInstance = getFirstNodeInstance(getCase().getDefaultJoin().getId());
        }
        return planningContextNodeInstance;
    }


    @Override
    public PlanItemInstanceContainer getPlanItemInstanceCreator() {
        return this;
    }



    // ***********CaseInstanceLifecyle implementation***********//
    @Override
    public void create() {
        planElementState.create(this);
    }

    @Override
    public void fault() {
        planElementState.fault(this);
    }

    @Override
    public void close() {
        planElementState.close(this);
    }

    @Override
    public PlanElementState getPlanElementState() {
        return planElementState;
    }

    @Override
    public CaseInstance getCaseInstance() {
        return this;
    }


    @Override
    public void setPlanElementState(PlanElementState s) {
        this.planElementState = s;
    }

    @Override
    public void reactivate() {
        planElementState.reactivate(this);
    }

    @Override
    public void suspend() {
        planElementState.suspend(this);
    }

    @Override
    public void terminate() {
        planElementState.terminate(this);
    }

    @Override
    public void complete() {
        planElementState.complete(this);
    }

    @Override
    public NodeInstance createPlannedItem(String tableItemId) {
        return PlanningTableContainerInstanceUtil.createPlannedTask(this, tableItemId);
    }
    @Override
    public Collection<String> getCaseRoleNames() {
        Set<String> result = new HashSet<String>();
        for (CaseRole caseRole : this.getCase().getRoles()) {
            result.add(caseRole.getName());
        }
        return result;
    }

    @Override
    public void resumeAfterPlanning() {
        if (getPlanElementState() != PlanElementState.CLOSED && getPlanElementState() != PlanElementState.ACTIVE) {
            reactivate();
        }
    }

}
