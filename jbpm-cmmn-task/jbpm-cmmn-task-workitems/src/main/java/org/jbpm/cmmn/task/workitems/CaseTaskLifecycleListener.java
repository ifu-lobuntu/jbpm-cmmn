package org.jbpm.cmmn.task.workitems;

import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.WorkItemManager;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.ControllableItemInstance;
import org.jbpm.cmmn.instance.impl.CaseInstanceImpl;
import org.jbpm.cmmn.instance.impl.StageInstance;
import org.jbpm.cmmn.task.additional.commands.CmmnTaskLifecycleEventListener;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.jbpm.services.task.wih.ExternalTaskEventListener;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskEvent;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Task;
import org.kie.internal.runtime.manager.InternalRuntimeManager;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

//TODO try to remove dependencies from 'impl'

public class CaseTaskLifecycleListener extends ExternalTaskEventListener
        implements CmmnTaskLifecycleEventListener {

    private static final Logger logger = LoggerFactory.getLogger(CaseTaskLifecycleListener.class);

    public CaseTaskLifecycleListener() {
        super();
    }
    @Override
    public void afterTaskCompletedEvent(TaskEvent task) {
        afterTaskCompletedEvent(task.getTask());
    }

    @Override
    public void afterTaskActivatedEvent(TaskEvent task) {
        afterTaskActivatedEvent(task.getTask());
    }



    @Override
    public void beforeTaskAddedEvent(Task t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeTaskUpdatedEvent(TaskEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterTaskUpdatedEvent(TaskEvent event) {
        // TODO Auto-generated method stub

    }
    public void afterTaskReactivatedEvent(Task task) {
        signalEvent(task, PlanItemTransition.REACTIVATE);
    }

    public void afterTaskReenabledEvent(Task task) {
        signalEvent(task, PlanItemTransition.REENABLE);
    }

    public void afterTaskParentSuspendedEvent(Task task) {
        signalEvent(task, PlanItemTransition.PARENT_SUSPEND);
    }

    public void afterTaskParentResumedEvent(Task task) {
        signalEvent(task, PlanItemTransition.PARENT_RESUME);
    }

    public void afterTaskExitCriteriaEvent(Task task) {
        signalEvent(task, PlanItemTransition.EXIT);
    }

    public void afterTaskStartedAutomaticallyEvent(Task task) {
        signalEvent(task, PlanItemTransition.START);
    }

    public void afterTaskAddedEvent(Task task) {

    }

    public void afterTaskReleasedEvent(Task task) {
    }

    public void afterTaskForwardedEvent(Task task) {
    }

    public void afterTaskDelegatedEvent(Task task) {
    }

    @Override
    public void afterTaskActivatedEvent(Task task) {
        signalEvent(task, PlanItemTransition.ENABLE);
    }

    @Override
    public void afterTaskClaimedEvent(Task task) {
    }

    @Override
    public void afterTaskStoppedEvent(Task task) {
    }

    public void afterTaskResumedEvent(Task task) {
        signalEvent(task, PlanItemTransition.RESUME);
    }

    public void afterTaskSuspendedEvent(Task task) {
        signalEvent(task, PlanItemTransition.SUSPEND);
    }

    @Override
    public void afterTaskStartedEvent(Task task) {
        signalEvent(task, PlanItemTransition.MANUAL_START);
    }

    public void afterTaskFailedEvent(Task task) {
        signalEvent(task, PlanItemTransition.FAULT);
    }

    public void afterTaskExitedEvent(Task task) {
        signalEvent(task, PlanItemTransition.TERMINATE); // In CMMN exit is when exit criteria occur
    }

    public void afterTaskSkippedEvent(Task task) {
        signalEvent(task, PlanItemTransition.DISABLE);
    }

    public void afterTaskCompletedEvent(Task task) {
        signalEvent(task, PlanItemTransition.COMPLETE);
    }

    public void beforeTaskCompletedEvent(Task task) {
        KieSession session = getKieSession(task);
        ProcessInstance pi = session.getProcessInstance(task.getTaskData().getProcessInstanceId());
        if (pi instanceof CaseInstanceImpl) {
            CaseInstance ci = (CaseInstance) pi;
            ControllableItemInstance<?> node = ci.findNodeForWorkItem(task.getTaskData().getWorkItemId());
            if (node instanceof StageInstance && !((StageInstance) node).canComplete()) {
                throw new IllegalStateException("Task " + task + " represents StageImpl Instance " + node.getItem().getEffectiveName() + "[" + ci.getId()
                        + "] which cannot be completed yet");
            }
        }

    }

    protected void signalEvent(Task task, PlanItemTransition standardEvent) {
        long processInstanceId = task.getTaskData().getProcessInstanceId();
        if (processInstanceId <= 0) {
            return;
        }
        KieSession session = getKieSession(task);
        if (session == null) {
            logger.error("EE: I've recieved an event but the session is not known by this handler ( " + task.getTaskData().getProcessSessionId() + ")");
            return;
        }
        ProcessInstance pi = session.getProcessInstance(processInstanceId);
        if (pi instanceof CaseInstanceImpl) {
            RuntimeManager manager = getManager(task);
            WorkItemManager workItemManager = (WorkItemManager) session.getWorkItemManager();
            WorkItem workItem = workItemManager.getWorkItem(task.getTaskData().getWorkItemId());
            if (workItem != null) {
                logger.debug("Workitem found: Task[" + task.getName() + "].workItemId=" + task.getTaskData().getWorkItemId());
                Map<String, Object> results = buildWorkItemResults(task, standardEvent, getRuntimeEngine(task), session, manager);
                workItem.setResults(results);
                // In CMMN we need the state of the PlanItemInstance for completion calculations
                workItemManager.signalEvent(WorkItemParameters.WORK_ITEM_UPDATED, workItem, processInstanceId);
            } else {
                logger.debug("Workitem not found: Task[" + task.getName() + "].workItemId=" + task.getTaskData().getWorkItemId());
            }
        } else {
            super.processTaskState(task);
        }

    }

    private RuntimeEngine getRuntimeEngine(Task task) {
        return getManager(task).getRuntimeEngine(ProcessInstanceIdContext.get(task.getTaskData().getProcessInstanceId()));
    }

    protected Map<String, Object> buildWorkItemResults(Task task, PlanItemTransition standardEvent, RuntimeEngine runtime, KieSession session,
                                                       RuntimeManager manager) {
        Map<String, Object> results = new HashMap<String, Object>();
        if (task.getTaskData().getActualOwner() != null) {
            String userId = task.getTaskData().getActualOwner().getId();
            results.put(WorkItemParameters.ACTUAL_OWNER, userId);
        }
        long contentId = task.getTaskData().getOutputContentId();
        if (contentId != -1) {
            Content content = runtime.getTaskService().getContentById(contentId);
            ClassLoader cl = null;
            if (manager instanceof InternalRuntimeManager) {
                cl = ((InternalRuntimeManager) manager).getEnvironment().getClassLoader();
            }
            Object result = ContentMarshallerHelper.unmarshall(content.getContent(), session.getEnvironment(), cl);
            results.put("Result", result);
            if (result instanceof Map) {
                Map<?, ?> map = (Map<?, ?>) result;
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    if (entry.getKey() instanceof String) {
                        results.put((String) entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        results.put(WorkItemParameters.TRANSITION, standardEvent);
        results.put(WorkItemParameters.TASK, task);
        return results;
    }

    private ProcessInstance getProcessInstance(Task task, long processInstanceId) {
        KieSession session = getKieSession(task);
        ProcessInstance pi = session.getProcessInstance(processInstanceId);
        return pi;
    }

    KieSession getKieSession(Task task) {
        return getRuntimeEngine(task).getKieSession();
    }


    @Override
    public void afterTaskReleasedEvent(TaskEvent te) {
        afterTaskReleasedEvent(te.getTask());

    }

    @Override
    public void afterTaskResumedEvent(TaskEvent te) {
        afterTaskResumedEvent(te.getTask());
    }

    @Override
    public void afterTaskSuspendedEvent(TaskEvent te) {
        afterTaskSuspendedEvent(te.getTask());
    }

    @Override
    public void afterTaskForwardedEvent(TaskEvent te) {
        afterTaskForwardedEvent(te.getTask());
    }

    @Override
    public void afterTaskDelegatedEvent(TaskEvent te) {
        afterTaskDelegatedEvent(te.getTask());
    }

    @Override
    public void afterTaskAddedEvent(TaskEvent task) {
        afterTaskAddedEvent(task.getTask());
    }

    @Override
    public void afterTaskClaimedEvent(TaskEvent task) {
        afterTaskClaimedEvent(task.getTask());
    }

    @Override
    public void afterTaskStoppedEvent(TaskEvent task) {
        afterTaskStoppedEvent(task.getTask());
    }

    @Override
    public void afterTaskStartedEvent(TaskEvent task) {
        afterTaskStartedEvent(task.getTask());
    }

    @Override
    public void afterTaskFailedEvent(TaskEvent task) {
        afterTaskFailedEvent(task.getTask());
    }

    @Override
    public void afterTaskExitedEvent(TaskEvent task) {
        afterTaskExitedEvent(task.getTask());
    }

    @Override
    public void afterTaskSkippedEvent(TaskEvent task) {
        afterTaskSkippedEvent(task.getTask());
    }

    @Override
    public void beforeTaskAddedEvent(TaskEvent t) {
        beforeTaskAddedEvent(t.getTask());
    }

    @Override
    public void beforeTaskCompletedEvent(TaskEvent task) {
        beforeTaskCompletedEvent(task.getTask());
    }

    @Override
    public void beforeTaskReactivatedEvent(Task task) {
    }

    @Override
    public void beforeTaskReenabledEvent(Task task) {
    }

    @Override
    public void beforeTaskParentSuspendedEvent(Task task) {
    }

    @Override
    public void beforeTaskParentResumedEvent(Task task) {
    }

    @Override
    public void beforeTaskExitCriteriaEvent(Task task) {
    }

    @Override
    public void beforeTaskStartedAutomaticallyEvent(Task task) {
    }
}
