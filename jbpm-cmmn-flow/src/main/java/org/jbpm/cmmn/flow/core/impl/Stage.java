package org.jbpm.cmmn.flow.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.drools.core.process.core.ParameterDefinition;
import org.drools.core.process.core.Work;
import org.drools.core.process.core.datatype.impl.type.StringDataType;
import org.drools.core.process.core.impl.ParameterDefinitionImpl;
import org.drools.core.process.core.impl.WorkImpl;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.PlanItemInfo;
import org.jbpm.cmmn.flow.core.PlanningTable;
import org.jbpm.cmmn.flow.core.task.AbstractPlanItemDefinition;
import org.jbpm.cmmn.flow.core.task.HumanTask;
import org.jbpm.workflow.core.node.EndNode;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.core.node.Split;
import org.jbpm.workflow.core.node.StartNode;
import org.kie.api.definition.process.Node;

public class Stage extends AbstractPlanItemDefinition implements PlanItemContainer {

	private static final long serialVersionUID = 3123425777169912160L;
	private boolean autoComplete;
	private Collection<PlanItemInfo<?>> planItemInfo = new ArrayList<PlanItemInfo<?>>();
	private StartNode defaultStart;
	private Split defaultSplit;
	private EndNode defaultEnd;
	private Join defaultJoin;

	private PlanningTable planningTable;

	public Work getWork() {
		Work work = new WorkImpl();
		work.setName("Human Task");
		Set<ParameterDefinition> parameterDefinitions = new HashSet<ParameterDefinition>();
		parameterDefinitions.add(new ParameterDefinitionImpl("TaskName", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("ActorId", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("Priority", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("Comment", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("Skippable", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("Content", new StringDataType()));
		return work;
	}

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
					if (pii.getDefinition() instanceof HumanTask) {
						HumanTask ht = (HumanTask) pii.getDefinition();
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
