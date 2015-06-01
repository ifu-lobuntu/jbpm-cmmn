package org.jbpm.cmmn.flow.core;

import java.util.Collection;

import org.kie.api.definition.process.Node;


public interface PlanningTable extends TableItem {

	Node getNode(long nodeId);

	PlanItemContainer getFirstPlanItemContainer();

	DiscretionaryItem<?> getDiscretionaryItemById(String discretionaryItemId);

	Collection<? extends TableItem> getTableItems();

    PlanningTableContainer getPlanningTableContainer();

}
