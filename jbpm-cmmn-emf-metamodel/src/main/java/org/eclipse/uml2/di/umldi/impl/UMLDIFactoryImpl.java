/**
 */
package org.eclipse.uml2.di.umldi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.uml2.di.umldi.DocumentRoot;
import org.eclipse.uml2.di.umldi.UMLDIFactory;
import org.eclipse.uml2.di.umldi.UMLDIPackage;
import org.eclipse.uml2.di.umldi.UMLDiagram;
import org.eclipse.uml2.di.umldi.UMLEdge;
import org.eclipse.uml2.di.umldi.UMLLabel;
import org.eclipse.uml2.di.umldi.UMLLabelStyle;
import org.eclipse.uml2.di.umldi.UMLPlane;
import org.eclipse.uml2.di.umldi.UMLShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLDIFactoryImpl extends EFactoryImpl implements UMLDIFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static UMLDIFactory init() {
        try {
            UMLDIFactory theUMLDIFactory = (UMLDIFactory)EPackage.Registry.INSTANCE.getEFactory(UMLDIPackage.eNS_URI);
            if (theUMLDIFactory != null) {
                return theUMLDIFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new UMLDIFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLDIFactoryImpl() {
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
            case UMLDIPackage.UML_DIAGRAM: return createUMLDiagram();
            case UMLDIPackage.UML_EDGE: return createUMLEdge();
            case UMLDIPackage.UML_LABEL: return createUMLLabel();
            case UMLDIPackage.UML_LABEL_STYLE: return createUMLLabelStyle();
            case UMLDIPackage.UML_PLANE: return createUMLPlane();
            case UMLDIPackage.UML_SHAPE: return createUMLShape();
            case UMLDIPackage.DOCUMENT_ROOT: return createDocumentRoot();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLDiagram createUMLDiagram() {
        UMLDiagramImpl umlDiagram = new UMLDiagramImpl();
        return umlDiagram;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLEdge createUMLEdge() {
        UMLEdgeImpl umlEdge = new UMLEdgeImpl();
        return umlEdge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLLabel createUMLLabel() {
        UMLLabelImpl umlLabel = new UMLLabelImpl();
        return umlLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLLabelStyle createUMLLabelStyle() {
        UMLLabelStyleImpl umlLabelStyle = new UMLLabelStyleImpl();
        return umlLabelStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLPlane createUMLPlane() {
        UMLPlaneImpl umlPlane = new UMLPlaneImpl();
        return umlPlane;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLShape createUMLShape() {
        UMLShapeImpl umlShape = new UMLShapeImpl();
        return umlShape;
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
    public UMLDIPackage getUMLDIPackage() {
        return (UMLDIPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static UMLDIPackage getPackage() {
        return UMLDIPackage.eINSTANCE;
    }

} //UMLDIFactoryImpl
