package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.workflow.instance.WorkflowProcessInstance;

import java.util.Map;
import java.util.Set;

public interface CaseInstance extends PlanItemInstanceContainer, WorkflowProcessInstance, org.jbpm.cmmn.common.CaseInstance, PlanElementLifecycle {
    void close();

    void markSubscriptionsForUpdate();

    Case getCase();

    String getCaseOwner();

    void reactivate();

    void fault();

    void addRoleAssignment(String name, String owner);

    Map<String, Object> getResult();

    Set<OnPartInstanceSubscription> findOnPartInstanceSubscriptions();
}
