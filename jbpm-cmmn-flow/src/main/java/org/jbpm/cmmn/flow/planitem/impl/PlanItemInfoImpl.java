package org.jbpm.cmmn.flow.planitem.impl;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.common.impl.PlanItemInstanceFactoryNodeImpl;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.definition.PlanItemControl;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.RepeatablePlanItemDefinition;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.PlanItemInfo;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.workflow.core.Node;
import org.jbpm.workflow.core.impl.ConnectionImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class was a workaround for the parallel inheritance trees between PlanItems and PlanItemDefinitions. This problem has been addressed and we need to absorb this class into PlanItemImpl
 */
@Deprecated
public class PlanItemInfoImpl<T extends PlanItemDefinition> implements PlanItemInfo<T>{
	private Map<String, Sentry> entryCriteria = new HashMap<String, Sentry>();
	private Map<String, Sentry> exitCriteria = new HashMap<String, Sentry>();
	private String definitionRef;
	private PlanItem<T> planItem;
	private T definition;
	private String elementId;
	private String name;
	private long id;
	private PlanItemContainer nodeContainer;
	private PlanItemControl itemControl;

	public PlanItemInfoImpl() {
	}

	@Override
	public Map<String, Sentry> getEntryCriteria() {
		return Collections.unmodifiableMap(entryCriteria);
	}

	@Override
	public Map<String, Sentry> getExitCriteria() {
		return Collections.unmodifiableMap(exitCriteria);
	}

	public void putEntryCriterion(String s, Sentry c) {
		entryCriteria.put(s, c);
	}

	public void putExitCriterion(String s, Sentry c) {
		exitCriteria.put(s, c);
	}

	private PlanItemInstanceFactoryNodeImpl createFactoryNodeIfRequired() {
		if (planItem.getDefinition() instanceof RepeatablePlanItemDefinition) {
			PlanItemInstanceFactoryNodeImpl result = new PlanItemInstanceFactoryNodeImpl();
			result.setId(id / 34123);
			result.setName(getName() + "Factory");
			return result;
		}else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public PlanItem<T> buildPlanItem() {
		planItem = (PlanItem<T>) new PlanItemImpl(this, createFactoryNodeIfRequired());
        planItem.setPlanItemContainer(nodeContainer); // possible duplication here of setNodeContainer
		planItem.setElementId(getElementId());
		planItem.setName(getName());
		planItem.setId(id);
		nodeContainer.addNode(planItem);
		if (planItem.getDefinition() instanceof RepeatablePlanItemDefinition) {
			nodeContainer.addNode(planItem.getFactoryNode());
			planItem.getFactoryNode().setItemToInstantiate((ItemWithDefinition<? extends RepeatablePlanItemDefinition>) planItem);
		}
		return planItem;
	}

	public void linkPlanItem() {
		Set<Entry<String, Sentry>> entrySet = entryCriteria.entrySet();
		for (Entry<String, Sentry> entry : entrySet) {
			((SentryImpl) entry.getValue()).setPlanItemEntering(this.planItem);
			if (planItem.getDefinition() instanceof RepeatablePlanItemDefinition) {
				new ConnectionImpl(entry.getValue(), Node.CONNECTION_DEFAULT_TYPE, planItem.getFactoryNode(),
						Node.CONNECTION_DEFAULT_TYPE);
			} else {
				new ConnectionImpl(entry.getValue(), Node.CONNECTION_DEFAULT_TYPE, planItem, Node.CONNECTION_DEFAULT_TYPE);
			}
		}
		Set<Entry<String, Sentry>> exitSet = exitCriteria.entrySet();
		for (Entry<String, Sentry> entry : exitSet) {
			((SentryImpl) entry.getValue()).setPlanItemExiting(this.planItem);
		}
		if (planItem.getDefinition() instanceof RepeatablePlanItemDefinition) {
			new ConnectionImpl(planItem.getFactoryNode(), Node.CONNECTION_DEFAULT_TYPE, planItem, Node.CONNECTION_DEFAULT_TYPE);
		}
	}

	public String getDefinitionRef() {
		return definitionRef;
	}

	public void setDefinitionRef(String definitionRef) {
		this.definitionRef = definitionRef;
	}

	public void setDefinition(T findPlanItemDefinition) {
		this.definition = findPlanItemDefinition;
	}

	@Override
	public T getDefinition() {
		return definition;
	}

	public void setElementId(String value) {
		this.elementId = value;
	}

	public String getElementId() {
		return elementId;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return name;
	}

	public void setId(long next) {
		this.id = next;
	}

	public void setContainer(PlanItemContainer nodeContainer) {
		this.nodeContainer = nodeContainer;
		nodeContainer.addPlanItemInfo(this);
	}

	public PlanItemControl getItemControl() {
		if (itemControl == null && definition != null) {
			return definition.getDefaultControl();
		}
		return itemControl;
	}

	public void setItemControl(PlanItemControl itemControl) {
		this.itemControl = itemControl;
	}
}
