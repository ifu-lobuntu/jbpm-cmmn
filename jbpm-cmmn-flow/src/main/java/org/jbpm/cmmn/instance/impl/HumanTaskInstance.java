package org.jbpm.cmmn.instance.impl;

import org.drools.core.WorkItemHandlerNotFoundException;
import org.drools.core.process.core.Work;
import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.WorkItemManager;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.definition.HumanTaskDefinition;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.impl.PlannerRoleCalculator;
import org.jbpm.cmmn.instance.HumanTaskLifecycle;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.process.core.context.exception.ExceptionScope;
import org.jbpm.process.instance.context.exception.ExceptionScopeInstance;
import org.jbpm.workflow.instance.WorkflowRuntimeException;
import org.kie.api.runtime.process.NodeInstance;

import java.util.HashMap;

public class HumanTaskInstance extends ControllableItemInstanceImpl<HumanTaskDefinition> implements PlanningTableContainerInstance, HumanTaskLifecycle {

    private static final long serialVersionUID = 8452936237272366757L;
    protected WorkItem workItem;
    private long workItemId = -1;
    private transient boolean signalFromTask = false;

    @Override
    public void internalTrigger(NodeInstance from, String type) {
        super.internalTrigger(from, type);
        workItem = createWorkItem(getItem().getDefinition().getWork());
        if (getItem().getDefinition().isBlocking()) {
            addWorkItemUpdatedListener();
        }
        executeWorkItem(workItem);
        this.workItemId = workItem.getId();
        noteInstantiation();
        if (!getItem().getDefinition().isBlocking()) {
            triggerCompleted();
        }
    }

    @Override
    public void addEventListeners() {
        super.addEventListeners();
        addWorkItemUpdatedListener();
    }

