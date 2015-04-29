package org.jbpm.cmmn.test.casefileitem;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.CaseFileItemTransition;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.subscription.DurableCaseSubscriptionInfo;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.cmmn.test.AbstractConstructionTestCase;
import org.junit.Test;
import org.kie.api.task.model.TaskSummary;

import test.cmmn.ConstructionCase;
import test.cmmn.House;
import test.cmmn.HousePlan;

public abstract class SubscriptionScopeTest extends AbstractConstructionTestCase {
	public SubscriptionScopeTest() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateAndDeleteSubscriptionsAgainstParent() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN
		SubscriptionManager subManager = (SubscriptionManager) getRuntimeEngine().getKieSession().getEnvironment().get(SubscriptionManager.ENV_NAME);
		getPersistence().start();
		SubscriptionPersistenceContext spc=(SubscriptionPersistenceContext) getPersistence();
		assertEquals(0, subManager.getCaseSubscriptionInfoFor(housePlan, spc).getCaseFileItemSubscriptions().size());
		getPersistence().commit();

		triggerStartOfTask();
		getPersistence().start();
		assertEquals(0, subManager.getCaseSubscriptionInfoFor(housePlan, spc).getCaseFileItemSubscriptions().size());
		getPersistence().commit();
		List<TaskSummary> list = getRuntimeEngine().getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
		assertEquals(1, list.size());
		getPersistence().start();
		getRuntimeEngine().getTaskService().start(list.get(0).getId(), "Builder");
		getPersistence().commit();
		getPersistence().start();
		assertEquals(2, subManager.getCaseSubscriptionInfoFor(housePlan, spc).getCaseFileItemSubscriptions().size());
		assertNotNull(subManager.getCaseSubscriptionInfoFor(housePlan, spc).findCaseFileItemSubscription("wallPlans",
				CaseFileItemTransition.CREATE));
		assertNotNull(subManager.getCaseSubscriptionInfoFor(housePlan, spc)
				.findCaseFileItemSubscription("roofPlan", CaseFileItemTransition.DELETE));
		getPersistence().commit();
		getPersistence().start();
		getRuntimeEngine().getTaskService().complete(list.get(0).getId(), "Builder", new HashMap<String, Object>());
		getPersistence().commit();
		getPersistence().start();
		DurableCaseSubscriptionInfo<?> caseSubscriptionInfoFor = subManager.getCaseSubscriptionInfoFor(housePlan,spc);
		Collection<?> caseFileItemSubscriptions = caseSubscriptionInfoFor.getCaseFileItemSubscriptions();
		assertEquals(0, caseFileItemSubscriptions.size());
		getPersistence().commit();
		// *****THEN
		// @SuppressWarnings("unchecked")
		// Map<String, Object> contentData = (Map<String, Object>)
		// ContentMarshallerHelper.unmarshall(input.getContent(), getRuntimeEngine().getKieSession(). getEnvironment());
		// assertEquals(housePlan.getWallPlans().iterator().next().getId(), ((WallPlan)
		// contentData.get("wallPlan")).getId());
	}

	protected void givenThatTheTestCaseIsStarted() {
		createRuntimeManager("test/casefileitem/SubscriptionScopeTests.cmmn");
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
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().startProcess("SubscriptionScopeTests", params);
		getPersistence().commit();
		assertProcessInstanceActive(caseInstance.getId(), getRuntimeEngine().getKieSession());
		assertNodeTriggered(caseInstance.getId(), "defaultSplit");
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "onTheUserEventOccurPartId");
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "TheUserEventPlanItem");
		getPersistence().commit();
	}

	private void triggerStartOfTask() throws Exception {
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		caseInstance.signalEvent("TheUserEvent", new Object());
		getPersistence().commit();
		assertNodeTriggered(caseInstance.getId(), "TheTask");
	}

}
