package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.instance.CaseFileItemEvent;
import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.RuntimeManagerRegistry;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.*;

public class EventQueues {
    private static ThreadLocal<Map<String, Set<QueuedCaseFileItemEvent>>> eventQueue = new ThreadLocal<Map<String, Set<QueuedCaseFileItemEvent>>>();
    static Logger logger = LoggerFactory.getLogger(EventQueues.class);

    public static Set<QueuedCaseFileItemEvent> getEventQueue(String deploymentId) {
        Map<String, Set<QueuedCaseFileItemEvent>> map = eventQueue.get();
        if (map == null) {
            eventQueue.set(map = new HashMap<String, Set<QueuedCaseFileItemEvent>>());
        }
        Set<QueuedCaseFileItemEvent> set = map.get(deploymentId);
        if (set == null) {
            map.put(deploymentId, set = new HashSet<QueuedCaseFileItemEvent>());
        }
        return set;
    }


    public static void dispatchCaseFileItemEventQueue(String deploymentId, EntityManager em) {
        Collection<QueuedCaseFileItemEvent> eq = getEventsFrom(deploymentId, em);
        RuntimeManager runtimeManager = RuntimeManagerRegistry.get().getManager(deploymentId);
        Set<RuntimeEngine> engines = new HashSet<RuntimeEngine>();
        try {
            for (QueuedCaseFileItemEvent q : eq) {
                Object parentObject = null;
                Object value = null;
                CaseFileItemEvent event = new CaseFileItemEvent(q.getCaseFileItemName(), q.getTransition(), parentObject, value);
                String eventType = AbstractStandardEventNode.getType(event.getCaseFileItemName(), event.getTransition());
                RuntimeEngine re = runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(q.getProcessInstanceId()));
                engines.add(re);
                re.getKieSession().signalEvent(eventType, event, q.getProcessInstanceId());
                em.remove(q);
            }
        } catch (Exception e) {
            logger.error("Could not dispatch CaseFileItemEvents", e);
        } finally {
            for (RuntimeEngine engine : engines) {
                try {
                    runtimeManager.disposeRuntimeEngine(engine);
                } catch (Exception e) {
                    logger.error("Could not dispose RuntimeEngine" + engine, e);
                }
            }
        }
    }

    private static Collection<QueuedCaseFileItemEvent> getEventsFrom(String deploymentId, EntityManager em) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<QueuedCaseFileItemEvent> q = criteriaBuilder.createQuery(QueuedCaseFileItemEvent.class);
        Root<QueuedCaseFileItemEvent> from = q.from(QueuedCaseFileItemEvent.class);
        Predicate deploymentIdPredicate = criteriaBuilder.equal(from.get("deploymentId"), deploymentId);
        q.where(deploymentIdPredicate);
        q.distinct(true);
        TypedQuery<QueuedCaseFileItemEvent> typedQuery = em.createQuery(q);
        return typedQuery.getResultList();
    }

    public static void queueEvent(String deploymentId, long processInstanceId, CaseFileItemEvent caseFileItemEvent) {
        Set<QueuedCaseFileItemEvent> set = getEventQueue(deploymentId);
        QueuedCaseFileItemEvent q = new QueuedCaseFileItemEvent();
        q.setDeploymentId(deploymentId);
        q.setTransition(caseFileItemEvent.getTransition());
        q.setCaseFileItemName(caseFileItemEvent.getCaseFileItemName());
        q.setProcessInstanceId(processInstanceId);
        try {
            q.setParentObject(caseFileItemEvent.getParentObject());
            q.setValue(caseFileItemEvent.getValue());
        } catch (IOException e) {
            //??bleh
            e.printStackTrace();
        }
        set.add(q);
    }

    public static boolean saveQueueTo(String deploymentId, EntityManager entityManager) {
        Set<QueuedCaseFileItemEvent> q = EventQueues.getEventQueue(deploymentId);
        boolean eventsFound = false;
        for (QueuedCaseFileItemEvent event : q) {
            entityManager.persist(event);
            eventsFound = true;
        }
        q.clear();
        return eventsFound;
    }
}