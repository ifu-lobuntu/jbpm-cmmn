package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.impl.CaseParameterImpl;
import org.jbpm.cmmn.flow.definition.CaseTaskDefinition;
import org.jbpm.cmmn.flow.definition.HumanTaskDefinition;
import org.jbpm.cmmn.flow.definition.ParameterMapping;
import org.jbpm.cmmn.flow.definition.ProcessTaskDefinition;
import org.jbpm.cmmn.flow.definition.impl.CaseTaskDefinitionImpl;
import org.jbpm.cmmn.flow.definition.impl.HumanTaskDefinitionImpl;
import org.jbpm.cmmn.flow.definition.impl.ParameterMappingImpl;
import org.jbpm.cmmn.flow.definition.impl.TaskDefinitionImpl;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ParameterMappingHandler extends AbstractCaseElementHandler implements Handler {
	public ParameterMappingHandler() {
		this.validParents.add(HumanTaskDefinition.class);
		this.validParents.add(CaseTaskDefinition.class);
		this.validParents.add(ProcessTaskDefinition.class);
		this.validPeers.add(null);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(ParameterMapping.class);

	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		ParameterMapping cp = new ParameterMappingImpl();
		cp.setSourceRef(IdGenerator.toXmlId(attrs.getValue("sourceRef")));
		cp.setTargetRef(IdGenerator.toXmlId(attrs.getValue("targetRef")));
		cp.setElementId(attrs.getValue("id"));
		if (parser.getParent() instanceof TaskDefinitionImpl) {
			TaskDefinitionImpl ht = (TaskDefinitionImpl) parser.getParent();
			ht.addParameterMapping(cp);
		}
		return cp;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		Element el = parser.endElementBuilder();
		ParameterMapping pm = (ParameterMapping) parser.getCurrent();
		pm.setTransformation(ConstraintExtractor.extractExpression(el, "transformation"));
		return pm;
	}

	@Override
	public Class<?> generateNodeFor() {
		return ParameterMappingImpl.class;
	}

}
