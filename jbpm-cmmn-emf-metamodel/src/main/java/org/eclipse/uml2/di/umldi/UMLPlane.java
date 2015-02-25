/**
 */
package org.eclipse.uml2.di.umldi;

import org.eclipse.dd.cmmn.di.Plane;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Plane</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLPlane#getUmlElement <em>Uml Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLPlane()
 * @model extendedMetaData="name='UMLPlane' kind='elementOnly'"
 * @generated
 */
public interface UMLPlane extends Plane {
    /**
     * Returns the value of the '<em><b>Uml Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uml Element</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uml Element</em>' reference.
     * @see #setUmlElement(Element)
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLPlane_UmlElement()
     * @model extendedMetaData="kind='attribute' name='UMLElement'"
     * @generated
     */
    Element getUmlElement();

    /**
     * Sets the value of the '{@link org.eclipse.uml2.di.umldi.UMLPlane#getUmlElement <em>Uml Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uml Element</em>' reference.
     * @see #getUmlElement()
     * @generated
     */
    void setUmlElement(Element value);

} // UMLPlane
