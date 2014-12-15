/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TStage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tStage defines the type for element "stage"
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TStage#getPlanningTable <em>Planning Table</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TStage#getPlanItemDefinitionGroup <em>Plan Item Definition Group</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TStage#getPlanItemDefinition <em>Plan Item Definition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TStage#isAutoComplete <em>Auto Complete</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TStage#getExitCriteriaRefs <em>Exit Criteria Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTStage()
 * @model extendedMetaData="name='tStage' kind='elementOnly'"
 * @generated
 */
public interface TStage extends TPlanFragment {
    /**
     * Returns the value of the '<em><b>Planning Table</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Planning Table</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Planning Table</em>' containment reference.
     * @see #setPlanningTable(TPlanningTable)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTStage_PlanningTable()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='planningTable' namespace='##targetNamespace'"
     * @generated
     */
    TPlanningTable getPlanningTable();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TStage#getPlanningTable <em>Planning Table</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Planning Table</em>' containment reference.
     * @see #getPlanningTable()
     * @generated
     */
    void setPlanningTable(TPlanningTable value);

    /**
     * Returns the value of the '<em><b>Plan Item Definition Group</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plan Item Definition Group</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plan Item Definition Group</em>' attribute list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTStage_PlanItemDefinitionGroup()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='group' name='planItemDefinition:group' namespace='##targetNamespace'"
     * @generated
     */
    FeatureMap getPlanItemDefinitionGroup();

    /**
     * Returns the value of the '<em><b>Plan Item Definition</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TPlanItemDefinition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plan Item Definition</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plan Item Definition</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTStage_PlanItemDefinition()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='planItemDefinition' namespace='##targetNamespace' group='planItemDefinition:group'"
     * @generated
     */
    EList<TPlanItemDefinition> getPlanItemDefinition();

    /**
     * Returns the value of the '<em><b>Auto Complete</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Auto Complete</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Auto Complete</em>' attribute.
     * @see #isSetAutoComplete()
     * @see #unsetAutoComplete()
     * @see #setAutoComplete(boolean)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTStage_AutoComplete()
     * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='autoComplete'"
     * @generated
     */
    boolean isAutoComplete();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TStage#isAutoComplete <em>Auto Complete</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Auto Complete</em>' attribute.
     * @see #isSetAutoComplete()
     * @see #unsetAutoComplete()
     * @see #isAutoComplete()
     * @generated
     */
    void setAutoComplete(boolean value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmn1.TStage#isAutoComplete <em>Auto Complete</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetAutoComplete()
     * @see #isAutoComplete()
     * @see #setAutoComplete(boolean)
     * @generated
     */
    void unsetAutoComplete();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmn1.TStage#isAutoComplete <em>Auto Complete</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Auto Complete</em>' attribute is set.
     * @see #unsetAutoComplete()
     * @see #isAutoComplete()
     * @see #setAutoComplete(boolean)
     * @generated
     */
    boolean isSetAutoComplete();

    /**
     * Returns the value of the '<em><b>Exit Criteria Refs</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TSentry}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               exitCriteriaRefs refers zero or more "sentry" elements.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Exit Criteria Refs</em>' reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTStage_ExitCriteriaRefs()
     * @model extendedMetaData="kind='attribute' name='exitCriteriaRefs'"
     * @generated
     */
    EList<TSentry> getExitCriteriaRefs();

} // TStage
