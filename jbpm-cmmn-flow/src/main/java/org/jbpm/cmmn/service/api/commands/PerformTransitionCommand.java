package org.jbpm.cmmn.service.api.commands;

import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.instance.PlanElementLifecycle;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.service.api.commands.AbstractPlanningCommand;

/**
 * Created by ampie on 2015/08/16.
 */
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
        if (planItem instanceof PlanItemInstanceContainer && t == PlanItemTransition.COMPLETE) {
            if (!PlanItemInstanceContainerUtil.canComplete((PlanItemInstanceContainer) planItem)) {
                throw new IllegalStateException("Planitem cannot complete - awating contained element completion");
            }
        }
        t.invokeOn(planItem);
        return null;
    }
}
