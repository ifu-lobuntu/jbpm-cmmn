package org.jbpm.cmmn.task.api.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.services.task.commands.TaskCommand;
import org.jbpm.services.task.commands.TaskContext;
import org.jbpm.services.task.events.TaskEventImpl;
import org.jbpm.services.task.events.TaskEventSupport;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.kie.api.task.TaskLifeCycleEventListener;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Task;
import org.kie.internal.command.Context;
import org.kie.internal.task.api.ContentMarshallerContext;
import org.kie.internal.task.api.TaskIdentityService;
import org.kie.internal.task.api.TaskInstanceService;
import org.kie.internal.task.api.TaskModelProvider;
import org.kie.internal.task.api.TaskPersistenceContext;
import org.kie.internal.task.api.TaskQueryService;
import org.kie.internal.task.api.model.ContentData;
import org.kie.internal.task.api.model.InternalContent;

public abstract class AbstractTaskCommand<T> extends TaskCommand<T> {

	private static final long serialVersionUID = -6267126920414609188L;
	private TaskPersistenceContext pm;
	private TaskContext ts;

	public AbstractTaskCommand() {
		super();
	}

	public abstract T execute();

	@Override
	public final T execute(Context context) {
		TaskContext taskContext = (TaskContext) context;
		init(taskContext);
		return execute();
	}

	protected void addContent(Long id, Map<String, Object> params) {
		ts.getTaskContentService().addContent(id, params);
	}

	protected void persist(Object o) {
		this.pm.persist(o);
	}

	protected void merge(Object o) {
		this.pm.merge(o);
	}

	protected <X> X find(Class<X> c, Object id) {
		return pm.find(c, id);
	}

	protected Task getTaskById(long taskId) {
		return ts.getTaskQueryService().getTaskInstanceById(taskId);
	}

	protected Task getTaskByWorkItemId(long id) {
		return ts.getTaskQueryService().getTaskByWorkItemId(id);
	}

	protected TaskIdentityService getTaskIdentityService() {
		return ts.getTaskIdentityService();
	}

	protected TaskQueryService getTaskQueryService() {
		return ts.getTaskQueryService();
	}

	protected TaskInstanceService getTaskInstanceService() {
		return ts.getTaskInstanceService();
	}

	private void init(TaskContext taskContext) {
		this.pm = taskContext.getPersistenceContext();
		this.ts = taskContext;
	}

	public final String toString() {
		return getClass().getSimpleName() + "(" + taskId + ", " + userId + ");";
	}

	private Object getCorrectContentObject(Map<String, Object> parameters, String contentParamName) {
		Object contentObject = parameters.get(contentParamName);
		if (contentObject == null) {
			contentObject = new HashMap<String, Object>(parameters);
		}
		return contentObject;
	}

	protected long ensureContentPresent(Task task, long existingId, Map<String, Object> newContentAsMap, String contentNameInMap) {
		InternalContent existingContent = null;
		ContentMarshallerContext mc = ts.getTaskContentService().getMarshallerContext(task);
		if (existingId < 0 || (existingContent =  (InternalContent) pm.findContent(existingId)) == null) {
			Object correctContentObject = getCorrectContentObject(newContentAsMap, contentNameInMap);
			ContentData contentData = ContentMarshallerHelper.marshal(correctContentObject, mc.getEnvironment());
			InternalContent newlyCreatedContent = (InternalContent) TaskModelProvider.getFactory().newContent();
			newlyCreatedContent.setContent(contentData.getContent());
			persist(newlyCreatedContent);
			return newlyCreatedContent.getId();
		} else {
			Object contentObjectToUpdateTaskWith = mergeContentObjectIfPossible(newContentAsMap, contentNameInMap, existingContent, mc);
			ContentData contentData = ContentMarshallerHelper.marshal(contentObjectToUpdateTaskWith, mc.getEnvironment());
			existingContent.setContent(contentData.getContent());
			return existingContent.getId();
		}
	}

