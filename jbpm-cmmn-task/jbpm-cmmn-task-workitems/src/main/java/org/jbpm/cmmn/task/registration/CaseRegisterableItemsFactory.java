package org.jbpm.cmmn.task.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.task.listeners.CaseTaskLifecycleListener;
import org.jbpm.cmmn.task.workitems.CaseTaskWorkItemHandler;
import org.jbpm.cmmn.task.workitems.UpdateTaskStatusWorkItemHandler;
import org.jbpm.runtime.manager.impl.DefaultRegisterableItemsFactory;
import org.jbpm.runtime.manager.impl.RuntimeEngineImpl;
import org.jbpm.services.task.wih.ExternalTaskEventListener;
import org.jbpm.services.task.wih.LocalHTWorkItemHandler;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.task.TaskLifeCycleEventListener;
import org.kie.internal.runtime.manager.Disposable;
import org.kie.internal.runtime.manager.DisposeListener;
import org.kie.internal.task.api.EventService;

public class CaseRegisterableItemsFactory extends DefaultRegisterableItemsFactory {
	private TaskLifeCycleEventListener lifecycleListener =new CaseTaskLifecycleListener();
	@SuppressWarnings({ "rawtypes" })
	@Override
	protected WorkItemHandler getHTWorkItemHandler(RuntimeEngine runtime) {
		LocalHTWorkItemHandler humanTaskHandler = new CaseTaskWorkItemHandler();
		humanTaskHandler.setRuntimeManager(((RuntimeEngineImpl) runtime).getManager());
		if (runtime instanceof Disposable) {
			((Disposable) runtime).addDisposeListener(new DisposeListener() {

				@Override
				public void onDispose(RuntimeEngine runtime) {
					if (runtime.getTaskService() instanceof EventService) {
						((EventService) runtime.getTaskService()).clearTaskEventListeners();
					}
				}
			});
		}
		return humanTaskHandler;
	}

	@Override
	public Map<String, WorkItemHandler> getWorkItemHandlers(RuntimeEngine runtime) {
		Map<String, WorkItemHandler> defaultHandlers = new HashMap<String, WorkItemHandler>();
		defaultHandlers.putAll(super.getWorkItemHandlers(runtime));
		UpdateTaskStatusWorkItemHandler stwih = new UpdateTaskStatusWorkItemHandler();
		stwih.setRuntimeManager(((RuntimeEngineImpl) runtime).getManager());
		defaultHandlers.put(WorkItemParameters.UPDATE_TASK_STATUS, stwih);
		return defaultHandlers;
	}
	@Override
	public List<TaskLifeCycleEventListener> getTaskListeners() {
		List<TaskLifeCycleEventListener> result = new ArrayList<TaskLifeCycleEventListener>();
		for (TaskLifeCycleEventListener listener : super.getTaskListeners()) {
			if(listener instanceof ExternalTaskEventListener){
				result.add(lifecycleListener);
			}else{
				result.add(listener);
			}
		}
		return result;
	}

}
