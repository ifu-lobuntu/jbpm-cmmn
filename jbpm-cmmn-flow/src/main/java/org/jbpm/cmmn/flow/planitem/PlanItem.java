package org.jbpm.cmmn.flow.planitem;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.workflow.core.Node;
import org.jbpm.workflow.core.NodeContainer;

import java.util.Map;

public interface PlanItem<T extends PlanItemDefinition> extends NodeContainer,Node, ItemWithDefinition<T> {
	VariableScope getVariableScope();

	Map<String, Sentry> getExitCriteria();

	Map<String, Sentry> getEntryCriteria();

	void setPlanItemContainer(PlanItemContainer pic);

	void setElementId(String elementId);

	String getDescription();

	void copyFromDefinition();

}
