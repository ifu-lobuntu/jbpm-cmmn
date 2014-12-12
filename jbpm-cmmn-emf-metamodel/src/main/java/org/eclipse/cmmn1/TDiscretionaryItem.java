/**
 */
package org.eclipse.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TDiscretionary Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TDiscretionaryItem#getItemControl <em>Item Control</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDiscretionaryItem#getDefinitionRef <em>Definition Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTDiscretionaryItem()
 * @model extendedMetaData="name='tDiscretionaryItem' kind='elementOnly'"
 * @generated
 */
public interface TDiscretionaryItem extends TTableItem {
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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDiscretionaryItem_ItemControl()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='itemControl' namespace='##targetNamespace'"
     * @generated
     */
    TPlanItemControl getItemControl();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDiscretionaryItem#getItemControl <em>Item Control</em>}' containment reference.
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
     *               definitionRef refers a "planItemDefinition" element
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Definition Ref</em>' reference.
     * @see #setDefinitionRef(TPlanItem)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDiscretionaryItem_DefinitionRef()
     * @model extendedMetaData="kind='attribute' name='definitionRef'"
     * @generated
     */
    TPlanItem getDefinitionRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDiscretionaryItem#getDefinitionRef <em>Definition Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Definition Ref</em>' reference.
     * @see #getDefinitionRef()
     * @generated
     */
    void setDefinitionRef(TPlanItem value);

} // TDiscretionaryItem
