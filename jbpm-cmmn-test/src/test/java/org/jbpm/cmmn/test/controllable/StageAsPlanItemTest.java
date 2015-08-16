package org.jbpm.cmmn.test.controllable;

import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannedItem;

import java.util.List;

public class StageAsPlanItemTest extends AbstractControllableLifecycleTest {
    {
        super.isJpa = true;
    }

    public StageAsPlanItemTest() {
    }

    @Override
    protected void completeControllableItem(PlannedItem theEventGeneratingTaskPlanItem) {
        Plan plan = getCmmnService().getPlan(caseInstance.getId(), theEventGeneratingTaskPlanItem.getNodeInstanceId());
        List<PlannedItem> plannedItems = plan.getPlannedItems();
        for (PlannedItem plannedItem : plannedItems) {
            System.out.println(plannedItem.getName());
            if (!plannedItem.getState().isTerminalState()) {
                getCmmnService().transitionPlanItem(caseInstance.getId(), plannedItem.getNodeInstanceId(), PlanItemTransition.TERMINATE);
            }
        }
        super.completeControllableItem(theEventGeneratingTaskPlanItem);
    }
// @Test
    // public void testStageTriggered() throws Exception {
    // // *****GIVEN
    // givenThatTheTestCaseIsStarted();
    // triggerTaskCreation();
    // assertNodeTriggered(caseInstance.getId(), "TopLevelTask");
    // List<TaskSummary> list = getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
    // assertEquals(1, list.size());
    // getTaskService().start(list.get(0).getId(), "Builder");
    //
    // // *****WHEN
    // getTaskService().complete(list.get(0).getId(), "Builder", new HashMap<String,Object>());
    // // *****THEN
    // assertNodeTriggered(caseInstance.getId(), "TheStagePlanItem");
    // list = getTaskService().getTasksAssignedAsPotentialOwner("Administrator", "en-UK");
    // assertEquals(2, list.size()); //Tasks representing StageImpl and the Case
    // assertTaskTypeCreated(list, "TheStagePlanItem");
    // }

    @Override
    public String getEventGeneratingTaskUser() {
        return "ConstructionProjectManager";
    }

    @Override
    protected String getCaseOwner() {
        return "Spielman";
    }

    @Override
    public String getNameOfProcessToStart() {
        return "StageTests";
    }

    @Override
    public String[] getProcessFileNames() {
        return new String[]{"test/controllable/StageAsPlanItemTests.cmmn"};
    }

}
