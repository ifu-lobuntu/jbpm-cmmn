package org.jbpm.cmmn.task.model;

import org.kie.api.task.model.TaskSummary;

public interface PlannableTaskSummary extends TaskSummary {
	public String getDiscretionaryItemId();

	String getPlanItemName();

}
