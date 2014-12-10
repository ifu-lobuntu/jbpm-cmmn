/**
 */
package org.omg.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCase Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.cmmn1.TCaseParameter#getBindingRefinement <em>Binding Refinement</em>}</li>
 *   <li>{@link org.omg.cmmn1.TCaseParameter#getBindingRef <em>Binding Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTCaseParameter()
 * @model extendedMetaData="name='tCaseParameter' kind='elementOnly'"
 * @generated
 */
public interface TCaseParameter extends TParameter {
	/**
	 * Returns the value of the '<em><b>Binding Refinement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Refinement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Refinement</em>' containment reference.
	 * @see #setBindingRefinement(TExpression)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseParameter_BindingRefinement()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='bindingRefinement' namespace='##targetNamespace'"
	 * @generated
	 */
	TExpression getBindingRefinement();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseParameter#getBindingRefinement <em>Binding Refinement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Refinement</em>' containment reference.
	 * @see #getBindingRefinement()
	 * @generated
	 */
	void setBindingRefinement(TExpression value);

	/**
	 * Returns the value of the '<em><b>Binding Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               bindingRef refers a "caseFileItem" element
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding Ref</em>' attribute.
	 * @see #setBindingRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseParameter_BindingRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='bindingRef'"
	 * @generated
	 */
	String getBindingRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseParameter#getBindingRef <em>Binding Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Ref</em>' attribute.
	 * @see #getBindingRef()
	 * @generated
	 */
	void setBindingRef(String value);

} // TCaseParameter
