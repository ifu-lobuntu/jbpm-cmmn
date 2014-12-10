/**
 */
package org.omg.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TParameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.cmmn1.TParameterMapping#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.omg.cmmn1.TParameterMapping#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.TParameterMapping#getTargetRef <em>Target Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTParameterMapping()
 * @model extendedMetaData="name='tParameterMapping' kind='elementOnly'"
 * @generated
 */
public interface TParameterMapping extends TCmmnElement {
	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' containment reference.
	 * @see #setTransformation(TExpression)
	 * @see org.omg.cmmn1.Cmmn1Package#getTParameterMapping_Transformation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='transformation' namespace='##targetNamespace'"
	 * @generated
	 */
	TExpression getTransformation();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TParameterMapping#getTransformation <em>Transformation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' containment reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(TExpression value);

	/**
	 * Returns the value of the '<em><b>Source Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               sourceRef refers a "parameter" element
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Ref</em>' attribute.
	 * @see #setSourceRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTParameterMapping_SourceRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='sourceRef'"
	 * @generated
	 */
	String getSourceRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TParameterMapping#getSourceRef <em>Source Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Ref</em>' attribute.
	 * @see #getSourceRef()
	 * @generated
	 */
	void setSourceRef(String value);

	/**
	 * Returns the value of the '<em><b>Target Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               targetRef refers a "parameter" element
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Ref</em>' attribute.
	 * @see #setTargetRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTParameterMapping_TargetRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='targetRef'"
	 * @generated
	 */
	String getTargetRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TParameterMapping#getTargetRef <em>Target Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Ref</em>' attribute.
	 * @see #getTargetRef()
	 * @generated
	 */
	void setTargetRef(String value);

} // TParameterMapping
