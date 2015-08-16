package org.jbpm.cmmn.casefile.jpa;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jbpm.cmmn.casefile.common.CaseFilePersistence;
import org.jbpm.cmmn.casefile.common.Stopwatch;
import org.jbpm.cmmn.instance.subscription.CaseSubscriptionKey;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.cmmn.instance.subscription.impl.AbstractDurableSubscriptionManager;
import org.jbpm.cmmn.instance.subscription.impl.EventQueues;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.EmptyContext;

/**
 * 
 * Needed to coordinate the dispatching of Events with storing the updated
 * subscriptions and flushing of the EntityManager. The plan is to do the
 * dispatching asynchronously eventually. There are still some serious issues to
 * resolve, specifically w.r.t. clearing some static variables and avoiding
 * memory leaks
 * 
 */
public class JpaCaseFilePersistence implements SubscriptionPersistenceContext<JpaCaseSubscriptionInfo, JpaCaseFileItemSubscriptionInfo>, CaseFilePersistence {
    public static final String ENV_NAME = JpaCaseFilePersistence.class.getName() + "VAR";
    static ThreadLocal<EntityManager> em = new ThreadLocal<EntityManager>();
    protected EntityManagerFactory emf;
    protected boolean startedTransaction = false;
    protected Stopwatch stopwatch = new Stopwatch(getClass());
    private UserTransaction transaction;
    private RuntimeEngine runtimeEngine;

    public JpaCaseFilePersistence(EntityManagerFactory emf, RuntimeEngine rm) {
        this.runtimeEngine = rm;
        this.emf = emf;
    }

    @Override
    public Object getDelegate() {
        return getEntityManager().getDelegate();
    }

    @Override
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

    protected boolean isTransactionActive() throws SystemException, NamingException {
        int status = getTransaction().getStatus();
        return status == Status.STATUS_ACTIVE;
    }

    protected RuntimeException convertException(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }

    @Override
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

    void setTransaction(UserTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public <T> T find(Class<T> class1, Object id) {
        return getEntityManager().find(class1, id);
    }

    public EntityManager getEntityManager() {
        if (em.get() == null || !em.get().isOpen()) {
            em.set(emf.createEntityManager());
            em.get().joinTransaction();
            em.get().setFlushMode(FlushModeType.COMMIT);
        }
        return em.get();
    }

    @Override
    public void remove(Object s) {
        getEntityManager().remove(s);
    }

    @Override
    public void close() {
        if (em.get() != null && em.get().isOpen()) {
            em.get().close();
        }
        this.startedTransaction = false;
    }

    @Override
    public void update(Object o) {
    }

    @Override
    public JpaCaseSubscriptionInfo findCaseSubscriptionInfo(CaseSubscriptionKey key) {
        return getEntityManager().find(JpaCaseSubscriptionInfo.class, key);
    }

    @Override
    public void updateCaseSupbscriptionInfo(JpaCaseSubscriptionInfo t) {
    }

    @Override
    public void persistCaseSubscriptionInfo(JpaCaseSubscriptionInfo t) {
        startOrJoinTransaction();
        getEntityManager().persist(t);
    }

    @Override
    public void removeCaseFileItemSubscriptionInfo(JpaCaseFileItemSubscriptionInfo x) {
        getEntityManager().remove(x);
    }

    @Override
    public void commit() {
        try {
            startOrJoinTransaction();
            getEntityManager().flush();
            doCaseFileItemEvents();
            if (runtimeEngine != null) {
                if (startedTransaction) {
                    getTransaction().commit();
//                    boolean workItemsProcessed = false;
//                    do {
//                        this.startedTransaction = false;
//                        startOrJoinTransaction();
//                        workItemsProcessed = EventQueues.dispatchWorkItemQueue(runtimeEngine);
//                        if (workItemsProcessed) {
//                            doCaseFileItemEvents();
//                        }
//                        getTransaction().commit();
//                    } while (workItemsProcessed);
//                    this.startedTransaction = false;
                }
            }
            close();
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private void doCaseFileItemEvents() {
        if (runtimeEngine != null) {
            while (EventQueues.dispatchCaseFileItemEventQueue(runtimeEngine)) {
                AbstractDurableSubscriptionManager.commitSubscriptionsTo(this);
                getEntityManager().flush();
            }
            if (AbstractDurableSubscriptionManager.commitSubscriptionsTo(this)) {
                getEntityManager().flush();
            }
        }
    }

}