package org.jbpm.cmmn.flow.planning.impl;

import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.PlanningTableContainer;

import java.util.Collection;
import java.util.Iterator;

public class PlannerRoleCalculator {

	public static String getPlannerRoles(Collection<CaseRole>... authorizedRoles) {
		for (Collection<CaseRole> collection : authorizedRoles) {
			if (collection != null && !collection.isEmpty()) {
				String seperator = System.getProperty("org.jbpm.ht.user.separator", ",");
				StringBuilder result = new StringBuilder();
				Iterator<CaseRole> values = collection.iterator();
				while (values.hasNext()) {
					CaseRoleImpl role = (CaseRoleImpl) values.next();
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
			PlanningTable planningTable = ptc.getPlanningTable();
			PlanItemContainer planItemContainer = pi.getPlanItemContainer();
			PlanningTable planningTable1 = planItemContainer.getPlanningTable();
			return PlannerRoleCalculator.getPlannerRoles(planningTable, planningTable1);
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
