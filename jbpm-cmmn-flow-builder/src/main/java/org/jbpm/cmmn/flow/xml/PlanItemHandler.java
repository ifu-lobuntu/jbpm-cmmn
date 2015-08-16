package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.impl.StageImpl;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.impl.PlanItemImpl;
import org.jbpm.workflow.core.NodeContainer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class PlanItemHandler extends AbstractCaseElementHandler implements Handler {
	public PlanItemHandler() {
		super();
		super.validParents.add(StageImpl.class);
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		@SuppressWarnings("rawtypes")
		PlanItemImpl planItem = new PlanItemImpl();
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
		planItem.setDefinitionRef(IdGenerator.toXmlId(attrs.getValue("definitionRef")));
		String exit = attrs.getValue("exitCriteriaRefs");
		if (exit != null) {
			for (String string : exit.split("\\ ")) {
				planItem.putExitCriterion(string, null);
			}
		}
		planItem.setPlanItemContainer(((PlanItemContainer) parser.getParent()));
		return planItem;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		PlanItemImpl node= (PlanItemImpl) parser.getCurrent();
		NodeContainer parent = (NodeContainer) parser.getParent();
		parent.addNode(node);
		return parser.getCurrent();
	}

	@Override
	public Class<?> generateNodeFor() {
		return PlanItemImpl.class;
	}

}
