package org.jbpm.cmmn.service.api.commands;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.cmmn.common.CaseInstance;
import org.jbpm.cmmn.service.api.commands.AbstractPlanningCommand;
import org.jbpm.cmmn.service.model.PlannableItem;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;

public class PreparePlannedTaskCommand extends AbstractPlanningCommand<PlannableItem> {
	private final String discretionaryItemId;
	private RuntimeManager runtimeManager;

	private static final long serialVersionUID = -8445378L;

	public PreparePlannedTaskCommand(RuntimeManager rm, long processId, String planningTableContainerInstanceId, String discretionaryItemId) {
		super(processId,planningTableContainerInstanceId);
		this.discretionaryItemId = discretionaryItemId;
		this.runtimeManager = rm;
	}

	@Override
	public PlannableItem execute() {
		long processInstanceId = getTaskById(parentTaskId).getTaskData().getProcessInstanceId();
		RuntimeEngine runtime = runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(processInstanceId));
		CaseInstance ci = (CaseInstance) runtime.getKieSession().getProcessInstance(processInstanceId);
		WorkItem wi = ci.createPlannedItem(getWorkItemId(parentTaskId), discretionaryItemId);
		return (PlannableItem) getTaskByWorkItemId(wi.getId());
	}
}