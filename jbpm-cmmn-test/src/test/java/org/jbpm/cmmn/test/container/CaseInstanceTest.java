package org.jbpm.cmmn.test.container;

import java.util.Map;

import org.jbpm.cmmn.flow.core.impl.DefaultJoin;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.CaseInstanceImpl;
import org.junit.Test;

import test.cmmn.WallPlan;

public class CaseInstanceTest extends AbstractPlanItemInstanceContainerLifecycleTest {

	{
		super.isJpa = true;
	}

	public CaseInstanceTest() {
	}

	@Test
	public void exitCriteria() {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		CaseInstance subCase = triggerInitialActivity();
		// *****WHEN
		getRuntimeEngine().getKieSession().signalEvent("EndUserEvent", new Object(), caseInstance.getId());
		// *******THEN
		getPersistence().start();
		PlanItemInstanceContainer piic = getPlanItemInstanceContainer();
		assertEquals(PlanElementState.TERMINATED, piic.getPlanElementState());
		printState(" ", piic);
		getPersistence().commitAndSendCaseFileItemEvents();
		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.TERMINATED);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.TERMINATED);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.TERMINATED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.COMPLETED);
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

	@SuppressWarnings("unchecked")
	protected void testCloseAndOutput(PlanItemInstanceContainer piic) {
		// and close it
		if (piic instanceof CaseInstanceImpl) {
			getPersistence().start();
			CaseInstance ci = reloadCaseInstance();
			ci.signalEvent(DefaultJoin.CLOSE, new Object());
			assertEquals(PlanElementState.CLOSED, ci.getPlanElementState());
			assertNull(getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId()));
			Map<String, Object> result = ci.getResult();
			assertTrue(result.get("theResultingWallPlan") instanceof WallPlan);
			getPersistence().commitAndSendCaseFileItemEvents();
		}
		// *****THEN
	}

	@Override
	protected void ensurePlanItemContainerIsStarted() {

	}

	@Override
	public String getCaseName() {
		return "CaseInstanceTests";
	}

	@Override
	public String getProcessFile() {
		return "test/container/CaseInstanceTests.cmmn";
	}

}