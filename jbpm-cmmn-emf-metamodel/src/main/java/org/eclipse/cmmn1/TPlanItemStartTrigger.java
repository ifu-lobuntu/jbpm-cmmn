/**
 */
package org.eclipse.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPlan Item Start Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TPlanItemStartTrigger#getStandardEvent <em>Standard Event</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanItemStartTrigger#getSourceRef <em>Source Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemStartTrigger()
 * @model extendedMetaData="name='tPlanItemStartTrigger' kind='elementOnly'"
 * @generated
 */
public interface TPlanItemStartTrigger extends TStartTrigger {
    /**
     * Returns the value of the '<em><b>Standard Event</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.cmmn1.PlanItemTransition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Standard Event</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Standard Event</em>' attribute.
     * @see org.eclipse.cmmn1.PlanItemTransition
     * @see #isSetStandardEvent()
     * @see #unsetStandardEvent()
     * @see #setStandardEvent(PlanItemTransition)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemStartTrigger_StandardEvent()
     * @model unsettable="true"
     *        extendedMetaData="kind='element' name='standardEvent' namespace='##targetNamespace'"
     * @generated
     */
    PlanItemTransition getStandardEvent();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItemStartTrigger#getStandardEvent <em>Standard Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Standard Event</em>' attribute.
     * @see org.eclipse.cmmn1.PlanItemTransition
     * @see #isSetStandardEvent()
     * @see #unsetStandardEvent()
     * @see #getStandardEvent()
     * @generated
     */
    void setStandardEvent(PlanItemTransition value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmn1.TPlanItemStartTrigger#getStandardEvent <em>Standard Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetStandardEvent()
     * @see #getStandardEvent()
     * @see #setStandardEvent(PlanItemTransition)
     * @generated
     */
    void unsetStandardEvent();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmn1.TPlanItemStartTrigger#getStandardEvent <em>Standard Event</em>}' attribute is set.
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
     * Returns the value of the '<em><b>Source Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               sourceRef refers a "planItem" element
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Source Ref</em>' reference.
     * @see #setSourceRef(TPlanItem)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemStartTrigger_SourceRef()
     * @model extendedMetaData="kind='attribute' name='sourceRef'"
     * @generated
     */
    TPlanItem getSourceRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItemStartTrigger#getSourceRef <em>Source Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Ref</em>' reference.
     * @see #getSourceRef()
     * @generated
     */
    void setSourceRef(TPlanItem value);

} // TPlanItemStartTrigger
