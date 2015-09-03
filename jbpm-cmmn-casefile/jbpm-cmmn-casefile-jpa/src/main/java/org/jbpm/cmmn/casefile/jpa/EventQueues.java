package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.instance.CaseFileItemEvent;
import org.jbpm.cmmn.instance.impl.util.SubscriptionUtil;
import org.jbpm.cmmn.instance.subscription.impl.CaseFileItemEventWrapper;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.RuntimeManagerRegistry;
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


    public static boolean dispatchCaseFileItemEventQueue(String deploymentId) {
        Set<CaseFileItemEventWrapper> eq = getEventQueue();
        RuntimeManager runtimeManager= RuntimeManagerRegistry.get().getManager(deploymentId);
        eventQueue.set(new HashSet<CaseFileItemEventWrapper>());
        if (eq.size() > 0) {
            Set<RuntimeEngine> engines = new HashSet<RuntimeEngine>();
            try {
                for (CaseFileItemEventWrapper w : eq) {
                    CaseFileItemEvent event = w.getEvent();
                    String eventType = AbstractStandardEventNode.getType(event.getCaseFileItemName(), event.getTransition());
                    RuntimeEngine re=runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(w.getProcessInstanceId()));
                    engines.add(re);
                    re.getKieSession().signalEvent(eventType, event, w.getProcessInstanceId());
                }
            } catch (Exception e) {
                logger.error("Could not dispatch CaseFileItemEvents", e);
            }finally{
                for (RuntimeEngine engine : engines) {
                    try {
                        runtimeManager.disposeRuntimeEngine(engine);
                    } catch (Exception e) {
                        logger.error("Could not dispose RuntimeEngine" + engine, e);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void queueEvent(String deploymentId, long processId, CaseFileItemEvent caseFileItemEvent) {
        Set<CaseFileItemEventWrapper> set = getEventQueue();
        set.add(new CaseFileItemEventWrapper(caseFileItemEvent, deploymentId, processId));
    }

}