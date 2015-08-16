package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.definition.*;
import org.jbpm.cmmn.flow.definition.impl.StageImpl;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.process.core.context.variable.Variable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.HashSet;

public class StageHandler extends PlanItemContainerHandler implements PlanItemDefinitionHandlerDelegate{
	public StageHandler() {
		this.validParents = new HashSet<Class<?>>();
		this.validParents.add(Case.class);
		this.validParents.add(Stage.class);

		this.validPeers = new HashSet<Class<?>>();
		this.validPeers.add(null);
		this.validPeers.add(Sentry.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(HumanTaskDefinition.class);
		this.validPeers.add(Variable.class);
		this.validPeers.add(CaseRole.class);
		this.validPeers.add(CaseTaskDefinition.class);
		this.validPeers.add(Variable.class);
		this.validPeers.add(Stage.class);
		this.validPeers.add(Milestone.class);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(UserEventListener.class);
		this.validPeers.add(TimerEventListener.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(DiscretionaryItem.class);
		this.validPeers.add(PlanningTable.class);
	}

	@Override
	public Class<?> generateNodeFor() {
		return Stage.class;
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		StageImpl node = new StageImpl();
		node.setElementId(attrs.getValue("id"));
		node.setAutoComplete("true".equals(attrs.getValue("autoComplete")));
		node.setName(attrs.getValue("name"));
		node.setId(IdGenerator.getIdAsUniqueAsUuid(parser, node));
		CaseImpl theCase = (CaseImpl) parser.getParent(Case.class);
		theCase.addPlanItemDefinition(node);
		super.startNodeContainer(node, parser);
		return node;
	}

	@Override
	public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
		parser.endElementBuilder();
		return parser.getCurrent();
	}

}
