package org.jbpm.cmmn.casefile.jpa;


import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.event.spi.*;
import org.hibernate.type.OneToOneType;
import org.jbpm.cmmn.flow.common.CaseFileItemTransition;
import org.jbpm.cmmn.instance.CaseFileItemEvent;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.subscription.CaseFileItemSubscription;
import org.jbpm.cmmn.instance.subscription.DurableCaseFileItemSubscription;
import org.jbpm.cmmn.instance.subscription.ScopedCaseFileItemSubscription;
import org.jbpm.cmmn.instance.subscription.impl.DemarcatedSubscriptionContext;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.jbpm.cmmn.flow.common.CaseFileItemTransition.*;

public class HibernateCaseFileItemEventGenerator implements
        PostInsertEventListener, PostDeleteEventListener, FlushEntityEventListener, FlushEventListener {

    @Override
    public void onFlushEntity(FlushEntityEvent event) throws HibernateException {
        if (event.getEntityEntry().isExistsInDatabase()
                && !(event.getEntity() instanceof JpaCaseFileItemSubscription)) {
            /*
             * Only interested in existing objects - new ones won't have subscriptions yet, and the CREATE subscription
			 * is stored against the parent
			 */
            Object entity = event.getEntity();
            Set<DirtyOneToOne> dirtyOneToOnes = new HashSet<DirtyOneToOne>();
            Collection<? extends JpaCaseFileItemSubscription> caseFileItemSubscriptions = getCaseFileItemSubscriptions(entity, event.getSession());
            fireEventsFor(event, dirtyOneToOnes, caseFileItemSubscriptions);
            fireEventsFor(event, dirtyOneToOnes, DemarcatedSubscriptionContext.getSubscriptionsInScopeForFor(event.getEntity(), ADD_CHILD, ADD_REFERENCE,
                    REMOVE_CHILD, REMOVE_REFERENCE, UPDATE));
            /**
             * For inverse OneToOnes to always allow for positive dirty comparison, whenever a change is made it needs
             * to be reflected in the loadedState
             */
            for (DirtyOneToOne dirtyOneToOne : dirtyOneToOnes) {
                event.getEntityEntry().getLoadedState()[dirtyOneToOne.i] = dirtyOneToOne.newValue;
            }
        }
    }

    Collection<? extends JpaCaseFileItemSubscription> getCaseFileItemSubscriptions(Object object, EventSource s) {

        Criteria criteria = s.createCriteria(JpaCaseFileItemSubscription.class);
        Class<?> entityClass = JpaIdUtil.INSTANCE.findEntityClass(object.getClass());
        criteria.add(Restrictions.eq("objectType", entityClass.getName()));
        String stringifiedObjectId = JpaIdUtil.INSTANCE.getId( JpaIdUtil.INSTANCE.findIdMember(entityClass), object).toString();
        criteria.add(Restrictions.eq("stringifiedObjectId", stringifiedObjectId));
        criteria.setFlushMode(FlushMode.MANUAL);
        return criteria.list();
    }

    protected void fireEventsFor(FlushEntityEvent event, Set<DirtyOneToOne> dirtyOneToOnes,
                                 Collection<? extends CaseFileItemSubscription> caseFileItemSubscriptions) {
        for (CaseFileItemSubscription is : caseFileItemSubscriptions) {
            if (is.getTransition() == CaseFileItemTransition.UPDATE) {
                fireUpdateEventIfDirty(event, is);
            } else {
                fireStructuralEvents(event, is, dirtyOneToOnes);
            }
        }
    }

    private void fireStructuralEvents(FlushEntityEvent event, CaseFileItemSubscription is, Set<DirtyOneToOne> dirtyOneToOnes) {
        for (int i = 0; i < event.getEntityEntry().getLoadedState().length; i++) {
            String propertyName = event.getEntityEntry().getPersister().getPropertyNames()[i];
            if (isMatchingCreateOrDelete(is, propertyName) || isMatchingAddOrRemove(is, propertyName)) {
                if (event.getPropertyValues()[i] instanceof Collection) {
                    fireCollectionEvents(event, is, i);
                } else {
                    DirtyOneToOne dirtyProp = fireSingletonEvents(event, is, i);
                    if (dirtyProp != null) {
                        dirtyOneToOnes.add(dirtyProp);
                    }
                }
            }
        }
    }

    private boolean isMatchingAddChild(CaseFileItemSubscription is, String propertyName) {
        return is.getRelatedItemName() != null && propertyName.equals(is.getRelatedItemName())
                && (is.getTransition() == CaseFileItemTransition.ADD_CHILD);
    }

    private boolean isMatchingCreate(CaseFileItemSubscription is, String propertyName) {
        return propertyName.equals(is.getItemName()) && (is.getTransition() == CaseFileItemTransition.CREATE);
    }

    private boolean isMatchingRemoveChild(CaseFileItemSubscription is, String propertyName) {
        return is.getRelatedItemName() != null && propertyName.equals(is.getRelatedItemName())
                && (is.getTransition() == CaseFileItemTransition.REMOVE_CHILD);
    }

    private boolean isMatchingDelete(CaseFileItemSubscription is, String propertyName) {
        return propertyName.equals(is.getItemName()) && (is.getTransition() == CaseFileItemTransition.DELETE);
    }

    private boolean isMatchingAddOrRemove(CaseFileItemSubscription is, String propertyName) {
        return is.getRelatedItemName() != null
                && propertyName.equals(is.getRelatedItemName())
                && (is.getTransition() == CaseFileItemTransition.ADD_CHILD || is.getTransition() == CaseFileItemTransition.REMOVE_CHILD
                || is.getTransition() == CaseFileItemTransition.ADD_REFERENCE || is.getTransition() == CaseFileItemTransition.REMOVE_REFERENCE);
    }

    protected boolean isMatchingCreateOrDelete(CaseFileItemSubscription is, String propertyName) {
		/*
		 * In the case of CREATE and DELETE the itemName is actually the name of
		 * the property on the parent to the child
		 */
        return propertyName.equals(is.getItemName())
                && (is.getTransition() == CaseFileItemTransition.CREATE || is.getTransition() == CaseFileItemTransition.DELETE);
    }


    private DirtyOneToOne fireSingletonEvents(FlushEntityEvent event, CaseFileItemSubscription is, int i) {
        Object oldValue = event.getEntityEntry().getLoadedState()[i];
        Object owner = event.getEntity();
        Object newValue = event.getPropertyValues()[i];
        if (isEntityValueDirty(oldValue, newValue, event.getSession())) {
            if (oldValue != null) {
                if (is.getTransition() == CaseFileItemTransition.DELETE || is.getTransition() == CaseFileItemTransition.REMOVE_CHILD
                        || is.getTransition() == CaseFileItemTransition.REMOVE_REFERENCE) {
                    queueEvent(is, owner, oldValue);
                }
            }
            if (newValue != null) {
                if (is.getTransition() == CaseFileItemTransition.CREATE || is.getTransition() == CaseFileItemTransition.ADD_CHILD
                        || is.getTransition() == CaseFileItemTransition.ADD_REFERENCE) {
                    queueEvent(is, owner, newValue);
                }
            }
            if (event.getEntityEntry().getPersister().getPropertyTypes()[i] instanceof OneToOneType) {
                return new DirtyOneToOne(newValue, i);
            }
        }
        return null;
    }

    private boolean isEntityValueDirty(Object oldValue, Object newValue, EventSource session) {
        if (oldValue == null) {
            return newValue != null;
        } else if (newValue == null) {
            return oldValue != null;
        } else {
            return !(oldValue == newValue || oldValue.equals(newValue));
        }
    }

    private void fireCollectionEvents(FlushEntityEvent event, CaseFileItemSubscription is, int i) {
        Collection<?> newState = (Collection<?>) event.getPropertyValues()[i];
        Collection<?> oldState = null;
        // TODO this forces a read - try to optimize
        newState.size();
        if (newState instanceof PersistentCollection) {
            Serializable storedSnapshot = ((PersistentCollection) newState).getStoredSnapshot();
            if (storedSnapshot instanceof Map) {
                oldState = ((Map<?, ?>) storedSnapshot).values();
            } else {
                oldState = (Collection<?>) storedSnapshot;
            }
        }
        if (oldState == null) {
            oldState = new HashSet<Object>();
        }
        Object owner = event.getEntity();
        for (Object oldObject : oldState) {
            if (!newState.contains(oldObject)) {
                if (is.getTransition() == CaseFileItemTransition.DELETE || is.getTransition() == CaseFileItemTransition.REMOVE_CHILD
                        || is.getTransition() == CaseFileItemTransition.REMOVE_REFERENCE) {
                    queueEvent(is, owner, oldObject);
                }
            }
        }
        for (Object newObject : newState) {
            if (!oldState.contains(newObject)) {
                if (is.getTransition() == CaseFileItemTransition.CREATE || is.getTransition() == CaseFileItemTransition.ADD_CHILD
                        || is.getTransition() == CaseFileItemTransition.ADD_REFERENCE) {
                    queueEvent(is, owner, newObject);
                }
            }
        }
    }

    private void fireUpdateEventIfDirty(FlushEntityEvent event, CaseFileItemSubscription is) {
        for (int i = 0; i < event.getEntityEntry().getLoadedState().length; i++) {
            if (!event.getEntityEntry().getPersister().getPropertyTypes()[i].isEntityType()
                    && !event.getEntityEntry().getPersister().getPropertyTypes()[i].isCollectionType()
                    && event.getEntityEntry().getPersister().getPropertyTypes()[i].isDirty(event.getEntityEntry().getLoadedState()[i],
                    event.getPropertyValues()[i], event.getSession())) {
                queueEvent(is, event.getEntity(), event.getEntity());
                break;
            }
        }
    }

    @Override
    public void onFlush(FlushEvent event) throws HibernateException {
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        for (CaseFileItemSubscription s : DemarcatedSubscriptionContext.getSubscriptionsInScopeForFor(event.getEntity(), DELETE)) {
            queueEvent(s, null, event.getEntity());
        }

    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        for (CaseFileItemSubscription s : DemarcatedSubscriptionContext.getSubscriptionsInScopeForFor(event.getEntity(), CREATE)) {
            queueEvent(s, null, event.getEntity());
        }
    }

    protected void queueEvent(CaseFileItemSubscription is, Object parentObject, Object value) {
        CaseFileItemEvent event = new CaseFileItemEvent(is.getItemName(), is.getTransition(), parentObject, value);
        if (is instanceof ScopedCaseFileItemSubscription) {
            ScopedCaseFileItemSubscription opis = (ScopedCaseFileItemSubscription) is;
            CaseInstance ci = (CaseInstance) opis.getKnowledgeRuntime().getProcessInstance(opis.getProcessInstanceId());
            if (opis.meetsBindingRefinementCriteria(value, ci)) {
                String deploymentId = (String) opis.getKnowledgeRuntime().getEnvironment().get("deploymentId");
                EventQueues.queueEvent(deploymentId, ci.getId(), event);
            }
        } else if (is instanceof DurableCaseFileItemSubscription) {
            DurableCaseFileItemSubscription pcfis = (DurableCaseFileItemSubscription) is;
            //TODO figure out a way to check if it meets the bindingRefinementCriteria
            EventQueues.queueEvent(pcfis.getDeploymentId(), pcfis.getProcessInstanceId(), event);
        }
    }

    private static class DirtyOneToOne {
        int i;
        Object newValue;

        public DirtyOneToOne(Object newValue, int i) {
            super();
            this.newValue = newValue;
            this.i = i;
        }

    }
}
