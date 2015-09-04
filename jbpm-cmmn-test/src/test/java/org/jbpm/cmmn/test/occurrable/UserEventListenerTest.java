package org.jbpm.cmmn.test.occurrable;

import org.jbpm.cmmn.instance.CaseInstance;

public class UserEventListenerTest extends AbstractOccurrableTestCase {

	public UserEventListenerTest() {
	}

	public String getCaseName() {
		return "UserEventListenerTests";
	}

	public String getProcessFile() {
		return "test/occurrable/UserEventListenerTests.cmmn";
	}

	@Override
	protected void triggerOccurrence() throws Exception {
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		caseInstance.signalEvent("TheUserEvent", new Object());
		getPersistence().commitAndSendCaseFileItemEvents();
	}

}
