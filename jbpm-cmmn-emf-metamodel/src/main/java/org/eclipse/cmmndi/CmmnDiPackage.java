/**
 */
package org.eclipse.cmmndi;

import org.eclipse.dd.cmmn.di.DiPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.cmmndi.CmmnDiFactory
 * @model kind="package"
 * @generated
 */
public interface CmmnDiPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "cmmndi";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.omg.org/spec/CMMN/20131201/DI";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "cmmndi";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CmmnDiPackage eINSTANCE = org.eclipse.cmmndi.impl.CmmnDiPackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.impl.CMMNDiagramImpl <em>CMMN Diagram</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.impl.CMMNDiagramImpl
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNDiagram()
     * @generated
     */
    int CMMN_DIAGRAM = 0;

    /**
     * The feature id for the '<em><b>Documentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM__DOCUMENTATION = DiPackage.DIAGRAM__DOCUMENTATION;

    /**
     * The feature id for the '<em><b>Owned Style</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM__OWNED_STYLE = DiPackage.DIAGRAM__OWNED_STYLE;

    /**
     * The feature id for the '<em><b>Root Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM__ROOT_ELEMENT = DiPackage.DIAGRAM__ROOT_ELEMENT;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM__ID = DiPackage.DIAGRAM__ID;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM__NAME = DiPackage.DIAGRAM__NAME;

    /**
     * The feature id for the '<em><b>Resolution</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM__RESOLUTION = DiPackage.DIAGRAM__RESOLUTION;

    /**
     * The feature id for the '<em><b>Plane</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM__PLANE = DiPackage.DIAGRAM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Label Style</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM__LABEL_STYLE = DiPackage.DIAGRAM_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>CMMN Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM_FEATURE_COUNT = DiPackage.DIAGRAM_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>CMMN Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_DIAGRAM_OPERATION_COUNT = DiPackage.DIAGRAM_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_DIAGRAM_OPERATION_COUNT = DiPackage.DIAGRAM_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_DIAGRAM_OPERATION_COUNT = DiPackage.DIAGRAM_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Diagram</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_DIAGRAM_OPERATION_COUNT = DiPackage.DIAGRAM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl <em>CMMN Edge</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.impl.CMMNEdgeImpl
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNEdge()
     * @generated
     */
    int CMMN_EDGE = 1;

    /**
     * The feature id for the '<em><b>Owning Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__OWNING_DIAGRAM = DiPackage.LABELED_EDGE__OWNING_DIAGRAM;

    /**
     * The feature id for the '<em><b>Owning Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__OWNING_ELEMENT = DiPackage.LABELED_EDGE__OWNING_ELEMENT;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__OWNED_ELEMENT = DiPackage.LABELED_EDGE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__MODEL_ELEMENT = DiPackage.LABELED_EDGE__MODEL_ELEMENT;

    /**
     * The feature id for the '<em><b>Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__STYLE = DiPackage.LABELED_EDGE__STYLE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__ID = DiPackage.LABELED_EDGE__ID;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__SOURCE = DiPackage.LABELED_EDGE__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__TARGET = DiPackage.LABELED_EDGE__TARGET;

    /**
     * The feature id for the '<em><b>Waypoint</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__WAYPOINT = DiPackage.LABELED_EDGE__WAYPOINT;

    /**
     * The feature id for the '<em><b>Owned Label</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__OWNED_LABEL = DiPackage.LABELED_EDGE__OWNED_LABEL;

    /**
     * The feature id for the '<em><b>Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__LABEL = DiPackage.LABELED_EDGE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Cmmn Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__CMMN_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Message Visible Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__MESSAGE_VISIBLE_KIND = DiPackage.LABELED_EDGE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Source Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__SOURCE_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Target Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE__TARGET_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>CMMN Edge</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE_FEATURE_COUNT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 5;

    /**
     * The number of operations of the '<em>CMMN Edge</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_EDGE_OPERATION_COUNT = DiPackage.LABELED_EDGE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Edge</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_EDGE_OPERATION_COUNT = DiPackage.LABELED_EDGE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Edge</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_EDGE_OPERATION_COUNT = DiPackage.LABELED_EDGE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Edge</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_EDGE_OPERATION_COUNT = DiPackage.LABELED_EDGE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.impl.CMMNLabelImpl <em>CMMN Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.impl.CMMNLabelImpl
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNLabel()
     * @generated
     */
    int CMMN_LABEL = 2;

    /**
     * The feature id for the '<em><b>Owning Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL__OWNING_DIAGRAM = DiPackage.LABEL__OWNING_DIAGRAM;

    /**
     * The feature id for the '<em><b>Owning Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL__OWNING_ELEMENT = DiPackage.LABEL__OWNING_ELEMENT;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL__OWNED_ELEMENT = DiPackage.LABEL__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL__MODEL_ELEMENT = DiPackage.LABEL__MODEL_ELEMENT;

    /**
     * The feature id for the '<em><b>Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL__STYLE = DiPackage.LABEL__STYLE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL__ID = DiPackage.LABEL__ID;

    /**
     * The feature id for the '<em><b>Bounds</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL__BOUNDS = DiPackage.LABEL__BOUNDS;

    /**
     * The feature id for the '<em><b>Label Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL__LABEL_STYLE = DiPackage.LABEL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>CMMN Label</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL_FEATURE_COUNT = DiPackage.LABEL_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>CMMN Label</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL_OPERATION_COUNT = DiPackage.LABEL_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Label</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_LABEL_OPERATION_COUNT = DiPackage.LABEL_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Label</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_LABEL_OPERATION_COUNT = DiPackage.LABEL_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Label</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_LABEL_OPERATION_COUNT = DiPackage.LABEL_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.impl.CMMNLabelStyleImpl <em>CMMN Label Style</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.impl.CMMNLabelStyleImpl
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNLabelStyle()
     * @generated
     */
    int CMMN_LABEL_STYLE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL_STYLE__ID = DiPackage.STYLE__ID;

    /**
     * The feature id for the '<em><b>Font</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL_STYLE__FONT = DiPackage.STYLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>CMMN Label Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL_STYLE_FEATURE_COUNT = DiPackage.STYLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>CMMN Label Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_LABEL_STYLE_OPERATION_COUNT = DiPackage.STYLE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Label Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_LABEL_STYLE_OPERATION_COUNT = DiPackage.STYLE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Label Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_LABEL_STYLE_OPERATION_COUNT = DiPackage.STYLE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Label Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_LABEL_STYLE_OPERATION_COUNT = DiPackage.STYLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.impl.CMMNPlaneImpl <em>CMMN Plane</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.impl.CMMNPlaneImpl
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNPlane()
     * @generated
     */
    int CMMN_PLANE = 4;

    /**
     * The feature id for the '<em><b>Owning Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE__OWNING_DIAGRAM = DiPackage.PLANE__OWNING_DIAGRAM;

    /**
     * The feature id for the '<em><b>Owning Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE__OWNING_ELEMENT = DiPackage.PLANE__OWNING_ELEMENT;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE__OWNED_ELEMENT = DiPackage.PLANE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE__MODEL_ELEMENT = DiPackage.PLANE__MODEL_ELEMENT;

    /**
     * The feature id for the '<em><b>Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE__STYLE = DiPackage.PLANE__STYLE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE__ID = DiPackage.PLANE__ID;

    /**
     * The feature id for the '<em><b>Plane Element</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE__PLANE_ELEMENT = DiPackage.PLANE__PLANE_ELEMENT;

    /**
     * The feature id for the '<em><b>Cmmn Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE__CMMN_ELEMENT = DiPackage.PLANE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>CMMN Plane</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE_FEATURE_COUNT = DiPackage.PLANE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Plane element type</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = DiPackage.PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP;

    /**
     * The number of operations of the '<em>CMMN Plane</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_PLANE_OPERATION_COUNT = DiPackage.PLANE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Plane element type</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = DiPackage.PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP;

    /**
     * The number of operations of the '<em>CMMN Plane</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_PLANE_OPERATION_COUNT = DiPackage.PLANE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Plane element type</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = DiPackage.PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP;

    /**
     * The number of operations of the '<em>CMMN Plane</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_PLANE_OPERATION_COUNT = DiPackage.PLANE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Plane element type</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP = DiPackage.PLANE___PLANE_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP;

    /**
     * The number of operations of the '<em>CMMN Plane</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_PLANE_OPERATION_COUNT = DiPackage.PLANE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.impl.CMMNShapeImpl <em>CMMN Shape</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.impl.CMMNShapeImpl
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNShape()
     * @generated
     */
    int CMMN_SHAPE = 5;

    /**
     * The feature id for the '<em><b>Owning Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__OWNING_DIAGRAM = DiPackage.LABELED_SHAPE__OWNING_DIAGRAM;

    /**
     * The feature id for the '<em><b>Owning Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__OWNING_ELEMENT = DiPackage.LABELED_SHAPE__OWNING_ELEMENT;

    /**
     * The feature id for the '<em><b>Owned Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__OWNED_ELEMENT = DiPackage.LABELED_SHAPE__OWNED_ELEMENT;

    /**
     * The feature id for the '<em><b>Model Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__MODEL_ELEMENT = DiPackage.LABELED_SHAPE__MODEL_ELEMENT;

    /**
     * The feature id for the '<em><b>Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__STYLE = DiPackage.LABELED_SHAPE__STYLE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__ID = DiPackage.LABELED_SHAPE__ID;

    /**
     * The feature id for the '<em><b>Bounds</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__BOUNDS = DiPackage.LABELED_SHAPE__BOUNDS;

    /**
     * The feature id for the '<em><b>Owned Label</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__OWNED_LABEL = DiPackage.LABELED_SHAPE__OWNED_LABEL;

    /**
     * The feature id for the '<em><b>CMMN Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__CMMN_LABEL = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Choreography Activity Shape</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Cmmn Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__CMMN_ELEMENT = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Is Expanded</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__IS_EXPANDED = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Is Horizontal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__IS_HORIZONTAL = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Is Marker Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__IS_MARKER_VISIBLE = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Is Message Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__IS_MESSAGE_VISIBLE = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Participant Band Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE__PARTICIPANT_BAND_KIND = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>CMMN Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE_FEATURE_COUNT = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 8;

    /**
     * The number of operations of the '<em>CMMN Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CMMN_SHAPE_OPERATION_COUNT = DiPackage.LABELED_SHAPE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_SHAPE_OPERATION_COUNT = DiPackage.LABELED_SHAPE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_SHAPE_OPERATION_COUNT = DiPackage.LABELED_SHAPE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>CMMN Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
//    int CMMN_SHAPE_OPERATION_COUNT = DiPackage.LABELED_SHAPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.impl.DocumentRootImpl
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getDocumentRoot()
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
     * The feature id for the '<em><b>CMMN Diagram</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CMMN_DIAGRAM = 3;

    /**
     * The feature id for the '<em><b>CMMN Edge</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CMMN_EDGE = 4;

    /**
     * The feature id for the '<em><b>CMMN Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CMMN_LABEL = 5;

    /**
     * The feature id for the '<em><b>CMMN Label Style</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CMMN_LABEL_STYLE = 6;

    /**
     * The feature id for the '<em><b>CMMN Plane</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CMMN_PLANE = 7;

    /**
     * The feature id for the '<em><b>CMMN Shape</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CMMN_SHAPE = 8;

    /**
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_FEATURE_COUNT = 9;

    /**
     * The number of operations of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.MessageVisibleKind <em>Message Visible Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.MessageVisibleKind
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getMessageVisibleKind()
     * @generated
     */
    int MESSAGE_VISIBLE_KIND = 7;

    /**
     * The meta object id for the '{@link org.eclipse.cmmndi.ParticipantBandKind <em>Participant Band Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.ParticipantBandKind
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getParticipantBandKind()
     * @generated
     */
    int PARTICIPANT_BAND_KIND = 8;

    /**
     * The meta object id for the '<em>Message Visible Kind Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.MessageVisibleKind
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getMessageVisibleKindObject()
     * @generated
     */
    int MESSAGE_VISIBLE_KIND_OBJECT = 9;

    /**
     * The meta object id for the '<em>Participant Band Kind Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.cmmndi.ParticipantBandKind
     * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getParticipantBandKindObject()
     * @generated
     */
    int PARTICIPANT_BAND_KIND_OBJECT = 10;


    /**
     * Returns the meta object for class '{@link org.eclipse.cmmndi.CMMNDiagram <em>CMMN Diagram</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>CMMN Diagram</em>'.
     * @see org.eclipse.cmmndi.CMMNDiagram
     * @generated
     */
    EClass getCMMNDiagram();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.CMMNDiagram#getPlane <em>Plane</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Plane</em>'.
     * @see org.eclipse.cmmndi.CMMNDiagram#getPlane()
     * @see #getCMMNDiagram()
     * @generated
     */
    EReference getCMMNDiagram_Plane();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.cmmndi.CMMNDiagram#getLabelStyle <em>Label Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Label Style</em>'.
     * @see org.eclipse.cmmndi.CMMNDiagram#getLabelStyle()
     * @see #getCMMNDiagram()
     * @generated
     */
    EReference getCMMNDiagram_LabelStyle();

    /**
     * Returns the meta object for class '{@link org.eclipse.cmmndi.CMMNEdge <em>CMMN Edge</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>CMMN Edge</em>'.
     * @see org.eclipse.cmmndi.CMMNEdge
     * @generated
     */
    EClass getCMMNEdge();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.CMMNEdge#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Label</em>'.
     * @see org.eclipse.cmmndi.CMMNEdge#getLabel()
     * @see #getCMMNEdge()
     * @generated
     */
    EReference getCMMNEdge_Label();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.cmmndi.CMMNEdge#getCmmnElement <em>Cmmn Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Cmmn Element</em>'.
     * @see org.eclipse.cmmndi.CMMNEdge#getCmmnElement()
     * @see #getCMMNEdge()
     * @generated
     */
    EReference getCMMNEdge_CmmnElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.cmmndi.CMMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Message Visible Kind</em>'.
     * @see org.eclipse.cmmndi.CMMNEdge#getMessageVisibleKind()
     * @see #getCMMNEdge()
     * @generated
     */
    EAttribute getCMMNEdge_MessageVisibleKind();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.cmmndi.CMMNEdge#getSourceElement <em>Source Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source Element</em>'.
     * @see org.eclipse.cmmndi.CMMNEdge#getSourceElement()
     * @see #getCMMNEdge()
     * @generated
     */
    EReference getCMMNEdge_SourceElement();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.cmmndi.CMMNEdge#getTargetElement <em>Target Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target Element</em>'.
     * @see org.eclipse.cmmndi.CMMNEdge#getTargetElement()
     * @see #getCMMNEdge()
     * @generated
     */
    EReference getCMMNEdge_TargetElement();

    /**
     * Returns the meta object for class '{@link org.eclipse.cmmndi.CMMNLabel <em>CMMN Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>CMMN Label</em>'.
     * @see org.eclipse.cmmndi.CMMNLabel
     * @generated
     */
    EClass getCMMNLabel();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.cmmndi.CMMNLabel#getLabelStyle <em>Label Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Label Style</em>'.
     * @see org.eclipse.cmmndi.CMMNLabel#getLabelStyle()
     * @see #getCMMNLabel()
     * @generated
     */
    EReference getCMMNLabel_LabelStyle();

    /**
     * Returns the meta object for class '{@link org.eclipse.cmmndi.CMMNLabelStyle <em>CMMN Label Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>CMMN Label Style</em>'.
     * @see org.eclipse.cmmndi.CMMNLabelStyle
     * @generated
     */
    EClass getCMMNLabelStyle();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.CMMNLabelStyle#getFont <em>Font</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Font</em>'.
     * @see org.eclipse.cmmndi.CMMNLabelStyle#getFont()
     * @see #getCMMNLabelStyle()
     * @generated
     */
    EReference getCMMNLabelStyle_Font();

    /**
     * Returns the meta object for class '{@link org.eclipse.cmmndi.CMMNPlane <em>CMMN Plane</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>CMMN Plane</em>'.
     * @see org.eclipse.cmmndi.CMMNPlane
     * @generated
     */
    EClass getCMMNPlane();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.cmmndi.CMMNPlane#getCmmnElement <em>Cmmn Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Cmmn Element</em>'.
     * @see org.eclipse.cmmndi.CMMNPlane#getCmmnElement()
     * @see #getCMMNPlane()
     * @generated
     */
    EReference getCMMNPlane_CmmnElement();

    /**
     * Returns the meta object for class '{@link org.eclipse.cmmndi.CMMNShape <em>CMMN Shape</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>CMMN Shape</em>'.
     * @see org.eclipse.cmmndi.CMMNShape
     * @generated
     */
    EClass getCMMNShape();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.CMMNShape#getCMMNLabel <em>CMMN Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>CMMN Label</em>'.
     * @see org.eclipse.cmmndi.CMMNShape#getCMMNLabel()
     * @see #getCMMNShape()
     * @generated
     */
    EReference getCMMNShape_CMMNLabel();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.cmmndi.CMMNShape#getChoreographyActivityShape <em>Choreography Activity Shape</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Choreography Activity Shape</em>'.
     * @see org.eclipse.cmmndi.CMMNShape#getChoreographyActivityShape()
     * @see #getCMMNShape()
     * @generated
     */
    EAttribute getCMMNShape_ChoreographyActivityShape();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.cmmndi.CMMNShape#getCmmnElement <em>Cmmn Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Cmmn Element</em>'.
     * @see org.eclipse.cmmndi.CMMNShape#getCmmnElement()
     * @see #getCMMNShape()
     * @generated
     */
    EReference getCMMNShape_CmmnElement();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.cmmndi.CMMNShape#isIsExpanded <em>Is Expanded</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Expanded</em>'.
     * @see org.eclipse.cmmndi.CMMNShape#isIsExpanded()
     * @see #getCMMNShape()
     * @generated
     */
    EAttribute getCMMNShape_IsExpanded();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.cmmndi.CMMNShape#isIsHorizontal <em>Is Horizontal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Horizontal</em>'.
     * @see org.eclipse.cmmndi.CMMNShape#isIsHorizontal()
     * @see #getCMMNShape()
     * @generated
     */
    EAttribute getCMMNShape_IsHorizontal();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.cmmndi.CMMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Marker Visible</em>'.
     * @see org.eclipse.cmmndi.CMMNShape#isIsMarkerVisible()
     * @see #getCMMNShape()
     * @generated
     */
    EAttribute getCMMNShape_IsMarkerVisible();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.cmmndi.CMMNShape#isIsMessageVisible <em>Is Message Visible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Message Visible</em>'.
     * @see org.eclipse.cmmndi.CMMNShape#isIsMessageVisible()
     * @see #getCMMNShape()
     * @generated
     */
    EAttribute getCMMNShape_IsMessageVisible();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.cmmndi.CMMNShape#getParticipantBandKind <em>Participant Band Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Participant Band Kind</em>'.
     * @see org.eclipse.cmmndi.CMMNShape#getParticipantBandKind()
     * @see #getCMMNShape()
     * @generated
     */
    EAttribute getCMMNShape_ParticipantBandKind();

    /**
     * Returns the meta object for class '{@link org.eclipse.cmmndi.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.cmmndi.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed();

    /**
     * Returns the meta object for the map '{@link org.eclipse.cmmndi.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap();

    /**
     * Returns the meta object for the map '{@link org.eclipse.cmmndi.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNDiagram <em>CMMN Diagram</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>CMMN Diagram</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getCMMNDiagram()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_CMMNDiagram();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNEdge <em>CMMN Edge</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>CMMN Edge</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getCMMNEdge()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_CMMNEdge();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNLabel <em>CMMN Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>CMMN Label</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getCMMNLabel()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_CMMNLabel();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNLabelStyle <em>CMMN Label Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>CMMN Label Style</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getCMMNLabelStyle()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_CMMNLabelStyle();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNPlane <em>CMMN Plane</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>CMMN Plane</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getCMMNPlane()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_CMMNPlane();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNShape <em>CMMN Shape</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>CMMN Shape</em>'.
     * @see org.eclipse.cmmndi.DocumentRoot#getCMMNShape()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_CMMNShape();

    /**
     * Returns the meta object for enum '{@link org.eclipse.cmmndi.MessageVisibleKind <em>Message Visible Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Message Visible Kind</em>'.
     * @see org.eclipse.cmmndi.MessageVisibleKind
     * @generated
     */
    EEnum getMessageVisibleKind();

    /**
     * Returns the meta object for enum '{@link org.eclipse.cmmndi.ParticipantBandKind <em>Participant Band Kind</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Participant Band Kind</em>'.
     * @see org.eclipse.cmmndi.ParticipantBandKind
     * @generated
     */
    EEnum getParticipantBandKind();

    /**
     * Returns the meta object for data type '{@link org.eclipse.cmmndi.MessageVisibleKind <em>Message Visible Kind Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Message Visible Kind Object</em>'.
     * @see org.eclipse.cmmndi.MessageVisibleKind
     * @model instanceClass="org.eclipse.cmmndi.MessageVisibleKind"
     *        extendedMetaData="name='MessageVisibleKind:Object' baseType='MessageVisibleKind'"
     * @generated
     */
    EDataType getMessageVisibleKindObject();

    /**
     * Returns the meta object for data type '{@link org.eclipse.cmmndi.ParticipantBandKind <em>Participant Band Kind Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Participant Band Kind Object</em>'.
     * @see org.eclipse.cmmndi.ParticipantBandKind
     * @model instanceClass="org.eclipse.cmmndi.ParticipantBandKind"
     *        extendedMetaData="name='ParticipantBandKind:Object' baseType='ParticipantBandKind'"
     * @generated
     */
    EDataType getParticipantBandKindObject();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CmmnDiFactory getCmmnDiFactory();

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
         * The meta object literal for the '{@link org.eclipse.cmmndi.impl.CMMNDiagramImpl <em>CMMN Diagram</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.impl.CMMNDiagramImpl
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNDiagram()
         * @generated
         */
        EClass CMMN_DIAGRAM = eINSTANCE.getCMMNDiagram();

        /**
         * The meta object literal for the '<em><b>Plane</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_DIAGRAM__PLANE = eINSTANCE.getCMMNDiagram_Plane();

        /**
         * The meta object literal for the '<em><b>Label Style</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_DIAGRAM__LABEL_STYLE = eINSTANCE.getCMMNDiagram_LabelStyle();

        /**
         * The meta object literal for the '{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl <em>CMMN Edge</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.impl.CMMNEdgeImpl
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNEdge()
         * @generated
         */
        EClass CMMN_EDGE = eINSTANCE.getCMMNEdge();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_EDGE__LABEL = eINSTANCE.getCMMNEdge_Label();

        /**
         * The meta object literal for the '<em><b>Cmmn Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_EDGE__CMMN_ELEMENT = eINSTANCE.getCMMNEdge_CmmnElement();

        /**
         * The meta object literal for the '<em><b>Message Visible Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CMMN_EDGE__MESSAGE_VISIBLE_KIND = eINSTANCE.getCMMNEdge_MessageVisibleKind();

        /**
         * The meta object literal for the '<em><b>Source Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_EDGE__SOURCE_ELEMENT = eINSTANCE.getCMMNEdge_SourceElement();

        /**
         * The meta object literal for the '<em><b>Target Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_EDGE__TARGET_ELEMENT = eINSTANCE.getCMMNEdge_TargetElement();

        /**
         * The meta object literal for the '{@link org.eclipse.cmmndi.impl.CMMNLabelImpl <em>CMMN Label</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.impl.CMMNLabelImpl
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNLabel()
         * @generated
         */
        EClass CMMN_LABEL = eINSTANCE.getCMMNLabel();

        /**
         * The meta object literal for the '<em><b>Label Style</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_LABEL__LABEL_STYLE = eINSTANCE.getCMMNLabel_LabelStyle();

        /**
         * The meta object literal for the '{@link org.eclipse.cmmndi.impl.CMMNLabelStyleImpl <em>CMMN Label Style</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.impl.CMMNLabelStyleImpl
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNLabelStyle()
         * @generated
         */
        EClass CMMN_LABEL_STYLE = eINSTANCE.getCMMNLabelStyle();

        /**
         * The meta object literal for the '<em><b>Font</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_LABEL_STYLE__FONT = eINSTANCE.getCMMNLabelStyle_Font();

        /**
         * The meta object literal for the '{@link org.eclipse.cmmndi.impl.CMMNPlaneImpl <em>CMMN Plane</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.impl.CMMNPlaneImpl
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNPlane()
         * @generated
         */
        EClass CMMN_PLANE = eINSTANCE.getCMMNPlane();

        /**
         * The meta object literal for the '<em><b>Cmmn Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_PLANE__CMMN_ELEMENT = eINSTANCE.getCMMNPlane_CmmnElement();

        /**
         * The meta object literal for the '{@link org.eclipse.cmmndi.impl.CMMNShapeImpl <em>CMMN Shape</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.impl.CMMNShapeImpl
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getCMMNShape()
         * @generated
         */
        EClass CMMN_SHAPE = eINSTANCE.getCMMNShape();

        /**
         * The meta object literal for the '<em><b>CMMN Label</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_SHAPE__CMMN_LABEL = eINSTANCE.getCMMNShape_CMMNLabel();

        /**
         * The meta object literal for the '<em><b>Choreography Activity Shape</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CMMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE = eINSTANCE.getCMMNShape_ChoreographyActivityShape();

        /**
         * The meta object literal for the '<em><b>Cmmn Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CMMN_SHAPE__CMMN_ELEMENT = eINSTANCE.getCMMNShape_CmmnElement();

        /**
         * The meta object literal for the '<em><b>Is Expanded</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CMMN_SHAPE__IS_EXPANDED = eINSTANCE.getCMMNShape_IsExpanded();

        /**
         * The meta object literal for the '<em><b>Is Horizontal</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CMMN_SHAPE__IS_HORIZONTAL = eINSTANCE.getCMMNShape_IsHorizontal();

        /**
         * The meta object literal for the '<em><b>Is Marker Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CMMN_SHAPE__IS_MARKER_VISIBLE = eINSTANCE.getCMMNShape_IsMarkerVisible();

        /**
         * The meta object literal for the '<em><b>Is Message Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CMMN_SHAPE__IS_MESSAGE_VISIBLE = eINSTANCE.getCMMNShape_IsMessageVisible();

        /**
         * The meta object literal for the '<em><b>Participant Band Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CMMN_SHAPE__PARTICIPANT_BAND_KIND = eINSTANCE.getCMMNShape_ParticipantBandKind();

        /**
         * The meta object literal for the '{@link org.eclipse.cmmndi.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.impl.DocumentRootImpl
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getDocumentRoot()
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
         * The meta object literal for the '<em><b>CMMN Diagram</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__CMMN_DIAGRAM = eINSTANCE.getDocumentRoot_CMMNDiagram();

        /**
         * The meta object literal for the '<em><b>CMMN Edge</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__CMMN_EDGE = eINSTANCE.getDocumentRoot_CMMNEdge();

        /**
         * The meta object literal for the '<em><b>CMMN Label</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__CMMN_LABEL = eINSTANCE.getDocumentRoot_CMMNLabel();

        /**
         * The meta object literal for the '<em><b>CMMN Label Style</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__CMMN_LABEL_STYLE = eINSTANCE.getDocumentRoot_CMMNLabelStyle();

        /**
         * The meta object literal for the '<em><b>CMMN Plane</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__CMMN_PLANE = eINSTANCE.getDocumentRoot_CMMNPlane();

        /**
         * The meta object literal for the '<em><b>CMMN Shape</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__CMMN_SHAPE = eINSTANCE.getDocumentRoot_CMMNShape();

        /**
         * The meta object literal for the '{@link org.eclipse.cmmndi.MessageVisibleKind <em>Message Visible Kind</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.MessageVisibleKind
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getMessageVisibleKind()
         * @generated
         */
        EEnum MESSAGE_VISIBLE_KIND = eINSTANCE.getMessageVisibleKind();

        /**
         * The meta object literal for the '{@link org.eclipse.cmmndi.ParticipantBandKind <em>Participant Band Kind</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.ParticipantBandKind
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getParticipantBandKind()
         * @generated
         */
        EEnum PARTICIPANT_BAND_KIND = eINSTANCE.getParticipantBandKind();

        /**
         * The meta object literal for the '<em>Message Visible Kind Object</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.MessageVisibleKind
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getMessageVisibleKindObject()
         * @generated
         */
        EDataType MESSAGE_VISIBLE_KIND_OBJECT = eINSTANCE.getMessageVisibleKindObject();

        /**
         * The meta object literal for the '<em>Participant Band Kind Object</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.cmmndi.ParticipantBandKind
         * @see org.eclipse.cmmndi.impl.CmmnDiPackageImpl#getParticipantBandKindObject()
         * @generated
         */
        EDataType PARTICIPANT_BAND_KIND_OBJECT = eINSTANCE.getParticipantBandKindObject();

    }

} //CmmnDiPackage
