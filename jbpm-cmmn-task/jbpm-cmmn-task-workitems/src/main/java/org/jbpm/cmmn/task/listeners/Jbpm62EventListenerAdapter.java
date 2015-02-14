package org.jbpm.cmmn.task.listeners;

import org.jbpm.cmmn.task.api.impl.CmmnTaskLifecycleEventListener;
import org.jbpm.services.task.wih.ExternalTaskEventListener;
import org.kie.api.task.TaskEvent;
import org.kie.api.task.model.Task;

public class Jbpm62EventListenerAdapter extends ExternalTaskEventListener
		implements CmmnTaskLifecycleEventListener {

	public Jbpm62EventListenerAdapter() {
		super();
	}

	@Override
	public void afterTaskReleasedEvent(TaskEvent te) {
		afterTaskReleasedEvent(te.getTask());

	}

	@Override
	public void afterTaskResumedEvent(TaskEvent te) {
		afterTaskResumedEvent(te.getTask());
	}

	@Override
	public void afterTaskSuspendedEvent(TaskEvent te) {
		afterTaskSuspendedEvent(te.getTask());
	}

	@Override
	public void afterTaskForwardedEvent(TaskEvent te) {
		afterTaskForwardedEvent(te.getTask());
	}

	@Override
	public void afterTaskDelegatedEvent(TaskEvent te) {
		afterTaskDelegatedEvent(te.getTask());
	}

	@Override
	public void afterTaskAddedEvent(TaskEvent task) {
		afterTaskAddedEvent(task.getTask());
	}

	@Override
	public void afterTaskClaimedEvent(TaskEvent task) {
		afterTaskClaimedEvent(task.getTask());
	}

	@Override
	public void afterTaskStoppedEvent(TaskEvent task) {
		afterTaskStoppedEvent(task.getTask());
	}

	@Override
	public void afterTaskStartedEvent(TaskEvent task) {
		afterTaskStartedEvent(task.getTask());
	}

	@Override
	public void afterTaskFailedEvent(TaskEvent task) {
		afterTaskFailedEvent(task.getTask());
	}

	@Override
	public void afterTaskExitedEvent(TaskEvent task) {
		afterTaskExitedEvent(task.getTask());
	}

	@Override
	public void afterTaskSkippedEvent(TaskEvent task) {
		afterTaskSkippedEvent(task.getTask());
	}

	@Override
	public void afterTaskCompletedEvent(TaskEvent task) {
		afterTaskCompletedEvent(task.getTask());
	}

	@Override
	public void afterTaskActivatedEvent(TaskEvent task) {
		afterTaskActivatedEvent(task.getTask());
	}

	@Override
	public void beforeTaskAddedEvent(TaskEvent t) {
		beforeTaskAddedEvent(t.getTask());
	}

	@Override
	public void beforeTaskCompletedEvent(TaskEvent task) {
		beforeTaskCompletedEvent(task.getTask());
	}

	// CMMN

	@Override
	public void afterTaskReactivatedEvent(Task task) {
	}

	@Override
	public void afterTaskReenabledEvent(Task task) {
	}

	@Override
	public void afterTaskParentSuspendedEvent(Task task) {
	}

	@Override
	public void afterTaskParentResumedEvent(Task task) {
	}

	@Override
	public void afterTaskExitCriteriaEvent(Task task) {
	}

	@Override
	public void afterTaskStartedAutomaticallyEvent(Task task) {
	}

	@Override
	public void beforeTaskReactivatedEvent(Task task) {
	}

	@Override
	public void beforeTaskReenabledEvent(Task task) {
	}

	@Override
	public void beforeTaskParentSuspendedEvent(Task task) {
	}

	@Override
	public void beforeTaskParentResumedEvent(Task task) {
	}

	@Override
	public void beforeTaskExitCriteriaEvent(Task task) {
	}

	@Override
	public void beforeTaskStartedAutomaticallyEvent(Task task) {
	}
//Bridging from 6.0
	public void afterTaskAddedEvent(Task task) {
	}

	public void afterTaskReleasedEvent(Task task) {
	}

	public void afterTaskForwardedEvent(Task task) {
	}

	public void afterTaskDelegatedEvent(Task task) {

	}

	public void afterTaskResumedEvent(Task task) {

	}

	public void afterTaskSuspendedEvent(Task task) {

	}

	public void afterTaskFailedEvent(Task task) {
	}

	public void afterTaskExitedEvent(Task task) {
	}

	public void afterTaskSkippedEvent(Task task) {
	}

	public void afterTaskCompletedEvent(Task task) {
	}

	@Override
	public void beforeTaskCompletedEvent(Task task) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTaskAddedEvent(Task t) {
		// TODO Auto-generated method stub

	}

    @Override
    public void beforeTaskUpdatedEvent(TaskEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterTaskUpdatedEvent(TaskEvent event) {
        // TODO Auto-generated method stub

    }

}