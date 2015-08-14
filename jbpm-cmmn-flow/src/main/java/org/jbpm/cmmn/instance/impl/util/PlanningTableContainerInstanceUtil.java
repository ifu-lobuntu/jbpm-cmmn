package org.jbpm.cmmn.instance.impl.util;

import org.drools.core.process.core.Work;
import org.drools.core.process.instance.WorkItem;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.casemgmt.role.Role;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;
import org.jbpm.cmmn.flow.definition.HumanTaskDefinition;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.TaskDefinition;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.TableItem;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.planning.impl.PlanningTableImpl;
import org.jbpm.cmmn.instance.*;
import org.jbpm.cmmn.instance.impl.HumanTaskInstance;
import org.jbpm.cmmn.instance.impl.PlanItemInstanceFactoryNodeInstance;
import org.jbpm.workflow.core.impl.NodeImpl;
import org.kie.api.runtime.process.NodeInstance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlanningTableContainerInstanceUtil {
	public static void makeDiscretionaryItemAvailable(PlanningTableContainerInstance ptc, String discretionaryItemId) {
		DiscretionaryItem <?> di = ptc.getPlanningTable().getDiscretionaryItemById(discretionaryItemId);
		PlanItemInstanceFactoryNodeInstance<?> ni = (PlanItemInstanceFactoryNodeInstance<?>) ptc.getPlanItemInstanceCreator().getFirstNodeInstance(
				di.getFactoryNode().getId());
		ni.setIncludedByDiscretion(true);
	}

	public static NodeInstance createPlannedTask(PlanningTableContainerInstance ptc, String discretionaryItemId) {
		if (ptc != null && ptc.getPlanningTable() != null) {
			NodeInstance contextNodeInstance = ptc.getPlanningContextNodeInstance();
			DiscretionaryItem<? extends PlanItemDefinition> di = ptc.getPlanningTable().getDiscretionaryItemById(discretionaryItemId);
			PlanItemDefinition definition = di.getDefinition();
			if (ptc instanceof HumanTaskInstance) {
				Work work = ((HumanTaskInstance)ptc).getWork();
				WorkItemImpl workItem = new WorkItemImpl();
				workItem.setName(work.getName());
				workItem.setProcessInstanceId(contextNodeInstance.getProcessInstance().getId());
				workItem.setParameters(new HashMap<String, Object>(work.getParameters()));
				workItem.getParameters().putAll(ExpressionUtil.buildInputParameters(work, contextNodeInstance, (TaskDefinition) definition));
				CaseInstance caseInstance = (CaseInstance) contextNodeInstance.getProcessInstance();
				String deploymentId = (String) caseInstance.getKnowledgeRuntime().getEnvironment().get("deploymentId");
				workItem.setDeploymentId(deploymentId);
				workItem.setParameter(WorkItemParameters.COMMENT, definition.getDescription());
				//TODO figure out what to do here.
//				workItem.setParameter(WorkItemParameters.PARENT_WORK_ITEM_ID, ptc.getWorkItemId());
//				workItem.setParameter(WorkItemParameters.PLANNED, Boolean.TRUE);
//				workItem.setParameter(WorkItemParameters.DISCRETIONARY_ITEM_ID, discretionaryItemId);
//				ptc.executeWorkItem(workItem);
			}
			return ptc.createPlannedItem(discretionaryItemId);

		} else {
			return null;
		}

	}

	public static ControllableItemInstance<?> ensurePlanItemCreated(PlanningTableContainerInstance e, String discretionaryItemId, WorkItem wi) {
		DiscretionaryItem<?> item = e.getPlanningTable().getDiscretionaryItemById(discretionaryItemId);
		PlanItemInstanceContainer piic = e.getPlanItemInstanceCreator();
		// TODO we may want to work through the factory node here
		ControllableItemInstance<?> found = PlanItemInstanceContainerUtil.findNodeForWorkItem(piic, wi.getId());
		if (found == null) {
			found = (ControllableItemInstance<?>) piic.getNodeInstance(item);
			found.internalTriggerWithoutInstantiation(piic.getNodeInstance(piic.getPlanItemContainer().getDefaultSplit()), NodeImpl.CONNECTION_DEFAULT_TYPE, wi);
			if (e.getPlanElementState() == PlanElementState.ACTIVE) {
				found.create();
				found.noteInstantiation();
			} else {
				found.setPlanElementState(PlanElementState.INITIAL);
			}
		}
		return found;
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
