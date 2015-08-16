package org.jbpm.cmmn.flow.planitem.impl;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.common.PlanItemInstanceFactoryNode;
import org.jbpm.cmmn.flow.common.impl.AbstractItem;
import org.jbpm.cmmn.flow.common.impl.PlanItemInstanceFactoryNodeImpl;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.impl.PlanItemControlImpl;
import org.jbpm.cmmn.flow.definition.PlanItemControl;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.RepeatablePlanItemDefinition;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.workflow.core.impl.ConnectionImpl;
import org.jbpm.workflow.core.node.EventNodeInterface;
import org.kie.api.definition.process.Connection;
import org.kie.api.definition.process.Node;

import java.util.*;

public class PlanItemImpl<T extends PlanItemDefinition> extends AbstractItem implements PlanItem<T> {

    private static final long serialVersionUID = -528614791490955918L;
    private Map<String, Sentry> entryCriteria = new HashMap<String, Sentry>();
    private Map<String, Sentry> exitCriteria = new HashMap<String, Sentry>();
    private String definitionRef;
    private String elementId;
    private PlanItemControl itemControl;
    private PlanItemContainer planItemContainer;
    private String description;
    private PlanItemInstanceFactoryNode factoryNode;
    private T definition;

    public PlanItemImpl() {
        super();
    }

    @Override
    public boolean acceptsEvent(String type, Object event) {
        return (getDefinition() instanceof EventNodeInterface && ((EventNodeInterface) getDefinition()).acceptsEvent(type, event)) || super.acceptsEvent(type, event);
    }

        @Override
    public Map<String, Sentry> getEntryCriteria() {
        return Collections.unmodifiableMap(entryCriteria);
    }

    @Override
    public Map<String, Sentry> getExitCriteria() {
        return Collections.unmodifiableMap(exitCriteria);
    }

    public void putEntryCriterion(String s, Sentry c) {
        entryCriteria.put(s, c);
    }

    public void putExitCriterion(String s, Sentry c) {
        exitCriteria.put(s, c);
    }

    private PlanItemInstanceFactoryNodeImpl createFactoryNodeIfRequired() {
        if (getDefinition() instanceof RepeatablePlanItemDefinition) {
            PlanItemInstanceFactoryNodeImpl result = new PlanItemInstanceFactoryNodeImpl();
            result.setId(getId() / 34123);
            result.setName(getName() + "Factory");
            getPlanItemContainer().addNode(result);
            return result;
        } else {
            return null;
        }
    }

    public void copyFromDefinition() {
        HashMap<Object, Object> copiedState = new HashMap<Object, Object>();
        T def = getDefinition();
        copiedState.put(def, this);
        copy(copiedState, def, this);
        Node[] nodes = this.getNodes();
        for (Node node : nodes) {
            if (node instanceof PlanItem) {
                ((PlanItem) node).setPlanItemContainer(planItemContainer);
            }
        }
    }

    public PlanItemInstanceFactoryNode getFactoryNode() {
        if (getDefinition() instanceof RepeatablePlanItemDefinition) {
            if(factoryNode==null){
                factoryNode=createFactoryNodeIfRequired();
            }
            return factoryNode;
        } else {
            throw new IllegalStateException("Only Milestones, Stages and Tasks can have a FactoryNode");
        }
    }

    @Override
    public final Connection getFrom() {
        final List<Connection> list = getIncomingConnections(org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public final void validateAddIncomingConnection(final String type, final Connection connection) {
        if (type == null) {
            throw new IllegalArgumentException("Connection type cannot be null");
        }
        if (connection == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        if (!org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE.equals(type)) {
            throw new IllegalArgumentException("This type of node only accepts default incoming connection type!");
        }

    }

    @Override
    public final T getDefinition() {
        return definition;
    }

    public final PlanItemContainer getPlanItemContainer() {
        return planItemContainer;
    }

    public final void setPlanItemContainer(PlanItemContainer planItemContainer) {
        this.planItemContainer = planItemContainer;
        super.setNodeContainer(planItemContainer);
    }

    public void linkPlanItem() {
        Set<Map.Entry<String, Sentry>> entrySet = entryCriteria.entrySet();
        for (Map.Entry<String, Sentry> entry : entrySet) {
            entry.getValue().setPlanItemEntering(this);
            if (getDefinition() instanceof RepeatablePlanItemDefinition) {
                new ConnectionImpl(entry.getValue(), org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE, getFactoryNode(),
                        org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE);
            } else {
                new ConnectionImpl(entry.getValue(), org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE, this, org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE);
            }
        }
        Set<Map.Entry<String, Sentry>> exitSet = exitCriteria.entrySet();
        for (Map.Entry<String, Sentry> entry : exitSet) {
            entry.getValue().setPlanItemExiting(this);
        }
        if (getDefinition() instanceof RepeatablePlanItemDefinition) {
            new ConnectionImpl(getFactoryNode(), org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE, this, org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE);
        }
        if (getDefinition() instanceof RepeatablePlanItemDefinition) {
            getFactoryNode().setItemToInstantiate((ItemWithDefinition<? extends RepeatablePlanItemDefinition>) this);
        }
    }
    public void setDefinition(T findPlanItemDefinition) {
        this.definition = findPlanItemDefinition;
    }

    @Override
    public PlanItemControl getItemControl() {
        if (itemControl == null && definition != null) {
            return definition.getDefaultControl();
        }
        return itemControl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String s) {
        this.description = s;
    }

    public final String getElementId() {
        return elementId;
    }

    public final void setElementId(String elementId) {
        this.elementId = elementId;
    }

    @Override
    public PlanItemControl getEffectiveItemControl() {
        if (getItemControl() == null) {
            return getDefinition().getDefaultControl();
        } else {
            return getItemControl();
        }
    }

    @Override
    public String getPlanItemEventName() {
        return getEffectiveName();
    }

    @Override
    public String getEffectiveName() {
        return getName();
    }

    public void setDefinitionRef(String definitionRef) {
        this.definitionRef = definitionRef;
    }

    public String getDefinitionRef() {
        return definitionRef;
    }

    public void setItemControl(PlanItemControlImpl itemControl) {
        this.itemControl = itemControl;
    }
}
