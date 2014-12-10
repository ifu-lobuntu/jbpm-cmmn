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
import org.omg.cmmn1.TParameterMapping;
import org.omg.cmmn1.TProcessTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TProcess Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TProcessTaskImpl#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TProcessTaskImpl#getProcessRef <em>Process Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TProcessTaskImpl extends TTaskImpl implements TProcessTask {
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
	 * The default value of the '{@link #getProcessRef() <em>Process Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessRef()
	 * @generated
	 * @ordered
	 */
	protected static final QName PROCESS_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessRef() <em>Process Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessRef()
	 * @generated
	 * @ordered
	 */
	protected QName processRef = PROCESS_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TProcessTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TPROCESS_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TParameterMapping> getParameterMapping() {
		if (parameterMapping == null) {
			parameterMapping = new EObjectContainmentEList<TParameterMapping>(TParameterMapping.class, this, Cmmn1Package.TPROCESS_TASK__PARAMETER_MAPPING);
		}
		return parameterMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getProcessRef() {
		return processRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessRef(QName newProcessRef) {
		QName oldProcessRef = processRef;
		processRef = newProcessRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TPROCESS_TASK__PROCESS_REF, oldProcessRef, processRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cmmn1Package.TPROCESS_TASK__PARAMETER_MAPPING:
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
			case Cmmn1Package.TPROCESS_TASK__PARAMETER_MAPPING:
				return getParameterMapping();
			case Cmmn1Package.TPROCESS_TASK__PROCESS_REF:
				return getProcessRef();
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
			case Cmmn1Package.TPROCESS_TASK__PARAMETER_MAPPING:
				getParameterMapping().clear();
				getParameterMapping().addAll((Collection<? extends TParameterMapping>)newValue);
				return;
			case Cmmn1Package.TPROCESS_TASK__PROCESS_REF:
				setProcessRef((QName)newValue);
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
			case Cmmn1Package.TPROCESS_TASK__PARAMETER_MAPPING:
				getParameterMapping().clear();
				return;
			case Cmmn1Package.TPROCESS_TASK__PROCESS_REF:
				setProcessRef(PROCESS_REF_EDEFAULT);
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
			case Cmmn1Package.TPROCESS_TASK__PARAMETER_MAPPING:
				return parameterMapping != null && !parameterMapping.isEmpty();
			case Cmmn1Package.TPROCESS_TASK__PROCESS_REF:
				return PROCESS_REF_EDEFAULT == null ? processRef != null : !PROCESS_REF_EDEFAULT.equals(processRef);
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
		result.append(" (processRef: ");
		result.append(processRef);
		result.append(')');
		return result.toString();
	}

} //TProcessTaskImpl
