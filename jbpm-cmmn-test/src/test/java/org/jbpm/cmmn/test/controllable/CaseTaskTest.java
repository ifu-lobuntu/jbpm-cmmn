package org.jbpm.cmmn.test.controllable;

import java.util.Collection;

import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.impl.AbstractCallingTaskInstance;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannedItem;
import org.junit.Test;

import test.cmmn.HousePlan;
import test.cmmn.WallPlan;

public class CaseTaskTest extends AbstractControllableLifecycleTest {
	{
		super.isJpa = true;
	}

	public CaseTaskTest() {
	}

	public String getEventGeneratingTaskUser() {
		return "ConstructionProjectManager";
	}

	@Override
	protected String getBusinessAdministratorUser() {
		return "ConstructionProjectManager";
	}

	@Override
	protected String getCaseOwner() {
		return "Spielman";
	}

	@Test
	public void testParameterMappings() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN
		triggerStartOfTask(); // Creates a second wallPlan
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannedItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		// *******THEN
		getPersistence().start();
		long id = getSubProcessInstanceId(theEventGeneratingTaskPlanItem.getNodeInstanceId());
		CaseInstance pi = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(id);
		HousePlan housePlan = (HousePlan) pi.getVariable("housePlan");
		@SuppressWarnings("unchecked")
		Collection<WallPlan> wallPlans = (Collection<WallPlan>) pi.getVariable("wallPlans");
		assertEquals(super.housePlan.getId(), housePlan.getId());
		assertEquals(2, wallPlans.size());
		for (WallPlan wallPlan : wallPlans) {
			assertEquals("I Am Transformed", wallPlan.getShortDescription());
		}
		getPersistence().commit();
		// *****THEN
	}

	@Override
	public String[] getProcessFileNames() {
		return new String[] { "test/controllable/CaseTaskTests.cmmn", "test/SubCase.cmmn" };
	}

	@Override
	public String getNameOfProcessToStart() {
		return "CaseTaskTests";
	}


	private long getSubProcessInstanceId(long uid) {
		return ((AbstractCallingTaskInstance) reloadCaseInstance(caseInstance).getNodeInstance(uid, true)).getProcessInstanceId();
	}

}
