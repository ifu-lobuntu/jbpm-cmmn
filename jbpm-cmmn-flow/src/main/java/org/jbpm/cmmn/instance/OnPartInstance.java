package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.workflow.instance.NodeInstance;
import org.jbpm.workflow.instance.node.EventBasedNodeInstanceInterface;
import org.jbpm.workflow.instance.node.EventNodeInstanceInterface;

public interface OnPartInstance extends EventNodeInstanceInterface, EventBasedNodeInstanceInterface, NodeInstance {

	AbstractStandardEventNode getOnPart();

	CaseEvent getCaseEvent();

	CaseInstance getCaseInstance();

	Object popEvent();

}
