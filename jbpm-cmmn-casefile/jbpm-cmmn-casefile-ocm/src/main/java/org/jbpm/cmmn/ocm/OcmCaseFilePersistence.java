package org.jbpm.cmmn.ocm;

import javax.jcr.ItemNotFoundException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.jackrabbit.ocm.manager.ObjectContentManager;
import org.apache.jackrabbit.ocm.mapper.model.ClassDescriptor;
import org.jbpm.cmmn.casefile.common.CaseFilePersistence;
import org.jbpm.cmmn.instance.subscription.CaseSubscriptionKey;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.cmmn.instance.subscription.impl.AbstractDurableSubscriptionManager;
import org.jbpm.cmmn.instance.subscription.impl.EventQueues;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.EmptyContext;

public class OcmCaseFilePersistence implements SubscriptionPersistenceContext<OcmCaseSubscriptionInfo, OcmCaseFileItemSubscriptionInfo>,
		CaseFilePersistence {
	RuntimeManager runtimeManager;
	private UserTransaction transaction;
	protected ObjectContentManagerFactory factory;
	protected boolean startedTransaction = false;

	public OcmCaseFilePersistence(ObjectContentManagerFactory factory, RuntimeManager runtimeManager) {
		this.runtimeManager = runtimeManager;
		this.factory = factory;
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
		try {

			startTransaction();
		} catch (Exception e) {
			throw convertException(e);
		}
		factory.updateEventListener();
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

	@Override
	public Object getDelegate() {
		return getObjectContentManager().getSession();
	}

	public ClassDescriptor getClassDescriptor(String jcrNodeType) {
		return factory.getMapper().getClassDescriptorByNodeType(jcrNodeType);
	}

	protected void startTransaction() throws SystemException, NamingException, NotSupportedException {
		if (!isTransactionActive()) {
			getTransaction().begin();
			this.startedTransaction = true;
		}
	}

	protected boolean isTransactionActive() throws SystemException, NamingException {
		return getTransaction().getStatus() == Status.STATUS_ACTIVE;
	}

	protected RuntimeException convertException(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	@Override
	public void persist(Object o) {
		getObjectContentManager().insert(o);
	}

	@Override
	public void update(Object o) {
		getObjectContentManager().update(o);
	}

	public ObjectContentManager getObjectContentManager() {
		return factory.getCurrentObjectContentManager();
	}

	protected UserTransaction getTransaction() throws NamingException {
		if (transaction == null) {
			transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
		}
		return transaction;
	}

	void setTransaction(UserTransaction transaction) {
		this.transaction = transaction;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T find(Class<T> class1, Object id) {
		return (T) getObjectContentManager().getObjectByUuid((String) id);
	}

	@Override
	public void remove(Object s) {
		getObjectContentManager().remove(s);
	}

	public Object find(String identifier) {
		return getObjectContentManager().getObjectByUuid(identifier);
	}

	public Node findNode(String identifier) {
		try {
			return getObjectContentManager().getSession().getNodeByIdentifier(identifier);
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close() {
		factory.close(getObjectContentManager());
	}
}
