package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.casefile.common.Stopwatch;
import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.instance.CaseFileItemEvent;
import org.jbpm.cmmn.instance.CaseFilePersistence;
import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.kie.api.executor.ExecutorService;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.executor.api.CommandContext;
import org.kie.internal.runtime.manager.RuntimeManagerRegistry;
import org.kie.internal.runtime.manager.context.EmptyContext;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Needed to coordinate the dispatching of Events with storing the updated
 * subscriptions and flushing of the EntityManager. The plan is to do the
 * dispatching asynchronously eventually. There are still some serious issues to
 * resolve, specifically w.r.t. clearing some static variables and avoiding
 * memory leaks
 * TODO refactor it to be much much thinner.
 */
public class JpaCaseFilePersistence implements CaseFilePersistence {
    static final Logger logger = LoggerFactory.getLogger(JpaCaseFilePersistence.class);
    static ThreadLocal<EntityManager> em = new ThreadLocal<EntityManager>();
    private final String deploymentId;
    private final String pu;
    private final ClassLoader classLoader;
    protected ThreadLocal<Boolean> startedTransaction = new ThreadLocal<Boolean>();
    private UserTransaction transaction;

    public JpaCaseFilePersistence(String pu, String deploymentId, ClassLoader cl) {
        this.pu = pu;
        this.deploymentId = deploymentId;
        this.classLoader = cl;
    }

    /**
     * for testing purposes only
     */
    public JpaCaseFilePersistence(String puName, EntityManagerFactory emf, String deploymentId) {
        this(puName, deploymentId, Thread.currentThread().getContextClassLoader());
        EntityManagerFactoryManager.get().addEntityManagerFactory(puName, emf);
    }

    public Object getDelegate() {
        return getEntityManager().getDelegate();
    }

    /**
     * Needs to be idempotent
     */
    public void start() {
        startOrJoinTransaction();
    }

