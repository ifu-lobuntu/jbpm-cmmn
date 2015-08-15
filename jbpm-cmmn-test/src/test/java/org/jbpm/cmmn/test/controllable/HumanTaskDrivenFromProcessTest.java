package org.jbpm.cmmn.test.controllable;

import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.service.model.PlannableItem;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;
import test.cmmn.ConstructionCase;
import test.cmmn.HousePlan;
import test.cmmn.RoofPlan;
import test.cmmn.WallPlan;

import java.util.*;

public class HumanTaskDrivenFromProcessTest extends AbstractControllableLifecycleWithTaskTest {
	{
		super.isJpa = true;
	}


	public HumanTaskDrivenFromProcessTest() {
	}

	@SuppressWarnings("unchecked")
	public void completeTask(String taskName) {
		long taskId=findTaskId(taskName);
		getPersistence().start();
		// Create an unrelated ConstructionCase, but associated its content with our instance.
		ConstructionCase otherCase = new ConstructionCase();
		HousePlan otherHousePlan = new HousePlan(otherCase);
		Set<WallPlan> newWallPlans = new HashSet<WallPlan>();
		newWallPlans.add(new WallPlan(otherHousePlan));
		newWallPlans.add(new WallPlan(otherHousePlan));
		newWallPlans.add(new WallPlan(otherHousePlan));
		RoofPlan newRoofPlan = new RoofPlan(otherHousePlan);
		getPersistence().persist(otherCase);
		getPersistence().commit();
		// Now complete the Case
		HashMap<String, Object> resultFromTask = new HashMap<String, Object>();
		resultFromTask.put("wallPlanOutput", newWallPlans);
		resultFromTask.put("roofPlanOutput", newRoofPlan);
		getPersistence().start();
		getRuntimeEngine().getTaskService().complete(taskId, getEventGeneratingTaskUser(), resultFromTask);
		// now look at the result - those new WallPlans must be added to the original housePlan due to the refinement
		getPersistence().commit();
		getPersistence().start();
		this.housePlan = getPersistence().find(HousePlan.class, housePlan.getId());
		assertTrue(this.housePlan.getWallPlans().containsAll(newWallPlans));
		assertEquals(5, this.housePlan.getWallPlans().size());
		assertEquals(newRoofPlan, this.housePlan.getRoofPlan());
		getPersistence().commit();
		// Check the task's result
		Task task = getTaskService().getTaskById(taskId);
		Content outputContent = getTaskService().getContentById(task.getTaskData().getOutputContentId());
		getPersistence().start();
		Map<String, Object> outputAsMap = (Map<String, Object>) ContentMarshallerHelper.unmarshall(outputContent.getContent(), getTaskService()
				.getMarshallerContext(task).getEnvironment());
		Collection<WallPlan> wallPlanTaskOutput = (Collection<WallPlan>) outputAsMap.get("wallPlanOutput");
		assertEquals(3, wallPlanTaskOutput.size());
		assertEquals(newRoofPlan, outputAsMap.get("roofPlanOutput"));
		getPersistence().commit();
	}
	protected void reenableTask(String taskName) {
		PlannableItem item = getCmmnService().getPlan(caseInstance.getId()).getPlannableItemsFor(taskName).get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), item.getNodeInstanceId(), PlanItemTransition.REENABLE);
	}

	protected void startTaskManually(String taskName) {
		PlannableItem item = getCmmnService().getPlan(caseInstance.getId()).getPlannableItemsFor(taskName).get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(),item.getNodeInstanceId(), PlanItemTransition.MANUAL_START);
	}
	protected void terminateTask(String taskName) {
		PlannableItem item = getCmmnService().getPlan(caseInstance.getId()).getPlannableItemsFor(taskName).get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(),item.getNodeInstanceId(), PlanItemTransition.TERMINATE);
	}
	protected void failTask(String taskName) {
		PlannableItem item = getCmmnService().getPlan(caseInstance.getId()).getPlannableItemsFor(taskName).get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(),item.getNodeInstanceId(), PlanItemTransition.FAULT);
	}

	@Override
	protected void disableTask(String taskName) {
		PlannableItem item = getCmmnService().getPlan(caseInstance.getId()).getPlannableItemsFor(taskName).get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(),item.getNodeInstanceId(), PlanItemTransition.DISABLE);
	}

	protected void reactivateTask(String taskName) {
		PlannableItem item = getCmmnService().getPlan(caseInstance.getId()).getPlannableItemsFor(taskName).get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(),item.getNodeInstanceId(), PlanItemTransition.REACTIVATE);
	}
	protected void resumeTask(String taskName) {
		PlannableItem item = getCmmnService().getPlan(caseInstance.getId()).getPlannableItemsFor(taskName).get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), item.getNodeInstanceId(), PlanItemTransition.RESUME);
	}

	protected void suspendTask(String taskName) {
		PlannableItem item = getCmmnService().getPlan(caseInstance.getId()).getPlannableItemsFor(taskName).get(0);
		getCmmnService().transitionPlanItem(caseInstance.getId(), item.getNodeInstanceId(), PlanItemTransition.SUSPEND);
	}
	@Override
	public void failTask(long taskId) {
		getRuntimeEngine().getTaskService().fail(taskId, getEventGeneratingTaskUser(), new HashMap<String, Object>());
	}

	public String getEventGeneratingTaskUser() {
		return "EventGeneratingBuilder";
	}


	protected void triggerTaskCreation() throws Exception {
		getPersistence().start();
		housePlan = getPersistence().find(HousePlan.class, housePlan.getId());
		new WallPlan(housePlan);
		getPersistence().commit();
		List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner(getEventGeneratingTaskUser(), "en-UK");
		getPersistence().start();
		TaskSummary ts = findTaskSummary(list, "TheEventGeneratingTaskPlanItem");
		if (ts.getActualOwner() != null && !ts.getActualOwner().getId().equals(getEventGeneratingTaskUser())) {
			// may have been assigned to the caseOwner/initiator
			getTaskService().forward(ts.getId(), ts.getActualOwner().getId(), getEventGeneratingTaskUser());
		}
		getTaskService().claim(ts.getId(), getEventGeneratingTaskUser());
		getPersistence().commit();
	}


	public String[] getProcessFileNames() {
		return new String[] { "test/controllable/HumanTaskTests.cmmn" };
	}

	public String getNameOfProcessToStart() {
		return "PlanItemEventTests";
	}

	@Override
	protected String getCaseOwner() {
		return "Spielman";
	}
}
