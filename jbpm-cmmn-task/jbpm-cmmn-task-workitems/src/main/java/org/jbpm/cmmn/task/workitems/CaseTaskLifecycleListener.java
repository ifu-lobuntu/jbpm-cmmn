package org.jbpm.cmmn.task.workitems;

import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.WorkItemManager;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.ControllableItemInstance;
import org.jbpm.cmmn.instance.impl.CaseInstanceImpl;
import org.jbpm.cmmn.instance.impl.StageInstance;
import org.jbpm.cmmn.task.additional.commands.CmmnTaskLifecycleEventListener;
import org.jbpm.cmmn.task.additional.commands.CmmnTaskLifecycleEventListenerImpl;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskEvent;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Task;
import org.kie.internal.runtime.manager.InternalRuntimeManager;
import org.kie.internal.runtime.manager.RuntimeManagerRegistry;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

//TODO try to remove dependencies from 'impl'

public class CaseTaskLifecycleListener extends CmmnTaskLifecycleEventListenerImpl {

    private static final Logger logger = LoggerFactory.getLogger(CaseTaskLifecycleListener.class);
    private static ThreadLocal<Boolean> enabled = new ThreadLocal<Boolean>();
    private RuntimeManagerRegistry registry = RuntimeManagerRegistry.get();

    public CaseTaskLifecycleListener() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if ((obj instanceof CaseTaskLifecycleListener))
            return true;

        return false;
    }

    @Override
    public void afterTaskCompletedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.COMPLETE);
    }

    @Override
    public void afterTaskActivatedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.ENABLE);
    }

    public void afterTaskReactivatedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.REACTIVATE);
    }

    public void afterTaskReenabledEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.REENABLE);
    }

    public void afterTaskParentSuspendedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.PARENT_SUSPEND);
    }

    public void afterTaskParentResumedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.PARENT_RESUME);
    }

    @Override
    public void afterTaskReleasedEvent(TaskEvent taskEvent) {
        signalEvent(taskEvent.getTask(), PlanItemTransition.STOP);
    }

    @Override
    public void afterTaskDelegatedEvent(TaskEvent taskEvent) {
        signalEvent(taskEvent.getTask(), PlanItemTransition.STOP);
    }

    @Override
    public void afterTaskForwardedEvent(TaskEvent taskEvent) {
        signalEvent(taskEvent.getTask(), PlanItemTransition.STOP);
    }

    public void afterTaskExitCriteriaEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.EXIT);
    }

    public void afterTaskStartedAutomaticallyEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.START);
    }


    protected void signalEvent(Task task, PlanItemTransition standardEvent) {
        try {
            if (isEnabled()) {
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
                    if (workItem == null) {
                        //HACK! May have been deleted by jBPM's default ExternalTaskEventListener on abort/complete
                        workItem = new WorkItemImpl();
                        workItem.setDeploymentId(task.getTaskData().getDeploymentId());
                        ((WorkItemImpl)workItem).setId(task.getTaskData().getWorkItemId());
                        workItem.setName("Human Task");
                        workItem.setProcessInstanceId(pi.getId());
                        workItem.setParameters(loadContentAsMap( getRuntimeEngine(task), session, manager,task.getTaskData().getDocumentContentId()));
                    }
                    logger.debug("Workitem found: Task[" + task.getName() + "].workItemId=" + task.getTaskData().getWorkItemId());
                    Map<String, Object> results = buildWorkItemResults(task, standardEvent, getRuntimeEngine(task), session, manager);
                    workItem.setResults(results);
                    // In CMMN we need the state of the PlanItemInstance for completion calculations
                    workItemManager.signalEvent(WorkItemParameters.WORK_ITEM_UPDATED, workItem, processInstanceId);
                }
            }
        } finally {
            enable();
        }

    }

    private boolean isEnabled() {
        boolean disabled = Boolean.FALSE.equals(this.enabled.get());
        return !disabled;
    }

    public RuntimeManager getManager(Task task) {
        return registry.getManager(task.getTaskData().getDeploymentId());

    }

    private RuntimeEngine getRuntimeEngine(Task task) {
        return getManager(task).getRuntimeEngine(ProcessInstanceIdContext.get(task.getTaskData().getProcessInstanceId()));
    }

    protected Map<String, Object> buildWorkItemResults(Task task, PlanItemTransition standardEvent, RuntimeEngine runtime, KieSession session,
                                                       RuntimeManager manager) {
        Map<String, Object> results = loadContentAsMap(runtime, session, manager, task.getTaskData().getOutputContentId());
        if (task.getTaskData().getActualOwner() != null) {
            String userId = task.getTaskData().getActualOwner().getId();
            results.put(WorkItemParameters.ACTUAL_OWNER, userId);
        }
        results.put(WorkItemParameters.TRANSITION, standardEvent);
        results.put(WorkItemParameters.TASK, task);
        return results;
    }

    private Map<String, Object> loadContentAsMap(RuntimeEngine runtime, KieSession session, RuntimeManager manager, long contentId) {
        Map<String, Object> results = new HashMap<String, Object>();
        if (contentId != -1) {
            Content content = runtime.getTaskService().getContentById(contentId);
            ClassLoader cl = null;
            if (manager instanceof InternalRuntimeManager) {
                cl = ((InternalRuntimeManager) manager).getEnvironment().getClassLoader();
            }
            Object result = ContentMarshallerHelper.unmarshall(content.getContent(), session.getEnvironment(), cl);
            if (result instanceof Map) {
                Map<?, ?> map = (Map<?, ?>) result;
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    if (entry.getKey() instanceof String) {
                        results.put((String) entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return results;
    }

    public void disable() {
        this.enabled.set(false);
    }

    public void enable() {
        this.enabled.set(true);
    }

    KieSession getKieSession(Task task) {
        return getRuntimeEngine(task).getKieSession();
    }


    @Override
    public void afterTaskResumedEvent(TaskEvent te) {
        signalEvent(te.getTask(), PlanItemTransition.RESUME);
    }

    @Override
    public void afterTaskSuspendedEvent(TaskEvent te) {
        signalEvent(te.getTask(), PlanItemTransition.SUSPEND);
    }

    @Override
    public void afterTaskStartedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.MANUAL_START);
    }

    @Override
    public void afterTaskFailedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.FAULT);
    }

    @Override
    public void afterTaskExitedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.TERMINATE); // In CMMN exit is when exit criteria occur
    }

    @Override
    public void afterTaskSkippedEvent(TaskEvent task) {
        signalEvent(task.getTask(), PlanItemTransition.DISABLE);
    }

}
