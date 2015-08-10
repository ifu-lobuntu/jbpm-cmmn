package org.jbpm.cmmn.instance.impl;

import org.jbpm.cmmn.flow.definition.UserEventListener;
import org.jbpm.cmmn.instance.Creatable;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemEvent;
import org.jbpm.workflow.instance.node.EventNodeInstanceInterface;

public class UserEventInstance extends OccurrablePlanItemInstanceImpl<UserEventListener> implements EventNodeInstanceInterface, Creatable {

	private static final long serialVersionUID = 3069593690659509023L;

	public UserEventInstance() {
		super.internalSetCompletionRequired(false);
		planElementState = PlanElementState.INITIAL;
	}

	public void signalEvent(String type, Object event) {
		super.signalEvent(type, event);
		String name = getPlanItem().getPlanInfo().getDefinition().getName();
		if (type.equals(name) && !(event instanceof PlanItemEvent) && canOccur()) {
			setPlanElementState(PlanElementState.AVAILABLE);
			occur();
		}
	}

	public void triggerCompleted() {
		((org.jbpm.workflow.instance.NodeInstanceContainer) getNodeInstanceContainer()).setCurrentLevel(getLevel());
		triggerCompleted(org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE, false);
	}

	@Override
	public void ensureCreationIsTriggered() {
		if (super.getPlanElementState() == PlanElementState.INITIAL) {
			super.create();
		}
	}

}
