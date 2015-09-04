package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.instance.CaseFileImplementation;
import org.jbpm.cmmn.instance.CaseFilePersistence;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaCaseFileImplementation implements CaseFileImplementation {

    public static final String CASE_FILE_PERSISTENCE_UNIT_NAME = "CaseFilePersistenceUnitName";

    @Override
    public ObjectMarshallingStrategy[] getObjectMarshallingStrategies(Environment env, ClassLoader cl) {

        return new ObjectMarshallingStrategy[]{new JpaPlaceHolderResolverStrategy(getCaseFilePersistence(env,cl))
                , new JpaCollectionPlaceHolderResolverStrategy(getCaseFilePersistence(env,cl))};
    }

    @Override
    public SubscriptionManager<?> getSubscriptionManager(Environment env, ClassLoader cl) {
        return new HibernateSubscriptionManager(getCaseFilePersistence(env,cl));
    }

    @Override
    public JpaCaseFilePersistence getCaseFilePersistence(Environment env, ClassLoader cl) {
        String pu = "org.jbpm.persistence.jpa.casefile";
        if(env.get(CASE_FILE_PERSISTENCE_UNIT_NAME)!=null){
            pu= (String) env.get("CaseFilePersistenceUnitName");
        }
        EntityManagerFactory oldEmf = EntityManagerFactoryManager.get().remove(pu);
        if(oldEmf!=null){
            oldEmf.close();
        }
        JpaCaseFilePersistence result = (JpaCaseFilePersistence) env.get(CaseFilePersistence.ENV_NAME);
        if(result==null){
            //create it once only
            result= new JpaCaseFilePersistence(pu, (String) env.get("deploymentId"), cl);
            env.set(CaseFilePersistence.ENV_NAME, result);
        }
        return result;
    }
}
