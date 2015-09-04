package org.jbpm.cmmn.test.controllable;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.test.AbstractConstructionTestCase;
import org.junit.Test;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.TaskSummary;
import test.cmmn.ConstructionCase;
import test.cmmn.House;
import test.cmmn.HousePlan;
import test.cmmn.WallPlan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractControllableLifecycleWithTaskTest extends AbstractConstructionTestCase {

    public abstract void failTask(long taskId);


    public AbstractControllableLifecycleWithTaskTest() {
        super();
    }

    protected abstract String getCaseOwner();

    public abstract String getNameOfProcessToStart();

    public abstract String[] getProcessFileNames();


    protected abstract void completeTask(String taskName);

    protected abstract void reactivateTask(String taskName);

    protected abstract void terminateTask(String taskName);

    protected abstract String getEventGeneratingTaskUser();

    protected abstract void resumeTask(String taskName);

    protected abstract void suspendTask(String taskName);

    protected abstract void startTaskManually(String taskName);

    protected abstract void reenableTask(String taskName);


    protected abstract void failTask(String taskName);

    protected abstract void disableTask(String taskName);

    @Test
    public void testTaskLifecycleComplete() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        // *****WHEN
        triggerTaskCreation();
        // *******THEN
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        suspendTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
        resumeTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        completeTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.COMPLETED);
        // *****THEN
        stopwatch.finish("testTaskLifecycleComplete");
    }

    protected String getBusinessAdministratorUser() {
        return "Administrator";
    }

    @Test
    public void testTaskLifecycleTerminate() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        // *****WHEN
        triggerTaskCreation();
        // *******THEN
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        suspendTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
        resumeTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        terminateTask(taskName);
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
        triggerTaskCreation();
        // *******THEN
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        suspendTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
        resumeTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        failTask(taskName);
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
        triggerTaskCreation();
        // *******THEN
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        suspendTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
        resumeTask(taskName);
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        getPersistence().start();
        getRuntimeEngine().getKieSession().signalEvent("TheUserEvent", new Object(), caseInstance.getId());
        getPersistence().commitAndSendCaseFileItemEvents();
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
        stopwatch.finish("testTaskLifecycleExit");
    }


    @Test
    public void testEventGeneratedOnCompletionOfTask() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        assertNodeTriggered(caseInstance.getId(), "TheEventGeneratingTaskPlanItem");
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        // *****WHEN
        completeTask(taskName);
        // *****THEN
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskCompleted");
        assertPlanItemInState(caseInstance.getId(), "PlanItemEnteredWhenTaskCompleted", PlanElementState.ENABLED);
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(2, list.size());
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.COMPLETED);
        assertEquals("PlanItemEnteredWhenTaskCompleted", list.get(0).getName());
        stopwatch.finish("testEventGeneratedOnCompletionOfTask");
    }

    @Test
    public void testEventGeneratedOnFaultOnTask() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        assertNodeTriggered(caseInstance.getId(), "TheEventGeneratingTaskPlanItem");
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        // *****WHEN
        failTask(taskName);
        // *****THEN
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskFaultOccurred");
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(2, list.size());
        assertEquals("PlanItemEnteredWhenTaskFaultOccurred", list.get(0).getName());
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.FAILED);
        stopwatch.finish("testEventGeneratedOnFaultOnTask");
    }

    @Test
    public void testEventGeneratedOnSuspensionOfTask() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        getPersistence().start();
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        // *****WHEN
        suspendTask(taskName);
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(2, list.size());
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskSuspended");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskSuspended");
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.SUSPENDED);
        stopwatch.finish("testEventGeneratedOnSuspensionOfTask");
    }

    @Test
    public void testEventGeneratedOnTerminationOfTask() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        startTaskManually(list.get(0).getName());
        // *****WHEN
        terminateTask(list.get(0).getName());
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(2, list.size());
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskTerminated");
        assertEquals("PlanItemEnteredWhenTaskTerminated", list.get(0).getName());
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
        stopwatch.finish("testEventGeneratedOnTerminationOfTask");
    }


    @Test
    public void testEventGeneratedOnResumptionOfTask() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        suspendTask(taskName);
        // *****WHEN
        resumeTask(taskName);
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(3, list.size());
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskResumed");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskResumed");
        stopwatch.finish("testEventGeneratedOnResumptionOfTask");
    }


    @Test()
    public void testEventGeneratedOnExitOfTask() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        // *****WHEN
        triggerExitOfTask(list);
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(2, list.size());
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskExited");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskExited");
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
        stopwatch.finish("testEventGeneratedOnExitOfTask");
    }

    private void triggerExitOfTask(List<TaskSummary> list) {
        stopwatch.start();
        getTaskService().start(list.get(0).getId(), getEventGeneratingTaskUser());
        getPersistence().start();
        getRuntimeEngine().getKieSession().signalEvent("TheUserEvent", new Object(), caseInstance.getId());
        getPersistence().commitAndSendCaseFileItemEvents();
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.TERMINATED);
    }

    @Test
    public void testEventGeneratedOnDisableOfTask() throws Exception {
        stopwatch.start();
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        String taskName = list.get(0).getName();
        // *****WHEN
        disableTask(taskName);
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(2, list.size());
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskDisabled");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskDisabled");
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
        getPersistence().commitAndSendCaseFileItemEvents();
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
        getPersistence().commitAndSendCaseFileItemEvents();
        List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner(getEventGeneratingTaskUser(), "en-UK");
        assertTrue(list.size() > 0); // there could be 2
        assertNodeTriggered(caseInstance.getId(), "TheManuallyActivatedTaskPlanItem");
        // *****WHEN
        startTaskManually("TheManuallyActivatedTaskPlanItem");
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(3, list.size());
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskManuallyStarted");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskManuallyStarted");
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskEnabled");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskEnabled");
        assertPlanItemInState(caseInstance.getId(), "TheManuallyActivatedTaskPlanItem", PlanElementState.ACTIVE);
        stopwatch.finish("testEventGeneratedOnManualStartOfTask");

    }


    @Test
    public void testEventGeneratedOnAutomaticStartOfTask() throws Exception {
        stopwatch.start();

        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        // ******WHEN
        getPersistence().start();
        getRuntimeEngine().getKieSession().signalEvent("UserEventToStartAutoActivatedTask", new Object(), caseInstance.getId());
        getPersistence().commitAndSendCaseFileItemEvents();
        // *****THEN
        List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner(getEventGeneratingTaskUser(), "en-UK");
        assertNodeTriggered(caseInstance.getId(), "TheAutoActivatedTaskPlanItem");
        assertTaskTypeCreated(list, "TheAutoActivatedTaskPlanItem");
        assertTrue(list.size() > 0); // could be two
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertEquals(2, list.size());
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskAutomaticallyStarted");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskAutomaticallyStarted");
        assertPlanItemInState(caseInstance.getId(), "TheAutoActivatedTaskPlanItem", PlanElementState.ACTIVE);
        stopwatch.finish("testEventGeneratedOnAutomaticStartOfTask");

    }

    @Test
    public void testEventGeneratedOnReactivateOfTask() throws Exception {
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        String taskName = list.get(0).getName();
        startTaskManually(taskName);
        failTask(taskName);
        // *****WHEN
        reactivateTask(taskName);
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertTrue(list.size() > 0);
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskReactivated");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskReactivated");
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ACTIVE);
        stopwatch.finish("testEventGeneratedOnReactivateOfTask");

    }

    @Test
    public void testEventGeneratedOnReenableOfTask() throws Exception {
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        triggerTaskCreation();
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        String taskName = list.get(0).getName();
        disableTask(taskName);
        // *****WHEN
        reenableTask(taskName);
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertTrue(list.size() > 0);
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskReenabled");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskReenabled");
        assertPlanItemInState(caseInstance.getId(), "TheEventGeneratingTaskPlanItem", PlanElementState.ENABLED);
        stopwatch.finish("testEventGeneratedOnReenableOfTask");
    }


    @Test
    public void testEventGeneratedOnCreateOfTask() throws Exception {
        // *****GIVEN
        givenThatTheTestCaseIsStarted();
        // *****WHEN
        triggerTaskCreation();
        List<TaskSummary> list = getTaskService().getTasksOwned(getEventGeneratingTaskUser(), "en-UK");
        assertEquals(1, list.size());
        // *****THEN
        list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
        assertTrue(list.size() > 0);
        assertNodeTriggered(caseInstance.getId(), "PlanItemEnteredWhenTaskCreated");
        assertTaskTypeCreated(list, "PlanItemEnteredWhenTaskCreated");
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
        getPersistence().commitAndSendCaseFileItemEvents();
        params.put("housePlan", housePlan);
        params.put("house", house);
        params.put(WorkItemParameters.CASE_OWNER, getCaseOwner());
        getPersistence().start();
        caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().startProcess(getNameOfProcessToStart(), params);
        getPersistence().commitAndSendCaseFileItemEvents();
        assertProcessInstanceActive(caseInstance.getId(), getRuntimeEngine().getKieSession());
        assertNodeTriggered(caseInstance.getId(), "defaultSplit");
        getPersistence().start();
        assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "onWallPlanCreatedPartId");
        assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "WaitingForWallPlanCreatedSentry");
        getPersistence().commitAndSendCaseFileItemEvents();
    }

    protected void triggerTaskCreation() throws Exception {
        getPersistence().start();
        housePlan = getPersistence().find(HousePlan.class, housePlan.getId());
        new WallPlan(housePlan);
        getPersistence().commitAndSendCaseFileItemEvents();
        List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner(getEventGeneratingTaskUser(), "en-UK");
        getPersistence().start();
        TaskSummary ts = findTaskSummary(list, "TheEventGeneratingTaskPlanItem");
        if (ts.getActualOwner() != null && !ts.getActualOwner().getId().equals(getEventGeneratingTaskUser())) {
            // may have been assigned to the caseOwner/initiator
            getTaskService().forward(ts.getId(), ts.getActualOwner().getId(), getEventGeneratingTaskUser());
        }
        getTaskService().claim(ts.getId(), getEventGeneratingTaskUser());
        getPersistence().commitAndSendCaseFileItemEvents();
    }
    protected long findTaskId(String taskName) {
        long eventGeneratingTaskId = -1;
        // ******WHEN
        for (TaskSummary ts : getTaskService().getTasksAssignedAsPotentialOwnerByStatus(getEventGeneratingTaskUser(), Arrays.asList(Status.values()), "en-UK")) {
            if (ts.getName().equals(taskName)) {
                eventGeneratingTaskId = ts.getId();
            }
        }
        return eventGeneratingTaskId;
    }


    protected TaskSummary findTaskSummary(List<TaskSummary> list, String taskName) {
        for (TaskSummary ts : list) {
            if (ts.getName().equals(taskName)) {
                return ts;
            }
        }
        throw new IllegalArgumentException("Task '" + taskName + "' not found");
    }

}