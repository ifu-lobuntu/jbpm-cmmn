package org.jbpm.cmmn.flow.definition;

import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.workflow.core.Constraint;

public interface PlanItemControl extends CMMNElement {

	Constraint getRepetitionRule();

	Constraint getRequiredRule();

	Constraint getManualActivationRule();

}
