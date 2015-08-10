package org.jbpm.cmmn.flow.common;

import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.process.core.context.variable.Variable;
import org.jbpm.workflow.core.Node;
import org.jbpm.workflow.core.node.EventNodeInterface;

/**
 * Common supertype for all OnParts and StartTriggers that are event nodes listening for StandardEvents
 */
public interface StandardEventNode extends CMMNElement, EventNodeInterface, Node {

    Enum<?> getStandardEvent();

    String getEventClassName();

    Variable getVariable();

    String getVariableName();
}
