package org.jbpm.cmmn.task.api.impl;

import org.jbpm.services.task.lifecycle.listeners.TaskLifeCycleEventListener;
import org.kie.api.task.model.Task;

public interface CmmnTaskLifecycleEventListener extends TaskLifeCycleEventListener {

	void beforeTaskCompletedEvent(Task task);

	void beforeTaskAddedEvent(Task t);

	void afterTaskReactivatedEvent(Task task);

	void afterTaskReenabledEvent(Task task);

	void afterTaskParentSuspendedEvent(Task task);

	void afterTaskParentResumedEvent(Task task);

	void afterTaskExitCriteriaEvent(Task task);

	void afterTaskStartedAutomaticallyEvent(Task task);

	void beforeTaskReactivatedEvent(Task task);

	void beforeTaskReenabledEvent(Task task);

	void beforeTaskParentSuspendedEvent(Task task);

	void beforeTaskParentResumedEvent(Task task);

	void beforeTaskExitCriteriaEvent(Task task);

	void beforeTaskStartedAutomaticallyEvent(Task task);

}