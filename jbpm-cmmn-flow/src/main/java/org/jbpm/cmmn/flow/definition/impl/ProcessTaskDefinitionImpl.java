package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.definition.ParameterMapping;
import org.jbpm.cmmn.flow.definition.ProcessTaskDefinition;
import org.jbpm.process.core.context.variable.Variable;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.kie.api.definition.process.Process;

import java.util.List;

public class ProcessTaskDefinitionImpl extends TaskDefinitionImpl implements ProcessTaskDefinition {
    private static final long serialVersionUID = 7495168121066617656L;
    private String processId;

    public ProcessTaskDefinitionImpl() {

    }

    @Override
    public List<ParameterMapping> prepareInputMappings(Process process) {
        for (ParameterMapping pm : inputMappings) {
            Variable cp = ((RuleFlowProcess) process).getVariableScope().findVariable(pm.getTargetParameterId());
            if (cp != null) {
                pm.setTargetParameterName(cp.getName());
            }
        }
        return inputMappings;
    }

    @Override
    public List<ParameterMapping> prepareOutputMappings(Process process) {
        for (ParameterMapping pm : outputMappings) {
            Variable cp = ((RuleFlowProcess) process).getVariableScope().findVariable(pm.getTargetParameterId());
            if (cp != null) {
                pm.setSourceParameterName(cp.getName());
            }
        }
        return outputMappings;
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
