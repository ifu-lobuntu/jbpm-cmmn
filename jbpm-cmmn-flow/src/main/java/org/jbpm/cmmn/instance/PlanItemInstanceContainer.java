package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.workflow.instance.NodeInstanceContainer;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface PlanItemInstanceContainer extends PlanningTableContainerInstance, NodeInstanceContainer {

	Collection<? extends PlanItemInstance<?>> getChildren();

    void complete();

	PlanItemContainer getPlanItemContainer();

	void populateSubscriptionsActivatedByParameters(SubscriptionContext sc);

	void addSubscribingCaseParameters(Set<org.jbpm.cmmn.flow.core.CaseParameter> params);

	void addCaseFileItemOnPartsForParameters(Collection<org.jbpm.cmmn.flow.core.CaseParameter> items,
			Map<OnPartInstance, OnPartInstanceSubscription> onCaseFileItemParts);

	PlanningTableContainerInstance findPlanningTableContainerInstance(long containerWorkItemId);

	void resumeAfterPlanning();
}