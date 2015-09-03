package org.jbpm.cmmn.instance;


import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;

public interface CaseFileImplementation {

    ObjectMarshallingStrategy[] getObjectMarshallingStrategies(Environment environmentTemplate);

    SubscriptionManager<?> getSubscriptionManager(Environment environmentTemplate);

    CaseFilePersistence getCaseFilePersistence(Environment env);
}
