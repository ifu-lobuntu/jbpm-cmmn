package org.jbpm.cmmn.instance.impl;

import java.util.HashMap;
import java.util.Map;

import org.drools.core.WorkItemHandlerNotFoundException;
import org.drools.core.process.core.Work;
import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.WorkItemManager;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.PlanItem;
import org.jbpm.cmmn.flow.core.PlanItemDefinition;
import org.jbpm.cmmn.flow.core.PlanItemTransition;
import org.jbpm.cmmn.flow.core.TaskDefinition;
import org.jbpm.cmmn.flow.core.TaskItemWithDefinition;
import org.jbpm.cmmn.flow.core.impl.PlannerRoleCalculator;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.ControllableItemInstance;
import org.jbpm.cmmn.instance.PlanElementLifecycleWithTask;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.cmmn.instance.subscription.impl.AbstractDurableSubscriptionManager;
import org.jbpm.cmmn.instance.subscription.impl.EventQueues;
import org.jbpm.process.core.context.exception.ExceptionScope;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.process.instance.ContextInstance;
import org.jbpm.process.instance.ProcessInstance;
import org.jbpm.process.instance.context.exception.ExceptionScopeInstance;
import org.jbpm.workflow.instance.WorkflowRuntimeException;
import org.jbpm.workflow.instance.node.CompositeContextNodeInstance;
import org.kie.api.runtime.process.NodeInstance;

