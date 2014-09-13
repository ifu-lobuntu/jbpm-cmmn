package org.jbpm.cmmn.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.event.UserEvent;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class UserEventHandler extends AbstractCaseElementHandler {

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		UserEvent node = new UserEvent();
		parser.startElementBuilder(localName, attrs);

		node.setElementId(attrs.getValue("id"));
		node.setName(attrs.getValue("name"));
		node.setEventName(attrs.getValue("name"));
		node.setId(IdGenerator.getIdAsUniqueAsUuid(parser, node));
		((CaseImpl) parser.getParent(CaseImpl.class)).addPlanItemDefinition(node);
		return node;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		return parser.getCurrent();
	}

	@Override
	public Class<?> generateNodeFor() {
		return UserEvent.class;
	}

}
