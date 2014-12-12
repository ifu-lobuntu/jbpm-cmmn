/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;
import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TApplicabilityRule;
import org.eclipse.cmmn1.TRole;
import org.eclipse.cmmn1.TTableItem;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTable Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TTableItemImpl#getApplicabilityRuleRefs <em>Applicability Rule Refs</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TTableItemImpl#getAuthorizedRoleRefs <em>Authorized Role Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TTableItemImpl extends TCmmnElementImpl implements TTableItem {
    /**
     * The cached value of the '{@link #getApplicabilityRuleRefs() <em>Applicability Rule Refs</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getApplicabilityRuleRefs()
     * @generated
     * @ordered
     */
    protected EList<TApplicabilityRule> applicabilityRuleRefs;

    /**
     * The cached value of the '{@link #getAuthorizedRoleRefs() <em>Authorized Role Refs</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthorizedRoleRefs()
     * @generated
     * @ordered
     */
    protected TRole authorizedRoleRefs;

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
    public EList<TApplicabilityRule> getApplicabilityRuleRefs() {
        if (applicabilityRuleRefs == null) {
            applicabilityRuleRefs = new EObjectResolvingEList<TApplicabilityRule>(TApplicabilityRule.class, this, Cmmn1Package.TTABLE_ITEM__APPLICABILITY_RULE_REFS);
        }
        return applicabilityRuleRefs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRole getAuthorizedRoleRefs() {
        if (authorizedRoleRefs != null && authorizedRoleRefs.eIsProxy()) {
            InternalEObject oldAuthorizedRoleRefs = (InternalEObject)authorizedRoleRefs;
            authorizedRoleRefs = (TRole)eResolveProxy(oldAuthorizedRoleRefs);
            if (authorizedRoleRefs != oldAuthorizedRoleRefs) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS, oldAuthorizedRoleRefs, authorizedRoleRefs));
            }
        }
        return authorizedRoleRefs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRole basicGetAuthorizedRoleRefs() {
        return authorizedRoleRefs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAuthorizedRoleRefs(TRole newAuthorizedRoleRefs) {
        TRole oldAuthorizedRoleRefs = authorizedRoleRefs;
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
                if (resolve) return getAuthorizedRoleRefs();
                return basicGetAuthorizedRoleRefs();
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
                getApplicabilityRuleRefs().clear();
                getApplicabilityRuleRefs().addAll((Collection<? extends TApplicabilityRule>)newValue);
                return;
            case Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS:
                setAuthorizedRoleRefs((TRole)newValue);
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
                getApplicabilityRuleRefs().clear();
                return;
            case Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS:
                setAuthorizedRoleRefs((TRole)null);
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
                return applicabilityRuleRefs != null && !applicabilityRuleRefs.isEmpty();
            case Cmmn1Package.TTABLE_ITEM__AUTHORIZED_ROLE_REFS:
                return authorizedRoleRefs != null;
        }
        return super.eIsSet(featureID);
    }

} //TTableItemImpl
