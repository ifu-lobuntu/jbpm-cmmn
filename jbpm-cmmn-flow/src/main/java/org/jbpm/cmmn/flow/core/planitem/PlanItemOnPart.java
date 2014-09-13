package org.jbpm.cmmn.flow.core.planitem;

import java.io.Serializable;

import org.jbpm.cmmn.flow.core.PlanItem;
import org.jbpm.cmmn.flow.core.PlanItemTransition;
import org.kie.api.task.model.Task;

public class PlanItemOnPart extends AbstractOnPart implements Serializable {
	private static final long serialVersionUID = -9167236068103073693L;
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
