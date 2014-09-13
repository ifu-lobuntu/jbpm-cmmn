package org.jbpm.cmmn.instance;

import java.util.Map;
import java.util.Set;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;
import org.jbpm.cmmn.flow.core.PlanningTable;
import org.kie.api.runtime.process.NodeInstance;

public interface PlanningTableContainerInstance extends PlanElementLifecycleWithTask, org.jbpm.cmmn.common.PlanningTableContainerInstance {
	PlanningTable getPlanningTable();

	PlanItemInstanceContainer getPlanItemInstanceCreator();

	ControllableItemInstance<?> ensurePlanItemCreated(String discretionaryItemId, WorkItem wi);

	void addApplicableItems(Map<String, ApplicableDiscretionaryItem> result, Set<String> roles);

	NodeInstance getPlanningContextNodeInstance();

	WorkItem executeWorkItem(WorkItem wu);

	WorkItem createPlannedItem(String tableItemId);

	void makeDiscretionaryItemAvailable(String discretionaryItemId);
}
