package org.jbpm.cmmn.flow.planning;

import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.kie.api.definition.process.Node;

import java.util.Map;

public interface TableItem extends CMMNElement,Node {

	Map<String, CaseRole> getAuthorizedRoles();
	Map<String, ApplicabilityRule> getApplicabilityRules();

	PlanningTable getParentTable();
    PlanningTable getRootTable();

	void setParentTable(PlanningTable planningTable);

	long getId();

	Node getNode(long id);
}
