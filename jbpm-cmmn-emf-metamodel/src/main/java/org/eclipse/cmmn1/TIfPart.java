/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TIf Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TIfPart#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TIfPart#getContextRef <em>Context Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTIfPart()
 * @model extendedMetaData="name='tIfPart' kind='elementOnly'"
 * @generated
 */
public interface TIfPart extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Condition</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TExpression}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTIfPart_Condition()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace'"
     * @generated
     */
    EList<TExpression> getCondition();

    /**
     * Returns the value of the '<em><b>Context Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               contextRef refers a "caseFileItem" element
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Context Ref</em>' reference.
     * @see #setContextRef(TCaseFileItem)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTIfPart_ContextRef()
     * @model extendedMetaData="kind='attribute' name='contextRef'"
     * @generated
     */
    TCaseFileItem getContextRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TIfPart#getContextRef <em>Context Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Ref</em>' reference.
     * @see #getContextRef()
     * @generated
     */
    void setContextRef(TCaseFileItem value);

} // TIfPart
