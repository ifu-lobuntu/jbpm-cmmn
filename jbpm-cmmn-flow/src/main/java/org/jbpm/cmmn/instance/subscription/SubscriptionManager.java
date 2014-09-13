package org.jbpm.cmmn.instance.subscription;

import java.util.Collection;
import java.util.Map;

import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.instance.CaseInstance;

public interface SubscriptionManager<T extends DurableCaseSubscriptionInfo<X>,X extends DurableCaseFileItemSubscriptionInfo> {
	String ENV_NAME = SubscriptionManager.class.getName();

	void updateSubscriptions(CaseInstance process, Collection<Object> targets, Map<CaseFileItem, Collection<Object>> parentSubscriptions, SubscriptionPersistenceContext<T,X> p);

	SubscriptionPersistenceContext<T,X> getObjectPersistence(CaseInstance p);

	DurableCaseSubscriptionInfo<?> getCaseSubscriptionInfoFor(Object object, SubscriptionPersistenceContext<T,X> p);

}
