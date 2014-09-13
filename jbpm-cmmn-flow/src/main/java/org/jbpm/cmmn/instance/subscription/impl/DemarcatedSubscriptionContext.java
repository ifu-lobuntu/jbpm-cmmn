package org.jbpm.cmmn.instance.subscription.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jbpm.cmmn.flow.core.CaseFileItemTransition;
import org.jbpm.cmmn.instance.impl.CaseInstanceImpl;
import org.jbpm.cmmn.instance.subscription.OnPartInstanceSubscription;

public class DemarcatedSubscriptionContext {
	private static ThreadLocal<Map<Long, Set<OnPartInstanceSubscription>>> demarcatedSubscriptions = new ThreadLocal<Map<Long, Set<OnPartInstanceSubscription>>>();

	public static void activateSubscriptionsFrom(CaseInstanceImpl theCase) {
		Map<Long, Set<OnPartInstanceSubscription>> map = demarcatedSubscriptions.get();
		if (map == null) {
			demarcatedSubscriptions.set(map = new HashMap<Long, Set<OnPartInstanceSubscription>>());
		}
		map.put(theCase.getId(), theCase.findOnPartInstanceSubscriptions());
	}

	public static Set<OnPartInstanceSubscription> getSubscriptionsInScopeForFor(Object source, CaseFileItemTransition... transitions) {
		if (demarcatedSubscriptions.get() != null) {
			Set<OnPartInstanceSubscription> result = new HashSet<OnPartInstanceSubscription>();
			for (Entry<Long, Set<OnPartInstanceSubscription>> entry : demarcatedSubscriptions.get().entrySet()) {
				for (CaseFileItemTransition t : transitions) {
					for (OnPartInstanceSubscription opis : entry.getValue()) {
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
