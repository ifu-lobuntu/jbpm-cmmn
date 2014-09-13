package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.core.CaseFileItemTransition;

public interface DurableCaseFileItemSubscriptionInfo extends CaseFileItemSubscriptionInfo {
	String getIdentifier();

	void setCaseKey(String caseKey);

	void setTransition(CaseFileItemTransition transition);

	void setItemName(String itemName);

	void setProcessInstanceId(long id);

	void setRelatedItemName(String itemName);

	void setCaseSubscription(DurableCaseSubscriptionInfo<?> caseSubscription);

	DurableCaseSubscriptionInfo<?> getCaseSubscription();

}
