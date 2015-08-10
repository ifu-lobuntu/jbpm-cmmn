package org.jbpm.cmmn.flow.definition;

import org.jbpm.cmmn.flow.core.CMMNElement;

import java.io.Serializable;

public interface PlanItemDefinition extends Serializable, CMMNElement {

	String getName();

	String getDescription();

	PlanItemControl getDefaultControl();

	void setDefaultControl(PlanItemControl c);

}
