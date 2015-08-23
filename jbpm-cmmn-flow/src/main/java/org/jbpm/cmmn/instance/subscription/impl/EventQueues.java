package org.jbpm.cmmn.instance.subscription.impl;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.instance.CaseFileItemEvent;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.InternalRuntimeManager;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class EventQueues {
    private static ThreadLocal<Set<CaseFileItemEventWrapper>> eventQueue = new ThreadLocal<Set<CaseFileItemEventWrapper>>();
    static Logger logger = LoggerFactory.getLogger(EventQueues.class);

    private static Set<CaseFileItemEventWrapper> getEventQueue() {
        Set<CaseFileItemEventWrapper> set = eventQueue.get();
        if (set == null) {
            eventQueue.set(set = new HashSet<CaseFileItemEventWrapper>());
        }
        return set;
    }


    public static boolean dispatchCaseFileItemEventQueue(RuntimeManager runtimeManager) {
        Set<CaseFileItemEventWrapper> eq = getEventQueue();
        eventQueue.set(new HashSet<CaseFileItemEventWrapper>());
        if (eq.size() > 0) {
            try {
                for (CaseFileItemEventWrapper w : eq) {
                    CaseFileItemEvent event = w.getEvent();
                    String eventType = AbstractStandardEventNode.getType(event.getCaseFileItemName(), event.getTransition());
                    RuntimeEngine re=runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(w.getProcessInstanceId()));
                    re.getKieSession().signalEvent(eventType, event, w.getProcessInstanceId());
                }
            } catch (Exception e) {
                logger.error("Could not dispatch CaseFileItemEvents", e);
            }
            return true;
        } else {
            return false;
        }
    }

    public static void queueEvent(String caseKey, long processId, CaseFileItemEvent caseFileItemEvent) {
        // TODO use deploymentId here
        Set<CaseFileItemEventWrapper> set = getEventQueue();
        set.add(new CaseFileItemEventWrapper(caseFileItemEvent, caseKey, processId));
    }

}