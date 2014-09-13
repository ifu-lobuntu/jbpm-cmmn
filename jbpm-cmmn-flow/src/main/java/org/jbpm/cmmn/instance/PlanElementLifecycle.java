package org.jbpm.cmmn.instance;


public interface PlanElementLifecycle {
	void create();

	void suspend();

	void terminate();

	void setPlanElementState(PlanElementState s);

	PlanElementState getPlanElementState();

	CaseInstance getCaseInstance();

}
