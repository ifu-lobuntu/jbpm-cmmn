/**
 */
package org.omg.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TManual Activation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tManualActivationRule defines the type of element "manualActivationRule".
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.cmmn1.TManualActivationRule#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.omg.cmmn1.TManualActivationRule#getContextRef <em>Context Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.TManualActivationRule#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTManualActivationRule()
 * @model extendedMetaData="name='tManualActivationRule' kind='elementOnly'"
 * @generated
 */
public interface TManualActivationRule extends TCmmnElement {
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
	 * @see org.omg.cmmn1.Cmmn1Package#getTManualActivationRule_Condition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace'"
	 * @generated
	 */
	TExpression getCondition();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TManualActivationRule#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(TExpression value);

	/**
	 * Returns the value of the '<em><b>Context Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               contextRef MUST refer a CaseFileItem if specified. 
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context Ref</em>' attribute.
	 * @see #setContextRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTManualActivationRule_ContextRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='contextRef'"
	 * @generated
	 */
	String getContextRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TManualActivationRule#getContextRef <em>Context Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Ref</em>' attribute.
	 * @see #getContextRef()
	 * @generated
	 */
	void setContextRef(String value);

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
	 * @see org.omg.cmmn1.Cmmn1Package#getTManualActivationRule_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TManualActivationRule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TManualActivationRule
