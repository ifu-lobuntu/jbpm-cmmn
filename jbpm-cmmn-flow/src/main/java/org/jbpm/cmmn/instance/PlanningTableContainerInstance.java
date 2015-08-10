package org.jbpm.cmmn.instance;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.kie.api.runtime.process.NodeInstance;

import java.util.Map;
import java.util.Set;

public interface PlanningTableContainerInstance<T extends PlanItemDefinition> extends  org.jbpm.cmmn.common.PlanningTableContainerInstance,PlanElementLifecycle {
	PlanningTable getPlanningTable();

	PlanItemInstanceContainer getPlanItemInstanceCreator();

	ControllableItemInstance<?> ensurePlanItemCreated(String discretionaryItemId, WorkItem wi);

	void addApplicableItems(Map<String, ApplicableDiscretionaryItem> result, Set<String> roles);

	NodeInstance getPlanningContextNodeInstance();

	NodeInstance createPlannedItem(String tableItemId);


}
