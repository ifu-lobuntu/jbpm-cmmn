/**
 */
package org.omg.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCase File Item On Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.cmmn1.TCaseFileItemOnPart#getStandardEvent <em>Standard Event</em>}</li>
 *   <li>{@link org.omg.cmmn1.TCaseFileItemOnPart#getRelationRef <em>Relation Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.TCaseFileItemOnPart#getSourceRef <em>Source Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItemOnPart()
 * @model extendedMetaData="name='tCaseFileItemOnPart' kind='elementOnly'"
 * @generated
 */
public interface TCaseFileItemOnPart extends TOnPart {
	/**
	 * Returns the value of the '<em><b>Standard Event</b></em>' attribute.
	 * The literals are from the enumeration {@link org.omg.cmmn1.CaseFileItemTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Event</em>' attribute.
	 * @see org.omg.cmmn1.CaseFileItemTransition
	 * @see #isSetStandardEvent()
	 * @see #unsetStandardEvent()
	 * @see #setStandardEvent(CaseFileItemTransition)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItemOnPart_StandardEvent()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='element' name='standardEvent' namespace='##targetNamespace'"
	 * @generated
	 */
	CaseFileItemTransition getStandardEvent();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItemOnPart#getStandardEvent <em>Standard Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Event</em>' attribute.
	 * @see org.omg.cmmn1.CaseFileItemTransition
	 * @see #isSetStandardEvent()
	 * @see #unsetStandardEvent()
	 * @see #getStandardEvent()
	 * @generated
	 */
	void setStandardEvent(CaseFileItemTransition value);

	/**
	 * Unsets the value of the '{@link org.omg.cmmn1.TCaseFileItemOnPart#getStandardEvent <em>Standard Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStandardEvent()
	 * @see #getStandardEvent()
	 * @see #setStandardEvent(CaseFileItemTransition)
	 * @generated
	 */
	void unsetStandardEvent();

	/**
	 * Returns whether the value of the '{@link org.omg.cmmn1.TCaseFileItemOnPart#getStandardEvent <em>Standard Event</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Standard Event</em>' attribute is set.
	 * @see #unsetStandardEvent()
	 * @see #getStandardEvent()
	 * @see #setStandardEvent(CaseFileItemTransition)
	 * @generated
	 */
	boolean isSetStandardEvent();

	/**
	 * Returns the value of the '<em><b>Relation Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Ref</em>' attribute.
	 * @see #setRelationRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItemOnPart_RelationRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='relationRef'"
	 * @generated
	 */
	String getRelationRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItemOnPart#getRelationRef <em>Relation Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Ref</em>' attribute.
	 * @see #getRelationRef()
	 * @generated
	 */
	void setRelationRef(String value);

	/**
	 * Returns the value of the '<em><b>Source Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               sourceRef refers a "caseFileItem" element
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Ref</em>' attribute.
	 * @see #setSourceRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItemOnPart_SourceRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='sourceRef'"
	 * @generated
	 */
	String getSourceRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItemOnPart#getSourceRef <em>Source Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Ref</em>' attribute.
	 * @see #getSourceRef()
	 * @generated
	 */
	void setSourceRef(String value);

} // TCaseFileItemOnPart
