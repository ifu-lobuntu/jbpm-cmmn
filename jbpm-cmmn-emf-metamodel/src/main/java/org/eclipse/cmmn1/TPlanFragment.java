/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPlan Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tPlanFragment defines the type for element "planFragment"
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TPlanFragment#getPlanItem <em>Plan Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanFragment#getSentry <em>Sentry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanFragment()
 * @model extendedMetaData="name='tPlanFragment' kind='elementOnly'"
 * @generated
 */
public interface TPlanFragment extends TPlanItemDefinition {
    /**
     * Returns the value of the '<em><b>Plan Item</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TPlanItem}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plan Item</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plan Item</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanFragment_PlanItem()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='planItem' namespace='##targetNamespace'"
     * @generated
     */
    EList<TPlanItem> getPlanItem();

    /**
     * Returns the value of the '<em><b>Sentry</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TSentry}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         sentry is the root element of "Sentry" in the Case Model and
     *         comprises of zero or more OnParts and zero or one IfPart.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Sentry</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanFragment_Sentry()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='sentry' namespace='##targetNamespace'"
     * @generated
     */
    EList<TSentry> getSentry();

} // TPlanFragment
