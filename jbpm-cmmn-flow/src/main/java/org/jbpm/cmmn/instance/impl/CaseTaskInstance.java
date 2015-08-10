package org.jbpm.cmmn.instance.impl;


import org.jbpm.cmmn.flow.definition.CaseTaskDefinition;

public class CaseTaskInstance extends AbstractCallingTaskInstance <CaseTaskDefinition>{

	@Override
	public String getCalledProcessId() {
		return getItem().getDefinition().getCaseId();
	}
}
