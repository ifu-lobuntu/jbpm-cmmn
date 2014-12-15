/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTimer Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TTimerEvent#getTimerExpression <em>Timer Expression</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TTimerEvent#getTimerStartGroup <em>Timer Start Group</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TTimerEvent#getTimerStart <em>Timer Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTTimerEvent()
 * @model extendedMetaData="name='tTimerEvent' kind='elementOnly'"
 * @generated
 */
public interface TTimerEvent extends TEvent {
    /**
     * Returns the value of the '<em><b>Timer Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *                 timerExpression is supposed to be an ISO-8601 conformant expression
     *               
     * <!-- end-model-doc -->
     * @return the value of the '<em>Timer Expression</em>' containment reference.
     * @see #setTimerExpression(TExpression)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTTimerEvent_TimerExpression()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='timerExpression' namespace='##targetNamespace'"
     * @generated
     */
    TExpression getTimerExpression();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TTimerEvent#getTimerExpression <em>Timer Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timer Expression</em>' containment reference.
     * @see #getTimerExpression()
     * @generated
     */
    void setTimerExpression(TExpression value);

    /**
     * Returns the value of the '<em><b>Timer Start Group</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *                 timerStart can be used to trigger the timer after a PlanItem or CaseFileItem
     *                 lifecycle state transition has occurred.
     *               
     * <!-- end-model-doc -->
     * @return the value of the '<em>Timer Start Group</em>' attribute list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTTimerEvent_TimerStartGroup()
     * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false"
     *        extendedMetaData="kind='group' name='timerStart:group' namespace='##targetNamespace'"
     * @generated
     */
    FeatureMap getTimerStartGroup();

    /**
     * Returns the value of the '<em><b>Timer Start</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *                 timerStart can be used to trigger the timer after a PlanItem or CaseFileItem
     *                 lifecycle state transition has occurred.
     *               
     * <!-- end-model-doc -->
     * @return the value of the '<em>Timer Start</em>' containment reference.
     * @see #setTimerStart(TStartTrigger)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTTimerEvent_TimerStart()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='timerStart' namespace='##targetNamespace' group='timerStart:group'"
     * @generated
     */
    TStartTrigger getTimerStart();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TTimerEvent#getTimerStart <em>Timer Start</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timer Start</em>' containment reference.
     * @see #getTimerStart()
     * @generated
     */
    void setTimerStart(TStartTrigger value);

} // TTimerEvent
