package org.jbpm.cmmn.task.registration;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.task.workitems.CaseTaskLifecycleListener;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseRegisterableItemsFactory extends DefaultRegisterableItemsFactory {
	private CaseTaskLifecycleListener lifecycleListener =new CaseTaskLifecycleListener();
	@SuppressWarnings({ "rawtypes" })
	@Override
	protected WorkItemHandler getHTWorkItemHandler(RuntimeEngine runtime) {
		return super.getHTWorkItemHandler(runtime);
	}

	@Override
	public Map<String, WorkItemHandler> getWorkItemHandlers(RuntimeEngine runtime) {
		Map<String, WorkItemHandler> defaultHandlers = new HashMap<String, WorkItemHandler>();
		defaultHandlers.putAll(super.getWorkItemHandlers(runtime));
		UpdateTaskStatusWorkItemHandler stwih = new UpdateTaskStatusWorkItemHandler(lifecycleListener);
		stwih.setRuntimeManager(((RuntimeEngineImpl) runtime).getManager());
		defaultHandlers.put(WorkItemParameters.UPDATE_TASK_STATUS, stwih);
		CaseTaskWorkItemHandler humanTaskHandler = new CaseTaskWorkItemHandler();
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
		defaultHandlers.put("CMMN Human Task",humanTaskHandler);
		return defaultHandlers;
	}
	@Override
	public List<TaskLifeCycleEventListener> getTaskListeners() {
		List<TaskLifeCycleEventListener> result = new ArrayList<TaskLifeCycleEventListener>();
		for (TaskLifeCycleEventListener listener : super.getTaskListeners()) {
			if(listener instanceof ExternalTaskEventListener){
			}else{
				result.add(listener);
			}
		}
		result.add(lifecycleListener);
		return result;
	}
}
