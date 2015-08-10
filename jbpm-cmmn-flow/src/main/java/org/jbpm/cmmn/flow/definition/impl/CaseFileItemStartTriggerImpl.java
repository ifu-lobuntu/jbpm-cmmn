package org.jbpm.cmmn.flow.definition.impl;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.common.impl.CaseFileItemStandardEventNodeImpl;

public class CaseFileItemStartTriggerImpl extends CaseFileItemStandardEventNodeImpl implements org.jbpm.cmmn.flow.definition.CaseFileItemStartTrigger {
	private static final long serialVersionUID = 1602328317980746322L;

	@Override
	public AbstractStandardEventNode copy() {
		CaseFileItemStartTriggerImpl result = new CaseFileItemStartTriggerImpl();
		result.setId(getId());
		result.setName(getName());
		result.setStandardEvent(getStandardEvent());
		result.setSourceCaseFileItem(getSourceCaseFileItem());
		result.setSourceRef(getSourceRef());
		return result;
	}
}
