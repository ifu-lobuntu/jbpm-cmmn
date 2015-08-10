package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.definition.ProcessTaskDefinition;

public class ProcessTaskDefinitionImpl extends TaskDefinitionImpl implements ProcessTaskDefinition {
	private static final long serialVersionUID = 7495168121066617656L;
	private String processId;

	public ProcessTaskDefinitionImpl() {

	}

	@Override
	public void setProcessId(String string) {
		this.processId = string;
	}

	@Override
	public String getProcessId() {
		return processId;
	}
}
