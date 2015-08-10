package org.jbpm.cmmn.instance.impl;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.common.impl.CaseFileItemStandardEventNodeImpl;
import org.jbpm.cmmn.flow.common.impl.PlanItemStandardEventNode;
import org.jbpm.cmmn.instance.*;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.process.instance.context.variable.VariableScopeInstance;
import org.jbpm.workflow.instance.node.EventNodeInstance;

import java.util.Stack;

public class StandardEventNodeInstance extends EventNodeInstance implements OnPartInstance{

	private static final long serialVersionUID = 377496036154216192L;

	public AbstractStandardEventNode getOnPart() {
		return (AbstractStandardEventNode) getEventNode();
	}

	@Override
	public void signalEvent(String type, Object event) {
		if (event instanceof CaseFileItemEvent && getOnPart() instanceof CaseFileItemStandardEventNodeImpl) {
			CaseFileItemStandardEventNodeImpl onPart = (CaseFileItemStandardEventNodeImpl) getOnPart();
			CaseFileItemEvent e = (CaseFileItemEvent) event;
			if (onPart.getSourceCaseFileItem().getName().equals(e.getCaseFileItemName()) && e.getTransition() == onPart.getStandardEvent()) {
				getEventStack().push(((CaseFileItemEvent) event).getValue());
				triggerCompleted();
			}
		} else if (event instanceof PlanItemEvent && getOnPart() instanceof PlanItemStandardEventNode) {
			PlanItemStandardEventNode onPart = (PlanItemStandardEventNode) getOnPart();
			PlanItemEvent e = (PlanItemEvent) event;
			if (e.getPlanItemName().equals(onPart.getSourcePlanItem().getName()) && e.getTransition() == onPart.getStandardEvent()) {
				getEventStack().push(((PlanItemEvent) event).getValue());
				triggerCompleted();

			}
		}
	}

	public Object popEvent() {
		return getEventStack().pop();
	}

	@SuppressWarnings("unchecked")
	private Stack<Object> getEventStack() {
		String variableName = getOnPart().getVariableName();
		VariableScopeInstance variableScopeInstance = (VariableScopeInstance) resolveContextInstance(VariableScope.VARIABLE_SCOPE, getOnPart()
				.getVariableName());
		if (variableScopeInstance == null) {
			throw new IllegalArgumentException("Could not find variable for event node: " + variableName);
		}
		Stack<Object> variable = (Stack<Object>) variableScopeInstance.getVariable(variableName);
		if (variable == null) {
			variableScopeInstance.setVariable(variableName, variable = new Stack<Object>());
		}
		return variable;
	}

	@Override
	public void triggerCompleted() {
		((org.jbpm.workflow.instance.NodeInstanceContainer) getNodeInstanceContainer()).setCurrentLevel(getLevel());
		triggerCompleted(org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE, false);
	}

	public CaseEvent getCaseEvent() {
		Object peek = getEventStack().peek();
		if(getOnPart() instanceof CaseFileItemStandardEventNodeImpl){
			CaseFileItemStandardEventNodeImpl cfiop=(CaseFileItemStandardEventNodeImpl) getOnPart();
			return new CaseFileItemEvent(cfiop.getSourceCaseFileItem().getName(), cfiop.getStandardEvent(), null, peek);
		}else{
			PlanItemStandardEventNode piop=(PlanItemStandardEventNode) getOnPart();
			return new PlanItemEvent(piop.getSourcePlanItem().getName(), piop.getStandardEvent() , peek);
		}
	}

	public CaseInstance getCaseInstance() {
		return (CaseInstance) getProcessInstance();
	}

}
