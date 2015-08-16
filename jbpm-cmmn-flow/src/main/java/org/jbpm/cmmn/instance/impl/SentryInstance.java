package org.jbpm.cmmn.instance.impl;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.common.impl.PlanItemInstanceFactoryNodeImpl;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.planitem.impl.SentryImpl;
import org.jbpm.cmmn.instance.CaseEvent;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.ControllableItemInstance;
import org.jbpm.cmmn.instance.OnPartInstance;
import org.jbpm.process.instance.impl.ConstraintEvaluator;
import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.Node;
import org.jbpm.workflow.core.impl.NodeImpl;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.jbpm.workflow.instance.node.JoinInstance;
import org.kie.api.definition.process.Connection;
import org.kie.api.runtime.process.NodeInstance;

import java.util.*;

public class SentryInstance extends JoinInstance {
	private static ThreadLocal<Deque<Collection<CaseEvent>>> currentEvents = new ThreadLocal<Deque<Collection<CaseEvent>>>();

	public static Collection<CaseEvent> getCurrentEvents() {
		return getEventQueue().peek();
	}

	private static final long serialVersionUID = -4302504131617050844L;

	public SentryImpl getSentry() {
		return (SentryImpl) getNode();
	}

	@Override
	public void internalTrigger(NodeInstance from, String type) {
		if (from instanceof DefaultSplitInstance) {
			// TODO not pretty - dependency on a preceding node's type
			List<Connection> outgoingConnections = getNode().getOutgoingConnections(NodeImpl.CONNECTION_DEFAULT_TYPE);
			if (outgoingConnections.isEmpty()) {
				// an exit criterion
			} else {
				Connection next = outgoingConnections.get(0);
				PlanItemInstanceFactoryNodeImpl to = (PlanItemInstanceFactoryNodeImpl) next.getTo();
				NodeInstance ni = ((NodeInstanceContainer) getNodeInstanceContainer()).getNodeInstance(to);
				((PlanItemInstanceFactoryNodeInstance<?>) ni).ensureCreationIsTriggered();
			}
		}
		super.internalTrigger(from, type);
	}

	protected Collection<CaseEvent> getEvents() {
		Collection<CaseEvent> result = new HashSet<CaseEvent>();
		Collection<Connection> values = getNode().getIncomingConnections(Node.CONNECTION_DEFAULT_TYPE);
		for (Connection connection : values) {
			if (connection.getFrom() instanceof AbstractStandardEventNode) {
				NodeInstance ni = findNodeInstance((NodeInstanceContainer) getNodeInstanceContainer(), (AbstractStandardEventNode) connection.getFrom());
				OnPartInstance opi = (OnPartInstance) ni;
				result.add(opi.getCaseEvent());
			}
		}
		return result;
	}

	@Override
	public void triggerCompleted() {
		if (isConditionTrue()) {
			if (getSentry().isExitsCase()) {
				getCaseInstance().terminate();
			} else {
				NodeInstanceContainer nic = (org.jbpm.workflow.instance.NodeInstanceContainer) getNodeInstanceContainer();
				nic.setCurrentLevel(getLevel());
				maybeTriggerExit(nic);
				// Default behavior is to keep this SentryInstance active so that it can
				// continue to listen to transitions/standardEvents
				Deque<Collection<CaseEvent>> deque = getEventQueue();
				deque.push(getEvents());
				try {
					triggerCompleted(org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE, false);
				} catch (RuntimeException e) {
					e.printStackTrace();
					throw e;
				} finally {
					deque.pop();
				}
				Collection<Connection> values = getNode().getIncomingConnections(Node.CONNECTION_DEFAULT_TYPE);
				for (Connection connection : values) {
					if (connection.getFrom() instanceof AbstractStandardEventNode) {
						NodeInstance ni = findNodeInstance((NodeInstanceContainer) getNodeInstanceContainer(), (AbstractStandardEventNode) connection.getFrom());
						OnPartInstance opi = (OnPartInstance) ni;
						if (opi != null) {
							// coud be after process completion
							opi.popEvent();
						}
					}
				}
				for (Connection connection : values) {
					if (!(connection.getFrom() instanceof AbstractStandardEventNode)) {
						// Once activated, we keep the originating "from" active to indicate an "Available" state
						super.getTriggers().put(connection.getFrom().getId(), 1);
					}
				}
			}
		}
	}

	private CaseInstance getCaseInstance() {
		return (CaseInstance) getProcessInstance();
	}

	private boolean isConditionTrue() {
		SentryImpl sentry = (SentryImpl) getNode();
		boolean condition = true;
		Constraint c = sentry.getCondition();
		if (c instanceof ConstraintEvaluator) {
			Connection conn = getNode().getIncomingConnections(Node.CONNECTION_DEFAULT_TYPE).get(0);
			condition = ((ConstraintEvaluator) c).evaluate(this, conn, c);
		}
		return condition;
	}

	protected static Deque<Collection<CaseEvent>> getEventQueue() {
		Deque<Collection<CaseEvent>> deque = currentEvents.get();
		if (deque == null) {
			currentEvents.set(deque = new ArrayDeque<Collection<CaseEvent>>());
		}
		return deque;
	}

	private boolean maybeTriggerExit(NodeInstanceContainer nic) {
		boolean hasTriggered = false;
		SentryImpl sentry = (SentryImpl) getNode();
		if (sentry.getPlanItemExiting() != null) {
			NodeInstance found = findNodeInstance(nic, sentry.getPlanItemExiting());
			// TODO refine which PlannItemInstance to exit, e.g. look at the
			// output and see if the caseFileITem Instance associated matches
			if (found instanceof ControllableItemInstance) {
					// Task planItem
				ControllableItemInstance<?> pii = (ControllableItemInstance<?>) found;
				pii.exit();
				hasTriggered = true;
			} else {

				// TODO: SubProcessInstance? Exception?
			}
		}
		return hasTriggered;
	}

	protected NodeInstance findNodeInstance(NodeInstanceContainer nic, Node planItem) {
		NodeInstance found = null;
		for (NodeInstance nodeInstance : nic.getNodeInstances()) {
			if (nodeInstance.getNodeId() == planItem.getId()) {
				found = nodeInstance;
			}
		}
		return found;
	}

}
