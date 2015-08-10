package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;

public interface CaseFileItemSubscriptionInfo {

	String getItemName();

	CaseFileItemTransition getTransition();

	String getRelatedItemName();

	boolean isValid();

	void validate();

	void invalidate();

	boolean isEquivalent(CaseFileItemSubscriptionInfo other);

	String getCaseKey();

	long getProcessInstanceId();
}
