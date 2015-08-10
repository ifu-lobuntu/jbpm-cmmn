package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.planitem.PlanItem;

public interface OccurrablePlanItemInstance<T extends PlanItemDefinition> extends PlanItemInstance<T> {
	void occur();

	boolean isCompletionRequired();

	void internalSetRequired(boolean readBoolean);

	PlanItem<T> getPlanItem();
}
