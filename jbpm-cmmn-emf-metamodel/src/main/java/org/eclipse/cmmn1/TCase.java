/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCase</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tCase defines the type of element "case".
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TCase#getCaseFileModel <em>Case File Model</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCase#getCasePlanModel <em>Case Plan Model</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCase#getCaseRoles <em>Case Roles</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCase#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCase#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCase#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTCase()
 * @model extendedMetaData="name='tCase' kind='elementOnly'"
 * @generated
 */
public interface TCase extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Case File Model</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Case File Model</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Case File Model</em>' containment reference.
     * @see #setCaseFileModel(TCaseFile)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCase_CaseFileModel()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='caseFileModel' namespace='##targetNamespace'"
     * @generated
     */
    TCaseFile getCaseFileModel();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TCase#getCaseFileModel <em>Case File Model</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case File Model</em>' containment reference.
     * @see #getCaseFileModel()
     * @generated
     */
    void setCaseFileModel(TCaseFile value);

    /**
     * Returns the value of the '<em><b>Case Plan Model</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Case Plan Model</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Case Plan Model</em>' containment reference.
     * @see #setCasePlanModel(TStage)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCase_CasePlanModel()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='casePlanModel' namespace='##targetNamespace'"
     * @generated
     */
    TStage getCasePlanModel();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TCase#getCasePlanModel <em>Case Plan Model</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case Plan Model</em>' containment reference.
     * @see #getCasePlanModel()
     * @generated
     */
    void setCasePlanModel(TStage value);

    /**
     * Returns the value of the '<em><b>Case Roles</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TRole}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Case Roles</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Case Roles</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCase_CaseRoles()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='caseRoles' namespace='##targetNamespace'"
     * @generated
     */
    EList<TRole> getCaseRoles();

    /**
     * Returns the value of the '<em><b>Input</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TCaseParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCase_Input()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='input' namespace='##targetNamespace'"
     * @generated
     */
    EList<TCaseParameter> getInput();

    /**
     * Returns the value of the '<em><b>Output</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TCaseParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCase_Output()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='output' namespace='##targetNamespace'"
     * @generated
     */
    EList<TCaseParameter> getOutput();

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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCase_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TCase#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // TCase
