/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TProcess</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tProcess defines the type of element "process"
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TProcess#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TProcess#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TProcess#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TProcess#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTProcess()
 * @model extendedMetaData="name='tProcess' kind='elementOnly'"
 * @generated
 */
public interface TProcess extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Input</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TProcessParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTProcess_Input()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='input' namespace='##targetNamespace'"
     * @generated
     */
    EList<TProcessParameter> getInput();

    /**
     * Returns the value of the '<em><b>Output</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TProcessParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTProcess_Output()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='output' namespace='##targetNamespace'"
     * @generated
     */
    EList<TProcessParameter> getOutput();

    /**
     * Returns the value of the '<em><b>Implementation Type</b></em>' attribute.
     * The default value is <code>"http://www.omg.org/spec/CMMN/ProcessType/Unspecified"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Implementation Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Implementation Type</em>' attribute.
     * @see #isSetImplementationType()
     * @see #unsetImplementationType()
     * @see #setImplementationType(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTProcess_ImplementationType()
     * @model default="http://www.omg.org/spec/CMMN/ProcessType/Unspecified" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
     *        extendedMetaData="kind='attribute' name='implementationType'"
     * @generated
     */
    String getImplementationType();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TProcess#getImplementationType <em>Implementation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Implementation Type</em>' attribute.
     * @see #isSetImplementationType()
     * @see #unsetImplementationType()
     * @see #getImplementationType()
     * @generated
     */
    void setImplementationType(String value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmn1.TProcess#getImplementationType <em>Implementation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetImplementationType()
     * @see #getImplementationType()
     * @see #setImplementationType(String)
     * @generated
     */
    void unsetImplementationType();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmn1.TProcess#getImplementationType <em>Implementation Type</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Implementation Type</em>' attribute is set.
     * @see #unsetImplementationType()
     * @see #getImplementationType()
     * @see #setImplementationType(String)
     * @generated
     */
    boolean isSetImplementationType();

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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTProcess_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TProcess#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // TProcess
