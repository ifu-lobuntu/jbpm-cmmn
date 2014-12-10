/**
 */
package org.omg.cmmn1.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.TExpression;
import org.omg.cmmn1.TParameterMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TParameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TParameterMappingImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TParameterMappingImpl#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TParameterMappingImpl#getTargetRef <em>Target Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TParameterMappingImpl extends TCmmnElementImpl implements TParameterMapping {
	/**
	 * The cached value of the '{@link #getTransformation() <em>Transformation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformation()
	 * @generated
	 * @ordered
	 */
	protected TExpression transformation;

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
	 * The default value of the '{@link #getTargetRef() <em>Target Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRef()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetRef() <em>Target Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRef()
	 * @generated
	 * @ordered
	 */
	protected String targetRef = TARGET_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TParameterMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TPARAMETER_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TExpression getTransformation() {
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(TExpression newTransformation, NotificationChain msgs) {
		TExpression oldTransformation = transformation;
		transformation = newTransformation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION, oldTransformation, newTransformation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(TExpression newTransformation) {
		if (newTransformation != transformation) {
			NotificationChain msgs = null;
			if (transformation != null)
				msgs = ((InternalEObject)transformation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION, null, msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION, null, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION, newTransformation, newTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPARAMETER_MAPPING__SOURCE_REF, oldSourceRef, sourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetRef() {
		return targetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRef(String newTargetRef) {
		String oldTargetRef = targetRef;
		targetRef = newTargetRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPARAMETER_MAPPING__TARGET_REF, oldTargetRef, targetRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION:
				return basicSetTransformation(null, msgs);
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
			case Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION:
				return getTransformation();
			case Cmmn1Package.TPARAMETER_MAPPING__SOURCE_REF:
				return getSourceRef();
			case Cmmn1Package.TPARAMETER_MAPPING__TARGET_REF:
				return getTargetRef();
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
			case Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION:
				setTransformation((TExpression)newValue);
				return;
			case Cmmn1Package.TPARAMETER_MAPPING__SOURCE_REF:
				setSourceRef((String)newValue);
				return;
			case Cmmn1Package.TPARAMETER_MAPPING__TARGET_REF:
				setTargetRef((String)newValue);
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
			case Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION:
				setTransformation((TExpression)null);
				return;
			case Cmmn1Package.TPARAMETER_MAPPING__SOURCE_REF:
				setSourceRef(SOURCE_REF_EDEFAULT);
				return;
			case Cmmn1Package.TPARAMETER_MAPPING__TARGET_REF:
				setTargetRef(TARGET_REF_EDEFAULT);
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
			case Cmmn1Package.TPARAMETER_MAPPING__TRANSFORMATION:
				return transformation != null;
			case Cmmn1Package.TPARAMETER_MAPPING__SOURCE_REF:
				return SOURCE_REF_EDEFAULT == null ? sourceRef != null : !SOURCE_REF_EDEFAULT.equals(sourceRef);
			case Cmmn1Package.TPARAMETER_MAPPING__TARGET_REF:
				return TARGET_REF_EDEFAULT == null ? targetRef != null : !TARGET_REF_EDEFAULT.equals(targetRef);
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
		result.append(" (sourceRef: ");
		result.append(sourceRef);
		result.append(", targetRef: ");
		result.append(targetRef);
		result.append(')');
		return result.toString();
	}

} //TParameterMappingImpl
