package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.definition.Stage;
import org.jbpm.cmmn.flow.planitem.PlanItemInfo;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.workflow.core.node.EndNode;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.core.node.Split;
import org.jbpm.workflow.core.node.StartNode;
import org.kie.api.definition.process.Node;

import java.util.ArrayList;
import java.util.Collection;

public class StageImpl extends AbstractPlanItemDefinition implements Stage {

	private static final long serialVersionUID = 3123425777169912160L;
	private boolean autoComplete;
	private Collection<PlanItemInfo<?>> planItemInfo = new ArrayList<PlanItemInfo<?>>();
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
				for (PlanItemInfo<?> pii : getPlanItemInfo()) {
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
	public void addPlanItemInfo(PlanItemInfo<?> d) {
		planItemInfo.add(d);
	}

	@Override
	public Collection<PlanItemInfo<?>> getPlanItemInfo() {
		return planItemInfo;
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
