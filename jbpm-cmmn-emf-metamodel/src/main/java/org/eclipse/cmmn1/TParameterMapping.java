/**
 */
package org.eclipse.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TParameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TParameterMapping#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TParameterMapping#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TParameterMapping#getTargetRef <em>Target Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTParameterMapping()
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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTParameterMapping_Transformation()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='transformation' namespace='##targetNamespace'"
     * @generated
     */
    TExpression getTransformation();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TParameterMapping#getTransformation <em>Transformation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transformation</em>' containment reference.
     * @see #getTransformation()
     * @generated
     */
    void setTransformation(TExpression value);

    /**
     * Returns the value of the '<em><b>Source Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               sourceRef refers a "parameter" element
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Source Ref</em>' reference.
     * @see #setSourceRef(TParameter)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTParameterMapping_SourceRef()
     * @model extendedMetaData="kind='attribute' name='sourceRef'"
     * @generated
     */
    TParameter getSourceRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TParameterMapping#getSourceRef <em>Source Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Ref</em>' reference.
     * @see #getSourceRef()
     * @generated
     */
    void setSourceRef(TParameter value);

    /**
     * Returns the value of the '<em><b>Target Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               targetRef refers a "parameter" element
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Target Ref</em>' reference.
     * @see #setTargetRef(TParameter)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTParameterMapping_TargetRef()
     * @model extendedMetaData="kind='attribute' name='targetRef'"
     * @generated
     */
    TParameter getTargetRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TParameterMapping#getTargetRef <em>Target Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Ref</em>' reference.
     * @see #getTargetRef()
     * @generated
     */
    void setTargetRef(TParameter value);

} // TParameterMapping
