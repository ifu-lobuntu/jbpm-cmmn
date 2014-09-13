package org.jbpm.cmmn.instance.subscription.impl;

import org.jbpm.cmmn.instance.CaseFileItemEvent;

public class CaseFileItemEventWrapper {
	CaseFileItemEvent event;
	String caseKey;
	long processId;

	public CaseFileItemEventWrapper(CaseFileItemEvent event, String caseKey, long processId) {
		super();
		this.event = event;
		this.caseKey = caseKey;
		this.processId = processId;
	}

	public CaseFileItemEvent getEvent() {
		return event;
	}

	public String getCaseKey() {
		return caseKey;
	}

	public long getProcessInstanceId() {
		return processId;
	}

}
