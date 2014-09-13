package org.jbpm.cmmn.casefile.jcr;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;

import org.jbpm.cmmn.instance.subscription.CaseSubscriptionKey;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.cmmn.instance.subscription.impl.AbstractDurableSubscriptionManager;
import org.jbpm.cmmn.instance.subscription.impl.EventQueues;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.EmptyContext;

public class JcrCasePersistence extends JcrObjectPersistence implements
		SubscriptionPersistenceContext<JcrCaseSubscriptionInfo, JcrCaseFileItemSubscriptionInfo> {
	RuntimeManager runtimeManager;

	public JcrCasePersistence(JcrSessionFactory factory, RuntimeManager runtimeManager) {
		super(factory);
		this.runtimeManager = runtimeManager;
	}

	@Override
	public JcrCaseSubscriptionInfo findCaseSubscriptionInfo(CaseSubscriptionKey id) {
		JcrCaseSubscriptionKey key = (JcrCaseSubscriptionKey) id;
		return getSubscription(key.getClassName(), key.getId());
	}

	@Override
	public void updateCaseSupbscriptionInfo(JcrCaseSubscriptionInfo t) {
		t.flush();
	}

	@Override
	public void persistCaseSubscriptionInfo(JcrCaseSubscriptionInfo si) {
		Node subs;
		try {
			subs = getCurrentSession().getNode("/subscriptions").addNode(si.getId().toString());
		} catch (Exception e) {
			throw convertException(e);
		}
		si.setSubscriptionNode(subs);
	}

	@Override
	public void removeCaseFileItemSubscriptionInfo(JcrCaseFileItemSubscriptionInfo s) {
		try {
			JcrCaseFileItemSubscriptionInfo si = (JcrCaseFileItemSubscriptionInfo) s;
			si.getNode().remove();
		} catch (Exception e) {
			throw convertException(e);
		}
	}

	public JcrCaseSubscriptionKey getSubscription(Node node) {
		try {
			return new JcrCaseSubscriptionKey("/subscriptions/" + node.getPrimaryNodeType().getName() + "$" + node.getIdentifier());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void start() {
		super.start();
		super.factory.updateEventListener();
	}

	@Override
	public void commit() {
		try {
			startTransaction();
			getCurrentSession().save();
			doCaseFileItemEvents();
			if (startedTransaction) {
				getTransaction().commit();
				boolean workItemsProcessed = false;
				do {
					getTransaction().begin();
					workItemsProcessed = EventQueues.dispatchWorkItemQueue(runtimeManager.getRuntimeEngine(EmptyContext
					.get()));
					if (workItemsProcessed) {
						doCaseFileItemEvents();
					}
					getTransaction().commit();
				} while (workItemsProcessed);
			}
			startedTransaction = false;
		} catch (Exception e) {
			throw convertException(e);
		}
	}

	private void doCaseFileItemEvents() {
		while (EventQueues.dispatchCaseFileItemEventQueue(runtimeManager.getRuntimeEngine(EmptyContext.get()))) {
			AbstractDurableSubscriptionManager.commitSubscriptionsTo(this);
			try {
				getCurrentSession().save();
			} catch (Exception e) {
				throw convertException(e);
			}
		}
		if (AbstractDurableSubscriptionManager.commitSubscriptionsTo(this)) {
			try {
				getCurrentSession().save();
			} catch (Exception e) {
				throw convertException(e);
			}
		}
	}

	protected JcrCaseSubscriptionInfo getSubscription(String className, String id) {
		try {
			Node node = getCurrentSession().getRootNode().getNode("subscriptions/" + className + "$" + id);
			return new JcrCaseSubscriptionInfo(node);
		} catch (PathNotFoundException e) {
			return null;
		} catch (Exception e) {
			throw convertException(e);
		}
	}

}
