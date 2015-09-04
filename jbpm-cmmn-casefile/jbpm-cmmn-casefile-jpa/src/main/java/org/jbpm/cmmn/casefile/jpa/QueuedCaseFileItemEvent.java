package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.services.task.impl.util.SerializableUtil;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;


@Entity
public class QueuedCaseFileItemEvent {
    @GeneratedValue
    @Id
    private Long id;
    private String caseFileItemName;
    @Enumerated
    private CaseFileItemTransition transition;
    private String valueClassName;
    @Lob
    private byte[] value;
    private String parentObjectClassName;
    @Lob
    private byte[] parentObjectId;
    private String deploymentId;
    private long processInstanceId;

    public String getCaseFileItemName() {
        return caseFileItemName;
    }

    public void setCaseFileItemName(String caseFileItemName) {
        this.caseFileItemName = caseFileItemName;
    }

    public CaseFileItemTransition getTransition() {
        return transition;
    }

    public void setTransition(CaseFileItemTransition transition) {
        this.transition = transition;
    }

    public void setValue(Object value) throws IOException {
        if (value != null) {
            if (JpaIdUtil.INSTANCE.isEntity(value.getClass())) {
                valueClassName = JpaIdUtil.INSTANCE.findEntityClass(value.getClass()).getName();
                Serializable id = JpaIdUtil.INSTANCE.getId(JpaIdUtil.INSTANCE.findIdMember(value.getClass()), value);
                this.value = SerializableUtil.serialize(id);
            } else {
                this.value=SerializableUtil.serialize((Serializable) value);
            }
        }
    }

    public void setParentObject(Object parentObject) throws IOException {
        if (parentObject != null) {
            parentObjectClassName = JpaIdUtil.INSTANCE.findEntityClass(parentObject.getClass()).getName();
            Serializable id = JpaIdUtil.INSTANCE.getId(JpaIdUtil.INSTANCE.findIdMember(parentObject.getClass()), parentObject);
            this.parentObjectId = SerializableUtil.serialize(id);
        }
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public long getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getValueClassName() {
        return valueClassName;
    }

    public void setValueClassName(String valueClassName) {
        this.valueClassName = valueClassName;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    public String getParentObjectClassName() {
        return parentObjectClassName;
    }

    public void setParentObjectClassName(String parentObjectClassName) {
        this.parentObjectClassName = parentObjectClassName;
    }

    public byte[] getParentObjectId() {
        return parentObjectId;
    }

    public void setParentObjectId(byte[] parentObjectId) {
        this.parentObjectId = parentObjectId;
    }
}
