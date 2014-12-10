package org.jbpm.cmmn.test.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.impl.DefaultJoin;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.CaseTaskInstance;
import org.jbpm.cmmn.test.AbstractConstructionTestCase;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.cmmn.ConstructionCase;
import test.cmmn.House;
import test.cmmn.HousePlan;
import test.cmmn.WallPlan;

public abstract class AbstractPlanItemInstanceContainerTest extends AbstractConstructionTestCase {
	Logger logger = LoggerFactory.getLogger(getClass());

	public AbstractPlanItemInstanceContainerTest() {
		super();
	}

	public AbstractPlanItemInstanceContainerTest(boolean setupDataSource, boolean sessionPersistence, String persistenceUnitName) {
		super(setupDataSource, sessionPersistence, persistenceUnitName);
	}

	public AbstractPlanItemInstanceContainerTest(boolean setupDataSource, boolean sessionPersistence) {
		super(setupDataSource, sessionPersistence);
	}

	public abstract String getProcessFile();

	public abstract String getCaseName();

	protected abstract void ensurePlanItemContainerIsStarted();

	protected PlanItemInstanceContainer getPlanItemInstanceContainer() {
		return reloadCaseInstance();
	}

	protected CaseInstance triggerInitialActivity() {
		getPersistence().start();
		CaseInstance ci1 = reloadCaseInstance();
		ci1.signalEvent("StartUserEvent", new Object());
		printState(" ", ci1);
		getPersistence().commit();

		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.ENABLED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ENABLED);
		assertEquals(PlanElementState.ACTIVE, ci1.getPlanElementState()); // Because autoComplete defaults to false
		List<TaskSummary> subTasksByParent = getTaskService().getSubTasksByParent(getTaskService().getTaskByWorkItemId(getWorkitemId()).getId());
		assertEquals(3, subTasksByParent.size());
		CaseInstance subCase = startSubCaseTask(subTasksByParent);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ACTIVE);
		return subCase;
	}

	public long getWorkitemId() {
		return caseInstance.getWorkItemId();
	}

	private CaseInstance startSubCaseTask(List<TaskSummary> subTasksByParent) {
		for (TaskSummary taskSummary : subTasksByParent) {
			if (taskSummary.getName().equals("TheCaseTaskPlanItem")) {
				getTaskService().start(taskSummary.getId(), "ConstructionProjectManager");
				getPersistence().start();
				long workItemId = getTaskService().getTaskById(taskSummary.getId()).getTaskData().getWorkItemId();
				CaseTaskInstance ni = (CaseTaskInstance) reloadCaseInstance().findNodeForWorkItem(workItemId);
				CaseInstance subCase = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(((CaseTaskInstance) ni).getProcessInstanceId());
				getPersistence().commit();
				return subCase;
			}
		}
		return null;
	}

	protected CaseInstance reloadCaseInstance() {
		return reloadCaseInstance(caseInstance);
	}

	protected void completeTasks(List<TaskSummary> subTasksByParent) {
		for (TaskSummary taskSummary : subTasksByParent) {
			if (taskSummary.getName().equals("TheHumanTaskPlanItem")) {
				String id = taskSummary.getActualOwner()!=null?taskSummary.getActualOwner().getId():"Builder";
				getTaskService().start(taskSummary.getId(), id);
				getTaskService().complete(taskSummary.getId(), id, new HashMap<String, Object>());
			} else if (taskSummary.getName().equals("TheCaseTaskPlanItem")) {
				getPersistence().start();
				CaseInstance ci3 = reloadCaseInstance();
				long workItemId = getTaskService().getTaskById(taskSummary.getId()).getTaskData().getWorkItemId();
				CaseTaskInstance ctpi = (CaseTaskInstance) ci3.findNodeForWorkItem(workItemId);
				getRuntimeEngine().getKieSession().getProcessInstance(ctpi.getProcessInstanceId()).signalEvent("TheUserEvent", new Object());
				printState(" ", ci3);
				getPersistence().commit();
				assertEquals(PlanElementState.COMPLETED,
						((CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(ctpi.getProcessInstanceId())).getPlanElementState());
				getPersistence().start();
				getRuntimeEngine().getKieSession().getProcessInstance(ctpi.getProcessInstanceId()).signalEvent(DefaultJoin.CLOSE, new Object());
				getPersistence().commit();
				assertNull(getRuntimeEngine().getKieSession().getProcessInstance(ctpi.getProcessInstanceId()));
			} else if (taskSummary.getName().equals("TheStagePlanItem")) {
				getPersistence().start();
				getRuntimeEngine().getKieSession().signalEvent("StageCompletingEvent", new Object(), caseInstance.getId());
				getPersistence().commit();
				assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItemInTheStage", PlanElementState.COMPLETED);
			}
		}
		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.COMPLETED);

	}

	protected void printState(String s, PlanItemInstanceContainer pi) {
		logger.trace(pi.toString());
		for (PlanItemInstance<?> ni : pi.getChildren()) {
			if (ni instanceof PlanItemInstance) {
				logger.trace(s + ni.getItem().getEffectiveName() + ":" + ni.getPlanElementState());
			} else {
				logger.trace(s + ni.getItem().getEffectiveName());
			}
			if (ni instanceof PlanItemInstanceContainer) {
				printState(s + " ", (PlanItemInstanceContainer) ni);
			}
		}
	}

	protected void givenThatTheTestCaseIsStarted() {
		createRuntimeManager(getProcessFile(), "test/SubCase.cmmn");
		Map<String, Object> params = new HashMap<String, Object>();
		getPersistence().start();

		ConstructionCase cc = new ConstructionCase("/cases/case1");
		housePlan = new HousePlan(cc);
		house = new House(cc);
		new WallPlan(housePlan);
		getPersistence().persist(cc);
		getPersistence().commit();
		params.put("housePlan", housePlan);
		params.put("house", house);
		params.put(WorkItemParameters.CASE_OWNER, "Spielman");
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().startProcess(getCaseName(), params);
		getPersistence().commit();
		assertProcessInstanceActive(caseInstance.getId(), getRuntimeEngine().getKieSession());
		assertNodeTriggered(caseInstance.getId(), "defaultSplit");
		getPersistence().start();
		getPersistence().commit();
		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.AVAILABLE);
		assertEquals(PlanElementState.ACTIVE, caseInstance.getPlanElementState());
		ensurePlanItemContainerIsStarted();

	}

	protected void assertTaskInState(List<TaskSummary> subTasksByParent, String string, Status expectedStatus) {
		Status foundStatus = null;
		for (TaskSummary taskSummary : subTasksByParent) {
			if (taskSummary.getName().equals(string)) {
				foundStatus = taskSummary.getStatus();
				break;
			}
		}
		if (foundStatus == null) {
			fail("Task '" + string + "' not found");
		} else {
			assertEquals(expectedStatus, foundStatus);
		}
	}

}