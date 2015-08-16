package org.jbpm.cmmn.flow.common;

import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.PlanItemControl;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.workflow.core.Node;

import java.util.Map;

/**
 * Common supertype for both PlanItems and DiscretionaryItems
* */
public interface ItemWithDefinition<T extends PlanItemDefinition> extends CMMNElement, Node {

	Map<String, Sentry> getExitCriteria();

	Map<String, Sentry> getEntryCriteria();

	T getDefinition();

	PlanItemControl getItemControl();

	PlanItemControl getEffectiveItemControl();

	String getEffectiveName();

	PlanItemContainer getPlanItemContainer();

	String getPlanItemEventName();

	PlanItemInstanceFactoryNode getFactoryNode();
}
