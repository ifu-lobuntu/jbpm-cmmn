package org.jbpm.cmmn.flow.core;

import java.util.Map;

public interface PlanItemInfo<T extends PlanItemDefinition> {

	T getDefinition();

	Map<String, Sentry> getExitCriteria();

	Map<String, Sentry> getEntryCriteria();

}
