package org.jbpm.cmmn.instance.impl;

import org.jbpm.casemgmt.role.RoleInstance;
import org.jbpm.casemgmt.role.impl.RoleInstanceImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.instance.impl.util.SubscriptionUtil;
import org.jbpm.cmmn.instance.subscription.DurableCaseFileItemSubscription;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
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
        super.signalEvent(type, event);
        signalCount--;
        if (shouldUpdateSubscriptions && signalCount == 0) {
            //only update subscriptions when initial, outermost signalEvent call has completed
            //sometimes a signalEvent can result in this method being called from internal nodes
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
            Set<DurableCaseFileItemSubscription> durable = SubscriptionUtil.buildCurrentDurableSubscriptionSet(this,subscriptionManager);
            subscriptionManager.setSubscriptions(this, durable);
        }
        shouldUpdateSubscriptions = false;

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

    @Override
    public Collection<? extends PlanItemInstance<?>> getChildren() {
        return PlanItemInstanceContainerUtil.getChildren(this);
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
