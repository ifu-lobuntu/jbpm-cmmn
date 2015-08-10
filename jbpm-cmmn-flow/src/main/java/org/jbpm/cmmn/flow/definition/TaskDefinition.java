package org.jbpm.cmmn.flow.definition;

import org.jbpm.cmmn.flow.core.CaseParameter;
import org.kie.api.definition.process.*;

import java.util.Collection;
import java.util.List;

public interface TaskDefinition extends RepeatablePlanItemDefinition {
	Collection<CaseParameter> getInputs();

	Collection<CaseParameter> getOutputs();

	void addOutputParameter(CaseParameter cp);

	void addInputParameter(CaseParameter cp);

    boolean isBlocking();

	List<ParameterMapping> prepareInputMappings(org.kie.api.definition.process.Process process);

	List<ParameterMapping> prepareOutputMappings(org.kie.api.definition.process.Process process);
}
