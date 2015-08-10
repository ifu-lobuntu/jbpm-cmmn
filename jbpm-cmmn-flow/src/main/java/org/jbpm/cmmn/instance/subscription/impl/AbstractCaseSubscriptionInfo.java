package org.jbpm.cmmn.instance.subscription.impl;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.instance.subscription.DurableCaseFileItemSubscriptionInfo;
import org.jbpm.cmmn.instance.subscription.DurableCaseSubscriptionInfo;
public abstract class AbstractCaseSubscriptionInfo<X extends DurableCaseFileItemSubscriptionInfo> implements DurableCaseSubscriptionInfo<X> {
	@Override
	public X findCaseFileItemSubscription(String itemName, CaseFileItemTransition transition) {
		for (X x : getCaseFileItemSubscriptions()) {
			if (x.getTransition() == transition && x.getItemName().equals(itemName)) {
				return x;
			}
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj instanceof DurableCaseSubscriptionInfo) {
			return ((DurableCaseSubscriptionInfo<?>) obj).getId().equals(getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}
