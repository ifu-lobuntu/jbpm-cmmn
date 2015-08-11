package org.jbpm.cmmn.common;

import org.jbpm.casemgmt.role.RoleInstance;

import java.util.Collection;

public interface CaseInstance{
	Collection<String> getCaseRoleNames();
	RoleInstance getRoleInstance(String role);

}
