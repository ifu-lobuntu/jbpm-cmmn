/**
 */
package org.eclipse.uml2.di.umldi;

import org.eclipse.dd.cmmn.di.Diagram;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLDiagram#getUmlPlane <em>Uml Plane</em>}</li>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLDiagram#getLabelStyle <em>Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLDiagram()
 * @model extendedMetaData="name='UMLDiagram' kind='elementOnly'"
 * @generated
 */
public interface UMLDiagram extends Diagram {
    /**
     * Returns the value of the '<em><b>Uml Plane</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uml Plane</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uml Plane</em>' containment reference.
     * @see #setUmlPlane(UMLPlane)
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLDiagram_UmlPlane()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='UMLPlane' namespace='##targetNamespace'"
     * @generated
     */
    UMLPlane getUmlPlane();

    /**
     * Sets the value of the '{@link org.eclipse.uml2.di.umldi.UMLDiagram#getUmlPlane <em>Uml Plane</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uml Plane</em>' containment reference.
     * @see #getUmlPlane()
     * @generated
     */
    void setUmlPlane(UMLPlane value);

    /**
     * Returns the value of the '<em><b>Label Style</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.uml2.di.umldi.UMLLabelStyle}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label Style</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label Style</em>' containment reference list.
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLDiagram_LabelStyle()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='UMLLabelStyle' namespace='##targetNamespace'"
     * @generated
     */
    EList<UMLLabelStyle> getLabelStyle();

} // UMLDiagram
