/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCase Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tCaseTask defines the type of element "caseTask"
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TCaseTask#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCaseTask#getCaseRef <em>Case Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseTask()
 * @model extendedMetaData="name='tCaseTask' kind='elementOnly'"
 * @generated
 */
public interface TCaseTask extends TTask {
    /**
     * Returns the value of the '<em><b>Parameter Mapping</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TParameterMapping}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Mapping</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter Mapping</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseTask_ParameterMapping()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='parameterMapping' namespace='##targetNamespace'"
     * @generated
     */
    EList<TParameterMapping> getParameterMapping();

    /**
     * Returns the value of the '<em><b>Case Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               caseRef refers a "case" element which is re-usable and can
     *               be imported via some other file.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case Ref</em>' reference.
     * @see #setCaseRef(TCase)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseTask_CaseRef()
     * @model extendedMetaData="kind='attribute' name='caseRef'"
     * @generated
     */
    TCase getCaseRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TCaseTask#getCaseRef <em>Case Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case Ref</em>' reference.
     * @see #getCaseRef()
     * @generated
     */
    void setCaseRef(TCase value);

} // TCaseTask
