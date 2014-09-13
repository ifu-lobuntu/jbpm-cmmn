package org.jbpm.cmmn.flow.core;

import java.util.Map;

public interface TableItem extends CMMNElement{

	Map<String, CaseRole> getAuthorizedRoles();
	Map<String, ApplicabilityRule> getApplicabilityRules();

	PlanningTable getParentTable();

}
