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
import org.jbpm.services.task.wih.ExternalTaskEventListener;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.EnvironmentName;
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
        //NB!!! Careful here, runtimeManager has not been fully initialized.
        super.setRuntimeManager(runtimeManager);
        RuntimeEnvironment environment = runtimeManager.getEnvironment();
        Environment env;
        if (environment instanceof SimpleRuntimeEnvironment) {
            SimpleRuntimeEnvironment sre = (SimpleRuntimeEnvironment) environment;
            env=sre.getEnvironmentTemplate();
        }else{
            env=environment.getEnvironment();
        }
        env.set("deploymentId",runtimeManager.getIdentifier());
        ObjectMarshallingStrategy[] omss = (ObjectMarshallingStrategy[]) env.get(EnvironmentName.OBJECT_MARSHALLING_STRATEGIES);
        ClassLoader cl = environment.getClassLoader();
        if(cl==null){
            cl=Thread.currentThread().getContextClassLoader();
        }
        CaseFileImplementation cfi = buildCaseFileImplementation(env, cl);
        env.set(CaseFilePersistence.ENV_NAME, cfi.deployCaseFilePersistence(env, cl));
        Object demarcated= env.get(CaseFileImplementation.DEMARCATED_SUBSCRIPTION);
        if(!(Boolean.TRUE.equals(demarcated) || "true".equals(demarcated))) {
            env.set(SubscriptionManager.ENV_NAME, cfi.getSubscriptionManager(env, cl));
        }
        ObjectMarshallingStrategy[] additionalOmss = cfi.getObjectMarshallingStrategies(env, cl);
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
            sre.addToEnvironment(SubscriptionManager.ENV_NAME, env.get(SubscriptionManager.ENV_NAME));
        }
    }

    private CaseFileImplementation buildCaseFileImplementation(Environment env, ClassLoader cl){
        String caseFileImplementation = "org.jbpm.cmmn.casefile.jpa.JpaCaseFileImplementation";
        if(env.get(CaseFileImplementation.CASE_FILE_IMPLEMENTATION_CLASS)!=null) {
            caseFileImplementation = (String) env.get(CaseFileImplementation.CASE_FILE_IMPLEMENTATION_CLASS);
        }
        try {
            return (CaseFileImplementation) Class.forName(caseFileImplementation, true,cl).newInstance();
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
