package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.process.instance.impl.Action;
import org.jbpm.process.instance.impl.ReturnValueConstraintEvaluator;
import org.jbpm.process.instance.impl.ReturnValueEvaluator;
import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.DroolsAction;
import org.jbpm.workflow.core.impl.ConstraintImpl;

public class BindingRefinementImpl implements org.jbpm.cmmn.flow.core.BindingRefinement {
	private Constraint expression;
	private Constraint parentExpression;
	private DroolsAction setterOnParent;

	public BindingRefinementImpl(ConstraintImpl exp) {
		this.expression = exp;
	}

	@Override
	public Constraint getParentExpression() {
		return parentExpression;
	}

	@Override
	public void setParentExpression(Constraint bindingRefinement) {
		this.parentExpression = bindingRefinement;
	}

	@Override
	public void setSetterOnParent(DroolsAction a) {
		this.setterOnParent = a;
	}

	@Override
	public Constraint getExpression() {
		return expression;
	}

	@Override
	public void setExpression(Constraint bindingRefinement) {
		this.expression = bindingRefinement;
	}

	@Override
	public ReturnValueEvaluator getEvaluator() {
		if (expression instanceof ReturnValueConstraintEvaluator) {
			return ((ReturnValueConstraintEvaluator) expression).getReturnValueEvaluator();
		}
		return null;
	}

	@Override
	public ReturnValueEvaluator getParentEvaluator() {
		if (parentExpression instanceof ReturnValueConstraintEvaluator) {
			return ((ReturnValueConstraintEvaluator) parentExpression).getReturnValueEvaluator();
		}
		return null;
	}

	@Override
	public Action getSetterOnParent() {
		if (setterOnParent != null) {
			return (Action) setterOnParent.getMetaData("Action");
		}
		return null;
	}

	@Override
	public boolean isValid() {
		return expression instanceof ReturnValueConstraintEvaluator;
	}

}
