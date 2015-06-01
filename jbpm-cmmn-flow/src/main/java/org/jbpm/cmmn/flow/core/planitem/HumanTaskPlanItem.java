package org.jbpm.cmmn.flow.core.planitem;

import java.util.Map.Entry;

import org.drools.core.process.core.ParameterDefinition;
import org.drools.core.process.core.Work;
import org.drools.core.process.core.impl.ParameterDefinitionImpl;
import org.drools.core.process.core.impl.WorkImpl;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.core.PlanningTable;
import org.jbpm.cmmn.flow.core.TaskItemWithDefinition;
import org.jbpm.cmmn.flow.core.impl.PlannerRoleCalculator;
import org.jbpm.cmmn.flow.core.task.HumanTask;

public class HumanTaskPlanItem extends AbstractPlanItem<HumanTask> implements MultiInstancePlanItem, TaskItemWithDefinition<HumanTask> {

    private static final long serialVersionUID = 7613141769339402877L;
    private Work work;
    private PlanItemInstanceFactoryNode factoryNode;
    private PlanningTable planningTable;

    public HumanTaskPlanItem() {
    }

    public HumanTaskPlanItem(PlanItemInfoImpl<HumanTask> info, PlanItemInstanceFactoryNode factorNode) {
        super(info);
        this.factoryNode = factorNode;
    }

    @Override
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
            work.setParameter(WorkItemParameters.TASK_NODE_NAME, getName());
            work.setParameter(WorkItemParameters.TASK_PLAN_ITEM_NAME, getName());
            work.setParameter(WorkItemParameters.BUSINESSADMINISTRATOR_ID, getPlannerRoles(this));
        }
        return work;
    }

    public static String getPlannerRoles(HumanTaskPlanItem htpi) {
        return PlannerRoleCalculator.getPlannerRoles(htpi.getPlanInfo().getDefinition().getPlanningTable(), htpi.getPlanItemContainer().getPlanningTable());
    }

    public PlanningTable getPlanningTable() {
        return planningTable;
    }

    public void setPlanningTable(PlanningTable pt) {
        this.planningTable = pt;
    }
}
