/**
 */
package org.omg.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TIf Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.cmmn1.TIfPart#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.omg.cmmn1.TIfPart#getContextRef <em>Context Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTIfPart()
 * @model extendedMetaData="name='tIfPart' kind='elementOnly'"
 * @generated
 */
public interface TIfPart extends TCmmnElement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.cmmn1.TExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference list.
	 * @see org.omg.cmmn1.Cmmn1Package#getTIfPart_Condition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TExpression> getCondition();

	/**
	 * Returns the value of the '<em><b>Context Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               contextRef refers a "caseFileItem" element
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context Ref</em>' attribute.
	 * @see #setContextRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTIfPart_ContextRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='contextRef'"
	 * @generated
	 */
	String getContextRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TIfPart#getContextRef <em>Context Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Ref</em>' attribute.
	 * @see #getContextRef()
	 * @generated
	 */
	void setContextRef(String value);

} // TIfPart
