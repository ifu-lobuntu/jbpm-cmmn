/**
 */
package org.eclipse.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPlan Item Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TPlanItemDefinition#getDefaultControl <em>Default Control</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanItemDefinition#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemDefinition()
 * @model abstract="true"
 *        extendedMetaData="name='tPlanItemDefinition' kind='elementOnly'"
 * @generated
 */
public interface TPlanItemDefinition extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Default Control</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Control</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Control</em>' containment reference.
     * @see #setDefaultControl(TPlanItemControl)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemDefinition_DefaultControl()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='defaultControl' namespace='##targetNamespace'"
     * @generated
     */
    TPlanItemControl getDefaultControl();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItemDefinition#getDefaultControl <em>Default Control</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Control</em>' containment reference.
     * @see #getDefaultControl()
     * @generated
     */
    void setDefaultControl(TPlanItemControl value);

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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemDefinition_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItemDefinition#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // TPlanItemDefinition
