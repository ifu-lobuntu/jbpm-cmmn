package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.workflow.instance.NodeInstance;

public interface PlanItemInstance<T extends PlanItemDefinition> extends PlanElementLifecycle, NodeInstance {

	void resume();

	void parentTerminate();

	ItemWithDefinition<T> getItem();

}
