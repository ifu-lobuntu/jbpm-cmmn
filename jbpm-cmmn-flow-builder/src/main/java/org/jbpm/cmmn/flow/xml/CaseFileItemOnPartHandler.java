package org.jbpm.cmmn.flow.xml;

import java.util.HashSet;

import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.common.impl.CaseFileItemStandardEventNodeImpl;
import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.flow.definition.CaseFileItemStartTrigger;
import org.jbpm.cmmn.flow.definition.StartTrigger;
import org.jbpm.cmmn.flow.definition.TimerEventListener;
import org.jbpm.cmmn.flow.definition.impl.CaseFileItemStartTriggerImpl;
import org.jbpm.cmmn.flow.planitem.CaseFileItemOnPart;
import org.jbpm.cmmn.flow.planitem.OnPart;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.cmmn.flow.planitem.impl.CaseFileItemOnPartImpl;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class CaseFileItemOnPartHandler extends BaseAbstractHandler implements Handler {
	public CaseFileItemOnPartHandler() {
		super.validParents = new HashSet<Class<?>>();
		validParents.add(Sentry.class);
		validParents.add(TimerEventListener.class);
		super.validParents.add(Sentry.class);
		super.validPeers = new HashSet<Class<?>>();
		validPeers.add(CaseFileItemOnPart.class);
		validPeers.add(CaseFileItemStartTrigger.class);
		validPeers.add(null);

	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		CaseFileItemStandardEventNodeImpl part = null;
		if (localName.equals("caseFileItemStartTrigger")) {
			part = new CaseFileItemStartTriggerImpl();
		} else {
			part = new CaseFileItemOnPartImpl();
		}
		part.setName(attrs.getValue("id"));
		part.setId(IdGenerator.getIdAsUniqueAsUuid(parser, part));
		Object parent = parser.getParent();
		if (parent instanceof Sentry) {
			((Sentry) parent).addOnPart((OnPart) part);
		} else {
			((TimerEventListener) parent).setStartTrigger((StartTrigger) part);
		}
		part.setSourceRef(IdGenerator.toXmlId(attrs.getValue("sourceRef")));
		part.setRelationRef(IdGenerator.toXmlId(attrs.getValue("relationRef")));
		return part;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		CaseFileItemStandardEventNodeImpl part = (CaseFileItemStandardEventNodeImpl) parser.getCurrent();
		NodeList standardEvents = parser.endElementBuilder().getElementsByTagName("standardEvent");
		part.setStandardEvent(CaseFileItemTransition.resolveByName(standardEvents.item(0).getFirstChild().getNodeValue()));
		return parser.getCurrent();
	}

	@Override
	public Class<?> generateNodeFor() {
		return CaseFileItemOnPartImpl.class;
	}

}
