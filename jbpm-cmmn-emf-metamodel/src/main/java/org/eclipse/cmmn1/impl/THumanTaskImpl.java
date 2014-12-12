/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.THumanTask;
import org.eclipse.cmmn1.TPlanningTable;
import org.eclipse.cmmn1.TRole;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>THuman Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.THumanTaskImpl#getPlanningTable <em>Planning Table</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.THumanTaskImpl#getPerformerRef <em>Performer Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class THumanTaskImpl extends TTaskImpl implements THumanTask {
    /**
     * The cached value of the '{@link #getPlanningTable() <em>Planning Table</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPlanningTable()
     * @generated
     * @ordered
     */
    protected EList<TPlanningTable> planningTable;

    /**
     * The cached value of the '{@link #getPerformerRef() <em>Performer Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPerformerRef()
     * @generated
     * @ordered
     */
    protected TRole performerRef;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected THumanTaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.THUMAN_TASK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TPlanningTable> getPlanningTable() {
        if (planningTable == null) {
            planningTable = new EObjectContainmentEList<TPlanningTable>(TPlanningTable.class, this, Cmmn1Package.THUMAN_TASK__PLANNING_TABLE);
        }
        return planningTable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRole getPerformerRef() {
        if (performerRef != null && performerRef.eIsProxy()) {
            InternalEObject oldPerformerRef = (InternalEObject)performerRef;
            performerRef = (TRole)eResolveProxy(oldPerformerRef);
            if (performerRef != oldPerformerRef) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Cmmn1Package.THUMAN_TASK__PERFORMER_REF, oldPerformerRef, performerRef));
            }
        }
        return performerRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRole basicGetPerformerRef() {
        return performerRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPerformerRef(TRole newPerformerRef) {
        TRole oldPerformerRef = performerRef;
        performerRef = newPerformerRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.THUMAN_TASK__PERFORMER_REF, oldPerformerRef, performerRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.THUMAN_TASK__PLANNING_TABLE:
                return ((InternalEList<?>)getPlanningTable()).basicRemove(otherEnd, msgs);
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
            case Cmmn1Package.THUMAN_TASK__PLANNING_TABLE:
                return getPlanningTable();
            case Cmmn1Package.THUMAN_TASK__PERFORMER_REF:
                if (resolve) return getPerformerRef();
                return basicGetPerformerRef();
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
            case Cmmn1Package.THUMAN_TASK__PLANNING_TABLE:
                getPlanningTable().clear();
                getPlanningTable().addAll((Collection<? extends TPlanningTable>)newValue);
                return;
            case Cmmn1Package.THUMAN_TASK__PERFORMER_REF:
                setPerformerRef((TRole)newValue);
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
            case Cmmn1Package.THUMAN_TASK__PLANNING_TABLE:
                getPlanningTable().clear();
                return;
            case Cmmn1Package.THUMAN_TASK__PERFORMER_REF:
                setPerformerRef((TRole)null);
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
            case Cmmn1Package.THUMAN_TASK__PLANNING_TABLE:
                return planningTable != null && !planningTable.isEmpty();
            case Cmmn1Package.THUMAN_TASK__PERFORMER_REF:
                return performerRef != null;
        }
        return super.eIsSet(featureID);
    }

} //THumanTaskImpl
