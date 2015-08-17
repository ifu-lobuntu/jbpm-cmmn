package org.jbpm.cmmn.service.api.commands;


import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.impl.HumanTaskInstance;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;

import java.util.Map;

public class OverrideInputCommand extends AbstractPlanningCommand<Void> {
    private final Map<String, Object> input;
    private final long planItemInstanceId;

    public OverrideInputCommand(long processInstanceId, long planItemInstanceId, Map<String, Object> input) {
        super(processInstanceId, null);
        this.planItemInstanceId = planItemInstanceId;
        this.input = input;
    }

    @Override
    protected Void execute() {
        PlanItemInstance planItemInstance = getPlanItem(planItemInstanceId);
        for (Map.Entry<String, Object> entry : input.entrySet()) {
            if (entry.getValue() == null || entry.getValue().equals("")) {
                planItemInstance.setVariable("Input" + entry.getKey(), null);
            } else {
                planItemInstance.setVariable("Input" + entry.getKey(), entry.getValue());
            }
            if (planItemInstance instanceof HumanTaskInstance) {
                //TODO consider going straight to the TaskService
                HumanTaskInstance hit = (HumanTaskInstance) planItemInstance;
                WorkItemImpl wi = new WorkItemImpl();
                wi.setProcessInstanceId(getCaseInstance().getId());
                String deploymentId = (String) getCaseInstance().getKnowledgeRuntime().getEnvironment().get("deploymentId");
                wi.setDeploymentId(deploymentId);
                wi.setName(WorkItemParameters.UPDATE_TASK_STATUS);
                wi.setParameter(WorkItemParameters.SET_INPUT, Boolean.TRUE);
                wi.setParameter(WorkItemParameters.WORK_ITEM_ID, hit.getWorkItemId());
                wi.getParameters().putAll(ExpressionUtil.buildInputParameters(hit.getWork(), hit, hit.getItem().getDefinition()));
                hit.executeWorkItem(wi);
            }
        }
        return null;
    }
}