package org.jbpm.cmmn.flow.xml;

import java.util.HashSet;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.planning.ApplicabilityRule;
import org.jbpm.cmmn.flow.planning.ApplicabilityRuleImpl;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.planning.impl.PlanningTableImpl;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ApplicabilityRuleHandler extends AbstractTableItemHandler implements Handler {
	public ApplicabilityRuleHandler() {
		super();
		validParents = new HashSet<Class<?>>();
		validPeers = new HashSet<Class<?>>();
		super.validParents.add(null);
		super.validParents.add(PlanningTable.class);
		super.validPeers.add(null);
		super.validPeers.add(PlanningTable.class);
		super.validPeers.add(DiscretionaryItem.class);
		super.validPeers.add(ApplicabilityRule.class);
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		ApplicabilityRuleImpl rule = new ApplicabilityRuleImpl();
		rule.setElementId(attrs.getValue("id"));
		rule.setContextRef(IdGenerator.toXmlId(attrs.getValue("contextRef")));
		PlanningTableImpl parent = (PlanningTableImpl) parser.getParent();
		parent.addOwnedApplicabilityRule(rule);
		return rule;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		Element el = parser.endElementBuilder();
		ApplicabilityRuleImpl rule = (ApplicabilityRuleImpl) parser.getCurrent();
		rule.setCondition(ConstraintExtractor.extractExpression(el, "condition"));
		return rule;
	}

	@Override
	public Class<?> generateNodeFor() {
		return ApplicabilityRuleImpl.class;
	}

}
