package org.jbpm.cmmn.instance.subscription.impl;

import org.drools.core.common.InternalKnowledgeRuntime;
import org.jbpm.cmmn.datatypes.CollectionDataType;
import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.flow.common.impl.CaseFileItemStandardEventNodeImpl;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.impl.CaseFileItemImpl;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.OnPartInstance;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.cmmn.instance.subscription.ScopedCaseFileItemSubscription;
import org.kie.internal.runtime.KnowledgeRuntime;

import java.util.HashSet;
import java.util.Set;

import static org.jbpm.cmmn.flow.common.CaseFileItemTransition.CREATE;
import static org.jbpm.cmmn.flow.common.CaseFileItemTransition.DELETE;

public class ScopedCaseFileItemSubscriptionImpl implements ScopedCaseFileItemSubscription {
	private final CaseInstance caseInstance;
	private final CaseFileItemStandardEventNodeImpl source;
	private Set<CaseParameter> subscribingParameters = new HashSet<CaseParameter>();
	private InternalKnowledgeRuntime kr;

	public ScopedCaseFileItemSubscriptionImpl(OnPartInstance source, CaseParameter caseParameter) {
		super();
		this.caseInstance=source.getCaseInstance();
		this.subscribingParameters.add(caseParameter);
		kr = source.getCaseInstance().getKnowledgeRuntime();
		this.source = (CaseFileItemStandardEventNodeImpl) source.getOnPart();
	}
	public String toString(){
		return "On" + getTransition() + "Of(" + getVariable().getName() +"."+getRelatedItemName() +")";
	}
	public CaseFileItemStandardEventNodeImpl getSource() {
		return source;
	}


	public boolean meetsBindingRefinementCriteria(Object o, CaseInstance caseInstance) {
		if (getSource().getStandardEvent() == CREATE || getSource().getStandardEvent() == DELETE) {
			return true; // TODO Can't make assumptions about whether the process state contains the new/old
							// object
		}
		return ExpressionUtil.meetsBindingRefinement(o, caseInstance, this.subscribingParameters);
	}

	public void addSubscribingParameter(CaseParameter parameter) {
		this.subscribingParameters.add(parameter);
	}

	@Override
	public Set<CaseParameter> getSubscribingParameters() {
		return subscribingParameters;
	}

	public CaseFileItemImpl getVariable() {
		return getSource().getSourceCaseFileItem();
	}

	private static boolean isInstance(Object source, String stringType) {
		try {
			return Class.forName(stringType).isInstance(source);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public long getProcessInstanceId() {
		return caseInstance.getId();
	}

	@Override
	public String getDeploymentId() {
		return (String) caseInstance.getKnowledgeRuntime().getEnvironment().get("deploymentId");
	}

	@Override
	public String getItemName() {
		return source.getSourceCaseFileItem().getName();
	}

	@Override
	public String getRelatedItemName() {
		if(source.getRelatedCaseFileItem()==null){
			return source.getRelationRef();//could be property name;
		}
		return source.getRelatedCaseFileItem().getName();
	}

	@Override
	public CaseFileItemTransition getTransition() {
		return source.getStandardEvent();
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
	public KnowledgeRuntime getKnowledgeRuntime() {
		return kr;
	}

}
