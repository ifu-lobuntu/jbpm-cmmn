package org.jbpm.cmmn.flow.planitem.impl;

import org.jbpm.cmmn.flow.common.PlanItemInstanceFactoryNode;
import org.jbpm.cmmn.flow.common.impl.AbstractItem;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.PlanItemControl;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.RepeatablePlanItemDefinition;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.PlanItemInfo;
import org.kie.api.definition.process.Connection;

import java.util.HashMap;
import java.util.List;

public class PlanItemImpl<T extends PlanItemDefinition> extends AbstractItem implements PlanItem<T> {

	private static final long serialVersionUID = -528614791490955918L;
	private String elementId;
	private PlanItemInfoImpl<T> planInfo;
	private PlanItemContainer planItemContainer;
	private String description;
	private PlanItemInstanceFactoryNode factoryNode;


	public PlanItemImpl(PlanItemInfoImpl<T> planInfo) {
		super();
		this.planInfo = planInfo;
	}

	public PlanItemImpl(PlanItemInfoImpl info, PlanItemInstanceFactoryNode factoryNode) {
		this.planInfo=info;
		this.factoryNode=factoryNode;
	}
	public void copyFromDefinition() {
		HashMap<Object, Object> copiedState = new HashMap<Object, Object>();
		T def = getDefinition();
		copiedState.put(def, this);
		copy(copiedState, def, this);
	}
	public PlanItemInstanceFactoryNode getFactoryNode() {
		if(getDefinition() instanceof RepeatablePlanItemDefinition) {
			return factoryNode;
		}else{
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
		return planInfo.getDefinition();
	}

	public final PlanItemContainer getPlanItemContainer() {
		return planItemContainer;
	}

	public final void setPlanItemContainer(PlanItemContainer planItemContainer) {
		this.planItemContainer = planItemContainer;
	}

	@Override
	public final PlanItemControl getItemControl() {
		return planInfo.getItemControl();
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
	public final PlanItemInfo<T> getPlanInfo() {
		return planInfo;
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

}
