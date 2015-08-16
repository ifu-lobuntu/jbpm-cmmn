package org.jbpm.cmmn.service.api;


import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.service.model.Plan;
import org.jbpm.cmmn.service.model.PlannedItem;

import java.util.Collection;
import java.util.Map;

public interface CMMNService {
    void transitionPlanItem(long processInstanceId, long planItemUniqueId, PlanItemTransition t);

    void transitionCase(long processInstanceId, PlanItemTransition t);

    Plan getPlan(long processInstanceId);

    Plan getPlan(long processInstanceId, long planningTableContainerId);

    void submitPlan(long processInstanceId);

    void submitPlan(long processInstanceId, long planningTableContainerId);

    Plan startPlanning(long processInstanceId, String user, boolean suspend);

    Plan startPlanning(long processInstanceId, long planningTableContainerId, String user, boolean suspend);

    PlannedItem preparePlannedItem(long processInstanceId, String discretionaryItemId);

    PlannedItem preparePlannedItem(long processInstanceId, long planningTableContainerId, String discretionaryItemId);

    void overrideInputTo(long processInstanceId, long planItemUniqueId, Map<String, Object> input);

    Map<String, Object> getInputTo(long processInstanceId, long planItemUniqueId);

}
