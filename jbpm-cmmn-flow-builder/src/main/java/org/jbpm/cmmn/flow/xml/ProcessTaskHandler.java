package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.definition.ProcessTaskDefinition;
import org.jbpm.cmmn.flow.definition.impl.CaseTaskDefinitionImpl;
import org.jbpm.cmmn.flow.definition.impl.ProcessTaskDefinitionImpl;
import org.jbpm.cmmn.flow.definition.impl.TaskDefinitionImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ProcessTaskHandler extends AbstractCaseElementHandler implements PlanItemDefinitionHandlerDelegate {
	public ProcessTaskHandler() {

	}

	@Override
	public Class<?> generateNodeFor() {
		return ProcessTaskDefinitionImpl.class;
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		ProcessTaskDefinitionImpl node = new ProcessTaskDefinitionImpl();
		node.setElementId(attrs.getValue("id"));
		node.setBlocking(!"false".equals(attrs.getValue("isBlocking")));
		node.setName(attrs.getValue("name"));
		String caseRef = attrs.getValue("processRef");
		if (caseRef != null) {
			String[] split = caseRef.split("[\\#\\:]");
			if (split.length == 1) {
				node.setProcessId(split[0]);
			} else {
				node.setProcessId(split[1]);
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
