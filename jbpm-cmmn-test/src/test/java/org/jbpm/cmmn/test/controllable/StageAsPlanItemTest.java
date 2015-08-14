package org.jbpm.cmmn.test.controllable;

import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.impl.StageInstance;
import org.kie.api.task.model.Status;

public class StageAsPlanItemTest extends AbstractControllableLifecycleTest {
	{
		super.isJpa = true;
	}

	public StageAsPlanItemTest() {
	}

	// @Test
	// public void testStageTriggered() throws Exception {
	// // *****GIVEN
	// givenThatTheTestCaseIsStarted();
	// triggerTaskCreation();
	// assertNodeTriggered(caseInstance.getId(), "TopLevelTask");
	// List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
	// assertEquals(1, list.size());
	// getTaskService().start(list.get(0).getId(), "Builder");
	//
	// // *****WHEN
	// getTaskService().complete(list.get(0).getId(), "Builder", new HashMap<String,Object>());
	// // *****THEN
	// assertNodeTriggered(caseInstance.getId(), "TheStagePlanItem");
	// list = getTaskService().getTasksAssignedAsPotentialOwner("Administrator", "en-UK");
	// assertEquals(2, list.size()); //Tasks representing StageImpl and the Case
	// assertTaskTypeCreated(list, "TheStagePlanItem");
	// }

	@Override
	public String getEventGeneratingTaskUser() {
		return "ConstructionProjectManager";
	}

	@Override
	protected String getCaseOwner() {
		return "Spielman";
	}

	@Override
	public String getNameOfProcessToStart() {
		return "StageTests";
	}

	@Override
	public String[] getProcessFileNames() {
		return new String[] { "test/controllable/StageAsPlanItemTests.cmmn" };
	}

}
