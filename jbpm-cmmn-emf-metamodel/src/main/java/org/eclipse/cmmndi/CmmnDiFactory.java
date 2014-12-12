/**
 */
package org.eclipse.cmmndi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.cmmndi.CmmnDiPackage
 * @generated
 */
public interface CmmnDiFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CmmnDiFactory eINSTANCE = org.eclipse.cmmndi.impl.CmmnDiFactoryImpl.init();

    /**
     * Returns a new object of class '<em>CMMN Diagram</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>CMMN Diagram</em>'.
     * @generated
     */
    CMMNDiagram createCMMNDiagram();

    /**
     * Returns a new object of class '<em>CMMN Edge</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>CMMN Edge</em>'.
     * @generated
     */
    CMMNEdge createCMMNEdge();

    /**
     * Returns a new object of class '<em>CMMN Label</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>CMMN Label</em>'.
     * @generated
     */
    CMMNLabel createCMMNLabel();

    /**
     * Returns a new object of class '<em>CMMN Label Style</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>CMMN Label Style</em>'.
     * @generated
     */
    CMMNLabelStyle createCMMNLabelStyle();

    /**
     * Returns a new object of class '<em>CMMN Plane</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>CMMN Plane</em>'.
     * @generated
     */
    CMMNPlane createCMMNPlane();

    /**
     * Returns a new object of class '<em>CMMN Shape</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>CMMN Shape</em>'.
     * @generated
     */
    CMMNShape createCMMNShape();

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
    CmmnDiPackage getCmmnDiPackage();

} //CmmnDiFactory
