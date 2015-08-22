package org.jbpm.cmmn.marshalling;

import org.drools.core.marshalling.impl.MarshallerReaderContext;
import org.drools.core.marshalling.impl.MarshallerWriteContext;
import org.drools.core.marshalling.impl.PersisterEnums;
import org.drools.core.util.StringUtils;
import org.jbpm.cmmn.instance.*;
import org.jbpm.cmmn.instance.impl.*;
import org.jbpm.marshalling.impl.AbstractProcessInstanceMarshaller;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.process.instance.context.variable.VariableScopeInstance;
import org.jbpm.workflow.instance.impl.NodeInstanceImpl;
import org.jbpm.workflow.instance.impl.WorkflowProcessInstanceImpl;
import org.jbpm.workflow.instance.node.CompositeNodeInstance;
import org.jbpm.workflow.instance.node.JoinInstance;
import org.jbpm.workflow.instance.node.StateBasedNodeInstance;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.api.runtime.process.NodeInstanceContainer;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkflowProcessInstance;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.*;

public class CaseInstanceMarshaller extends AbstractProcessInstanceMarshaller {
    private static final int SENTRY_INSTANCE = 176;
    private static final int ON_PART_INSTANCE = 177;
    private static final int HUMAN_TASK_PLAN_ITEM_INSTANCE = 178;
    private static final int STAGE_PLAN_ITEM_INSTANCE = 179;
    private static final int USER_EVENT_PLAN_ITEM_INSTANCE = 180;
    private static final int TIMER_EVENT_PLAN_ITEM_INSTANCE = 181;
    private static final int MILESTONE_PLAN_ITEM_INSTANCE = 182;
    private static final int CASE_TASK_PLAN_ITEM_INSTANCE = 183;
    private static final int PROCESS_TASK_PLAN_ITEM_INSTANCE = 184;
    private static final int DEFAULT_JOIN_INSTANCE = 185;
    private static final int PLAN_ITEM_INSTANCE_FACTORY_NODE_INSTANCE = 186;
    private static final int DEFAULT_SPLIT_INSTANCE = 187;

    @Override
    protected WorkflowProcessInstanceImpl createProcessInstance() {
        return new CaseInstanceImpl();
    }

    @Override
    public Object writeProcessInstance(MarshallerWriteContext context, ProcessInstance processInstance) throws IOException {
        Object result = super.writeProcessInstance(context, processInstance);
        if (processInstance instanceof CaseInstanceImpl) {
            context.stream.writeInt(((CaseInstance) processInstance).getPlanElementState().ordinal());
        }
        return result;
    }

    @Override
    public ProcessInstance readProcessInstance(MarshallerReaderContext context) throws IOException {
        ObjectInputStream stream = context.stream;
        ProcessInstance read = super.readProcessInstance(context);
        if (read instanceof CaseInstanceImpl) {
            CaseInstanceImpl ci = (CaseInstanceImpl) read;
            ci.setPlanElementState(PlanElementState.values()[stream.readInt()]);
            for (NodeInstance ni : ci.getNodeInstances()) {
                if (ni instanceof CompositeNodeInstance) {
                    try {
                        Field field = CompositeNodeInstance.class.getDeclaredField("singleNodeInstanceCounter");
                        field.setAccessible(true);
                        field.set(ni, ci.internalGetNodeInstanceCounter());
                    } catch (NoSuchFieldException e) {
                    } catch (IllegalAccessException e) {
                    }
                }
            }
        }
        return read;
    }

    private void writePlanItemStates(PlanItemInstanceLifecycleWithHistory<?> pi, ObjectOutputStream stream) throws IOException {
        stream.writeInt(pi.getPlanElementState().ordinal());
        stream.writeInt(pi.getLastBusyState().ordinal());
        if (pi instanceof ControllableItemInstance && pi.getPlanElementState() != PlanElementState.INITIAL) {
            stream.writeBoolean(((ControllableItemInstance<?>) pi).isCompletionRequired());
        }
    }