	@SuppressWarnings("unchecked")
	private Object mergeContentObjectIfPossible(Map<String, Object> newContentAsMap, String contentNameInMap, InternalContent existingContent,
			ContentMarshallerContext mc) {
		Object contentObjectToUpdateTaskWith = ContentMarshallerHelper.unmarshall(existingContent.getContent(), mc.getEnvironment());
		if (contentObjectToUpdateTaskWith instanceof Map) {
			Map<String, Object> existingOutputAsMap = (Map<String, Object>) contentObjectToUpdateTaskWith;
			Object newContentObject = getCorrectContentObject(newContentAsMap, contentNameInMap);
			if (newContentObject instanceof Map) {
				// merge
				existingOutputAsMap.putAll((Map<String, Object>) newContentObject);
			} else if (newContentObject != null) {
				// replace
				contentObjectToUpdateTaskWith = newContentObject;
			}
		} else {
			contentObjectToUpdateTaskWith = getCorrectContentObject(newContentAsMap, contentNameInMap);
		}
		return contentObjectToUpdateTaskWith;
	}

	private List<CmmnTaskLifecycleEventListener> getCmmnEventListeners() {
		TaskEventSupport es = getTaskEventSupport();
		List<CmmnTaskLifecycleEventListener> result = new ArrayList<CmmnTaskLifecycleEventListener>();
		for (TaskLifeCycleEventListener el : es.getEventListeners()) {
			if (el instanceof CmmnTaskLifecycleEventListener) {
				result.add((CmmnTaskLifecycleEventListener) el);
			}
		}
		return result;
	}

	private TaskEventSupport getTaskEventSupport() {
		TaskEventSupport es = null;
		try {
			Field esField = TaskContext.class.getDeclaredField("taskEventSupport");
			esField.setAccessible(true);
			es = (TaskEventSupport) esField.get(ts);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return es;
	}

	protected void fireBeforeTaskStartedAutomaticallyEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.beforeTaskStartedAutomaticallyEvent(t);
		}
	}

	protected void fireAfterTaskStartedAutomaticallyEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.afterTaskStartedAutomaticallyEvent(t);
		}
	}

	protected void fireBeforeTaskExitCriteriaEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.beforeTaskExitCriteriaEvent(t);
		}
	}

	protected void fireAfterTaskExitCriteriaEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.afterTaskExitCriteriaEvent(t);
		}
	}

	protected void fireBeforeTaskCompletedEvent(Task t) {
		for (TaskLifeCycleEventListener l : getTaskEventSupport().getEventListeners()) {
			l.beforeTaskCompletedEvent(new TaskEventImpl(t, ts));
		}
	}

	protected void fireAfterTaskCompletedEvent(Task t) {
		for (TaskLifeCycleEventListener l : getTaskEventSupport().getEventListeners()) {
			l.afterTaskCompletedEvent(new TaskEventImpl(t, ts));
		}
	}

	protected void fireBeforeTaskAddedEvent(Task t) {
		for (TaskLifeCycleEventListener l : getTaskEventSupport().getEventListeners()) {
			l.beforeTaskAddedEvent(new TaskEventImpl(t, this.ts));
		}
	}

	protected void fireAfterTaskAddedEvent(Task t) {
		for (TaskLifeCycleEventListener l : getTaskEventSupport().getEventListeners()) {
			l.afterTaskAddedEvent(new TaskEventImpl(t, ts));
		}
	}

	protected void fireBeforeTaskReactivatedEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.beforeTaskReactivatedEvent(t);
		}
	}

	protected void fireAfterTaskReactivatedEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.afterTaskReactivatedEvent(t);
		}
	}

	protected void fireBeforeTaskReenabledEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.beforeTaskReenabledEvent(t);
		}
	}

	protected void fireAfterTaskReenabledEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.afterTaskReenabledEvent(t);
		}
	}

	protected void fireBeforeTaskResumedFromParentEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.beforeTaskParentResumedEvent(t);
		}
	}

	protected void fireAfterTaskResumedFromParentEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.afterTaskParentResumedEvent(t);
		}
	}

	protected void fireBeforeTaskSuspendedFromParentEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.beforeTaskParentSuspendedEvent(t);
		}
	}

	protected void fireAfterTaskSuspendedFromParentEvent(Task t) {
		for (CmmnTaskLifecycleEventListener l : getCmmnEventListeners()) {
			l.afterTaskParentSuspendedEvent(t);
		}
	}
}