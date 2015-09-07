package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.instance.CaseFileImplementation;
import org.jbpm.cmmn.instance.CaseFilePersistence;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;

import javax.persistence.EntityManagerFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JpaCaseFileImplementation implements CaseFileImplementation {

    public static final String CASE_FILE_PERSISTENCE_UNIT_NAME = "CaseFilePersistenceUnitName";
    private static Map<String, JpaCaseFilePersistence> deployedPersistence = new ConcurrentHashMap<String, JpaCaseFilePersistence>();
    private static Map<String, EventDispatcher> eventDispatchers = new ConcurrentHashMap<String, EventDispatcher>();

    @Override
    public ObjectMarshallingStrategy[] getObjectMarshallingStrategies(Environment env, ClassLoader cl) {

        return new ObjectMarshallingStrategy[]{new JpaPlaceHolderResolverStrategy(deployCaseFilePersistence(env, cl))
                , new JpaCollectionPlaceHolderResolverStrategy(getCaseFilePersistence(env))};
    }

    @Override
    public SubscriptionManager<?> getSubscriptionManager(Environment env, ClassLoader cl) {
        return new HibernateSubscriptionManager(getCaseFilePersistence(env));
    }

    @Override
    public JpaCaseFilePersistence deployCaseFilePersistence(Environment env, ClassLoader cl) {
        String deploymentId = (String) env.get("deploymentId");
        EventDispatcher eventDispatcher = eventDispatchers.remove(deploymentId);
        if(eventDispatcher!=null){
            eventDispatcher.active=false;
        }
        JpaCaseFilePersistence oldPersistence = deployedPersistence.remove(deploymentId);
        if(oldPersistence !=null){
            oldPersistence.disposeEntityManagerFactory();
        }
        String pu = deploymentId;
        if (env.get(CASE_FILE_PERSISTENCE_UNIT_NAME) != null) {
            pu = (String) env.get(CASE_FILE_PERSISTENCE_UNIT_NAME);
        }
        //create it once only
        JpaCaseFilePersistence result = new JpaCaseFilePersistence(pu, deploymentId, cl);
        result.getEntityManager();//Load EMF
        env.set(CaseFilePersistence.ENV_NAME, result);
        EntityManagerFactory oldEmf = EntityManagerFactoryManager.get().remove(pu);
        if (oldEmf != null) {
            oldEmf.close();
        }
        //TODO find a better way to do this
        startEventDispatcherThread(deploymentId, result);
        return result;
    }

    private JpaCaseFilePersistence getCaseFilePersistence(Environment env) {
        return (JpaCaseFilePersistence) env.get(CaseFilePersistence.ENV_NAME);
    }

    private void startEventDispatcherThread(String deploymentId, JpaCaseFilePersistence p) {
        //TODO find a better way to do this. Will only work in a non CMT environment
        EventDispatcher ed = new EventDispatcher(p);
        eventDispatchers.put(deploymentId,ed);
        ed.start();
    }

    private static class EventDispatcher extends Thread {
        private final JpaCaseFilePersistence p;
        volatile  boolean active;

        public EventDispatcher(JpaCaseFilePersistence p) {
            this.p = p;
            active = true;
        }

        @Override
        public void run() {
            while (active) {
                try {
                    Thread.sleep(10000);
                    p.start();
                    p.commitAndSendCaseFileItemEvents();
                } catch (Exception e) {
                    p.rollback();
                }
            }
        }
    }
}
