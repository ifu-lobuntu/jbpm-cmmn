package org.jbpm.cmmn.instance.impl;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.TaskDefinition;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.planning.impl.PlannerRoleCalculator;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.ControllableItemInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.process.instance.ContextInstance;
import org.jbpm.process.instance.ProcessInstance;
import org.jbpm.process.instance.context.variable.VariableScopeInstance;
import org.jbpm.workflow.instance.node.CompositeContextNodeInstance;
import org.kie.api.runtime.process.NodeInstance;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class ControllableItemInstanceImpl<T extends PlanItemDefinition> extends CompositeContextNodeInstance
		implements ControllableItemInstance<T> {

	private static final long serialVersionUID = 3200294767777991641L;

	private PlanElementState lastBusyState = PlanElementState.NONE;
	protected PlanElementState planElementState = PlanElementState.AVAILABLE;
	protected Boolean isCompletionRequired;

	public ControllableItemInstanceImpl() {
		super();
	}


	public org.jbpm.workflow.instance.NodeInstance getFirstNodeInstance(final long nodeId) {
		// level logic not relevant.
		for (NodeInstance ni : this.getNodeInstances()) {
			if (ni.getNodeId() == nodeId) {
				return (org.jbpm.workflow.instance.NodeInstance) ni;
			}
		}
		return null;
	}
	@Override
	protected final boolean isLinkedIncomingNodeRequired() {
		return false;
	}


	public boolean isActivatedManually() {
		return ExpressionUtil.isActivatedManually(this, this.getItem());
	}



	@Override
	public boolean isComplexLifecycle() {
		return true;
	}

	@Override
	public void parentTerminate() {
		throw new IllegalStateException("Complex planItemInstances do not support to parentTerminate");
	}


	protected Map<String, Object> buildParametersFor(PlanItemTransition transition) {
		return new HashMap<String, Object>();
	}

	public void

	internalTriggerWithoutInstantiation(NodeInstance from, String type, WorkItem wi) {
		this.planElementState = PlanElementState.INITIAL;
	}



	public void noteInstantiation() {
		if (isCompletionRequired == null) {
			isCompletionRequired = ExpressionUtil.isRequired(getItem(), this);
		}
		if (isActivatedManually()) {
			enable();
		} else {
			start();
		}
	}

	@SuppressWarnings("unchecked")
	protected void writeToBinding(CaseParameter cp, Object val) {
		if (cp.getBindingRefinement().isValid()) {
			ExpressionUtil.writeToBindingRefinement(this, cp, val);
		} else {
			if (cp.getBoundVariable().isCollection()) {
				Collection<Object> coll = (Collection<Object>) getCaseInstance().getVariable(cp.getBoundVariable().getName());
				if (coll == null) {
					getCaseInstance().setVariable(cp.getBoundVariable().getName(), coll = new HashSet<Object>());
				}
				if (val instanceof Collection) {
					coll.addAll((Collection<Object>) val);
				} else {
					coll.add(val);
				}
			} else {
				getCaseInstance().setVariable(cp.getBoundVariable().getName(), val);
			}
		}
	}


	@Override
	public ContextInstance resolveContextInstance(String contextId, Object param) {
		final ContextInstance result = super.resolveContextInstance(contextId, param);
		if (contextId.equals(VariableScope.VARIABLE_SCOPE)) {
			// TODO make caseParameters available??
			return new CustomVariableScopeInstance(this);
		}
		return result;
	}


	public void setVariable(String variableName, Object value) {
		VariableScopeInstance variableScope = (VariableScopeInstance)
				super.resolveContextInstance(VariableScope.VARIABLE_SCOPE, variableName);
		if (variableScope == null) {
			variableScope = (VariableScopeInstance) getProcessInstance().getContextInstance(VariableScope.VARIABLE_SCOPE);
		}
		variableScope.setVariable(variableName, value);
	}

	@Override
	public String[] getEventTypes() {
		return new String[] {};
	}

	@Override
	public void signalEvent(String type, Object event) {
		if (event instanceof PlanItemTransition) {
			PlanItemTransition transition = (PlanItemTransition) event;
			transition.invokeOn(this);
		} else {
			super.signalEvent(type, event);
		}
	}


	@Override
	public void setLastBusyState(PlanElementState s) {
		this.lastBusyState = s;
	}

	@Override
	public void enable() {
		planElementState.enable(this);
	}

	@Override
	public void disable() {
		planElementState.disable(this);
	}

	@Override
	public void reenable() {
		planElementState.reenable(this);
	}

	@Override
	public void manualStart() {
		planElementState.manualStart(this);
	}

	@Override
	public void reactivate() {
		planElementState.reactivate(this);
	}

	@Override
	public void exit() {
		planElementState.exit(this);
	}

	@Override
	public void complete() {
		planElementState.complete(this);
	}

	@Override
	public void parentSuspend() {
		planElementState.parentSuspend(this);
	}

	@Override
	public void parentResume() {
		planElementState.parentResume(this);
	}

	@Override
	public void create() {
		planElementState.create(this);
	}

	@Override
	public void fault() {
		planElementState.fault(this);
	}

	@Override
	public PlanElementState getLastBusyState() {
		return lastBusyState;
	}

	@Override
	public void start() {
		planElementState.start(this);
	}



	@SuppressWarnings("unchecked")
	public ItemWithDefinition<T> getItem() {
		return (ItemWithDefinition<T>) getNode();
	}

	@Override
	public void setPlanElementState(PlanElementState s) {
		if (requiresSubscriptionUpdate(s)) {
			getCaseInstance().markSubscriptionsForUpdate();
		}
		this.planElementState = s;
	}

	private boolean requiresSubscriptionUpdate(PlanElementState s) {
		if (getCaseInstance() == null) {
			return false;
		} else if (this.planElementState == PlanElementState.ACTIVE) {
			return s != PlanElementState.ACTIVE;
		} else if (s == PlanElementState.ACTIVE) {
			return this.planElementState != PlanElementState.ACTIVE;
		}
		return false;
	}

	public boolean isCompletionRequired() {
		return isCompletionRequired;
	}

	public boolean isCompletionStillRequired() {
		return isCompletionRequired && !planElementState.isTerminalState() && !planElementState.isSemiTerminalState(this)
				&& !(getItem() instanceof TaskDefinition && !((TaskDefinition) getItem()).isBlocking());
	}

	public void internalSetCompletionRequired(boolean b) {
		this.isCompletionRequired = b;
	}

	@Override
	public void suspend() {
		planElementState.suspend(this);
	}

	public void resume() {
		planElementState.resume(this);
	}

	@Override
	public void terminate() {
		planElementState.terminate(this);
	}

	@Override
	public PlanElementState getPlanElementState() {
		return planElementState;
	}

	@Override
	public CaseInstance getCaseInstance() {
		return (CaseInstance) getProcessInstance();
	}

}