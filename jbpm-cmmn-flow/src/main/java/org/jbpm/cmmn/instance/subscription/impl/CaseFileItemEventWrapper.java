package org.jbpm.cmmn.instance.subscription.impl;

import org.jbpm.cmmn.instance.CaseFileItemEvent;

public class CaseFileItemEventWrapper {
	CaseFileItemEvent event;
	String deploymentId;
	long processId;

	public CaseFileItemEventWrapper(CaseFileItemEvent event, String deploymentId, long processId) {
		super();
		this.event = event;
		this.deploymentId = deploymentId;
		this.processId = processId;
	}

	public CaseFileItemEvent getEvent() {
		return event;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public long getProcessInstanceId() {
		return processId;
	}

}
