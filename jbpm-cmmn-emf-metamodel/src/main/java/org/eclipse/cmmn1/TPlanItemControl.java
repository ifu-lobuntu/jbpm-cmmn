/**
 */
package org.eclipse.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPlan Item Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tPlanItemcontrol defines the type of element "planItemControl".
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TPlanItemControl#getRepetitionRule <em>Repetition Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanItemControl#getRequiredRule <em>Required Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanItemControl#getManualActivationRule <em>Manual Activation Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemControl()
 * @model extendedMetaData="name='tPlanItemControl' kind='elementOnly'"
 * @generated
 */
public interface TPlanItemControl extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Repetition Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         repetitionRule is the root element for specifying a
     *         repetition rule for a PlanItemDefinition element.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Repetition Rule</em>' containment reference.
     * @see #setRepetitionRule(TRepetitionRule)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemControl_RepetitionRule()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='repetitionRule' namespace='##targetNamespace'"
     * @generated
     */
    TRepetitionRule getRepetitionRule();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItemControl#getRepetitionRule <em>Repetition Rule</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Repetition Rule</em>' containment reference.
     * @see #getRepetitionRule()
     * @generated
     */
    void setRepetitionRule(TRepetitionRule value);

    /**
     * Returns the value of the '<em><b>Required Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         requiredRule is the root element for specifying a
     *         required rule for a PlanItemDefinition element.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Required Rule</em>' containment reference.
     * @see #setRequiredRule(TRequiredRule)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemControl_RequiredRule()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='requiredRule' namespace='##targetNamespace'"
     * @generated
     */
    TRequiredRule getRequiredRule();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItemControl#getRequiredRule <em>Required Rule</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Required Rule</em>' containment reference.
     * @see #getRequiredRule()
     * @generated
     */
    void setRequiredRule(TRequiredRule value);

    /**
     * Returns the value of the '<em><b>Manual Activation Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         manualActivationRule is the root element for specifying an
     *         manual activation rule for a PlanItemDefinition element.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Manual Activation Rule</em>' containment reference.
     * @see #setManualActivationRule(TManualActivationRule)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItemControl_ManualActivationRule()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='manualActivationRule' namespace='##targetNamespace'"
     * @generated
     */
    TManualActivationRule getManualActivationRule();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItemControl#getManualActivationRule <em>Manual Activation Rule</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Manual Activation Rule</em>' containment reference.
     * @see #getManualActivationRule()
     * @generated
     */
    void setManualActivationRule(TManualActivationRule value);

} // TPlanItemControl
