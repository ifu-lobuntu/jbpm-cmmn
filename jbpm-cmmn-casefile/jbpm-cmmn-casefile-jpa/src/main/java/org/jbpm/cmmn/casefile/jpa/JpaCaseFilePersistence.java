package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.casefile.common.Stopwatch;
import org.jbpm.cmmn.instance.CaseFilePersistence;
import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.kie.api.executor.ExecutorService;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.executor.api.CommandContext;
import org.kie.internal.runtime.manager.RuntimeManagerRegistry;
import org.kie.internal.runtime.manager.context.EmptyContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.Set;

/**
 * Needed to coordinate the dispatching of Events with storing the updated
 * subscriptions and flushing of the EntityManager. The plan is to do the
 * dispatching asynchronously eventually. There are still some serious issues to
 * resolve, specifically w.r.t. clearing some static variables and avoiding
 * memory leaks
 * TODO more or less refactor it away, or make it much much thinner.
 */
public class JpaCaseFilePersistence implements CaseFilePersistence {
    static ThreadLocal<EntityManager> em = new ThreadLocal<EntityManager>();
    private final String deploymentId;
    private final String pu;
    private final ClassLoader classLoader;
    protected boolean startedTransaction = false;
    protected Stopwatch stopwatch = new Stopwatch(getClass());
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

    public void start() {
        try {
            if (em.get() != null && em.get().isOpen()) {
                em.get().close();
                em.set(null);
            }
            startOrJoinTransaction();
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    protected void startOrJoinTransaction() {
        try {
            if (!isTransactionActive()) {
                this.startedTransaction = true;
                getTransaction().begin();
            }
            getEntityManager().joinTransaction();
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private boolean isTransactionActive() throws SystemException, NamingException {
        int status = getTransaction().getStatus();
        return status == Status.STATUS_ACTIVE;
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
                em.get().joinTransaction();
                em.get().setFlushMode(FlushModeType.COMMIT);
            } catch (Exception e) {
                e.getCause().printStackTrace();
            } finally {
                Thread.currentThread().setContextClassLoader(tccl);
            }
        }
        return em.get();
    }

    public void remove(Object s) {
        getEntityManager().remove(s);
    }

    public void close() {
        if (em.get() != null && em.get().isOpen()) {
            em.get().close();
            em.set(null);
        }
        this.startedTransaction = false;
    }

    public void update(Object o) {
    }


    public void commitAndSendCaseFileItemEvents() {
        try {
            startOrJoinTransaction();
            getEntityManager().flush();
            doCaseFileItemEvents();
            if (startedTransaction) {
                getTransaction().commit();
                transaction = null;
            }
            close();
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private void doCaseFileItemEvents() {
        while (saveEvents()) {
            EventQueues.dispatchCaseFileItemEventQueue(deploymentId, getEntityManager());
        }
    }


    private boolean saveEvents() {
        boolean found = EventQueues.saveQueueTo(deploymentId, getEntityManager());
        getEntityManager().flush();
        return found;
    }

    public void flush() {
        getEntityManager().flush();
        saveEvents();
    }
    public void scheduleEventDelivery(){
        //TODO this needs to still run in a TX context
        RuntimeEngine re = RuntimeManagerRegistry.get().getManager(deploymentId).getRuntimeEngine(EmptyContext.get());
        ExecutorService executorService = (ExecutorService) re.getKieSession().getEnvironment().get("ExecutorService");
        CommandContext c = new CommandContext();
        c.setData("deploymentId", deploymentId);
        executorService.scheduleRequest(DispatchCaseFileItemEventsCommand.class.getName(), c);
    }
}