/**
 */
package org.eclipse.uml2.di.umldi.impl;

import org.eclipse.dd.cmmn.dc.DcPackage;
import org.eclipse.dd.cmmn.di.DiPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.uml2.di.umldi.DocumentRoot;
import org.eclipse.uml2.di.umldi.UMLDIFactory;
import org.eclipse.uml2.di.umldi.UMLDIPackage;
import org.eclipse.uml2.di.umldi.UMLDiagram;
import org.eclipse.uml2.di.umldi.UMLEdge;
import org.eclipse.uml2.di.umldi.UMLLabel;
import org.eclipse.uml2.di.umldi.UMLLabelStyle;
import org.eclipse.uml2.di.umldi.UMLPlane;
import org.eclipse.uml2.di.umldi.UMLShape;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.impl.UMLPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLDIPackageImpl extends EPackageImpl implements UMLDIPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass umlDiagramEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass umlEdgeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass umlLabelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass umlLabelStyleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass umlPlaneEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass umlShapeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentRootEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.uml2.di.umldi.UMLDIPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private UMLDIPackageImpl() {
        super(eNS_URI, UMLDIFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>This method is used to initialize {@link UMLDIPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static UMLDIPackage init() {
        if (isInited) return (UMLDIPackage)EPackage.Registry.INSTANCE.getEPackage(UMLDIPackage.eNS_URI);

        // Obtain or create and register package
        UMLDIPackageImpl theUMLDIPackage = (UMLDIPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UMLDIPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UMLDIPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        DcPackage.eINSTANCE.eClass();
        DiPackage.eINSTANCE.eClass();
        UMLPackage.eINSTANCE.eClass();
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theUMLDIPackage.createPackageContents();

        // Initialize created meta-data
        theUMLDIPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theUMLDIPackage.freeze();


        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(UMLDIPackage.eNS_URI, theUMLDIPackage);
        return theUMLDIPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUMLDiagram() {
        return umlDiagramEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLDiagram_UmlPlane() {
        return (EReference)umlDiagramEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLDiagram_LabelStyle() {
        return (EReference)umlDiagramEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUMLEdge() {
        return umlEdgeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLEdge_UmlLabel() {
        return (EReference)umlEdgeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLEdge_UmlElement() {
        return (EReference)umlEdgeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLEdge_SourceElement() {
        return (EReference)umlEdgeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLEdge_TargetElement() {
        return (EReference)umlEdgeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUMLLabel() {
        return umlLabelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLLabel_LabelStyle() {
        return (EReference)umlLabelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUMLLabelStyle() {
        return umlLabelStyleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLLabelStyle_Font() {
        return (EReference)umlLabelStyleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUMLPlane() {
        return umlPlaneEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLPlane_UmlElement() {
        return (EReference)umlPlaneEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUMLShape() {
        return umlShapeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLShape_UmlLabel() {
        return (EReference)umlShapeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUMLShape_UmlElement() {
        return (EReference)umlShapeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUMLShape_IsExpanded() {
        return (EAttribute)umlShapeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDocumentRoot() {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Packages() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Diagram() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLDIFactory getUMLDIFactory() {
        return (UMLDIFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        umlDiagramEClass = createEClass(UML_DIAGRAM);
        createEReference(umlDiagramEClass, UML_DIAGRAM__UML_PLANE);
        createEReference(umlDiagramEClass, UML_DIAGRAM__LABEL_STYLE);

        umlEdgeEClass = createEClass(UML_EDGE);
        createEReference(umlEdgeEClass, UML_EDGE__UML_LABEL);
        createEReference(umlEdgeEClass, UML_EDGE__UML_ELEMENT);
        createEReference(umlEdgeEClass, UML_EDGE__SOURCE_ELEMENT);
        createEReference(umlEdgeEClass, UML_EDGE__TARGET_ELEMENT);

        umlLabelEClass = createEClass(UML_LABEL);
        createEReference(umlLabelEClass, UML_LABEL__LABEL_STYLE);

        umlLabelStyleEClass = createEClass(UML_LABEL_STYLE);
        createEReference(umlLabelStyleEClass, UML_LABEL_STYLE__FONT);

        umlPlaneEClass = createEClass(UML_PLANE);
        createEReference(umlPlaneEClass, UML_PLANE__UML_ELEMENT);

        umlShapeEClass = createEClass(UML_SHAPE);
        createEReference(umlShapeEClass, UML_SHAPE__UML_LABEL);
        createEReference(umlShapeEClass, UML_SHAPE__UML_ELEMENT);
        createEAttribute(umlShapeEClass, UML_SHAPE__IS_EXPANDED);

        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PACKAGES);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DIAGRAM);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        DiPackage theDiPackage = (DiPackage)EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI);
        UMLPackage theUMLPackage = UMLPackageImpl.init();
        DcPackage theDcPackage = (DcPackage)EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI);
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        umlDiagramEClass.getESuperTypes().add(theDiPackage.getDiagram());
        umlEdgeEClass.getESuperTypes().add(theDiPackage.getLabeledEdge());
        umlLabelEClass.getESuperTypes().add(theDiPackage.getLabel());
        umlLabelStyleEClass.getESuperTypes().add(theDiPackage.getStyle());
        umlPlaneEClass.getESuperTypes().add(theDiPackage.getPlane());
        umlShapeEClass.getESuperTypes().add(theDiPackage.getLabeledShape());

        // Initialize classes, features, and operations; add parameters
        initEClass(umlDiagramEClass, UMLDiagram.class, "UMLDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUMLDiagram_UmlPlane(), this.getUMLPlane(), null, "umlPlane", null, 1, 1, UMLDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUMLDiagram_LabelStyle(), this.getUMLLabelStyle(), null, "labelStyle", null, 0, -1, UMLDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(umlEdgeEClass, UMLEdge.class, "UMLEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUMLEdge_UmlLabel(), this.getUMLLabel(), null, "umlLabel", null, 0, 1, UMLEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUMLEdge_UmlElement(), theUMLPackage.getElement(), null, "umlElement", null, 0, 1, UMLEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUMLEdge_SourceElement(), theDiPackage.getDiagramElement(), null, "sourceElement", null, 0, 1, UMLEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUMLEdge_TargetElement(), theDiPackage.getDiagramElement(), null, "targetElement", null, 0, 1, UMLEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(umlLabelEClass, UMLLabel.class, "UMLLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUMLLabel_LabelStyle(), this.getUMLLabelStyle(), null, "labelStyle", null, 0, 1, UMLLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(umlLabelStyleEClass, UMLLabelStyle.class, "UMLLabelStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUMLLabelStyle_Font(), theDcPackage.getFont(), null, "font", null, 1, 1, UMLLabelStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(umlPlaneEClass, UMLPlane.class, "UMLPlane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUMLPlane_UmlElement(), theUMLPackage.getElement(), null, "umlElement", null, 0, 1, UMLPlane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(umlShapeEClass, UMLShape.class, "UMLShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUMLShape_UmlLabel(), this.getUMLLabel(), null, "umlLabel", null, 0, 1, UMLShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUMLShape_UmlElement(), theUMLPackage.getElement(), null, "umlElement", null, 0, 1, UMLShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUMLShape_IsExpanded(), theXMLTypePackage.getBoolean(), "isExpanded", null, 0, 1, UMLShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, DocumentRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, DocumentRoot.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, DocumentRoot.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Packages(), theUMLPackage.getPackage(), null, "packages", null, 0, -1, DocumentRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Diagram(), this.getUMLDiagram(), null, "diagram", null, 0, -1, DocumentRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
        addAnnotation
          (umlDiagramEClass,
           source,
           new String[] {
             "name", "UMLDiagram",
             "kind", "elementOnly"
           });
        addAnnotation
          (getUMLDiagram_UmlPlane(),
           source,
           new String[] {
             "kind", "element",
             "name", "UMLPlane",
             "namespace", "##targetNamespace"
           });
        addAnnotation
          (getUMLDiagram_LabelStyle(),
           source,
           new String[] {
             "kind", "element",
             "name", "UMLLabelStyle",
             "namespace", "##targetNamespace"
           });
        addAnnotation
          (umlEdgeEClass,
           source,
           new String[] {
             "name", "UMLEdge",
             "kind", "elementOnly"
           });
        addAnnotation
          (getUMLEdge_UmlLabel(),
           source,
           new String[] {
             "kind", "element",
             "name", "UMLLabel",
             "namespace", "##targetNamespace"
           });
        addAnnotation
          (getUMLEdge_UmlElement(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "UMLElement"
           });
        addAnnotation
          (getUMLEdge_SourceElement(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "sourceElement"
           });
        addAnnotation
          (getUMLEdge_TargetElement(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "targetElement"
           });
        addAnnotation
          (umlLabelEClass,
           source,
           new String[] {
             "name", "UMLLabel",
             "kind", "elementOnly"
           });
        addAnnotation
          (getUMLLabel_LabelStyle(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "labelStyle"
           });
        addAnnotation
          (umlLabelStyleEClass,
           source,
           new String[] {
             "name", "UMLLabelStyle",
             "kind", "elementOnly"
           });
        addAnnotation
          (getUMLLabelStyle_Font(),
           source,
           new String[] {
             "kind", "element",
             "name", "Font",
             "namespace", "http://www.omg.org/spec/DD/20150101/DC"
           });
        addAnnotation
          (umlPlaneEClass,
           source,
           new String[] {
             "name", "UMLPlane",
             "kind", "elementOnly"
           });
        addAnnotation
          (getUMLPlane_UmlElement(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "UMLElement"
           });
        addAnnotation
          (umlShapeEClass,
           source,
           new String[] {
             "name", "UMLShape",
             "kind", "elementOnly"
           });
        addAnnotation
          (getUMLShape_UmlLabel(),
           source,
           new String[] {
             "kind", "element",
             "name", "UMLLabel",
             "namespace", "##targetNamespace"
           });
        addAnnotation
          (getUMLShape_UmlElement(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "UMLElement"
           });
        addAnnotation
          (getUMLShape_IsExpanded(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "isExpanded"
           });
        addAnnotation
          (documentRootEClass,
           source,
           new String[] {
             "name", "umlDocument",
             "kind", "elementOnly"
           });
        addAnnotation
          (getDocumentRoot_Mixed(),
           source,
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });
        addAnnotation
          (getDocumentRoot_XMLNSPrefixMap(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "xmlns:prefix"
           });
        addAnnotation
          (getDocumentRoot_XSISchemaLocation(),
           source,
           new String[] {
             "kind", "attribute",
             "name", "xsi:schemaLocation"
           });
    }

} //UMLDIPackageImpl
