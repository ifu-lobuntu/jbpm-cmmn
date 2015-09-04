package org.jbpm.cmmn.instance;


import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;

public interface CaseFileImplementation {

    String CASE_FILE_IMPLEMENTATION_CLASS =  CaseFileImplementation.class.getName()+"Class";
    String DEMARCATED_SUBSCRIPTION =  CaseFileImplementation.class.getName()+"DemarcatedSubscriptions";

    ObjectMarshallingStrategy[] getObjectMarshallingStrategies(Environment environmentTemplate);

    SubscriptionManager<?> getSubscriptionManager(Environment environmentTemplate);

    CaseFilePersistence getCaseFilePersistence(Environment env);
}