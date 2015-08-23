package org.jbpm.cmmn.service.api.commands;

import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.PlanElementLifecycle;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.HumanTaskInstance;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.service.api.commands.AbstractPlanningCommand;


public class PerformTransitionCommand extends AbstractPlanningCommand<Void> {
    private static final long serialVersionUID = 630L;
    private final Long uniqueId;
    private final PlanItemTransition t;

    public PerformTransitionCommand(long processInstanceId, Long uniqueId, PlanItemTransition t) {
        super(processInstanceId, null);
        this.uniqueId = uniqueId;
        this.t = t;
    }

    public Void execute() {
        PlanElementLifecycle planItem = uniqueId == null ? (PlanElementLifecycle) getCaseInstance() : getPlanItem(uniqueId);
        if (t == PlanItemTransition.COMPLETE) {
            if (planItem instanceof PlanItemInstanceContainer) {
                if (!PlanItemInstanceContainerUtil.canComplete((PlanItemInstanceContainer) planItem)) {
                    throw new IllegalStateException("Planitem cannot complete - awating contained element completion");
                }
            } else if(planItem instanceof HumanTaskInstance) {
                throw new IllegalStateException("Human Tasks cannot be completed during planning because its output needs to be set - complete using the TaskService");
            }
        }
        t.invokeOn(planItem);
        return null;
    }
}
