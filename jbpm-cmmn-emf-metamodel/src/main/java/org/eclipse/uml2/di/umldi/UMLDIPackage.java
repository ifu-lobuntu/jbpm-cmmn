/**
 */
package org.eclipse.uml2.di.umldi;

import org.eclipse.dd.cmmn.di.DiPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.di.umldi.UMLDIFactory
 * @model kind="package"
 * @generated
 */
public interface UMLDIPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "umldi";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.omg.org/spec/UML/20131201/DI";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "umldi";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    UMLDIPackage eINSTANCE = org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.uml2.di.umldi.impl.UMLDiagramImpl <em>UML Diagram</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.uml2.di.umldi.impl.UMLDiagramImpl
     * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLDiagram()
     * @generated
     */
    int UML_DIAGRAM = 0;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM__DOCUMENTATION = DiPackage.DIAGRAM__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Owned Style</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM__OWNED_STYLE = DiPackage.DIAGRAM__OWNED_STYLE;

    /**
     * The feature id for the '<em><b>Root Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM__ROOT_ELEMENT = DiPackage.DIAGRAM__ROOT_ELEMENT;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM__ID = DiPackage.DIAGRAM__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM__NAME = DiPackage.DIAGRAM__NAME;

    /**
     * The feature id for the '<em><b>Resolution</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM__RESOLUTION = DiPackage.DIAGRAM__RESOLUTION;

    /**
     * The feature id for the '<em><b>Uml Plane</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM__UML_PLANE = DiPackage.DIAGRAM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Label Style</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM__LABEL_STYLE = DiPackage.DIAGRAM_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>UML Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM_FEATURE_COUNT = DiPackage.DIAGRAM_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>UML Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_DIAGRAM_OPERATION_COUNT = DiPackage.DIAGRAM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.uml2.di.umldi.impl.UMLEdgeImpl <em>UML Edge</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.uml2.di.umldi.impl.UMLEdgeImpl
     * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLEdge()
     * @generated
     */
    int UML_EDGE = 1;

    /**
     * The feature id for the '<em><b>Owning Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__OWNING_DIAGRAM = DiPackage.LABELED_EDGE__OWNING_DIAGRAM;

    /**
     * The feature id for the '<em><b>Owning Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__OWNING_ELEMENT = DiPackage.LABELED_EDGE__OWNING_ELEMENT;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__OWNED_ELEMENT = DiPackage.LABELED_EDGE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__MODEL_ELEMENT = DiPackage.LABELED_EDGE__MODEL_ELEMENT;

    /**
     * The feature id for the '<em><b>Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__STYLE = DiPackage.LABELED_EDGE__STYLE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__ID = DiPackage.LABELED_EDGE__ID;

    /**
     * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__ANY_ATTRIBUTE = DiPackage.LABELED_EDGE__ANY_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__SOURCE = DiPackage.LABELED_EDGE__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__TARGET = DiPackage.LABELED_EDGE__TARGET;

    /**
     * The feature id for the '<em><b>Waypoint</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__WAYPOINT = DiPackage.LABELED_EDGE__WAYPOINT;

    /**
     * The feature id for the '<em><b>Owned Label</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__OWNED_LABEL = DiPackage.LABELED_EDGE__OWNED_LABEL;

    /**
     * The feature id for the '<em><b>Uml Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__UML_LABEL = DiPackage.LABELED_EDGE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Uml Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__UML_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Source Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__SOURCE_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Target Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE__TARGET_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>UML Edge</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE_FEATURE_COUNT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>UML Edge</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_EDGE_OPERATION_COUNT = DiPackage.LABELED_EDGE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.uml2.di.umldi.impl.UMLLabelImpl <em>UML Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.uml2.di.umldi.impl.UMLLabelImpl
     * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLLabel()
     * @generated
     */
    int UML_LABEL = 2;

    /**
     * The feature id for the '<em><b>Owning Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__OWNING_DIAGRAM = DiPackage.LABEL__OWNING_DIAGRAM;

    /**
     * The feature id for the '<em><b>Owning Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__OWNING_ELEMENT = DiPackage.LABEL__OWNING_ELEMENT;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__OWNED_ELEMENT = DiPackage.LABEL__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__MODEL_ELEMENT = DiPackage.LABEL__MODEL_ELEMENT;

    /**
     * The feature id for the '<em><b>Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__STYLE = DiPackage.LABEL__STYLE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__ID = DiPackage.LABEL__ID;

    /**
     * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__ANY_ATTRIBUTE = DiPackage.LABEL__ANY_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Bounds</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__BOUNDS = DiPackage.LABEL__BOUNDS;

    /**
     * The feature id for the '<em><b>Label Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL__LABEL_STYLE = DiPackage.LABEL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>UML Label</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL_FEATURE_COUNT = DiPackage.LABEL_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>UML Label</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL_OPERATION_COUNT = DiPackage.LABEL_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.uml2.di.umldi.impl.UMLLabelStyleImpl <em>UML Label Style</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.uml2.di.umldi.impl.UMLLabelStyleImpl
     * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLLabelStyle()
     * @generated
     */
    int UML_LABEL_STYLE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL_STYLE__ID = DiPackage.STYLE__ID;

    /**
     * The feature id for the '<em><b>Font</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL_STYLE__FONT = DiPackage.STYLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>UML Label Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL_STYLE_FEATURE_COUNT = DiPackage.STYLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>UML Label Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_LABEL_STYLE_OPERATION_COUNT = DiPackage.STYLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.uml2.di.umldi.impl.UMLPlaneImpl <em>UML Plane</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.uml2.di.umldi.impl.UMLPlaneImpl
     * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLPlane()
     * @generated
     */
    int UML_PLANE = 4;

    /**
     * The feature id for the '<em><b>Owning Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__OWNING_DIAGRAM = DiPackage.PLANE__OWNING_DIAGRAM;

    /**
     * The feature id for the '<em><b>Owning Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__OWNING_ELEMENT = DiPackage.PLANE__OWNING_ELEMENT;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__OWNED_ELEMENT = DiPackage.PLANE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__MODEL_ELEMENT = DiPackage.PLANE__MODEL_ELEMENT;

    /**
     * The feature id for the '<em><b>Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__STYLE = DiPackage.PLANE__STYLE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__ID = DiPackage.PLANE__ID;

    /**
     * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__ANY_ATTRIBUTE = DiPackage.PLANE__ANY_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Plane Element</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__PLANE_ELEMENT = DiPackage.PLANE__PLANE_ELEMENT;

    /**
     * The feature id for the '<em><b>Uml Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE__UML_ELEMENT = DiPackage.PLANE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>UML Plane</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE_FEATURE_COUNT = DiPackage.PLANE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Plane element type</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = DiPackage.PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP;

    /**
     * The number of operations of the '<em>UML Plane</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_PLANE_OPERATION_COUNT = DiPackage.PLANE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.uml2.di.umldi.impl.UMLShapeImpl <em>UML Shape</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.uml2.di.umldi.impl.UMLShapeImpl
     * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLShape()
     * @generated
     */
    int UML_SHAPE = 5;

    /**
     * The feature id for the '<em><b>Owning Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__OWNING_DIAGRAM = DiPackage.LABELED_SHAPE__OWNING_DIAGRAM;

    /**
     * The feature id for the '<em><b>Owning Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__OWNING_ELEMENT = DiPackage.LABELED_SHAPE__OWNING_ELEMENT;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__OWNED_ELEMENT = DiPackage.LABELED_SHAPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__MODEL_ELEMENT = DiPackage.LABELED_SHAPE__MODEL_ELEMENT;

    /**
     * The feature id for the '<em><b>Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__STYLE = DiPackage.LABELED_SHAPE__STYLE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__ID = DiPackage.LABELED_SHAPE__ID;

    /**
     * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__ANY_ATTRIBUTE = DiPackage.LABELED_SHAPE__ANY_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>Bounds</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__BOUNDS = DiPackage.LABELED_SHAPE__BOUNDS;

    /**
     * The feature id for the '<em><b>Owned Label</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__OWNED_LABEL = DiPackage.LABELED_SHAPE__OWNED_LABEL;

    /**
     * The feature id for the '<em><b>Uml Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__UML_LABEL = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Uml Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__UML_ELEMENT = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Is Expanded</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE__IS_EXPANDED = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>UML Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE_FEATURE_COUNT = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>UML Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UML_SHAPE_OPERATION_COUNT = DiPackage.LABELED_SHAPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.uml2.di.umldi.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.uml2.di.umldi.impl.DocumentRootImpl
     * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getDocumentRoot()
     * @generated
     */
    int DOCUMENT_ROOT = 6;

    /**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MIXED = 0;

    /**
     * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

    /**
     * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

    /**
     * The feature id for the '<em><b>Packages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__PACKAGES = 3;

    /**
     * The feature id for the '<em><b>Diagram</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__DIAGRAM = 4;

    /**
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.uml2.di.umldi.UMLDiagram <em>UML Diagram</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UML Diagram</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLDiagram
     * @generated
     */
    EClass getUMLDiagram();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.uml2.di.umldi.UMLDiagram#getUmlPlane <em>Uml Plane</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Uml Plane</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLDiagram#getUmlPlane()
     * @see #getUMLDiagram()
     * @generated
     */
    EReference getUMLDiagram_UmlPlane();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.di.umldi.UMLDiagram#getLabelStyle <em>Label Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Label Style</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLDiagram#getLabelStyle()
     * @see #getUMLDiagram()
     * @generated
     */
    EReference getUMLDiagram_LabelStyle();

    /**
     * Returns the meta object for class '{@link org.eclipse.uml2.di.umldi.UMLEdge <em>UML Edge</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UML Edge</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLEdge
     * @generated
     */
    EClass getUMLEdge();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.uml2.di.umldi.UMLEdge#getUmlLabel <em>Uml Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Uml Label</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLEdge#getUmlLabel()
     * @see #getUMLEdge()
     * @generated
     */
    EReference getUMLEdge_UmlLabel();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.uml2.di.umldi.UMLEdge#getUmlElement <em>Uml Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Uml Element</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLEdge#getUmlElement()
     * @see #getUMLEdge()
     * @generated
     */
    EReference getUMLEdge_UmlElement();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.uml2.di.umldi.UMLEdge#getSourceElement <em>Source Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source Element</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLEdge#getSourceElement()
     * @see #getUMLEdge()
     * @generated
     */
    EReference getUMLEdge_SourceElement();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.uml2.di.umldi.UMLEdge#getTargetElement <em>Target Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target Element</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLEdge#getTargetElement()
     * @see #getUMLEdge()
     * @generated
     */
    EReference getUMLEdge_TargetElement();

    /**
     * Returns the meta object for class '{@link org.eclipse.uml2.di.umldi.UMLLabel <em>UML Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UML Label</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLLabel
     * @generated
     */
    EClass getUMLLabel();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.uml2.di.umldi.UMLLabel#getLabelStyle <em>Label Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Label Style</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLLabel#getLabelStyle()
     * @see #getUMLLabel()
     * @generated
     */
    EReference getUMLLabel_LabelStyle();

    /**
     * Returns the meta object for class '{@link org.eclipse.uml2.di.umldi.UMLLabelStyle <em>UML Label Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UML Label Style</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLLabelStyle
     * @generated
     */
    EClass getUMLLabelStyle();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.uml2.di.umldi.UMLLabelStyle#getFont <em>Font</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Font</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLLabelStyle#getFont()
     * @see #getUMLLabelStyle()
     * @generated
     */
    EReference getUMLLabelStyle_Font();

    /**
     * Returns the meta object for class '{@link org.eclipse.uml2.di.umldi.UMLPlane <em>UML Plane</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UML Plane</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLPlane
     * @generated
     */
    EClass getUMLPlane();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.uml2.di.umldi.UMLPlane#getUmlElement <em>Uml Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Uml Element</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLPlane#getUmlElement()
     * @see #getUMLPlane()
     * @generated
     */
    EReference getUMLPlane_UmlElement();

    /**
     * Returns the meta object for class '{@link org.eclipse.uml2.di.umldi.UMLShape <em>UML Shape</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UML Shape</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLShape
     * @generated
     */
    EClass getUMLShape();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.uml2.di.umldi.UMLShape#getUmlLabel <em>Uml Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Uml Label</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLShape#getUmlLabel()
     * @see #getUMLShape()
     * @generated
     */
    EReference getUMLShape_UmlLabel();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.uml2.di.umldi.UMLShape#getUmlElement <em>Uml Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Uml Element</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLShape#getUmlElement()
     * @see #getUMLShape()
     * @generated
     */
    EReference getUMLShape_UmlElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.uml2.di.umldi.UMLShape#isIsExpanded <em>Is Expanded</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Expanded</em>'.
     * @see org.eclipse.uml2.di.umldi.UMLShape#isIsExpanded()
     * @see #getUMLShape()
     * @generated
     */
    EAttribute getUMLShape_IsExpanded();

    /**
     * Returns the meta object for class '{@link org.eclipse.uml2.di.umldi.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.eclipse.uml2.di.umldi.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.uml2.di.umldi.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.eclipse.uml2.di.umldi.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed();

    /**
     * Returns the meta object for the map '{@link org.eclipse.uml2.di.umldi.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.eclipse.uml2.di.umldi.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap();

    /**
     * Returns the meta object for the map '{@link org.eclipse.uml2.di.umldi.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.eclipse.uml2.di.umldi.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.di.umldi.DocumentRoot#getPackages <em>Packages</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Packages</em>'.
     * @see org.eclipse.uml2.di.umldi.DocumentRoot#getPackages()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Packages();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.uml2.di.umldi.DocumentRoot#getDiagram <em>Diagram</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Diagram</em>'.
     * @see org.eclipse.uml2.di.umldi.DocumentRoot#getDiagram()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Diagram();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    UMLDIFactory getUMLDIFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.uml2.di.umldi.impl.UMLDiagramImpl <em>UML Diagram</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.uml2.di.umldi.impl.UMLDiagramImpl
         * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLDiagram()
         * @generated
         */
        EClass UML_DIAGRAM = eINSTANCE.getUMLDiagram();

        /**
         * The meta object literal for the '<em><b>Uml Plane</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_DIAGRAM__UML_PLANE = eINSTANCE.getUMLDiagram_UmlPlane();

        /**
         * The meta object literal for the '<em><b>Label Style</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_DIAGRAM__LABEL_STYLE = eINSTANCE.getUMLDiagram_LabelStyle();

        /**
         * The meta object literal for the '{@link org.eclipse.uml2.di.umldi.impl.UMLEdgeImpl <em>UML Edge</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.uml2.di.umldi.impl.UMLEdgeImpl
         * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLEdge()
         * @generated
         */
        EClass UML_EDGE = eINSTANCE.getUMLEdge();

        /**
         * The meta object literal for the '<em><b>Uml Label</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_EDGE__UML_LABEL = eINSTANCE.getUMLEdge_UmlLabel();

        /**
         * The meta object literal for the '<em><b>Uml Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_EDGE__UML_ELEMENT = eINSTANCE.getUMLEdge_UmlElement();

        /**
         * The meta object literal for the '<em><b>Source Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_EDGE__SOURCE_ELEMENT = eINSTANCE.getUMLEdge_SourceElement();

        /**
         * The meta object literal for the '<em><b>Target Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_EDGE__TARGET_ELEMENT = eINSTANCE.getUMLEdge_TargetElement();

        /**
         * The meta object literal for the '{@link org.eclipse.uml2.di.umldi.impl.UMLLabelImpl <em>UML Label</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.uml2.di.umldi.impl.UMLLabelImpl
         * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLLabel()
         * @generated
         */
        EClass UML_LABEL = eINSTANCE.getUMLLabel();

        /**
         * The meta object literal for the '<em><b>Label Style</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_LABEL__LABEL_STYLE = eINSTANCE.getUMLLabel_LabelStyle();

        /**
         * The meta object literal for the '{@link org.eclipse.uml2.di.umldi.impl.UMLLabelStyleImpl <em>UML Label Style</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.uml2.di.umldi.impl.UMLLabelStyleImpl
         * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLLabelStyle()
         * @generated
         */
        EClass UML_LABEL_STYLE = eINSTANCE.getUMLLabelStyle();

        /**
         * The meta object literal for the '<em><b>Font</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_LABEL_STYLE__FONT = eINSTANCE.getUMLLabelStyle_Font();

        /**
         * The meta object literal for the '{@link org.eclipse.uml2.di.umldi.impl.UMLPlaneImpl <em>UML Plane</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.uml2.di.umldi.impl.UMLPlaneImpl
         * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLPlane()
         * @generated
         */
        EClass UML_PLANE = eINSTANCE.getUMLPlane();

        /**
         * The meta object literal for the '<em><b>Uml Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_PLANE__UML_ELEMENT = eINSTANCE.getUMLPlane_UmlElement();

        /**
         * The meta object literal for the '{@link org.eclipse.uml2.di.umldi.impl.UMLShapeImpl <em>UML Shape</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.uml2.di.umldi.impl.UMLShapeImpl
         * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getUMLShape()
         * @generated
         */
        EClass UML_SHAPE = eINSTANCE.getUMLShape();

        /**
         * The meta object literal for the '<em><b>Uml Label</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_SHAPE__UML_LABEL = eINSTANCE.getUMLShape_UmlLabel();

        /**
         * The meta object literal for the '<em><b>Uml Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UML_SHAPE__UML_ELEMENT = eINSTANCE.getUMLShape_UmlElement();

        /**
         * The meta object literal for the '<em><b>Is Expanded</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UML_SHAPE__IS_EXPANDED = eINSTANCE.getUMLShape_IsExpanded();

        /**
         * The meta object literal for the '{@link org.eclipse.uml2.di.umldi.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.uml2.di.umldi.impl.DocumentRootImpl
         * @see org.eclipse.uml2.di.umldi.impl.UMLDIPackageImpl#getDocumentRoot()
         * @generated
         */
        EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

        /**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

        /**
         * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

        /**
         * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

        /**
         * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__PACKAGES = eINSTANCE.getDocumentRoot_Packages();

        /**
         * The meta object literal for the '<em><b>Diagram</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__DIAGRAM = eINSTANCE.getDocumentRoot_Diagram();

    }

} //UMLDIPackage
