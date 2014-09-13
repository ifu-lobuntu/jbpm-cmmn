package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.core.ItemWithDefinition;
import org.jbpm.cmmn.flow.core.PlanItemDefinition;

public interface PlanItemInstance<T extends PlanItemDefinition> extends PlanElementLifecycle {

	void resume();

	void parentTerminate();

	ItemWithDefinition<T> getItem();

}
