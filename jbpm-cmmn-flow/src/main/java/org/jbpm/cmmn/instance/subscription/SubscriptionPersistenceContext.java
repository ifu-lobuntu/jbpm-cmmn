package org.jbpm.cmmn.instance.subscription;


public interface SubscriptionPersistenceContext<X extends DurableCaseFileItemSubscription> {

	Object getDelegate();

}
