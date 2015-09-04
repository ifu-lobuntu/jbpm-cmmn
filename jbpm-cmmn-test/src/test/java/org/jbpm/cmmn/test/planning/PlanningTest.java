package org.jbpm.cmmn.test.planning;

import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannedItem;
import org.jbpm.cmmn.test.container.AbstractPlanItemInstanceContainerTest;
import org.junit.Test;

import java.util.Collection;

public class PlanningTest extends AbstractPlanItemInstanceContainerTest {
	{
		isJpa = true;
	}

	@Test
	public void testStartPlanning() throws Exception {
		givenThatTheTestCaseIsStarted();
		triggerInitialActivity();
		getPersistence().start();
		Plan pti = getCmmnService().startPlanning(caseInstance.getId(), "ConstructionProjectManager", false);
		assertEquals(0, pti.getApplicableDiscretionaryItems().size());
		getPersistence().commitAndSendCaseFileItemEvents();
		getPersistence().start();
		reloadCaseInstance(caseInstance).getRoleInstance("ConstructionProjectManagers").addRoleAssignment("ConstructionProjectManager");
		getPersistence().commitAndSendCaseFileItemEvents();
		getPersistence().start();
		pti = getCmmnService().startPlanning(caseInstance.getId(),"ConstructionProjectManager", false);
		getPersistence().commitAndSendCaseFileItemEvents();
		assertPlanItemDefinitionPresent(pti.getApplicableDiscretionaryItems(), "TheCaseTask");
		assertPlanItemDefinitionPresent(pti.getApplicableDiscretionaryItems(), "TheHumanTask");
		assertPlanItemDefinitionPresent(pti.getApplicableDiscretionaryItems(), "TheStage");
		assertPlannableItemPresent(pti.getPlannedItems(), "TheCaseTaskPlanItem");
		assertPlannableItemPresent(pti.getPlannedItems(), "TheStagePlanItem");
		assertPlannableItemPresent(pti.getPlannedItems(), "TheHumanTaskPlanItem");
		assertEquals(4, pti.getApplicableDiscretionaryItems().size());
		for (ApplicableDiscretionaryItem pts : pti.getApplicableDiscretionaryItems()) {
			if ("theUnapplicableItem".equals(pts.getDiscretionaryItemId())) {
				fail();
			}
		}
	}

