package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinition;
import org.jbpm.cmmn.flow.core.Import;

import java.util.ArrayList;
import java.util.List;

public class DefinitionsImpl implements org.jbpm.cmmn.flow.core.Definitions {

	private static final long serialVersionUID = 3235326449898795391L;
    private List<CaseFileItemDefinition> caseFileItemDefinitions = new ArrayList<CaseFileItemDefinition>();
    private List<Case> cases = new ArrayList<Case>();
    private List<Process> processes = new ArrayList<Process>();
    private List<Import> imports= new ArrayList<Import>();
	private String targetNamespace;

	@Override
	public List<CaseFileItemDefinition> getCaseFileItemDefinitions() {
		return caseFileItemDefinitions;
	}

	@Override
	public void setCaseFileItemDefinitions(List<CaseFileItemDefinition> caseFileItemDefinitions) {
		this.caseFileItemDefinitions = caseFileItemDefinitions;
	}

	@Override
	public String getTargetNamespace() {
		return targetNamespace;
	}

	@Override
	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}
}
