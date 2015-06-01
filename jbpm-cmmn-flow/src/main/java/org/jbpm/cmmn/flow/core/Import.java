package org.jbpm.cmmn.flow.core;

import java.io.Serializable;

public class Import implements Serializable, CMMNElement {

	private static final long serialVersionUID = -2231177916762919L;
	private String importType;
    private String location;
    private String namespace;
	private String id;
	
    public Import(String id) {
        super();
        this.id = id;
    }
    public String getImportType() {
        return importType;
    }
    public void setImportType(String importType) {
        this.importType = importType;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getNamespace() {
        return namespace;
    }
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    public String getElementId() {
        return id;
    }
}
