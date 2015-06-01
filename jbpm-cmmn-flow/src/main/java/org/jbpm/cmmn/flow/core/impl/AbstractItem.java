package org.jbpm.cmmn.flow.core.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.jbpm.cmmn.flow.core.PlanItemDefinition;
import org.jbpm.workflow.core.impl.NodeImpl;
import org.jbpm.workflow.core.node.StateNode;

public class AbstractItem extends StateNode {

	private static final long serialVersionUID = -377075234369815381L;
	private String elementId;

	public AbstractItem() {
		super();
	}

	public String getElementId() {
		return elementId;
	}


	public void setElementId(String elementId) {
		getMetaData().put("UniqueId", elementId);
		this.elementId = elementId;
	}




}