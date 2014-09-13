package org.jbpm.cmmn.flow.core;

import org.jbpm.workflow.core.Constraint;

public interface PlanItemControl extends CMMNElement {

	Constraint getRepetitionRule();

	Constraint getRequiredRule();

	Constraint getManualActivationRule();

}
