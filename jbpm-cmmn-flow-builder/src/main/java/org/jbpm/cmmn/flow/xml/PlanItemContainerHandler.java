package org.jbpm.cmmn.flow.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.drools.core.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.datatypes.CollectionDataType;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.PlanItem;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.PlanItemInfo;
import org.jbpm.cmmn.flow.core.event.CaseFileItemStartTrigger;
import org.jbpm.cmmn.flow.core.event.PlanItemStartTrigger;
import org.jbpm.cmmn.flow.core.event.TimerEvent;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.DefaultJoin;
import org.jbpm.cmmn.flow.core.impl.DefaultSplit;
import org.jbpm.cmmn.flow.core.planitem.AbstractOnPart;
import org.jbpm.cmmn.flow.core.planitem.CaseFileItemOnPart;
import org.jbpm.cmmn.flow.core.planitem.MultiInstancePlanItem;
import org.jbpm.cmmn.flow.core.planitem.PlanItemInfoImpl;
import org.jbpm.cmmn.flow.core.planitem.PlanItemOnPart;
import org.jbpm.cmmn.flow.core.planitem.SentryImpl;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.process.core.context.variable.Variable;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.workflow.core.impl.ConnectionImpl;
import org.jbpm.workflow.core.node.EndNode;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.core.node.Split;
import org.jbpm.workflow.core.node.StartNode;
import org.kie.api.definition.process.Node;

public abstract class PlanItemContainerHandler extends BaseAbstractHandler {

	protected static String DEFAULT = org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE;

