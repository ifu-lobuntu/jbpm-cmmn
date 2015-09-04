package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.instance.CaseFileImplementation;
import org.jbpm.cmmn.instance.CaseFilePersistence;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;

public class JpaCaseFileImplementation implements CaseFileImplementation {

    public static final String CASE_FILE_PERSISTENCE_UNIT_NAME = "CaseFilePersistenceUnitName";

    @Override
    public ObjectMarshallingStrategy[] getObjectMarshallingStrategies(Environment env) {

        return new ObjectMarshallingStrategy[]{new JpaPlaceHolderResolverStrategy(env)
                , new JpaCollectionPlaceHolderResolverStrategy(env)};
    }

    @Override
    public SubscriptionManager<?> getSubscriptionManager(Environment env) {
        return new HibernateSubscriptionManager(getCaseFilePersistence(env));
    }

    @Override
    public JpaCaseFilePersistence getCaseFilePersistence(Environment env) {
        String pu = "org.jbpm.persistence.jpa";
        if(env.get(CASE_FILE_PERSISTENCE_UNIT_NAME)!=null){
            pu= (String) env.get("CaseFilePersistenceUnitName");
        }
        JpaCaseFilePersistence result = (JpaCaseFilePersistence) env.get(CaseFilePersistence.ENV_NAME);
        if(result==null){
            //create it once only
            result= new JpaCaseFilePersistence(pu, (String) env.get("deploymentId"));
            env.set(CaseFilePersistence.ENV_NAME, result);
        }
        return result;
    }
}
