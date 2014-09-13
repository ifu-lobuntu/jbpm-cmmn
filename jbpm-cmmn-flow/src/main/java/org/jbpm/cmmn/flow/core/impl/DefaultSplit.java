package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.workflow.core.node.Split;

public class DefaultSplit extends Split {

	private static final long serialVersionUID = 4769541086401100L;

	public DefaultSplit() {
		super(Split.TYPE_AND);
	}
}