    private void readPlanItemStates(PlanItemInstanceLifecycleWithHistory<?> pi, ObjectInputStream stream) throws IOException {
        pi.setPlanElementState(PlanElementState.values()[stream.readInt()]);
        pi.setLastBusyState(PlanElementState.values()[stream.readInt()]);
        if (pi instanceof ControllableItemInstance && pi.getPlanElementState() != PlanElementState.INITIAL) {
            ((ControllableItemInstance<?>) pi).internalSetCompletionRequired(stream.readBoolean());
        }
    }

    @Override
    public NodeInstance readNodeInstance(MarshallerReaderContext context, NodeInstanceContainer nodeInstanceContainer, WorkflowProcessInstance processInstance)
            throws IOException {
        NodeInstance ni = super.readNodeInstance(context, nodeInstanceContainer, processInstance);
        if(ni instanceof ControllableItemInstanceImpl){
            readVariables(context, (ControllableItemInstanceImpl<?>) ni);
        }
        if (ni instanceof StageInstance) {
            StageInstance si = (StageInstance) ni;
            while (context.stream.readShort() == PersisterEnums.NODE_INSTANCE) {
                readNodeInstance(context, si, processInstance);
            }
        }
        return ni;
    }

    private void readVariables(MarshallerReaderContext context, ControllableItemInstanceImpl<?> si) throws IOException {
        int nbVariables = context.stream.readInt();
        if (nbVariables > 0) {
            VariableScopeInstance variableScopeInstance = (VariableScopeInstance) si
                    .getContextInstance(VariableScope.VARIABLE_SCOPE);
            for (int i = 0; i < nbVariables; i++) {
                String name = context.stream.readUTF();
                try {
                    ObjectMarshallingStrategy strategy = null;
                    String strategyClassName = context.stream.readUTF();
                    if (!StringUtils.isEmpty(strategyClassName)) {
                        strategy = context.resolverStrategyFactory.getStrategyObject(strategyClassName);
                        if (strategy == null) {
                            throw new IllegalStateException("No strategy of type " + strategyClassName + " available.");
                        }
                    }
                    // If either way retrieves a strategy, use it
                    Object value = null;
                    if (strategy != null) {
                        value = strategy.read(context.stream);
                    }
                    variableScopeInstance.internalSetVariable(name, value);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(
                            "Could not reload variable " + name);
                }
            }
        }
    }

