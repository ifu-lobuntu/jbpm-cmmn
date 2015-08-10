package org.jbpm.cmmn.service.api.commands;


import org.drools.core.command.impl.GenericCommand;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.runtime.KnowledgeContext;
import org.kie.internal.command.Context;

public abstract class AbstractPlanningCommand<T> implements GenericCommand<T> {

    private static final long serialVersionUID = -4217142163951701835L;
    protected long processId;
    protected KieSession kieSession;

    public AbstractPlanningCommand(long processId) {
        super();
        this.processId = processId;
    }

    @Override
    public T execute(Context context) {
        if (context instanceof KnowledgeContext) {
            KieRuntime kieRuntime = ((KnowledgeContext) context).getKieRuntime();
            if (kieRuntime instanceof KieSession) {
                this.kieSession = (KieSession) kieRuntime;
                return execute();
            } else {
                throw new IllegalStateException("No KieSession Found");
            }
        } else {
            throw new IllegalStateException("No KnowledgeContextFound");
        }
    }

    protected PlanningTableContainerInstance<?> getPlanningTableContainerInstance(String uniqueId) {
        NodeInstance ni = getNodeInstance(uniqueId);
        return (PlanningTableContainerInstance<?>) ni;
    }
    protected PlanItemInstance<?> getPlanItem(String uniqueId) {
        NodeInstance ni = getNodeInstance(uniqueId);
        return (PlanItemInstance<?>) ni;
    }

    private NodeInstance getNodeInstance(String uniqueId) {
        WorkflowProcessInstance pi = (WorkflowProcessInstance) this.kieSession.getProcessInstance(this.processId);
        NodeInstanceContainer nic = (NodeInstanceContainer) pi;
        NodeInstance ni = null;
        for (String s : uniqueId.split("\\:")) {
            ni = nic.getNodeInstance(Long.valueOf(s));
            if (ni instanceof NodeInstanceContainer) {
                nic = (NodeInstanceContainer) ni;
            }
        }
        return ni;
    }

    protected abstract T execute();


}