package org.jbpm.cmmn.service.api;


import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannableItem;

import java.util.Collection;

public interface CMMNService {
    void transitionPlanItem(long processId, String planItemUniqueId, PlanItemTransition t);

    void transitionCase(long processId, PlanItemTransition t);

    Plan getPlan(long processId);

    Plan getPlan(long processId, String planningTableContainerId);

    void submitPlan(long processId, String planningTableContainerId, Collection<PlannableItem> plannedTasks, boolean resume);

    Plan startPlanning(long processId, String user, boolean suspend);

    Plan startPlanning(long processId, String planningTableContainerId, String user, boolean suspend);

    Plan preparePlannableItem(long processId, String planningTableContainerId, String discretionaryItemId);

    void makeDiscretionaryItemAvailable(long processId, String planningTableContainerId, String discretionaryItemId);

}
