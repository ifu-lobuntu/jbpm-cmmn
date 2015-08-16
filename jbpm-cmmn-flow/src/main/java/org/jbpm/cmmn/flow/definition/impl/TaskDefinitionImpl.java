package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.impl.CaseParameterImpl;
import org.jbpm.cmmn.flow.definition.ParameterMapping;
import org.jbpm.cmmn.flow.definition.TaskDefinition;
import org.kie.api.definition.process.Process;
import org.kie.internal.task.api.model.TaskDef;

import java.util.*;

public class TaskDefinitionImpl extends AbstractPlanItemDefinition implements TaskDefinition {
	Map<String, CaseParameter> inputs = new HashMap<String, CaseParameter>();
	Map<String, CaseParameter> outputs = new HashMap<String, CaseParameter>();
	List<ParameterMapping> mappings = new ArrayList<ParameterMapping>();
	List<ParameterMapping> outputMappings = new ArrayList<ParameterMapping>();
	List<ParameterMapping> inputMappings = new ArrayList<ParameterMapping>();
	private boolean blocking;

	public Collection<CaseParameter> getInputs() {
		return inputs.values();
	}

	public Collection<CaseParameter> getOutputs() {
		return outputs.values();
	}

	public void addOutputParameter(CaseParameter cp) {
		this.outputs.put(cp.getElementId()==null?cp.getName():cp.getElementId(), cp);
	}

	public void addInputParameter(CaseParameter cp) {
		this.inputs.put(cp.getElementId()==null?cp.getName():cp.getElementId(), cp);
	}

	public void setBlocking(boolean b) {
		this.blocking = b;
	}

	public boolean isBlocking() {
		return blocking;
	}

	public void addParameterMapping(ParameterMapping cp) {
		mappings.add(cp);
	}

	public List<ParameterMapping> getParameterMappings() {
		return mappings;
	}

	public void mapParameters() {
		for (ParameterMapping pm : this.mappings) {
			CaseParameter sourceParameter = inputs.get(pm.getSourceRef());
			if (sourceParameter != null) {
				pm.setSourceParameter(sourceParameter);
				inputMappings.add(pm);
			} else {
				CaseParameter cp = outputs.get(pm.getTargetRef());
				if (cp == null) {
					throw new IllegalStateException("A parameter mapping  must either map to or from a Case/ProcessTaskDefinition parameter: " + pm.getTargetRef());
				}
				pm.setTargetParameter(cp);
				outputMappings.add(pm);
			}
		}
	}


}
