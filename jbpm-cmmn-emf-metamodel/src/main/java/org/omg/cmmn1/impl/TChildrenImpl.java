/**
 */
package org.omg.cmmn1.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.TCaseFileItem;
import org.omg.cmmn1.TChildren;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TChildren</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TChildrenImpl#getCaseFileItem <em>Case File Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TChildrenImpl extends TCmmnElementImpl implements TChildren {
	/**
	 * The cached value of the '{@link #getCaseFileItem() <em>Case File Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseFileItem()
	 * @generated
	 * @ordered
	 */
	protected EList<TCaseFileItem> caseFileItem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TChildrenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TCHILDREN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCaseFileItem> getCaseFileItem() {
		if (caseFileItem == null) {
			caseFileItem = new EObjectContainmentEList<TCaseFileItem>(TCaseFileItem.class, this, Cmmn1Package.TCHILDREN__CASE_FILE_ITEM);
		}
		return caseFileItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cmmn1Package.TCHILDREN__CASE_FILE_ITEM:
				return ((InternalEList<?>)getCaseFileItem()).basicRemove(otherEnd, msgs);
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
			case Cmmn1Package.TCHILDREN__CASE_FILE_ITEM:
				return getCaseFileItem();
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
			case Cmmn1Package.TCHILDREN__CASE_FILE_ITEM:
				getCaseFileItem().clear();
				getCaseFileItem().addAll((Collection<? extends TCaseFileItem>)newValue);
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
			case Cmmn1Package.TCHILDREN__CASE_FILE_ITEM:
				getCaseFileItem().clear();
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
			case Cmmn1Package.TCHILDREN__CASE_FILE_ITEM:
				return caseFileItem != null && !caseFileItem.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TChildrenImpl
