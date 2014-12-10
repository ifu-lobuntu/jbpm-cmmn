/**
 */
package org.omg.cmmn1.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.TPlanItem;
import org.omg.cmmn1.TPlanItemControl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TPlan Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TPlanItemImpl#getItemControl <em>Item Control</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TPlanItemImpl#getDefinitionRef <em>Definition Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TPlanItemImpl#getEntryCriteriaRefs <em>Entry Criteria Refs</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TPlanItemImpl#getExitCriteriaRefs <em>Exit Criteria Refs</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TPlanItemImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TPlanItemImpl extends TCmmnElementImpl implements TPlanItem {
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
	 * The default value of the '{@link #getEntryCriteriaRefs() <em>Entry Criteria Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryCriteriaRefs()
	 * @generated
	 * @ordered
	 */
	protected static final List<String> ENTRY_CRITERIA_REFS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryCriteriaRefs() <em>Entry Criteria Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryCriteriaRefs()
	 * @generated
	 * @ordered
	 */
	protected List<String> entryCriteriaRefs = ENTRY_CRITERIA_REFS_EDEFAULT;

	/**
	 * The default value of the '{@link #getExitCriteriaRefs() <em>Exit Criteria Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitCriteriaRefs()
	 * @generated
	 * @ordered
	 */
	protected static final List<String> EXIT_CRITERIA_REFS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExitCriteriaRefs() <em>Exit Criteria Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitCriteriaRefs()
	 * @generated
	 * @ordered
	 */
	protected List<String> exitCriteriaRefs = EXIT_CRITERIA_REFS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TPlanItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TPLAN_ITEM;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL, oldItemControl, newItemControl);
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
				msgs = ((InternalEObject)itemControl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL, null, msgs);
			if (newItemControl != null)
				msgs = ((InternalEObject)newItemControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL, null, msgs);
			msgs = basicSetItemControl(newItemControl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL, newItemControl, newItemControl));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM__DEFINITION_REF, oldDefinitionRef, definitionRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getEntryCriteriaRefs() {
		return entryCriteriaRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryCriteriaRefs(List<String> newEntryCriteriaRefs) {
		List<String> oldEntryCriteriaRefs = entryCriteriaRefs;
		entryCriteriaRefs = newEntryCriteriaRefs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM__ENTRY_CRITERIA_REFS, oldEntryCriteriaRefs, entryCriteriaRefs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getExitCriteriaRefs() {
		return exitCriteriaRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExitCriteriaRefs(List<String> newExitCriteriaRefs) {
		List<String> oldExitCriteriaRefs = exitCriteriaRefs;
		exitCriteriaRefs = newExitCriteriaRefs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM__EXIT_CRITERIA_REFS, oldExitCriteriaRefs, exitCriteriaRefs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL:
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
			case Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL:
				return getItemControl();
			case Cmmn1Package.TPLAN_ITEM__DEFINITION_REF:
				return getDefinitionRef();
			case Cmmn1Package.TPLAN_ITEM__ENTRY_CRITERIA_REFS:
				return getEntryCriteriaRefs();
			case Cmmn1Package.TPLAN_ITEM__EXIT_CRITERIA_REFS:
				return getExitCriteriaRefs();
			case Cmmn1Package.TPLAN_ITEM__NAME:
				return getName();
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
			case Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL:
				setItemControl((TPlanItemControl)newValue);
				return;
			case Cmmn1Package.TPLAN_ITEM__DEFINITION_REF:
				setDefinitionRef((String)newValue);
				return;
			case Cmmn1Package.TPLAN_ITEM__ENTRY_CRITERIA_REFS:
				setEntryCriteriaRefs((List<String>)newValue);
				return;
			case Cmmn1Package.TPLAN_ITEM__EXIT_CRITERIA_REFS:
				setExitCriteriaRefs((List<String>)newValue);
				return;
			case Cmmn1Package.TPLAN_ITEM__NAME:
				setName((String)newValue);
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
			case Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL:
				setItemControl((TPlanItemControl)null);
				return;
			case Cmmn1Package.TPLAN_ITEM__DEFINITION_REF:
				setDefinitionRef(DEFINITION_REF_EDEFAULT);
				return;
			case Cmmn1Package.TPLAN_ITEM__ENTRY_CRITERIA_REFS:
				setEntryCriteriaRefs(ENTRY_CRITERIA_REFS_EDEFAULT);
				return;
			case Cmmn1Package.TPLAN_ITEM__EXIT_CRITERIA_REFS:
				setExitCriteriaRefs(EXIT_CRITERIA_REFS_EDEFAULT);
				return;
			case Cmmn1Package.TPLAN_ITEM__NAME:
				setName(NAME_EDEFAULT);
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
			case Cmmn1Package.TPLAN_ITEM__ITEM_CONTROL:
				return itemControl != null;
			case Cmmn1Package.TPLAN_ITEM__DEFINITION_REF:
				return DEFINITION_REF_EDEFAULT == null ? definitionRef != null : !DEFINITION_REF_EDEFAULT.equals(definitionRef);
			case Cmmn1Package.TPLAN_ITEM__ENTRY_CRITERIA_REFS:
				return ENTRY_CRITERIA_REFS_EDEFAULT == null ? entryCriteriaRefs != null : !ENTRY_CRITERIA_REFS_EDEFAULT.equals(entryCriteriaRefs);
			case Cmmn1Package.TPLAN_ITEM__EXIT_CRITERIA_REFS:
				return EXIT_CRITERIA_REFS_EDEFAULT == null ? exitCriteriaRefs != null : !EXIT_CRITERIA_REFS_EDEFAULT.equals(exitCriteriaRefs);
			case Cmmn1Package.TPLAN_ITEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(", entryCriteriaRefs: ");
		result.append(entryCriteriaRefs);
		result.append(", exitCriteriaRefs: ");
		result.append(exitCriteriaRefs);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TPlanItemImpl
