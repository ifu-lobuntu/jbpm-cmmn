package org.jbpm.cmmn.task.model;

import java.io.Serializable;
import java.util.Collection;

import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;

public class PlanningTableInstance implements Serializable {
	private static final long serialVersionUID = 7379712745917913470L;
	private Collection<PlannableTask> plannedTasks;
	private Collection<ApplicableDiscretionaryItem> applicableDiscretionaryItems;

	public PlanningTableInstance() {
		super();
	}

	public PlanningTableInstance(Collection<PlannableTask> plannedTasks, Collection<ApplicableDiscretionaryItem> applicableDiscretionaryItems) {
		super();
		this.plannedTasks = plannedTasks;
		this.applicableDiscretionaryItems = applicableDiscretionaryItems;
	}

	public Collection<PlannableTask> getPlannableTasks() {
		return plannedTasks;
	}

	public void setPlannableTasks(Collection<PlannableTask> plannedTasks) {
		this.plannedTasks = plannedTasks;
	}

	public Collection<ApplicableDiscretionaryItem> getApplicableDiscretionaryItems() {
		return applicableDiscretionaryItems;
	}

	public void setApplicableDiscretionaryItems(Collection<ApplicableDiscretionaryItem> applicableDiscretionaryItems) {
		this.applicableDiscretionaryItems = applicableDiscretionaryItems;
	}

}
