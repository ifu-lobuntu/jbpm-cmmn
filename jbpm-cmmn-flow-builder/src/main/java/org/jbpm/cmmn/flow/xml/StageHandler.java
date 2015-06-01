package org.jbpm.cmmn.flow.xml;

import java.util.HashSet;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.PlanItem;
import org.jbpm.cmmn.flow.core.event.TimerEvent;
import org.jbpm.cmmn.flow.core.event.UserEvent;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.Milestone;
import org.jbpm.cmmn.flow.core.impl.Stage;
import org.jbpm.cmmn.flow.core.planitem.PlanItemInfoImpl;
import org.jbpm.cmmn.flow.core.planitem.SentryImpl;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.core.planning.PlanningTableImpl;
import org.jbpm.cmmn.flow.core.task.CaseTask;
import org.jbpm.cmmn.flow.core.task.HumanTask;
import org.jbpm.process.core.context.variable.Variable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class StageHandler extends PlanItemContainerHandler implements PlanItemDefinitionHandlerDelegate{
	public StageHandler() {
		this.validParents = new HashSet<Class<?>>();
		this.validParents.add(CaseImpl.class);
		this.validParents.add(Stage.class);

		this.validPeers = new HashSet<Class<?>>();
		this.validPeers.add(null);
		this.validPeers.add(SentryImpl.class);
		this.validPeers.add(PlanItemInfoImpl.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(HumanTask.class);
		this.validPeers.add(Variable.class);
		this.validPeers.add(CaseRole.class);
		this.validPeers.add(CaseTask.class);
		this.validPeers.add(Variable.class);
		this.validPeers.add(Stage.class);
		this.validPeers.add(Milestone.class);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(UserEvent.class);
		this.validPeers.add(TimerEvent.class);
		this.validPeers.add(PlanItemInfoImpl.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(DiscretionaryItemImpl.class);
		this.validPeers.add(PlanningTableImpl.class);
	}

	@Override
	public Class<?> generateNodeFor() {
		return Stage.class;
	}

	@Override
	public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser parser) throws SAXException {
		parser.startElementBuilder(localName, attrs);
		Stage node = new Stage();
		node.setElementId(attrs.getValue("id"));
		node.setAutoComplete("true".equals(attrs.getValue("autoComplete")));
		node.setName(attrs.getValue("name"));
		node.setId(IdGenerator.getIdAsUniqueAsUuid(parser, node));
		CaseImpl theCase = (CaseImpl) parser.getParent(CaseImpl.class);
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
