package org.jbpm.cmmn.flow.planitem;


import org.jbpm.cmmn.flow.common.CaseFileItemTransition;

public interface CaseFileItemOnPart extends OnPart{
    @Override
    CaseFileItemTransition getStandardEvent();
}
