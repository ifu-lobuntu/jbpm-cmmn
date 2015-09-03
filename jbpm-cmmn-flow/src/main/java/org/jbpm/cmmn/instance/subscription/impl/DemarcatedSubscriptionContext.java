package org.jbpm.cmmn.instance.subscription.impl;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.instance.impl.CaseInstanceImpl;
import org.jbpm.cmmn.instance.impl.util.SubscriptionUtil;
import org.jbpm.cmmn.instance.subscription.ScopedCaseFileItemSubscription;

import java.util.*;
import java.util.Map.Entry;

public class DemarcatedSubscriptionContext {
	private static ThreadLocal<Map<Long, Set<ScopedCaseFileItemSubscription>>> demarcatedSubscriptions = new ThreadLocal<Map<Long, Set<ScopedCaseFileItemSubscription>>>();

	public static void activateSubscriptionsFrom(CaseInstanceImpl theCase) {
		Map<Long, Set<ScopedCaseFileItemSubscription>> map = demarcatedSubscriptions.get();
		if (map == null) {
			demarcatedSubscriptions.set(map = new HashMap<Long, Set<ScopedCaseFileItemSubscription>>());
		}
		CaseInstanceImpl caseInstance = theCase;

		map.put(theCase.getId(), SubscriptionUtil.findScopedCaseFileItemSubscriptions(caseInstance));
	}

	public static Set<ScopedCaseFileItemSubscription> getSubscriptionsInScopeForFor(Object source, CaseFileItemTransition... transitions) {
		if (demarcatedSubscriptions.get() != null) {
			Set<ScopedCaseFileItemSubscription> result = new HashSet<ScopedCaseFileItemSubscription>();
			for (Entry<Long, Set<ScopedCaseFileItemSubscription>> entry : demarcatedSubscriptions.get().entrySet()) {
				for (CaseFileItemTransition t : transitions) {
					for (ScopedCaseFileItemSubscription opis : entry.getValue()) {
						if (opis.isListeningTo(source, t)) {
							result.add(opis);
						}
					}
				}
			}
			return result;
		}
		return Collections.emptySet();
	}

	public static void deactiveSubscriptions() {
		// TODO do by processInstance
		demarcatedSubscriptions.set(null);
	}

}
