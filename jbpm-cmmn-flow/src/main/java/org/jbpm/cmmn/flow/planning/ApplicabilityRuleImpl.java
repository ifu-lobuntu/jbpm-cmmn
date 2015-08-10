package org.jbpm.cmmn.flow.planning;

import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.workflow.core.Constraint;

public class ApplicabilityRuleImpl implements ApplicabilityRule {
	private static final long serialVersionUID = 2760086481660795186L;
	private String elementId;
	private String contextRef;
	private CaseFileItem context;
	private Constraint condition;

	@Override
	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	@Override
	public String getContextRef() {
		return contextRef;
	}

	public void setContextRef(String contextRef) {
		this.contextRef = contextRef;
	}

	@Override
	public CaseFileItem getContext() {
		return context;
	}

	public void setContext(CaseFileItem context) {
		this.context = context;
	}

	@Override
	public Constraint getCondition() {
		return condition;
	}

	public void setCondition(Constraint condition) {
		this.condition = condition;
	}

}
