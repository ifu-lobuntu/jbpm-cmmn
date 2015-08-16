package org.jbpm.cmmn.flow.definition;


public interface ProcessTaskDefinition extends CallingTaskDefinition{
    String getProcessId();
    void setProcessId(String id);
}
