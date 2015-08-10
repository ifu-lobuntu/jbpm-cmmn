package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.common.impl.PlanItemStandardEventNode;
import org.jbpm.cmmn.flow.definition.PlanItemStartTrigger;

public class PlanItemStartTriggerImpl extends PlanItemStandardEventNode implements PlanItemStartTrigger{
	private static final long serialVersionUID = 1602328317980746322L;

	@Override
	public AbstractStandardEventNode copy() {
		PlanItemStartTriggerImpl result = new PlanItemStartTriggerImpl();
		result.setId(getId());
		result.setName(getName());
		result.setStandardEvent(getStandardEvent());
		result.setSourcePlanItem(getSourcePlanItem());
		result.setSourceRef(getSourceRef());
		return result;
	}
}
