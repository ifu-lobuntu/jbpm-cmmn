package org.jbpm.cmmn.task.internal.model;

import org.jbpm.cmmn.task.model.PlannedTaskSummary;
import org.kie.internal.task.api.model.InternalTaskSummary;

public interface InternalPlannedTaskSummary extends InternalTaskSummary, PlannedTaskSummary {
	public void setDiscretionaryItemId(String tableItemId);

	void setPlanItemName(String name);


}
