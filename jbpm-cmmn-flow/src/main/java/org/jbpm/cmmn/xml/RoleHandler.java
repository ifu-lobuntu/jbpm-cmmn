package org.jbpm.cmmn.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class RoleHandler extends AbstractCaseElementHandler implements Handler {

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		CaseRole role = new CaseRole();
		role.setElementId(attrs.getValue("id"));
		role.setName(attrs.getValue("name"));
		CaseImpl process = (CaseImpl) parser.getParent();
		process.addRole(role);
		parser.getParent();
		return role;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		return parser.getCurrent();
	}

	@Override
	public Class<?> generateNodeFor() {
		return CaseRole.class;
	}

}
