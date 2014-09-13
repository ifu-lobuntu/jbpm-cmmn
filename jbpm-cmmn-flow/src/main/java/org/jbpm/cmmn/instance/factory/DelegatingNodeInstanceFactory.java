package org.jbpm.cmmn.instance.factory;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.cmmn.flow.core.ItemWithDefinition;
import org.jbpm.cmmn.flow.core.PlanItemDefinition;
import org.jbpm.cmmn.flow.core.event.TimerEvent;
import org.jbpm.cmmn.flow.core.event.UserEvent;
import org.jbpm.cmmn.flow.core.impl.Milestone;
import org.jbpm.cmmn.flow.core.impl.Stage;
import org.jbpm.cmmn.flow.core.task.CaseTask;
import org.jbpm.cmmn.flow.core.task.HumanTask;
import org.jbpm.cmmn.instance.impl.CaseTaskInstance;
import org.jbpm.cmmn.instance.impl.HumanTaskInstance;
import org.jbpm.cmmn.instance.impl.MilestoneInstance;
import org.jbpm.cmmn.instance.impl.StageInstance;
import org.jbpm.cmmn.instance.impl.TimerEventInstance;
import org.jbpm.cmmn.instance.impl.UserEventInstance;
import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.jbpm.workflow.instance.impl.NodeInstanceFactory;
import org.jbpm.workflow.instance.impl.factory.CreateNewNodeFactory;
import org.jbpm.workflow.instance.impl.factory.ReuseNodeFactory;
import org.kie.api.definition.process.Node;
import org.kie.api.runtime.process.NodeInstance;

public final class DelegatingNodeInstanceFactory implements NodeInstanceFactory {
	Map<Class<?>, NodeInstanceFactory> registry = new HashMap<Class<?>, NodeInstanceFactory>();

	public DelegatingNodeInstanceFactory() {
		registry.put(UserEvent.class, new ReuseNodeFactory(UserEventInstance.class));
		registry.put(TimerEvent.class, new ReuseNodeFactory(TimerEventInstance.class));
		registry.put(Milestone.class, new CreateNewNodeFactory(MilestoneInstance.class));
		registry.put(Stage.class, new CreateNewNodeFactory(StageInstance.class));
		registry.put(HumanTask.class, new CreateNewNodeFactory(HumanTaskInstance.class));
		registry.put(CaseTask.class, new CreateNewNodeFactory(CaseTaskInstance.class));
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