package org.jbpm.cmmn.test;

import javax.persistence.EntityManagerFactory;

import org.drools.core.command.Interceptor;
import org.drools.core.command.impl.AbstractInterceptor;
import org.jbpm.runtime.manager.impl.SimpleRuntimeEnvironment;
import org.jbpm.services.task.HumanTaskConfigurator;
import org.jbpm.services.task.commands.TaskCommand;
import org.jbpm.services.task.persistence.JPATaskPersistenceContextManager;
import org.jbpm.services.task.wih.ExternalTaskEventListener;
import org.kie.api.command.Command;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.EnvironmentName;
import org.kie.api.runtime.manager.RegisterableItemsFactory;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.task.TaskLifeCycleEventListener;
import org.kie.api.task.TaskService;
import org.kie.api.task.UserGroupCallback;
import org.kie.internal.command.Context;
import org.kie.internal.command.World;
import org.kie.internal.runtime.manager.TaskServiceFactory;
import org.kie.internal.task.api.InternalTaskService;
import org.kie.internal.task.api.TaskContext;
import org.kie.internal.task.api.TaskPersistenceContext;
import org.kie.internal.task.api.TaskPersistenceContextManager;

public class TestTaskServiceFactory implements TaskServiceFactory {
	public static class PersistenceInterceptor extends AbstractInterceptor
			implements Interceptor {
		private TaskPersistenceContextManager tpm;

		public PersistenceInterceptor(Environment env) {
			if (env.get(EnvironmentName.TASK_PERSISTENCE_CONTEXT_MANAGER) != null) {
				this.tpm = (TaskPersistenceContextManager) env
						.get(EnvironmentName.TASK_PERSISTENCE_CONTEXT_MANAGER);
			} else {
				try {
					this.tpm = new JPATaskPersistenceContextManager(env);
				} catch (Exception e) {
					throw new RuntimeException(
							"Error creating JPATaskPersistenceContextManager",
							e);
				}
				env.set(EnvironmentName.TASK_PERSISTENCE_CONTEXT_MANAGER,
						this.tpm);
			}
		}

		@Override
		public <T> T execute(Command<T> command) {
			return ((TaskCommand<T>) command).execute(getContext());
		}

		@Override
		public Context getContext() {
			return new TaskContext() {

				@Override
				public void set(String identifier, Object value) {
				}

				@Override
				public void remove(String identifier) {
				}

				@Override
				public String getName() {
					return null;
				}

				@Override
				public World getContextManager() {
					return null;
				}

				@Override
				public Object get(String identifier) {
					return null;
				}

				@Override
				public void setPersistenceContext(TaskPersistenceContext context) {
				}

				@Override
				public TaskPersistenceContext getPersistenceContext() {
					return tpm.getPersistenceContext();
				}

				@Override
				public UserGroupCallback getUserGroupCallback() {
					return null;
				}
			};
		}
	};

	private RuntimeEnvironment runtimeEnvironment;

	public TestTaskServiceFactory(RuntimeEnvironment runtimeEnvironment) {
		this.runtimeEnvironment = runtimeEnvironment;
	}

	@Override
	public TaskService newTaskService() {
		// all to reuse an already given instance of task service instead of
		// producing new one
		TaskService providedTaskService = (TaskService) ((SimpleRuntimeEnvironment) runtimeEnvironment)
				.getEnvironmentTemplate().get("org.kie.api.task.TaskService");
		if (providedTaskService != null) {
			return providedTaskService;
		}

		EntityManagerFactory emf = ((SimpleRuntimeEnvironment) runtimeEnvironment)
				.getEmf();
		if (emf != null) {

			HumanTaskConfigurator configurator = new HumanTaskConfigurator() {
				protected void addDefaultInterceptor() {
					interceptor(5, new PersistenceInterceptor(
							runtimeEnvironment.getEnvironment()));
				};
			}.environment(runtimeEnvironment.getEnvironment())
					.entityManagerFactory(emf)
					.userGroupCallback(
							runtimeEnvironment.getUserGroupCallback());
			// register task listeners if any
			RegisterableItemsFactory itemsFactory = runtimeEnvironment
					.getRegisterableItemsFactory();
			ExternalTaskEventListener oldListener=null;
			for (TaskLifeCycleEventListener taskListener : itemsFactory
					.getTaskListeners()) {
				configurator.listener(taskListener);
			}
			InternalTaskService internalTaskService = (InternalTaskService) configurator.getTaskService();
			return internalTaskService;
		} else {
			return null;
		}
	}

	@Override
	public void close() {

	}

}
