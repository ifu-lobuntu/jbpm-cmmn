package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.PlanItemDefinition;
import org.jbpm.cmmn.flow.core.event.TimerEvent;
import org.jbpm.cmmn.flow.core.event.UserEvent;
import org.jbpm.cmmn.flow.core.impl.Milestone;
import org.jbpm.cmmn.flow.core.impl.PlanItemControlImpl;
import org.jbpm.cmmn.flow.core.planitem.PlanItemInfoImpl;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.core.task.CaseTask;
import org.jbpm.cmmn.flow.core.task.HumanTask;
import org.jbpm.cmmn.flow.core.task.ParameterMapping;
import org.jbpm.workflow.core.impl.ConstraintImpl;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class PlanItemControlHandler extends AbstractCaseElementHandler implements Handler {
	public PlanItemControlHandler() {
		super();
		super.validParents.add(PlanItemInfoImpl.class);
		super.validParents.add(HumanTask.class);
		super.validParents.add(CaseTask.class);
		super.validParents.add(UserEvent.class);
		super.validParents.add(TimerEvent.class);
		super.validParents.add(Milestone.class);
		super.validParents.add(DiscretionaryItemImpl.class);
		super.validPeers.add(null);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(ParameterMapping.class);
		this.validPeers.add(PlanItemControlImpl.class);

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
