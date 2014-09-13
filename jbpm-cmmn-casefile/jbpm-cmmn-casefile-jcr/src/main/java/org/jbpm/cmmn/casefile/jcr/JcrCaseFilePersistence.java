package org.jbpm.cmmn.casefile.jcr;

import javax.jcr.ItemNotFoundException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jbpm.cmmn.casefile.common.CaseFilePersistence;
import org.jbpm.cmmn.instance.subscription.CaseSubscriptionKey;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.jbpm.cmmn.instance.subscription.impl.AbstractDurableSubscriptionManager;
import org.jbpm.cmmn.instance.subscription.impl.EventQueues;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.internal.runtime.manager.context.EmptyContext;

public class JcrCaseFilePersistence implements SubscriptionPersistenceContext<JcrCaseSubscriptionInfo, JcrCaseFileItemSubscriptionInfo> , CaseFilePersistence {
	RuntimeManager runtimeManager;
	private UserTransaction transaction;
	protected JcrSessionFactory factory;
	protected boolean startedTransaction = false;


	@Override
	public Object getDelegate() {
		return getCurrentSession();
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
		try {
			getCurrentSession().getRootNode().addNode(((Node) o).getPath());
		} catch (Exception e) {
			throw convertException(e);
		}
	}

	@Override
	public void update(Object o) {
	}

	public Session getCurrentSession() {
		return factory.getCurrentSession();
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
		try {
			return (T) getCurrentSession().getNodeByIdentifier((String) id);
		} catch (Exception e) {
			throw convertException(e);
		}
	}

	@Override
	public void remove(Object s) {
		try {
			getCurrentSession().removeItem(((Node) s).getPath());
		} catch (Exception e) {
			throw convertException(e);
		}
	}

	public Object find(String identifier) {
		try {
			return getCurrentSession().getNodeByIdentifier(identifier);
		} catch (Exception e) {
			throw convertException(e);
		}
	}

	public Node findNode(String identifier) {
		try {
			return getCurrentSession().getNodeByIdentifier(identifier);
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close() {
		factory.close(getCurrentSession());
	}

	public JcrCaseFilePersistence(JcrSessionFactory factory, RuntimeManager runtimeManager) {
		this.runtimeManager = runtimeManager;
		this.factory=factory;
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
			getCurrentSession().save();
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
