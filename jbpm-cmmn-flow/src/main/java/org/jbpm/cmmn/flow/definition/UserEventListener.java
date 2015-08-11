package org.jbpm.cmmn.flow.definition;

import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;
import org.jbpm.workflow.core.node.EventNodeInterface;

import java.util.Collection;


public interface UserEventListener extends PlanItemDefinition,EventNodeInterface {
    void putAuthorizedRole(String id, CaseRoleImpl role);

    Collection<CaseRole> getAuthorizedRoles();

    String getEventName();

    void setEventName(String eventName);
}
