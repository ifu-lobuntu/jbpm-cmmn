/**
 */
package org.eclipse.uml2.di.umldi;

import org.eclipse.dd.cmmn.di.Label;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLLabel#getLabelStyle <em>Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLLabel()
 * @model extendedMetaData="name='UMLLabel' kind='elementOnly'"
 * @generated
 */
public interface UMLLabel extends Label {
    /**
     * Returns the value of the '<em><b>Label Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label Style</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label Style</em>' reference.
     * @see #setLabelStyle(UMLLabelStyle)
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLLabel_LabelStyle()
     * @model extendedMetaData="kind='attribute' name='labelStyle'"
     * @generated
     */
    UMLLabelStyle getLabelStyle();

    /**
     * Sets the value of the '{@link org.eclipse.uml2.di.umldi.UMLLabel#getLabelStyle <em>Label Style</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label Style</em>' reference.
     * @see #getLabelStyle()
     * @generated
     */
    void setLabelStyle(UMLLabelStyle value);

} // UMLLabel
