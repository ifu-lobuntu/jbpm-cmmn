package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.core.planitem.AbstractOnPart;
import org.jbpm.workflow.instance.NodeInstance;
import org.jbpm.workflow.instance.node.EventBasedNodeInstanceInterface;
import org.jbpm.workflow.instance.node.EventNodeInstanceInterface;

public interface OnPartInstance extends EventNodeInstanceInterface, EventBasedNodeInstanceInterface, NodeInstance {

	public abstract AbstractOnPart getOnPart();

	public CaseEvent getCaseEvent();

	public CaseInstance getCaseInstance();

	Object popEvent();

}
