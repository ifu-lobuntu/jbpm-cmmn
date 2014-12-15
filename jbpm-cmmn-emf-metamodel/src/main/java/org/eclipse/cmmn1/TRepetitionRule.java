/**
 */
package org.eclipse.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRepetition Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tRepetitionRule defines the type of element "repetitionRule".
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TRepetitionRule#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TRepetitionRule#getContextRef <em>Context Ref</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TRepetitionRule#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTRepetitionRule()
 * @model extendedMetaData="name='tRepetitionRule' kind='elementOnly'"
 * @generated
 */
public interface TRepetitionRule extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' containment reference.
     * @see #setCondition(TExpression)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTRepetitionRule_Condition()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace'"
     * @generated
     */
    TExpression getCondition();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TRepetitionRule#getCondition <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' containment reference.
     * @see #getCondition()
     * @generated
     */
    void setCondition(TExpression value);

    /**
     * Returns the value of the '<em><b>Context Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               contextRef MUST refer a CaseFileItem if specified.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Context Ref</em>' reference.
     * @see #setContextRef(TCaseFileItem)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTRepetitionRule_ContextRef()
     * @model extendedMetaData="kind='attribute' name='contextRef'"
     * @generated
     */
    TCaseFileItem getContextRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TRepetitionRule#getContextRef <em>Context Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Ref</em>' reference.
     * @see #getContextRef()
     * @generated
     */
    void setContextRef(TCaseFileItem value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTRepetitionRule_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TRepetitionRule#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // TRepetitionRule
