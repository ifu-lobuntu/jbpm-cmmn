package org.jbpm.cmmn.flow.definition.impl;

import org.drools.core.process.core.ParameterDefinition;
import org.drools.core.process.core.Work;
import org.drools.core.process.core.datatype.impl.type.StringDataType;
import org.drools.core.process.core.impl.ParameterDefinitionImpl;
import org.drools.core.process.core.impl.WorkImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.impl.CaseRoleImpl;
import org.jbpm.cmmn.flow.definition.HumanTaskDefinition;
import org.jbpm.cmmn.flow.planning.PlanningTable;

import java.util.HashSet;
import java.util.Set;

public class HumanTaskDefinitionImpl extends TaskDefinitionImpl implements HumanTaskDefinition {
	private String performerRef;
	private CaseRole performer;

	private static final long serialVersionUID = 2502972573721493216L;
	private PlanningTable planningTable;
	private Work work;

	public HumanTaskDefinitionImpl() {
		work = new WorkImpl();
		work.setName("CMMN Human Task");
		Set<ParameterDefinition> parameterDefinitions = new HashSet<ParameterDefinition>();
		parameterDefinitions.add(new ParameterDefinitionImpl("TaskName", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("ActorId", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("Priority", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("Comment", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("Skippable", new StringDataType()));
		parameterDefinitions.add(new ParameterDefinitionImpl("Content", new StringDataType()));
		// TODO: initiator
		// TODO: attachments
		// TODO: deadlines
		// TODO: delegates
		// TODO: recipients
		// TODO: ...
		work.setParameterDefinitions(parameterDefinitions);

	}


	public String getPerformerRef() {
		return performerRef;
	}

	public void setPerformerRef(String performerRef) {
		this.performerRef = performerRef;
	}

	public CaseRole getPerformer() {
		return performer;
	}

	public void setPerformer(CaseRole performer) {
		this.performer = performer;
	}

	@Override
	public Work getWork() {
		Work result = work;
		if (getPerformer() != null) {
			result.setParameter(WorkItemParameters.GROUP_ID, getPerformer().getName());
		}
		return result;
	}

	public void setPlanningTable(PlanningTable item) {
		this.planningTable = item;
	}

	public PlanningTable getPlanningTable() {
		return planningTable;
	}
}
