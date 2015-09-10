package org.jbpm.cmmn.instance;

import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.common.PlanItemTransition;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.instance.impl.ControllableItemInstanceImpl;
import org.jbpm.cmmn.instance.impl.HumanTaskInstance;

import java.util.Collection;

import static org.jbpm.cmmn.flow.common.PlanItemTransition.*;

public enum PlanElementState {
    AVAILABLE() {
        @Override
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            if (pii instanceof CaseInstance) {
                return new PlanItemTransition[0];
            } else if (isComplexLifecycle(pii)) {
                return new PlanItemTransition[]{ENABLE, START, SUSPEND, PARENT_SUSPEND, PARENT_TERMINATE, EXIT};
            } else {
                return new PlanItemTransition[]{SUSPEND, TERMINATE, PARENT_SUSPEND, PARENT_TERMINATE, OCCUR};
            }
        }

    },
    SUSPENDED() {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            if (pii instanceof CaseInstance) {
                return new PlanItemTransition[]{REACTIVATE, CLOSE};
            } else if (isComplexLifecycle(pii)) {
                return new PlanItemTransition[]{PARENT_RESUME, RESUME, EXIT};
            } else {
                return new PlanItemTransition[]{TERMINATE, PARENT_TERMINATE, RESUME};
            }
        }
    },
    COMPLETED() {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            if (pii instanceof CaseInstance) {
                return new PlanItemTransition[]{REACTIVATE, CLOSE};
            } else {
                return new PlanItemTransition[]{};
            }
        }
    },
    TERMINATED() {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            if (pii instanceof CaseInstance) {
                return new PlanItemTransition[]{REACTIVATE, CLOSE};
            } else {
                return new PlanItemTransition[]{};
            }
        }
    },
    CLOSED() {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            return new PlanItemTransition[]{};
        }
    },
    FAILED() {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            if (pii instanceof CaseInstance) {
                return new PlanItemTransition[]{REACTIVATE, CLOSE};
            } else if (isComplexLifecycle(pii)) {
                return new PlanItemTransition[]{REACTIVATE, EXIT};
            } else {
                return new PlanItemTransition[]{};
            }
        }
    },
    ACTIVE() {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            if (pii instanceof CaseInstance) {
                return new PlanItemTransition[]{COMPLETE, TERMINATE, FAULT, SUSPEND};
            } else if (isComplexLifecycle(pii)) {
                return new PlanItemTransition[]{SUSPEND, PARENT_SUSPEND, EXIT, TERMINATE, COMPLETE, FAULT,STOP};
            } else {
                return new PlanItemTransition[]{};
            }
        }
    },
    ENABLED() {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            if (pii instanceof CaseInstance) {
                return new PlanItemTransition[]{};
            } else if (isComplexLifecycle(pii)) {
                return new PlanItemTransition[]{DISABLE, MANUAL_START, PARENT_SUSPEND, TERMINATE, EXIT};
            } else {
                return new PlanItemTransition[]{};
            }
        }

    },
    DISABLED {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            if (pii instanceof CaseInstance) {
                return new PlanItemTransition[]{};
            } else if (isComplexLifecycle(pii)) {
                return new PlanItemTransition[]{REENABLE, PARENT_SUSPEND, EXIT};
            } else {
                return new PlanItemTransition[]{};
            }
        }
    },
    NONE, INITIAL {
        public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
            return new PlanItemTransition[]{CREATE};
        }
    };

    private void validateTransition(PlanElementLifecycle pi, PlanItemTransition t) {
        for (PlanItemTransition pit : getSupportedTransitions(pi)) {
            if (t == pit) {
                return;
            }
        }
        throw new IllegalPlanItemStateException(this, t);
    }

    public final boolean isBusyState(PlanElementLifecycle pl) {
        if (pl instanceof CaseInstance) {
            return this == ACTIVE;
        } else if (isComplexLifecycle(pl)) {
            return this == ACTIVE || this == DISABLED || this == ENABLED || this == AVAILABLE;
        } else {
            return this == AVAILABLE;
        }
    }

    public void enable(ControllableItemInstance<?> pi) {
        validateTransition(pi, ENABLE);
        signalEvent(pi, PlanItemTransition.ENABLE);
        pi.setPlanElementState(ENABLED);
    }

    private void signalEvent(PlanItemInstance<?> pi, PlanItemTransition transition) {
        String eventToTrigger = AbstractStandardEventNode.getType(pi.getItem().getPlanItemEventName(), transition);
        Object eventObject = null;
        if (pi instanceof HumanTaskInstance) {
            eventObject = ((HumanTaskInstance) pi).getTask();
        }
        if (eventObject == null) {
            eventObject = "No task";
        }
        PlanItemEvent event = new PlanItemEvent(pi.getItem().getPlanItemEventName(), transition, eventObject);
        pi.getCaseInstance().signalEvent(eventToTrigger, event);
    }

    public void disable(ControllableItemInstance<?> pi) {
        validateTransition(pi, DISABLE);
        signalEvent(pi, PlanItemTransition.DISABLE);
        pi.setPlanElementState(DISABLED);
    }

    public void reenable(ControllableItemInstance<?> pi) {
        validateTransition(pi, REENABLE);
        signalEvent(pi, PlanItemTransition.REENABLE);
        pi.setPlanElementState(ENABLED);
    }

    public void start(ControllableItemInstance<?> pi) {
        validateTransition(pi, START);
        signalEvent(pi, PlanItemTransition.START);
        setActive(pi);
    }

    public void manualStart(ControllableItemInstance<?> pi) {
        validateTransition(pi, MANUAL_START);
        signalEvent(pi, PlanItemTransition.MANUAL_START);
        setActive(pi);
    }

    public void reactivate(PlanElementLifecycle pi) {
        validateTransition(pi, REACTIVATE);
        if (pi instanceof PlanItemInstance) {
            signalEvent((PlanItemInstance<?>) pi, PlanItemTransition.REACTIVATE);
        }
        if (pi instanceof CaseInstance) {
            if (pi.getPlanElementState() == SUSPENDED) {
                resumeChildren((PlanItemInstanceContainer) pi);
            } else {
                // TODO find out
            }
        }
        setActive(pi);
    }

    public void suspend(PlanElementLifecycle pi) {
        validateTransition(pi, SUSPEND);
        if (pi instanceof PlanItemInstance) {
            signalEvent((PlanItemInstance<?>) pi, PlanItemTransition.SUSPEND);
        }
        pi.setPlanElementState(SUSPENDED);
        if (pi instanceof PlanItemInstanceContainer) {
            PlanItemInstanceContainer pic = (PlanItemInstanceContainer) pi;
            Collection<? extends PlanItemInstance<?>> children = pic.getChildren();
            for (PlanItemInstance<?> child : children) {
                if (child.getPlanElementState().isBusyState(child)) {
                    if (isComplexLifecycle(child)) {
                        ((PlanItemInstanceLifecycleWithHistory<?>) child).parentSuspend();
                    } else if (child instanceof OccurrablePlanItemInstance) {
                        ((OccurrablePlanItemInstance<?>) child).suspend();
                    }
                }
            }
        }
    }

    public void resume(PlanItemInstance<?> pi) {
        validateTransition(pi, RESUME);
        signalEvent(pi, PlanItemTransition.RESUME);
        if (pi instanceof ControllableItemInstance) {
            setActive(pi);
        } else {
            pi.setPlanElementState(AVAILABLE);
        }
        if (pi instanceof PlanItemInstanceContainer) {
            resumeChildren((PlanItemInstanceContainer) pi);
        }
    }

    private void setActive(PlanElementLifecycle pi) {
        pi.setPlanElementState(ACTIVE);
        pi.getCaseInstance().markSubscriptionsForUpdate();
        if (pi instanceof PlanItemInstanceContainer) {
            Collection<? extends PlanItemInstance<?>> children = ((PlanItemInstanceContainer) pi).getChildren();
            for (PlanItemInstance<?> child : children) {
                if (child instanceof ControllableItemInstance && child.getPlanElementState() == INITIAL) {
                    child.setPlanElementState(AVAILABLE);
                    ((ControllableItemInstance<?>) child).noteInstantiation();
                }
            }
        }
    }

    public static void resumeChildren(PlanItemInstanceContainer pi) {
        Collection<? extends PlanItemInstance<?>> children = pi.getChildren();
        for (PlanItemInstance<?> child : children) {
            if (child.getPlanElementState() == SUSPENDED) {
                if (child instanceof OccurrablePlanItemInstance) {
                    ((OccurrablePlanItemInstance<?>) child).resume();
                } else if (isComplexLifecycle(child)) {
                    ((PlanItemInstanceLifecycleWithHistory<?>) child).parentResume();
                }
            }
        }
    }

    public void terminate(PlanElementLifecycle pi) {
        validateTransition(pi, TERMINATE);
        if (pi instanceof PlanItemInstance) {
            signalEvent((PlanItemInstance<?>) pi, PlanItemTransition.TERMINATE);
        }
        pi.setPlanElementState(TERMINATED);
        if (pi instanceof PlanItemInstanceContainer) {
            terminateChildren((PlanItemInstanceContainer) pi);
        }
    }

    public static void terminateChildren(PlanItemInstanceContainer pi2) {
        Collection<? extends PlanItemInstance<?>> children = pi2.getChildren();
        for (PlanItemInstance<?> child : children) {
            if (!child.getPlanElementState().isTerminalState()) {
                if (isComplexLifecycle(child)) {
                    ((PlanItemInstanceLifecycleWithHistory<?>) child).exit();
                } else if (child instanceof OccurrablePlanItemInstance) {
                    ((OccurrablePlanItemInstance<?>) child).parentTerminate();
                }
            }
        }
    }

    public void exit(PlanItemInstanceLifecycleWithHistory<?> pi) {
        validateTransition(pi, EXIT);
        signalEvent(pi, PlanItemTransition.EXIT);
        pi.setPlanElementState(TERMINATED);
    }

    public void complete(PlanElementLifecycle pi) {
        validateTransition(pi, COMPLETE);
        if (pi instanceof PlanItemInstance) {
            signalEvent((PlanItemInstance<?>) pi, PlanItemTransition.COMPLETE);
        }
        pi.setPlanElementState(COMPLETED);
        pi.getCaseInstance().markSubscriptionsForUpdate();
    }

    public void parentSuspend(PlanItemInstanceLifecycleWithHistory<?> pi) {
        validateTransition(pi, PARENT_SUSPEND);
        signalEvent(pi, PlanItemTransition.PARENT_SUSPEND);
        pi.setLastBusyState(pi.getPlanElementState());
        pi.setPlanElementState(SUSPENDED);
    }

    public void parentResume(PlanItemInstanceLifecycleWithHistory<?> pi) {
        validateTransition(pi, PARENT_RESUME);
        signalEvent(pi, PlanItemTransition.PARENT_RESUME);
        pi.setPlanElementState(pi.getLastBusyState());
    }

    public void parentTerminate(PlanItemInstance<?> pi) {
        validateTransition(pi, PARENT_TERMINATE);
        signalEvent(pi, PlanItemTransition.PARENT_TERMINATE);
        pi.setPlanElementState(TERMINATED);
    }

    public void create(PlanElementLifecycle pi) {
        validateTransition(pi, CREATE);
        if (pi instanceof PlanItemInstance) {
            signalEvent((PlanItemInstance<?>) pi, PlanItemTransition.CREATE);
        }
        pi.setPlanElementState(AVAILABLE);
    }

    public void create(PlanItemInstanceLifecycleWithHistory<?> pi) {
        PlanItemTransition transition = PlanItemTransition.CREATE;
        String eventToTrigger = AbstractStandardEventNode.getType(pi.getItem().getPlanItemEventName(), transition);
        Object eventObject = null;
        if (eventObject == null) {
            eventObject = new Object();
        }
        PlanItemEvent event = new PlanItemEvent(pi.getItem().getPlanItemEventName(), transition, eventObject);
        pi.getCaseInstance().signalEvent(eventToTrigger, event);
        pi.setPlanElementState(AVAILABLE);
    }

    public void fault(PlanElementLifecycle pi) {
        validateTransition(pi, FAULT);
        if (pi instanceof PlanItemInstance) {
            signalEvent((PlanItemInstance<?>) pi, PlanItemTransition.FAULT);
        }
        pi.setPlanElementState(FAILED);
    }

    public void occur(OccurrablePlanItemInstance<?> pi) {
        validateTransition(pi, OCCUR);
        signalEvent(pi, PlanItemTransition.OCCUR);
        pi.setPlanElementState(COMPLETED);
    }

    public void close(CaseInstance pi) {
        validateTransition(pi, CLOSE);
        if (pi instanceof PlanItemInstance) {
            signalEvent((PlanItemInstance<?>) pi, PlanItemTransition.CLOSE);
        }
        pi.setPlanElementState(CLOSED);
    }

    public PlanItemTransition[] getSupportedTransitions(PlanElementLifecycle pii) {
        return new PlanItemTransition[0];
    }

    public boolean isTerminalState() {
        return this == CLOSED || this == COMPLETED || this == TERMINATED;
    }

    public boolean isSemiTerminalState(PlanElementLifecycle pe) {
        if (pe instanceof CaseInstance) {
            return this == DISABLED || this == FAILED || this == COMPLETED;
        } else {
            if (isComplexLifecycle(pe)) {
                return this == DISABLED || this == FAILED;
            } else {
                return false;
            }
        }
    }

    private static boolean isComplexLifecycle(PlanElementLifecycle pe) {
        if (pe instanceof PlanItemInstanceLifecycleWithHistory) {
            return ((PlanItemInstanceLifecycleWithHistory<?>) pe).isComplexLifecycle();
        }
        return false;
    }

    public void stop(HumanTaskInstance pi) {
        validateTransition(pi, STOP);
        signalEvent(pi, PlanItemTransition.STOP);
        pi.setPlanElementState(ENABLED);
    }
}
