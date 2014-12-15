/**
 */
package org.eclipse.cmmndi.impl;

import org.eclipse.cmmndi.CMMNDiagram;
import org.eclipse.cmmndi.CMMNEdge;
import org.eclipse.cmmndi.CMMNLabel;
import org.eclipse.cmmndi.CMMNLabelStyle;
import org.eclipse.cmmndi.CMMNPlane;
import org.eclipse.cmmndi.CMMNShape;
import org.eclipse.cmmndi.CmmnDiFactory;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.cmmndi.DocumentRoot;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CmmnDiFactoryImpl extends EFactoryImpl implements CmmnDiFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CmmnDiFactory init() {
        try {
            CmmnDiFactory theCmmnDiFactory = (CmmnDiFactory)EPackage.Registry.INSTANCE.getEFactory(CmmnDiPackage.eNS_URI);
            if (theCmmnDiFactory != null) {
                return theCmmnDiFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CmmnDiFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CmmnDiFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case CmmnDiPackage.CMMN_DIAGRAM: return createCMMNDiagram();
            case CmmnDiPackage.CMMN_EDGE: return createCMMNEdge();
            case CmmnDiPackage.CMMN_LABEL: return createCMMNLabel();
            case CmmnDiPackage.CMMN_LABEL_STYLE: return createCMMNLabelStyle();
            case CmmnDiPackage.CMMN_PLANE: return createCMMNPlane();
            case CmmnDiPackage.CMMN_SHAPE: return createCMMNShape();
            case CmmnDiPackage.DOCUMENT_ROOT: return createDocumentRoot();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNDiagram createCMMNDiagram() {
        CMMNDiagramImpl cmmnDiagram = new CMMNDiagramImpl();
        return cmmnDiagram;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNEdge createCMMNEdge() {
        CMMNEdgeImpl cmmnEdge = new CMMNEdgeImpl();
        return cmmnEdge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNLabel createCMMNLabel() {
        CMMNLabelImpl cmmnLabel = new CMMNLabelImpl();
        return cmmnLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNLabelStyle createCMMNLabelStyle() {
        CMMNLabelStyleImpl cmmnLabelStyle = new CMMNLabelStyleImpl();
        return cmmnLabelStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNPlane createCMMNPlane() {
        CMMNPlaneImpl cmmnPlane = new CMMNPlaneImpl();
        return cmmnPlane;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNShape createCMMNShape() {
        CMMNShapeImpl cmmnShape = new CMMNShapeImpl();
        return cmmnShape;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentRoot createDocumentRoot() {
        DocumentRootImpl documentRoot = new DocumentRootImpl();
        return documentRoot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CmmnDiPackage getCmmnDiPackage() {
        return (CmmnDiPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CmmnDiPackage getPackage() {
        return CmmnDiPackage.eINSTANCE;
    }

} //CmmnDiFactoryImpl
