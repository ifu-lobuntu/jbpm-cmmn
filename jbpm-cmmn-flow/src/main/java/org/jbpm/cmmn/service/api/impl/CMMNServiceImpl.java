package org.jbpm.cmmn.service.api.impl;


import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.service.api.CMMNService;
import org.jbpm.cmmn.service.api.commands.AbstractPlanningCommand;
import org.jbpm.cmmn.service.api.commands.GetPlanCommand;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.workflow.instance.node.EventNodeInstanceInterface;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.audit.AuditService;
import org.kie.api.task.TaskService;

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
    public void transitionPlanItem(final long processId, final String uniqueId, final PlanItemTransition t) {
        ksession.execute(new AbstractPlanningCommand<Void>(processId) {
            private static final long serialVersionUID = 630L;

            public Void execute() {
                ((EventNodeInstanceInterface) getPlanItem(uniqueId)).signalEvent("Transition", t);
                return null;
            }
        });
    }

    @Override
    public void transitionCase(long processId, PlanItemTransition t) {
        ksession.signalEvent("Transition", t, processId);
    }

    @Override
    public Plan getPlan(long processId) {
        return ksession.execute(new GetPlanCommand(processId,null));
    }
    public Plan getPlan(long processId, String planningTableContainerInstanceId) {
        return ksession.execute(new GetPlanCommand(processId,planningTableContainerInstanceId));
    }

}
