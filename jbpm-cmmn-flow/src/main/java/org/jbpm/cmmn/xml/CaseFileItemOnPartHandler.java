package org.jbpm.cmmn.xml;

import java.util.HashSet;

import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.CaseFileItemTransition;
import org.jbpm.cmmn.flow.core.event.CaseFileItemStartTrigger;
import org.jbpm.cmmn.flow.core.event.TimerEvent;
import org.jbpm.cmmn.flow.core.planitem.CaseFileItemOnPart;
import org.jbpm.cmmn.flow.core.planitem.SentryImpl;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class CaseFileItemOnPartHandler extends BaseAbstractHandler implements Handler {
	public CaseFileItemOnPartHandler() {
		super.validParents = new HashSet<Class<?>>();
		validParents.add(SentryImpl.class);
		validParents.add(TimerEvent.class);
		super.validParents.add(SentryImpl.class);
		super.validPeers = new HashSet<Class<?>>();
		validPeers.add(CaseFileItemOnPart.class);
		validPeers.add(CaseFileItemStartTrigger.class);
		validPeers.add(null);

	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		CaseFileItemOnPart part = null;
		if (localName.equals("caseFileItemStartTrigger")) {
			part = new CaseFileItemStartTrigger();
		} else {
			part = new CaseFileItemOnPart();
		}
		part.setName(attrs.getValue("id"));
		part.setId(IdGenerator.getIdAsUniqueAsUuid(parser, part));
		Object parent = parser.getParent();
		if (parent instanceof SentryImpl) {
			((SentryImpl) parent).addOnPart(part);
		} else {
			((TimerEvent) parent).setStartTrigger((CaseFileItemStartTrigger) part);
		}
		part.setSourceRef(attrs.getValue("sourceRef"));
		part.setRelationRef(attrs.getValue("relationRef"));
		return part;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		CaseFileItemOnPart part = (CaseFileItemOnPart) parser.getCurrent();
		NodeList standardEvents = parser.endElementBuilder().getElementsByTagName("standardEvent");
		part.setStandardEvent(CaseFileItemTransition.resolveByName(standardEvents.item(0).getFirstChild().getNodeValue()));
		return parser.getCurrent();
	}

	@Override
	public Class<?> generateNodeFor() {
		return CaseFileItemOnPart.class;
	}

}
