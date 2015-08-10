package org.jbpm.cmmn.flow.planitem;

import org.jbpm.cmmn.flow.definition.PlanItemDefinition;

import java.util.Map;

public interface PlanItemInfo<T extends PlanItemDefinition> {

	T getDefinition();

	Map<String, Sentry> getExitCriteria();

	Map<String, Sentry> getEntryCriteria();

}
