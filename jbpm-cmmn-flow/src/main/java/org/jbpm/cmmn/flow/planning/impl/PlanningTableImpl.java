package org.jbpm.cmmn.flow.planning.impl;

import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.impl.HumanTaskDefinitionImpl;
import org.jbpm.cmmn.flow.definition.impl.StageImpl;
import org.jbpm.cmmn.flow.planning.ApplicabilityRule;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.PlanningTableContainer;
import org.jbpm.cmmn.flow.planning.TableItem;
import org.kie.api.definition.process.Node;

import java.util.Collection;
import java.util.HashSet;

public class PlanningTableImpl extends TableItemImpl implements PlanningTable {

	private static final long serialVersionUID = 11515151511L;
	private Collection<ApplicabilityRule> applicabilityRules = new HashSet<ApplicabilityRule>();
	private Collection<TableItem> tableItems = new HashSet<TableItem>();
	private long id;
	private PlanningTableContainer planningTableContainer;

	@Override
	public Node getNode(long id) {
		for (TableItem ti : tableItems) {
			if (ti.getId() == id) {
				return ti;
			} else if (ti instanceof PlanningTableImpl) {
				Node node = ti.getNode(id);
				if (node != null) {
					return node;
				}
			}
		}
		return super.getNode(id);
	}

	public Collection<ApplicabilityRule> getOwnedApplicabilityRules() {
		return applicabilityRules;
	}

	public void addOwnedApplicabilityRule(ApplicabilityRule applicabilityRule) {
		applicabilityRules.add(applicabilityRule);
	}

	public Collection<TableItem> getTableItems() {
		return tableItems;
	}

	public void addTableItem(TableItem ti) {
		this.tableItems.add(ti);
		ti.setParentTable(this);
	}

	public void setId(long next) {
		this.id = next;
	}

	public long getId() {
		return id;
	}

	public DiscretionaryItemImpl<?> getDiscretionaryItemById(String elementId) {
		for (TableItem ti : getTableItems()) {
			if (ti.getElementId().equals(elementId)) {
				return (DiscretionaryItemImpl<?>) ti;
			} else if (ti instanceof PlanningTableImpl) {
				DiscretionaryItemImpl<?> result = ((PlanningTableImpl) ti).getDiscretionaryItemById(elementId);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

	public PlanItemContainer getFirstPlanItemContainer() {
	    PlanningTableContainer ptc = getRootTable().getPlanningTableContainer();
	    if(ptc instanceof StageImpl || ptc instanceof Case){
	        return (PlanItemContainer) ptc;
	    }else{
	        //TODO This is a bug in CMMN
	        //A HumanTaskDefinitionImpl may be referenced from multiple stages
	        return ((HumanTaskDefinitionImpl)ptc).getCase();
	    }
	}

    public PlanningTableContainer getPlanningTableContainer() {
        return planningTableContainer;
    }

    public void setPlanningTableContainer(PlanningTableContainer planningTableContainer) {
        this.planningTableContainer = planningTableContainer;
    }


}
