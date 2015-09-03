package org.jbpm.cmmn.instance.impl.util;

import org.jbpm.cmmn.instance.*;
import org.jbpm.cmmn.instance.impl.MilestoneInstance;
import org.jbpm.cmmn.instance.impl.PlanItemInstanceFactoryNodeInstance;
import org.kie.api.runtime.process.NodeInstance;

import java.util.*;

/**
 * Defines all the logic common to CaseInstances and StagePlanItemInstances. This is required as it is not possible to
 * give them a common superclass
 */
public class PlanItemInstanceContainerUtil {

    public static boolean canComplete(PlanItemInstanceContainer container) {
        if (container.getPlanElementState() != PlanElementState.ACTIVE) {
            return false;
        }
        Collection<? extends PlanItemInstance<?>> nodeInstances = container.getChildren();
        for (PlanItemInstance<?> nodeInstance : nodeInstances) {
            if (nodeInstance instanceof PlanItemInstanceFactoryNodeInstance
                    && ((PlanItemInstanceFactoryNodeInstance<?>) nodeInstance).isPlanItemInstanceStillRequired()  && !nodeInstance.getPlanElementState().isTerminalState()) {
                return false;
            } else if (nodeInstance instanceof MilestoneInstance && ((MilestoneInstance) nodeInstance).isCompletionStillRequired()) {
                return false;
            } else if (nodeInstance instanceof ControllableItemInstance && ((ControllableItemInstance<?>) nodeInstance).isCompletionStillRequired()) {
                return false;
            }

        }
        return true;

    }


    public static Collection<? extends PlanItemInstance<?>> getChildren(PlanItemInstanceContainer container) {
        Set<PlanItemInstance<?>> result = new HashSet<PlanItemInstance<?>>();
        for (NodeInstance nodeInstance : container.getNodeInstances()) {
            if (nodeInstance instanceof PlanItemInstance) {
                result.add((PlanItemInstance<?>) nodeInstance);
            }
        }
        return result;
    }

}
