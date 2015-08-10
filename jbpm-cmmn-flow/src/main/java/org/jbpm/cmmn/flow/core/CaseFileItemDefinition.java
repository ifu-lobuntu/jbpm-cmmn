package org.jbpm.cmmn.flow.core;


public interface CaseFileItemDefinition extends CMMNElement {
    CaseFileItemDefinitionType getDefinitionType();

    void setDefinitionType(CaseFileItemDefinitionType definitionType);

    String getStructureRef();

    void setStructureRef(String structureRef);
}
