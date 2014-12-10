/**
 */
package org.omg.cmmn1.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.cmmn1.CaseFileItemTransition;
import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.TCaseFileItemStartTrigger;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCase File Item Start Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TCaseFileItemStartTriggerImpl#getStandardEvent <em>Standard Event</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TCaseFileItemStartTriggerImpl#getSourceRef <em>Source Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCaseFileItemStartTriggerImpl extends TStartTriggerImpl implements TCaseFileItemStartTrigger {
	/**
	 * The default value of the '{@link #getStandardEvent() <em>Standard Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardEvent()
	 * @generated
	 * @ordered
	 */
	protected static final CaseFileItemTransition STANDARD_EVENT_EDEFAULT = CaseFileItemTransition.ADD_CHILD;

	/**
	 * The cached value of the '{@link #getStandardEvent() <em>Standard Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardEvent()
	 * @generated
	 * @ordered
	 */
	protected CaseFileItemTransition standardEvent = STANDARD_EVENT_EDEFAULT;

	/**
	 * This is true if the Standard Event attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean standardEventESet;

	/**
	 * The default value of the '{@link #getSourceRef() <em>Source Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRef()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceRef() <em>Source Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRef()
	 * @generated
	 * @ordered
	 */
	protected String sourceRef = SOURCE_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCaseFileItemStartTriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TCASE_FILE_ITEM_START_TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseFileItemTransition getStandardEvent() {
		return standardEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardEvent(CaseFileItemTransition newStandardEvent) {
		CaseFileItemTransition oldStandardEvent = standardEvent;
		standardEvent = newStandardEvent == null ? STANDARD_EVENT_EDEFAULT : newStandardEvent;
		boolean oldStandardEventESet = standardEventESet;
		standardEventESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__STANDARD_EVENT, oldStandardEvent, standardEvent, !oldStandardEventESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStandardEvent() {
		CaseFileItemTransition oldStandardEvent = standardEvent;
		boolean oldStandardEventESet = standardEventESet;
		standardEvent = STANDARD_EVENT_EDEFAULT;
		standardEventESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__STANDARD_EVENT, oldStandardEvent, STANDARD_EVENT_EDEFAULT, oldStandardEventESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStandardEvent() {
		return standardEventESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceRef() {
		return sourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRef(String newSourceRef) {
		String oldSourceRef = sourceRef;
		sourceRef = newSourceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__SOURCE_REF, oldSourceRef, sourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__STANDARD_EVENT:
				return getStandardEvent();
			case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__SOURCE_REF:
				return getSourceRef();
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
			case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__STANDARD_EVENT:
				setStandardEvent((CaseFileItemTransition)newValue);
				return;
			case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__SOURCE_REF:
				setSourceRef((String)newValue);
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
			case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__STANDARD_EVENT:
				unsetStandardEvent();
				return;
			case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__SOURCE_REF:
				setSourceRef(SOURCE_REF_EDEFAULT);
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
			case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__STANDARD_EVENT:
				return isSetStandardEvent();
			case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER__SOURCE_REF:
				return SOURCE_REF_EDEFAULT == null ? sourceRef != null : !SOURCE_REF_EDEFAULT.equals(sourceRef);
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
		result.append(" (standardEvent: ");
		if (standardEventESet) result.append(standardEvent); else result.append("<unset>");
		result.append(", sourceRef: ");
		result.append(sourceRef);
		result.append(')');
		return result.toString();
	}

} //TCaseFileItemStartTriggerImpl
