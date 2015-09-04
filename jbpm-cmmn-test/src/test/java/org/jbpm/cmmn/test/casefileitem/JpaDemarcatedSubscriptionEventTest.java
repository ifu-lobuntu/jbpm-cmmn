package org.jbpm.cmmn.test.casefileitem;

import org.jbpm.cmmn.instance.CaseFileImplementation;
import org.jbpm.cmmn.instance.impl.CaseInstanceImpl;
import org.jbpm.cmmn.instance.subscription.impl.DemarcatedSubscriptionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JpaDemarcatedSubscriptionEventTest extends JpaPersistentSubscriptionEventTest {
    @Before
    public void setup() {
        addEnvironmentEntry(CaseFileImplementation.DEMARCATED_SUBSCRIPTION,"true");
    }
    @After
    public void cleanup() {
        addEnvironmentEntry(CaseFileImplementation.DEMARCATED_SUBSCRIPTION,"false");
    }

    @Override
    protected void maybeStartSubscription() {
        getPersistence().start();
        DemarcatedSubscriptionContext.activateSubscriptionsFrom((CaseInstanceImpl) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId()));
    }

    @Override
    protected void endSubscription() {
        DemarcatedSubscriptionContext.deactiveSubscriptions();
    }

    @Test
    public void testCreationOfObjectInCollectionFileItem() throws Exception {
        super.testCreationOfObjectInCollectionFileItem();
    }
}
