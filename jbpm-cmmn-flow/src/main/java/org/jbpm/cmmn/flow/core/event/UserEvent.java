package org.jbpm.cmmn.flow.core.event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.task.AbstractPlanItemDefinition;

public class UserEvent extends AbstractPlanItemDefinition {

	private static final long serialVersionUID = 1144314141L;
	private String eventName;
	private Map<String, CaseRole> authorizedRoles = new HashMap<String, CaseRole>();

	public void putAuthorizedRole(String id, CaseRole role) {
		authorizedRoles.put(id, role);
	}

	public Collection<CaseRole> getAuthorizedRoles() {
		return authorizedRoles.values();
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
