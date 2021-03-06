package org.jbpm.cmmn.instance.impl;

import org.jbpm.cmmn.flow.core.impl.DefaultJoin;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.workflow.core.impl.NodeImpl;
import org.jbpm.workflow.instance.node.EventNodeInstanceInterface;
import org.jbpm.workflow.instance.node.JoinInstance;
import org.kie.api.runtime.process.NodeInstance;

public class DefaultJoinInstance extends JoinInstance implements EventNodeInstanceInterface {
	private static final long serialVersionUID = -8715207082336857538L;
	private transient boolean isInitializing = false;

	public DefaultJoinInstance() {
	}

	@Override
	public void internalTrigger(NodeInstance from, String type) {
		super.internalTrigger(from, type);
		if (!isInitializing && getNodeInstanceContainer() instanceof PlanItemInstanceContainer) {
			PlanItemInstanceContainer piic = (PlanItemInstanceContainer) getNodeInstanceContainer();
			if (PlanItemInstanceContainerUtil.canComplete(piic) && piic.getPlanItemContainer().isAutoComplete()) {
				piic.complete();
			}
		}
	}

	public void triggerCompleted() {
		triggerCompleted(org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE, false);
	}

	public void setInitializing(boolean b) {
		this.isInitializing = b;
	}

	@Override
	public void signalEvent(String type, Object event) {
		if (getNodeInstanceContainer() instanceof PlanItemInstanceContainer) {
			PlanItemInstanceContainer piic = (PlanItemInstanceContainer) getNodeInstanceContainer();
			if (type.equals(DefaultJoin.CLOSE) && piic instanceof CaseInstance) {
				if (piic.getPlanElementState().isTerminalState()) {
					((CaseInstance) piic).close();
					triggerCompleted(NodeImpl.CONNECTION_DEFAULT_TYPE, true);
				}
			}
		}

	}

}
