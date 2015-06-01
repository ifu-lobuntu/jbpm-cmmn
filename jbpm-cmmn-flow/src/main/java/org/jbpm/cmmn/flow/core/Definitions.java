package org.jbpm.cmmn.flow.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Definitions implements Serializable {

	private static final long serialVersionUID = 3235326449898795391L;
    private List<CaseFileItemDefinition> caseFileItemDefinitions = new ArrayList<CaseFileItemDefinition>();
    private List<Case> cases = new ArrayList<Case>();
    private List<Process> processes = new ArrayList<Process>();
    private List<Import> imports= new ArrayList<Import>();
	private String targetNamespace;

	public List<CaseFileItemDefinition> getCaseFileItemDefinitions() {
		return caseFileItemDefinitions;
	}

	public void setCaseFileItemDefinitions(List<CaseFileItemDefinition> caseFileItemDefinitions) {
		this.caseFileItemDefinitions = caseFileItemDefinitions;
	}

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}
}
