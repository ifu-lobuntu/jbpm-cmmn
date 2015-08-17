package org.jbpm.cmmn.service.api.commands;


import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.definition.TaskDefinition;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.impl.AbstractCallingTaskInstance;
import org.jbpm.cmmn.instance.impl.HumanTaskInstance;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;

import java.util.Map;

public class GetInputCommand extends AbstractPlanningCommand<Map<String, Object>> {
    private final long planItemInstanceId;

    public GetInputCommand(long processInstanceId, long planItemInstanceId) {
        super(processInstanceId, null);
        this.planItemInstanceId = planItemInstanceId;
    }

    @Override
    protected Map<String, Object> execute() {
        PlanItemInstance planItemInstance = getPlanItem(planItemInstanceId);
        if (planItemInstance instanceof HumanTaskInstance) {
            HumanTaskInstance hti = (HumanTaskInstance) planItemInstance;
            return ExpressionUtil.buildInputParameters(hti.getWork(), hti, hti.getItem().getDefinition());
        } else if (planItemInstance instanceof AbstractCallingTaskInstance) {
            AbstractCallingTaskInstance hti = (AbstractCallingTaskInstance) planItemInstance;
            return ExpressionUtil.buildInputParameters(hti, (TaskDefinition) hti.getItem().getDefinition());
        } else {
            throw new IllegalStateException(planItemInstance.getNodeName() + " is not a Task");
        }
    }
}