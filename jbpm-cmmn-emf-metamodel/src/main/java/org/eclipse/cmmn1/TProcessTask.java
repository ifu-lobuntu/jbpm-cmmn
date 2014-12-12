/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TProcess Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tProcessTask defines the type of element "process"
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TProcessTask#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TProcessTask#getProcessRef <em>Process Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTProcessTask()
 * @model extendedMetaData="name='tProcessTask' kind='elementOnly'"
 * @generated
 */
public interface TProcessTask extends TTask {
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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTProcessTask_ParameterMapping()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='parameterMapping' namespace='##targetNamespace'"
     * @generated
     */
    EList<TParameterMapping> getParameterMapping();

    /**
     * Returns the value of the '<em><b>Process Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               processRef refers a "process" element which is re-usable and can
     *               be imported via some other file.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Process Ref</em>' reference.
     * @see #setProcessRef(TProcess)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTProcessTask_ProcessRef()
     * @model extendedMetaData="kind='attribute' name='processRef'"
     * @generated
     */
    TProcess getProcessRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TProcessTask#getProcessRef <em>Process Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Process Ref</em>' reference.
     * @see #getProcessRef()
     * @generated
     */
    void setProcessRef(TProcess value);

} // TProcessTask
