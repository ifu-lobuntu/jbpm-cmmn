package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.flow.core.impl.CaseFileItemImpl;
import org.jbpm.cmmn.instance.CaseInstance;
import org.kie.internal.runtime.KnowledgeRuntime;

public interface OnPartInstanceSubscription extends CaseFileItemSubscriptionInfo {

	void addParameter(org.jbpm.cmmn.flow.core.CaseParameter parameter);

	KnowledgeRuntime getKnowledgeRuntime();

	boolean meetsBindingRefinementCriteria(Object value, CaseInstance ci);

	CaseFileItemImpl getVariable();

	boolean isListeningTo(Object target, CaseFileItemTransition transition);

}
