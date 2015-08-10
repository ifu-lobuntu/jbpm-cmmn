package org.jbpm.cmmn.instance.impl;

import org.jbpm.cmmn.flow.definition.Milestone;
import org.kie.api.runtime.process.NodeInstance;

public class MilestoneInstance extends OccurrablePlanItemInstanceImpl<Milestone> {
	private static final long serialVersionUID = 3069593690659509023L;

	public MilestoneInstance() {
	}

	@Override
	public void internalTrigger(NodeInstance from, String type) {
		occur();
		triggerCompleted(false);
	}

}
