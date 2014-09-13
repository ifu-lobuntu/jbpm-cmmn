package org.jbpm.cmmn.instance;

import org.drools.core.process.instance.WorkItem;
import org.jbpm.cmmn.flow.core.PlanItemTransition;

public interface PlanElementLifecycleWithTask extends PlanElementLifecycle {
	WorkItem getWorkItem();

	void reactivate();

	void complete();

	void triggerTransitionOnTask(PlanItemTransition transition);

	void fault();

	Object getTask();

	long getWorkItemId();

}