    @Override
    protected NodeInstanceImpl readNodeInstanceContent(int nodeType, ObjectInputStream stream, MarshallerReaderContext context,
                                                       WorkflowProcessInstance processInstance) throws IOException {
        NodeInstanceImpl nodeInstance = null;
        switch (nodeType) {
            case PLAN_ITEM_INSTANCE_FACTORY_NODE_INSTANCE:
                @SuppressWarnings("rawtypes")
                PlanItemInstanceFactoryNodeInstance piifni = new PlanItemInstanceFactoryNodeInstance();
                readPlanItemStates(piifni, stream);
                piifni.internalSetPlanItemInstanceRequired(context.stream.readBoolean());
                piifni.internalSetHasPlanItemInstanceBeenInstantiated(context.stream.readBoolean());
                piifni.internalSetRepeating(context.stream.readBoolean());
                piifni.setIncludedByDiscretion(context.stream.readBoolean());
                nodeInstance = piifni;
                break;
            case SENTRY_INSTANCE:
                SentryInstance sentryInstance = new SentryInstance();
                int number = stream.readInt();
                if (number > 0) {
                    Map<Long, Integer> triggers = new HashMap<Long, Integer>();
                    for (int i = 0; i < number; i++) {
                        long l = stream.readLong();
                        int count = stream.readInt();
                        triggers.put(l, count);
                    }
                    sentryInstance.internalSetTriggers(triggers);
                }
                nodeInstance = sentryInstance;
                break;
            case ON_PART_INSTANCE:
                StandardEventNodeInstance onPartInstance = new StandardEventNodeInstance();
                nodeInstance = onPartInstance;
                break;
            case MILESTONE_PLAN_ITEM_INSTANCE:
                nodeInstance = new MilestoneInstance();
                readOccurrablePlanItemInstance(stream, (MilestoneInstance) nodeInstance);
                break;
            case USER_EVENT_PLAN_ITEM_INSTANCE:
                nodeInstance = new UserEventInstance();
                readOccurrablePlanItemInstance(stream, (UserEventInstance) nodeInstance);
                break;
            case TIMER_EVENT_PLAN_ITEM_INSTANCE:
                nodeInstance = new TimerEventInstance();
                readOccurrablePlanItemInstance(stream, (TimerEventInstance) nodeInstance);
                ((TimerEventInstance) nodeInstance).internalSetTimerInstanceId(stream.readLong());
                break;
            case CASE_TASK_PLAN_ITEM_INSTANCE:
                nodeInstance = new CaseTaskInstance();
                ((CaseTaskInstance) nodeInstance).internalSetProcessInstanceId(stream.readLong());
                readControllableItemInstanceContent(stream, context, (ControllableItemInstanceImpl<?>) nodeInstance);
                break;
            case PROCESS_TASK_PLAN_ITEM_INSTANCE:
                nodeInstance = new ProcessTaskInstance();
                ((ProcessTaskInstance) nodeInstance).internalSetProcessInstanceId(stream.readLong());
                readControllableItemInstanceContent(stream, context, (ControllableItemInstanceImpl<?>) nodeInstance);
                break;
            case HUMAN_TASK_PLAN_ITEM_INSTANCE:
                nodeInstance = new HumanTaskInstance();
                ((HumanTaskInstance)nodeInstance).internalSetWorkItemId(stream.readLong());
                readControllableItemInstanceContent(stream, context, (ControllableItemInstanceImpl<?>) nodeInstance);
                break;
            case STAGE_PLAN_ITEM_INSTANCE:
                nodeInstance = new StageInstance();
                readControllableItemInstanceContent(stream, context, (ControllableItemInstanceImpl<?>) nodeInstance);
                break;
            case DEFAULT_SPLIT_INSTANCE:
                nodeInstance = new DefaultSplitInstance();
                break;
            case DEFAULT_JOIN_INSTANCE:
                nodeInstance = new DefaultJoinInstance();
                number = stream.readInt();
                if (number > 0) {
                    Map<Long, Integer> triggers = new HashMap<Long, Integer>();
                    for (int i = 0; i < number; i++) {
                        long l = stream.readLong();
                        int count = stream.readInt();
                        triggers.put(l, count);
                    }
                    ((JoinInstance) nodeInstance).internalSetTriggers(triggers);
                }
                break;
            default:
                nodeInstance = super.readNodeInstanceContent(nodeType, stream, context, processInstance);
        }
        return nodeInstance;
    }

    private void readTimerInstances(ObjectInputStream stream, StateBasedNodeInstance caseTaskInstance) throws IOException {
        int nbTimerInstances = stream.readInt();
        if (nbTimerInstances > 0) {
            List<Long> timerInstances = new ArrayList<Long>();
            for (int i = 0; i < nbTimerInstances; i++) {
                timerInstances.add(stream.readLong());
            }
            caseTaskInstance.internalSetTimerInstances(timerInstances);
        }
    }

    protected void readOccurrablePlanItemInstance(ObjectInputStream stream, OccurrablePlanItemInstance<?> nodeInstance) throws IOException {
        nodeInstance.internalSetRequired(stream.readBoolean());
        nodeInstance.setPlanElementState(PlanElementState.values()[stream.readInt()]);
    }

