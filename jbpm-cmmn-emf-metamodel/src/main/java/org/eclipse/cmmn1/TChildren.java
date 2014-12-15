/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TChildren</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tChildren defines a container for zero or more "caseFileItem" elements.
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TChildren#getCaseFileItem <em>Case File Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTChildren()
 * @model extendedMetaData="name='tChildren' kind='elementOnly'"
 * @generated
 */
public interface TChildren extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Case File Item</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TCaseFileItem}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         caseFileItem is the root element for CMMN data.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case File Item</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTChildren_CaseFileItem()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='caseFileItem' namespace='##targetNamespace'"
     * @generated
     */
    EList<TCaseFileItem> getCaseFileItem();

} // TChildren
