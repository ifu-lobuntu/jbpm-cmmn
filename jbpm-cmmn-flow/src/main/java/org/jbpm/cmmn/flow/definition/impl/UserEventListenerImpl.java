package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserEventListenerImpl extends AbstractPlanItemDefinition implements org.jbpm.cmmn.flow.definition.UserEventListener {

	private static final long serialVersionUID = 1144314141L;
	private String eventName;
	private Map<String, CaseRole> authorizedRoles = new HashMap<String, CaseRole>();

	@Override
	public boolean acceptsEvent(String type, Object event) {
		return type.equals(getEventName()) || super.acceptsEvent(type, event);
	}

	@Override
	public void putAuthorizedRole(String id, CaseRoleImpl role) {
		authorizedRoles.put(id, role);
	}

	@Override
	public Collection<CaseRole> getAuthorizedRoles() {
		return authorizedRoles.values();
	}

	@Override
	public String getEventName() {
		return eventName;
	}

	@Override
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
