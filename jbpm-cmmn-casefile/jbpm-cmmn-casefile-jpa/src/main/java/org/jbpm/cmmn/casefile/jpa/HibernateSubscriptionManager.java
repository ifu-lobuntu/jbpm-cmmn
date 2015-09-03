package org.jbpm.cmmn.casefile.jpa;

import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.impl.util.SubscriptionUtil;
import org.jbpm.cmmn.instance.subscription.*;
import org.kie.api.runtime.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.Map.Entry;

public class HibernateSubscriptionManager
        implements SubscriptionManager<JpaCaseFileItemSubscription> {
    static Logger logger = LoggerFactory.getLogger(HibernateSubscriptionManager.class);
    JpaCaseFilePersistence p;

    public HibernateSubscriptionManager(JpaCaseFilePersistence persistence) {
        super();
        this.p = persistence;
    }


    @Override
    public JpaCaseFileItemSubscription createSubscription(Object object) {
        JpaCaseFileItemSubscription result = new JpaCaseFileItemSubscription();
        Class<?> entityClass = JpaIdUtil.INSTANCE.findEntityClass(object.getClass());
        String stringifiedObjectId = JpaIdUtil.INSTANCE.getId(JpaIdUtil.INSTANCE.findIdMember(entityClass), object).toString();
        result.setObjectType(entityClass.getName());
        result.setStringifiedObjectId(stringifiedObjectId);
        return result;
    }

    @Override
    public void setSubscriptions(CaseInstance caseInstance, Set<JpaCaseFileItemSubscription> newSubscriptions) {
        Set<JpaCaseFileItemSubscription> existingSubscriptions = new HashSet<JpaCaseFileItemSubscription>(getCaseSubscriptionInfoFor(caseInstance));
        Set<JpaCaseFileItemSubscription> obsoleteSubscriptions = new HashSet<JpaCaseFileItemSubscription>(existingSubscriptions);
        obsoleteSubscriptions.removeAll(newSubscriptions);
        for (JpaCaseFileItemSubscription oldSubscription : obsoleteSubscriptions) {
            p.remove(oldSubscription);
        }
        newSubscriptions.removeAll(existingSubscriptions);
        for (JpaCaseFileItemSubscription newSubscription : newSubscriptions) {
            p.persist(newSubscription);
        }
    }

    @Override
    public Collection<JpaCaseFileItemSubscription> getCaseSubscriptionInfoFor(Object object) {
        EntityManager em = p.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<JpaCaseFileItemSubscription> q = criteriaBuilder.createQuery(JpaCaseFileItemSubscription.class);
        Root<JpaCaseFileItemSubscription> from = q.from(JpaCaseFileItemSubscription.class);
        Class<?> entityClass = JpaIdUtil.INSTANCE.findEntityClass(object.getClass());
        String stringifiedObjectId = JpaIdUtil.INSTANCE.getId(JpaIdUtil.INSTANCE.findIdMember(entityClass), object).toString();
        Predicate objectTypePredicate = criteriaBuilder.equal(from.get("objectType"), criteriaBuilder.literal(entityClass.getName()));
        Predicate stringifiedObjectIdPredicate = criteriaBuilder.equal(from.get("stringifiedObjectId"), stringifiedObjectId);
        q.where(criteriaBuilder.and(objectTypePredicate, stringifiedObjectIdPredicate));
        q.distinct(true);
        TypedQuery<JpaCaseFileItemSubscription> typedQuery = em.createQuery(q);
        return typedQuery.getResultList();
    }

    @Override
    public Collection<JpaCaseFileItemSubscription> getCaseSubscriptionInfoFor(CaseInstance caseInstance) {
        EntityManager em = p.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<JpaCaseFileItemSubscription> q = criteriaBuilder.createQuery(JpaCaseFileItemSubscription.class);
        Root<JpaCaseFileItemSubscription> from = q.from(JpaCaseFileItemSubscription.class);
        Predicate processInstanceIdPredicate = criteriaBuilder.equal(from.get("processInstanceId"), criteriaBuilder.literal(caseInstance.getId()));
        Predicate deploymentIdPredicate = criteriaBuilder.equal(from.get("deploymentId"), criteriaBuilder.literal(caseInstance.getKnowledgeRuntime().getEnvironment().get("deploymentId")));
        q.where(criteriaBuilder.and(processInstanceIdPredicate, deploymentIdPredicate));
        q.distinct(true);
        TypedQuery<JpaCaseFileItemSubscription> typedQuery = em.createQuery(q);
        return typedQuery.getResultList();
    }

}
