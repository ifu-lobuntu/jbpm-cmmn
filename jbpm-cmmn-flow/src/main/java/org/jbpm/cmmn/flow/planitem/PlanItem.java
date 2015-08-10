package org.jbpm.cmmn.flow.planitem;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.workflow.core.Node;
import org.jbpm.workflow.core.NodeContainer;

public interface PlanItem<T extends PlanItemDefinition> extends NodeContainer,Node, ItemWithDefinition<T> {
	PlanItemContainer getPlanItemContainer();

	void setPlanItemContainer(PlanItemContainer pic);

	public abstract void setElementId(String elementId);

	@Override
	public abstract String getElementId();

	PlanItemInfo<T> getPlanInfo();

	String getDescription();

	void copyFromDefinition();

}
