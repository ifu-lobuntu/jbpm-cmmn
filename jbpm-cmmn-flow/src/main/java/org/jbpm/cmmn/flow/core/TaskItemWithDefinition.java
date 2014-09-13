package org.jbpm.cmmn.flow.core;

import org.drools.core.process.core.Work;
import org.jbpm.workflow.core.Node;

public interface TaskItemWithDefinition<T extends PlanItemDefinition> extends ItemWithDefinition<T> {
	Work getWork();

	Node getFactoryNode();

}
