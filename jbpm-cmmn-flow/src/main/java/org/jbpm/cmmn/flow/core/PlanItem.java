package org.jbpm.cmmn.flow.core;

import org.jbpm.workflow.core.Node;

public interface PlanItem<T extends PlanItemDefinition> extends Node, ItemWithDefinition<T> {
	PlanItemContainer getPlanItemContainer();

	void setPlanItemContainer(PlanItemContainer pic);

	public abstract void setElementId(String elementId);

	@Override
	public abstract String getElementId();

	PlanItemInfo<T> getPlanInfo();

	String getDescription();

}
