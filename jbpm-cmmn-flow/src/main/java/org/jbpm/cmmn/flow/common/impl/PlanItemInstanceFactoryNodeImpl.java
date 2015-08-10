package org.jbpm.cmmn.flow.common.impl;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.common.PlanItemInstanceFactoryNode;
import org.jbpm.cmmn.flow.definition.RepeatablePlanItemDefinition;
import org.jbpm.workflow.core.node.StateNode;

public class PlanItemInstanceFactoryNodeImpl extends StateNode implements PlanItemInstanceFactoryNode {

	private static final long serialVersionUID = -3811996856528514976L;
	private ItemWithDefinition<? extends RepeatablePlanItemDefinition> planItem;

	public PlanItemInstanceFactoryNodeImpl() {
	}

	public ItemWithDefinition<?> getItemToInstantiate() {
		return planItem;
	}

	public void setItemToInstantiate(ItemWithDefinition<? extends RepeatablePlanItemDefinition> planItem) {
		this.planItem = planItem;
	}
}
