package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.impl.AbstractPlanItemDefinition;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.workflow.core.node.EndNode;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.core.node.Split;
import org.jbpm.workflow.core.node.StartNode;
import org.kie.api.definition.process.Node;

import java.util.*;

public class CaseImpl extends RuleFlowProcess implements Case {
	private static final long serialVersionUID = -2253866933695827108L;
	public static final String WORK_ITEM = "WorkItem";
	private Map<String, org.jbpm.cmmn.flow.core.CaseParameter> inputParameters = new HashMap<String, org.jbpm.cmmn.flow.core.CaseParameter>();
	private Map<String, org.jbpm.cmmn.flow.core.CaseParameter> outputParameters = new HashMap<String, org.jbpm.cmmn.flow.core.CaseParameter>();
	private Map<String, PlanItemDefinition> planItemDefinitions = new HashMap<String, PlanItemDefinition>();
	private Collection<CaseRole> roles = new ArrayList<CaseRole>();
	private StartNode defaultStart;
	private Split defaultSplit;
	private EndNode defaultEnd;
	private Join defaultJoin;
	private PlanningTable planningTable;
	private boolean isBuilt;
	public CaseImpl(){
		super();
		setType(CASE_TYPE);
	}

	@Override
	public String getType() {
		return CASE_TYPE;
	}

	@Override
	public StartNode getDefaultStart() {
		return defaultStart;
	}

	@Override
	public Node superGetNode(long id) {
		return super.getNode(id);
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
	public CaseImpl getCase() {
		return this;
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
	public void setDefaultJoin(Join n) {
		this.defaultJoin = n;
	}

	@Override
	public Join getDefaultJoin() {
		return defaultJoin;
	}

	public void addInputParameter(CaseParameterImpl cp) {
		inputParameters.put(cp.getElementId(), cp);
	}

	public Collection<org.jbpm.cmmn.flow.core.CaseParameter> getInputParameters() {
		return inputParameters.values();
	}

	public void addOutputParameter(CaseParameterImpl cp) {
		outputParameters.put(cp.getElementId(), cp);
	}

	public Collection<org.jbpm.cmmn.flow.core.CaseParameter> getOutputParameters() {
		return outputParameters.values();
	}

	public CaseParameter getInputParameter(String id) {
		return inputParameters.get(id);
	}

	public CaseParameter getOutputParameter(String id) {
		return outputParameters.get(id);
	}

	@Override
	public Node getNode(long id) {
		return PlanItemContainerUtil.getNode(this, id);
	}

	public String getCaseKey() {
		return super.getPackageName() + super.getId() + super.getVersion();
	}

	public void addPlanItemDefinition(PlanItemDefinition d) {
		planItemDefinitions.put(d.getElementId(), d);
		if(d instanceof AbstractPlanItemDefinition){
		    ((AbstractPlanItemDefinition) d).setCase(this);
		}
	}


	public PlanItemDefinition getPlanItemDefinition(String elementId) {
		return planItemDefinitions.get(elementId);
	}

	public Collection<PlanItemDefinition> getPlanItemDefinitions() {
		return planItemDefinitions.values();
	}

	public Collection<CaseRole> getRoles() {
		return roles;
	}

	public void addRole(CaseRole r) {
		roles.add(r);
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


	@Override
	public PlanningTable getPlanningTable() {
		return planningTable;
	}

	@Override
	public void setPlanningTable(PlanningTable planningTable) {
		this.planningTable = planningTable;
	}

	public boolean isBuilt() {
		return isBuilt;
	}

	public void setBuilt(boolean isBuilt) {
		this.isBuilt = isBuilt;
	}
}
