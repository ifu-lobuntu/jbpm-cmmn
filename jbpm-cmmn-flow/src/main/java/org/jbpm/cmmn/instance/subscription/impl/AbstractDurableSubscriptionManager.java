package org.jbpm.cmmn.instance.subscription.impl;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseFileItemTransition;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.instance.CaseFileItemEvent;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.subscription.CaseFileItemSubscriptionInfo;
import org.jbpm.cmmn.instance.subscription.CaseSubscriptionKey;
import org.jbpm.cmmn.instance.subscription.DurableCaseFileItemSubscriptionInfo;
import org.jbpm.cmmn.instance.subscription.DurableCaseSubscriptionInfo;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.cmmn.instance.subscription.SubscriptionPersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDurableSubscriptionManager<T extends DurableCaseSubscriptionInfo<X>, X extends DurableCaseFileItemSubscriptionInfo>
		implements SubscriptionManager<T, X> {
	static Logger logger = LoggerFactory.getLogger(AbstractDurableSubscriptionManager.class);
	private boolean cascadeSubscription = false;
	private static Map<Object, Map<CaseSubscriptionKey, DurableCaseSubscriptionInfo<?>>> cachedSubscriptions = new HashMap<Object, Map<CaseSubscriptionKey, DurableCaseSubscriptionInfo<?>>>();

	public AbstractDurableSubscriptionManager() {
		super();
	}

	public AbstractDurableSubscriptionManager(boolean cascade) {
		super();
		this.cascadeSubscription = cascade;
	}

	@Override
	public void updateSubscriptions(CaseInstance caseInstance, Collection<Object> targets,
			Map<CaseFileItem, Collection<Object>> parentSubscriptions, SubscriptionPersistenceContext<T, X> p) {
		cacheSubscriptions(caseInstance, p);
		Set<OnPartInstanceSubscription> findOnPartInstanceSubscriptions = caseInstance.findOnPartInstanceSubscriptions();
		subscribeToUnknownNumberOfObjects(caseInstance, findOnPartInstanceSubscriptions, targets, p);
		subscribeToCreateAndDeleteOfChildren(caseInstance, parentSubscriptions, p);
	}

	private void cacheSubscriptions(CaseInstance caseInstance, SubscriptionPersistenceContext<T, X> p) {
		Map<CaseSubscriptionKey, DurableCaseSubscriptionInfo<?>> map = getCachedSubscriptions(p);
		for (T t : getAllSubscriptionsAgainst(caseInstance, p)) {
			invalidateCaseFileItemSubscriptions(caseInstance, t);
			map.put(t.getId(), t);
		}
	}

	public static Map<CaseSubscriptionKey, DurableCaseSubscriptionInfo<?>> getCachedSubscriptions(Object p) {
		Map<CaseSubscriptionKey, DurableCaseSubscriptionInfo<?>> map = cachedSubscriptions.get(p);
		if (map == null) {
			cachedSubscriptions.put(p, map = new HashMap<CaseSubscriptionKey, DurableCaseSubscriptionInfo<?>>());
		}
		return map;
	}

	private void invalidateCaseFileItemSubscriptions(CaseInstance caseInstance, T t) {
		for (X x : t.getCaseFileItemSubscriptions()) {
			if (x.getProcessInstanceId() == caseInstance.getId()) {
				x.invalidate();
			}
		}
	}

	private void subscribeToUnknownNumberOfObjects(CaseInstance process, Collection<OnPartInstanceSubscription> subs, Object target,
			SubscriptionPersistenceContext<T, X> em) {
		if (target instanceof Collection) {
			Collection<?> targets = (Collection<?>) target;
			for (Object currentTarget : targets) {
				subscribeToUnknownNumberOfObjects(process, subs, currentTarget, em);
			}
		} else if (target instanceof Iterator) {
			Iterator<?> targets = (Iterator<?>) target;
			while (targets.hasNext()) {
				subscribeToUnknownNumberOfObjects(process, subs, targets.next(), em);
			}
		} else if (target != null) {
			subscribeToSingleObject(process, subs, target, em);
		}
	}

	protected static void queueEvent(CaseFileItemSubscriptionInfo is, Object parentObject, Object value) {
		CaseFileItemEvent event = new CaseFileItemEvent(is.getItemName(), is.getTransition(), parentObject, value);
		if (is instanceof OnPartInstanceSubscription) {
			OnPartInstanceSubscription opis = (OnPartInstanceSubscription) is;
			CaseInstance ci = (CaseInstance) opis.getKnowledgeRuntime().getProcessInstance(opis.getProcessInstanceId());
			if (opis.meetsBindingRefinementCriteria(value, ci)) {
				EventQueues.queueEvent(ci.getCase().getCaseKey(),ci.getId(),event);
			}
		} else if (is instanceof DurableCaseFileItemSubscriptionInfo) {
			DurableCaseFileItemSubscriptionInfo pcfis = (DurableCaseFileItemSubscriptionInfo) is;
			EventQueues.queueEvent(pcfis.getCaseKey(),pcfis.getProcessInstanceId(),event);
		}
	}

	private void subscribeToSingleObject(CaseInstance caseInstance, Collection<OnPartInstanceSubscription> subs, Object target,
			SubscriptionPersistenceContext<T, X> em) {
		T info = findOrCreateCaseSubscriptionInfo(caseInstance, target, em);
		for (OnPartInstanceSubscription sub : subs) {
			if (sub.isListeningTo(target, sub.getTransition()) && !sub.getTransition().requiresParentSubscription()) {
				storeVariable(caseInstance, sub.getVariable(), target);
				buildCaseFileItemSubscriptionInfo(caseInstance, info, sub);
			}
			if (cascadeSubscription) {
				/*
				 * CREATE and DELETE events are only relevant if the object
				 * created is added as a child to a parent object that is
				 * already involved in the case. We therefore need to listen for
				 * that event too
				 */
				for (CaseFileItem childCaseFileItem : sub.getVariable().getChildren()) {
					registerChildCreateAndDeleteSubscriptions(caseInstance, subs, info, childCaseFileItem);
				}
				if (sub.isListeningTo(target, sub.getTransition())) {
					cascadeSubscribe(caseInstance, target, sub.getVariable().getChildren(), em, subs);
					cascadeSubscribe(caseInstance, target, sub.getVariable().getTargets().values(), em, subs);
				}
			}
		}
	}

	private void registerChildCreateAndDeleteSubscriptions(CaseInstance caseInstance, Collection<OnPartInstanceSubscription> subs,
			T parentInfo, CaseFileItem childCaseFileItem) {
		for (OnPartInstanceSubscription childSubscription : subs) {
			if (childSubscription.getVariable().getElementId().equals(childCaseFileItem.getElementId())
					&& childSubscription.getTransition().requiresParentSubscription()) {
				buildCaseFileItemSubscriptionInfo(caseInstance, parentInfo, childSubscription);
			}
		}
	}

	private void subscribeToCreateAndDeleteOfChildren(CaseInstance caseInstance, Map<CaseFileItem, Collection<Object>> parents,
			SubscriptionPersistenceContext<T, X> p) {
		Set<OnPartInstanceSubscription> subs = caseInstance.findOnPartInstanceSubscriptions();
		for (Entry<CaseFileItem, Collection<Object>> entry : parents.entrySet()) {
			CaseFileItem caseFileItem = entry.getKey();
			for (Object currentParent : entry.getValue()) {
				T parentSubscription = findOrCreateCaseSubscriptionInfo(caseInstance, currentParent, p);
				registerChildCreateAndDeleteSubscriptions(caseInstance, subs, parentSubscription, caseFileItem);
			}
		}
	}

	public T getCaseSubscriptionInfoFor(Object currentInstance, SubscriptionPersistenceContext<T, X> em) {
		CaseSubscriptionKey key = createCaseSubscriptionKey(currentInstance);
		return em.findCaseSubscriptionInfo(key);
	}

	protected abstract Collection<T> getAllSubscriptionsAgainst(CaseInstance caseInstance, SubscriptionPersistenceContext<T, X> em);

	@SuppressWarnings("unchecked")
	private T findOrCreateCaseSubscriptionInfo(CaseInstance caseInstance, Object currentInstance, SubscriptionPersistenceContext<T, X> em) {
		CaseSubscriptionKey key = createCaseSubscriptionKey(currentInstance);
		T info = (T) getCachedSubscriptions(em.getDelegate()).get(key);
		if (info == null) {
			info = em.findCaseSubscriptionInfo(key);
			if (info == null) {
				info = createCaseSubscriptionInfo(currentInstance);
				em.persistCaseSubscriptionInfo(info);
			} else {
				// found, deactivate subscriptions for this caseInstance to be
				// activated only if matched subscription
				// found
				invalidateCaseFileItemSubscriptions(caseInstance, info);
			}
			cachedSubscriptions.get(em.getDelegate()).put(key, info);
		}
		return info;
	}

	private X buildCaseFileItemSubscriptionInfo(CaseInstance process, T info, OnPartInstanceSubscription sub) {
		// first try to find it and the actiate it
		for (X x : info.getCaseFileItemSubscriptions()) {
			if (x.isEquivalent(sub)) {
				x.validate();
				return x;
			}
		}
		// not foud, create new
		X result = createCaseFileItemSubscriptionInfo();
		result.setCaseSubscription(info);
		result.setItemName(sub.getItemName());
		result.setTransition(sub.getTransition());
		result.setProcessInstanceId(process.getId());
		result.setCaseKey(((CaseImpl) process.getProcess()).getCaseKey());
		result.setRelatedItemName(sub.getRelatedItemName());
		info.addCaseFileItemSubscription(result);
		return result;
	}

	protected abstract X createCaseFileItemSubscriptionInfo();

	protected abstract T createCaseSubscriptionInfo(Object currentInstance);

	protected abstract CaseSubscriptionKey createCaseSubscriptionKey(Object currentInstance);

	@SuppressWarnings("unchecked")
	private void storeVariable(CaseInstance process, CaseFileItem caseFileItem, Object target) {
		if (caseFileItem.isCollection()) {
			Collection<Object> variable = (Collection<Object>) process.getVariable(caseFileItem.getName());
			if (variable == null) {
				variable = new HashSet<Object>();
				process.setVariable(caseFileItem.getName(), variable);
			}
			variable.add(target);
		} else {
			process.setVariable(caseFileItem.getName(), target);
		}
	}

	private void cascadeSubscribe(CaseInstance process, Object target, Collection<CaseFileItem> related,
			SubscriptionPersistenceContext<T, X> em, Collection<OnPartInstanceSubscription> subs) {
		for (CaseFileItem caseFileItem : related) {
			String propName = caseFileItem.getName();
			Object children = getChildren(target, propName);
			subscribeToUnknownNumberOfObjects(process, subs, children, em);
		}
	}

	protected Object getChildren(Object target, String propName) {
		try {
			Method getter = target.getClass().getMethod("get" + Character.toUpperCase(propName.charAt(0)) + propName.substring(1));
			Object children = getter.invoke(target);
			return children;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected boolean isMatchingAddChild(CaseFileItemSubscriptionInfo is, String propertyName) {
		return is.getRelatedItemName() != null && propertyName.equals(is.getRelatedItemName())
				&& (is.getTransition() == CaseFileItemTransition.ADD_CHILD);
	}

	protected boolean isMatchingCreate(CaseFileItemSubscriptionInfo is, String propertyName) {
		return propertyName.equals(is.getItemName()) && (is.getTransition() == CaseFileItemTransition.CREATE);
	}

	protected boolean isMatchingRemoveChild(CaseFileItemSubscriptionInfo is, String propertyName) {
		return is.getRelatedItemName() != null && propertyName.equals(is.getRelatedItemName())
				&& (is.getTransition() == CaseFileItemTransition.REMOVE_CHILD);
	}

	protected boolean isMatchingDelete(CaseFileItemSubscriptionInfo is, String propertyName) {
		return propertyName.equals(is.getItemName()) && (is.getTransition() == CaseFileItemTransition.DELETE);
	}

	protected boolean isMatchingAddOrRemove(CaseFileItemSubscriptionInfo is, String propertyName) {
		return is.getRelatedItemName() != null
				&& propertyName.equals(is.getRelatedItemName())
				&& (is.getTransition() == CaseFileItemTransition.ADD_CHILD || is.getTransition() == CaseFileItemTransition.REMOVE_CHILD
						|| is.getTransition() == CaseFileItemTransition.ADD_REFERENCE || is.getTransition() == CaseFileItemTransition.REMOVE_REFERENCE);
	}

	protected boolean isMatchingCreateOrDelete(CaseFileItemSubscriptionInfo is, String propertyName) {
		/*
		 * In the case of CREATE and DELETE the itemName is actually the name of
		 * the property on the parent to the child
		 */
		return propertyName.equals(is.getItemName())
				&& (is.getTransition() == CaseFileItemTransition.CREATE || is.getTransition() == CaseFileItemTransition.DELETE);
	}

	public static <T extends DurableCaseSubscriptionInfo<X>, X extends DurableCaseFileItemSubscriptionInfo> boolean commitSubscriptionsTo(
			SubscriptionPersistenceContext<T, X> op) {
		Object p = op.getDelegate();
		Map<CaseSubscriptionKey, DurableCaseSubscriptionInfo<?>> map1 = AbstractDurableSubscriptionManager.getCachedSubscriptions(p);
		AbstractDurableSubscriptionManager.cachedSubscriptions.remove(p);
		Map<CaseSubscriptionKey, DurableCaseSubscriptionInfo<?>> map = map1;
		@SuppressWarnings("unchecked")
		Collection<T> values = (Collection<T>) map.values();
		if (values.size() > 0) {
			for (T t : values) {
				for (DurableCaseFileItemSubscriptionInfo x : new HashSet<DurableCaseFileItemSubscriptionInfo>(t.getCaseFileItemSubscriptions())) {
					if (!x.isValid()) {
						x.getCaseSubscription().getCaseFileItemSubscriptions().remove(x);
					}
				}
				op.updateCaseSupbscriptionInfo(t);
			}
			map.clear();
			return true;
		}
		return false;
	}

}
