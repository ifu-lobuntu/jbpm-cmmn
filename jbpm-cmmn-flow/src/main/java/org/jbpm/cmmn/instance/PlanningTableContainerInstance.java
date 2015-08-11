package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.kie.api.runtime.process.NodeInstance;

public interface PlanningTableContainerInstance<T extends PlanItemDefinition> extends  org.jbpm.cmmn.common.PlanningTableContainerInstance,PlanElementLifecycle {
	PlanningTable getPlanningTable();

	PlanItemInstanceContainer getPlanItemInstanceCreator();

	NodeInstance getPlanningContextNodeInstance();

	NodeInstance createPlannedItem(String tableItemId);


}
