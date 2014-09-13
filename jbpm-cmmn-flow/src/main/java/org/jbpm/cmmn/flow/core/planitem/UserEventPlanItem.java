package org.jbpm.cmmn.flow.core.planitem;

import org.jbpm.cmmn.flow.core.event.UserEvent;

public class UserEventPlanItem extends AbstractPlanItem<UserEvent> {
	private static final long serialVersionUID = 3392205893370057689L;

	public UserEventPlanItem() {

	}

	public UserEventPlanItem(PlanItemInfoImpl<UserEvent> info) {
		super(info);
	}

	public boolean acceptsEvent(String type, Object event) {
		return getDefinition().getEventName().equals(type);
	}

}
