/**
 */
package org.eclipse.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPlan Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TPlanItem#getItemControl <em>Item Control</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanItem#getDefinitionRef <em>Definition Ref</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanItem#getEntryCriteriaRefs <em>Entry Criteria Refs</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanItem#getExitCriteriaRefs <em>Exit Criteria Refs</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TPlanItem#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItem()
 * @model extendedMetaData="name='tPlanItem' kind='elementOnly'"
 * @generated
 */
public interface TPlanItem extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Item Control</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item Control</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item Control</em>' containment reference.
     * @see #setItemControl(TPlanItemControl)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItem_ItemControl()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='itemControl' namespace='##targetNamespace'"
     * @generated
     */
    TPlanItemControl getItemControl();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItem#getItemControl <em>Item Control</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item Control</em>' containment reference.
     * @see #getItemControl()
     * @generated
     */
    void setItemControl(TPlanItemControl value);

    /**
     * Returns the value of the '<em><b>Definition Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               definitionRef refers a "planItemDefinition" element.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Definition Ref</em>' reference.
     * @see #setDefinitionRef(TPlanItemDefinition)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItem_DefinitionRef()
     * @model extendedMetaData="kind='attribute' name='definitionRef'"
     * @generated
     */
    TPlanItemDefinition getDefinitionRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItem#getDefinitionRef <em>Definition Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Definition Ref</em>' reference.
     * @see #getDefinitionRef()
     * @generated
     */
    void setDefinitionRef(TPlanItemDefinition value);

    /**
     * Returns the value of the '<em><b>Entry Criteria Refs</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               entryCriteriaRefs refers "sentry" elements.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Entry Criteria Refs</em>' reference.
     * @see #setEntryCriteriaRefs(TSentry)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItem_EntryCriteriaRefs()
     * @model extendedMetaData="kind='attribute' name='entryCriteriaRefs'"
     * @generated
     */
    TSentry getEntryCriteriaRefs();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItem#getEntryCriteriaRefs <em>Entry Criteria Refs</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Entry Criteria Refs</em>' reference.
     * @see #getEntryCriteriaRefs()
     * @generated
     */
    void setEntryCriteriaRefs(TSentry value);

    /**
     * Returns the value of the '<em><b>Exit Criteria Refs</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               exitCriteriaRefs refers "sentry" elements.
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Exit Criteria Refs</em>' reference.
     * @see #setExitCriteriaRefs(TSentry)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItem_ExitCriteriaRefs()
     * @model extendedMetaData="kind='attribute' name='exitCriteriaRefs'"
     * @generated
     */
    TSentry getExitCriteriaRefs();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItem#getExitCriteriaRefs <em>Exit Criteria Refs</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exit Criteria Refs</em>' reference.
     * @see #getExitCriteriaRefs()
     * @generated
     */
    void setExitCriteriaRefs(TSentry value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTPlanItem_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TPlanItem#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // TPlanItem
