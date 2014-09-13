package org.jbpm.cmmn.flow.xml;

import java.util.HashSet;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.ApplicabilityRule;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.core.planning.PlanningTableImpl;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ApplicabilityRuleHandler extends AbstractTableItemHandler implements Handler {
	public ApplicabilityRuleHandler() {
		super();
		validParents = new HashSet<Class<?>>();
		validPeers = new HashSet<Class<?>>();
		super.validParents.add(null);
		super.validParents.add(PlanningTableImpl.class);
		super.validPeers.add(null);
		super.validPeers.add(PlanningTableImpl.class);
		super.validPeers.add(DiscretionaryItemImpl.class);
		super.validPeers.add(ApplicabilityRule.class);
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		ApplicabilityRule rule = new ApplicabilityRule();
		rule.setElementId(attrs.getValue("id"));
		rule.setContextRef(attrs.getValue("contextRef"));
		PlanningTableImpl parent = (PlanningTableImpl) parser.getParent();
		parent.addOwnedApplicabilityRule(rule);
		return rule;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		Element el = parser.endElementBuilder();
		ApplicabilityRule rule = (ApplicabilityRule) parser.getCurrent();
		rule.setCondition(ConstraintExtractor.extractExpression(el, "condition"));
		return rule;
	}

	@Override
	public Class<?> generateNodeFor() {
		return ApplicabilityRule.class;
	}

}
