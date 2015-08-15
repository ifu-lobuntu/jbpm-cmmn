package org.jbpm.cmmn.test.container;

import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.junit.Test;

public abstract class AbstractPlanItemInstanceContainerLifecycleTest extends AbstractPlanItemInstanceContainerTest {

    public AbstractPlanItemInstanceContainerLifecycleTest() {
        super();
    }

    //	@Test
//	public void testCaseLifecycleCannotComplete() throws Exception {
//		// *****GIVEN
//		givenThatTheTestCaseIsStarted();
//		// *****WHEN
//		triggerInitialActivity();
//		// *****THEN
//		getPersistence().start();
//		// Cannot complete it
//		assertFalse(getPlanItemInstanceContainer().canComplete());
//		getPersistence().commit();
//		try {
//			getTaskService().complete(getTaskService().getTaskByWorkItemId(getWorkitemId()).getId(), "ConstructionProjectManager",
//					new HashMap<String, Object>());
//			fail("The stage/case instance cannot be completed yet");
//		} catch (RuntimeException e) {
//			getPersistence().close();
//			Status currentStatus = getTaskService().getTaskByWorkItemId(getWorkitemId()).getTaskData().getStatus();
//			assertEquals(org.kie.api.task.model.Status.InProgress, currentStatus);
//		}
//		getPersistence().start();
//		printState(" ", getPlanItemInstanceContainer());
//		getPersistence().commit();
//	}



    @Test
    public void testCaseLifecycleCanComplete() throws Exception {
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerInitialActivity();
        // *****WHEN
        // complete some pending tasks
        completeTasks(getPlan());

        // *****THEN
        // Now we can complete it
        getPersistence().start();
        PlanItemInstanceContainer piic = getPlanItemInstanceContainer();
        assertTrue(piic.canComplete());
        assertEquals(PlanElementState.ACTIVE, piic.getPlanElementState());
        printState(" ", piic);
        getPersistence().commit();
        completePlanItemInstanceContainer();
        getPersistence().start();
		assertEquals(PlanElementState.COMPLETED, getPlanItemInstanceContainer().getPlanElementState());
		printState(" ", getPlanItemInstanceContainer());
		getPersistence().commit();
		// After completion, the planItem's state remain the same
		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.COMPLETED);
		testCloseAndOutput(piic);
    }

    protected void completePlanItemInstanceContainer() {
        getCmmnService().transitionCase(caseInstance.getId(), PlanItemTransition.COMPLETE);
    }

    protected void testCloseAndOutput(PlanItemInstanceContainer piic) {
    }
	@Test

	public void testTaskLifecycleSuspendAndReactivate() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		CaseInstance subCase = triggerInitialActivity();
        assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.ENABLED);
        assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.ACTIVE);
        assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ACTIVE);

		// *****WHEN
        suspedPlanItemInstanceContainer();

		// *******THEN
		getPersistence().start();
		PlanItemInstanceContainer piic = getPlanItemInstanceContainer();
		assertEquals(PlanElementState.SUSPENDED, piic.getPlanElementState());
		printState(" ", piic);
		getPersistence().commit();
		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.SUSPENDED);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.SUSPENDED);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.SUSPENDED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.SUSPENDED);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.SUSPENDED);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.SUSPENDED);
		assertEquals(PlanElementState.SUSPENDED, reloadCaseInstance(subCase).getPlanElementState());
		// reactivate
        continuePlanItemInstanceContainer();
		assertEquals(PlanElementState.ACTIVE, reloadCaseInstance(subCase).getPlanElementState());
		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.ENABLED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ACTIVE);
	}

    protected void continuePlanItemInstanceContainer() {
        getPersistence().start();
        getCmmnService().transitionCase(caseInstance.getId(), PlanItemTransition.REACTIVATE);
        getPersistence().commit();
    }

    protected void suspedPlanItemInstanceContainer() {
        getPersistence().start();
        getCmmnService().transitionCase(caseInstance.getId(), PlanItemTransition.SUSPEND);
        getPersistence().commit();
    }

	@Test
	public void testTaskLifecycleFailed() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		CaseInstance subCase = triggerInitialActivity();
		// Task taskByWorkItemId = getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId());
		// *****WHEN
        failPlanItemInstanceContainer();
        // *******THEN
        assertEquals(PlanElementState.FAILED, getPlanItemInstanceContainer().getPlanElementState());
		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.ENABLED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ACTIVE);
		assertEquals(PlanElementState.ACTIVE, reloadCaseInstance(subCase).getPlanElementState());
		// Task taskByWorkItemId = getTaskService().getTaskByWorkItemId(getWorkitemId());
		// List<TaskSummary> subTasksByParent =
		// getTaskService().getSubTasksByParent(taskByWorkItemId.getTaskData().getWorkItemId());
		// assertTaskInState(subTasksByParent, "TheHumanTaskPlanItem", Status.Reserved);
		// assertTaskInState(subTasksByParent, "TheStagePlanItem", Status.Reserved);
		// assertTaskInState(subTasksByParent, "TheCaseTaskPlanItem", Status.InProgress);
		// // reactivate
		// getTaskService().resume(taskByWorkItemId.getId(), "ConstructionProjectManager");
		// assertEquals(PlanElementState.ACTIVE, reloadCaseInstance(subCase).getPlanElementState());
		// assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		// assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		// assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		// assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.ENABLED);
		// assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		// assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		// // assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.AVAILABLE);
		// assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ACTIVE);
	}

    protected void failPlanItemInstanceContainer() {
        getPersistence().start();
        getCmmnService().transitionCase(caseInstance.getId(), PlanItemTransition.FAULT);
        getPersistence().commit();
    }

    @Test
	public void testTaskLifecycleTerminate() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		CaseInstance subCase = triggerInitialActivity();
        assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.ENABLED);
        assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.ACTIVE);
        assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ACTIVE);
		// *****WHEN
        terminatePlanItemInstanceContainer();
		// *******THEN
		getPersistence().start();
		PlanItemInstanceContainer piic = getPlanItemInstanceContainer();
		assertEquals(PlanElementState.TERMINATED, piic.getPlanElementState());
		printState(" ", piic);
		getPersistence().commit();
		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.TERMINATED);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.TERMINATED);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.TERMINATED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.TERMINATED);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.TERMINATED);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.TERMINATED);
		assertNull(reloadCaseInstance(subCase));
		// reactivate
		// getTaskService().resume(taskByWorkItemId.getId(), "ConstructionProjectManager");
		// assertEquals(PlanElementState.ACTIVE, reloadCaseInstance(subCase).getPlanElementState());
		// assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		// assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		// assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		// assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.ENABLED);
		// assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		// assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		// // assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.AVAILABLE);
		// assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ACTIVE);
	}

    protected void terminatePlanItemInstanceContainer() {
        getPersistence().start();
        getCmmnService().transitionCase(caseInstance.getId(), PlanItemTransition.TERMINATE);
        getPersistence().commit();
    }

}