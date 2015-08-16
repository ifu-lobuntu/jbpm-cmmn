package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.datatypes.CollectionDataType;
import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.common.impl.CaseFileItemStandardEventNodeImpl;
import org.jbpm.cmmn.flow.common.impl.PlanItemStandardEventNode;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.impl.CaseFileItemImpl;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.DefaultJoin;
import org.jbpm.cmmn.flow.core.impl.DefaultSplit;
import org.jbpm.cmmn.flow.definition.RepeatablePlanItemDefinition;
import org.jbpm.cmmn.flow.definition.TimerEventListener;
import org.jbpm.cmmn.flow.definition.impl.CaseFileItemStartTriggerImpl;
import org.jbpm.cmmn.flow.definition.impl.PlanItemStartTriggerImpl;
import org.jbpm.cmmn.flow.planitem.OnPart;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.impl.PlanItemImpl;
import org.jbpm.cmmn.flow.planitem.impl.SentryImpl;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.process.core.context.variable.Variable;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.workflow.core.impl.ConnectionImpl;
import org.jbpm.workflow.core.node.EndNode;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.core.node.Split;
import org.jbpm.workflow.core.node.StartNode;
import org.kie.api.definition.process.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class PlanItemContainerHandler extends BaseAbstractHandler {

	protected static String DEFAULT = org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE;

	public PlanItemContainerHandler() {
		super();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void linkPlanItems(PlanItemContainer container, ExtensibleXmlParser p, VariableScope variableScope) {
		Split defaultSplit = container.getDefaultSplit();
		EndNode defaultEnd = container.getDefaultEnd();
		defaultEnd.setTerminate(container instanceof CaseImpl);
		for (PlanItem<?> pi : container.getPlanItems()) {
			PlanItemImpl pii = (PlanItemImpl) pi;
			pii.setDefinition(container.getCase().getPlanItemDefinition(pii.getDefinitionRef()));
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
		for (String string : new ArrayList<String>(node.getEntryCriteria().keySet())) {
			SentryImpl entry = findSentry(process, string);
			((PlanItemImpl<?>) node).putEntryCriterion(string, entry);
		}
		for (String string : new ArrayList<String>(node.getExitCriteria().keySet())) {
			SentryImpl exit = findSentry(process, string);
			((PlanItemImpl<?>) node).putExitCriterion(string, exit);
		}
		((PlanItemImpl<?>) node).linkPlanItem();
		if (node.getEntryCriteria().isEmpty()) {
			if (node.getDefinition() instanceof RepeatablePlanItemDefinition) {
				new ConnectionImpl(process.getDefaultSplit(), DEFAULT, node.getFactoryNode(), DEFAULT);
			} else if (node.getDefinition() instanceof TimerEventListener) {
				TimerEventListener tel = (TimerEventListener) node.getDefinition();
				if (tel.getStartTrigger() != null) {
					if (tel.getStartTrigger() instanceof CaseFileItemStartTriggerImpl) {
						CaseFileItemStartTriggerImpl startTrigger = (CaseFileItemStartTriggerImpl) tel.getStartTrigger();
						startTrigger.setSourceCaseFileItem(findCaseFileItemById(process.getCase().getVariableScope(), startTrigger.getSourceRef()));
					} else if (tel.getStartTrigger() instanceof PlanItemStartTriggerImpl) {
						PlanItemStartTriggerImpl startTrigger = (PlanItemStartTriggerImpl) tel.getStartTrigger();
						startTrigger.setSourcePlanItem(findPlanItem(process, startTrigger.getSourceRef()));
					}
					AbstractStandardEventNode copy = ((AbstractStandardEventNode) tel.getStartTrigger()).copy();
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
		for (OnPart onPart : sentry.getOnParts()) {
			new ConnectionImpl(process.getDefaultSplit(), DEFAULT, onPart, DEFAULT);
			if (onPart instanceof PlanItemStandardEventNode) {
				PlanItemStandardEventNode apip = (PlanItemStandardEventNode) onPart;
				apip.setSourcePlanItem(findPlanItem(process, apip.getSourceRef()));
			} else {
				CaseFileItemStandardEventNodeImpl ocfip = (CaseFileItemStandardEventNodeImpl) onPart;
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

	protected CaseFileItemImpl findCaseFileItemById(VariableScope variableScope, String caseFileItemId) {
		CaseFileItemImpl binding = null;
		if (caseFileItemId != null) {
			List<Variable> variables = variableScope.getVariables();
			for (Variable variable : variables) {
				if (variable instanceof CaseFileItem) {
					if (((CaseFileItem) variable).getElementId().equals(caseFileItemId)) {
						binding = (CaseFileItemImpl) variable;
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