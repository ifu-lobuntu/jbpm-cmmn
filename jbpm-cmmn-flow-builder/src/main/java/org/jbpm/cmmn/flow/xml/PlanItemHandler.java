package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.impl.Stage;
import org.jbpm.cmmn.flow.core.planitem.PlanItemInfoImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class PlanItemHandler extends AbstractCaseElementHandler implements Handler {
	public PlanItemHandler() {
		super();
		super.validParents.add(Stage.class);
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		@SuppressWarnings("rawtypes")
		PlanItemInfoImpl planItem = new PlanItemInfoImpl();
		planItem.setContainer(((PlanItemContainer) parser.getParent()));
		planItem.setName(attrs.getValue("name"));
		planItem.setElementId(attrs.getValue("id"));
		planItem.setId(IdGenerator.getIdAsUniqueAsUuid(parser, planItem));
		String entry = attrs.getValue("entryCriteriaRefs");
		if (entry != null) {
			for (String string : entry.split("\\ ")) {
				planItem.putEntryCriterion(string, null);
			}
		}
		planItem.setElementId(attrs.getValue("id"));
		planItem.setDefinitionRef(attrs.getValue("definitionRef"));
		String exit = attrs.getValue("exitCriteriaRefs");
		if (exit != null) {
			for (String string : exit.split("\\ ")) {
				planItem.putExitCriterion(string, null);
			}
		}
		return planItem;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		return parser.getCurrent();
	}

	@Override
	public Class<?> generateNodeFor() {
		return PlanItemInfoImpl.class;
	}

}
