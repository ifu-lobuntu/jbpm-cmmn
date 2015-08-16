package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.definition.CaseTaskDefinition;
import org.jbpm.cmmn.flow.definition.ParameterMapping;
import org.kie.api.definition.process.*;

import java.util.List;

public class CaseTaskDefinitionImpl extends TaskDefinitionImpl implements CaseTaskDefinition {
    private static final long serialVersionUID = 7495168121066617656L;
    private String processId;

    public CaseTaskDefinitionImpl() {

    }

    @Override
    public List<ParameterMapping> prepareInputMappings(org.kie.api.definition.process.Process process) {
        for (ParameterMapping pm : inputMappings) {
            CaseParameter cp = ((Case) process).getInputParameter(pm.getTargetParameterId());
            if (cp != null) {
                pm.setTargetParameterName(cp.getName());
            }
        }
        return inputMappings;
    }

    @Override
    public List<ParameterMapping> prepareOutputMappings(org.kie.api.definition.process.Process process) {
        for (ParameterMapping pm : outputMappings) {
            CaseParameter cp = ((Case) process).getOutputParameter(pm.getSourceParameterId());
            if (cp != null) {
                pm.setSourceParameterName(cp.getName());
            }
        }
        return outputMappings;
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
