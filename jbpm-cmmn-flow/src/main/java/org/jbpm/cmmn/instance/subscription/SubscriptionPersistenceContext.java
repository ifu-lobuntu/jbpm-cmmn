package org.jbpm.cmmn.instance.subscription;


public interface SubscriptionPersistenceContext<T extends DurableCaseSubscriptionInfo<X>, X extends DurableCaseFileItemSubscriptionInfo> {

	T findCaseSubscriptionInfo(CaseSubscriptionKey key);

	Object getDelegate();

	void updateCaseSupbscriptionInfo(T t);

	void persistCaseSubscriptionInfo(T t);
	
	void removeCaseFileItemSubscriptionInfo(X x);
}
