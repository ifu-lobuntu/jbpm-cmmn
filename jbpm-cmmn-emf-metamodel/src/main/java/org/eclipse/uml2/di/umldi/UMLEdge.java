/**
 */
package org.eclipse.uml2.di.umldi;

import org.eclipse.dd.cmmn.di.DiagramElement;
import org.eclipse.dd.cmmn.di.LabeledEdge;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLEdge#getUmlLabel <em>Uml Label</em>}</li>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLEdge#getUmlElement <em>Uml Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLEdge#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.di.umldi.UMLEdge#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLEdge()
 * @model extendedMetaData="name='UMLEdge' kind='elementOnly'"
 * @generated
 */
public interface UMLEdge extends LabeledEdge {
    /**
     * Returns the value of the '<em><b>Uml Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uml Label</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uml Label</em>' containment reference.
     * @see #setUmlLabel(UMLLabel)
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLEdge_UmlLabel()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='UMLLabel' namespace='##targetNamespace'"
     * @generated
     */
    UMLLabel getUmlLabel();

    /**
     * Sets the value of the '{@link org.eclipse.uml2.di.umldi.UMLEdge#getUmlLabel <em>Uml Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uml Label</em>' containment reference.
     * @see #getUmlLabel()
     * @generated
     */
    void setUmlLabel(UMLLabel value);

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
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLEdge_UmlElement()
     * @model extendedMetaData="kind='attribute' name='UMLElement'"
     * @generated
     */
    Element getUmlElement();

    /**
     * Sets the value of the '{@link org.eclipse.uml2.di.umldi.UMLEdge#getUmlElement <em>Uml Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uml Element</em>' reference.
     * @see #getUmlElement()
     * @generated
     */
    void setUmlElement(Element value);

    /**
     * Returns the value of the '<em><b>Source Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Element</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Element</em>' reference.
     * @see #setSourceElement(DiagramElement)
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLEdge_SourceElement()
     * @model extendedMetaData="kind='attribute' name='sourceElement'"
     * @generated
     */
    DiagramElement getSourceElement();

    /**
     * Sets the value of the '{@link org.eclipse.uml2.di.umldi.UMLEdge#getSourceElement <em>Source Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Element</em>' reference.
     * @see #getSourceElement()
     * @generated
     */
    void setSourceElement(DiagramElement value);

    /**
     * Returns the value of the '<em><b>Target Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Element</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Element</em>' reference.
     * @see #setTargetElement(DiagramElement)
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#getUMLEdge_TargetElement()
     * @model extendedMetaData="kind='attribute' name='targetElement'"
     * @generated
     */
    DiagramElement getTargetElement();

    /**
     * Sets the value of the '{@link org.eclipse.uml2.di.umldi.UMLEdge#getTargetElement <em>Target Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Element</em>' reference.
     * @see #getTargetElement()
     * @generated
     */
    void setTargetElement(DiagramElement value);

} // UMLEdge
