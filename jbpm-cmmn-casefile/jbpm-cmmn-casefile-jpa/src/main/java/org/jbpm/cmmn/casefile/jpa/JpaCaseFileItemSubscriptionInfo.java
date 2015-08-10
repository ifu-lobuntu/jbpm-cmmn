package org.jbpm.cmmn.casefile.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.subscription.DurableCaseFileItemSubscriptionInfo;
import org.jbpm.cmmn.instance.subscription.DurableCaseSubscriptionInfo;
import org.jbpm.cmmn.instance.subscription.impl.AbstractCaseFileItemSubscriptionInfo;

@Entity
public class JpaCaseFileItemSubscriptionInfo extends AbstractCaseFileItemSubscriptionInfo implements DurableCaseFileItemSubscriptionInfo {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private JpaCaseSubscriptionInfo caseSubscription;
	private String itemName;
	private String relatedItemName;
	private CaseFileItemTransition transition;
	private long processInstanceId;
	private String caseKey;

	public JpaCaseFileItemSubscriptionInfo() {
		super();
	}

	public JpaCaseFileItemSubscriptionInfo(JpaCaseSubscriptionInfo caseSubscription, String itemName, CaseFileItemTransition transition, CaseInstance instance) {
		super();

	}

	@Override
	public String getRelatedItemName() {
		return relatedItemName;
	}

	@Override
	public void setRelatedItemName(String relatedItemName) {
		this.relatedItemName = relatedItemName;
	}

	public JpaCaseSubscriptionInfo getCaseSubscription() {
		return caseSubscription;
	}

	@Override
	public void setCaseSubscription(DurableCaseSubscriptionInfo<?> caseSubscription) {
		this.caseSubscription = (JpaCaseSubscriptionInfo) caseSubscription;
	}

	@Override
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public void setTransition(CaseFileItemTransition transition) {
		this.transition = transition;
	}

	@Override
	public void setCaseKey(String caseKey) {
		this.caseKey = caseKey;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getCaseKey() {
		return caseKey;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getItemName() {
		return itemName;
	}

	@Override
	public CaseFileItemTransition getTransition() {
		return transition;
	}

	@Override
	public String toString() {
		return itemName + "[" + transition + "]";
	}

	@Override
	public long getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getIdentifier() {
		return caseSubscription.getId().getClassName() + caseSubscription.getId().getId() + super.getIdentifier();
	}
}
