package org.jbpm.cmmn.flow.xml;

import java.util.HashSet;

import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.planning.TableItemImpl;
import org.xml.sax.Attributes;

public abstract class AbstractTableItemHandler extends BaseAbstractHandler implements Handler {

	public AbstractTableItemHandler() {
		super();
		validParents = new HashSet<Class<?>>();
		validPeers = new HashSet<Class<?>>();
		validPeers.add(null);
	}

	protected void populateCommonItems(Attributes attrs, TableItemImpl item) {
		item.setElementId(attrs.getValue("id"));
		String authRoles = attrs.getValue("authorizedRoleRefs");
		if (authRoles != null) {
			String[] split = authRoles.split("\\ ");
			for (String string : split) {
				item.putAuthorizedRole(string, null);
			}
		}
		String applicabilityRuleRefs = attrs.getValue("applicabilityRuleRefs");
		if (applicabilityRuleRefs != null) {
			String[] split = applicabilityRuleRefs.split("\\ ");
			for (String string : split) {
				item.putApplicabilityRule(string, null);
			}
		}
	}

}