    @Override
    protected void writeNodeInstanceContent(ObjectOutputStream stream, NodeInstance nodeInstance, MarshallerWriteContext context) throws IOException {
        if (nodeInstance instanceof SentryInstance) {
            stream.writeShort(SENTRY_INSTANCE);
            Map<Long, Integer> triggers = ((JoinInstance) nodeInstance).getTriggers();
            stream.writeInt(triggers.size());
            List<Long> keys = new ArrayList<Long>(triggers.keySet());
            Collections.sort(keys, new Comparator<Long>() {

                public int compare(Long o1, Long o2) {
                    return o1.compareTo(o2);
                }
            });
            for (Long key : keys) {
                stream.writeLong(key);
                stream.writeInt(triggers.get(key));
            }

        } else if (nodeInstance instanceof PlanItemInstanceFactoryNodeInstance) {
            stream.writeShort(PLAN_ITEM_INSTANCE_FACTORY_NODE_INSTANCE);
            writePlanItemStates((PlanItemInstanceFactoryNodeInstance<?>) nodeInstance, stream);
            stream.writeBoolean(((PlanItemInstanceFactoryNodeInstance<?>) nodeInstance).isPlanItemInstanceRequired());
            stream.writeBoolean(((PlanItemInstanceFactoryNodeInstance<?>) nodeInstance).isHasPlanItemBeenInstantiatedYet());
            stream.writeBoolean(((PlanItemInstanceFactoryNodeInstance<?>) nodeInstance).isRepeating());
            stream.writeBoolean(((PlanItemInstanceFactoryNodeInstance<?>) nodeInstance).isIncludedByDiscretion());
        } else if (nodeInstance instanceof OnPartInstance) {
            stream.writeShort(ON_PART_INSTANCE);
        } else if (nodeInstance instanceof MilestoneInstance) {
            stream.writeShort(MILESTONE_PLAN_ITEM_INSTANCE);
            writeOccurrableNodeInstance(stream, (MilestoneInstance) nodeInstance);
        } else if (nodeInstance instanceof UserEventInstance) {
            stream.writeShort(USER_EVENT_PLAN_ITEM_INSTANCE);
            writeOccurrableNodeInstance(stream, (UserEventInstance) nodeInstance);
        } else if (nodeInstance instanceof TimerEventInstance) {
            stream.writeShort(TIMER_EVENT_PLAN_ITEM_INSTANCE);
            writeOccurrableNodeInstance(stream, (TimerEventInstance) nodeInstance);
            stream.writeLong(((TimerEventInstance) nodeInstance).getTimerInstanceId());
        } else if (nodeInstance instanceof CaseTaskInstance) {
            stream.writeShort(CASE_TASK_PLAN_ITEM_INSTANCE);
            AbstractCallingTaskInstance acti = (AbstractCallingTaskInstance) nodeInstance;
            stream.writeLong(acti.getProcessInstanceId());
            writeControllableItemInstance(stream, context, acti);
        } else if (nodeInstance instanceof ProcessTaskInstance) {
            stream.writeShort(PROCESS_TASK_PLAN_ITEM_INSTANCE);
            AbstractCallingTaskInstance acti = (AbstractCallingTaskInstance) nodeInstance;
            stream.writeLong(acti.getProcessInstanceId());
            writeControllableItemInstance(stream, context, acti);
        } else if (nodeInstance instanceof HumanTaskInstance) {
            stream.writeShort(HUMAN_TASK_PLAN_ITEM_INSTANCE);
            HumanTaskInstance hpii = (HumanTaskInstance) nodeInstance;
            stream.writeLong(hpii.getWorkItemId());
            writeControllableItemInstance(stream, context, hpii);
        } else if (nodeInstance instanceof StageInstance) {
            stream.writeShort(STAGE_PLAN_ITEM_INSTANCE);
            StageInstance stageInstance = (StageInstance) nodeInstance;
            writeControllableItemInstance(stream, context, stageInstance);
            List<NodeInstance> nodeInstances = new ArrayList<NodeInstance>(stageInstance.getNodeInstances());
            Collections.sort(nodeInstances, new Comparator<NodeInstance>() {

                @Override
                public int compare(NodeInstance o1, NodeInstance o2) {
                    return (int) (o1.getId() - o2.getId());
                }
            });
            for (NodeInstance subNodeInstance : nodeInstances) {
                stream.writeShort(PersisterEnums.NODE_INSTANCE);
                writeNodeInstance(context, subNodeInstance);
            }
            stream.writeShort(PersisterEnums.END);
        } else if (nodeInstance instanceof DefaultSplitInstance) {
            stream.writeShort(DEFAULT_SPLIT_INSTANCE);
        } else if (nodeInstance instanceof DefaultJoinInstance) {
            stream.writeShort(DEFAULT_JOIN_INSTANCE);
            Map<Long, Integer> triggers = ((DefaultJoinInstance) nodeInstance).getTriggers();
            stream.writeInt(triggers.size());
            List<Long> keys = new ArrayList<Long>(triggers.keySet());
            Collections.sort(keys, new Comparator<Long>() {

                public int compare(Long o1, Long o2) {
                    return o1.compareTo(o2);
                }
            });
            for (Long key : keys) {
                stream.writeLong(key);
                stream.writeInt(triggers.get(key));
            }
        } else {
            super.writeNodeInstanceContent(stream, nodeInstance, context);
        }
    }

