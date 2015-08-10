package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.definition.ParameterMapping;
import org.jbpm.process.instance.impl.ReturnValueConstraintEvaluator;
import org.jbpm.process.instance.impl.ReturnValueEvaluator;
import org.jbpm.workflow.core.Constraint;

import java.io.Serializable;

public class ParameterMappingImpl implements Serializable, ParameterMapping {
	private static final long serialVersionUID = -3627421388193991961L;
	private String elementId;
	private String sourceRef;
	private CaseParameter sourceParameter;
	private String targetRef;
	private Constraint transformation;
	private String targetParameterName;
	private CaseParameter targetParameter;
	private String sourceParameterName;

	@Override
	public String getSourceRef() {
		return sourceRef;
	}

	@Override
	public void setSourceRef(String sourceRef) {
		this.sourceRef = sourceRef;
	}

	@Override
	public CaseParameter getSourceParameter() {
		return sourceParameter;
	}

	@Override
	public CaseParameter getTargetParameter() {
		return targetParameter;
	}

	@Override
	public String getTargetRef() {
		return targetRef;
	}

	@Override
	public void setTargetRef(String targetRef) {
		this.targetRef = targetRef;
	}

	@Override
	public String getElementId() {
		return elementId;
	}

	@Override
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	@Override
	public Constraint getTransformation() {
		return transformation;
	}

	@Override
	public ReturnValueEvaluator getTransformer() {
		if (transformation instanceof ReturnValueConstraintEvaluator) {
			return ((ReturnValueConstraintEvaluator) transformation).getReturnValueEvaluator();
		} else {
			return null;
		}
	}

	@Override
	public void setTransformation(Constraint transformation) {
		this.transformation = transformation;
	}

	@Override
	public String getTargetParameterName() {
		if (targetParameter != null) {
			return targetParameter.getName();
		}
		if (targetParameterName == null) {
			return getTargetParameterId();
		}
		return targetParameterName;
	}

	@Override
	public String getSourceParameterName() {
		if (sourceParameter != null) {
			return sourceParameter.getName();
		}
		if (sourceParameterName == null) {
			return getSourceParameterId();
		}
		return sourceParameterName;
	}

	@Override
	public void setTargetParameterName(String targetParameterName) {
		this.targetParameterName = targetParameterName;
	}

	@Override
	public void setSourceParameterName(String sourceParameterName) {
		this.sourceParameterName = sourceParameterName;
	}

	@Override
	public String getSourceParameterId() {
		String[] split = sourceRef.split("\\#");
		return split[split.length - 1];
	}

	@Override
	public String getTargetParameterId() {
		String[] split = targetRef.split("\\#");
		return split[split.length - 1];
	}

	@Override
	public void setTargetParameter(CaseParameter cp) {
		this.targetParameter = cp;

	}

	@Override
	public void setSourceParameter(CaseParameter sourceParameter) {
		this.sourceParameter = sourceParameter;
	}

}
