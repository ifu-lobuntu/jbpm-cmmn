package org.jbpm.cmmn.service.api.commands;

import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannableItem;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.kie.api.runtime.process.NodeInstance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class GetPlanCommand extends AbstractPlanningCommand<Plan> {
    private static final long serialVersionUID = 630L;
    private String planningTableContainerInstanceId;

    public GetPlanCommand(long processId, String planningTableContainerInstanceId) {
        super(processId);
        this.planningTableContainerInstanceId = planningTableContainerInstanceId;
    }

    public Plan execute() {
        NodeInstanceContainer nic = null;
        PlanningTable pt=null;
        if (planningTableContainerInstanceId == null) {
            nic = (NodeInstanceContainer) super.kieSession.getProcessInstance(processId);
            pt=((PlanningTableContainerInstance)nic).getPlanningTable();
        } else {
            PlanningTableContainerInstance<?> ptci = getPlanningTableContainerInstance(planningTableContainerInstanceId);
            nic = ptci.getPlanItemInstanceCreator();
            pt=ptci.getPlanningTable();
        }
        List<PlannableItem> plannableItems = new ArrayList<PlannableItem>();
        Collection<NodeInstance> nodeInstances = nic.getNodeInstances();
        for (NodeInstance nodeInstance : nodeInstances) {
            if (nodeInstance instanceof PlanItemInstance) {
                PlanItemInstance pii = (PlanItemInstance) nodeInstance;
                plannableItems.add(new PlannableItem(pii.getNodeName(), pii.getUniqueId(), pii.getPlanElementState(), pii.getPlanElementState().getSupportedTransitions(pii)));
            }
        }
        return new Plan(plannableItems);
    }
}
