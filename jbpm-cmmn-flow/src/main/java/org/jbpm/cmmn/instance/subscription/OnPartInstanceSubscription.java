package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseFileItemTransition;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.instance.CaseInstance;
import org.kie.internal.runtime.KnowledgeRuntime;

public interface OnPartInstanceSubscription extends CaseFileItemSubscriptionInfo {

	void addParameter(CaseParameter parameter);

	KnowledgeRuntime getKnowledgeRuntime();

	boolean meetsBindingRefinementCriteria(Object value, CaseInstance ci);

	CaseFileItem getVariable();

	boolean isListeningTo(Object target, CaseFileItemTransition transition);

}
