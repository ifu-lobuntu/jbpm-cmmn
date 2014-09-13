package org.jbpm.cmmn.casefile.jcr;

import javax.jcr.ItemNotFoundException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jbpm.cmmn.casefile.common.ObjectPersistence;


public class JcrObjectPersistence implements ObjectPersistence {
	private UserTransaction transaction;
	protected JcrSessionFactory factory;
	protected boolean startedTransaction = false;

	public JcrObjectPersistence(JcrSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Object getDelegate() {
		return getCurrentSession();
	}

	@Override
	public void start() {
		try {
			startTransaction();
		} catch (Exception e) {
			throw convertException(e);
		}
	}

	protected void startTransaction() throws SystemException, NamingException, NotSupportedException {
		if (!isTransactionActive()) {
			getTransaction().begin();
			this.startedTransaction = true;
		}
	}

	@Override
	public void commit() {
		try {
			startTransaction();
			getCurrentSession().save();
			if (startedTransaction) {
				getTransaction().commit();
			}
			startedTransaction = false;
		} catch (Exception e) {
			throw convertException(e);
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

}
