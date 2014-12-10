/**
 */
package org.omg.cmmn1.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.TTableItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTable Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TTableItemImpl#getApplicabilityRuleRefs <em>Applicability Rule Refs</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TTableItemImpl#getAuthorizedRoleRefs <em>Authorized Role Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TTableItemImpl extends TCmmnElementImpl implements TTableItem {
	/**
	 * The default value of the '{@link #getApplicabilityRuleRefs() <em>Applicability Rule Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicabilityRuleRefs()
	 * @generated
	 * @ordered
	 */
	protected static final List<String> APPLICABILITY_RULE_REFS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplicabilityRuleRefs() <em>Applicability Rule Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicabilityRuleRefs()
	 * @generated
	 * @ordered
	 */
	protected List<String> applicabilityRuleRefs = APPLICABILITY_RULE_REFS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthorizedRoleRefs() <em>Authorized Role Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorizedRoleRefs()
	 * @generated
	 * @ordered
	 */
	protected static final List<String> AUTHORIZED_ROLE_REFS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthorizedRoleRefs() <em>Authorized Role Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorizedRoleRefs()
	 * @generated
	 * @ordered
	 */
	protected List<String> authorizedRoleRefs = AUTHORIZED_ROLE_REFS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TTableItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cmmn1Package.Literals.TTABLE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getApplicabilityRuleRefs() {
		return applicabilityRuleRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicabilityRuleRefs(List<String> newApplicabilityRuleRefs) {
		List<String> oldApplicabilityRuleRefs = applicabilityRuleRefs;
		applicabilityRuleRefs = newApplicabilityRuleRefs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TTABLE_ITEM__APPLICABILITY_RULE_REFS, oldApplicabilityRuleRefs, applicabilityRuleRefs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getAuthorizedRoleRefs() {
		return authorizedRoleRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthorizedRoleRefs(List<String> newAuthorizedRoleRefs) {
		List<String> oldAuthorizedRoleRefs = authorizedRoleRefs;
		authorizedRoleRefs = newAuthorizedRoleRefs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS, oldAuthorizedRoleRefs, authorizedRoleRefs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Cmmn1Package.TTABLE_ITEM__APPLICABILITY_RULE_REFS:
				return getApplicabilityRuleRefs();
			case Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS:
				return getAuthorizedRoleRefs();
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
			case Cmmn1Package.TTABLE_ITEM__APPLICABILITY_RULE_REFS:
				setApplicabilityRuleRefs((List<String>)newValue);
				return;
			case Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS:
				setAuthorizedRoleRefs((List<String>)newValue);
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
			case Cmmn1Package.TTABLE_ITEM__APPLICABILITY_RULE_REFS:
				setApplicabilityRuleRefs(APPLICABILITY_RULE_REFS_EDEFAULT);
				return;
			case Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS:
				setAuthorizedRoleRefs(AUTHORIZED_ROLE_REFS_EDEFAULT);
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
			case Cmmn1Package.TTABLE_ITEM__APPLICABILITY_RULE_REFS:
				return APPLICABILITY_RULE_REFS_EDEFAULT == null ? applicabilityRuleRefs != null : !APPLICABILITY_RULE_REFS_EDEFAULT.equals(applicabilityRuleRefs);
			case Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS:
				return AUTHORIZED_ROLE_REFS_EDEFAULT == null ? authorizedRoleRefs != null : !AUTHORIZED_ROLE_REFS_EDEFAULT.equals(authorizedRoleRefs);
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
		result.append(" (applicabilityRuleRefs: ");
		result.append(applicabilityRuleRefs);
		result.append(", authorizedRoleRefs: ");
		result.append(authorizedRoleRefs);
		result.append(')');
		return result.toString();
	}

} //TTableItemImpl
