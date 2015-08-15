package org.jbpm.cmmn.service.api.commands;


import org.drools.core.command.impl.GenericCommand;
import org.drools.core.command.impl.KnowledgeCommandContext;
import org.drools.core.spi.ProcessContext;
import org.jbpm.casemgmt.CaseMgmtService;
import org.jbpm.casemgmt.CaseMgmtUtil;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.jbpm.workflow.instance.impl.WorkflowProcessInstanceImpl;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.internal.command.Context;
import org.kie.internal.runtime.KnowledgeContext;

import java.util.Collection;

public abstract class AbstractPlanningCommand<T> implements GenericCommand<T> {

    private static final long serialVersionUID = -4217142163951701835L;
    private long processInstanceId;
    private KieSession kieSession;
    private Long planningTableContainerInstanceId;
    protected CaseMgmtService caseMgmtService;
    protected ProcessContext processContext;

    public AbstractPlanningCommand(long processInstanceId, Long planningTableContainerInstanceId) {
        super();
        this.processInstanceId = processInstanceId;
        this.planningTableContainerInstanceId = planningTableContainerInstanceId;
    }

    @Override
    public T execute(Context context) {
        if (context instanceof KnowledgeCommandContext) {
            this.kieSession = ((KnowledgeCommandContext) context).getKieSession();
            this.processContext = new ProcessContext(this.kieSession);
            processContext.setProcessInstance(this.kieSession.getProcessInstance(processInstanceId));
            this.caseMgmtService = new CaseMgmtUtil(processContext);
            return execute();
        } else {
            throw new IllegalStateException("No KnowledgeContextFound");
        }
    }

    protected NodeInstanceContainer getPlanningScope() {
        NodeInstanceContainer nic;
        if (planningTableContainerInstanceId == null) {
            nic = (NodeInstanceContainer) this.processContext.getProcessInstance();
        } else {
            nic = getPlanningTableContainerInstance(planningTableContainerInstanceId).getPlanItemInstanceCreator();
        }
        return nic;
    }

    protected PlanningTableContainerInstance getPlanningTableContainerInstance() {
        PlanningTableContainerInstance ptci;
        if (planningTableContainerInstanceId == null) {
            ptci = (PlanningTableContainerInstance) this.processContext.getProcessInstance();
            ;
        } else {
            ptci = getPlanningTableContainerInstance(planningTableContainerInstanceId);
        }
        return ptci;
    }

    private PlanningTableContainerInstance<?> getPlanningTableContainerInstance(long uniqueId) {
        NodeInstance ni = getNodeInstance(uniqueId);
        return (PlanningTableContainerInstance<?>) ni;
    }

    protected PlanItemInstance<?> getPlanItem(long uniqueId) {
        NodeInstance ni = getNodeInstance(uniqueId);
        return (PlanItemInstance<?>) ni;
    }

    private NodeInstance getNodeInstance(long uniqueId) {
        NodeInstanceContainer pi = (NodeInstanceContainer) processContext.getProcessInstance();
        return pi.getNodeInstance(uniqueId,true);
    }

    protected abstract T execute();


}