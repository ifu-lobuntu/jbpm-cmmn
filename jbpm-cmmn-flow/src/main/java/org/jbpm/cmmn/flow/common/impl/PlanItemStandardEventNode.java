package org.jbpm.cmmn.flow.common.impl;

import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.PlanItemOnPart;
import org.kie.api.task.model.Task;

import java.io.Serializable;


public class PlanItemStandardEventNode extends AbstractStandardEventNode implements Serializable {
	private PlanItemTransition standardEvent;
	private PlanItem<?> planSourceItem;
	private String sourceRef;

	public PlanItemTransition getStandardEvent() {
		return standardEvent;
	}

	public void setStandardEvent(PlanItemTransition transition) {
		this.standardEvent = transition;
	}

	public PlanItem<?> getSourcePlanItem() {
		return planSourceItem;
	}

	public void setSourcePlanItem(PlanItem<?> planItem) {
		this.planSourceItem = planItem;
	}

	public void setSourceRef(String value) {
		this.sourceRef = value;
	}

	public String getSourceRef() {
		return sourceRef;
	}

	@Override
	public String getType() {
		return getType(this.planSourceItem.getName(), standardEvent);
	}

	@Override
	public String getEventClassName() {
		return Task.class.getName();
	}
}
