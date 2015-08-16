package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.impl.HumanTaskDefinitionImpl;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.workflow.core.Node;

public class PlanItemContainerUtil {
	public static Node getNode(PlanItemContainer pic, long nodeId) {
		Node result = null;
		try {
			result = (Node) pic.superGetNode(nodeId);
		} catch (Exception e) {
		}
		if (result == null && pic.getPlanningTable() != null) {
			result = (Node) pic.getPlanningTable().getNode(nodeId);
		}
		if (result == null) {
			for (PlanItem<?> pi : pic.getPlanItems()) {
				if (pi.getDefinition() instanceof HumanTaskDefinitionImpl) {
					HumanTaskDefinitionImpl ht = (HumanTaskDefinitionImpl) pi.getDefinition();
					if (ht.getPlanningTable() != null) {
						result = (Node) ht.getPlanningTable().getNode(nodeId);
						if (result != null) {
							break;
						}
					}
				}
			}
		}
		return result;
	}
}
