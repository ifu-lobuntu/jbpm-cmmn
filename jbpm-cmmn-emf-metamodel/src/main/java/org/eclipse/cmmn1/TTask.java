/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTask</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TTask#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TTask#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TTask#isIsBlocking <em>Is Blocking</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTTask()
 * @model extendedMetaData="name='tTask' kind='elementOnly'"
 * @generated
 */
public interface TTask extends TPlanItemDefinition {
    /**
     * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TCaseParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inputs</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTTask_Inputs()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='inputs' namespace='##targetNamespace'"
     * @generated
     */
    EList<TCaseParameter> getInputs();

    /**
     * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TCaseParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outputs</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTTask_Outputs()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='outputs' namespace='##targetNamespace'"
     * @generated
     */
    EList<TCaseParameter> getOutputs();

    /**
     * Returns the value of the '<em><b>Is Blocking</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Blocking</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Blocking</em>' attribute.
     * @see #isSetIsBlocking()
     * @see #unsetIsBlocking()
     * @see #setIsBlocking(boolean)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTTask_IsBlocking()
     * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='isBlocking'"
     * @generated
     */
    boolean isIsBlocking();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TTask#isIsBlocking <em>Is Blocking</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Blocking</em>' attribute.
     * @see #isSetIsBlocking()
     * @see #unsetIsBlocking()
     * @see #isIsBlocking()
     * @generated
     */
    void setIsBlocking(boolean value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmn1.TTask#isIsBlocking <em>Is Blocking</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetIsBlocking()
     * @see #isIsBlocking()
     * @see #setIsBlocking(boolean)
     * @generated
     */
    void unsetIsBlocking();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmn1.TTask#isIsBlocking <em>Is Blocking</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Is Blocking</em>' attribute is set.
     * @see #unsetIsBlocking()
     * @see #isIsBlocking()
     * @see #setIsBlocking(boolean)
     * @generated
     */
    boolean isSetIsBlocking();

} // TTask
