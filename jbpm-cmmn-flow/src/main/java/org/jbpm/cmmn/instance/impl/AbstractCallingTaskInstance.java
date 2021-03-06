package org.jbpm.cmmn.instance.impl;

import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.definition.CallingTaskDefinition;
import org.jbpm.cmmn.flow.definition.CaseTaskDefinition;
import org.jbpm.cmmn.flow.definition.ParameterMapping;
import org.jbpm.cmmn.flow.definition.TaskDefinition;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.impl.util.ExpressionUtil;
import org.jbpm.cmmn.instance.subscription.TaskInstance;
import org.jbpm.process.core.context.exception.ExceptionScope;
import org.jbpm.process.instance.ContextInstanceContainer;
import org.jbpm.process.instance.ProcessInstance;
import org.jbpm.process.instance.StartProcessHelper;
import org.jbpm.process.instance.context.exception.ExceptionScopeInstance;
import org.jbpm.process.instance.impl.ProcessInstanceImpl;
import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.kie.api.KieBase;
import org.kie.api.definition.process.*;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.EventListener;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.internal.runtime.KnowledgeRuntime;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public abstract class AbstractCallingTaskInstance <T extends CallingTaskDefinition> extends ControllableItemInstanceImpl<T> implements EventListener, ContextInstanceContainer,TaskInstance<T> {
	static final Logger logger = LoggerFactory.getLogger(CaseTaskInstance.class);
	private static final long serialVersionUID = -2144001908752174712L;
	private long processInstanceId = -1;
	transient private ProcessInstance processInstance;
	@Override
	public void internalTrigger(NodeInstance from, String type) {
		super.internalTrigger(from, type);
		noteInstantiation();
	}
	@Override
	public Object getInput(String s) {
		return ExpressionUtil.getInputParameter(this,getItem().getDefinition().getInputParameter(s));
	}


	public abstract String getCalledProcessId();
	@Override
	public void start() {
		super.start();
		startProcess();
	}

	@Override
	public void manualStart() {
		super.manualStart();
		startProcess();
	}

	@Override
	public void terminate() {
		super.terminate();
		killSubprocessGracefully();
	}

	@Override
	public void reactivate() {
		super.reactivate();
		startProcess();
	}

	private void startProcess() {
		String processId = getCalledProcessId();
		KieBase kbase =  getProcessInstance().getKnowledgeRuntime().getKieBase();
		// start process instance
		org.kie.api.definition.process.Process process = kbase.getProcess(processId);
		if (process == null) {
			// try to find it by name
			String latestProcessId = StartProcessHelper.findLatestProcessByName(kbase, processId);
			if (latestProcessId != null) {
				processId = latestProcessId;
				process = kbase.getProcess(processId);
			}
		}

		if (process == null) {
			logger.error("Could not find process {}", processId);
			logger.error("Aborting process");
			((ProcessInstance) getProcessInstance()).setState(ProcessInstance.STATE_ABORTED);
			throw new RuntimeException("Could not find process " + processId);
		} else {
			List<ParameterMapping> parameterMappings = getItem().getDefinition().prepareInputMappings(process);
			HashMap<String, Object> fromParameters = ExpressionUtil.buildInputParameters(this, getItem().getDefinition());
			Map<String, Object> parametersToMap = ExpressionUtil.transformParameters(parameterMappings, fromParameters, this);
			Map<String, Object> inputParamaters = mapParameters(parameterMappings, parametersToMap);
			String caseOwner = getCaseInstance().getCaseOwner();
			if(caseOwner==null) {
				inputParamaters.put(WorkItemParameters.INITIATOR, getCaseInstance().getVariable(WorkItemParameters.INITIATOR));
			}else{
				inputParamaters.put(WorkItemParameters.INITIATOR, caseOwner);
			}
			KnowledgeRuntime kruntime = ((ProcessInstance) getProcessInstance()).getKnowledgeRuntime();
			RuntimeManager manager = (RuntimeManager) kruntime.getEnvironment().get("RuntimeManager");
			if (manager != null) {
				RuntimeEngine runtime = manager.getRuntimeEngine(ProcessInstanceIdContext.get());
				kruntime = (KnowledgeRuntime) runtime.getKieSession();
			}
			ProcessInstance processInstance = (ProcessInstance) kruntime.createProcessInstance(processId, inputParamaters);
			this.processInstanceId = processInstance.getId();
			((ProcessInstanceImpl) processInstance).setMetaData("ParentProcessInstanceId", getProcessInstance().getId());
			processInstance.setParentProcessInstanceId(getProcessInstance().getId());
			kruntime.startProcessInstance(processInstance.getId());
			if (!getItem().getDefinition().isBlocking()) {
				triggerCompleted();
			} else if (processInstance.getState() == ProcessInstance.STATE_COMPLETED || processInstance.getState() == ProcessInstance.STATE_ABORTED) {
				processInstanceCompleted(processInstance);
			} else {
				addProcessListener();
			}
		}
	}

	@Override
	public void resume() {
		super.resume();
		setSubProcessState(ProcessInstance.STATE_ACTIVE);
	}

	@Override
	public void parentResume() {
		super.parentResume();
		setSubProcessState(ProcessInstance.STATE_ACTIVE);
	}

	@Override
	public void parentSuspend() {
		super.parentSuspend();
		setSubProcessState(ProcessInstance.STATE_SUSPENDED);
	}

	@Override
	public void suspend() {
		super.suspend();
		setSubProcessState(ProcessInstance.STATE_SUSPENDED);
	}

	@Override
	public void exit() {
		super.exit();
		killSubprocessGracefully();
	}

	private void killSubprocessGracefully() {
		WorkflowProcessInstance subProcess = (WorkflowProcessInstance) getProcessInstance().getKnowledgeRuntime().getProcessInstance(getProcessInstanceId());
		if (subProcess instanceof CaseInstance) {
			PlanElementState.terminateChildren((PlanItemInstanceContainer) subProcess);
		} else {
			for (NodeInstance nodeInstance : subProcess.getNodeInstances()) {
				if (nodeInstance instanceof org.jbpm.workflow.instance.NodeInstance) {
					((org.jbpm.workflow.instance.NodeInstance) nodeInstance).cancel();
				}
			}
		}
		subProcess.setState(ProcessInstance.STATE_COMPLETED);
	}

	public void cancel() {
		super.cancel();
		setSubProcessState(ProcessInstance.STATE_ABORTED);
	}

	protected void setSubProcessState(int processState) {
		if (getItem().getDefinition() != null && getItem().getDefinition().isBlocking()) {
			ProcessInstance processInstance = (ProcessInstance) ((ProcessInstance) getProcessInstance()).getKnowledgeRuntime().getProcessInstance(
					processInstanceId);
			if (processInstance != null) {
				processInstance.setState(processState);
			}
		}
	}

	public long getProcessInstanceId() {
		return processInstanceId;
	}

	public void internalSetProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public void addEventListeners() {
		super.addEventListeners();
		addProcessListener();
	}

	private void addProcessListener() {
		if (processInstanceId >= 0) {
			getProcessInstance().addEventListener("processInstanceCompleted:" + processInstanceId, this, true);
		}
	}

	public void removeEventListeners() {
		super.removeEventListeners();
		getProcessInstance().removeEventListener("processInstanceCompleted:" + processInstanceId, this, true);
	}

	public void signalEvent(String type, Object event) {
		if (("processInstanceCompleted:" + processInstanceId).equals(type) && !getPlanElementState().isTerminalState()) {
			processInstanceCompleted((ProcessInstance) event);
		} else {
			super.signalEvent(type, event);
		}
	}

	public String[] getEventTypes() {
		return new String[] { "processInstanceCompleted:" + processInstanceId};
	}

	public void processInstanceCompleted(ProcessInstance processInstance) {
		this.processInstance = processInstance;
		getProcessInstance().removeEventListener("processInstanceCompleted:" + processInstanceId, this, true);
		if (processInstance.getState() == ProcessInstance.STATE_ABORTED) {
			String faultName = processInstance.getOutcome() == null ? "" : processInstance.getOutcome();
			// handle exception as sub process failed with error code
			ExceptionScopeInstance exceptionScopeInstance = (ExceptionScopeInstance) resolveContextInstance(ExceptionScope.EXCEPTION_SCOPE, faultName);
			if (exceptionScopeInstance != null) {
				exceptionScopeInstance.handleException(faultName, null);
			}
			fault();
		} else {
			List<ParameterMapping> parameterMappings = getItem().getDefinition().prepareOutputMappings(processInstance.getProcess());
			Map<String, Object> parametersRead = new HashMap<String, Object>();
			if (processInstance instanceof CaseInstance) {
				parametersRead = ExpressionUtil.transformParameters(parameterMappings, ((CaseInstance) processInstance).getResult(), this);
			} else {
				for (ParameterMapping pm : parameterMappings) {
					parametersRead.put(pm.getTargetParameterName(), ((WorkflowProcessInstance) processInstance).getVariable(pm.getSourceParameterName()));
				}
			}
			Map<String, Object> result = mapParameters(parameterMappings, parametersRead);
			for (CaseParameter cp : getItem().getDefinition().getOutputs()) {
				Object val = result.get(cp.getName());
				if (val != null) {
					writeToBinding(cp, val);
				}
			}
			complete();
		}
	}

	private Map<String, Object> mapParameters(List<ParameterMapping> parameterMappings, Map<String, Object> parametersRead) {
		Map<String, Object> result = new HashMap<String, Object>();
		Set<String> sourceParameters = new HashSet<String>();
		for (ParameterMapping pm : parameterMappings) {
			Object value = parametersRead.get(pm.getSourceParameterName());
			sourceParameters.add(pm.getSourceParameterName());
			result.put(pm.getTargetParameterName(), value);
		}
		for (Map.Entry<String, Object> entry : parametersRead.entrySet()) {
			if (!sourceParameters.contains(entry.getKey())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}

}
