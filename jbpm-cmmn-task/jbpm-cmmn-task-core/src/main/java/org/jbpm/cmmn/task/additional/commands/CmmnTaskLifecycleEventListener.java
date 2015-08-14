package org.jbpm.cmmn.task.additional.commands;

import org.jbpm.services.task.lifecycle.listeners.TaskLifeCycleEventListener;
import org.kie.api.task.model.Task;
import org.kie.api.task.TaskEvent;
public interface CmmnTaskLifecycleEventListener extends TaskLifeCycleEventListener {

	void beforeTaskCompletedEvent(TaskEvent  task);

	void beforeTaskAddedEvent(TaskEvent  t);

	void afterTaskReactivatedEvent(TaskEvent  task);

	void afterTaskReenabledEvent(TaskEvent  task);

	void afterTaskParentSuspendedEvent(TaskEvent  task);

	void afterTaskParentResumedEvent(TaskEvent  task);

	void afterTaskExitCriteriaEvent(TaskEvent  task);

	void afterTaskStartedAutomaticallyEvent(TaskEvent  task);

	void beforeTaskReactivatedEvent(TaskEvent  task);

	void beforeTaskReenabledEvent(TaskEvent  task);

	void beforeTaskParentSuspendedEvent(TaskEvent  task);

	void beforeTaskParentResumedEvent(TaskEvent  task);

	void beforeTaskExitCriteriaEvent(TaskEvent  task);

	void beforeTaskStartedAutomaticallyEvent(TaskEvent  task);

}