    /**
     * Needs to be idempotent
     */
    protected void startOrJoinTransaction() {
        try {
            // EntityManager first - do not want to create EMF in transaction
            EntityManager entityManager = getEntityManager();
            if (!isTransactionActive()) {
                this.startedTransaction.set(true);
                getTransaction().begin();
            }
            entityManager.joinTransaction();
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private boolean isTransactionActive() throws SystemException, NamingException {
        UserTransaction tx = getTransaction();
        return tx!=null && tx.getStatus() == Status.STATUS_ACTIVE;
    }

    private RuntimeException convertException(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }

    public void persist(Object o) {
        startOrJoinTransaction();
        getEntityManager().persist(o);
    }

    public UserTransaction getTransaction() throws NamingException {
        if (transaction == null) {
            transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
        }
        return transaction;
    }

    public <T> T find(Class<T> class1, Object id) {
        return getEntityManager().find(class1, id);
    }

    public <T> T find(String className, Object id) {
        try {
            return (T) getEntityManager().find(Class.forName(className, true, classLoader), id);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EntityManager getEntityManager() {
        if (em.get() == null || !em.get().isOpen()) {
            ClassLoader tccl = Thread.currentThread().getContextClassLoader();
            try {
                Thread.currentThread().setContextClassLoader(classLoader);
                EntityManagerFactory emf = EntityManagerFactoryManager.get().getOrCreate(pu);
                em.set(emf.createEntityManager());
                if(isTransactionActive()) {
                    em.get().joinTransaction();
                }
                em.get().setFlushMode(FlushModeType.COMMIT);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.currentThread().setContextClassLoader(tccl);
            }
        }
        return em.get();
    }

    public void remove(Object s) {
        getEntityManager().remove(s);
    }

    /**
     * needs to be idempotent - do not know how many times it may be called
     */
    public void close() {
        if (em.get() != null && em.get().isOpen()) {
            em.get().close();
            em.set(null);
        }
    }

    public void update(Object o) {
    }
    public void rollback(){
        try {
            if (Boolean.TRUE.equals(startedTransaction.get())) {
                getTransaction().rollback();
            }
        } catch (SystemException e) {
            logger.error("Could not rollback", e);
        } catch (NamingException e) {
            logger.error("Could not rollback", e);
        }finally{
            close();
        }
    }
    /**
     * Used for synchronous delivery of events, specifically for tests
     */

    public void commitAndSendCaseFileItemEvents() {
        try {
            startOrJoinTransaction();
            getEntityManager().flush();
            while (dispatchCaseFileItemEventQueue()){
                getEntityManager().flush();
            }
            if (Boolean.TRUE.equals(startedTransaction.get())) {
                getTransaction().commit();
                this.startedTransaction.set(false);
                transaction = null;
            }
            close();
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    /**
     * TODO move to HIbernateCaseFileITemEVentGEnerator
     * @return
     */

    public void flush() {
        getEntityManager().flush();
    }

    public void scheduleEventDelivery() {
        //TODO this needs to still run in a TX context
        //Consider a ThreadPoolExecutor.
        RuntimeEngine re = RuntimeManagerRegistry.get().getManager(deploymentId).getRuntimeEngine(EmptyContext.get());
        ExecutorService executorService = (ExecutorService) re.getKieSession().getEnvironment().get("ExecutorService");
        CommandContext c = new CommandContext();
        c.setData("deploymentId", deploymentId);
        executorService.scheduleRequest(DispatchCaseFileItemEventsCommand.class.getName(), c);
    }


    public boolean dispatchCaseFileItemEventQueue() {
        Collection<QueuedCaseFileItemEvent> eq = getLatestEvents();
        RuntimeManager runtimeManager = RuntimeManagerRegistry.get().getManager(deploymentId);
        Set<RuntimeEngine> engines = new HashSet<RuntimeEngine>();
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(classLoader);
            for (QueuedCaseFileItemEvent q : eq) {
                RuntimeEngine re = runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(q.getProcessInstanceId()));
                dispatchEvent(q, re);
                engines.add(re);
            }
        } catch (Exception e) {
            logger.error("Could not dispatch CaseFileItemEvents for RuntimeManager " + deploymentId, e);
        } finally {
            for (RuntimeEngine engine : engines) {
                try {
                    runtimeManager.disposeRuntimeEngine(engine);
                } catch (Exception e) {
                    logger.error("Could not dispose RuntimeEngine" + engine, e);
                }
            }
            Thread.currentThread().setContextClassLoader(tccl);
        }
        return eq.size()>0;
    }

    private void dispatchEvent(QueuedCaseFileItemEvent q, RuntimeEngine re) {
        try {
            Object parentObject = null;
            Serializable parentObjectId = q.getParentObjectId();
            if (parentObjectId != null && q.getParentObjectClassName() != null && q.getParentObjectClassName().length() > 0) {
                parentObject = find(q.getParentObjectClassName(), parentObjectId);
            }
            Object value = q.getValue();
            if (value != null && q.getValueClassName() != null && q.getValueClassName().length() > 0) {
                value = find(q.getValueClassName(), value);
            }
            CaseFileItemEvent event = new CaseFileItemEvent(q.getCaseFileItemName(), q.getTransition(), parentObject, value);
            String eventType = AbstractStandardEventNode.getType(event.getCaseFileItemName(), event.getTransition());
            re.getKieSession().signalEvent(eventType, event, q.getProcessInstanceId());
            getEntityManager().remove(q);
        }catch(Exception e){
            logger.error("Could not dispatch CaseFileItemEvent " + q.toString(), e);
        }
    }

    private Collection<QueuedCaseFileItemEvent> getLatestEvents() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<QueuedCaseFileItemEvent> q = criteriaBuilder.createQuery(QueuedCaseFileItemEvent.class);
        Root<QueuedCaseFileItemEvent> from = q.from(QueuedCaseFileItemEvent.class);
        Predicate deploymentIdPredicate = criteriaBuilder.equal(from.get("deploymentId"), deploymentId);
        q.where(deploymentIdPredicate);
        q.distinct(true);
        TypedQuery<QueuedCaseFileItemEvent> typedQuery = getEntityManager().createQuery(q);
        return typedQuery.getResultList();
    }
}