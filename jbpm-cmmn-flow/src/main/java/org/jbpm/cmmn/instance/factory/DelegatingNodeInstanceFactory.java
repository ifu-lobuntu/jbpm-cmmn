package org.jbpm.cmmn.instance.factory;

import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.impl.*;
import org.jbpm.cmmn.instance.impl.*;
import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.jbpm.workflow.instance.impl.NodeInstanceFactory;
import org.jbpm.workflow.instance.impl.factory.CreateNewNodeFactory;
import org.jbpm.workflow.instance.impl.factory.ReuseNodeFactory;
import org.kie.api.definition.process.Node;
import org.kie.api.runtime.process.NodeInstance;

import java.util.HashMap;
import java.util.Map;

public final class DelegatingNodeInstanceFactory implements NodeInstanceFactory {
	Map<Class<?>, NodeInstanceFactory> registry = new HashMap<Class<?>, NodeInstanceFactory>();

	public DelegatingNodeInstanceFactory() {
		registry.put(UserEventListenerImpl.class, new ReuseNodeFactory(UserEventInstance.class));
		registry.put(TimerEventListenerImpl.class, new ReuseNodeFactory(TimerEventInstance.class));
		registry.put(MilestoneImpl.class, new CreateNewNodeFactory(MilestoneInstance.class));
		registry.put(StageImpl.class, new CreateNewNodeFactory(StageInstance.class));
		registry.put(HumanTaskDefinitionImpl.class, new CreateNewNodeFactory(HumanTaskInstance.class));
		registry.put(CaseTaskDefinitionImpl.class, new CreateNewNodeFactory(CaseTaskInstance.class));
	}

	@Override
	public NodeInstance getNodeInstance(Node node, WorkflowProcessInstance processInstance,
			org.kie.api.runtime.process.NodeInstanceContainer nodeInstanceContainer) {
		ItemWithDefinition<?> di = (ItemWithDefinition<?>) node;
		return registry.get(di.getDefinition().getClass()).getNodeInstance(node, processInstance, nodeInstanceContainer);
	}

	public void addDelegate(Class<? extends PlanItemDefinition> d, NodeInstanceFactory f) {
		registry.put(d, f);
	}
}