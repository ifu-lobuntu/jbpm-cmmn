package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.instance.CaseInstance;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * An
 */
public interface SubscriptionManager<X extends DurableCaseFileItemSubscription> {
    String ENV_NAME = SubscriptionManager.class.getName();

    X createSubscription(Object object);

    void setSubscriptions(CaseInstance caseInstance, Set<X> subscriptions);

    //For testing purposes really
    Collection<? extends DurableCaseFileItemSubscription> getCaseSubscriptionInfoFor(Object object);

    Collection<? extends DurableCaseFileItemSubscription> getCaseSubscriptionInfoFor(CaseInstance caseInstance);

}
