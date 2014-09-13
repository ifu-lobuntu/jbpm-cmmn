package org.jbpm.cmmn.task.internal.model;

import org.jbpm.cmmn.task.model.PlannableTaskSummary;
import org.kie.internal.task.api.model.InternalTaskSummary;

public interface InternalPlannableTaskSummary extends InternalTaskSummary, PlannableTaskSummary {
	public void setDiscretionaryItemId(String tableItemId);

	void setPlanItemName(String name);


}
