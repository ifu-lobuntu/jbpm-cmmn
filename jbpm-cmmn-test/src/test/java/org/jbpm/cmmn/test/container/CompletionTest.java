package org.jbpm.cmmn.test.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.test.AbstractConstructionTestCase;
import org.junit.Test;
import org.kie.api.task.model.TaskSummary;

import test.cmmn.ConstructionCase;
import test.cmmn.House;
import test.cmmn.HousePlan;

public class CompletionTest extends AbstractConstructionTestCase {

	public CompletionTest() {
	}

	@Test
	public void testAfterOccurrenceOfMilestone() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN

		triggerStartOfMilestone();
		// *****THEN

		assertNodeTriggered(caseInstance.getId(), "TheMilestonePlanItem");
		assertNodeTriggered(caseInstance.getId(), "TheTask");
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		assertFalse(caseInstance.canComplete());
		getPersistence().commit();
	}

	@Test
	public void testAfterCompletionOfTask() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfMilestone();
		List<TaskSummary> tasks = getRuntimeEngine().getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
		assertEquals(1, tasks.size());
		// *****WHEN
		getRuntimeEngine().getTaskService().start(tasks.get(0).getId(), "Builder");
		getRuntimeEngine().getTaskService().complete(tasks.get(0).getId(), "Builder", new HashMap<String, Object>());
		// *****THEN
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		assertTrue(caseInstance.canComplete());
		getPersistence().commit();
	}

	@Test
	public void testAfterStartOfCaseInstance() throws Exception {
		// *****GIVEN
		// *****WHEN
		givenThatTheTestCaseIsStarted();

		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		assertFalse(caseInstance.canComplete());
		getPersistence().commit();
		// *****THEN

	}

	protected void givenThatTheTestCaseIsStarted() {
		createRuntimeManager("test/container/CompletionTests.cmmn");
		Map<String, Object> params = new HashMap<String, Object>();
		getPersistence().start();

		ConstructionCase cc = new ConstructionCase("/cases/case1");
		housePlan = new HousePlan(cc);
		house = new House(cc);
		getPersistence().persist(cc);
		getPersistence().commit();
		params.put("housePlan", housePlan);
		params.put("house", house);
		params.put(WorkItemParameters.INITIATOR, "Spielman");
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().startProcess("CompletionTests", params);
		getPersistence().commit();
		assertProcessInstanceActive(caseInstance.getId(), getRuntimeEngine().getKieSession());
		assertNodeTriggered(caseInstance.getId(), "defaultSplit");
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "onTheUserEventOccurPartId");
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "onTheMilestoneOccurPartId");
		getPersistence().commit();
	}

	private void triggerStartOfMilestone() throws Exception {
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		caseInstance.signalEvent("TheUserEvent", new Object());
		getPersistence().commit();
	}

}
