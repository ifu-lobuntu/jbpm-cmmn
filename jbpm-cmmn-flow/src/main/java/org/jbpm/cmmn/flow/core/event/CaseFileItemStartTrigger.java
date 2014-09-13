package org.jbpm.cmmn.flow.core.event;

import org.jbpm.cmmn.flow.core.planitem.AbstractOnPart;
import org.jbpm.cmmn.flow.core.planitem.CaseFileItemOnPart;

public class CaseFileItemStartTrigger extends CaseFileItemOnPart {
	private static final long serialVersionUID = 1602328317980746322L;

	@Override
	public AbstractOnPart copy() {
		CaseFileItemStartTrigger result = new CaseFileItemStartTrigger();
		result.setId(getId());
		result.setName(getName());
		result.setStandardEvent(getStandardEvent());
		result.setSourceCaseFileItem(getSourceCaseFileItem());
		result.setSourceRef(getSourceRef());
		return result;
	}
}
