package org.jbpm.cmmn.flow.xml;

import org.drools.core.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.impl.BindingRefinementImpl;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.CaseParameterImpl;
import org.jbpm.cmmn.flow.definition.*;
import org.jbpm.process.core.context.variable.Variable;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class CaseParameterHandler extends AbstractCaseElementHandler implements Handler {
	public CaseParameterHandler() {
		this.validParents.add(HumanTaskDefinition.class);
		this.validParents.add(CaseTaskDefinition.class);
		this.validPeers.add(null);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(ParameterMapping.class);
		this.validPeers.add(PlanItemControl.class);
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		CaseParameterImpl cp = new CaseParameterImpl();
		cp.setBindingRef(IdGenerator.toXmlId(attrs.getValue("bindingRef")));
		cp.setElementId(attrs.getValue("id"));
		cp.setName(attrs.getValue("name"));
		if (parser.getParent() instanceof CaseImpl) {
			CaseImpl p = (CaseImpl) parser.getParent();
			if (localName.equals("output")) {
				p.addOutputParameter(cp);
			} else {
				p.addInputParameter(cp);
			}
		} else if (parser.getParent() instanceof TaskDefinition) {
			TaskDefinition ht = (TaskDefinition) parser.getParent();
			Variable var = new Variable();
			var.setType(new ObjectDataType());//TODO link to CaseFileItem type
			ht.getVariableScope().getVariables().add(var);
			if (localName.equals("outputs")) {
				ht.addOutputParameter(cp);
				var.setName("Output" + cp.getName());
			} else {
				ht.addInputParameter(cp);
				var.setName("Input"+cp.getName());
			}
		}
		return cp;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		Element el = parser.endElementBuilder();
		CaseParameterImpl caseParameter = (CaseParameterImpl) parser.getCurrent();
		caseParameter.setBindingRefinement(new BindingRefinementImpl(ConstraintExtractor.extractExpression(el, "bindingRefinement")));
		return caseParameter;
	}

	@Override
	public Class<?> generateNodeFor() {
		return CaseParameterImpl.class;
	}

}
