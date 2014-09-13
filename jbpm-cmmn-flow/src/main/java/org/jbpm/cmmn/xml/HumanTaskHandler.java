package org.jbpm.cmmn.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.task.HumanTask;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class HumanTaskHandler extends AbstractCaseElementHandler implements Handler {
	public HumanTaskHandler() {

	}

	@Override
	public Class<?> generateNodeFor() {
		return HumanTask.class;
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		HumanTask node = new HumanTask();
		node.setElementId(attrs.getValue("id"));
		node.setBlocking(!"false".equals(attrs.getValue("isBlocking")));
		node.setPerformerRef(attrs.getValue("performerRef"));
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
