package org.jbpm.cmmn.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.junit.Test;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;

import test.cmmn.*;

public class ParameterTest extends AbstractConstructionTestCase {
	{
		super.isJpa = true;
	}
	protected HousePlan housePlan;
	protected House house;
	private CaseInstance caseInstance;

	public ParameterTest() {
	}

	// TODO testTaskOutputParameters -writing to caseFilteItem - not essential for a pass-by-reference world

	@Test
	public void testTaskInputParameters() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN
		triggerStartOfTask();
		// *****THEN
		assertNodeTriggered(caseInstance.getId(), "TheTask");
		List<TaskSummary> list = getRuntimeEngine().getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
		assertEquals(1, list.size());
		Task task = getRuntimeEngine().getTaskService().getTaskById(list.get(0).getId());
		Content input = getRuntimeEngine().getTaskService().getContentById(task.getTaskData().getDocumentContentId());
		getPersistence().start();
		@SuppressWarnings("unchecked")
		Map<String, Object> contentData = (Map<String, Object>) ContentMarshallerHelper.unmarshall(input.getContent(), getRuntimeEngine().getKieSession()
				.getEnvironment());
		assertEquals(housePlan.getWallPlans().iterator().next().getId(), ((WallPlan) contentData.get("wallPlan")).getId());
		assertEquals(housePlan.getRoofPlan().getId(), ((RoofPlan) contentData.get("roofPlan")).getId());
		getPersistence().commit();
	}

	protected void givenThatTheTestCaseIsStarted() {
		createRuntimeManager("test/ParameterTests.cmmn");
		Map<String, Object> params = new HashMap<String, Object>();
		getPersistence().start();

		ConstructionCase cc = new ConstructionCase("/cases/case1");
		housePlan = new HousePlan(cc);
		house = new House(cc);
		getPersistence().persist(cc);
		getPersistence().commit();
		params.put("housePlan", housePlan);
		params.put("house", house);
		params.put(WorkItemParameters.INITIATOR, "Spielman");
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().startProcess("ParameterTests", params);
		getPersistence().commit();
		assertProcessInstanceActive(caseInstance.getId(), getRuntimeEngine().getKieSession());
		assertNodeTriggered(caseInstance.getId(), "defaultSplit");
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "onWallPlanCreatedPartId");
		getPersistence().commit();
	}

	private void triggerStartOfTask() throws Exception {
		getPersistence().start();
		housePlan = getPersistence().find(HousePlan.class, housePlan.getId());
		new WallPlan(housePlan);
		new RoofPlan(housePlan);
		getPersistence().update(housePlan);
		getPersistence().commit();
	}

}
