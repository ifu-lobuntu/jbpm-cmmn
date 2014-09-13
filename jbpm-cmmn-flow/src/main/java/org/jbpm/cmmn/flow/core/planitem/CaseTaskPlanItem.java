package org.jbpm.cmmn.flow.core.planitem;

import java.util.Map.Entry;

import org.drools.core.process.core.ParameterDefinition;
import org.drools.core.process.core.Work;
import org.drools.core.process.core.impl.ParameterDefinitionImpl;
import org.drools.core.process.core.impl.WorkImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.TaskItemWithDefinition;
import org.jbpm.cmmn.flow.core.impl.PlannerRoleCalculator;
import org.jbpm.cmmn.flow.core.task.CaseTask;

public class CaseTaskPlanItem extends AbstractPlanItem<CaseTask> implements MultiInstancePlanItem, TaskItemWithDefinition<CaseTask> {

	private static final long serialVersionUID = 76131417693392877L;
	private Work work;
	private PlanItemInstanceFactoryNode factoryNode;

	public CaseTaskPlanItem() {
	}

	public CaseTaskPlanItem(PlanItemInfoImpl<CaseTask> planItemInfo, PlanItemInstanceFactoryNode createFactoryNode) {
		super(planItemInfo);
		this.factoryNode = createFactoryNode;
	}

	public PlanItemInstanceFactoryNode getFactoryNode() {
		return factoryNode;
	}

	public Work getWork() {
		if (work == null) {
			work = new WorkImpl();
			Work sourceWork = getDefinition().getWork();
			work.setName(sourceWork.getName());
			for (ParameterDefinition pd : sourceWork.getParameterDefinitions()) {
				work.addParameterDefinition(new ParameterDefinitionImpl(pd.getName(), pd.getType()));
			}
			for (Entry<String, Object> entry : sourceWork.getParameters().entrySet()) {
				work.setParameter(entry.getKey(), entry.getValue());
			}
			work.setParameter("NodeName", getName());
			work.setParameter(WorkItemParameters.GROUP_ID, getPlannerRoles(this));
			work.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, getPlannerRoles(this));
		}
		return work;
	}

	public static String getPlannerRoles(CaseTaskPlanItem t) {
		return PlannerRoleCalculator.getPlannerRoles(t);
	}
}
