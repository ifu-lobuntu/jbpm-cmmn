package org.jbpm.cmmn.common;

import java.util.Collection;
import java.util.Set;

import org.jbpm.casemgmt.role.RoleInstance;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.api.runtime.process.WorkItem;

public interface CaseInstance{
	Collection<String> getCaseRoleNames();
	RoleInstance getRoleInstance(String role);
	Collection<ApplicableDiscretionaryItem> getApplicableDiscretionaryItems(long workItemId, Set<String> usersRoles);
	void ensurePlanItemCreated(long workItemId, String discretionaryItemId, WorkItem wi);
	NodeInstance createPlannedItem(long workItemId, String discretionaryItemId);
	PlanningTableContainerInstance findPlanningTableContainerInstance(long workItemId);

}
