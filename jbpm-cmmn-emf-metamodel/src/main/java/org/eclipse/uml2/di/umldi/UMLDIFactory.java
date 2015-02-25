/**
 */
package org.eclipse.uml2.di.umldi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.di.umldi.UMLDIPackage
 * @generated
 */
public interface UMLDIFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    UMLDIFactory eINSTANCE = org.eclipse.uml2.di.umldi.impl.UMLDIFactoryImpl.init();

    /**
     * Returns a new object of class '<em>UML Diagram</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UML Diagram</em>'.
     * @generated
     */
    UMLDiagram createUMLDiagram();

    /**
     * Returns a new object of class '<em>UML Edge</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UML Edge</em>'.
     * @generated
     */
    UMLEdge createUMLEdge();

    /**
     * Returns a new object of class '<em>UML Label</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UML Label</em>'.
     * @generated
     */
    UMLLabel createUMLLabel();

    /**
     * Returns a new object of class '<em>UML Label Style</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UML Label Style</em>'.
     * @generated
     */
    UMLLabelStyle createUMLLabelStyle();

    /**
     * Returns a new object of class '<em>UML Plane</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UML Plane</em>'.
     * @generated
     */
    UMLPlane createUMLPlane();

    /**
     * Returns a new object of class '<em>UML Shape</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UML Shape</em>'.
     * @generated
     */
    UMLShape createUMLShape();

    /**
     * Returns a new object of class '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Document Root</em>'.
     * @generated
     */
    DocumentRoot createDocumentRoot();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    UMLDIPackage getUMLDIPackage();

} //UMLDIFactory
