package org.jbpm.cmmn.flow.planning;

import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;
import org.jbpm.cmmn.flow.planning.impl.PlanningTableImpl;
import org.kie.api.definition.process.Node;

import java.util.Map;

public interface TableItem extends CMMNElement,Node {

	Map<String, CaseRoleImpl> getAuthorizedRoles();
	Map<String, ApplicabilityRule> getApplicabilityRules();

	PlanningTable getParentTable();
    PlanningTable getRootTable();

	void setParentTable(PlanningTable planningTable);

	long getId();

	Node getNode(long id);
}
