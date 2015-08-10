package org.jbpm.cmmn.flow.core;

import org.drools.core.process.core.TypeObject;
import org.jbpm.process.core.ValueObject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface CaseFileItem extends CMMNElement,TypeObject, ValueObject, Serializable {
    boolean isUnique();

    void setUnique(boolean isUnique);

    boolean isOrdered();

    void setOrdered(boolean isOrdered);

    List<CaseFileItem> getChildren();

    Map<String, CaseFileItem> getTargets();

    void putTarget(String id, CaseFileItem t);

    void addChild(CaseFileItem c);

    void setElementId(String id);

    void setDefinitionRef(String value);

    String getDefinitionRef();

    CaseFileItemDefinition getDefinition();

    void setDefinition(CaseFileItemDefinition definition);

    boolean isCollection();

    void setCollection(boolean isCollection);

    String getName();
}
