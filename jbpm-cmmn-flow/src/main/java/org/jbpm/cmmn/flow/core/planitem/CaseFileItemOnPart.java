package org.jbpm.cmmn.flow.core.planitem;

import java.io.Serializable;

import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseFileItemTransition;

public class CaseFileItemOnPart extends AbstractOnPart implements Serializable {
	private static final long serialVersionUID = -9167236068103073693L;
	private CaseFileItemTransition standardEvent;
	private CaseFileItem sourceCaseFileItem;
	private CaseFileItem relatedCaseFileItem;
	private String sourceRef;
	private String relationRef;

	public CaseFileItemTransition getStandardEvent() {
		return standardEvent;
	}

	public void setStandardEvent(CaseFileItemTransition type) {
		this.standardEvent = type;
	}

	public CaseFileItem getSourceCaseFileItem() {
		return sourceCaseFileItem;
	}

	public void setSourceCaseFileItem(CaseFileItem caseFileItem) {
		this.sourceCaseFileItem = caseFileItem;
	}

	public void setSourceRef(String value) {
		this.sourceRef = value;
	}

	@Override
	public String getType() {
		return getType(this.sourceCaseFileItem.getName(), standardEvent);
	}

	public String getIdentifier() {
		if (this.relatedCaseFileItem != null) {
			return getType(this.sourceCaseFileItem.getName() + "." + relatedCaseFileItem.getName(), standardEvent);
		} else {
			return getType(this.sourceCaseFileItem.getName(), standardEvent);
		}
	}

	public String getSourceRef() {
		return sourceRef;
	}

	public String getRelationRef() {
		return relationRef;
	}

	public void setRelationRef(String relationRef) {
		this.relationRef = relationRef;
	}

	public CaseFileItem getRelatedCaseFileItem() {
		return relatedCaseFileItem;
	}

	public void setRelatedCaseFileItem(CaseFileItem relatedCaseFileItem) {
		this.relatedCaseFileItem = relatedCaseFileItem;
	}

	@Override
	public String getEventClassName() {
		if (getRelatedCaseFileItem() != null) {
			return getRelatedCaseFileItem().getType().getStringType();
		} else {
			return getSourceCaseFileItem().getType().getStringType();
		}
	}

}
