package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.impl.CaseParameterImpl;
import org.jbpm.cmmn.flow.definition.*;
import org.jbpm.cmmn.flow.definition.impl.*;
import org.jbpm.cmmn.flow.core.impl.PlanItemControlImpl;
import org.jbpm.cmmn.flow.planitem.PlanItemInfo;
import org.jbpm.cmmn.flow.planitem.impl.PlanItemInfoImpl;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.definition.impl.HumanTaskDefinitionImpl;
import org.jbpm.workflow.core.impl.ConstraintImpl;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class PlanItemControlHandler extends AbstractCaseElementHandler implements Handler {
	public PlanItemControlHandler() {
		super();
		super.validParents.add(PlanItemInfo.class);
		super.validParents.add(HumanTaskDefinition.class);
		super.validParents.add(CaseTaskDefinition.class);
		super.validParents.add(ProcessTaskDefinition.class);
		super.validParents.add(UserEventListener.class);
		super.validParents.add(TimerEventListener.class);
		super.validParents.add(MilestoneImpl.class);
		super.validParents.add(DiscretionaryItem.class);
		super.validPeers.add(null);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(ParameterMapping.class);
		this.validPeers.add(PlanItemControl.class);

	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		PlanItemControlImpl planItemControl = new PlanItemControlImpl();
		planItemControl.setElementId(attrs.getValue("id"));
		Object parent = parser.getParent();
		if (parent instanceof PlanItemInfoImpl) {
			((PlanItemInfoImpl<?>) parent).setItemControl(planItemControl);
		} else if (parent instanceof PlanItemDefinition) {
			((PlanItemDefinition) parent).setDefaultControl(planItemControl);
		} else if (parent instanceof DiscretionaryItemImpl) {
			((DiscretionaryItemImpl<?>) parent).setItemControl(planItemControl);
		}
		return planItemControl;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		Element el = parser.endElementBuilder();
		PlanItemControlImpl planItemControl = (PlanItemControlImpl) parser.getCurrent();
		planItemControl.setManualActivationRule(extractRule(el, "manualActivationRule"));
		planItemControl.setRepetitionRule(extractRule(el, "repetitionRule"));
		planItemControl.setRequiredRule(extractRule(el, "requiredRule"));
		return parser.getCurrent();
	}

	protected ConstraintImpl extractRule(Element el, String epxressionElementName3) {
		NodeList elems = el.getElementsByTagName(epxressionElementName3);
		if (elems.getLength() == 1) {
			Element rule = (Element) elems.item(0);
			return ConstraintExtractor.extractExpression(rule, "condition");
		}
		return null;
	}

	@Override
	public Class<?> generateNodeFor() {
		return PlanItemControlImpl.class;
	}

}
