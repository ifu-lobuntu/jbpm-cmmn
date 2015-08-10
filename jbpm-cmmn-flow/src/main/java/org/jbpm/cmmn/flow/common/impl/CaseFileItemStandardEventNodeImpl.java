package org.jbpm.cmmn.flow.common.impl;

import org.drools.core.process.core.datatype.DataType;
import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.flow.core.impl.CaseFileItemImpl;

import java.io.Serializable;


public abstract class CaseFileItemStandardEventNodeImpl extends AbstractStandardEventNode implements Serializable {
	private CaseFileItemTransition standardEvent;
	private CaseFileItemImpl sourceCaseFileItem;
	private CaseFileItemImpl relatedCaseFileItem;
	private String sourceRef;
	private String relationRef;

	public CaseFileItemTransition getStandardEvent() {
		return standardEvent;
	}

	public void setStandardEvent(CaseFileItemTransition type) {
		this.standardEvent = type;
	}

	public CaseFileItemImpl getSourceCaseFileItem() {
		return sourceCaseFileItem;
	}

	public void setSourceCaseFileItem(CaseFileItemImpl caseFileItem) {
		if(caseFileItem==null){
			System.out.println();
		}
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

	public CaseFileItemImpl getRelatedCaseFileItem() {
		return relatedCaseFileItem;
	}

	public void setRelatedCaseFileItem(CaseFileItemImpl relatedCaseFileItem) {
		this.relatedCaseFileItem = relatedCaseFileItem;
	}

	@Override
	public String getEventClassName() {
		if (getRelatedCaseFileItem() != null) {
			return getRelatedCaseFileItem().getType().getStringType();
		} else {
			CaseFileItemImpl cfi = getSourceCaseFileItem();
			DataType type = cfi.getType();
			return type.getStringType();
		}
	}
}
