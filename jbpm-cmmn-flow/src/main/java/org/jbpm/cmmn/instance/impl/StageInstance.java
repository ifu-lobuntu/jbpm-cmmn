package org.jbpm.cmmn.instance.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.PlanningTable;
import org.jbpm.cmmn.flow.core.TaskItemWithDefinition;
import org.jbpm.cmmn.flow.core.impl.Stage;
import org.jbpm.cmmn.instance.ControllableItemInstance;
import org.jbpm.cmmn.instance.OnPartInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.cmmn.instance.SubscriptionContext;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.process.instance.ContextInstanceContainer;
import org.jbpm.workflow.core.node.StartNode;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.jbpm.workflow.instance.node.EventBasedNodeInstanceInterface;
import org.jbpm.workflow.instance.node.EventNodeInstanceInterface;
import org.kie.api.runtime.process.NodeInstance;

public class StageInstance extends ControllableItemInstanceImpl<Stage, TaskItemWithDefinition<Stage>> implements PlanItemInstanceContainer,
		NodeInstanceContainer, EventNodeInstanceInterface, EventBasedNodeInstanceInterface, ContextInstanceContainer {

	private static final long serialVersionUID = 112341234123L;

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

	@Override
	protected String getIdealRoles() {
		String bas = getBusinessAdministrators();
		if (bas.equals("Administrators")) {
			return null;
		}
		return bas;
	}

	/*** PlanningTableContainer implementation **/
	@Override
	public PlanItemInstanceContainer getPlanItemInstanceCreator() {
		return this;
	}

	@Override
	public ControllableItemInstance<?> ensurePlanItemCreated(String discretionaryItemId, WorkItem wi) {
		return PlanningTableContainerInstanceUtil.ensurePlanItemCreated(this, discretionaryItemId, wi);
	}

	@Override
	public void addApplicableItems(Map<String, ApplicableDiscretionaryItem> result, Set<String> usersRoles) {
		PlanningTableContainerInstanceUtil.addApplicableItems(this, result, usersRoles);
	}

	@Override
	public NodeInstance getPlanningContextNodeInstance() {
		return this;
	}

	@Override
	public WorkItem createPlannedItem(String tableItemId) {
		return PlanningTableContainerInstanceUtil.createPlannedTask(this, tableItemId);
	}

	@Override
	public PlanningTable getPlanningTable() {
		return getItem().getDefinition().getPlanningTable();
	}

	/*** PlanItemInstanceContainer implementation ***/
	@Override
	public PlanItemContainer getPlanItemContainer() {
		return getItem().getDefinition();
	}

	@Override
	public void populateSubscriptionsActivatedByParameters(SubscriptionContext sc) {
		PlanItemInstanceContainerUtil.populateSubscriptionsActivatedByParametersOfContainedTasks(this, sc);
	}

	@Override
	public boolean canComplete() {
		return PlanItemInstanceContainerUtil.canComplete(this);
	}

	@Override
	public void addSubscribingCaseParameters(Set<CaseParameter> params) {
		PlanItemInstanceContainerUtil.addSubscribingCaseParameters(params, this);
	}

	@Override
	public void addCaseFileItemOnPartsForParameters(Collection<CaseParameter> items, Map<OnPartInstance, OnPartInstanceSubscription> onCaseFileItemParts) {
		PlanItemInstanceContainerUtil.addCaseFileItemOnPartsForParameters(items, this, onCaseFileItemParts);
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
	public void makeDiscretionaryItemAvailable(String discretionaryItemId) {
		PlanningTableContainerInstanceUtil.makeDiscretionaryItemAvailable(this, discretionaryItemId);
	}

	@Override
	public void resumeAfterPlanning() {
		if(getPlanElementState()==PlanElementState.SUSPENDED){
			reactivate();
		}
	}
}
