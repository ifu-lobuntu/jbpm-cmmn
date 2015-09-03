package org.jbpm.cmmn.task.registration;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.instance.CaseFileImplementation;
import org.jbpm.cmmn.instance.CaseFilePersistence;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.cmmn.task.workitems.CaseTaskLifecycleListener;
import org.jbpm.cmmn.task.workitems.CaseTaskWorkItemHandler;
import org.jbpm.cmmn.task.workitems.UpdateTaskStatusWorkItemHandler;
import org.jbpm.runtime.manager.impl.DefaultRegisterableItemsFactory;
import org.jbpm.runtime.manager.impl.RuntimeEngineImpl;
import org.jbpm.runtime.manager.impl.SimpleRuntimeEnvironment;
import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.jbpm.services.task.persistence.JPATaskPersistenceContext;
import org.jbpm.services.task.wih.ExternalTaskEventListener;
import org.jbpm.services.task.wih.LocalHTWorkItemHandler;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.EnvironmentName;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.task.TaskLifeCycleEventListener;
import org.kie.internal.runtime.manager.Disposable;
import org.kie.internal.runtime.manager.DisposeListener;
import org.kie.internal.runtime.manager.InternalRuntimeManager;
import org.kie.internal.runtime.manager.RuntimeEnvironment;
import org.kie.internal.task.api.EventService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseRegisterableItemsFactory extends DefaultRegisterableItemsFactory {
    private CaseTaskLifecycleListener lifecycleListener = new CaseTaskLifecycleListener();

    @SuppressWarnings({"rawtypes"})
    @Override
    protected WorkItemHandler getHTWorkItemHandler(RuntimeEngine runtime) {
        return super.getHTWorkItemHandler(runtime);
    }

    @Override
    public void setRuntimeManager(InternalRuntimeManager runtimeManager) {
        super.setRuntimeManager(runtimeManager);
        RuntimeEnvironment environment = runtimeManager.getEnvironment();
        Environment env=null;
        if (environment instanceof SimpleRuntimeEnvironment) {
            SimpleRuntimeEnvironment sre = (SimpleRuntimeEnvironment) environment;
            env=sre.getEnvironmentTemplate();
        }
        ObjectMarshallingStrategy[] omss = (ObjectMarshallingStrategy[]) env.get(EnvironmentName.OBJECT_MARSHALLING_STRATEGIES);
        CaseFileImplementation cfi = buildCaseFileImplementation(runtimeManager, env);
        env.set(CaseFilePersistence.ENV_NAME, cfi.getCaseFilePersistence(env));
        env.set(SubscriptionManager.ENV_NAME, cfi.getSubscriptionManager(env));
        ObjectMarshallingStrategy[] additionalOmss = cfi.getObjectMarshallingStrategies(env);
        ObjectMarshallingStrategy[] newOmss = new ObjectMarshallingStrategy[omss.length + additionalOmss.length];
        int i=0;
        for (ObjectMarshallingStrategy oms : additionalOmss) {
            newOmss[i++]=oms;
        }
        for (ObjectMarshallingStrategy oms : omss) {
            newOmss[i++]=oms;
        }
        env.set(EnvironmentName.OBJECT_MARSHALLING_STRATEGIES, newOmss);
        if (environment instanceof SimpleRuntimeEnvironment) {
            SimpleRuntimeEnvironment sre = (SimpleRuntimeEnvironment) environment;
            sre.addToEnvironment(CaseFilePersistence.ENV_NAME, env.get(CaseFilePersistence.ENV_NAME));
            sre.addToEnvironment(SubscriptionManager.ENV_NAME,env.get(SubscriptionManager.ENV_NAME));
        }
    }

    private CaseFileImplementation buildCaseFileImplementation(InternalRuntimeManager runtimeManager, Environment env){
        String caseFileImplementation = "org.jbpm.cmmn.casefile.jpa.JpaCaseFileImplementation";
        if(env.get("CaseFileImplementation")!=null) {
            caseFileImplementation = (String) env.get("CaseFileImplementation");
        }
        try {
            return (CaseFileImplementation) Class.forName(caseFileImplementation, true,runtimeManager.getEnvironment().getClassLoader()).newInstance();
        } catch (ClassNotFoundException e) {
            try {
                return (CaseFileImplementation) Class.forName(caseFileImplementation).newInstance();
            } catch (RuntimeException e1) {
                throw e1;
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void setKieSessionScopedInfrastracture(KieSession kieSession) {
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
        defaultHandlers.put("CMMN Human Task", humanTaskHandler);
        setKieSessionScopedInfrastracture(runtime.getKieSession());
        return defaultHandlers;
    }

    @Override
    public List<TaskLifeCycleEventListener> getTaskListeners() {
        List<TaskLifeCycleEventListener> result = new ArrayList<TaskLifeCycleEventListener>();
        for (TaskLifeCycleEventListener listener : super.getTaskListeners()) {
            if (listener instanceof ExternalTaskEventListener) {
            } else {
                result.add(listener);
            }
        }
        result.add(lifecycleListener);
        return result;
    }
}
