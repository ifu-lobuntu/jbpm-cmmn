package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.instance.CaseInstance;
import org.kie.internal.runtime.KnowledgeRuntime;

import java.util.Collection;

/**
 * An interface used to keep track of CaseFileItemSubscriptions that are in scope. As such, it does not carry any state pertaining to any objects subscribed to. Instead,
 * one can use the subscribingParameters property to find out which objects are being subscribed to.
 */
public interface ScopedCaseFileItemSubscription extends CaseFileItemSubscription {

	void addSubscribingParameter(CaseParameter parameter);

	Collection<CaseParameter> getSubscribingParameters();

	KnowledgeRuntime getKnowledgeRuntime();

	boolean meetsBindingRefinementCriteria(Object value, CaseInstance ci);

	CaseFileItem getVariable();

	boolean isListeningTo(Object target, CaseFileItemTransition transition);

}
