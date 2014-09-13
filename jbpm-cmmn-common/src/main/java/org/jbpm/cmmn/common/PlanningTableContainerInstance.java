package org.jbpm.cmmn.common;

public interface PlanningTableContainerInstance {

	void makeDiscretionaryItemAvailable(String discretionaryItemId);

	void resumeAfterPlanning();

}
