package org.jbpm.cmmn.test.planning;

import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.impl.HumanTaskInstance;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannedItem;
import org.jbpm.cmmn.test.container.AbstractPlanItemInstanceContainerTest;
import org.junit.Test;
import org.kie.api.task.model.Task;
import test.cmmn.HousePlan;
import test.cmmn.WallPlan;

import java.util.Collection;
import java.util.Map;

public class InputOverrideTest extends AbstractPlanItemInstanceContainerTest {
	{
		isJpa = true;
	}

	@Test
	public void testOverrideHumanTaskInput() throws Exception {
		givenThatTheTestCaseIsStarted();
		triggerInitialActivity();
		getPersistence().start();
		Plan pti = getCmmnService().startPlanning(caseInstance.getId(), "ConstructionProjectManager", false);
		assertEquals(0, pti.getApplicableDiscretionaryItems().size());
		getPersistence().commit();
		getPersistence().start();
		reloadCaseInstance(caseInstance).getRoleInstance("ConstructionProjectManagers").addRoleAssignment("ConstructionProjectManager");
		getPersistence().commit();
		getPersistence().start();
		pti = getCmmnService().startPlanning(caseInstance.getId(),"ConstructionProjectManager", false);
		getPersistence().commit();
		assertPlanItemDefinitionPresent(pti.getApplicableDiscretionaryItems(), "TheCaseTask");
		assertPlanItemDefinitionPresent(pti.getApplicableDiscretionaryItems(), "TheHumanTask");
		assertPlannableItemPresent(pti.getPlannedItems(), "TheCaseTaskPlanItem");
		assertPlannableItemPresent(pti.getPlannedItems(), "TheHumanTaskPlanItem");
		// ***** WHEN
		getPersistence().start();
		long nodeInstanceId = pti.getPlannableItemsFor("TheHumanTaskPlanItem").get(0).getNodeInstanceId();
		Map<String, Object> input = getCmmnService().getInputTo(caseInstance.getId(), nodeInstanceId);
		HousePlan housePlan= (HousePlan) input.get("housePlanTaskParameter");
		WallPlan oldWallPlan= (WallPlan) input.get("wallPlanTaskParameter");
		oldWallPlan.setShortDescription("The Old Wallplan");
		WallPlan addedWallPlan = new WallPlan(housePlan);
		getPersistence().persist(addedWallPlan);
		addedWallPlan.setShortDescription("The new wallplan");
		input.put("wallPlanTaskParameter", addedWallPlan);
		getPersistence().commit();
		getPersistence().start();
		getCmmnService().overrideInputTo(caseInstance.getId(), nodeInstanceId, input);
		getPersistence().commit();
		// *****THEN
		getPersistence().start();
		Map<String, Object> foundInput = getCmmnService().getInputTo(caseInstance.getId(), nodeInstanceId);
		WallPlan foundWallPlan = (WallPlan) foundInput.get("wallPlanTaskParameter");
		assertEquals("The new wallplan", foundWallPlan.getShortDescription());
		HumanTaskInstance hti= (HumanTaskInstance) reloadCaseInstance().getNodeInstance(nodeInstanceId, true);
		Task taskByWorkItemId = getTaskService().getTaskByWorkItemId(hti.getWorkItemId());
		Map<String, Object> taskParameters = getTaskService().getTaskContent(taskByWorkItemId.getId());
		foundWallPlan = (WallPlan) taskParameters.get("wallPlanTaskParameter");
		assertEquals("The new wallplan", foundWallPlan.getShortDescription());
		getPersistence().commit();
		System.out.println();

	}

	private void assertPlanItemDefinitionPresent(Collection<ApplicableDiscretionaryItem> pts, String itemName) {
		for (ApplicableDiscretionaryItem pt : pts) {
			if (itemName.equals(pt.getPlanItemName())) {
				return;
			}
		}
		fail("Item with name '" + itemName + "' not found");
	}


	public void assertPlannableItemPresent(Collection<PlannedItem> pts, String itemName) {
		for (PlannedItem pt : pts) {
			if (itemName.equals(pt.getName())) {
				return;
			}
		}
		fail("Item with name '" + itemName + "' not found");
	}

	@Override
	public String getProcessFile() {
		return "test/planning/PlanningTests.cmmn";
	}

	@Override
	public String getCaseName() {
		return "PlanningTests";
	}

	@Override
	protected void ensurePlanItemContainerIsStarted() {
	}

}