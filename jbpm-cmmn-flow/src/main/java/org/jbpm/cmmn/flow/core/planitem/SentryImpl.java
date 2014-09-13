package org.jbpm.cmmn.flow.core.planitem;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.cmmn.flow.core.ItemWithDefinition;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.Sentry;
import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.node.Join;
import org.kie.api.definition.process.Connection;

public class SentryImpl extends Join implements Sentry {
	private static final long serialVersionUID = -3568385090236274366L;
	private List<AbstractOnPart> onParts = new ArrayList<AbstractOnPart>();
	private String elementId;
	private Constraint condition;
	private ItemWithDefinition<?> planItemExiting;
	private ItemWithDefinition<?> planItemEntering;
	private boolean exitsCase;

	public SentryImpl() {
		setType(TYPE_AND);
	}

	public Constraint getCondition() {
		return condition;
	}

	public void addOnPart(AbstractOnPart onPart) {
		this.onParts.add(onPart);
	}

	public void setCondition(Constraint condition) {
		this.condition = condition;
	}

	@Override
	public void validateAddIncomingConnection(String type, Connection connection) {
		super.validateAddIncomingConnection(type, connection);
	}

	public List<AbstractOnPart> getOnParts() {
		return onParts;
	}

	@Override
	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public void setPlanItemExiting(ItemWithDefinition<?> planItem) {
		planItemExiting = planItem;
	}

	public ItemWithDefinition<?> getPlanItemExiting() {
		return planItemExiting;
	}

	public ItemWithDefinition<?> getPlanItemEntering() {
		return planItemEntering;
	}

	public void setPlanItemEntering(ItemWithDefinition<?> planItemEntering) {
		this.planItemEntering = planItemEntering;
	}

	public PlanItemContainer getPlanItemContainer() {
		if (planItemEntering != null) {
			return planItemEntering.getPlanItemContainer();
		}
		if (planItemExiting != null) {
			return planItemExiting.getPlanItemContainer();
		}
		return null;
	}

	public boolean isExitsCase() {
		return exitsCase;
	}

	public void setExitsCase(boolean exitsCase) {
		this.exitsCase = exitsCase;
	}

}
