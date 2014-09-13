package org.jbpm.cmmn.instance;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.workflow.instance.NodeInstanceContainer;

public interface PlanItemInstanceContainer extends PlanningTableContainerInstance, NodeInstanceContainer {

	Collection<? extends PlanItemInstance<?>> getChildren();

	boolean canComplete();

	PlanItemContainer getPlanItemContainer();

	void populateSubscriptionsActivatedByParameters(SubscriptionContext sc);

	void addSubscribingCaseParameters(Set<CaseParameter> params);

	void addCaseFileItemOnPartsForParameters(Collection<CaseParameter> items,
			Map<OnPartInstance, OnPartInstanceSubscription> onCaseFileItemParts);

	ControllableItemInstance<?> findNodeForWorkItem(long id);

	PlanningTableContainerInstance findPlanningTableContainerInstance(long containerWorkItemId);

	void resumeAfterPlanning();
}