package org.jbpm.cmmn.task.api.impl;

import org.jbpm.cmmn.common.CaseInstance;
import org.jbpm.cmmn.common.PlanningTableContainerInstance;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;

public class MakeDiscretionaryItemAvailableCommand extends AbstractPlanningCommand<Void> {
	private final String discretionaryItemId;
	private final long parentTaskId;
	private RuntimeManager runtimeManager;

	private static final long serialVersionUID = -8445378L;

	public MakeDiscretionaryItemAvailableCommand(RuntimeManager rm,  String discretionaryItemId, long parentTaskId) {
		super();
		this.discretionaryItemId = discretionaryItemId;
		this.parentTaskId = parentTaskId;
		this.runtimeManager = rm;
	}

	@Override
	public Void execute() {
		long processInstanceId = getTaskById(parentTaskId).getTaskData().getProcessInstanceId();
		RuntimeEngine runtime = runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(processInstanceId));
		CaseInstance ci = (CaseInstance) runtime.getKieSession().getProcessInstance(processInstanceId);
		PlanningTableContainerInstance ptci = ci.findPlanningTableContainerInstance(getTaskById(parentTaskId).getTaskData().getWorkItemId());
		ptci.makeDiscretionaryItemAvailable(discretionaryItemId);
		return null;
	}
}