    private void readControllableItemInstanceContent(ObjectInputStream stream, MarshallerReaderContext context, ControllableItemInstanceImpl<?> controllableItemInstance) throws IOException {
        readPlanItemStates(controllableItemInstance, stream);
//        readVariables(context, controllableItemInstance); has to happen AFTER the node has been added to its parent
        readTimerInstances(stream, controllableItemInstance);
    }


    private void writeControllableItemInstance(ObjectOutputStream stream, MarshallerWriteContext context, ControllableItemInstanceImpl<?> controllableItemInstance) throws IOException {
        writePlanItemStates(controllableItemInstance, stream);
        writeTimerInstances(stream, controllableItemInstance);
        writeVariables(stream, context, controllableItemInstance);
    }

    private void writeTimerInstances(ObjectOutputStream stream, ControllableItemInstanceImpl<?> controllableItemInstance) throws IOException {
        List<Long> timerInstances = controllableItemInstance.getTimerInstances();
        if (timerInstances != null) {
            stream.writeInt(timerInstances.size());
            for (Long id : timerInstances) {
                stream.writeLong(id);
            }
        } else {
            stream.writeInt(0);
        }
    }

    private void writeVariables(ObjectOutputStream stream, MarshallerWriteContext context, ControllableItemInstanceImpl<?> controllableItemInstance) throws IOException {
        VariableScopeInstance variableScopeInstance = (VariableScopeInstance) controllableItemInstance.getContextInstance(VariableScope.VARIABLE_SCOPE);
        Map<String, Object> variables = variableScopeInstance.getVariables();
        List<String> keys = new ArrayList<String>(variables.keySet());
        Collection<Object> values = variables.values();

        Collections.sort(keys,
                new Comparator<String>() {

                    public int compare(String o1,
                                       String o2) {
                        return o1.compareTo(o2);
                    }
                });
        // Process Variables
        // - Number of non null Variables = nonnullvariables.size()
        // For Each Variable
        // - Variable Key
        // - Marshalling Strategy Index
        // - Marshalled Object

        Collection<Object> notNullValues = new ArrayList<Object>();
        for (Object value : values) {
            if (value != null) {
                notNullValues.add(value);
            }
        }

        stream.writeInt(notNullValues.size());
        for (String key : keys) {
            Object object = variables.get(key);
            if (object != null) {
                stream.writeUTF(key);
                ObjectMarshallingStrategy strategy = context.objectMarshallingStrategyStore.getStrategyObject(object);
                stream.writeUTF(strategy.getClass().getName());
                strategy.write(stream, object);
            }

        }
    }

    protected void writeOccurrableNodeInstance(ObjectOutputStream stream, OccurrablePlanItemInstance<?> nodeInstance) throws IOException {
        stream.writeBoolean(nodeInstance.isCompletionRequired());
        stream.writeInt(nodeInstance.getPlanElementState().ordinal());
    }

}
