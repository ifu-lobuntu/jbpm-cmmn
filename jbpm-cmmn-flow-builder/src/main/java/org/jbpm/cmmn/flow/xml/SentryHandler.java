package org.jbpm.cmmn.flow.xml;

import java.util.Collection;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.definition.impl.StageImpl;
import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.planitem.OnPart;
import org.jbpm.cmmn.flow.planitem.impl.SentryImpl;
import org.jbpm.workflow.core.Node;
import org.jbpm.workflow.core.NodeContainer;
import org.jbpm.workflow.core.impl.ConnectionImpl;
import org.jbpm.workflow.core.impl.ConstraintImpl;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SentryHandler extends AbstractCaseElementHandler implements Handler {
	private static final String DEFAULT = Node.CONNECTION_DEFAULT_TYPE;

	public SentryHandler() {
		super.validPeers.add(SentryImpl.class);
		super.validParents.add(StageImpl.class);
	}

	@Override
	public Object start(final String uri, final String localName, final Attributes attrs, final ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		SentryImpl node = new SentryImpl();
		node.setElementId(attrs.getValue("id"));
		node.setName(attrs.getValue("name"));
		node.setId(IdGenerator.getIdAsUniqueAsUuid(parser, node));
		return node;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class generateNodeFor() {
		return SentryImpl.class;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		SentryImpl node = (SentryImpl) parser.getCurrent();
		Collection<OnPart> onParts = node.getOnParts();
		Element el = parser.endElementBuilder();
		ConstraintImpl constraint = maybeCreateConstraint(node, el);
		node.setCondition(constraint);
		NodeContainer parent = (NodeContainer) parser.getParent();
		parent.addNode(node);
		for (OnPart onPart : onParts) {
			new ConnectionImpl(onPart, DEFAULT, node, DEFAULT);
			parent.addNode(onPart);
		}
		return node;
	}

	protected ConstraintImpl maybeCreateConstraint(SentryImpl node, Element el) {
		NodeList ifPartList = el.getElementsByTagName("ifPart");
		ConstraintImpl result = null;
		if (ifPartList.getLength() == 1) {
			Element ifPart = (Element) ifPartList.item(0);
			String name = "condition";
			result = ConstraintExtractor.extractExpression(ifPart, name);
		}
		return result;
	}

	protected static String getDialect(Element condition) {
		String dialect = null;
		String language = condition.getAttribute("language");
		if (language == null) {
			language = "mvel";
		} else {
			language = language.toLowerCase();
		}
		if (language.endsWith("java")) {
			dialect = "java";
		} else if (language.endsWith("mvel")) {
			dialect = "mvel";
		} else if (language.endsWith("ocl")) {
			dialect = "ocl";
		} else if (language.endsWith("xpath")) {
			dialect = "xpath";
		} else {
			dialect = "mvel";
		}
		return dialect;
	}

}
