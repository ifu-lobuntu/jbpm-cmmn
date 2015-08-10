package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.cmmn.flow.core.BindingRefinement;
import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseParameter;

import java.io.Serializable;

public class CaseParameterImpl implements Serializable, CMMNElement, CaseParameter {
	private static final long serialVersionUID = -2726481569205195638L;
	private String id;
	private String bindingRef;
	private String name;
	private CaseFileItem variable;
	private BindingRefinement bindingRefinement;

	@Override
	public String getElementId() {
		return id;
	}

	@Override
	public void setElementId(String id) {
		this.id = id;
	}

	@Override
	public String getBindingRef() {
		return bindingRef;
	}

	@Override
	public void setBindingRef(String bindingRef) {
		this.bindingRef = bindingRef;
	}

	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public CaseFileItem getBoundVariable() {
		return variable;
	}

	@Override
	public void setBoundVariable(CaseFileItem variable) {
		this.variable = variable;
	}

	@Override
	public BindingRefinement getBindingRefinement() {
		return bindingRefinement;
	}

	@Override
	public void setBindingRefinement(BindingRefinement bindingRefinement) {
		this.bindingRefinement = bindingRefinement;
	}

}
