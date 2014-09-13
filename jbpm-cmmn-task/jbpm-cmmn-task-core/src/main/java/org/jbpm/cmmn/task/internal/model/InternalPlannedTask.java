package org.jbpm.cmmn.task.internal.model;

import org.jbpm.cmmn.task.model.PlannedTask;
import org.kie.internal.task.api.model.InternalTask;

public interface InternalPlannedTask extends PlannedTask, InternalTask {

	void setDiscretionaryItemId(String tableItemId);

	public abstract void setPlanItemName(String planItemName);

}
