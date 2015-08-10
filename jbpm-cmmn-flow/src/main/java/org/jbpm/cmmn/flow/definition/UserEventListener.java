package org.jbpm.cmmn.flow.definition;

import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;

import java.util.Collection;


public interface UserEventListener extends PlanItemDefinition {
    void putAuthorizedRole(String id, CaseRoleImpl role);

    Collection<CaseRole> getAuthorizedRoles();

    String getEventName();

    void setEventName(String eventName);
}
