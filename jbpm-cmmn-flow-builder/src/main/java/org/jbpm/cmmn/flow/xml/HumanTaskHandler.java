package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.definition.impl.HumanTaskDefinitionImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class HumanTaskHandler extends AbstractCaseElementHandler implements PlanItemDefinitionHandlerDelegate {
	public HumanTaskHandler() {

	}

	@Override
	public Class<?> generateNodeFor() {
		return HumanTaskDefinitionImpl.class;
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		HumanTaskDefinitionImpl node = new HumanTaskDefinitionImpl();
		node.setElementId(attrs.getValue("id"));
		node.setBlocking(!"false".equals(attrs.getValue("isBlocking")));
		node.setPerformerRef(IdGenerator.toXmlId(attrs.getValue("performerRef")));
		node.setName(attrs.getValue("name"));
		((CaseImpl) parser.getParent(CaseImpl.class)).addPlanItemDefinition(node);
		node.setId(IdGenerator.getIdAsUniqueAsUuid(parser, node));
		return node;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		return parser.getCurrent();
	}

}
