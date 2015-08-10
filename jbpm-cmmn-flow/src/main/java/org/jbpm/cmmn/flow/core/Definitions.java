package org.jbpm.cmmn.flow.core;

import java.io.Serializable;
import java.util.List;


public interface Definitions extends Serializable {
    List<CaseFileItemDefinition> getCaseFileItemDefinitions();

    void setCaseFileItemDefinitions(List<CaseFileItemDefinition> caseFileItemDefinitions);

    String getTargetNamespace();

    void setTargetNamespace(String targetNamespace);
}
