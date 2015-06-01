package org.jbpm.cmmn.flow.xml;

import org.jbpm.workflow.core.impl.ConstraintImpl;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ConstraintExtractor {

    public static ConstraintImpl extractExpression(Element parentElement, String epxressionElementName) {
        NodeList conditionList = parentElement.getElementsByTagName(epxressionElementName);
        ConstraintImpl constraint = null;
        if (conditionList.getLength() == 1) {
            Element condition = (Element) conditionList.item(0);
            String dialect = SentryHandler.getDialect(condition);
            NodeList bodyList = condition.getElementsByTagName("body");
            if (bodyList.getLength() == 1) {
                Element body = (Element) bodyList.item(0);
                String bodyText = body.getFirstChild().getNodeValue();
                if (bodyText != null && bodyText.trim().length() > 0) {
                    constraint = new ConstraintImpl();
                    constraint.setConstraint(bodyText);
                    constraint.setDialect(dialect);
                }
            }
        }
        return constraint;
    }

}
