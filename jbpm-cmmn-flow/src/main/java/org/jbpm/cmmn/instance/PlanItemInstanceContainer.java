package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.workflow.instance.NodeInstanceContainer;

import java.util.Collection;

public interface PlanItemInstanceContainer extends PlanningTableContainerInstance, NodeInstanceContainer {

	Collection<? extends PlanItemInstance<?>> getChildren();

    void complete();

	PlanItemContainer getPlanItemContainer();

	void resumeAfterPlanning();
}