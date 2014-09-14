package org.jbpm.cmmn.instance.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.drools.core.WorkItemHandlerNotFoundException;
import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.WorkItemManager;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.PlanItemTransition;
import org.jbpm.cmmn.flow.core.PlanningTable;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.planning.TableItemImpl;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.ControllableItemInstance;
import org.jbpm.cmmn.instance.OnPartInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.cmmn.instance.SubscriptionContext;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.process.instance.ProcessInstance;
import org.jbpm.ruleflow.instance.RuleFlowProcessInstance;
import org.kie.api.runtime.process.NodeInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaseInstanceImpl extends RuleFlowProcessInstance implements CaseInstance {
	Logger logger = LoggerFactory.getLogger(CaseInstanceImpl.class);
	private static final long serialVersionUID = 8715128915363796623L;
	private PlanElementState planElementState = PlanElementState.ACTIVE;
	private long workItemId = -1;
	private transient WorkItem workItem;
	private transient int signalCount = 0;
	private transient boolean shouldUpdateSubscriptions = false;
	private transient NodeInstance planningContextNodeInstance;

	public CaseImpl getCase() {
		return (CaseImpl) getProcess();
	}

	public void addRoleAssignment(String role, String userId) {
		getRoleAssignments(role).add(userId);
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
	public Collection<String> getRoleAssignments(String role) {
		Collection<String> var = (Collection<String>) getVariable(role);
		if (var == null) {
			var = new HashSet<String>();
			setVariable(role, var);
		}
		return var;
	}

	public WorkItem createPlannedItem(long containerWorkItemId, String tableItemId) {
		PlanningTableContainerInstance ptc = findPlanningTableContainerInstance(containerWorkItemId);
		if (ptc != null) {
			return ptc.createPlannedItem(tableItemId);
		} else {
			return null;
		}
	}

	public void markSubscriptionsForUpdate() {
		this.shouldUpdateSubscriptions = true;
	}

	@Override
	public void signalEvent(String type, Object event) {
		signalCount++;
		if (type.equals("workItemUpdated") && isMyWorkItem((WorkItem) event)) {
			this.workItem = (WorkItem) event;
			PlanItemTransition transition = (PlanItemTransition) workItem.getResult(WorkItemParameters.TRANSITION);
			if (getPlanElementState().isTerminalState() && transition == PlanItemTransition.TERMINATE) {
				logger.info("ignore - called from task service: " + WorkItemParameters.TRANSITION);
			} else if (transition == PlanItemTransition.COMPLETE) {
				if (canComplete()) {
					if (isStandaloneCaseInstance() && !getCase().isAutoComplete()) {
						// This was called from the task service. Need to write
						// the output
						WorkItemImpl wi = createEmtpyWorkItemToTask();
						wi.getParameters().putAll(getResult());
						wi.setParameter(WorkItemParameters.SET_OUTPUT, true);
						executeWorkItem(wi);
					}
					transition.invokeOn(this);
				} else {
					// TODO what now?
				}
			} else {
				transition.invokeOn(this);
			}
		} else {
			super.signalEvent(type, event);
		}
		signalCount--;
		if (shouldUpdateSubscriptions && signalCount == 0) {
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

	protected boolean isMyWorkItem(WorkItem event) {
		return event.getId() == getWorkItemId() || (getWorkItem() != null && getWorkItem().getId() == (event.getId()));
	}

	protected WorkItem createWorkItem() {
		// if we are in here, it means it is a standalone case, not called from
		// a CaseTask
		WorkItemImpl workItem = new WorkItemImpl();
		workItem.setName("Human Task");
		workItem.setProcessInstanceId(getId());
		workItem.setParameters(new HashMap<String, Object>());
		workItem.setParameter(WorkItemParameters.TASK_NODE_NAME, getCase().getName());
		String initiator = getInitiator();
		String caseOwner = getCaseOwner();
		if (initiator != null) {
			workItem.setParameter(WorkItemParameters.INITIATOR, initiator);
		}
		if (caseOwner != null) {
			workItem.setParameter(WorkItemParameters.ACTOR_ID, caseOwner);
		} else if (initiator != null) {
			workItem.setParameter(WorkItemParameters.ACTOR_ID, initiator);
		} else {
			throw new IllegalStateException("A Case Instance must have either an initiator, an owner or both");
		}
		workItem.setParameter(WorkItemParameters.CLAIM_IMMEDIATELY, true);
		workItem.setParameter(WorkItemParameters.GROUP_ID, TableItemImpl.getPlannerRoles(this.getCase()));
		workItem.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, TableItemImpl.getPlannerRoles(this.getCase()));
		return workItem;
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
		maybeExecuteWorkItem();
	}

	private void maybeExecuteWorkItem() {
		if (workItemId < 0) {
			this.workItem = createWorkItem();
			executeWorkItem(workItem);
			this.workItemId = workItem.getId();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		Set<CaseParameter> params = new HashSet<CaseParameter>();
		params.addAll(getCase().getInputParameters());
		addSubscribingCaseParameters(params);
		Map<OnPartInstance, OnPartInstanceSubscription> onCaseFileItemParts = new HashMap<OnPartInstance, OnPartInstanceSubscription>();
		addCaseFileItemOnPartsForParameters(params, onCaseFileItemParts);
		return new HashSet<OnPartInstanceSubscription>(onCaseFileItemParts.values());

	}

	private WorkItemImpl createEmtpyWorkItemToTask() {
		WorkItemImpl wi = new WorkItemImpl();
		wi.setName(WorkItemParameters.UPDATE_TASK_STATUS);
		wi.setParameter(WorkItemParameters.WORK_ITEM_ID, getWorkItemId());
		return wi;
	}

	private boolean isStandaloneCaseInstance() {
		return getWorkItem().getProcessInstanceId() == getId();
	}

	public void inernalSetWorkItemId(long readLong) {
		this.workItemId = readLong;
	}

	public void setWorkItem(WorkItem w) {
		this.workItem = w;
		this.workItemId = w.getId();
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

	public ControllableItemInstance<?> ensurePlanItemCreated(long parentWorkItemId, String discretionaryItemId, WorkItem wi) {
		ControllableItemInstance<?> found = findNodeForWorkItem(wi.getId());
		if (found != null) {
			return found;
		} else {
			PlanningTableContainerInstance e = findPlanningTableContainerInstance(parentWorkItemId);
			return e.ensurePlanItemCreated(discretionaryItemId, wi);
		}
	}

	public Set<ApplicableDiscretionaryItem> getApplicableDiscretionaryItems(long wi, Set<String> roles) {
		PlanningTableContainerInstance pewt = findPlanningTableContainerInstance(wi);
		Map<String, ApplicableDiscretionaryItem> result = new HashMap<String, ApplicableDiscretionaryItem>();
		if (pewt != null) {
			pewt.addApplicableItems(result, roles);
		}
		return new HashSet<ApplicableDiscretionaryItem>(result.values());
	}

	// ****PlanItemInstanceContainerLifecycle implementation*****//
	@Override
	public void addCaseFileItemOnPartsForParameters(Collection<CaseParameter> items,
			Map<OnPartInstance, OnPartInstanceSubscription> onCaseFileItemParts) {
		PlanItemInstanceContainerUtil.addCaseFileItemOnPartsForParameters(items, this, onCaseFileItemParts);
	}

	@Override
	public void addSubscribingCaseParameters(Set<CaseParameter> params) {
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

	// ****PlanElementTableContainer implementation*****//
	public WorkItem executeWorkItem(WorkItem wi) {
		String deploymentId = (String) getKnowledgeRuntime().getEnvironment().get("deploymentId");
		wi.setDeploymentId(deploymentId);
		try {
			((WorkItemManager) getKnowledgeRuntime().getWorkItemManager())
					.internalExecuteWorkItem((org.drools.core.process.instance.WorkItem) wi);
			return wi;
		} catch (WorkItemHandlerNotFoundException wihnfe) {
			setState(ProcessInstance.STATE_ABORTED);
			throw wihnfe;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
	public ControllableItemInstance<?> ensurePlanItemCreated(String discretionaryItemId, WorkItem wi) {
		return PlanningTableContainerInstanceUtil.ensurePlanItemCreated(this, discretionaryItemId, wi);
	}

	@Override
	public PlanItemInstanceContainer getPlanItemInstanceCreator() {
		return this;
	}

	@Override
	public void addApplicableItems(Map<String, ApplicableDiscretionaryItem> result, Set<String> roles) {
		PlanningTableContainerInstanceUtil.addApplicableItems(this, result, roles);
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

	public WorkItem getWorkItem() {
		if (workItem == null && workItemId >= 0) {
			workItem = ((WorkItemManager) getKnowledgeRuntime().getWorkItemManager()).getWorkItem(workItemId);
		}
		return workItem;
	}

	@Override
	public Object getTask() {
		if (getWorkItem() != null) {
			return getWorkItem().getResult(WorkItemParameters.TASK);
		}
		return null;
	}

	@Override
	public long getWorkItemId() {
		if (workItem != null) {
			return workItem.getId();
		}
		return workItemId;
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
	public void triggerTransitionOnTask(PlanItemTransition transition) {
		if (transition == PlanItemTransition.COMPLETE && !isStandaloneCaseInstance()) {
			// Most likely called from DefaultJoinInstance with
			// autoComplete=true
			// Let the caseTaskInstance know
			getKnowledgeRuntime().signalEvent("processInstanceCompleted:" + getId(), this, getWorkItem().getProcessInstanceId());
			// We don't write the parameters here because the
			// CaseTaskPlanItemInstance may need to transform them
			// Because only the Task will be completed in the callback, not this
			// caseInstance, we complete it here:
			complete();
		} else {
			WorkItemImpl wi = createEmtpyWorkItemToTask();
			wi.setParameter(WorkItemParameters.TASK_TRANSITION, transition);
			executeWorkItem(wi);
		}
	}

	@Override
	public WorkItem createPlannedItem(String tableItemId) {
		return PlanningTableContainerInstanceUtil.createPlannedTask(this, tableItemId);
	}

	@Override
	public void makeDiscretionaryItemAvailable(String discretionaryItemId) {
		PlanningTableContainerInstanceUtil.makeDiscretionaryItemAvailable(this, discretionaryItemId);
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
	public void ensurePlanItemCreated(long workItemId, String discretionaryItemId, org.kie.api.runtime.process.WorkItem wi) {
		ensurePlanItemCreated(workItemId, discretionaryItemId, (WorkItem) wi);
	}

	@Override
	public void resumeAfterPlanning() {
		if(getPlanElementState()!=PlanElementState.CLOSED && getPlanElementState() !=PlanElementState.ACTIVE){
			reactivate();
		}
	}

}
