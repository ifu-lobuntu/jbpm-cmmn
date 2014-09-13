package org.jbpm.cmmn.task.api;

import java.util.Collection;

import org.jbpm.cmmn.task.model.PlannableTask;
import org.jbpm.cmmn.task.model.PlanningTableInstance;
import org.kie.api.runtime.manager.RuntimeManager;

public interface PlanningService {

	void setRuntimeManager(RuntimeManager runtimeManager);

	void submitPlan(long parentTaskId, Collection<PlannableTask> plannedTasks, boolean resume);

	PlanningTableInstance startPlanning(long parentTaskId, String user, boolean suspend);

	PlannableTask preparePlannableTask(long parentTaskId, String discretionaryItemId);

	void makeDiscretionaryItemAvailable(long parentTaskId, String discretionaryItemId);

	PlannableTask getPlannableTaskById(long id);

}