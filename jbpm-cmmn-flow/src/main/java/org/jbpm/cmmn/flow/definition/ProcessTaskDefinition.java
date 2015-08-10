package org.jbpm.cmmn.flow.definition;


public interface ProcessTaskDefinition extends TaskDefinition{
    String getProcessId();
    void setProcessId(String id);
}
