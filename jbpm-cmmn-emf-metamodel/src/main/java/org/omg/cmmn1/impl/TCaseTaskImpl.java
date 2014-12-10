/**
 */
package org.omg.cmmn1.impl;

import java.util.Collection;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.TCaseTask;
import org.omg.cmmn1.TParameterMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCase Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TCaseTaskImpl#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TCaseTaskImpl#getCaseRef <em>Case Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCaseTaskImpl extends TTaskImpl implements TCaseTask {
	/**
	 * The cached value of the '{@link #getParameterMapping() <em>Parameter Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<TParameterMapping> parameterMapping;

	/**
	 * The default value of the '{@link #getCaseRef() <em>Case Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseRef()
	 * @generated
	 * @ordered
	 */
	protected static final QName CASE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCaseRef() <em>Case Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseRef()
	 * @generated
	 * @ordered
	 */
	protected QName caseRef = CASE_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCaseTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TCASE_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TParameterMapping> getParameterMapping() {
		if (parameterMapping == null) {
			parameterMapping = new EObjectContainmentEList<TParameterMapping>(TParameterMapping.class, this, Cmmn1Package.TCASE_TASK__PARAMETER_MAPPING);
		}
		return parameterMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getCaseRef() {
		return caseRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaseRef(QName newCaseRef) {
		QName oldCaseRef = caseRef;
		caseRef = newCaseRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_TASK__CASE_REF, oldCaseRef, caseRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cmmn1Package.TCASE_TASK__PARAMETER_MAPPING:
				return ((InternalEList<?>)getParameterMapping()).basicRemove(otherEnd, msgs);
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
			case Cmmn1Package.TCASE_TASK__PARAMETER_MAPPING:
				return getParameterMapping();
			case Cmmn1Package.TCASE_TASK__CASE_REF:
				return getCaseRef();
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
			case Cmmn1Package.TCASE_TASK__PARAMETER_MAPPING:
				getParameterMapping().clear();
				getParameterMapping().addAll((Collection<? extends TParameterMapping>)newValue);
				return;
			case Cmmn1Package.TCASE_TASK__CASE_REF:
				setCaseRef((QName)newValue);
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
			case Cmmn1Package.TCASE_TASK__PARAMETER_MAPPING:
				getParameterMapping().clear();
				return;
			case Cmmn1Package.TCASE_TASK__CASE_REF:
				setCaseRef(CASE_REF_EDEFAULT);
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
			case Cmmn1Package.TCASE_TASK__PARAMETER_MAPPING:
				return parameterMapping != null && !parameterMapping.isEmpty();
			case Cmmn1Package.TCASE_TASK__CASE_REF:
				return CASE_REF_EDEFAULT == null ? caseRef != null : !CASE_REF_EDEFAULT.equals(caseRef);
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
		result.append(" (caseRef: ");
		result.append(caseRef);
		result.append(')');
		return result.toString();
	}

} //TCaseTaskImpl
