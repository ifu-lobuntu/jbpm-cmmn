package org.jbpm.cmmn.task.api.impl;


public abstract class AbstractPlanningCommand<T> extends AbstractTaskCommand<T> {

	private static final long serialVersionUID = -4217142163951701835L;

	public AbstractPlanningCommand() {
		super();
	}

	protected long getWorkItemId(long parentTaskId) {
		return getTaskById(parentTaskId).getTaskData().getWorkItemId();
	}
}