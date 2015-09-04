package org.jbpm.cmmn.test.occurrable;

import java.util.Collection;

import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.process.instance.InternalProcessRuntime;
import org.jbpm.process.instance.timer.TimerInstance;
import org.jbpm.process.instance.timer.TimerManager;
import org.junit.After;
import org.junit.Test;

import test.cmmn.HousePlan;
import test.cmmn.WallPlan;

public class TimerEventTest extends AbstractOccurrableTestCase {

	public TimerEventTest() {
	}

	public String getCaseName() {
		return "TimerEventListenerTests";
	}

	public String getProcessFile() {
		return "test/occurrable/TimerEventListenerTests.cmmn";
	}

	@After
	public void deleteTimers() {
		getPersistence().start();
		Collection<TimerInstance> timers = getTimerManager().getTimers();
		for (TimerInstance timerInstance : timers) {
			getTimerManager().cancelTimer(timerInstance.getId());
		}
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	@Test
	public void testPlanItemTrigger() throws Exception {
		givenThatTheTestCaseIsStarted();
		assertNodeNotTriggered(caseInstance.getId(), "TimerEventWithPlanItemTriggerPlanItem");
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "theUserEventTrigger");
		reloadCaseInstance(caseInstance).signalEvent("TheUserEvent", new Object());
		getPersistence().commitAndSendCaseFileItemEvents();
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "TimerEventWithPlanItemTriggerPlanItem");
		Collection<TimerInstance> timers = getTimerManager().getTimers();
		assertEquals(2, timers.size());
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	@Test
	public void testCaseFileItemTrigger() throws Exception {
		givenThatTheTestCaseIsStarted();
		assertNodeNotTriggered(caseInstance.getId(), "TimerEventWithCaseFileItemTriggerPlanItem");
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "wallPlanCreatedTrigger");
		housePlan = getPersistence().find(HousePlan.class, housePlan.getId());
		new WallPlan(housePlan);
		getPersistence().update(housePlan);
		getPersistence().commitAndSendCaseFileItemEvents();
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "TimerEventWithCaseFileItemTriggerPlanItem");
		Collection<TimerInstance> timers = getTimerManager().getTimers();
		assertEquals(2, timers.size());
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	@Override
	protected void givenThatTheTestCaseIsStarted() {
		super.givenThatTheTestCaseIsStarted();
		getPersistence().start();
		Collection<TimerInstance> timers = getTimerManager().getTimers();
		assertEquals(1, timers.size());
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	private TimerManager getTimerManager() {
		return ((InternalProcessRuntime) reloadCaseInstance(caseInstance).getKnowledgeRuntime().getProcessRuntime()).getTimerManager();
	}

	@Override
	protected void triggerOccurrence() throws Exception {
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		Collection<TimerInstance> timers = getTimerManager().getTimers();
		for (TimerInstance timerInstance : timers) {
			caseInstance.signalEvent("timerTriggered", timerInstance);
		}
		getPersistence().commitAndSendCaseFileItemEvents();
	}

}
