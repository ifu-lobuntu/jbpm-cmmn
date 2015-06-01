package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.task.CaseTask;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ProcessTaskHandler extends AbstractCaseElementHandler implements PlanItemDefinitionHandlerDelegate {
	public ProcessTaskHandler() {

	}

	@Override
	public Class<?> generateNodeFor() {
		return CaseTask.class;
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		CaseTask node = new CaseTask();
		node.setElementId(attrs.getValue("id"));
		node.setBlocking(!"false".equals(attrs.getValue("isBlocking")));
		node.setName(attrs.getValue("name"));
		String processRef = attrs.getValue("processRef");
		if (processRef != null) {
			String[] split = processRef.split("[\\#\\:]");
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
		CaseTask node = (CaseTask) parser.getCurrent();
		node.mapParameters();
		return parser.getCurrent();
	}

}
