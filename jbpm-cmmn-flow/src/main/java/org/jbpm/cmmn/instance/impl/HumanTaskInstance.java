package org.jbpm.cmmn.instance.impl;

import org.drools.core.WorkItemHandlerNotFoundException;
import org.drools.core.process.core.Work;
import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.WorkItemManager;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.impl.CaseParameterImpl;
import org.jbpm.cmmn.flow.definition.HumanTaskDefinition;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.TaskDefinition;
import org.jbpm.cmmn.flow.definition.impl.HumanTaskDefinitionImpl;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.instance.*;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;
import org.jbpm.cmmn.instance.subscription.impl.EventQueues;
import org.jbpm.process.core.context.exception.ExceptionScope;
import org.jbpm.process.instance.ProcessInstance;
import org.jbpm.process.instance.context.exception.ExceptionScopeInstance;
import org.jbpm.workflow.instance.WorkflowRuntimeException;
import org.kie.api.runtime.process.NodeInstance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HumanTaskInstance extends ControllableItemInstanceImpl<HumanTaskDefinition> implements PlanningTableContainerInstance, HumanTaskLifecycle {

    private static final long serialVersionUID = 8452936237272366757L;
    protected WorkItem workItem;
    private long workItemId;
    private Work work;

    protected boolean isWaitForCompletion() {
        return super.getItem().getDefinition().isBlocking();
    }

    @Override
    protected String getIdealRoles() {
        ItemWithDefinition<HumanTaskDefinition> item = getItem();
        return item.getDefinition().getPerformer().getName();
    }


    @Override
    public void internalTrigger(NodeInstance from, String type) {
        super.internalTrigger(from, type);
        workItem = createWorkItem(getItem().getDefinition().getWork());
        if (isBlocking()) {
            addWorkItemUpdatedListener();
        }
        executeWorkItem(workItem);
        this.workItemId = workItem.getId();
        noteInstantiation();
        if (!isBlocking()) {
            triggerCompleted();
        }
    }

    @Override
    public void addEventListeners() {
        super.addEventListeners();
        addWorkItemUpdatedListener();
    }

    private void addWorkItemUpdatedListener() {
        getProcessInstance().addEventListener(WorkItemParameters.WORK_ITEM_UPDATED, this, false);
    }

    @Override
    public void removeEventListeners() {
        super.removeEventListeners();
        getProcessInstance().removeEventListener(WorkItemParameters.WORK_ITEM_UPDATED, this, false);
    }

    protected boolean isMyWorkItem(WorkItem event) {
        return event.getId() == getWorkItemId() || (getWorkItemId() == -1 && getWorkItem().getId() == (event.getId()));
    }

    @Override
    public WorkItem getWorkItem() {
        if (this.workItem == null) {
            workItem = ((WorkItemManager) ((ProcessInstance) getProcessInstance()).getKnowledgeRuntime().getWorkItemManager()).getWorkItem(workItemId);
        }
        return this.workItem;
    }

    public void noteInstantiation() {
        if (isCompletionRequired == null) {
            isCompletionRequired = ExpressionUtil.isRequired(getItem(), this);
        }
        if (isActivatedManually()) {
            triggerTransitionOnTask(PlanItemTransition.ENABLE);
        } else {
            triggerTransitionOnTask(PlanItemTransition.START);
        }
    }

    @Override
    public final void triggerTransitionOnTask(PlanItemTransition transition) {
        WorkItemImpl wi = new WorkItemImpl();
        wi.setProcessInstanceId(this.getProcessInstance().getId());
        String deploymentId = (String) getProcessInstance().getKnowledgeRuntime().getEnvironment().get("deploymentId");
        wi.setDeploymentId(deploymentId);
        wi.setName(WorkItemParameters.UPDATE_TASK_STATUS);
        wi.setParameter(WorkItemParameters.TASK_TRANSITION, transition);
        wi.setParameter(WorkItemParameters.WORK_ITEM_ID, getWorkItemId());
        if (getItem().getName().equals("TheAutoActivatedTaskPlanItem")) {
            System.out.println();
        }

        wi.setParameter(WorkItemParameters.ACTOR_ID, getIdealOwner());
        wi.setParameter(WorkItemParameters.USERS_IN_ROLE, getCaseInstance().getRoleInstance(getIdealRoles()).getRoleAssignmentNames());
        wi.setParameter(WorkItemParameters.GROUP_ID, getIdealRoles());
        wi.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, getBusinessAdministrators());
        wi.getParameters().putAll(buildParametersFor(transition));
        //TODO this is not reliable
        EventQueues.queueWorkItem(wi);
//		executeWorkItem(wi);
    }

    public final WorkItemImpl createWorkItem(Work work) {
        PlanItemDefinition definition = this.getItem().getDefinition();
        WorkItemImpl workItem = new WorkItemImpl();
        workItem.setName(work.getName());
        workItem.setProcessInstanceId(this.getProcessInstance().getId());
        workItem.setParameters(new HashMap<String, Object>(work.getParameters()));
        if (definition instanceof TaskDefinition) {
            workItem.getParameters().putAll(ExpressionUtil.buildInputParameters(work, this, (TaskDefinition) definition));
        }
        workItem.setParameter(WorkItemParameters.INITIATOR, getInitiator());
        workItem.setParameter(WorkItemParameters.ACTOR_ID, getIdealOwner());
        workItem.setParameter(WorkItemParameters.GROUP_ID, getIdealRoles());
        workItem.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, getBusinessAdministrators());
        String deploymentId = (String) getProcessInstance().getKnowledgeRuntime().getEnvironment().get("deploymentId");
        workItem.setDeploymentId(deploymentId);
        workItem.setParameter(WorkItemParameters.COMMENT, definition.getDescription());
        if (this.getCaseInstance().getVariable("workItemId")!=null) {
            workItem.setParameter(WorkItemParameters.PARENT_WORK_ITEM_ID, this.getCaseInstance().getVariable("workItemId"));
        }
        workItem.setParameter(WorkItemParameters.CLAIM_IMMEDIATELY, false);
        return workItem;
    }

    @Override
    public long getWorkItemId() {
        if (this.workItem != null) {
            return workItem.getId();
        }
        return workItemId;
    }

    @Override
    protected String getIdealOwner() {
        if (isActivatedManually()) {
            // Let the role do the assignment
            return null;
        } else {
            // need to find someone
            // TODO think this through - should be done in the WorkItemHandler rather
            String[] roleAssignments = getCaseInstance().getRoleInstance(getIdealRoles()).getRoleAssignmentNames();
            if (roleAssignments.length == 1) {
                return roleAssignments[0];
            } else {
                return null;
            }
        }
    }

    public void internalTriggerWithoutInstantiation(NodeInstance from, String type, WorkItem wi) {
        this.workItem = wi;
        this.workItemId = wi.getId();
        this.planElementState = PlanElementState.INITIAL;
    }

    @Override
    public void signalEvent(String type, Object event) {
        if (type.equals(WorkItemParameters.WORK_ITEM_UPDATED) && isMyWorkItem((WorkItem) event)) {
            WorkItem wi = (WorkItem) event;
            this.workItem = (WorkItem) event;
            PlanItemTransition transition = (PlanItemTransition) wi.getResult(WorkItemParameters.TRANSITION);
            if (isCompletionTransition(transition)) {
                for (CaseParameter cp : getItem().getDefinition().getOutputs()) {
                    Object val = wi.getResult(cp.getName());
                    if (val != null) {
                        writeToBinding(cp, val);
                    }
                }
            }
            transition.invokeOn(this);
            String owner = (String) wi.getResult(WorkItemParameters.ACTUAL_OWNER);
            if (owner != null) {
                getCaseInstance().addRoleAssignment(getItem().getDefinition().getPerformer().getName(), owner);
            }
        }
        super.signalEvent(type, event);
    }

    private boolean isCompletionTransition(PlanItemTransition transition) {
        boolean isCompletionTransition1 = transition == PlanItemTransition.COMPLETE || transition == PlanItemTransition.EXIT
                || transition == PlanItemTransition.FAULT;
        return isCompletionTransition1;
    }

    @Override
    public Object getTask() {
        if (getWorkItem() != null) {
            return (Object) getWorkItem().getResult(WorkItemParameters.TASK);
        }
        return null;
    }

    public void internalSetWorkItemId(long readLong) {
        this.workItemId = readLong;
    }

    /*********
     * PlanningTableContainner implementation
     *******/

    @Override
    public PlanningTable getPlanningTable() {
        return super.getItem().getDefinition().getPlanningTable();
    }


    @Override
    public PlanItemInstanceContainer getPlanItemInstanceCreator() {
        return (PlanItemInstanceContainer) getNodeInstanceContainer();
    }

    @Override
    public ControllableItemInstance<?> ensurePlanItemCreated(String discretionaryItemId, WorkItem wi) {
        return PlanningTableContainerInstanceUtil.ensurePlanItemCreated(this, discretionaryItemId, wi);
    }

    @Override
    public void addApplicableItems(Map result, Set usersRoles) {
        PlanningTableContainerInstanceUtil.addApplicableItems(this, result, usersRoles);
    }

    @Override
    public NodeInstance getPlanningContextNodeInstance() {
        return this;
    }

    @Override
    public NodeInstance createPlannedItem(String tableItemId) {
        return PlanningTableContainerInstanceUtil.createPlannedTask(this, tableItemId);
    }

    @Override
    public void makeDiscretionaryItemAvailable(String discretionaryItemId) {
        PlanningTableContainerInstanceUtil.makeDiscretionaryItemAvailable(this, discretionaryItemId);
    }

    @Override
    public void resumeAfterPlanning() {
        PlanItemInstanceContainer pic = (PlanItemInstanceContainer) getNodeInstanceContainer();
        pic.resumeAfterPlanning();
    }

    public WorkItem executeWorkItem(WorkItem wi) {
        if (isInversionOfControl()) {
            ((ProcessInstance) getProcessInstance()).getKnowledgeRuntime().update(
                    ((ProcessInstance) getProcessInstance()).getKnowledgeRuntime().getFactHandle(this), this);
        } else {
            try {
                ((WorkItemManager) ((ProcessInstance) getProcessInstance()).getKnowledgeRuntime().getWorkItemManager()).internalExecuteWorkItem(wi);
            } catch (WorkItemHandlerNotFoundException wihnfe) {
                getProcessInstance().setState(org.kie.api.runtime.process.ProcessInstance.STATE_ABORTED);
                throw wihnfe;
            } catch (Exception e) {
                e.printStackTrace();
                String exceptionName = e.getClass().getName();
                ExceptionScopeInstance exceptionScopeInstance = (ExceptionScopeInstance) resolveContextInstance(ExceptionScope.EXCEPTION_SCOPE, exceptionName);
                if (exceptionScopeInstance == null) {
                    throw new WorkflowRuntimeException(this, getProcessInstance(), "Unable to execute Action: " + e.getMessage(), e);
                }
                this.workItemId = wi.getId();
                exceptionScopeInstance.handleException(exceptionName, e);
            }
        }
        return wi;
    }

    public Work getWork() {
        return work;
    }
}
