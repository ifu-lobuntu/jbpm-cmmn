package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;

/**
 * An interface to be implemented by SubscriptionManager implementors. It extends CaseFileItemSubscription with direct references to the single object subscribed to, as well as setter methods
 */
public interface DurableCaseFileItemSubscription extends CaseFileItemSubscription {
    String getStringifiedObjectId();

    String getObjectType();

    void setProcessInstanceId(long processInstanceId);

    void setDeploymentId(String deploymentId);

    void setItemName(String itemName);

    void setRelatedItemName(String relatedItemName);

    void setTransition(CaseFileItemTransition transition);
}
