/**
 */
package org.omg.cmmn1.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.TDiscretionaryItem;
import org.omg.cmmn1.TPlanItemControl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TDiscretionary Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TDiscretionaryItemImpl#getItemControl <em>Item Control</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TDiscretionaryItemImpl#getDefinitionRef <em>Definition Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TDiscretionaryItemImpl extends TTableItemImpl implements TDiscretionaryItem {
	/**
	 * The cached value of the '{@link #getItemControl() <em>Item Control</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemControl()
	 * @generated
	 * @ordered
	 */
	protected TPlanItemControl itemControl;

	/**
	 * The default value of the '{@link #getDefinitionRef() <em>Definition Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionRef()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinitionRef() <em>Definition Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionRef()
	 * @generated
	 * @ordered
	 */
	protected String definitionRef = DEFINITION_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TDiscretionaryItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TDISCRETIONARY_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPlanItemControl getItemControl() {
		return itemControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItemControl(TPlanItemControl newItemControl, NotificationChain msgs) {
		TPlanItemControl oldItemControl = itemControl;
		itemControl = newItemControl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL, oldItemControl, newItemControl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemControl(TPlanItemControl newItemControl) {
		if (newItemControl != itemControl) {
			NotificationChain msgs = null;
			if (itemControl != null)
				msgs = ((InternalEObject)itemControl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL, null, msgs);
			if (newItemControl != null)
				msgs = ((InternalEObject)newItemControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL, null, msgs);
			msgs = basicSetItemControl(newItemControl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL, newItemControl, newItemControl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefinitionRef() {
		return definitionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitionRef(String newDefinitionRef) {
		String oldDefinitionRef = definitionRef;
		definitionRef = newDefinitionRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDISCRETIONARY_ITEM__DEFINITION_REF, oldDefinitionRef, definitionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL:
				return basicSetItemControl(null, msgs);
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
			case Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL:
				return getItemControl();
			case Cmmn1Package.TDISCRETIONARY_ITEM__DEFINITION_REF:
				return getDefinitionRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL:
				setItemControl((TPlanItemControl)newValue);
				return;
			case Cmmn1Package.TDISCRETIONARY_ITEM__DEFINITION_REF:
				setDefinitionRef((String)newValue);
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
			case Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL:
				setItemControl((TPlanItemControl)null);
				return;
			case Cmmn1Package.TDISCRETIONARY_ITEM__DEFINITION_REF:
				setDefinitionRef(DEFINITION_REF_EDEFAULT);
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
			case Cmmn1Package.TDISCRETIONARY_ITEM__ITEM_CONTROL:
				return itemControl != null;
			case Cmmn1Package.TDISCRETIONARY_ITEM__DEFINITION_REF:
				return DEFINITION_REF_EDEFAULT == null ? definitionRef != null : !DEFINITION_REF_EDEFAULT.equals(definitionRef);
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
		result.append(" (definitionRef: ");
		result.append(definitionRef);
		result.append(')');
		return result.toString();
	}

} //TDiscretionaryItemImpl
