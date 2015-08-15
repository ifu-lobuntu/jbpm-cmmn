package org.jbpm.cmmn.test.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.core.impl.DefaultJoin;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.AbstractCallingTaskInstance;
import org.jbpm.cmmn.instance.impl.CaseTaskInstance;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannableItem;
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
		Plan plan = getCmmnService().getPlan(caseInstance.getId());

		assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheTimerEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheHumanTaskPlanItem", PlanElementState.ENABLED);
		assertPlanItemInState(caseInstance.getId(), "EndUserEventPlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "StartUserEventPlanItem", PlanElementState.COMPLETED);
		assertPlanItemInState(caseInstance.getId(), "TheStagePlanItem", PlanElementState.AVAILABLE);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ENABLED);
		assertEquals(PlanElementState.ACTIVE, ci1.getPlanElementState()); // Because autoComplete defaults to false
		getCmmnService().transitionPlanItem(caseInstance.getId(), plan.getPlannableItemsFor("TheCaseTaskPlanItem").get(0).getUniqueId(), PlanItemTransition.MANUAL_START);
		assertPlanItemInState(caseInstance.getId(), "TheCaseTaskPlanItem", PlanElementState.ACTIVE);
		String uid=plan.getPlannableItemsFor("TheCaseTaskPlanItem").get(0).getUniqueId();
		for (org.jbpm.workflow.instance.NodeInstance nodeInstance : reloadCaseInstance(caseInstance).getNodeInstances(true)) {
			if(nodeInstance instanceof AbstractCallingTaskInstance &&  ((AbstractCallingTaskInstance)nodeInstance).getUniqueId().equals(uid)){
				return (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(((AbstractCallingTaskInstance) nodeInstance).getProcessInstanceId());
			}
		}
		throw new IllegalStateException();
	}

	protected CaseInstance reloadCaseInstance() {
		return reloadCaseInstance(caseInstance);
	}

	protected void completeTasks(Plan plan) {
		for (PlannableItem item : plan.getPlannableItems()) {
//			if (item.getName().equals("TheHumanTaskPlanItem")) {
//				caseInstance.getNodeInstance()
//				getTaskService().getTaskByWorkItemId(workItemId);
//				String id = item.getActualOwner()!=null?item.getActualOwner().getId():"Builder";
//				getTaskService().start(item.getId(), id);
//				getTaskService().complete(item.getId(), id, new HashMap<String, Object>());
//			} else if (item.getName().equals("TheCaseTaskPlanItem")) {
//				getPersistence().start();
//				CaseInstance ci3 = reloadCaseInstance();
//				long workItemId = getTaskService().getTaskById(item.getId()).getTaskData().getWorkItemId();
//				CaseTaskInstance ctpi = (CaseTaskInstance) PlanItemInstanceContainerUtil.findNodeForWorkItem(ci3,workItemId);
//				getRuntimeEngine().getKieSession().getProcessInstance(ctpi.getProcessInstanceId()).signalEvent("TheUserEvent", new Object());
//				printState(" ", ci3);
//				getPersistence().commit();
//				assertEquals(PlanElementState.COMPLETED,
//						((CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(ctpi.getProcessInstanceId())).getPlanElementState());
//				getPersistence().start();
//				getRuntimeEngine().getKieSession().getProcessInstance(ctpi.getProcessInstanceId()).signalEvent(DefaultJoin.CLOSE, new Object());
//				getPersistence().commit();
//				assertNull(getRuntimeEngine().getKieSession().getProcessInstance(ctpi.getProcessInstanceId()));
//			} else if (item.getName().equals("TheStagePlanItem")) {
//				getPersistence().start();
//				getRuntimeEngine().getKieSession().signalEvent("StageCompletingEvent", new Object(), caseInstance.getId());
//				getPersistence().commit();
//				assertPlanItemInState(caseInstance.getId(), "TheMilestonePlanItemInTheStage", PlanElementState.COMPLETED);
//			}
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