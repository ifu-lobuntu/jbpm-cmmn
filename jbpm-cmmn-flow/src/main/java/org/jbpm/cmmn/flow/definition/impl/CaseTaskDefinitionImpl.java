package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.definition.CaseTaskDefinition;

public class CaseTaskDefinitionImpl extends TaskDefinitionImpl implements CaseTaskDefinition {
	private static final long serialVersionUID = 7495168121066617656L;
	private String processId;

	public CaseTaskDefinitionImpl() {

	}

	@Override
	public void setCaseId(String string) {
		this.processId = string;
	}

	@Override
	public String getCaseId() {
		return processId;
	}
}
