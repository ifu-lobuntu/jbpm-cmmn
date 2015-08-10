package org.jbpm.cmmn.flow.core;


public interface CaseParameter extends CMMNElement {
    String getName();

    void setElementId(String id);

    String getBindingRef();

    void setBindingRef(String bindingRef);

    void setName(String name);

    CaseFileItem getBoundVariable();

    void setBoundVariable(CaseFileItem variable);

    BindingRefinement getBindingRefinement();

    void setBindingRefinement(BindingRefinement bindingRefinement);
}
