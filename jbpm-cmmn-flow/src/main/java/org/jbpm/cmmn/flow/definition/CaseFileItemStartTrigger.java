package org.jbpm.cmmn.flow.definition;


import org.jbpm.cmmn.flow.common.CaseFileItemTransition;

public interface CaseFileItemStartTrigger extends StartTrigger{
    @Override
    CaseFileItemTransition getStandardEvent();
}
