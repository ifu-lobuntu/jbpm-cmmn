package org.jbpm.cmmn.instance.impl;


import org.jbpm.cmmn.flow.definition.ProcessTaskDefinition;

public class ProcessTaskInstance extends AbstractCallingTaskInstance<ProcessTaskDefinition> {

	@Override
	public String getCalledProcessId() {
		return getItem().getDefinition().getProcessId();
	}
}
