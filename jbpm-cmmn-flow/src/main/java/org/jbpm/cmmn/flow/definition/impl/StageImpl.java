package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.definition.Stage;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.workflow.core.node.EndNode;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.core.node.Split;
import org.jbpm.workflow.core.node.StartNode;
import org.kie.api.definition.process.Node;

import java.util.Collection;
import java.util.HashSet;

public class StageImpl extends AbstractPlanItemDefinition implements Stage {

	private static final long serialVersionUID = 3123425777169912160L;
	private boolean autoComplete;
	private StartNode defaultStart;
	private Split defaultSplit;
	private EndNode defaultEnd;
	private Join defaultJoin;

	private PlanningTable planningTable;

	@Override
	public Node superGetNode(long id) {
		return super.getNode(id);
	}

	@Override
	public StartNode getDefaultStart() {
		return defaultStart;
	}

	@Override
	public Node getNode(long id) {
		Node node = super.getNode(id);
		if (node == null && getPlanningTable() != null) {
			node = getPlanningTable().getNode(id);
			if (node == null) {
				for (PlanItem<?> pii : getPlanItems()) {
					if (pii.getDefinition() instanceof HumanTaskDefinitionImpl) {
						HumanTaskDefinitionImpl ht = (HumanTaskDefinitionImpl) pii.getDefinition();
						if (ht.getPlanningTable() != null) {
							node = ht.getPlanningTable().getNode(id);
							if (node != null) {
								break;
							}
						}
					}
				}
			}
		}
		return node;
	}

	@Override
	public void setDefaultStart(StartNode defaultStart) {
		this.defaultStart = defaultStart;
	}

	@Override
	public Split getDefaultSplit() {
		return defaultSplit;
	}

	@Override
	public void setDefaultSplit(Split defaultSplit) {
		this.defaultSplit = defaultSplit;
	}

	@Override
	public EndNode getDefaultEnd() {
		return defaultEnd;
	}

	@Override
	public void setDefaultEnd(EndNode defaultEnd) {
		this.defaultEnd = defaultEnd;
	}

	@Override
	public Join getDefaultJoin() {
		return defaultJoin;
	}

	@Override
	public void setDefaultJoin(Join defaultJoin) {
		this.defaultJoin = defaultJoin;
	}

		@Override
	public Collection<PlanItem<?>> getPlanItems() {
			Collection<PlanItem<?>> result = new HashSet<PlanItem<?>>();
			for (Node node : getNodes()) {
				if(node instanceof PlanItem){
					result.add((PlanItem)node);
				}
			}
			return result;
	}

	public boolean isAutoComplete() {
		return autoComplete;
	}

	public void setAutoComplete(boolean autoComplete) {
		this.autoComplete = autoComplete;
	}

	public void setPlanningTable(PlanningTable planningTable) {
		this.planningTable = planningTable;
	}

	public PlanningTable getPlanningTable() {
		return planningTable;
	}

}
