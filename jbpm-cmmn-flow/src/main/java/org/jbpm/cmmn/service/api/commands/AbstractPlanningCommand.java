package org.jbpm.cmmn.service.api.commands;


import org.drools.core.command.impl.GenericCommand;
import org.drools.core.command.impl.KnowledgeCommandContext;
import org.drools.core.spi.ProcessContext;
import org.jbpm.casemgmt.CaseMgmtService;
import org.jbpm.casemgmt.CaseMgmtUtil;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.cmmn.instance.impl.PlanItemInstanceFactoryNodeInstance;
import org.jbpm.cmmn.service.model.PlannedItem;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.internal.command.Context;

public abstract class AbstractPlanningCommand<T> implements GenericCommand<T> {

    private static final long serialVersionUID = -4217142163951701835L;
    private long processInstanceId;
    private KieSession kieSession;
    private Long planningTableContainerInstanceId;
    protected CaseMgmtService caseMgmtService;
    private ProcessContext processContext;

    public AbstractPlanningCommand(long processInstanceId, Long planningTableContainerInstanceId) {
        super();
        this.processInstanceId = processInstanceId;
        this.planningTableContainerInstanceId = planningTableContainerInstanceId;
    }

    protected PlannedItem createPlannableItem(PlanItemInstance pii) {
        String nodeName = pii.getNodeName();
        if(pii instanceof PlanItemInstanceFactoryNodeInstance){
            nodeName=pii.getItem().getEffectiveName();
        }
        return new PlannedItem(nodeName, pii.getId(), pii.getPlanElementState(), pii.getPlanElementState().getSupportedTransitions(pii));
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
    protected CaseInstance getCaseInstance(){
        return (CaseInstance) processContext.getProcessInstance();
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