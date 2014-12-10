/**
 */
package org.omg.cmmn1.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.PlanItemTransition;
import org.omg.cmmn1.TPlanItemOnPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TPlan Item On Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TPlanItemOnPartImpl#getStandardEvent <em>Standard Event</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TPlanItemOnPartImpl#getSentryRef <em>Sentry Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TPlanItemOnPartImpl#getSourceRef <em>Source Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TPlanItemOnPartImpl extends TOnPartImpl implements TPlanItemOnPart {
	/**
	 * The default value of the '{@link #getStandardEvent() <em>Standard Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardEvent()
	 * @generated
	 * @ordered
	 */
	protected static final PlanItemTransition STANDARD_EVENT_EDEFAULT = PlanItemTransition.CLOSE;

	/**
	 * The cached value of the '{@link #getStandardEvent() <em>Standard Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardEvent()
	 * @generated
	 * @ordered
	 */
	protected PlanItemTransition standardEvent = STANDARD_EVENT_EDEFAULT;

	/**
	 * This is true if the Standard Event attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean standardEventESet;

	/**
	 * The default value of the '{@link #getSentryRef() <em>Sentry Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentryRef()
	 * @generated
	 * @ordered
	 */
	protected static final String SENTRY_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSentryRef() <em>Sentry Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentryRef()
	 * @generated
	 * @ordered
	 */
	protected String sentryRef = SENTRY_REF_EDEFAULT;

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
	protected TPlanItemOnPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TPLAN_ITEM_ON_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlanItemTransition getStandardEvent() {
		return standardEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardEvent(PlanItemTransition newStandardEvent) {
		PlanItemTransition oldStandardEvent = standardEvent;
		standardEvent = newStandardEvent == null ? STANDARD_EVENT_EDEFAULT : newStandardEvent;
		boolean oldStandardEventESet = standardEventESet;
		standardEventESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM_ON_PART__STANDARD_EVENT, oldStandardEvent, standardEvent, !oldStandardEventESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStandardEvent() {
		PlanItemTransition oldStandardEvent = standardEvent;
		boolean oldStandardEventESet = standardEventESet;
		standardEvent = STANDARD_EVENT_EDEFAULT;
		standardEventESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Cmmn1Package.TPLAN_ITEM_ON_PART__STANDARD_EVENT, oldStandardEvent, STANDARD_EVENT_EDEFAULT, oldStandardEventESet));
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
	public String getSentryRef() {
		return sentryRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentryRef(String newSentryRef) {
		String oldSentryRef = sentryRef;
		sentryRef = newSentryRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM_ON_PART__SENTRY_REF, oldSentryRef, sentryRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPLAN_ITEM_ON_PART__SOURCE_REF, oldSourceRef, sourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Cmmn1Package.TPLAN_ITEM_ON_PART__STANDARD_EVENT:
				return getStandardEvent();
			case Cmmn1Package.TPLAN_ITEM_ON_PART__SENTRY_REF:
				return getSentryRef();
			case Cmmn1Package.TPLAN_ITEM_ON_PART__SOURCE_REF:
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
			case Cmmn1Package.TPLAN_ITEM_ON_PART__STANDARD_EVENT:
				setStandardEvent((PlanItemTransition)newValue);
				return;
			case Cmmn1Package.TPLAN_ITEM_ON_PART__SENTRY_REF:
				setSentryRef((String)newValue);
				return;
			case Cmmn1Package.TPLAN_ITEM_ON_PART__SOURCE_REF:
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
			case Cmmn1Package.TPLAN_ITEM_ON_PART__STANDARD_EVENT:
				unsetStandardEvent();
				return;
			case Cmmn1Package.TPLAN_ITEM_ON_PART__SENTRY_REF:
				setSentryRef(SENTRY_REF_EDEFAULT);
				return;
			case Cmmn1Package.TPLAN_ITEM_ON_PART__SOURCE_REF:
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
			case Cmmn1Package.TPLAN_ITEM_ON_PART__STANDARD_EVENT:
				return isSetStandardEvent();
			case Cmmn1Package.TPLAN_ITEM_ON_PART__SENTRY_REF:
				return SENTRY_REF_EDEFAULT == null ? sentryRef != null : !SENTRY_REF_EDEFAULT.equals(sentryRef);
			case Cmmn1Package.TPLAN_ITEM_ON_PART__SOURCE_REF:
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
		result.append(", sentryRef: ");
		result.append(sentryRef);
		result.append(", sourceRef: ");
		result.append(sourceRef);
		result.append(')');
		return result.toString();
	}

} //TPlanItemOnPartImpl
