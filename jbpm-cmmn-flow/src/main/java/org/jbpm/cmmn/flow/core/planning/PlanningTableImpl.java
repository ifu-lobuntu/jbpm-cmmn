package org.jbpm.cmmn.flow.core.planning;

import java.util.Collection;
import java.util.HashSet;

import org.jbpm.cmmn.flow.core.ApplicabilityRule;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.PlanningTable;
import org.kie.api.definition.process.Node;

public class PlanningTableImpl extends TableItemImpl implements PlanningTable {

	private static final long serialVersionUID = 11515151511L;
	private Collection<ApplicabilityRule> applicabilityRules = new HashSet<ApplicabilityRule>();
	private Collection<TableItemImpl> tableItems = new HashSet<TableItemImpl>();
	private long id;
	private PlanItemContainer planItemContainer;

	@Override
	public Node getNode(long id) {
		for (TableItemImpl ti : tableItems) {
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

	public Collection<TableItemImpl> getTableItems() {
		return tableItems;
	}

	public void addTableItem(TableItemImpl ti) {
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
		for (TableItemImpl ti : getTableItems()) {
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
		if (planItemContainer == null && getParentTable() != null) {
			return getParentTable().getFirstPlanItemContainer();
		}
		return this.planItemContainer;
	}

	public void setPlanItemContainer(PlanItemContainer planItemContainer) {
		this.planItemContainer = planItemContainer;
	}

}
