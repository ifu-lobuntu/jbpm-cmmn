package org.jbpm.cmmn.service.api.commands;

import org.jbpm.casemgmt.role.RoleAssignment;
import org.jbpm.casemgmt.role.RoleInstance;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.cmmn.instance.impl.PlanItemInstanceFactoryNodeInstance;
import org.jbpm.cmmn.instance.impl.util.PlanningTableContainerInstanceUtil;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannedItem;
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
        List<PlannedItem> plannedItems = getPlannableItems(nic);
        Set<String> usersRoles = getUserRolesInCase();
        Map<String, ApplicableDiscretionaryItem> applicableDiscretionaryItemHashMap = getApplicableDiscretionaryItems(ptci, usersRoles);
        List<ApplicableDiscretionaryItem> applicableItems = new ArrayList<ApplicableDiscretionaryItem>(applicableDiscretionaryItemHashMap.values());
        return new Plan(plannedItems, applicableItems);
    }


    private List<PlannedItem> getPlannableItems(NodeInstanceContainer nic) {
        List<PlannedItem> plannedItems = new ArrayList<PlannedItem>();
        Collection<NodeInstance> nodeInstances = nic.getNodeInstances();
        Collection<PlanItemInstanceFactoryNodeInstance> factories = new HashSet<PlanItemInstanceFactoryNodeInstance>();
        Set<String> activePlanItems = new HashSet<String>();
        for (NodeInstance nodeInstance : nodeInstances) {
            if(nodeInstance instanceof PlanItemInstanceFactoryNodeInstance) {
                factories.add((PlanItemInstanceFactoryNodeInstance) nodeInstance);
            }else if (nodeInstance instanceof PlanItemInstance) {
                PlanItemInstance pii = (PlanItemInstance) nodeInstance;
                plannedItems.add(createPlannableItem(pii));
                activePlanItems.add(pii.getItem().getEffectiveName());
            }
        }
        for (PlanItemInstanceFactoryNodeInstance factory : factories) {
            if(!activePlanItems.contains(factory.getItem().getEffectiveName())){
                plannedItems.add(createPlannableItem(factory));
            }
        }
        return plannedItems;
    }

    private Map<String, ApplicableDiscretionaryItem> getApplicableDiscretionaryItems(PlanningTableContainerInstance ptci, Set<String> usersRoles) {
        Map<String, ApplicableDiscretionaryItem> applicableDiscretionaryItemHashMap = new HashMap<String, ApplicableDiscretionaryItem>();
        PlanningTableContainerInstanceUtil.addApplicableItems(ptci, applicableDiscretionaryItemHashMap, usersRoles);
        return applicableDiscretionaryItemHashMap;
    }

    private Set<String> getUserRolesInCase() {
        Set<String> usersRoles = new HashSet<String>();
        WorkflowProcessInstance wfp = getCaseInstance();
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
