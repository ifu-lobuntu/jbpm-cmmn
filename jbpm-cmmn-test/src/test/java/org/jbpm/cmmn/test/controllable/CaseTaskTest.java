package org.jbpm.cmmn.test.controllable;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.impl.CaseTaskInstance;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.junit.Test;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;

import test.cmmn.ConstructionCase;
import test.cmmn.HousePlan;
import test.cmmn.RoofPlan;
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
		List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner("ConstructionProjectManager", "en-UK");
		assertTaskTypeCreated(list, "TheEventGeneratingTaskPlanItem", 1);
		long subTaskId = -1;
		for (TaskSummary taskSummary : list) {
			if (taskSummary.getName().equals("TheEventGeneratingTaskPlanItem")) {
				subTaskId = taskSummary.getId();
			}
		}
		getRuntimeEngine().getTaskService().start(subTaskId, "ConstructionProjectManager");
		// *******THEN
		getPersistence().start();
		long id = getSubProcessInstanceId(subTaskId);
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


	private long getSubProcessInstanceId(long taskId) {
		long workItemId = getRuntimeEngine().getTaskService().getTaskById(taskId).getTaskData().getWorkItemId();
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		long subProccessInstanceId = -1;
		for (NodeInstance nodeInstance : caseInstance.getNodeInstances()) {
			if (nodeInstance instanceof CaseTaskInstance) {
				subProccessInstanceId = ((CaseTaskInstance) nodeInstance).getProcessInstanceId();
			}
		}
		getPersistence().commit();
		return subProccessInstanceId;
	}

}
