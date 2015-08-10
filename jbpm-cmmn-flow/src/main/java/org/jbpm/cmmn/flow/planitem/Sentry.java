package org.jbpm.cmmn.flow.planitem;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.Node;
import org.kie.api.definition.process.Connection;

import java.util.List;

public interface Sentry extends Node, CMMNElement {

    Constraint getCondition();

    void addOnPart(OnPart onPart);

    void setCondition(Constraint condition);

    void validateAddIncomingConnection(String type, Connection connection);

    List<OnPart> getOnParts();

    void setElementId(String elementId);

    void setPlanItemExiting(ItemWithDefinition<?> planItem);

    ItemWithDefinition<?> getPlanItemExiting();

    ItemWithDefinition<?> getPlanItemEntering();

    void setPlanItemEntering(ItemWithDefinition<?> planItemEntering);

    PlanItemContainer getPlanItemContainer();

    boolean isExitsCase();

    void setExitsCase(boolean exitsCase);
}
