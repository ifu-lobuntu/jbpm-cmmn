package org.jbpm.cmmn.instance.subscription.impl;

import static org.jbpm.cmmn.flow.core.CaseFileItemTransition.CREATE;
import static org.jbpm.cmmn.flow.core.CaseFileItemTransition.DELETE;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.drools.core.common.InternalKnowledgeRuntime;
import org.jbpm.cmmn.datatypes.CollectionDataType;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseFileItemTransition;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.planitem.CaseFileItemOnPart;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.OnPartInstance;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.cmmn.instance.subscription.CaseFileItemSubscriptionInfo;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.kie.internal.runtime.KnowledgeRuntime;

public class OnPartInstanceSubscriptionImpl extends AbstractCaseFileItemSubscriptionInfo implements CaseFileItemSubscriptionInfo, OnPartInstanceSubscription {
	CaseFileItemOnPart source;
	private Set<CaseParameter> subscribingParameters = new HashSet<CaseParameter>();
	private InternalKnowledgeRuntime kr;
	private String caseKey;
	private long processInstanceId;

	public OnPartInstanceSubscriptionImpl(OnPartInstance source, CaseParameter caseParameter) {
		super();
		// InternalRuntimeManager manager = (InternalRuntimeManager)
		// source.getCaseInstance().getKnowledgeRuntime().getEnvironment().get("RuntimeManager");
		this.subscribingParameters.add(caseParameter);
		kr = source.getCaseInstance().getKnowledgeRuntime();
		this.source = (CaseFileItemOnPart) source.getOnPart();
		this.caseKey = source.getCaseInstance().getCase().getCaseKey();
		this.processInstanceId = source.getCaseInstance().getId();
	}

	public CaseFileItemOnPart getSource() {
		return (CaseFileItemOnPart) source;
	}

	@Override
	public String getItemName() {
		return getSource().getSourceCaseFileItem().getName();
	}

	@Override
	public CaseFileItemTransition getTransition() {
		return getSource().getStandardEvent();
	}

	@Override
	public String getRelatedItemName() {
		return getSource().getRelatedCaseFileItem() != null ? getSource().getRelatedCaseFileItem().getName() : null;
	}

	public boolean meetsBindingRefinementCriteria(Object o, CaseInstance caseInstance) {
		Set<CaseParameter> subscribingParameters2 = this.subscribingParameters;
		if (getSource().getStandardEvent() == CREATE || getSource().getStandardEvent() == DELETE) {
			return true; // TODO Can't make assumptions about whether the process state contains the new/old
							// object
		}
		for (CaseParameter caseParameter : subscribingParameters2) {
			if (caseParameter.getBindingRefinement() == null || !caseParameter.getBindingRefinement().isValid()) {
				return true;
			} else {
				Object val = ExpressionUtil.readFromBindingRefinement(caseParameter, caseInstance, null);
				if (caseParameter.getBoundVariable().isCollection()) {
					if (val instanceof Collection && ((Collection<?>) val).contains(o)) {
						return true;
					}
					if (val != null && val.equals(o)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void addParameter(CaseParameter parameter) {
		this.subscribingParameters.add(parameter);
	}

	public CaseFileItem getVariable() {
		return getSource().getSourceCaseFileItem();
	}

	private static boolean isInstance(Object source, String stringType) {
		try {
			return Class.forName(stringType).isInstance(source);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isListeningTo(Object target, CaseFileItemTransition t) {
		if (t == getTransition()) {
			if (getVariable().isCollection()) {
				CollectionDataType dt = (CollectionDataType) getVariable().getType();
				String elementClassName = dt.getElementClassName();
				if (isInstance(target, elementClassName)) {
					return true;
				}
			} else {
				String stringType = getVariable().getType().getStringType();
				if (isInstance(target, stringType)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String getCaseKey() {
		return caseKey;

	}

	@Override
	public long getProcessInstanceId() {
		return processInstanceId;
	}

	@Override
	public KnowledgeRuntime getKnowledgeRuntime() {
		return kr;
	}

}
