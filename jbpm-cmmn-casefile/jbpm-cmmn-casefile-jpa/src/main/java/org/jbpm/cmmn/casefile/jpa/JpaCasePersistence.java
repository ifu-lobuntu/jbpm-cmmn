package org.jbpm.cmmn.casefile.jpa;

import javax.persistence.EntityManagerFactory;

import org.jbpm.cmmn.instance.subscription.CaseSubscriptionKey;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.cmmn.instance.subscription.impl.AbstractDurableSubscriptionManager;
import org.jbpm.cmmn.instance.subscription.impl.EventQueues;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.EmptyContext;

/**
 * 
 * Needed to coordinate the dispatching of Events with storing the updated subscriptions and flushing of the
 * EntityManager. The plan is to do the dispatching asynchronously eventually. There are still some serious issues to
 * resolve, specifically w.r.t. clearing some static variables and avoiding memory leaks
 * 
 */
public class JpaCasePersistence extends JpaObjectPersistence implements SubscriptionPersistenceContext<JpaCaseSubscriptionInfo, JpaCaseFileItemSubscriptionInfo> {
	private RuntimeManager runtimeManager;

	public JpaCasePersistence(EntityManagerFactory emf, RuntimeManager rm) {
		super(emf);
		this.runtimeManager = rm;
	}

	@Override
	public JpaCaseSubscriptionInfo findCaseSubscriptionInfo(CaseSubscriptionKey key) {
		return getEntityManager().find(JpaCaseSubscriptionInfo.class, key);
	}

	@Override
	public void updateCaseSupbscriptionInfo(JpaCaseSubscriptionInfo t) {
	}

	@Override
	public void persistCaseSubscriptionInfo(JpaCaseSubscriptionInfo t) {
		startOrJoinTransaction();
		getEntityManager().persist(t);
	}

	@Override
	public void removeCaseFileItemSubscriptionInfo(JpaCaseFileItemSubscriptionInfo x) {
		getEntityManager().remove(x);
	}
	@Override
	public void commit() {
		try {
			startOrJoinTransaction();
			getEntityManager().flush();
			doCaseFileItemEvents();
			if (startedTransaction) {
				getTransaction().commit();
				boolean workItemsProcessed = false;
				do {
					this.startedTransaction = false;
					startOrJoinTransaction();
					workItemsProcessed = EventQueues.dispatchWorkItemQueue(runtimeManager.getRuntimeEngine(EmptyContext.get()));
					if (workItemsProcessed) {
						doCaseFileItemEvents();
					}
					getTransaction().commit();
				} while (workItemsProcessed);
				this.startedTransaction = false;
			}
			close();
		} catch (Exception e) {
			throw convertException(e);
		}
	}

	private void doCaseFileItemEvents() {
		while (EventQueues.dispatchCaseFileItemEventQueue(runtimeManager.getRuntimeEngine(EmptyContext.get()))) {
			AbstractDurableSubscriptionManager.commitSubscriptionsTo(this);
			getEntityManager().flush();
		}
		if (AbstractDurableSubscriptionManager.commitSubscriptionsTo(this)) {
			getEntityManager().flush();
		}
	}


}