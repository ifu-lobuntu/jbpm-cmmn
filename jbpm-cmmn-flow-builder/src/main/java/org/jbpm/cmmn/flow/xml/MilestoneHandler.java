package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.Milestone;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class MilestoneHandler extends AbstractCaseElementHandler {

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		Milestone node = new Milestone();
		node.setElementId(attrs.getValue("id"));
		node.setName(attrs.getValue("name"));
		node.setId(IdGenerator.getIdAsUniqueAsUuid(parser, node));
		((CaseImpl) parser.getParent(CaseImpl.class)).addPlanItemDefinition(node);
		return node;
	}

	@Override
	public Class<?> generateNodeFor() {
		return Milestone.class;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		return parser.getCurrent();
	}

}
