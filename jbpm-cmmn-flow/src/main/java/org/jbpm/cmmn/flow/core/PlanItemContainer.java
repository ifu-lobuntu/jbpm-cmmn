package org.jbpm.cmmn.flow.core;

import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.PlanningTableContainer;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.workflow.core.NodeContainer;
import org.jbpm.workflow.core.node.EndNode;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.core.node.Split;
import org.jbpm.workflow.core.node.StartNode;
import org.kie.api.definition.process.Node;

import java.util.Collection;

public interface PlanItemContainer extends NodeContainer, PlanningTableContainer {

    VariableScope getVariableScope();

    Collection<PlanItem<?>> getPlanItems();

    void setDefaultStart(StartNode n);

    StartNode getDefaultStart();

    void setDefaultSplit(Split n);

    Split getDefaultSplit();

    void setDefaultEnd(EndNode n);

    EndNode getDefaultEnd();

    void setDefaultJoin(Join n);

    Join getDefaultJoin();

    Case getCase();

    boolean isAutoComplete();

    void setPlanningTable(PlanningTable planningTable);

    Node superGetNode(long id);
}
