package org.jbpm.cmmn.flow.planning.impl;

import org.jbpm.cmmn.flow.common.impl.AbstractItem;
import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;
import org.jbpm.cmmn.flow.planning.ApplicabilityRule;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.TableItem;

import java.util.HashMap;
import java.util.Map;

public class TableItemImpl extends AbstractItem implements TableItem{
	private static final long serialVersionUID = 6743815602437868413L;
	private Map<String, CaseRoleImpl> authorizedRoles = new HashMap<String, CaseRoleImpl>();

	private PlanningTable planningTable;
	private String description;
	private Map<String, ApplicabilityRule> applicabilityRules = new HashMap<String, ApplicabilityRule>();

	public void putApplicabilityRule(String id, ApplicabilityRule r) {
		this.applicabilityRules.put(id, r);
	}

	public Map<String, ApplicabilityRule> getApplicabilityRules() {
		return applicabilityRules;
	}

	public void putAuthorizedRole(String id, CaseRoleImpl role) {
		authorizedRoles.put(id, role);
	}

	@Override
	public Map<String, CaseRoleImpl> getAuthorizedRoles() {
		return authorizedRoles;
	}

	public static String getPlannerRoles(Case theCase) {
		return PlannerRoleCalculator.getPlannerRoles(theCase.getPlanningTable());
	}

    @Override
    public PlanningTable getParentTable() {
        return planningTable;
    }
    @Override
    public PlanningTable getRootTable() {
        if(planningTable==null){
            return (PlanningTableImpl)this;
        }else{
            return planningTable.getRootTable();
        }
    }

	public void setParentTable(PlanningTable planningTable) {
		this.planningTable = planningTable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
