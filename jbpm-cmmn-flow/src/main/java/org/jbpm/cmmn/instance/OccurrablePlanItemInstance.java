package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.core.PlanItem;
import org.jbpm.cmmn.flow.core.PlanItemDefinition;

public interface OccurrablePlanItemInstance<T extends PlanItemDefinition> extends PlanItemInstance<T> {
	void occur();

	boolean isCompletionRequired();

	void internalSetRequired(boolean readBoolean);

	PlanItem<T> getPlanItem();
}
