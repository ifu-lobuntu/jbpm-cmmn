package org.jbpm.cmmn.flow.core.impl;

import java.util.Collection;
import java.util.Iterator;

import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.DiscretionaryItem;
import org.jbpm.cmmn.flow.core.PlanItem;
import org.jbpm.cmmn.flow.core.PlanningTable;
import org.jbpm.cmmn.flow.core.PlanningTableContainer;

public class PlannerRoleCalculator {

	public static String getPlannerRoles(Collection<CaseRole>... authorizedRoles) {
		for (Collection<CaseRole> collection : authorizedRoles) {
			if (collection != null && !collection.isEmpty()) {
				String seperator = System.getProperty("org.jbpm.ht.user.separator", ",");
				StringBuilder result = new StringBuilder();
				Iterator<CaseRole> values = collection.iterator();
				while (values.hasNext()) {
					CaseRole role = (CaseRole) values.next();
					result.append(role.getName());
					if (values.hasNext()) {
						result.append(seperator);
					}
				}
				return result.toString();
			}
		}
		return "Administrators";
	}
	public static String getPlannerRoles(PlanItem<?> pi) {
		if (pi.getDefinition() instanceof PlanningTableContainer) {
			PlanningTableContainer ptc = (PlanningTableContainer) pi.getDefinition();
			return PlannerRoleCalculator.getPlannerRoles(ptc.getPlanningTable(), pi.getPlanItemContainer().getPlanningTable());
		}
		return PlannerRoleCalculator.getPlannerRoles(pi.getPlanItemContainer().getPlanningTable());
	}

	public static String getPlannerRoles(PlanningTable ... planningTables) {
		@SuppressWarnings("unchecked")
		Collection<CaseRole>[] roles = new Collection[planningTables.length];
		for (int i = 0; i < planningTables.length; i++) {
			PlanningTable pt = planningTables[i];
			if (pt != null) {
				roles[i] = pt.getAuthorizedRoles().values();
			}
	
		}
		return getPlannerRoles(roles);
	}

	@SuppressWarnings("unchecked")
	public static String getPlannerRoles(DiscretionaryItem<?> pi) {
		return getPlannerRoles(pi.getAuthorizedRoles().values(), pi.getParentTable().getAuthorizedRoles().values());
	}

}
