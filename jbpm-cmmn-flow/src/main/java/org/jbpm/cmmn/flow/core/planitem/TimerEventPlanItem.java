package org.jbpm.cmmn.flow.core.planitem;

import org.jbpm.cmmn.flow.core.event.TimerEvent;

public class TimerEventPlanItem extends AbstractPlanItem<TimerEvent> {
	private static final long serialVersionUID = 3392205893370057689L;

	public TimerEventPlanItem() {
	}

	public TimerEventPlanItem(PlanItemInfoImpl<TimerEvent> info) {
		super(info);
	}
}