	@Test
	public void testPreparePlannableItem() throws Exception {
		givenThatTheTestCaseIsStarted();
		triggerInitialActivity();
		PlannedItem plannedCaseTask = getCmmnService().preparePlannedItem(caseInstance.getId(), "theCaseTaskDiscretionaryItemId");
		PlannedItem plannedHumanTask = getCmmnService().preparePlannedItem(caseInstance.getId(), "theHumanTaskDiscretionaryItemId");
		PlannedItem plannedStage = getCmmnService().preparePlannedItem(caseInstance.getId(), "theStageDiscretionaryItemId");
		getPersistence().start();
		CaseInstance ci = reloadCaseInstance(caseInstance);
		assertEquals("TheCaseTask", plannedCaseTask.getName());
		assertEquals("TheHumanTask", plannedHumanTask.getName());
		assertEquals("TheStage", plannedStage.getName());
		assertEquals(PlanElementState.ENABLED, plannedCaseTask.getState());
		assertEquals(PlanElementState.ENABLED, plannedHumanTask.getState());
		assertEquals(PlanElementState.ACTIVE, plannedStage.getState());
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	@Test
	public void testSubmitPlanWithContainerAlreadyActive() throws Exception {
//		givenThatTheTestCaseIsStarted();
//		triggerInitialActivity();
//		getPersistence().start();
//		Long parentTaskId = getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId();
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		PlannedItem plannedCaseTask = getCmmnService().preparePlannedItem(parentTaskId, "theCaseTaskDiscretionaryItemId");
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		PlannedItem plannedHumanTask = getCmmnService().preparePlannedItem(parentTaskId, "theHumanTaskDiscretionaryItemId");
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		PlannedItem plannedStage = getCmmnService().preparePlannedItem(parentTaskId, "theStageDiscretionaryItemId");
//		getPersistence().commitAndSendCaseFileItemEvents();
//		for (TaskSummary s : getTaskService().getSubTasksByParent(parentTaskId)) {
//			if(s.getName().equals("TheHumanTaskPlanItem")){
//				getPersistence().start();
//				//Get it in the right state
//				getTaskService().claim(s.getId(), "Builder");
//				getPersistence().commitAndSendCaseFileItemEvents();
//			}
//		}
//		getPersistence().start();
//		PlanningTableInstance pti = getCmmnService().startPlanning(
//				getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(), "ConstructionProjectManager", false);
//		getPersistence().commitAndSendCaseFileItemEvents();
//		for (PlannedItem plannableTask : pti.getPlannedItems()) {
//			((InternalTaskData) plannableTask.getTaskData()).setActualOwner(new UserImpl("salaboy"));
//			plannableTask.getPeopleAssignments().getPotentialOwners().add(new UserImpl("salaboy"));
//		}
//		getPersistence().start();
//		getCmmnService().submitPlan(parentTaskId, pti.getPlannedItems(), false);
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		caseInstance = reloadCaseInstance(caseInstance);
//		assertFalse(caseInstance.canComplete());
//		assertNotNull(caseInstance.findNodeForWorkItem(plannedCaseTask.getTaskData().getWorkItemId()));
//		assertNotNull(caseInstance.findNodeForWorkItem(plannedHumanTask.getTaskData().getWorkItemId()));
//		assertNotNull(caseInstance.findNodeForWorkItem(plannedStage.getTaskData().getWorkItemId()));
//		assertEquals(PlanElementState.ENABLED, caseInstance.findNodeForWorkItem(plannedCaseTask.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		assertEquals(PlanElementState.ENABLED, caseInstance.findNodeForWorkItem(plannedHumanTask.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		// Automatic activation:
//		assertEquals(PlanElementState.ACTIVE, caseInstance.findNodeForWorkItem(plannedStage.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		List<TaskSummary> tasks = getTaskService().getTasksOwned("salaboy", "en-UK");
//		assertEquals(6, tasks.size());// TheHumanTaskPlanItem is in Ready state
//										// in spite of having been assigned, but
//										// that is more or less right
//		assertTaskInState(tasks, plannedCaseTask.getPlanItemName(), Status.Reserved);
//		assertTaskInState(tasks, plannedHumanTask.getPlanItemName(), Status.Reserved);
//		assertTaskInState(tasks, plannedStage.getPlanItemName(), Status.InProgress);
//		super.completeTasks(tasks);
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		caseInstance = reloadCaseInstance(caseInstance);
//		assertFalse(caseInstance.canComplete());
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		getTaskService().start(plannedHumanTask.getId(), "salaboy");
//		getTaskService().complete(plannedHumanTask.getId(), "salaboy", new HashMap<String, Object>());
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		caseInstance = reloadCaseInstance(caseInstance);
//		assertTrue(caseInstance.canComplete());
//		getPersistence().commitAndSendCaseFileItemEvents();
	}

	@Test
	public void testSubmitPlanWithContainerNotActive() throws Exception {
//		givenThatTheTestCaseIsStarted();
//		triggerInitialActivity();
//		Long parentTaskId = getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId();
//		PlannedItem plannedCaseTask = getCmmnService().preparePlannedItem(parentTaskId, "theCaseTaskDiscretionaryItemId");
//		PlannedItem plannedHumanTask = getCmmnService().preparePlannedItem(parentTaskId, "theHumanTaskDiscretionaryItemId");
//		PlannedItem plannedStage = getCmmnService().preparePlannedItem(parentTaskId, "theStageDiscretionaryItemId");
//		PlanningTableInstance pti = getCmmnService().startPlanning(
//				getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(), "ConstructionProjectManager", true);
//		assertEquals(PlanElementState.SUSPENDED, reloadCaseInstance().getPlanElementState());
//		for (PlannedItem PlannedItem : pti.getPlannedItems()) {
//			((InternalTaskData) PlannedItem.getTaskData()).setActualOwner(new UserImpl("salaboy"));
//		}
//		getPersistence().start();
//		getCmmnService().submitPlan(parentTaskId, pti.getPlannedItems(), false);
//		getPersistence().commitAndSendCaseFileItemEvents();
//		List<TaskSummary> tasks = getTaskService().getTasksOwned("salaboy",
//				Arrays.asList(Status.Created, Status.Ready, Status.Reserved, Status.Suspended), null);
//		assertEquals(6, tasks.size());
//		for (TaskSummary taskSummary : tasks) {
//			if (taskSummary.getId() == plannedCaseTask.getId() || taskSummary.getId() == plannedHumanTask.getId()
//					|| taskSummary.getId() == plannedStage.getId()) {
//				// They're all ENABLED
//				assertEquals(Status.Created, taskSummary.getStatus());
//			} else {
//				assertEquals(Status.Suspended, taskSummary.getStatus());
//			}
//		}
//		getPersistence().start();
//		caseInstance = reloadCaseInstance(caseInstance);
//		printState("", caseInstance);
//		assertNotNull(caseInstance.findNodeForWorkItem(plannedCaseTask.getTaskData().getWorkItemId()));
//		assertNotNull(caseInstance.findNodeForWorkItem(plannedHumanTask.getTaskData().getWorkItemId()));
//		assertEquals(PlanElementState.INITIAL, caseInstance.findNodeForWorkItem(plannedCaseTask.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		assertEquals(PlanElementState.INITIAL, caseInstance.findNodeForWorkItem(plannedHumanTask.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		assertEquals(PlanElementState.INITIAL, caseInstance.findNodeForWorkItem(plannedStage.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		getTaskService().resume(parentTaskId, "ConstructionProjectManager");
//		getPersistence().commitAndSendCaseFileItemEvents();
//		getPersistence().start();
//		caseInstance = reloadCaseInstance(caseInstance);
//		assertEquals(PlanElementState.ENABLED, caseInstance.findNodeForWorkItem(plannedCaseTask.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		assertEquals(PlanElementState.ENABLED, caseInstance.findNodeForWorkItem(plannedHumanTask.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		// Automatic activation:
//		assertEquals(PlanElementState.ACTIVE, caseInstance.findNodeForWorkItem(plannedStage.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		getPersistence().commitAndSendCaseFileItemEvents();
	}

	private void assertPlanItemDefinitionPresent(Collection<ApplicableDiscretionaryItem> pts, String itemName) {
		for (ApplicableDiscretionaryItem pt : pts) {
			if (itemName.equals(pt.getPlanItemName())) {
				return;
			}
		}
		fail("Item with name '" + itemName + "' not found");
	}

	public void assertItemPresent(Collection<PlannedItem> pts, String itemName) {
		for (PlannedItem pt : pts) {
			if (itemName.equals(pt.getName())) {
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