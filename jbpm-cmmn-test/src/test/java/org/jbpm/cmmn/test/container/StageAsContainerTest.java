package org.jbpm.cmmn.test.container;

import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.StageInstance;
import org.jbpm.cmmn.service.model.Plan;
import org.kie.api.runtime.process.NodeInstance;

public class StageAsContainerTest extends AbstractPlanItemInstanceContainerLifecycleTest {

	{
		super.isJpa = true;
	}

	public StageAsContainerTest() {
	}

	@Override
	protected void ensurePlanItemContainerIsStarted() {
		assertPlanItemInState(caseInstance.getId(), "TheTopLevelStagePlanItem", PlanElementState.ACTIVE);
	}
	protected void completePlanItemInstanceContainer() {
		getCmmnService().transitionPlanItem(caseInstance.getId(), getStagePlanItemInstance().getId(), PlanItemTransition.COMPLETE);
	}
	@Override
	protected Plan getPlan() {
		return getCmmnService().getPlan(caseInstance.getId(),getStagePlanItemInstance().getId());
	}

	@Override
	protected PlanItemInstanceContainer getPlanItemInstanceContainer() {
		return getStagePlanItemInstance();
	}

	@Override
	public String getCaseName() {
		return "StagePlanItemInstanceTests";
	}

	protected void continuePlanItemInstanceContainer() {
		getPersistence().start();
		getCmmnService().transitionPlanItem(caseInstance.getId(), getStagePlanItemInstance().getId(), PlanItemTransition.RESUME);
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	protected void suspedPlanItemInstanceContainer() {
		getPersistence().start();
		getCmmnService().transitionPlanItem(caseInstance.getId(), getStagePlanItemInstance().getId(), PlanItemTransition.SUSPEND);
		getPersistence().commitAndSendCaseFileItemEvents();
	}
	protected void terminatePlanItemInstanceContainer() {
		getPersistence().start();
		getCmmnService().transitionPlanItem(caseInstance.getId(), getStagePlanItemInstance().getId(), PlanItemTransition.TERMINATE);
		getPersistence().commitAndSendCaseFileItemEvents();
	}
	public StageInstance getStagePlanItemInstance() {
		StageInstance spii = null;
		for (NodeInstance ni : reloadCaseInstance(caseInstance).getNodeInstances()) {
			if (ni instanceof StageInstance) {
				spii = (StageInstance) ni;
			}
		}
		return spii;
	}
	protected void failPlanItemInstanceContainer() {
		getPersistence().start();
		getCmmnService().transitionPlanItem(caseInstance.getId(), getStagePlanItemInstance().getId(), PlanItemTransition.FAULT);
		getPersistence().commitAndSendCaseFileItemEvents();
	}

	@Override
	public String getProcessFile() {
		return "test/container/StageAsContainerTests.cmmn";
	}

}