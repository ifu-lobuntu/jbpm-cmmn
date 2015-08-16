package org.jbpm.cmmn.flow.definition;


public interface CaseTaskDefinition extends CallingTaskDefinition{

    void setCaseId(String string);

    String getCaseId();
}
