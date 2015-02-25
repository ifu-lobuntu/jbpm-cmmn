/**
 */
package org.eclipse.uml2.di.umldi;

import org.eclipse.dd.cmmn.dc.Font;
import org.eclipse.dd.cmmn.di.Style;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Label Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLLabelStyle#getFont <em>Font</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLLabelStyle()
 * @model extendedMetaData="name='UMLLabelStyle' kind='elementOnly'"
 * @generated
 */
public interface UMLLabelStyle extends Style {
    /**
     * Returns the value of the '<em><b>Font</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Font</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Font</em>' containment reference.
     * @see #setFont(Font)
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLLabelStyle_Font()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='Font' namespace='http://www.omg.org/spec/DD/20150101/DC'"
     * @generated
     */
    Font getFont();

    /**
     * Sets the value of the '{@link org.eclipse.uml2.di.umldi.UMLLabelStyle#getFont <em>Font</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Font</em>' containment reference.
     * @see #getFont()
     * @generated
     */
    void setFont(Font value);

} // UMLLabelStyle
