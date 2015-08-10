package org.jbpm.cmmn.flow.planitem.impl;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.planitem.OnPart;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.node.Join;
import org.kie.api.definition.process.Connection;

import java.util.ArrayList;
import java.util.List;

public class SentryImpl extends Join implements Sentry {
	private static final long serialVersionUID = -3568385090236274366L;
	private List<OnPart> onParts = new ArrayList<OnPart>();
	private String elementId;
	private Constraint condition;
	private ItemWithDefinition<?> planItemExiting;
	private ItemWithDefinition<?> planItemEntering;
	private boolean exitsCase;

	public SentryImpl() {
		setType(TYPE_AND);
	}

	@Override
	public Constraint getCondition() {
		return condition;
	}

	@Override
	public void addOnPart(OnPart onPart) {
		this.onParts.add(onPart);
	}

	@Override
	public void setCondition(Constraint condition) {
		this.condition = condition;
	}

	@Override
	public void validateAddIncomingConnection(String type, Connection connection) {
		super.validateAddIncomingConnection(type, connection);
	}

	@Override
	public List<OnPart> getOnParts() {
		return onParts;
	}

	@Override
	public String getElementId() {
		return elementId;
	}

	@Override
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	@Override
	public void setPlanItemExiting(ItemWithDefinition<?> planItem) {
		planItemExiting = planItem;
	}

	@Override
	public ItemWithDefinition<?> getPlanItemExiting() {
		return planItemExiting;
	}

	@Override
	public ItemWithDefinition<?> getPlanItemEntering() {
		return planItemEntering;
	}

	@Override
	public void setPlanItemEntering(ItemWithDefinition<?> planItemEntering) {
		this.planItemEntering = planItemEntering;
	}

	@Override
	public PlanItemContainer getPlanItemContainer() {
		if (planItemEntering != null) {
			return planItemEntering.getPlanItemContainer();
		}
		if (planItemExiting != null) {
			return planItemExiting.getPlanItemContainer();
		}
		return null;
	}

	@Override
	public boolean isExitsCase() {
		return exitsCase;
	}

	@Override
	public void setExitsCase(boolean exitsCase) {
		this.exitsCase = exitsCase;
	}

}
