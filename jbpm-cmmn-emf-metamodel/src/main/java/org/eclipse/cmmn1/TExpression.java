/**
 */
package org.eclipse.cmmn1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TExpression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TExpression#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TExpression#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTExpression()
 * @model extendedMetaData="name='tExpression' kind='mixed'"
 * @generated
 */
public interface TExpression extends TCmmnElementWithMixedContent {
    /**
     * Returns the value of the '<em><b>Body</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Body</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Body</em>' attribute.
     * @see #setBody(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTExpression_Body()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='body' namespace='##targetNamespace'"
     * @generated
     */
    String getBody();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TExpression#getBody <em>Body</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Body</em>' attribute.
     * @see #getBody()
     * @generated
     */
    void setBody(String value);

    /**
     * Returns the value of the '<em><b>Language</b></em>' attribute.
     * The default value is <code>"http://www.w3.org/1999/XPath"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Language</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Language</em>' attribute.
     * @see #isSetLanguage()
     * @see #unsetLanguage()
     * @see #setLanguage(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTExpression_Language()
     * @model default="http://www.w3.org/1999/XPath" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
     *        extendedMetaData="kind='attribute' name='language'"
     * @generated
     */
    String getLanguage();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TExpression#getLanguage <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Language</em>' attribute.
     * @see #isSetLanguage()
     * @see #unsetLanguage()
     * @see #getLanguage()
     * @generated
     */
    void setLanguage(String value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmn1.TExpression#getLanguage <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetLanguage()
     * @see #getLanguage()
     * @see #setLanguage(String)
     * @generated
     */
    void unsetLanguage();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmn1.TExpression#getLanguage <em>Language</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Language</em>' attribute is set.
     * @see #unsetLanguage()
     * @see #getLanguage()
     * @see #setLanguage(String)
     * @generated
     */
    boolean isSetLanguage();

} // TExpression
