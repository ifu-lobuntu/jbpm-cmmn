/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TPlanFragment;
import org.eclipse.cmmn1.TPlanItem;
import org.eclipse.cmmn1.TSentry;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TPlan Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TPlanFragmentImpl#getPlanItem <em>Plan Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TPlanFragmentImpl#getSentry <em>Sentry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TPlanFragmentImpl extends TPlanItemDefinitionImpl implements TPlanFragment {
    /**
     * The cached value of the '{@link #getPlanItem() <em>Plan Item</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPlanItem()
     * @generated
     * @ordered
     */
    protected EList<TPlanItem> planItem;

    /**
     * The cached value of the '{@link #getSentry() <em>Sentry</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSentry()
     * @generated
     * @ordered
     */
    protected EList<TSentry> sentry;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TPlanFragmentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TPLAN_FRAGMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TPlanItem> getPlanItem() {
        if (planItem == null) {
            planItem = new EObjectContainmentEList<TPlanItem>(TPlanItem.class, this, Cmmn1Package.TPLAN_FRAGMENT__PLAN_ITEM);
        }
        return planItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TSentry> getSentry() {
        if (sentry == null) {
            sentry = new EObjectContainmentEList<TSentry>(TSentry.class, this, Cmmn1Package.TPLAN_FRAGMENT__SENTRY);
        }
        return sentry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TPLAN_FRAGMENT__PLAN_ITEM:
                return ((InternalEList<?>)getPlanItem()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TPLAN_FRAGMENT__SENTRY:
                return ((InternalEList<?>)getSentry()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case Cmmn1Package.TPLAN_FRAGMENT__PLAN_ITEM:
                return getPlanItem();
            case Cmmn1Package.TPLAN_FRAGMENT__SENTRY:
                return getSentry();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case Cmmn1Package.TPLAN_FRAGMENT__PLAN_ITEM:
                getPlanItem().clear();
                getPlanItem().addAll((Collection<? extends TPlanItem>)newValue);
                return;
            case Cmmn1Package.TPLAN_FRAGMENT__SENTRY:
                getSentry().clear();
                getSentry().addAll((Collection<? extends TSentry>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case Cmmn1Package.TPLAN_FRAGMENT__PLAN_ITEM:
                getPlanItem().clear();
                return;
            case Cmmn1Package.TPLAN_FRAGMENT__SENTRY:
                getSentry().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case Cmmn1Package.TPLAN_FRAGMENT__PLAN_ITEM:
                return planItem != null && !planItem.isEmpty();
            case Cmmn1Package.TPLAN_FRAGMENT__SENTRY:
                return sentry != null && !sentry.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //TPlanFragmentImpl
