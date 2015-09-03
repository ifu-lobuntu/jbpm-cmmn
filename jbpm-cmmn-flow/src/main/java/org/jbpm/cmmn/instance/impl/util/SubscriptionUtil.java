package org.jbpm.cmmn.instance.impl.util;

import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.flow.common.impl.CaseFileItemStandardEventNodeImpl;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.OnPartInstance;
import org.jbpm.cmmn.instance.PlanElementState;
import org.jbpm.cmmn.instance.PlanItemInstanceContainer;
import org.jbpm.cmmn.instance.subscription.DurableCaseFileItemSubscription;
import org.jbpm.cmmn.instance.subscription.ScopedCaseFileItemSubscription;
import org.jbpm.cmmn.instance.subscription.SubscriptionManager;
import org.jbpm.cmmn.instance.subscription.TaskInstance;
import org.jbpm.cmmn.instance.subscription.impl.ScopedCaseFileItemSubscriptionImpl;
import org.kie.api.runtime.process.NodeInstance;

import java.util.*;

public class SubscriptionUtil {
    public static Set<ScopedCaseFileItemSubscription> findScopedCaseFileItemSubscriptions(CaseInstance caseInstance) {
        Set<CaseParameter> params = getAllSubscribingParameters(caseInstance);
        Map<OnPartInstance, ScopedCaseFileItemSubscription> onCaseFileItemParts = new HashMap<OnPartInstance, ScopedCaseFileItemSubscription>();
        addScopedFileItemSubscriptionsForParameters(params, caseInstance, onCaseFileItemParts);
        Collection<ScopedCaseFileItemSubscription> values = onCaseFileItemParts.values();
        return new HashSet<ScopedCaseFileItemSubscription>(values);
    }

    private static Set<CaseParameter> getAllSubscribingParameters(CaseInstance caseInstance) {
        Set<CaseParameter> params = new HashSet<CaseParameter>();
        params.addAll(caseInstance.getCase().getInputParameters());
        addSubscribingTaskParameters(params, caseInstance);
        return params;
    }

    private static boolean isSubscribing(TaskInstance<?> ni) {
        return ni.getPlanElementState() == PlanElementState.ACTIVE || ni.getPlanElementState() == PlanElementState.ENABLED;
    }


    private static void addSubscribingTaskParameters(Set<CaseParameter> params, PlanItemInstanceContainer caseInstance) {
        for (NodeInstance ni : caseInstance.getNodeInstances(true)) {
            if (ni instanceof TaskInstance && isSubscribing((TaskInstance<?>) ni)) {
                TaskInstance<?> ti = (TaskInstance) ni;
                params.addAll(ti.getItem().getDefinition().getOutputs());
            }
        }
    }


    private static void addScopedFileItemSubscriptionsForParameters(Collection<CaseParameter> items, PlanItemInstanceContainer container,
                                                                    Map<OnPartInstance, ScopedCaseFileItemSubscription> target) {
        Collection<org.jbpm.workflow.instance.NodeInstance> nodeInstances = container.getNodeInstances(true);
        for (CaseParameter parameter : items) {
            for (NodeInstance node : nodeInstances) {
                if (node instanceof OnPartInstance) {
                    OnPartInstance onPartInstance = (OnPartInstance) node;
                    if (onPartInstance.getOnPart() instanceof CaseFileItemStandardEventNodeImpl) {
                        CaseFileItemStandardEventNodeImpl onPart = (CaseFileItemStandardEventNodeImpl) onPartInstance.getOnPart();
                        if (onPart.getSourceCaseFileItem().getElementId().equals(parameter.getBoundVariable().getElementId())) {
                            ScopedCaseFileItemSubscription subscription = target.get(onPartInstance);
                            if (subscription == null) {
                                target.put(onPartInstance, new ScopedCaseFileItemSubscriptionImpl(onPartInstance, parameter));
                            } else {
                                subscription.addSubscribingParameter(parameter);
                            }
                        }
                    }
                }
            }
        }
    }


    public static Set<DurableCaseFileItemSubscription> buildCurrentDurableSubscriptionSet(CaseInstance caseInstance, SubscriptionManager sm) {
        Set<ScopedCaseFileItemSubscription> inScope = findScopedCaseFileItemSubscriptions(caseInstance);
        return buildDurableCaseFileItemSubscriptions(caseInstance, sm, inScope);
    }

    private static Set<DurableCaseFileItemSubscription> buildDurableCaseFileItemSubscriptions(CaseInstance caseInstance, SubscriptionManager sm, Set<ScopedCaseFileItemSubscription> inScope) {
        Set<DurableCaseFileItemSubscription> result = new HashSet<DurableCaseFileItemSubscription>();
        for (ScopedCaseFileItemSubscription s : inScope) {
            Set<Object> objectsSubscribedTo = findObjectsSubscribedTo(caseInstance, s);
            for (Object o : objectsSubscribedTo) {
                DurableCaseFileItemSubscription subscription = sm.createSubscription(o);
                copyInto(s, subscription);
                result.add(subscription);
            }
        }
        return result;
    }

    private static void copyInto(ScopedCaseFileItemSubscription s, DurableCaseFileItemSubscription subscription) {
        subscription.setDeploymentId((String) s.getKnowledgeRuntime().getEnvironment().get("deploymentId"));
        subscription.setProcessInstanceId(s.getProcessInstanceId());
        subscription.setItemName(s.getItemName());
        subscription.setRelatedItemName(s.getRelatedItemName());
        subscription.setTransition(s.getTransition());
    }

    private static Set<Object> findObjectsSubscribedTo(CaseInstance caseInstance, ScopedCaseFileItemSubscription s) {
        Set<Object> objectsSubscribedTo = new HashSet<Object>();
        for (CaseParameter p : s.getSubscribingParameters()) {
            Object val;
            if (s.getTransition() == CaseFileItemTransition.CREATE || s.getTransition() == CaseFileItemTransition.DELETE) {
                if (p.getBindingRefinement() != null && p.getBindingRefinement().isValid()) {
                    val = ExpressionUtil.readFromBindingRefinementParent(p, caseInstance, null);
                } else {
                    throw new IllegalStateException("CaseFileItem events for Create and Delete transitions need to specify bindingRefinements because it would be impractical to have  a gobal listener for all removes or adds");
                    //TODO BIG TODO - generate events when objects are added/removed from the case instance itself
                }
            } else {
                if (p.getBindingRefinement() == null || !p.getBindingRefinement().isValid()) {
                    val = caseInstance.getVariable(p.getBoundVariable().getName());
                } else {
                    val = ExpressionUtil.readFromBindingRefinement(p, caseInstance, null);
                }
            }
            if (val instanceof Collection) {
                objectsSubscribedTo.addAll((Collection<?>) val);
            } else if (val != null) {
                objectsSubscribedTo.add(val);
            }//TODO iterators? (for JCR, bleh!)
        }
        return objectsSubscribedTo;
    }
}
