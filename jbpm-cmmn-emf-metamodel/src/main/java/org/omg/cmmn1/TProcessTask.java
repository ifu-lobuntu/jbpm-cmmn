/**
 */
package org.omg.cmmn1;

import javax.xml.namespace.QName;

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
 *   <li>{@link org.omg.cmmn1.TProcessTask#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link org.omg.cmmn1.TProcessTask#getProcessRef <em>Process Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTProcessTask()
 * @model extendedMetaData="name='tProcessTask' kind='elementOnly'"
 * @generated
 */
public interface TProcessTask extends TTask {
	/**
	 * Returns the value of the '<em><b>Parameter Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.cmmn1.TParameterMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Mapping</em>' containment reference list.
	 * @see org.omg.cmmn1.Cmmn1Package#getTProcessTask_ParameterMapping()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameterMapping' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TParameterMapping> getParameterMapping();

	/**
	 * Returns the value of the '<em><b>Process Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               processRef refers a "process" element which is re-usable and can
	 *               be imported via some other file.
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Process Ref</em>' attribute.
	 * @see #setProcessRef(QName)
	 * @see org.omg.cmmn1.Cmmn1Package#getTProcessTask_ProcessRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='processRef'"
	 * @generated
	 */
	QName getProcessRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TProcessTask#getProcessRef <em>Process Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Ref</em>' attribute.
	 * @see #getProcessRef()
	 * @generated
	 */
	void setProcessRef(QName value);

} // TProcessTask
