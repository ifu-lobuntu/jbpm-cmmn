package org.jbpm.cmmn.flow.definition;

import org.kie.api.definition.process.Process;

import java.util.List;
public interface CallingTaskDefinition extends TaskDefinition {

    List<ParameterMapping> prepareInputMappings(Process process);

    List<ParameterMapping> prepareOutputMappings(Process process);
}