public abstract class ControllableItemInstanceImpl<T extends PlanItemDefinition, X extends TaskItemWithDefinition<T>> extends CompositeContextNodeInstance
		implements ControllableItemInstance<T> {

	private static final long serialVersionUID = 3200294767777991641L;

	private PlanElementState lastBusyState = PlanElementState.NONE;
	protected WorkItem workItem;
	private long workItemId;
	protected PlanElementState planElementState = PlanElementState.AVAILABLE;
	protected Boolean isCompletionRequired;

	public ControllableItemInstanceImpl() {
		super();
	}

	protected abstract String getIdealRoles();

	public org.jbpm.workflow.instance.NodeInstance getFirstNodeInstance(final long nodeId) {
		// level logic not relevant.
		for (NodeInstance ni : this.getNodeInstances()) {
			if (ni.getNodeId() == nodeId) {
				return (org.jbpm.workflow.instance.NodeInstance) ni;
			}
		}
		return null;
	}

	protected String getIdealOwner() {
		if (isActivatedManually()) {
			return null;
		} else {
			return getCaseInstance().getCaseOwner();
		}
	}

	public boolean isActivatedManually() {
		return ExpressionUtil.isActivatedManually(this, this.getItem());
	}

	protected String getInitiator() {
		// by this time a case MUST have an owner
		return getCaseInstance().getCaseOwner();
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
		if (this.getNodeInstanceContainer() instanceof PlanElementLifecycleWithTask) {
			long parentWorkItemId = ((PlanElementLifecycleWithTask) this.getNodeInstanceContainer()).getWorkItemId();
			if (parentWorkItemId >= 0) {
				workItem.setParameter(WorkItemParameters.PARENT_WORK_ITEM_ID, parentWorkItemId);
			}
		}
		workItem.setParameter(WorkItemParameters.CLAIM_IMMEDIATELY, false);
		return workItem;
	}

	protected String getBusinessAdministrators() {
		TaskItemWithDefinition<T> item = getItem();
		if (item instanceof PlanItem) {
			return PlannerRoleCalculator.getPlannerRoles((PlanItem<?>) item);
		} else {
			return PlannerRoleCalculator.getPlannerRoles((DiscretionaryItemImpl<?>) item);
		}
	}

	protected boolean isBlocking() {
		return true;
	}

	@Override
	public boolean isComplexLifecycle() {
		return true;
	}

	@Override
	public void parentTerminate() {
		throw new IllegalStateException("Complex planItemInstances do not support to parentTerminate");
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
		wi.setParameter(WorkItemParameters.ACTOR_ID, getIdealOwner());
		wi.setParameter(WorkItemParameters.USERS_IN_ROLE, getCaseInstance().getRoleAssignments(getIdealRoles()));
		wi.setParameter(WorkItemParameters.GROUP_ID, getIdealRoles());
		wi.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, getBusinessAdministrators());
		wi.getParameters().putAll(buildParametersFor(transition));
		//TODO this is not reliable
		EventQueues.queueWorkItem(wi);
		// executeWorkItem(wi);
	}

	protected Map<String, Object> buildParametersFor(PlanItemTransition transition) {
		return new HashMap<String, Object>();
	}

	public void internalTriggerWithoutInstantiation(NodeInstance from, String type, WorkItem wi) {
		this.workItem = wi;
		this.workItemId = wi.getId();
		this.planElementState = PlanElementState.INITIAL;
	}

	@Override
	public void internalTrigger(NodeInstance from, String type) {
		super.internalTrigger(from, type);
		workItem = createWorkItem(getItem().getWork());
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

	@Override
	public long getWorkItemId() {
		if (this.workItem != null) {
			return workItem.getId();
		}
		return workItemId;
	}

	@Override
	public ContextInstance resolveContextInstance(String contextId, Object param) {
		final ContextInstance result = super.resolveContextInstance(contextId, param);
		if (contextId.equals(VariableScope.VARIABLE_SCOPE)) {
			// TODO make caseParameters available??
			return new CustomVariableScopeInstance(this);
		}
		return result;
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

	@Override
	public WorkItem getWorkItem() {
		if (this.workItem == null) {
			workItem = ((WorkItemManager) ((ProcessInstance) getProcessInstance()).getKnowledgeRuntime().getWorkItemManager()).getWorkItem(workItemId);
		}
		return this.workItem;
	}

	@Override
	public String[] getEventTypes() {
		return new String[] { WorkItemParameters.WORK_ITEM_UPDATED };
	}

	@Override
	public void signalEvent(String type, Object event) {
		if (type.equals(WorkItemParameters.WORK_ITEM_UPDATED) && isMyWorkItem((WorkItem) event)) {
			this.workItem = (WorkItem) event;
			PlanItemTransition transition = (PlanItemTransition) workItem.getResult(WorkItemParameters.TRANSITION);
			transition.invokeOn(this);
		} else {
			super.signalEvent(type, event);
		}
	}

	protected boolean isMyWorkItem(WorkItem event) {
		return event.getId() == getWorkItemId() || (getWorkItemId() == -1 && getWorkItem().getId() == (event.getId()));
	}

	@Override
	public void setLastBusyState(PlanElementState s) {
		this.lastBusyState = s;
	}

	@Override
	public void enable() {
		planElementState.enable(this);
	}

	@Override
	public void disable() {
		planElementState.disable(this);
	}

	@Override
	public void reenable() {
		planElementState.reenable(this);
	}

	@Override
	public void manualStart() {
		planElementState.manualStart(this);
	}

	@Override
	public void reactivate() {
		planElementState.reactivate(this);
	}

	@Override
	public void exit() {
		planElementState.exit(this);
	}

	@Override
	public void complete() {
		planElementState.complete(this);
	}

	@Override
	public void parentSuspend() {
		planElementState.parentSuspend(this);
	}

	@Override
	public void parentResume() {
		planElementState.parentResume(this);
	}

	@Override
	public void create() {
		planElementState.create(this);
	}

	@Override
	public void fault() {
		planElementState.fault(this);
	}

	@Override
	public PlanElementState getLastBusyState() {
		return lastBusyState;
	}

	@Override
	public void start() {
		planElementState.start(this);
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

	@SuppressWarnings("unchecked")
	public X getItem() {
		return (X) getNode();
	}

	@Override
	public void setPlanElementState(PlanElementState s) {
		if (requiresSubscriptionUpdate(s)) {
			getCaseInstance().markSubscriptionsForUpdate();
		}
		this.planElementState = s;
	}

	private boolean requiresSubscriptionUpdate(PlanElementState s) {
		if (getCaseInstance() == null) {
			return false;
		} else if (this.planElementState == PlanElementState.ACTIVE) {
			return s != PlanElementState.ACTIVE;
		} else if (s == PlanElementState.ACTIVE) {
			return this.planElementState != PlanElementState.ACTIVE;
		}
		return false;
	}

	public boolean isCompletionRequired() {
		return isCompletionRequired;
	}

	public boolean isCompletionStillRequired() {
		return isCompletionRequired && !planElementState.isTerminalState() && !planElementState.isSemiTerminalState(this)
				&& !(getItem() instanceof TaskDefinition && !((TaskDefinition) getItem()).isBlocking());
	}

	public void internalSetCompletionRequired(boolean b) {
		this.isCompletionRequired = b;
	}

	@Override
	public void suspend() {
		planElementState.suspend(this);
	}

	public void resume() {
		planElementState.resume(this);
	}

	@Override
	public void terminate() {
		planElementState.terminate(this);
	}

	@Override
	public PlanElementState getPlanElementState() {
		return planElementState;
	}

	@Override
	public CaseInstance getCaseInstance() {
		return (CaseInstance) getProcessInstance();
	}

}