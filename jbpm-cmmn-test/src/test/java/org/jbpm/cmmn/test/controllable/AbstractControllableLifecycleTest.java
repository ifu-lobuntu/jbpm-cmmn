package org.jbpm.cmmn.test.controllable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannableItem;
import org.jbpm.cmmn.test.AbstractConstructionTestCase;
import org.junit.Test;
import org.kie.api.task.model.TaskSummary;

import test.cmmn.ConstructionCase;
import test.cmmn.House;
import test.cmmn.HousePlan;
import test.cmmn.WallPlan;

public abstract class AbstractControllableLifecycleTest extends AbstractConstructionTestCase {

	public AbstractControllableLifecycleTest() {
		super();
	}
	@Test
	public void testTaskLifecycleComplete() throws Exception {
		stopwatch.start();
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN
		triggerStartOfTask();
		// *******THEN
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.SUSPEND);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.RESUME);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.COMPLETE);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.COMPLETED);
		// *****THEN
		stopwatch.finish("testTaskLifecycleComplete");
	}

	@Test
	public void testTaskLifecycleTerminate() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN
		triggerStartOfTask();
		// *******THEN
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.SUSPEND);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.RESUME);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.EXIT);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
		// *****THEN
		stopwatch.finish("testTaskLifecycleTerminate");

	}

	@Test
	public void testTaskLifecycleFailed() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN
		triggerStartOfTask();
		// *******THEN
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.SUSPEND);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.RESUME);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.FAULT);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.FAILED);
		// *****THEN
		stopwatch.finish("testTaskLifecycleFailed");
	}

	@Test
	public void testTaskLifecycleExit() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN
		triggerStartOfTask();
		// *******THEN
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.SUSPEND);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.RESUME);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getPersistence().start();
		getRuntimeEngine().getKieSession().signalEvent("TheUserEvent", new Object(), caseInstance.getId());
		getPersistence().commit();
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
		stopwatch.finish("testTaskLifecycleExit");
	}

	public abstract String getEventGeneratingTaskUser();

	@Test
	public void testEventGeneratedOnCompletionOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();
		assertNodeTriggered(caseInstance.getId(), "TheEventGeneratingTaskPlanItem");
		// *****WHEN
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.COMPLETE);
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskCompleted");
		assertPlanItemInState(caseInstance.getId(), "PlanItemEnteredWhenTaskCompleted", PlanElementState.ENABLED);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.COMPLETED);
		stopwatch.finish("testEventGeneratedOnCompletionOfTask");
	}

	@Test
	public void testEventGeneratedOnFaultOnTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();
		assertNodeTriggered(caseInstance.getId(), "TheEventGeneratingTaskPlanItem");
		// *****WHEN
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.FAULT);
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskFaultOccurred");
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.FAILED);
		stopwatch.finish("testEventGeneratedOnFaultOnTask");
	}

	@Test
	public void testEventGeneratedOnSuspensionOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();
		// *****WHEN
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.SUSPEND);
		getPersistence().commit();
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskSuspended");
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
		stopwatch.finish("testEventGeneratedOnSuspensionOfTask");
	}

	@Test
	public void testEventGeneratedOnTerminationOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		// *****WHEN
		// *****WHEN
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.TERMINATE);
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskTerminated");
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
		stopwatch.finish("testEventGeneratedOnTerminationOfTask");
	}

	protected String getBusinessAdministratorUser() {
		return "Administrator";
	}

	@Test
	public void testEventGeneratedOnResumptionOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.SUSPEND);
		// *****WHEN
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.RESUME);
		// *****THEN
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);

		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskResumed");
		stopwatch.finish("testEventGeneratedOnResumptionOfTask");
	}

	@Test()
	public void testEventGeneratedOnExitOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		// *****WHEN

		getPersistence().start();
		//Achieve exit criteria
		getRuntimeEngine().getKieSession().signalEvent("TheUserEvent", new Object(), caseInstance.getId());
		getPersistence().commit();
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskExited");
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
		stopwatch.finish("testEventGeneratedOnExitOfTask");
	}


	@Test
	public void testEventGeneratedOnDisableOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();
		// ***** WHEN
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.DISABLE);
       // *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskDisabled");
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.DISABLED);
		stopwatch.finish("testEventGeneratedOnDisableOfTask");

	}

	@Test
	public void testEventGeneratedOnEnableOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// ******WHEN
		getPersistence().start();
		getRuntimeEngine().getKieSession().signalEvent("UserEventToStartManuallyActivatedTask", new Object(), caseInstance.getId());
		getPersistence().commit();
		assertNodeTriggered(caseInstance.getId(), "TheManuallyActivatedTaskPlanItem");
		// *****THEN
		List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
		assertEquals(2, list.size());
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskEnabled");
		assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskEnabled");
		assertPlanItemInState(caseInstance.getId(), "TheManuallyActivatedTaskPlanItem", PlanElementState.ENABLED);
		stopwatch.finish("testEventGeneratedOnEnableOfTask");

	}

	@Test
	public void testEventGeneratedOnManualStartOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		getPersistence().start();
		getRuntimeEngine().getKieSession().signalEvent("UserEventToStartManuallyActivatedTask", new Object(), caseInstance.getId());
		getPersistence().commit();
		assertNodeTriggered(caseInstance.getId(), "TheManuallyActivatedTaskPlanItem");
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheManuallyActivatedTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);

		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskManuallyStarted");
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskEnabled");
		assertPlanItemInState(caseInstance.getId(), "TheManuallyActivatedTaskPlanItem", PlanElementState.ACTIVE);
		stopwatch.finish("testEventGeneratedOnManualStartOfTask");

	}

	private long findTask(List<TaskSummary> list, String taskName) {
		long eventGeneratingTaskId = -1;
		// ******WHEN
		for (TaskSummary ts : list) {
			if (ts.getName().equals(taskName)) {
				eventGeneratingTaskId = ts.getId();
			}
		}
		return eventGeneratingTaskId;
	}

	protected TaskSummary findTaskSummary(List<TaskSummary> list, String taskName) {
		// ******WHEN
		for (TaskSummary ts : list) {
			if (ts.getName().equals(taskName)) {
				return ts;
			}
		}
		throw new IllegalArgumentException("Task '" + taskName + "' not found");
	}

	@Test
	public void testEventGeneratedOnAutomaticStartOfTask() throws Exception {
		stopwatch.start();

		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// ******WHEN
		getPersistence().start();
		getRuntimeEngine().getKieSession().signalEvent("UserEventToStartAutoActivatedTask", new Object(), caseInstance.getId());
		getPersistence().commit();
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "TheAutoActivatedTaskPlanItem");
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskAutomaticallyStarted");
		assertPlanItemInState(caseInstance.getId(), "TheAutoActivatedTaskPlanItem", PlanElementState.ACTIVE);
		stopwatch.finish("testEventGeneratedOnAutomaticStartOfTask");

	}

	@Test
	public void testEventGeneratedOnReactivateOfTask() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.FAULT);
		// *****WHEN
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.REACTIVATE);
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskReactivated");
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
		stopwatch.finish("testEventGeneratedOnReactivateOfTask");

	}

	@Test
	public void testEventGeneratedOnReenableOfTask() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfTask();

		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.DISABLE);
		// *****WHEN
		getCmmnService().transitionPlanItem(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId(), PlanItemTransition.REENABLE);
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskReenabled");
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
		stopwatch.finish("testEventGeneratedOnReenableOfTask");

	}

	@Test
	public void testEventGeneratedOnCreateOfTask() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN
		triggerStartOfTask();
		Plan plan = getCmmnService().getPlan(caseInstance.getId());
		PlannableItem theEventGeneratingTaskPlanItem = plan.getPlannableItemsFor("TheEventGeneratingTaskPlanItem").get(0);
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskCreated");
		assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
		stopwatch.finish("testEventGeneratedOnCreateOfTask");

	}

	protected void givenThatTheTestCaseIsStarted() {
		createRuntimeManager(getProcessFileNames());
		Map<String, Object> params = new HashMap<String, Object>();
		getPersistence().start();

		ConstructionCase cc = new ConstructionCase("/cases/case1");
		housePlan = new HousePlan(cc);
		new WallPlan(housePlan);
		house = new House(cc);
		getPersistence().persist(cc);
		getPersistence().commit();
		params.put("housePlan", housePlan);
		params.put("house", house);
		params.put(WorkItemParameters.CASE_OWNER, getCaseOwner());
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().startProcess(getNameOfProcessToStart(), params);
		getPersistence().commit();
		assertProcessInstanceActive(caseInstance.getId(), getRuntimeEngine().getKieSession());
		assertNodeTriggered(caseInstance.getId(), "defaultSplit");
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "onWallPlanCreatedPartId");
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "WaitingForWallPlanCreatedSentry");
		getPersistence().commit();
	}

	protected abstract String getCaseOwner();

	public abstract String getNameOfProcessToStart();

	public abstract String[] getProcessFileNames();

	protected void triggerStartOfTask() throws Exception {
		getPersistence().start();
		housePlan = getPersistence().find(HousePlan.class, housePlan.getId());
		new WallPlan(housePlan);
		getPersistence().commit();
//		List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner(getEventGeneratingTaskUser(), "en-UK");
//		getPersistence().start();
//		TaskSummary ts = findTaskSummary(list, "TheEventGeneratingTaskPlanItem");
//		if (ts.getActualOwner() != null && !ts.getActualOwner().getId().equals(getEventGeneratingTaskUser())) {
//			// may have been assigned to the caseOwner/initiator
//			getTaskService().forward(ts.getId(), ts.getActualOwner().getId(), getEventGeneratingTaskUser());
//		}
//		getTaskService().claim(ts.getId(), getEventGeneratingTaskUser());
//		getPersistence().commit();
	}

}