package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.definition.CaseTaskDefinition;
import org.jbpm.cmmn.flow.definition.impl.CaseTaskDefinitionImpl;
import org.jbpm.cmmn.flow.definition.impl.TaskDefinitionImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class CaseTaskHandler extends AbstractCaseElementHandler implements PlanItemDefinitionHandlerDelegate {
	public CaseTaskHandler() {

	}

	@Override
	public Class<?> generateNodeFor() {
		return CaseTaskDefinitionImpl.class;
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		CaseTaskDefinitionImpl node = new CaseTaskDefinitionImpl();
		node.setElementId(attrs.getValue("id"));
		node.setBlocking(!"false".equals(attrs.getValue("isBlocking")));
		node.setName(attrs.getValue("name"));
		String caseRef = attrs.getValue("caseRef");
		if (caseRef != null) {
			String[] split = caseRef.split("[\\#\\:]");
			if (split.length == 1) {
				node.setCaseId(split[0]);
			} else {
				node.setCaseId(split[1]);
			}
		}
		((CaseImpl) parser.getParent(CaseImpl.class)).addPlanItemDefinition(node);
		return node;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		TaskDefinitionImpl node = (TaskDefinitionImpl) parser.getCurrent();
		node.mapParameters();
		return parser.getCurrent();
	}

}
