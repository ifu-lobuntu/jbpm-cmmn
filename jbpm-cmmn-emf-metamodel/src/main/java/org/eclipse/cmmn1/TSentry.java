/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TSentry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tSentry defines the type of element "sentry"
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TSentry#getOnPartGroup <em>On Part Group</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TSentry#getOnPart <em>On Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TSentry#getIfPart <em>If Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TSentry#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTSentry()
 * @model extendedMetaData="name='tSentry' kind='elementOnly'"
 * @generated
 */
public interface TSentry extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>On Part Group</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Part Group</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Part Group</em>' attribute list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTSentry_OnPartGroup()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='group' name='onPart:group' namespace='##targetNamespace'"
     * @generated
     */
    FeatureMap getOnPartGroup();

    /**
     * Returns the value of the '<em><b>On Part</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TOnPart}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Part</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Part</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTSentry_OnPart()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='onPart' namespace='##targetNamespace' group='onPart:group'"
     * @generated
     */
    EList<TOnPart> getOnPart();

    /**
     * Returns the value of the '<em><b>If Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>If Part</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>If Part</em>' containment reference.
     * @see #setIfPart(TIfPart)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTSentry_IfPart()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='ifPart' namespace='##targetNamespace'"
     * @generated
     */
    TIfPart getIfPart();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TSentry#getIfPart <em>If Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>If Part</em>' containment reference.
     * @see #getIfPart()
     * @generated
     */
    void setIfPart(TIfPart value);

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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTSentry_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TSentry#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // TSentry
