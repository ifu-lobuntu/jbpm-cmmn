package org.jbpm.cmmn.ocm;

import javax.jcr.Node;

import org.apache.jackrabbit.ocm.mapper.model.ClassDescriptor;
import org.jbpm.cmmn.instance.subscription.CaseSubscriptionKey;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.cmmn.instance.subscription.impl.AbstractDurableSubscriptionManager;
import org.jbpm.cmmn.instance.subscription.impl.EventQueues;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.EmptyContext;

public class OcmCasePersistence extends OcmObjectPersistence implements SubscriptionPersistenceContext<OcmCaseSubscriptionInfo, OcmCaseFileItemSubscriptionInfo>{
	RuntimeManager runtimeManager;

	public OcmCasePersistence(ObjectContentManagerFactory factory, RuntimeManager runtimeManager) {
		super(factory);
		this.runtimeManager = runtimeManager;
	}

	@Override
	public OcmCaseSubscriptionInfo findCaseSubscriptionInfo(CaseSubscriptionKey id) {
		OcmCaseSubscriptionKey key = (OcmCaseSubscriptionKey) id;
		return getSubscription(key.getClassName(), key.getId());
	}

	@Override
	public void updateCaseSupbscriptionInfo(OcmCaseSubscriptionInfo t) {
		getObjectContentManager().update(t);
	}

	@Override
	public void persistCaseSubscriptionInfo(OcmCaseSubscriptionInfo t) {
		getObjectContentManager().insert(t);
	}

	@Override
	public void removeCaseFileItemSubscriptionInfo(OcmCaseFileItemSubscriptionInfo x) {
		getObjectContentManager().remove(x);
	}


	public OcmCaseSubscriptionKey getSubscription(Node node) {
		try {
			ClassDescriptor classDescriptor = getClassDescriptor(node.getPrimaryNodeType().getName());
			return new OcmCaseSubscriptionKey("/subscriptions/" + classDescriptor.getClassName() + "$" + node.getIdentifier());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
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
			getObjectContentManager().save();
			doCaseFileItemEvents();
			if (startedTransaction) {
				getTransaction().commit();
				boolean workItemsProcessed = false;
				do {
					getTransaction().begin();
					workItemsProcessed = EventQueues.dispatchWorkItemQueue(runtimeManager.getRuntimeEngine(EmptyContext.get()));
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
			getObjectContentManager().save();
		}
		if (AbstractDurableSubscriptionManager.commitSubscriptionsTo(this)) {
			getObjectContentManager().save();
		}
	}

	protected OcmCaseSubscriptionInfo getSubscription(String className, String id) {
		return (OcmCaseSubscriptionInfo) getObjectContentManager().getObject("/subscriptions/" + className + "$" + id);
	}
}
