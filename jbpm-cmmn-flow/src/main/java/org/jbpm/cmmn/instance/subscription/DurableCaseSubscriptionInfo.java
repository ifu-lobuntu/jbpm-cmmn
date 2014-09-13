package org.jbpm.cmmn.instance.subscription;

import java.util.Collection;

import org.jbpm.cmmn.flow.core.CaseFileItemTransition;

public interface DurableCaseSubscriptionInfo<T extends DurableCaseFileItemSubscriptionInfo> {

	Collection<? extends T> getCaseFileItemSubscriptions();

	void addCaseFileItemSubscription(T i);

	void removeCaseFileItemSubscription(T i);

	public abstract T findCaseFileItemSubscription(String itemName, CaseFileItemTransition transition);

	CaseSubscriptionKey getId();
}
