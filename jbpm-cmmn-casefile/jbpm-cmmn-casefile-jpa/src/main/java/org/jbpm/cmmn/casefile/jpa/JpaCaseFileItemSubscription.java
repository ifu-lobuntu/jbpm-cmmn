package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.instance.subscription.DurableCaseFileItemSubscription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JpaCaseFileItemSubscription implements DurableCaseFileItemSubscription {
    @GeneratedValue()
    @Id
    Long id;
    String stringifiedObjectId;
    String objectType;
    long processInstanceId;
    String deploymentId;
    String itemName;
    String relatedItemName;
    CaseFileItemTransition transition;

    public JpaCaseFileItemSubscription() {
        super();
    }

    @Override
    public String getStringifiedObjectId() {
        return stringifiedObjectId;
    }

    public void setStringifiedObjectId(String stringifiedObjectId) {
        this.stringifiedObjectId = stringifiedObjectId;
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public long getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    @Override
    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String getRelatedItemName() {
        return relatedItemName;
    }

    public void setRelatedItemName(String relatedItemName) {
        this.relatedItemName = relatedItemName;
    }

    @Override
    public CaseFileItemTransition getTransition() {
        return transition;
    }

    public void setTransition(CaseFileItemTransition transition) {
        this.transition = transition;
    }
}
