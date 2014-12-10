/**
 */
package org.omg.cmmn1.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.THumanTask;
import org.omg.cmmn1.TPlanningTable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>THuman Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.THumanTaskImpl#getPlanningTable <em>Planning Table</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.THumanTaskImpl#getPerformerRef <em>Performer Ref</em>}</li>
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
	 * The default value of the '{@link #getPerformerRef() <em>Performer Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformerRef()
	 * @generated
	 * @ordered
	 */
	protected static final String PERFORMER_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPerformerRef() <em>Performer Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformerRef()
	 * @generated
	 * @ordered
	 */
	protected String performerRef = PERFORMER_REF_EDEFAULT;

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
	public String getPerformerRef() {
		return performerRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerformerRef(String newPerformerRef) {
		String oldPerformerRef = performerRef;
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
				return getPerformerRef();
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
				setPerformerRef((String)newValue);
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
				setPerformerRef(PERFORMER_REF_EDEFAULT);
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
				return PERFORMER_REF_EDEFAULT == null ? performerRef != null : !PERFORMER_REF_EDEFAULT.equals(performerRef);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (performerRef: ");
		result.append(performerRef);
		result.append(')');
		return result.toString();
	}

} //THumanTaskImpl