	public PlanItemContainerHandler() {
		super();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void linkPlanItems(PlanItemContainer container, ExtensibleXmlParser p) {
		VariableScope variableScope = container.getCase().getVariableScope();
		Split defaultSplit = container.getDefaultSplit();
		EndNode defaultEnd = container.getDefaultEnd();
		defaultEnd.setTerminate(container instanceof CaseImpl);
		for (PlanItemInfo<?> pi : container.getPlanItemInfo()) {
			PlanItemInfoImpl pii = (PlanItemInfoImpl) pi;
			pii.setDefinition(container.getCase().getPlanItemDefinition(pii.getDefinitionRef()));
			pii.buildPlanItem();
		}
		DefaultJoin defaultJoin = new DefaultJoin();
		defaultJoin.setId(IdGenerator.next(p));
		defaultJoin.setType(Join.TYPE_AND);
		container.addNode(defaultJoin);
		container.setDefaultJoin(defaultJoin);
		new ConnectionImpl(defaultSplit, DEFAULT, defaultJoin, DEFAULT);
		new ConnectionImpl(container.getDefaultJoin(), DEFAULT, defaultEnd, DEFAULT);
		for (Node node : container.getNodes()) {
			if (node instanceof PlanItem) {
				linkPlanItemCriteria(container, (PlanItem) node);
			} else if (node instanceof SentryImpl) {
				// We need to activate sentries immediately to indicate that the associated PLanItem is available
				new ConnectionImpl(defaultSplit, DEFAULT, node, DEFAULT);
				linkSentryOnPart(container, variableScope, (SentryImpl) node);
			}
		}
		if(defaultSplit.getOutgoingConnections().size()==1){
			//HACK to get around empty containers - maybe should rather validate up front
			new ConnectionImpl(defaultSplit, DEFAULT, defaultJoin, DEFAULT);
		}
	}

	protected void linkDiscretionaryItemCriteria(PlanItemContainer process, DiscretionaryItemImpl<?> node) {
		for (String string : new ArrayList<String>(node.getEntryCriteria().keySet())) {
			SentryImpl entry = findSentry(process, string);
			node.putEntryCriterion(string, entry);
		}
		for (String string : new ArrayList<String>(node.getExitCriteria().keySet())) {
			SentryImpl exit = findSentry(process, string);
			node.putExitCriterion(string, exit);
		}
		node.linkItem();
		if (node.getEntryCriteria().isEmpty()) {
			process.addNode(node.getFactoryNode());
			new ConnectionImpl(process.getDefaultSplit(), DEFAULT, node.getFactoryNode(), DEFAULT);
		}
	}

	private void linkPlanItemCriteria(PlanItemContainer process, PlanItem<?> node) {
		if (process.getDefaultJoin() != null) {
			new ConnectionImpl(node, DEFAULT, process.getDefaultJoin(), DEFAULT);
		}
		for (String string : new ArrayList<String>(node.getPlanInfo().getEntryCriteria().keySet())) {
			SentryImpl entry = findSentry(process, string);
			((PlanItemInfoImpl<?>) node.getPlanInfo()).putEntryCriterion(string, entry);
		}
		for (String string : new ArrayList<String>(node.getPlanInfo().getExitCriteria().keySet())) {
			SentryImpl exit = findSentry(process, string);
			((PlanItemInfoImpl<?>) node.getPlanInfo()).putExitCriterion(string, exit);
		}
		((PlanItemInfoImpl<?>) node.getPlanInfo()).linkPlanItem();
		if (node.getPlanInfo().getEntryCriteria().isEmpty()) {
			if (node instanceof MultiInstancePlanItem) {
				new ConnectionImpl(process.getDefaultSplit(), DEFAULT, ((MultiInstancePlanItem) node).getFactoryNode(), DEFAULT);
			} else if (node.getDefinition() instanceof TimerEvent) {
				TimerEvent tel = (TimerEvent) node.getDefinition();
				if (tel.getStartTrigger() != null) {
					if (tel.getStartTrigger() instanceof CaseFileItemStartTrigger) {
						CaseFileItemStartTrigger startTrigger = (CaseFileItemStartTrigger) tel.getStartTrigger();
						startTrigger.setSourceCaseFileItem(findCaseFileItemById(process.getCase().getVariableScope(), startTrigger.getSourceRef()));
					} else if (tel.getStartTrigger() instanceof PlanItemStartTrigger) {
						PlanItemStartTrigger startTrigger = (PlanItemStartTrigger) tel.getStartTrigger();
						startTrigger.setSourcePlanItem(findPlanItem(process, startTrigger.getSourceRef()));
					}
					AbstractOnPart copy = ((AbstractOnPart) tel.getStartTrigger()).copy();
					process.addNode(copy);
					new ConnectionImpl(process.getDefaultSplit(), DEFAULT, copy, DEFAULT);
					new ConnectionImpl(copy, DEFAULT, node, DEFAULT);
				} else {
					new ConnectionImpl(process.getDefaultSplit(), DEFAULT, node, DEFAULT);
				}
			} else {
				new ConnectionImpl(process.getDefaultSplit(), DEFAULT, node, DEFAULT); // necessary at all?
			}
		}
	}

	private void linkSentryOnPart(PlanItemContainer process, VariableScope variableScope, SentryImpl sentry) {
		for (AbstractOnPart onPart : sentry.getOnParts()) {
			new ConnectionImpl(process.getDefaultSplit(), DEFAULT, onPart, DEFAULT);
			if (onPart instanceof PlanItemOnPart) {
				PlanItemOnPart apip = (PlanItemOnPart) onPart;
				apip.setSourcePlanItem(findPlanItem(process, apip.getSourceRef()));
			} else {
				CaseFileItemOnPart ocfip = (CaseFileItemOnPart) onPart;
				ocfip.setSourceCaseFileItem(findCaseFileItemById(variableScope, ocfip.getSourceRef()));
				ocfip.setRelatedCaseFileItem(findCaseFileItemById(variableScope, ocfip.getRelationRef()));
			}
			Variable var = new Variable();
			var.setName(onPart.getVariableName());
			CollectionDataType cdt = new CollectionDataType(Stack.class.getName());
			cdt.setElementClassName(onPart.getEventClassName());
			var.setType(cdt);

			variableScope.getVariables().add(var);
		}
	}

	protected CaseFileItem findCaseFileItemById(VariableScope variableScope, String caseFileItemId) {
		CaseFileItem binding = null;
		if (caseFileItemId != null) {
			List<Variable> variables = variableScope.getVariables();
			for (Variable variable : variables) {
				if (variable instanceof CaseFileItem) {
					if (((CaseFileItem) variable).getElementId().equals(caseFileItemId)) {
						binding = (CaseFileItem) variable;
						break;
					}
				}
			}
		}
		return binding;
	}

	private PlanItem<?> findPlanItem(PlanItemContainer process, String sourceRef) {
		for (Node node : process.getNodes()) {
			if (node instanceof PlanItem && ((PlanItem<?>) node).getElementId().equals(sourceRef)) {
				return (PlanItem<?>) node;
			}
		}
		return null;
	}

	private SentryImpl findSentry(PlanItemContainer process, String elementId) {
		Node[] nodes = process.getNodes();
		for (Node node : nodes) {
			if (node instanceof SentryImpl && ((SentryImpl) node).getElementId().equals(elementId)) {
				return (SentryImpl) node;
			}
		}
		return null;
	}

	protected void startNodeContainer(PlanItemContainer process, ExtensibleXmlParser p) {
		StartNode start = new StartNode();
		start.setId(IdGenerator.next(p));
		process.addNode(start);
		start.setName("defaultStart");
		process.setDefaultStart(start);
		DefaultSplit split = new DefaultSplit();
		split.setId(IdGenerator.next(p));
		process.addNode(split);
		split.setName("defaultSplit");
		process.setDefaultSplit(split);
		new ConnectionImpl(start, DEFAULT, split, DEFAULT);
		EndNode end = new EndNode();
		end.setName("defaultEnd");
		end.setId(IdGenerator.next(p));
		end.setTerminate(false);
		process.addNode(end);
		process.setDefaultEnd(end);
	}
}