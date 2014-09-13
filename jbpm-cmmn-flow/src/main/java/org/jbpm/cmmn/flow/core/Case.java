package org.jbpm.cmmn.flow.core;

import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.workflow.core.WorkflowProcess;

public interface Case extends PlanItemContainer,WorkflowProcess {

	CaseParameter getInputParameter(String id);
	CaseParameter getOutputParameter(String id);
	VariableScope getVariableScope();
	PlanItemDefinition getPlanItemDefinition(String id);
	String getCaseKey();

}
