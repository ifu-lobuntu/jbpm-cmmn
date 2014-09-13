package org.jbpm.cmmn.test.casefileitem;

import org.jbpm.cmmn.casefile.jcr.JcrSubscriptionManager;
import org.jbpm.cmmn.instance.impl.CaseInstanceImpl;
import org.jbpm.cmmn.instance.subscription.impl.DemarcatedSubscriptionContext;

public class JcrDemarcatedSubscriptionEventTest extends JcrCaseFileItemEventTest {
	@Override
	protected JcrSubscriptionManager getSubscriptionManager() {
		return null;
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

}
