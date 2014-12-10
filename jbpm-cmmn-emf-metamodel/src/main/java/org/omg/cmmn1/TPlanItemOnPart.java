/**
 */
package org.omg.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPlan Item On Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.cmmn1.TPlanItemOnPart#getStandardEvent <em>Standard Event</em>}</li>
 *   <li>{@link org.omg.cmmn1.TPlanItemOnPart#getSentryRef <em>Sentry Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.TPlanItemOnPart#getSourceRef <em>Source Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTPlanItemOnPart()
 * @model extendedMetaData="name='tPlanItemOnPart' kind='elementOnly'"
 * @generated
 */
public interface TPlanItemOnPart extends TOnPart {
	/**
	 * Returns the value of the '<em><b>Standard Event</b></em>' attribute.
	 * The literals are from the enumeration {@link org.omg.cmmn1.PlanItemTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Event</em>' attribute.
	 * @see org.omg.cmmn1.PlanItemTransition
	 * @see #isSetStandardEvent()
	 * @see #unsetStandardEvent()
	 * @see #setStandardEvent(PlanItemTransition)
	 * @see org.omg.cmmn1.Cmmn1Package#getTPlanItemOnPart_StandardEvent()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='element' name='standardEvent' namespace='##targetNamespace'"
	 * @generated
	 */
	PlanItemTransition getStandardEvent();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TPlanItemOnPart#getStandardEvent <em>Standard Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Event</em>' attribute.
	 * @see org.omg.cmmn1.PlanItemTransition
	 * @see #isSetStandardEvent()
	 * @see #unsetStandardEvent()
	 * @see #getStandardEvent()
	 * @generated
	 */
	void setStandardEvent(PlanItemTransition value);

	/**
	 * Unsets the value of the '{@link org.omg.cmmn1.TPlanItemOnPart#getStandardEvent <em>Standard Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStandardEvent()
	 * @see #getStandardEvent()
	 * @see #setStandardEvent(PlanItemTransition)
	 * @generated
	 */
	void unsetStandardEvent();

	/**
	 * Returns whether the value of the '{@link org.omg.cmmn1.TPlanItemOnPart#getStandardEvent <em>Standard Event</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Standard Event</em>' attribute is set.
	 * @see #unsetStandardEvent()
	 * @see #getStandardEvent()
	 * @see #setStandardEvent(PlanItemTransition)
	 * @generated
	 */
	boolean isSetStandardEvent();

	/**
	 * Returns the value of the '<em><b>Sentry Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               sentryRef refers a "Sentry" element
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sentry Ref</em>' attribute.
	 * @see #setSentryRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTPlanItemOnPart_SentryRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='sentryRef'"
	 * @generated
	 */
	String getSentryRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TPlanItemOnPart#getSentryRef <em>Sentry Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentry Ref</em>' attribute.
	 * @see #getSentryRef()
	 * @generated
	 */
	void setSentryRef(String value);

	/**
	 * Returns the value of the '<em><b>Source Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               sourceRef refers a "planItem" element
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Ref</em>' attribute.
	 * @see #setSourceRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTPlanItemOnPart_SourceRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='sourceRef'"
	 * @generated
	 */
	String getSourceRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TPlanItemOnPart#getSourceRef <em>Source Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Ref</em>' attribute.
	 * @see #getSourceRef()
	 * @generated
	 */
	void setSourceRef(String value);

} // TPlanItemOnPart
