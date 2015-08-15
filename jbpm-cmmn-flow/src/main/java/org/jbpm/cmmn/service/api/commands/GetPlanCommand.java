package org.jbpm.cmmn.service.api.commands;

import org.jbpm.casemgmt.CaseMgmtUtil;
import org.jbpm.casemgmt.role.RoleAssignment;
import org.jbpm.casemgmt.role.RoleInstance;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannableItem;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.kie.api.runtime.process.NodeInstance;

import java.util.*;


public class GetPlanCommand extends AbstractPlanningCommand<Plan> {
    private static final long serialVersionUID = 630L;
    private final String userId;

    public GetPlanCommand(long processId, Long planningTableContainerInstanceId, String userId) {
        super(processId, planningTableContainerInstanceId);
        this.userId = userId;
    }

    public Plan execute() {
        PlanningTableContainerInstance ptci = getPlanningTableContainerInstance();
        NodeInstanceContainer nic = getPlanningScope();
        List<PlannableItem> plannableItems = getPlannableItems(nic);
        Set<String> usersRoles = getUserRolesInCase();
        Map<String, ApplicableDiscretionaryItem> applicableDiscretionaryItemHashMap = getApplicableDiscretionaryItems(ptci, usersRoles);
        List<ApplicableDiscretionaryItem> applicableItems = new ArrayList<ApplicableDiscretionaryItem>(applicableDiscretionaryItemHashMap.values());
        return new Plan(plannableItems, applicableItems);
    }


    private List<PlannableItem> getPlannableItems(NodeInstanceContainer nic) {
        List<PlannableItem> plannableItems = new ArrayList<PlannableItem>();
        Collection<NodeInstance> nodeInstances = nic.getNodeInstances();
        for (NodeInstance nodeInstance : nodeInstances) {
            if (nodeInstance instanceof PlanItemInstance) {
                PlanItemInstance pii = (PlanItemInstance) nodeInstance;
                plannableItems.add(new PlannableItem(pii.getNodeName(), pii.getId(), pii.getPlanElementState(), pii.getPlanElementState().getSupportedTransitions(pii)));
            }
        }
        return plannableItems;
    }

    private Map<String, ApplicableDiscretionaryItem> getApplicableDiscretionaryItems(PlanningTableContainerInstance ptci, Set<String> usersRoles) {
        Map<String, ApplicableDiscretionaryItem> applicableDiscretionaryItemHashMap = new HashMap<String, ApplicableDiscretionaryItem>();
        PlanningTableContainerInstanceUtil.addApplicableItems(ptci, applicableDiscretionaryItemHashMap, usersRoles);
        return applicableDiscretionaryItemHashMap;
    }

    private Set<String> getUserRolesInCase() {
        Set<String> usersRoles = new HashSet<String>();
        WorkflowProcessInstance wfp = (WorkflowProcessInstance) super.processContext.getProcessInstance();
        Map<String, RoleInstance> roleInstanceMap = (Map<String, RoleInstance>) wfp.getVariable("CaseRoles");
        Collection<RoleInstance> roleInstances = roleInstanceMap.values();
        for (RoleInstance roleInstance : roleInstances) {
            if (userId == null) {
                usersRoles.add(roleInstance.getRoleName());
            } else {
                Collection<RoleAssignment> roleAssignments = roleInstance.getRoleAssignments();
                for (RoleAssignment roleAssignment : roleAssignments) {
                    if (roleAssignment.getUserId().equals(userId)) {
                        usersRoles.add(roleInstance.getRoleName());
                    }
                }
            }
        }
        return usersRoles;
    }
}
