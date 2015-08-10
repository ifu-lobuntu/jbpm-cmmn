package org.jbpm.cmmn.flow.definition;

import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.process.instance.impl.ReturnValueEvaluator;
import org.jbpm.workflow.core.Constraint;

/**
 * Created by ampie on 2015/08/10.
 */
public interface ParameterMapping extends CMMNElement {
    String getSourceRef();

    void setSourceRef(String sourceRef);

    CaseParameter getSourceParameter();

    CaseParameter getTargetParameter();

    String getTargetRef();

    void setTargetRef(String targetRef);

    void setElementId(String elementId);

    Constraint getTransformation();

    ReturnValueEvaluator getTransformer();

    void setTransformation(Constraint transformation);

    String getTargetParameterName();

    String getSourceParameterName();

    void setTargetParameterName(String targetParameterName);

    void setSourceParameterName(String sourceParameterName);

    String getSourceParameterId();

    String getTargetParameterId();

    void setTargetParameter(CaseParameter cp);

    void setSourceParameter(CaseParameter sourceParameter);
}
