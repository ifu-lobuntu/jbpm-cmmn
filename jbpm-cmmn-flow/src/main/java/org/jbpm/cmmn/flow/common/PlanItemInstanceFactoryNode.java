package org.jbpm.cmmn.flow.common;


import org.jbpm.cmmn.flow.definition.RepeatablePlanItemDefinition;
import org.jbpm.workflow.core.Node;

/**
 * An artifical node that is required to allow repeatable PlanItemDefinitions to be instantiated multiple times
 */
public interface PlanItemInstanceFactoryNode extends Node {
    void setItemToInstantiate(ItemWithDefinition<? extends RepeatablePlanItemDefinition> planItem);
}
