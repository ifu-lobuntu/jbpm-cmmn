package org.jbpm.cmmn.flow.core;

import org.jbpm.process.instance.impl.Action;
import org.jbpm.process.instance.impl.ReturnValueEvaluator;
import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.DroolsAction;


public interface BindingRefinement {
    Constraint getParentExpression();

    void setParentExpression(Constraint bindingRefinement);

    void setSetterOnParent(DroolsAction a);

    Constraint getExpression();

    void setExpression(Constraint bindingRefinement);

    ReturnValueEvaluator getEvaluator();

    ReturnValueEvaluator getParentEvaluator();

    Action getSetterOnParent();

    boolean isValid();
}
