package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.common.impl.PlanItemStandardEventNode;
import org.jbpm.cmmn.flow.definition.StartTrigger;
import org.jbpm.cmmn.flow.definition.TimerEventListener;
import org.jbpm.cmmn.flow.definition.impl.PlanItemStartTriggerImpl;
import org.jbpm.cmmn.flow.planitem.CaseFileItemOnPart;
import org.jbpm.cmmn.flow.planitem.OnPart;
import org.jbpm.cmmn.flow.planitem.PlanItemOnPart;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.cmmn.flow.planitem.impl.PlanItemOnPartImpl;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.HashSet;

public class PlanItemOnPartHandler extends BaseAbstractHandler implements Handler {
	public PlanItemOnPartHandler() {
		super.validParents = new HashSet<Class<?>>();
		validParents.add(Sentry.class);
		validParents.add(TimerEventListener.class);
		super.validParents.add(Sentry.class);
		super.validPeers = new HashSet<Class<?>>();
		validPeers.add(PlanItemOnPart.class);
		validPeers.add(CaseFileItemOnPart.class);
		validPeers.add(null);

	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		PlanItemStandardEventNode part = localName.equals("planItemOnPart") ? new PlanItemOnPartImpl() : new PlanItemStartTriggerImpl();
		part.setName(attrs.getValue("id"));
		part.setId(IdGenerator.getIdAsUniqueAsUuid(parser, part));
		part.setSourceRef(IdGenerator.toXmlId(attrs.getValue("sourceRef")));

		Object parent = parser.getParent();
		if (parent instanceof Sentry) {
			((Sentry) parent).addOnPart((OnPart) part);
		} else {
			((TimerEventListener) parent).setStartTrigger((StartTrigger) part);
		}
		return part;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		PlanItemStandardEventNode part = (PlanItemStandardEventNode) parser.getCurrent();
		NodeList elementsByTagName = parser.endElementBuilder().getElementsByTagName("standardEvent");
		part.setStandardEvent(PlanItemTransition.resolveByName(elementsByTagName.item(0).getFirstChild().getNodeValue()));
		return parser.getCurrent();
	}

	@Override
	public Class<?> generateNodeFor() {
		return PlanItemOnPartImpl.class;
	}

}
