package org.jbpm.cmmn.flow.core.planitem;

import org.jbpm.cmmn.flow.core.impl.Milestone;

public class MilestonePlanItem extends AbstractPlanItem<Milestone> implements MultiInstancePlanItem {

	private static final long serialVersionUID = -1183275791860455366L;
	private PlanItemInstanceFactoryNode factoryNode;

	public MilestonePlanItem() {
	}

	public MilestonePlanItem(PlanItemInfoImpl<Milestone> planInfo, PlanItemInstanceFactoryNode planItemInstanceFactoryNode) {
		super(planInfo);
		this.factoryNode = planItemInstanceFactoryNode;
	}

	@Override
	public PlanItemInstanceFactoryNode getFactoryNode() {
		return factoryNode;
	}

}
