package org.jbpm.cmmn.task.model;

import java.util.Map;

import org.kie.api.task.model.Task;

public interface PlannedTask extends Task {

	String getDiscretionaryItemId();

	public abstract String getPlanItemName();

	@Deprecated()
	/**
	 * Need to come up with passByReference/passByValue solution for GWT
	 * @return
	 */
	Map<String, Object> getParameterOverrides();

}