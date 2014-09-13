package org.jbpm.cmmn.flow.xml;

import java.util.Collection;
import java.util.Map.Entry;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.ApplicabilityRule;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.PlanItem;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.event.TimerEvent;
import org.jbpm.cmmn.flow.core.event.UserEvent;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.Milestone;
import org.jbpm.cmmn.flow.core.impl.Stage;
import org.jbpm.cmmn.flow.core.planitem.PlanItemInfoImpl;
import org.jbpm.cmmn.flow.core.planitem.SentryImpl;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.core.planning.PlanningTableImpl;
import org.jbpm.cmmn.flow.core.planning.TableItemImpl;
import org.jbpm.cmmn.flow.core.task.CaseTask;
import org.jbpm.cmmn.flow.core.task.HumanTask;
import org.jbpm.process.core.context.variable.Variable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class PlanningTableHandler extends AbstractTableItemHandler implements Handler {
	public PlanningTableHandler() {
		super();
		this.validParents.add(null);
		this.validParents.add(CaseImpl.class);
		this.validParents.add(HumanTask.class);
		this.validParents.add(PlanningTableImpl.class);
		this.validParents.add(Stage.class);
		this.validPeers.add(null);
		this.validPeers.add(PlanningTableImpl.class);
		this.validPeers.add(DiscretionaryItemImpl.class);
		this.validPeers.add(ApplicabilityRule.class);
		this.validPeers.add(SentryImpl.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(HumanTask.class);
		this.validPeers.add(CaseTask.class);
		this.validPeers.add(Variable.class);
		this.validPeers.add(CaseRole.class);
		this.validPeers.add(Stage.class);
		this.validPeers.add(Milestone.class);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(UserEvent.class);
		this.validPeers.add(TimerEvent.class);
		this.validPeers.add(PlanItemInfoImpl.class);
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
			if (parent instanceof Stage) {
				((Stage) parent).setPlanningTable(table);
			} else if (parent instanceof CaseImpl) {
				((CaseImpl) parent).setPlanningTable(table);
			} else if (parent instanceof HumanTask) {
				((HumanTask) parent).setPlanningTable(table);
			}
			table.setPlanItemContainer((PlanItemContainer) parent);
		}
		return table;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		PlanningTableImpl table = (PlanningTableImpl) parser.getCurrent();
		Collection<ApplicabilityRule> applicabilityRules = table.getOwnedApplicabilityRules();
		for (TableItemImpl ti : table.getTableItems()) {
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
		return PlanningTableImpl.class;
	}

}
