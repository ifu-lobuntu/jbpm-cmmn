package org.jbpm.cmmn.test.controllable;

import org.kie.api.task.model.TaskSummary;
import test.cmmn.HousePlan;
import test.cmmn.WallPlan;

import java.util.List;

public class HumanTaskTest extends AbstractControllableLifecycleTest {
	{
		super.isJpa = true;
	}

	public HumanTaskTest() {
	}

	public String getEventGeneratingTaskUser() {
		return "EventGeneratingBuilder";
	}


	protected void triggerStartOfTask() throws Exception {
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
