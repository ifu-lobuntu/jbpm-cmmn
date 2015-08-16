package org.jbpm.cmmn.service.api.impl;


import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.service.api.CMMNService;
import org.jbpm.cmmn.service.api.commands.*;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannedItem;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.audit.AuditService;
import org.kie.api.task.TaskService;

import java.util.Collection;
import java.util.Map;

public class CMMNServiceImpl implements CMMNService {
    private KieSession ksession;
    private AuditService auditService;
    private TaskService taskService;

    public CMMNServiceImpl(RuntimeEngine engine) {
        this.auditService = engine.getAuditService();
        this.ksession = engine.getKieSession();
        this.taskService = engine.getTaskService();
    }


    @Override
    public void transitionPlanItem(final long processInstanceId, final long uniqueId, final PlanItemTransition t) {
        ksession.execute(new PerformTransitionCommand(processInstanceId, uniqueId, t));
    }

    @Override
    public void transitionCase(long processInstanceId, PlanItemTransition t) {
        ksession.execute(new PerformTransitionCommand(processInstanceId, null, t));
    }

    @Override
    public Plan getPlan(long processInstanceId) {
        return ksession.execute(new GetPlanCommand(processInstanceId,null,null));
    }

    @Override
    public Plan getPlan(long processInstanceId, long planningTableContainerInstanceId) {
        return ksession.execute(new GetPlanCommand(processInstanceId,planningTableContainerInstanceId,null));
    }


    @Override
    public Plan startPlanning(long processInstanceId, String user, boolean suspend) {
        if(suspend){
            transitionCase(processInstanceId, PlanItemTransition.SUSPEND);
        }
        return ksession.execute(new GetPlanCommand(processInstanceId, null, user));
    }

    @Override
    public Plan startPlanning(long processInstanceId, long planningTableContainerId, String user, boolean suspend) {
        if(suspend){
         transitionPlanItem(processInstanceId, planningTableContainerId, PlanItemTransition.SUSPEND);
        }
        return ksession.execute(new GetPlanCommand(processInstanceId,planningTableContainerId,user));
    }

    @Override
    public PlannedItem preparePlannedItem(long processInstanceId, String discretionaryItemId) {
        return ksession.execute(new PreparePlannedTaskCommand(processInstanceId,null,discretionaryItemId));
    }


    @Override
    public PlannedItem preparePlannedItem(long processInstanceId, long planningTableContainerId, String discretionaryItemId) {
       return ksession.execute(new PreparePlannedTaskCommand(processInstanceId,planningTableContainerId,discretionaryItemId));
    }

    @Override
    public void overrideInputTo(long processInstanceId, long planItemUniqueId, Map<String, Object> input) {
        ksession.execute(new OverrideInputCommand(processInstanceId,planItemUniqueId,input));
    }
    @Override
    public Map<String, Object> getInputTo(long processInstanceId, long planItemUniqueId) {
        return ksession.execute(new GetInputCommand(processInstanceId,planItemUniqueId));
    }

    @Override
    public void submitPlan(long processInstanceId, long planningTableContainerId) {
        ksession.execute(new SubmitPlanCommand(processInstanceId,planningTableContainerId));
    }

    @Override
    public void submitPlan(long processInstanceId) {
        ksession.execute(new SubmitPlanCommand(processInstanceId,null));
    }
}
