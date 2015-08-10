package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.casemgmt.role.impl.RoleImpl;
import org.jbpm.cmmn.flow.core.CaseRole;

import java.io.Serializable;

public class CaseRoleImpl extends RoleImpl implements Serializable, CaseRole {
    private static final long serialVersionUID = 8146649730480734851L;
    private String elementId;

    public CaseRoleImpl(String name) {
        super(name);
    }

    public void setElementId(String value) {
        this.elementId = value;

    }

    @Override
    public String getElementId() {
        return elementId;
    }
}
