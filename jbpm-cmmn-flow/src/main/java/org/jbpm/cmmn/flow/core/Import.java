package org.jbpm.cmmn.flow.core;

import java.io.Serializable;

public interface Import extends Serializable, CMMNElement {

    String getImportType();

    void setImportType(String importType);

    String getLocation();

    void setLocation(String location);

    String getNamespace();

    void setNamespace(String namespace);
}
