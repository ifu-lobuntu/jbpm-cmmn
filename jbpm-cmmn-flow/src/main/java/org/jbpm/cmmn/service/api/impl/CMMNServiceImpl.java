package org.jbpm.cmmn.service.api.impl;


import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.service.api.CMMNService;
import org.jbpm.cmmn.service.api.commands.AbstractPlanningCommand;
import org.jbpm.cmmn.service.api.commands.GetPlanCommand;
import org.jbpm.cmmn.service.api.commands.SubmitPlanCommand;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannableItem;
import org.jbpm.workflow.instance.node.EventNodeInstanceInterface;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.audit.AuditService;
import org.kie.api.task.TaskService;

import java.util.Collection;

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
    public void transitionPlanItem(final long processInstanceId, final String uniqueId, final PlanItemTransition t) {
        ksession.execute(new AbstractPlanningCommand<Void>(processInstanceId, null) {
            private static final long serialVersionUID = 630L;

            public Void execute() {
                ((EventNodeInstanceInterface) getPlanItem(uniqueId)).signalEvent("Transition", t);
                return null;
            }
        });
    }

    @Override
    public void transitionCase(long processInstanceId, PlanItemTransition t) {
        ksession.signalEvent("Transition", t, processInstanceId);
    }

    @Override
    public Plan getPlan(long processInstanceId) {
        return ksession.execute(new GetPlanCommand(processInstanceId,null,null));
    }

    @Override
    public Plan getPlan(long processInstanceId, String planningTableContainerInstanceId) {
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
    public Plan startPlanning(long processInstanceId, String planningTableContainerId, String user, boolean suspend) {
        if(suspend){
         transitionPlanItem(processInstanceId,planningTableContainerId,PlanItemTransition.SUSPEND);
        }
        return ksession.execute(new GetPlanCommand(processInstanceId,planningTableContainerId,user));
    }

    @Override
    public void submitPlan(long processInstanceId, String planningTableContainerId, Collection<PlannableItem> plannedTasks, boolean resume) {
        ksession.execute(new SubmitPlanCommand(plannedTasks, processInstanceId,planningTableContainerId,resume));
    }

    @Override
    public Plan preparePlannableItem(long processInstanceId, String planningTableContainerId, String discretionaryItemId) {
        return null;
    }

    @Override
    public void makeDiscretionaryItemAvailable(long processInstanceId, String planningTableContainerId, String discretionaryItemId) {

    }

}
