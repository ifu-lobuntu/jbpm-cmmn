package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.definition.*;
import org.jbpm.cmmn.flow.definition.impl.HumanTaskDefinitionImpl;
import org.jbpm.cmmn.flow.definition.impl.StageImpl;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.cmmn.flow.planning.ApplicabilityRule;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.TableItem;
import org.jbpm.cmmn.flow.planning.impl.PlanningTableImpl;
import org.jbpm.process.core.context.variable.Variable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.Collection;
import java.util.Map.Entry;

public class PlanningTableHandler extends AbstractTableItemHandler implements Handler {
	public PlanningTableHandler() {
		super();
		this.validParents.add(null);
		this.validParents.add(Case.class);
		this.validParents.add(HumanTaskDefinition.class);
		this.validParents.add(PlanningTable.class);
		this.validParents.add(Stage.class);
		this.validPeers.add(null);
		this.validPeers.add(PlanningTable.class);
		this.validPeers.add(DiscretionaryItem.class);
		this.validPeers.add(ApplicabilityRule.class);
		this.validPeers.add(Sentry.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(HumanTaskDefinition.class);
		this.validPeers.add(CaseTaskDefinition.class);
		this.validPeers.add(Variable.class);
		this.validPeers.add(CaseRole.class);
		this.validPeers.add(Stage.class);
		this.validPeers.add(Milestone.class);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(UserEventListener.class);
		this.validPeers.add(TimerEventListener.class);
		this.validPeers.add(PlanItem.class);
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		PlanningTableImpl table = new PlanningTableImpl();
		super.populateCommonItems(attrs, table);
		table.setId(IdGenerator.getIdAsUniqueAsUuid(parser, table));
		Object parent = parser.getParent();
		if (parent instanceof PlanningTableImpl) {
			((PlanningTableImpl) parent).addTableItem(table);
		} else {
			if (parent instanceof StageImpl) {
				((StageImpl) parent).setPlanningTable(table);
	            table.setPlanningTableContainer((StageImpl) parent);
			} else if (parent instanceof CaseImpl) {
				((CaseImpl) parent).setPlanningTable(table);
	            table.setPlanningTableContainer((CaseImpl) parent);
			} else if (parent instanceof HumanTaskDefinitionImpl) {
				((HumanTaskDefinitionImpl) parent).setPlanningTable(table);
				table.setPlanningTableContainer(((HumanTaskDefinitionImpl) parent));
			}
		}
		return table;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		PlanningTableImpl table = (PlanningTableImpl) parser.getCurrent();
		Collection<ApplicabilityRule> applicabilityRules = table.getOwnedApplicabilityRules();
		for (TableItem ti : table.getTableItems()) {
			// TODO recursively? Check with OMG
			for (Entry<String, ApplicabilityRule> entry : ti.getApplicabilityRules().entrySet()) {
				for (ApplicabilityRule rule : applicabilityRules) {
					if (entry.getValue() == null && entry.getKey().equals(rule.getElementId())) {
						entry.setValue(rule);
						break;
					}
				}
			}
		}
		return table;
	}

	@Override
	public Class<?> generateNodeFor() {
		return PlanningTable.class;
	}

}
