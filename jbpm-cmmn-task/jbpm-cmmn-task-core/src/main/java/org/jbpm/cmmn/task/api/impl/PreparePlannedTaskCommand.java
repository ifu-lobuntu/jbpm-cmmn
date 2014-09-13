package org.jbpm.cmmn.task.api.impl;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.cmmn.common.CaseInstance;
import org.jbpm.cmmn.task.model.PlannedTask;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;

public class PreparePlannedTaskCommand extends AbstractPlanningCommand<PlannedTask> {
	private final String discretionaryItemId;
	private final long parentTaskId;
	private RuntimeManager runtimeManager;

	private static final long serialVersionUID = -8445378L;

	public PreparePlannedTaskCommand(RuntimeManager rm, String discretionaryItemId, long parentTaskId) {
		super();
		this.discretionaryItemId = discretionaryItemId;
		this.parentTaskId = parentTaskId;
		this.runtimeManager = rm;
	}

	@Override
	public PlannedTask execute() {
		long processInstanceId = getTaskById(parentTaskId).getTaskData().getProcessInstanceId();
		RuntimeEngine runtime = runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(processInstanceId));
		CaseInstance ci = (CaseInstance) runtime.getKieSession().getProcessInstance(processInstanceId);
		WorkItem wi = (WorkItem) ci.createPlannedItem(getWorkItemId(parentTaskId), discretionaryItemId);
		return find(PlannedTaskImpl.class, getTaskByWorkItemId(wi.getId()).getId());
	}
}