package org.jbpm.cmmn.instance;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.workflow.instance.WorkflowProcessInstance;

public interface CaseInstance extends PlanItemInstanceContainer, WorkflowProcessInstance,org.jbpm.cmmn.common.CaseInstance {
	void close();

	void markSubscriptionsForUpdate();

	Case getCase();

	String getCaseOwner();

	void addRoleAssignment(String name, String owner);

	Collection<String> getRoleAssignments(String idealRoles);

	public abstract Map<String, Object> getResult();

	Set<OnPartInstanceSubscription> findOnPartInstanceSubscriptions();
}
