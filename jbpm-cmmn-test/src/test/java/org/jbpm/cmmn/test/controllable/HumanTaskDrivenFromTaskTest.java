package org.jbpm.cmmn.test.controllable;

import org.jbpm.cmmn.task.additional.commands.ReactivateTaskCommand;
import org.jbpm.cmmn.task.additional.commands.ReenableTaskCommand;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Task;
import test.cmmn.ConstructionCase;
import test.cmmn.HousePlan;
import test.cmmn.RoofPlan;
import test.cmmn.WallPlan;

import java.util.*;

public class HumanTaskDrivenFromTaskTest extends AbstractControllableLifecycleWithTaskTest {
	{
		super.isJpa = true;
	}

	public HumanTaskDrivenFromTaskTest() {
	}

	public String getEventGeneratingTaskUser() {
		return "EventGeneratingBuilder";
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
		getPersistence().commitAndSendCaseFileItemEvents();
		// Now complete the Case
		HashMap<String, Object> resultFromTask = new HashMap<String, Object>();
		resultFromTask.put("wallPlanOutput", newWallPlans);
		resultFromTask.put("roofPlanOutput", newRoofPlan);
		getPersistence().start();
		getRuntimeEngine().getTaskService().complete(taskId, getEventGeneratingTaskUser(), resultFromTask);
		// now look at the result - those new WallPlans must be added to the original housePlan due to the refinement
		getPersistence().commitAndSendCaseFileItemEvents();
		getPersistence().start();
		this.housePlan = getPersistence().find(HousePlan.class, housePlan.getId());
		assertTrue(this.housePlan.getWallPlans().containsAll(newWallPlans));
		assertEquals(5, this.housePlan.getWallPlans().size());
		assertEquals(newRoofPlan, this.housePlan.getRoofPlan());
		getPersistence().commitAndSendCaseFileItemEvents();
		// Check the task's result
		Task task = getTaskService().getTaskById(taskId);
		Content outputContent = getTaskService().getContentById(task.getTaskData().getOutputContentId());
		getPersistence().start();
		Map<String, Object> outputAsMap = (Map<String, Object>) ContentMarshallerHelper.unmarshall(outputContent.getContent(), getTaskService()
				.getMarshallerContext(task).getEnvironment());
		Collection<WallPlan> wallPlanTaskOutput = (Collection<WallPlan>) outputAsMap.get("wallPlanOutput");
		assertEquals(3, wallPlanTaskOutput.size());
		assertEquals(newRoofPlan, outputAsMap.get("roofPlanOutput"));
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	@Override
	public void failTask(long taskId) {
		getRuntimeEngine().getTaskService().fail(taskId, getEventGeneratingTaskUser(), new HashMap<String, Object>());
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

	protected void reactivateTask(String taskName) {
        getPersistence().start();
        getTaskService().execute(new ReactivateTaskCommand(findTaskId(taskName), getEventGeneratingTaskUser()));
        getPersistence().commitAndSendCaseFileItemEvents();
    }

	protected void terminateTask(String taskName){
        getTaskService().exit(findTaskId(taskName), getBusinessAdministratorUser());
    }
	protected void reenableTask(String taskName) {
		getPersistence().start();
		getTaskService().execute(new ReenableTaskCommand(findTaskId(taskName), getEventGeneratingTaskUser()));
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	protected void resumeTask(String taskName) {
        getPersistence().start();
        getTaskService().resume(findTaskId(taskName), getEventGeneratingTaskUser());
        getPersistence().commitAndSendCaseFileItemEvents();
    }

	protected void suspendTask(String taskName) {
        getPersistence().start();
        getTaskService().suspend(findTaskId(taskName), getEventGeneratingTaskUser());
        getPersistence().commitAndSendCaseFileItemEvents();
    }

	protected void startTaskManually(String taskName) {
        getPersistence().start();
        getTaskService().start(findTaskId(taskName), getEventGeneratingTaskUser());
        getPersistence().commitAndSendCaseFileItemEvents();
    }

	protected void failTask(String taskName) {
        getPersistence().start();
        getTaskService().fail(findTaskId(taskName), getEventGeneratingTaskUser(), new HashMap<String, Object>());
        getPersistence().commitAndSendCaseFileItemEvents();
    }

	protected void disableTask(String taskName) {
		getPersistence().start();
		getTaskService().skip(findTaskId(taskName), getEventGeneratingTaskUser());
		getPersistence().commitAndSendCaseFileItemEvents();
	}
}
