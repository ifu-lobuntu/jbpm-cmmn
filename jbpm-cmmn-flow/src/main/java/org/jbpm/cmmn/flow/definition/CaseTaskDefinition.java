package org.jbpm.cmmn.flow.definition;


public interface CaseTaskDefinition extends TaskDefinition{

    void setCaseId(String string);

    String getCaseId();
}
