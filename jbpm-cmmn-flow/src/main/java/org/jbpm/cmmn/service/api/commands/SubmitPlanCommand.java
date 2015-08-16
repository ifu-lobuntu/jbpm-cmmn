package org.jbpm.cmmn.service.api.commands;

import org.jbpm.cmmn.common.PlanningTableContainerInstance;
import org.jbpm.cmmn.service.model.PlannedItem;

import java.util.Collection;

public class SubmitPlanCommand extends AbstractPlanningCommand<Void> {
    private static final long serialVersionUID = 7907971723514784829L;

    public SubmitPlanCommand(long processInstanceId, Long planningTableContainerInstanceId) {
        super(processInstanceId, planningTableContainerInstanceId);
    }

    @Override
    public Void execute() {
        PlanningTableContainerInstance p = getPlanningTableContainerInstance();
        p.resumeAfterPlanning();
        return null;
    }

}