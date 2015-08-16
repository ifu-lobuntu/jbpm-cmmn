package org.jbpm.cmmn.instance.impl.util;

import org.jbpm.casemgmt.role.Role;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.planitem.OnPart;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.TableItem;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.planning.impl.PlanningTableImpl;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstance;
import org.jbpm.cmmn.instance.PlanningTableContainerInstance;
import org.jbpm.cmmn.instance.impl.PlanItemInstanceFactoryNodeInstance;
import org.jbpm.workflow.core.Node;
import org.kie.api.runtime.process.NodeInstance;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class PlanningTableContainerInstanceUtil {
    public static void makeDiscretionaryItemAvailable(PlanningTableContainerInstance ptc, String discretionaryItemId) {
        DiscretionaryItem<?> di = ptc.getPlanningTable().getDiscretionaryItemById(discretionaryItemId);
        PlanItemInstanceFactoryNodeInstance<?> ni = (PlanItemInstanceFactoryNodeInstance<?>) ptc.getPlanItemInstanceCreator().getFirstNodeInstance(
                di.getFactoryNode().getId());
        ni.setIncludedByDiscretion(true);
    }

    public static PlanItemInstance createPlannedTask(PlanningTableContainerInstance ptc, String discretionaryItemId) {
        if (ptc != null && ptc.getPlanningTable() != null) {
            NodeInstance contextNodeInstance = ptc.getPlanningContextNodeInstance();
            DiscretionaryItem<? extends PlanItemDefinition> di = ptc.getPlanningTable().getDiscretionaryItemById(discretionaryItemId);
            PlanItemDefinition definition = di.getDefinition();
            for (Sentry sentry : di.getEntryCriteria().values()) {
                for (OnPart onPart : sentry.getOnParts()) {
                    ptc.getPlanItemInstanceCreator().getNodeInstance(onPart).trigger(null, Node.CONNECTION_DEFAULT_TYPE);
                }
                ptc.getPlanItemInstanceCreator().getNodeInstance(sentry);
            }
            PlanItemInstanceFactoryNodeInstance result = (PlanItemInstanceFactoryNodeInstance) ptc.getPlanItemInstanceCreator().getNodeInstance(di.getFactoryNode());
            result.ensureCreationIsTriggered();
            result.setIncludedByDiscretion(true);
            if (ptc.getPlanElementState() == PlanElementState.ACTIVE && di.getEntryCriteria().isEmpty()){
                result.trigger(null, Node.CONNECTION_DEFAULT_TYPE);
                PlanItemInstance pii=null;
                for (NodeInstance nodeInstance : ptc.getPlanItemInstanceCreator().getNodeInstances()) {
                    if(nodeInstance.getNodeId()==di.getId()){
                        pii=(PlanItemInstance)nodeInstance;
                    }
                }
                return pii;
            }else {
                return result;//uses ReuseNodeINstanceFactory
            }
        } else {
            return null;
        }

    }


    public static void addApplicableItems(PlanningTableContainerInstance container, Map<String, ApplicableDiscretionaryItem> result, Set<String> usersRoles) {
        if (container.getPlanningTable() != null && isAuthorized(usersRoles, container.getPlanningTable().getAuthorizedRoles())) {
            addApplicableItems(container, result, usersRoles, container.getPlanningTable());
        }
    }

    private static void addApplicableItems(PlanningTableContainerInstance container, Map<String, ApplicableDiscretionaryItem> target, Set<String> usersRoles,
                                           PlanningTable currentTable) {
        for (TableItem ti : currentTable.getTableItems()) {
            if (isAuthorized(usersRoles, ti.getAuthorizedRoles()) && ExpressionUtil.isApplicable(ti, container.getPlanningContextNodeInstance())) {
                if (ti instanceof DiscretionaryItemImpl<?>) {
                    DiscretionaryItemImpl<?> di = (DiscretionaryItemImpl<?>) ti;
                    ApplicableDiscretionaryItem adi = new ApplicableDiscretionaryItem(di.getElementId(), di.getDefinition().getName());
                    adi.setRepeatable(ExpressionUtil.isRepeating(container.getPlanningContextNodeInstance(), di));
                    adi.setActivatedManually(ExpressionUtil.isActivatedManually(container.getPlanningContextNodeInstance(), di));
                    adi.setHasEntryCriteria(!di.getEntryCriteria().isEmpty());
                    target.put(ti.getElementId(), adi);
                } else {
                    addApplicableItems(container, target, usersRoles, (PlanningTableImpl) ti);
                }
            }
        }
    }

    private static boolean isAuthorized(Set<String> usersRoles, Map<String, ? extends Role> authorizedRoles) {
        boolean authorized = authorizedRoles.isEmpty();
        for (Role role : authorizedRoles.values()) {
            if (usersRoles.contains(role.getName())) {
                authorized = true;
            }
        }
        return authorized;
    }

}
