package org.jbpm.cmmn.flow.planning;

import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.planning.impl.TableItemImpl;
import org.kie.api.definition.process.Node;

import java.util.Collection;


public interface PlanningTable extends TableItem {

	Node getNode(long nodeId);

	PlanItemContainer getFirstPlanItemContainer();

	DiscretionaryItem<?> getDiscretionaryItemById(String discretionaryItemId);

	Collection<? extends TableItem> getTableItems();

    PlanningTableContainer getPlanningTableContainer();

	void addTableItem(TableItem item);
}
