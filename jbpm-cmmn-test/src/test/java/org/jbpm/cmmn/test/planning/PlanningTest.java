package org.jbpm.cmmn.test.planning;

import org.jbpm.cmmn.task.model.PlannableTask;
import org.jbpm.cmmn.task.model.PlannableTaskSummary;
import org.jbpm.cmmn.task.model.PlanningTableInstance;
import org.jbpm.cmmn.test.container.AbstractPlanItemInstanceContainerTest;

public class PlanningTest extends AbstractPlanItemInstanceContainerTest {
//	PlanningServiceImpl planningService = new PlanningServiceImpl();
//	{
//		isJpa = true;
//	}
//
//	@Test
//	public void testStartPlanning() throws Exception {
//		givenThatTheTestCaseIsStarted();
//		triggerInitialActivity();
//		getPersistence().start();
//		PlanningTableInstance pti = getPlanningService().startPlanning(
//				getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(), "ConstructionProjectManager", false);
//		assertEquals(0, pti.getApplicableDiscretionaryItems().size());
//		getPersistence().commit();
//		getPersistence().start();
//		reloadCaseInstance(caseInstance).getRoleInstance("ConstructionProjectManagers").addRoleAssignment("ConstructionProjectManager");
//		getPersistence().commit();
//		getPersistence().start();
//		pti = getPlanningService().startPlanning(getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(),
//				"ConstructionProjectManager", false);
//		for (PlannableTask summary : pti.getPlannableTasks()) {
//			assertNull(summary.getDiscretionaryItemId());
//		}
//		getPersistence().commit();
//		assertPlanItemDefinitionPresent(pti.getApplicableDiscretionaryItems(), "TheCaseTask");
//		assertPlanItemDefinitionPresent(pti.getApplicableDiscretionaryItems(), "TheHumanTask");
//		assertPlanItemDefinitionPresent(pti.getApplicableDiscretionaryItems(), "TheStage");
//		assertPlannableTaskPresent(pti.getPlannableTasks(), "TheCaseTaskPlanItem");
//		assertPlannableTaskPresent(pti.getPlannableTasks(), "TheStagePlanItem");
//		assertPlannableTaskPresent(pti.getPlannableTasks(), "TheHumanTaskPlanItem");
//		assertEquals(4, pti.getApplicableDiscretionaryItems().size());
//		for (ApplicableDiscretionaryItem pts : pti.getApplicableDiscretionaryItems()) {
//			if ("theUnapplicableItem".equals(pts.getDiscretionaryItemId())) {
//				fail();
//			}
//		}
//	}
//
//	@Test
//	public void testPreparePlannableTask() throws Exception {
//		givenThatTheTestCaseIsStarted();
//		triggerInitialActivity();
//		PlannableTask plannedCaseTask = getPlanningService().preparePlannableTask(
//				getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(), "theCaseTaskDiscretionaryItemId");
//		PlannableTask plannedHumanTask = getPlanningService().preparePlannableTask(
//				getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(), "theHumanTaskDiscretionaryItemId");
//		PlannableTask plannedStage = getPlanningService().preparePlannableTask(
//				getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(), "theStageDiscretionaryItemId");
//		getPersistence().start();
//		CaseInstance ci = reloadCaseInstance(caseInstance);
//		assertEquals("TheCaseTask", plannedCaseTask.getNames().get(0).getText());
//		assertEquals("TheHumanTask", plannedHumanTask.getNames().get(0).getText());
//		assertEquals("TheStage", plannedStage.getNames().get(0).getText());
//		assertEquals(Status.Created, plannedCaseTask.getTaskData().getStatus());
//		assertEquals(Status.Created, plannedHumanTask.getTaskData().getStatus());
//		assertEquals(Status.Created, plannedStage.getTaskData().getStatus());
//		assertNull(ci.findNodeForWorkItem(plannedCaseTask.getTaskData().getWorkItemId()));
//		assertNull(ci.findNodeForWorkItem(plannedHumanTask.getTaskData().getWorkItemId()));
//		assertNull(ci.findNodeForWorkItem(plannedStage.getTaskData().getWorkItemId()));
//		getPersistence().commit();
//	}
//
//	@Test
//	public void testActivateDiscretionaryItem() throws Exception {
//		givenThatTheTestCaseIsStarted();
//		triggerInitialActivity();
//		getPlanningService().makeDiscretionaryItemAvailable(getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(),
//				"theHumanTaskDiscretionaryItemWithEntryCriteriaId");
//		assertNodeNotTriggered(caseInstance.getId(), "TheHumanTask");
//		getPersistence().start();
//		reloadCaseInstance(caseInstance).signalEvent("DiscretionaryStartUserEvent", new Object());
//		getPersistence().commit();
//		getPersistence().start();
//		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "TheHumanTask");
//		getPersistence().commit();
//		getPersistence().start();
//		List<TaskSummary> tasksAssignedAsPotentialOwner = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
//		assertTaskInState(tasksAssignedAsPotentialOwner, "TheHumanTask", Status.Ready);
//		getPersistence().commit();
//		assertPlanItemInState(caseInstance.getId(), "TheHumanTask", PlanElementState.ENABLED);
//	}
//
//	@Test
//	public void testSubmitPlanWithContainerAlreadyActive() throws Exception {
//		givenThatTheTestCaseIsStarted();
//		triggerInitialActivity();
//		getPersistence().start();
//		Long parentTaskId = getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId();
//		getPersistence().commit();
//		getPersistence().start();
//		PlannableTask plannedCaseTask = getPlanningService().preparePlannableTask(parentTaskId, "theCaseTaskDiscretionaryItemId");
//		getPersistence().commit();
//		getPersistence().start();
//		PlannableTask plannedHumanTask = getPlanningService().preparePlannableTask(parentTaskId, "theHumanTaskDiscretionaryItemId");
//		getPersistence().commit();
//		getPersistence().start();
//		PlannableTask plannedStage = getPlanningService().preparePlannableTask(parentTaskId, "theStageDiscretionaryItemId");
//		getPersistence().commit();
//		for (TaskSummary s : getTaskService().getSubTasksByParent(parentTaskId)) {
//			if(s.getName().equals("TheHumanTaskPlanItem")){
//				getPersistence().start();
//				//Get it in the right state
//				getTaskService().claim(s.getId(), "Builder");
//				getPersistence().commit();
//			}
//		}
//		getPersistence().start();
//		PlanningTableInstance pti = getPlanningService().startPlanning(
//				getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(), "ConstructionProjectManager", false);
//		getPersistence().commit();
//		for (PlannableTask plannableTask : pti.getPlannableTasks()) {
//			((InternalTaskData) plannableTask.getTaskData()).setActualOwner(new UserImpl("salaboy"));
//			plannableTask.getPeopleAssignments().getPotentialOwners().add(new UserImpl("salaboy"));
//		}
//		getPersistence().start();
//		getPlanningService().submitPlan(parentTaskId, pti.getPlannableTasks(), false);
//		getPersistence().commit();
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
//		getPersistence().commit();
//		getPersistence().start();
//		List<TaskSummary> tasks = getTaskService().getTasksOwned("salaboy", "en-UK");
//		assertEquals(6, tasks.size());// TheHumanTaskPlanItem is in Ready state
//										// in spite of having been assigned, but
//										// that is more or less right
//		assertTaskInState(tasks, plannedCaseTask.getPlanItemName(), Status.Reserved);
//		assertTaskInState(tasks, plannedHumanTask.getPlanItemName(), Status.Reserved);
//		assertTaskInState(tasks, plannedStage.getPlanItemName(), Status.InProgress);
//		super.completeTasks(tasks);
//		getPersistence().commit();
//		getPersistence().start();
//		caseInstance = reloadCaseInstance(caseInstance);
//		assertFalse(caseInstance.canComplete());
//		getPersistence().commit();
//		getPersistence().start();
//		getTaskService().start(plannedHumanTask.getId(), "salaboy");
//		getTaskService().complete(plannedHumanTask.getId(), "salaboy", new HashMap<String, Object>());
//		getPersistence().commit();
//		getPersistence().start();
//		caseInstance = reloadCaseInstance(caseInstance);
//		assertTrue(caseInstance.canComplete());
//		getPersistence().commit();
//	}
//
//	@Test
//	public void testSubmitPlanWithContainerNotActive() throws Exception {
//		givenThatTheTestCaseIsStarted();
//		triggerInitialActivity();
//		Long parentTaskId = getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId();
//		PlannableTask plannedCaseTask = getPlanningService().preparePlannableTask(parentTaskId, "theCaseTaskDiscretionaryItemId");
//		PlannableTask plannedHumanTask = getPlanningService().preparePlannableTask(parentTaskId, "theHumanTaskDiscretionaryItemId");
//		PlannableTask plannedStage = getPlanningService().preparePlannableTask(parentTaskId, "theStageDiscretionaryItemId");
//		PlanningTableInstance pti = getPlanningService().startPlanning(
//				getTaskService().getTaskByWorkItemId(caseInstance.getWorkItemId()).getId(), "ConstructionProjectManager", true);
//		assertEquals(PlanElementState.SUSPENDED, reloadCaseInstance().getPlanElementState());
//		for (PlannableTask PlannableTask : pti.getPlannableTasks()) {
//			((InternalTaskData) PlannableTask.getTaskData()).setActualOwner(new UserImpl("salaboy"));
//		}
//		getPersistence().start();
//		getPlanningService().submitPlan(parentTaskId, pti.getPlannableTasks(), false);
//		getPersistence().commit();
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
//		getPersistence().commit();
//		getPersistence().start();
//		getTaskService().resume(parentTaskId, "ConstructionProjectManager");
//		getPersistence().commit();
//		getPersistence().start();
//		caseInstance = reloadCaseInstance(caseInstance);
//		assertEquals(PlanElementState.ENABLED, caseInstance.findNodeForWorkItem(plannedCaseTask.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		assertEquals(PlanElementState.ENABLED, caseInstance.findNodeForWorkItem(plannedHumanTask.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		// Automatic activation:
//		assertEquals(PlanElementState.ACTIVE, caseInstance.findNodeForWorkItem(plannedStage.getTaskData().getWorkItemId())
//				.getPlanElementState());
//		getPersistence().commit();
//	}
//
//	private void assertPlanItemDefinitionPresent(Collection<ApplicableDiscretionaryItem> pts, String itemName) {
//		for (ApplicableDiscretionaryItem pt : pts) {
//			if (itemName.equals(pt.getPlanItemName())) {
//				return;
//			}
//		}
//		fail("Item with name '" + itemName + "' not found");
//	}
//
//	public void assertItemPresent(Collection<PlannableTaskSummary> pts, String itemName) {
//		for (PlannableTaskSummary pt : pts) {
//			if (itemName.equals(pt.getPlanItemName())) {
//				return;
//			}
//		}
//		fail("Item with name '" + itemName + "' not found");
//	}
//	public void assertPlannableTaskPresent(Collection<PlannableTask> pts, String itemName) {
//		for (PlannableTask pt : pts) {
//			if (itemName.equals(pt.getPlanItemName())) {
//				return;
//			}
//		}
//		fail("Item with name '" + itemName + "' not found");
//	}
//
//	public PlanningService getPlanningService() {
//		planningService.setTaskService(getTaskService());
//		return planningService;
//	}
//
//	@Override
//	protected RuntimeManager createRuntimeManager(String... processFile) {
//		RuntimeManager rm = super.createRuntimeManager(processFile);
//		planningService.setRuntimeManager(rm);
//		return rm;
//	}
//
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