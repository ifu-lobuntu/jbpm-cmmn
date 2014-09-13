package org.jbpm.cmmn.flow.core.event;

import org.jbpm.cmmn.flow.core.planitem.AbstractOnPart;
import org.jbpm.cmmn.flow.core.planitem.PlanItemOnPart;

public class PlanItemStartTrigger extends PlanItemOnPart {
	private static final long serialVersionUID = 1602328317980746322L;

	@Override
	public AbstractOnPart copy() {
		PlanItemStartTrigger result = new PlanItemStartTrigger();
		result.setId(getId());
		result.setName(getName());
		result.setStandardEvent(getStandardEvent());
		result.setSourcePlanItem(getSourcePlanItem());
		result.setSourceRef(getSourceRef());
		return result;
	}
}
