package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;

/**
 * An abstract representation of the subscription information that is available inside a CaseInstance. It excludes any reference to actual objects which can be found in
 * @see DurableCaseFileItemSubscription
 */
public interface CaseFileItemSubscription {

	long getProcessInstanceId();
	String getDeploymentId();
	String getItemName();
	String getRelatedItemName();
	CaseFileItemTransition getTransition();

}
