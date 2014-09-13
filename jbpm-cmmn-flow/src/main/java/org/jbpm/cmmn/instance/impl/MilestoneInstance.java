package org.jbpm.cmmn.instance.impl;

import org.jbpm.cmmn.flow.core.impl.Milestone;
import org.jbpm.cmmn.flow.core.planitem.MilestonePlanItem;
import org.kie.api.runtime.process.NodeInstance;

public class MilestoneInstance extends OccurrablePlanItemInstanceImpl<Milestone, MilestonePlanItem> {
	private static final long serialVersionUID = 3069593690659509023L;

	public MilestoneInstance() {
	}

	@Override
	public void internalTrigger(NodeInstance from, String type) {
		occur();
		triggerCompleted(false);
	}

}
