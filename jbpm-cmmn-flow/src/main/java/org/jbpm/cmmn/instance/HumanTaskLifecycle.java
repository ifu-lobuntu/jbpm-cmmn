package org.jbpm.cmmn.instance;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.cmmn.flow.common.PlanItemTransition;

public interface HumanTaskLifecycle extends PlanElementLifecycle {
	WorkItem getWorkItem();
	Object getTask();

	long getWorkItemId();

}
