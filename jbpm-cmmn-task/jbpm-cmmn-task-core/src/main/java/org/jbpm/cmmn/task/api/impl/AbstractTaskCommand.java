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
import org.kie.internal.task.api.model.InternalTaskData;

public abstract class AbstractTaskCommand<T> extends TaskCommand<T> {

	private static final long serialVersionUID = -6267126920414609188L;

	protected TaskPersistenceContext taskPersistenceContext;

	protected TaskContext taskContext;

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
	@Deprecated
	protected void addContent(Task task, Map<String, Object> params) {
		ContentMarshallerContext mc = taskContext.getTaskContentService().getMarshallerContext(task);
			ContentData contentData = ContentMarshallerHelper.marshal(params, mc.getEnvironment());
			InternalContent newlyCreatedContent = (InternalContent) TaskModelProvider.getFactory().newContent();
			newlyCreatedContent.setContent(contentData.getContent());
		((InternalTaskData)task.getTaskData()).setDocumentContentId(newlyCreatedContent.getId());
			persist(newlyCreatedContent);

	}

	protected void persist(Object o) {
		this.taskPersistenceContext.persist(o);
	}

	protected void merge(Object o) {
		this.taskPersistenceContext.merge(o);
	}

	protected <X> X find(Class<X> c, Object id) {
		return taskPersistenceContext.find(c, id);
	}

	protected Task getTaskById(long taskId) {
		return taskContext.getTaskQueryService().getTaskInstanceById(taskId);
	}

	protected Task getTaskByWorkItemId(long id) {
		return taskContext.getTaskQueryService().getTaskByWorkItemId(id);
	}

	protected TaskIdentityService getTaskIdentityService() {
		return taskContext.getTaskIdentityService();
	}

	protected TaskQueryService getTaskQueryService() {
		return taskContext.getTaskQueryService();
	}

	protected TaskInstanceService getTaskInstanceService() {
		return taskContext.getTaskInstanceService();
	}

	protected void init(TaskContext taskContext) {
		this.taskPersistenceContext = taskContext.getPersistenceContext();
		this.taskContext = taskContext;
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

	protected long ensureContentIdPresent(Task task, long existingId, Map<String, Object> newContentAsMap, String contentNameInMap) {
		InternalContent resultingContent = ensureContentPresent(task, existingId, newContentAsMap, contentNameInMap);
		return resultingContent.getId();
	}

	private InternalContent ensureContentPresent(Task task, long existingId, Map<String, Object> newContentAsMap, String contentNameInMap) {
		InternalContent existingContent = null;
		ContentMarshallerContext mc = taskContext.getTaskContentService().getMarshallerContext(task);
		if (existingId < 0 || (existingContent = (InternalContent) taskPersistenceContext.findContent(existingId)) == null) {
			Object correctContentObject = getCorrectContentObject(newContentAsMap, contentNameInMap);
			ContentData contentData = ContentMarshallerHelper.marshal(correctContentObject, mc.getEnvironment());
			InternalContent newlyCreatedContent = (InternalContent) TaskModelProvider.getFactory().newContent();
			newlyCreatedContent.setContent(contentData.getContent());
			persist(newlyCreatedContent);
			return newlyCreatedContent;
		} else {
			Object contentObjectToUpdateTaskWith = mergeContentObjectIfPossible(newContentAsMap, contentNameInMap, existingContent, mc);
			ContentData contentData = ContentMarshallerHelper.marshal(contentObjectToUpdateTaskWith, mc.getEnvironment());
			existingContent.setContent(contentData.getContent());
			return existingContent;
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

	protected TaskEventSupport getTaskEventSupport() {
		TaskEventSupport es = null;
		try {
			Field esField = TaskContext.class.getDeclaredField("taskEventSupport");
			esField.setAccessible(true);
			es = (TaskEventSupport) esField.get(taskContext);
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
			l.beforeTaskCompletedEvent(new TaskEventImpl(t, taskContext));
		}
	}

	protected void fireAfterTaskCompletedEvent(Task t) {
		for (TaskLifeCycleEventListener l : getTaskEventSupport().getEventListeners()) {
			l.afterTaskCompletedEvent(new TaskEventImpl(t, taskContext));
		}
	}

	protected void fireBeforeTaskAddedEvent(Task t) {
		for (TaskLifeCycleEventListener l : getTaskEventSupport().getEventListeners()) {
			l.beforeTaskAddedEvent(new TaskEventImpl(t, this.taskContext));
		}
	}

	protected void fireAfterTaskAddedEvent(Task t) {
		for (TaskLifeCycleEventListener l : getTaskEventSupport().getEventListeners()) {
			l.afterTaskAddedEvent(new TaskEventImpl(t, taskContext));
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