/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTable Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TTableItem#getApplicabilityRuleRefs <em>Applicability Rule Refs</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TTableItem#getAuthorizedRoleRefs <em>Authorized Role Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTTableItem()
 * @model abstract="true"
 *        extendedMetaData="name='tTableItem' kind='empty'"
 * @generated
 */
public interface TTableItem extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Applicability Rule Refs</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TApplicabilityRule}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               applicabilityRuleRefs refers one or more "applicabilityRule" elements.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Applicability Rule Refs</em>' reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTTableItem_ApplicabilityRuleRefs()
     * @model extendedMetaData="kind='attribute' name='applicabilityRuleRefs'"
     * @generated
     */
    EList<TApplicabilityRule> getApplicabilityRuleRefs();

    /**
     * Returns the value of the '<em><b>Authorized Role Refs</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TRole}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               authorizedRoleRefs refers zero or more "role" elements.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Authorized Role Refs</em>' reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTTableItem_AuthorizedRoleRefs()
     * @model extendedMetaData="kind='attribute' name='authorizedRoleRefs'"
     * @generated
     */
    EList<TRole> getAuthorizedRoleRefs();

} // TTableItem
