/**
 */
package org.omg.cmmn1;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTable Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.cmmn1.TTableItem#getApplicabilityRuleRefs <em>Applicability Rule Refs</em>}</li>
 *   <li>{@link org.omg.cmmn1.TTableItem#getAuthorizedRoleRefs <em>Authorized Role Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTTableItem()
 * @model abstract="true"
 *        extendedMetaData="name='tTableItem' kind='empty'"
 * @generated
 */
public interface TTableItem extends TCmmnElement {
	/**
	 * Returns the value of the '<em><b>Applicability Rule Refs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               applicabilityRuleRefs refers one or more "applicabilityRule" elements.
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applicability Rule Refs</em>' attribute.
	 * @see #setApplicabilityRuleRefs(List)
	 * @see org.omg.cmmn1.Cmmn1Package#getTTableItem_ApplicabilityRuleRefs()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREFS" many="false"
	 *        extendedMetaData="kind='attribute' name='applicabilityRuleRefs'"
	 * @generated
	 */
	List<String> getApplicabilityRuleRefs();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TTableItem#getApplicabilityRuleRefs <em>Applicability Rule Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applicability Rule Refs</em>' attribute.
	 * @see #getApplicabilityRuleRefs()
	 * @generated
	 */
	void setApplicabilityRuleRefs(List<String> value);

	/**
	 * Returns the value of the '<em><b>Authorized Role Refs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               authorizedRoleRefs refers zero or more "role" elements.
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Authorized Role Refs</em>' attribute.
	 * @see #setAuthorizedRoleRefs(List)
	 * @see org.omg.cmmn1.Cmmn1Package#getTTableItem_AuthorizedRoleRefs()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREFS" many="false"
	 *        extendedMetaData="kind='attribute' name='authorizedRoleRefs'"
	 * @generated
	 */
	List<String> getAuthorizedRoleRefs();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TTableItem#getAuthorizedRoleRefs <em>Authorized Role Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authorized Role Refs</em>' attribute.
	 * @see #getAuthorizedRoleRefs()
	 * @generated
	 */
	void setAuthorizedRoleRefs(List<String> value);

} // TTableItem
