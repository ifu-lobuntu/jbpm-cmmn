package org.jbpm.cmmn.task.model;

import org.kie.api.task.model.TaskSummary;

public interface PlannedTaskSummary extends TaskSummary {
	public String getDiscretionaryItemId();

	String getPlanItemName();

}
