package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinitionType;

import java.io.Serializable;

public class CaseFileItemDefinitionImpl implements Serializable, org.jbpm.cmmn.flow.core.CaseFileItemDefinition {

	private static final long serialVersionUID = -4667585177916762919L;
	private CaseFileItemDefinitionType definitionType;
	private String structureRef;
	private String id;

	public CaseFileItemDefinitionImpl(String id) {
		this.id = id;
	}

	@Override
	public CaseFileItemDefinitionType getDefinitionType() {
		return definitionType;
	}

	@Override
	public void setDefinitionType(CaseFileItemDefinitionType definitionType) {
		this.definitionType = definitionType;
	}

	@Override
	public String getStructureRef() {
		return structureRef;
	}

	@Override
	public void setStructureRef(String structureRef) {
		this.structureRef = structureRef;
	}

	@Override
	public String getElementId() {
		return id;
	}
}
