package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.cmmn.flow.definition.PlanItemControl;
import org.jbpm.workflow.core.Constraint;

import java.io.Serializable;

public class PlanItemControlImpl implements Serializable, PlanItemControl {

	private static final long serialVersionUID = 166L;
	private String elementId;
	private Constraint manualActivationRule;
	private Constraint requiredRule;
	private Constraint repetionrule;

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	@Override
	public Constraint getManualActivationRule() {
		return manualActivationRule;
	}

	public void setManualActivationRule(Constraint automaticActivationRule) {
		this.manualActivationRule = automaticActivationRule;
	}

	@Override
	public Constraint getRequiredRule() {
		return requiredRule;
	}

	public void setRequiredRule(Constraint requiredRule) {
		this.requiredRule = requiredRule;
	}

	@Override
	public Constraint getRepetitionRule() {
		return repetionrule;
	}

	public void setRepetitionRule(Constraint repetionRule) {
		this.repetionrule = repetionRule;
	}

}
