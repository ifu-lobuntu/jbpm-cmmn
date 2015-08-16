package org.jbpm.cmmn.instance.impl;

import org.jbpm.process.core.Context;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.process.instance.ContextInstanceContainer;
import org.jbpm.process.instance.ContextableInstance;
import org.jbpm.process.instance.ProcessInstance;
import org.jbpm.process.instance.context.variable.VariableScopeInstance;
import org.jbpm.workflow.instance.NodeInstance;

import java.util.Map;

/**
 * This class achieves two goals
 * 1. to make "special" variables available from the environment, such as the current event
 * 2. to resolve variables from the correct scope at the instance level
 * It serves as a wrapper around the current set of VariableScopes that are in scope, but should never be Marshalled, as it is an incomplete implementation
 *
 * @author ampie
 */
public final class CustomVariableScopeInstance extends VariableScopeInstance {
    private static final long serialVersionUID = 6026168560982471308L;
    private ControllableItemInstanceImpl<?> node;

    public CustomVariableScopeInstance(ControllableItemInstanceImpl<?> nodeImpl) {
        this.node = nodeImpl;
    }
    @Override
    public String getContextType() {
        return VariableScope.VARIABLE_SCOPE;
    }


    @Override
    public ProcessInstance getProcessInstance() {
        return node.getProcessInstance();
    }

    @Override
    public Object getVariable(String name) {
        if (name.equals("currentEvent")) {
            return SentryInstance.getCurrentEvents().iterator().next();
        }
        if (name.equals("currentEvents")) {
            return SentryInstance.getCurrentEvents();
        }
        return resolveVariableUpward(name, this.node);
    }

    protected Object resolveVariableUpward(String name, ContextableInstance contextInstanceContainer) {
        VariableScopeInstance scopeInstance = (VariableScopeInstance) contextInstanceContainer.getContextInstance(VariableScope.VARIABLE_SCOPE);
        Object value = scopeInstance.getVariable(name);
        if (value == null) {
            if (scopeInstance.getVariableScope().findVariable(name) == null) {
                //not defined in this scope, go up
                if (contextInstanceContainer instanceof NodeInstance) {
                    NodeInstance ni = (NodeInstance) contextInstanceContainer;
                    if (ni.getNodeInstanceContainer() instanceof ContextableInstance) {
                        return resolveVariableUpward(name, (ContextableInstance) ni.getNodeInstanceContainer());
                    }
                }
            }
            return null;
        } else {
            return value;
        }
    }
    @Override
    public void setContextId(long contextId) {
        throw new IllegalStateException();
    }

    @Override
    public ContextInstanceContainer getContextInstanceContainer() {
        throw new IllegalStateException();
    }

    @Override
    public Context getContext() {
        throw new IllegalStateException();
    }


    @Override
    public Map<String, Object> getVariables() {
        throw new IllegalStateException();
    }

    @Override
    public void setProcessInstance(ProcessInstance processInstance) {
        throw new IllegalStateException();
    }

    @Override
    public void setVariable(String name, Object value) {
        throw new IllegalStateException();
    }

    @Override
    public void internalSetVariable(String name, Object value) {
        throw new IllegalStateException();
    }

    @Override
    public VariableScope getVariableScope() {
        throw new IllegalStateException();
    }

    @Override
    public void setContextInstanceContainer(ContextInstanceContainer contextInstanceContainer) {
        throw new IllegalStateException();
    }
}