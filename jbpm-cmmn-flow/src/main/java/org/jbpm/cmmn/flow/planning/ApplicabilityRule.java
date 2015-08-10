package org.jbpm.cmmn.flow.planning;

import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.process.instance.impl.ReturnValueConstraintEvaluator;
import org.jbpm.workflow.core.Constraint;


public interface ApplicabilityRule extends CMMNElement {
    String getElementId();

    String getContextRef();

    CaseFileItem getContext();

    Constraint getCondition();

    void setCondition(Constraint build);
}