    @Override
    public String[] getEventTypes() {
        return new String[]{WorkItemParameters.WORK_ITEM_UPDATED};
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
            workItem = ((WorkItemManager) getProcessInstance().getKnowledgeRuntime().getWorkItemManager()).getWorkItem(workItemId);
        }
        return this.workItem;
    }

    public void noteInstantiation() {
        if (isCompletionRequired == null) {
            isCompletionRequired = ExpressionUtil.isRequired(getItem(), this);
        }
        if (isActivatedManually()) {
            enable();
        } else {
            start();
        }
    }

    @Override
    public void enable() {
        super.enable();
        triggerTransitionOnTask(PlanItemTransition.ENABLE);
    }

    @Override
    public void start() {
        super.start();
        triggerTransitionOnTask(PlanItemTransition.START);
    }

    @Override
    public void manualStart() {
        super.manualStart();
        triggerTransitionOnTask(PlanItemTransition.MANUAL_START);
    }

    @Override
    public void reactivate() {
        super.reactivate();
        triggerTransitionOnTask(PlanItemTransition.REACTIVATE);
    }

    @Override
    public void fault() {
        super.fault();
        triggerTransitionOnTask(PlanItemTransition.FAULT);
    }

    @Override
    public void exit() {
        super.exit();
        triggerTransitionOnTask(PlanItemTransition.EXIT);
    }

    @Override
    public void disable() {
        super.disable();
        triggerTransitionOnTask(PlanItemTransition.DISABLE);
    }

    @Override
    public void reenable() {
        super.reenable();
        triggerTransitionOnTask(PlanItemTransition.REENABLE);
    }

    @Override
    public void complete() {
        super.complete();
        triggerTransitionOnTask(PlanItemTransition.EXIT);
    }

    @Override
    public void parentSuspend() {
        super.parentSuspend();
        triggerTransitionOnTask(PlanItemTransition.PARENT_SUSPEND);
    }

    @Override
    public void parentResume() {
        super.parentResume();
        triggerTransitionOnTask(PlanItemTransition.PARENT_RESUME);
    }

    @Override
    public void create() {
        super.create();
        triggerTransitionOnTask(PlanItemTransition.CREATE);
    }

    @Override
    public void suspend() {
        super.suspend();
        triggerTransitionOnTask(PlanItemTransition.SUSPEND);
    }

    @Override
    public void resume() {
        super.resume();
        triggerTransitionOnTask(PlanItemTransition.RESUME);
    }

    @Override
    public void terminate() {
        super.terminate();
        triggerTransitionOnTask(PlanItemTransition.TERMINATE);
    }

    private final void triggerTransitionOnTask(PlanItemTransition transition) {
        if (!signalFromTask) {
            WorkItemImpl wi = new WorkItemImpl();
            wi.setProcessInstanceId(this.getProcessInstance().getId());
            String deploymentId = (String) getProcessInstance().getKnowledgeRuntime().getEnvironment().get("deploymentId");
            wi.setDeploymentId(deploymentId);
            wi.setName(WorkItemParameters.UPDATE_TASK_STATUS);
            wi.setParameter(WorkItemParameters.TASK_TRANSITION, transition);
            wi.setParameter(WorkItemParameters.WORK_ITEM_ID, getWorkItemId());
            wi.setParameter(WorkItemParameters.ACTOR_ID, getIdealOwner());
            wi.setParameter(WorkItemParameters.USERS_IN_ROLE, getCaseInstance().getRoleInstance(getItem().getDefinition().getPerformer().getName()).getRoleAssignmentNames());
            wi.setParameter(WorkItemParameters.GROUP_ID, getItem().getDefinition().getPerformer().getName());
            wi.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, getBusinessAdministrators());
            executeWorkItem(wi);
        }
    }

    public final WorkItemImpl createWorkItem(Work work) {
        HumanTaskDefinition definition = this.getItem().getDefinition();
        WorkItemImpl workItem = new WorkItemImpl();
        workItem.setName(work.getName());
        workItem.setProcessInstanceId(this.getProcessInstance().getId());
        workItem.setParameters(new HashMap<String, Object>(work.getParameters()));
        workItem.getParameters().putAll(ExpressionUtil.buildInputParameters(work, this, definition));
        workItem.setParameter(WorkItemParameters.TASK_NODE_NAME, getItem().getName());
        workItem.setParameter(WorkItemParameters.TASK_PLAN_ITEM_NAME, getItem().getName());
        workItem.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, getBusinessAdministrators());
        workItem.setParameter(WorkItemParameters.INITIATOR, getCaseInstance().getCaseOwner());
        workItem.setParameter(WorkItemParameters.ACTOR_ID, getIdealOwner());
        workItem.setParameter(WorkItemParameters.GROUP_ID, getItem().getDefinition().getPerformer().getName());
        workItem.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, getBusinessAdministrators());
        String deploymentId = (String) getProcessInstance().getKnowledgeRuntime().getEnvironment().get("deploymentId");
        workItem.setDeploymentId(deploymentId);
        workItem.setParameter(WorkItemParameters.COMMENT, definition.getDescription());
        if (this.getCaseInstance().getVariable("workItemId") != null) {
            workItem.setParameter(WorkItemParameters.PARENT_WORK_ITEM_ID, this.getCaseInstance().getVariable("workItemId"));
        }
        workItem.setParameter(WorkItemParameters.CLAIM_IMMEDIATELY, false);
        return workItem;
    }

    protected String getBusinessAdministrators() {
        ItemWithDefinition<?> item = getItem();
        if (item instanceof PlanItem) {
            return PlannerRoleCalculator.getPlannerRoles((PlanItem<?>) item);
        } else {
            return PlannerRoleCalculator.getPlannerRoles((DiscretionaryItem<?>) item);
        }
    }

    @Override
    public long getWorkItemId() {
        if (this.workItem != null) {
            return workItem.getId();
        }
        return workItemId;
    }

    private String getIdealOwner() {
        if (isActivatedManually()) {
            // Let the role do the assignment
            return null;
        } else {
            // need to find someone
            // TODO think this through - should be done in the WorkItemHandler rather
            String[] roleAssignments = getCaseInstance().getRoleInstance(getItem().getDefinition().getPerformer().getName()).getRoleAssignmentNames();
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
            signalFromTask = true;
            transition.invokeOn(this);
            signalFromTask = false;
            String owner = (String) wi.getResult(WorkItemParameters.ACTUAL_OWNER);
            if (owner != null) {
                getCaseInstance().addRoleAssignment(getItem().getDefinition().getPerformer().getName(), owner);
            }
        } else {
            super.signalEvent(type, event);
        }
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
    public NodeInstance getPlanningContextNodeInstance() {
        return this;
    }


    @Override
    public void resumeAfterPlanning() {
        PlanItemInstanceContainer pic = (PlanItemInstanceContainer) getNodeInstanceContainer();
        pic.resumeAfterPlanning();
    }

    public WorkItem executeWorkItem(WorkItem wi) {
        if (isInversionOfControl()) {
            getProcessInstance().getKnowledgeRuntime().update(
                    getProcessInstance().getKnowledgeRuntime().getFactHandle(this), this);
        } else {
            try {
                ((WorkItemManager) getProcessInstance().getKnowledgeRuntime().getWorkItemManager()).internalExecuteWorkItem(wi);
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
        return getItem().getDefinition().getWork();
    }
}
