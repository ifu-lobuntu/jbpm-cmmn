package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.definition.TimerEventListener;
import org.jbpm.cmmn.flow.definition.impl.TimerEventListenerImpl;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class TimerEventHandler extends AbstractCaseElementHandler implements PlanItemDefinitionHandlerDelegate {

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		TimerEventListenerImpl node = new TimerEventListenerImpl();
		parser.startElementBuilder(localName, attrs);
		node.setElementId(attrs.getValue("id"));
		CaseImpl theCase = (CaseImpl) parser.getParent(CaseImpl.class);
		node.setId(IdGenerator.getIdAsUniqueAsUuid(parser, node));
		node.setName(attrs.getValue("name"));
		theCase.addPlanItemDefinition(node);
		return node;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		Element el = parser.endElementBuilder();
		TimerEventListener l = (TimerEventListener) parser.getCurrent();
		l.setTimerExpression(ConstraintExtractor.extractExpression(el, "timerExpression"));
		return l;
	}

	@Override
	public Class<?> generateNodeFor() {
		return TimerEventListenerImpl.class;
	}

}
