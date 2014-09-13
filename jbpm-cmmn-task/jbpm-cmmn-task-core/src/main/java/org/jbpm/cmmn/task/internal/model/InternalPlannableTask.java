package org.jbpm.cmmn.task.internal.model;

import org.jbpm.cmmn.task.model.PlannableTask;
import org.kie.internal.task.api.model.InternalTask;

public interface InternalPlannableTask extends PlannableTask, InternalTask {

	void setDiscretionaryItemId(String tableItemId);

	public abstract void setPlanItemName(String planItemName);

}
