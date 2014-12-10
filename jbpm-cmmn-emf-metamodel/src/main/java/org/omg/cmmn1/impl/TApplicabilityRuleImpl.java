/**
 */
package org.omg.cmmn1.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.TApplicabilityRule;
import org.omg.cmmn1.TExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TApplicability Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TApplicabilityRuleImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TApplicabilityRuleImpl#getContextRef <em>Context Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TApplicabilityRuleImpl extends TCmmnElementImpl implements TApplicabilityRule {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected TExpression condition;

	/**
	 * The default value of the '{@link #getContextRef() <em>Context Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextRef()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContextRef() <em>Context Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextRef()
	 * @generated
	 * @ordered
	 */
	protected String contextRef = CONTEXT_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TApplicabilityRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TAPPLICABILITY_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TExpression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(TExpression newCondition, NotificationChain msgs) {
		TExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TAPPLICABILITY_RULE__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(TExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TAPPLICABILITY_RULE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TAPPLICABILITY_RULE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TAPPLICABILITY_RULE__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContextRef() {
		return contextRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextRef(String newContextRef) {
		String oldContextRef = contextRef;
		contextRef = newContextRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TAPPLICABILITY_RULE__CONTEXT_REF, oldContextRef, contextRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cmmn1Package.TAPPLICABILITY_RULE__CONDITION:
				return basicSetCondition(null, msgs);
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
			case Cmmn1Package.TAPPLICABILITY_RULE__CONDITION:
				return getCondition();
			case Cmmn1Package.TAPPLICABILITY_RULE__CONTEXT_REF:
				return getContextRef();
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
			case Cmmn1Package.TAPPLICABILITY_RULE__CONDITION:
				setCondition((TExpression)newValue);
				return;
			case Cmmn1Package.TAPPLICABILITY_RULE__CONTEXT_REF:
				setContextRef((String)newValue);
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
			case Cmmn1Package.TAPPLICABILITY_RULE__CONDITION:
				setCondition((TExpression)null);
				return;
			case Cmmn1Package.TAPPLICABILITY_RULE__CONTEXT_REF:
				setContextRef(CONTEXT_REF_EDEFAULT);
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
			case Cmmn1Package.TAPPLICABILITY_RULE__CONDITION:
				return condition != null;
			case Cmmn1Package.TAPPLICABILITY_RULE__CONTEXT_REF:
				return CONTEXT_REF_EDEFAULT == null ? contextRef != null : !CONTEXT_REF_EDEFAULT.equals(contextRef);
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
		result.append(" (contextRef: ");
		result.append(contextRef);
		result.append(')');
		return result.toString();
	}

} //TApplicabilityRuleImpl
