/**
 */
package org.eclipse.cmmndi.impl;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.impl.Cmmn1PackageImpl;
import org.eclipse.cmmndi.CMMNDiagram;
import org.eclipse.cmmndi.CMMNEdge;
import org.eclipse.cmmndi.CMMNLabel;
import org.eclipse.cmmndi.CMMNLabelStyle;
import org.eclipse.cmmndi.CMMNPlane;
import org.eclipse.cmmndi.CMMNShape;
import org.eclipse.cmmndi.CmmnDiFactory;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.cmmndi.DocumentRoot;
import org.eclipse.dd.cmmn.dc.DcPackage;
import org.eclipse.dd.cmmn.dc.impl.DcPackageImpl;
import org.eclipse.dd.cmmn.di.DiPackage;
import org.eclipse.dd.cmmn.di.impl.DiPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CmmnDiPackageImpl extends EPackageImpl implements CmmnDiPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cmmnDiagramEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cmmnEdgeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cmmnLabelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cmmnLabelStyleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cmmnPlaneEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cmmnShapeEClass = null;

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
     * @see org.eclipse.cmmndi.CmmnDiPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CmmnDiPackageImpl() {
        super(eNS_URI, CmmnDiFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link CmmnDiPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CmmnDiPackage init() {
        if (isInited) return (CmmnDiPackage)EPackage.Registry.INSTANCE.getEPackage(CmmnDiPackage.eNS_URI);

        // Obtain or create and register package
        CmmnDiPackageImpl theCmmnDiPackage = (CmmnDiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CmmnDiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CmmnDiPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        Cmmn1PackageImpl theCmmn1Package = (Cmmn1PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Cmmn1Package.eNS_URI) instanceof Cmmn1PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Cmmn1Package.eNS_URI) : Cmmn1Package.eINSTANCE);
        DcPackageImpl theDcPackage = (DcPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) instanceof DcPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) : DcPackage.eINSTANCE);
        DiPackageImpl theDiPackage = (DiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) instanceof DiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) : DiPackage.eINSTANCE);

        // Create package meta-data objects
        theCmmnDiPackage.createPackageContents();
        theCmmn1Package.createPackageContents();
        theDcPackage.createPackageContents();
        theDiPackage.createPackageContents();

        // Initialize created meta-data
        theCmmnDiPackage.initializePackageContents();
        theCmmn1Package.initializePackageContents();
        theDcPackage.initializePackageContents();
        theDiPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCmmnDiPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CmmnDiPackage.eNS_URI, theCmmnDiPackage);
        return theCmmnDiPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCMMNDiagram() {
        return cmmnDiagramEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNDiagram_CMMNPlane() {
        return (EReference)cmmnDiagramEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNDiagram_CMMNLabelStyle() {
        return (EReference)cmmnDiagramEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCMMNEdge() {
        return cmmnEdgeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNEdge_CMMNLabel() {
        return (EReference)cmmnEdgeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNEdge_CmmnElement() {
        return (EReference)cmmnEdgeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNEdge_SourceElement() {
        return (EReference)cmmnEdgeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNEdge_TargetElement() {
        return (EReference)cmmnEdgeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCMMNLabel() {
        return cmmnLabelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNLabel_LabelStyle() {
        return (EReference)cmmnLabelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCMMNLabelStyle() {
        return cmmnLabelStyleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNLabelStyle_Font() {
        return (EReference)cmmnLabelStyleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCMMNPlane() {
        return cmmnPlaneEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNPlane_CmmnElement() {
        return (EReference)cmmnPlaneEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCMMNShape() {
        return cmmnShapeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNShape_CMMNLabel() {
        return (EReference)cmmnShapeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNShape_CmmnElement() {
        return (EReference)cmmnShapeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCMMNShape_IsExpanded() {
        return (EAttribute)cmmnShapeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCMMNShape_IsHorizontal() {
        return (EAttribute)cmmnShapeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCMMNShape_IsMarkerVisible() {
        return (EAttribute)cmmnShapeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCMMNShape_ChildShapes() {
        return (EReference)cmmnShapeEClass.getEStructuralFeatures().get(5);
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
    public EReference getDocumentRoot_CMMNDiagram() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CMMNEdge() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CMMNLabel() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CMMNLabelStyle() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CMMNPlane() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CMMNShape() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CmmnDiFactory getCmmnDiFactory() {
        return (CmmnDiFactory)getEFactoryInstance();
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
        cmmnDiagramEClass = createEClass(CMMN_DIAGRAM);
        createEReference(cmmnDiagramEClass, CMMN_DIAGRAM__CMMN_PLANE);
        createEReference(cmmnDiagramEClass, CMMN_DIAGRAM__CMMN_LABEL_STYLE);

        cmmnEdgeEClass = createEClass(CMMN_EDGE);
        createEReference(cmmnEdgeEClass, CMMN_EDGE__CMMN_LABEL);
        createEReference(cmmnEdgeEClass, CMMN_EDGE__CMMN_ELEMENT);
        createEReference(cmmnEdgeEClass, CMMN_EDGE__SOURCE_ELEMENT);
        createEReference(cmmnEdgeEClass, CMMN_EDGE__TARGET_ELEMENT);

        cmmnLabelEClass = createEClass(CMMN_LABEL);
        createEReference(cmmnLabelEClass, CMMN_LABEL__LABEL_STYLE);

        cmmnLabelStyleEClass = createEClass(CMMN_LABEL_STYLE);
        createEReference(cmmnLabelStyleEClass, CMMN_LABEL_STYLE__FONT);

        cmmnPlaneEClass = createEClass(CMMN_PLANE);
        createEReference(cmmnPlaneEClass, CMMN_PLANE__CMMN_ELEMENT);

        cmmnShapeEClass = createEClass(CMMN_SHAPE);
        createEReference(cmmnShapeEClass, CMMN_SHAPE__CMMN_LABEL);
        createEReference(cmmnShapeEClass, CMMN_SHAPE__CMMN_ELEMENT);
        createEAttribute(cmmnShapeEClass, CMMN_SHAPE__IS_EXPANDED);
        createEAttribute(cmmnShapeEClass, CMMN_SHAPE__IS_HORIZONTAL);
        createEAttribute(cmmnShapeEClass, CMMN_SHAPE__IS_MARKER_VISIBLE);
        createEReference(cmmnShapeEClass, CMMN_SHAPE__CHILD_SHAPES);

        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CMMN_DIAGRAM);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CMMN_EDGE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CMMN_LABEL);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CMMN_LABEL_STYLE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CMMN_PLANE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CMMN_SHAPE);
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
        Cmmn1Package theCmmn1Package = (Cmmn1Package)EPackage.Registry.INSTANCE.getEPackage(Cmmn1Package.eNS_URI);
        DcPackage theDcPackage = (DcPackage)EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI);
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        cmmnDiagramEClass.getESuperTypes().add(theDiPackage.getDiagram());
        cmmnEdgeEClass.getESuperTypes().add(theDiPackage.getLabeledEdge());
        cmmnLabelEClass.getESuperTypes().add(theDiPackage.getLabel());
        cmmnLabelStyleEClass.getESuperTypes().add(theDiPackage.getStyle());
        cmmnPlaneEClass.getESuperTypes().add(theDiPackage.getPlane());
        cmmnShapeEClass.getESuperTypes().add(theDiPackage.getLabeledShape());

        // Initialize classes, features, and operations; add parameters
        initEClass(cmmnDiagramEClass, CMMNDiagram.class, "CMMNDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCMMNDiagram_CMMNPlane(), this.getCMMNPlane(), null, "cMMNPlane", null, 1, 1, CMMNDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCMMNDiagram_CMMNLabelStyle(), this.getCMMNLabelStyle(), null, "cMMNLabelStyle", null, 0, -1, CMMNDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(cmmnEdgeEClass, CMMNEdge.class, "CMMNEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCMMNEdge_CMMNLabel(), this.getCMMNLabel(), null, "cMMNLabel", null, 0, 1, CMMNEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCMMNEdge_CmmnElement(), theCmmn1Package.getTCmmnElement(), null, "cmmnElement", null, 0, 1, CMMNEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCMMNEdge_SourceElement(), theDiPackage.getDiagramElement(), null, "sourceElement", null, 0, 1, CMMNEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCMMNEdge_TargetElement(), theDiPackage.getDiagramElement(), null, "targetElement", null, 0, 1, CMMNEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(cmmnLabelEClass, CMMNLabel.class, "CMMNLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCMMNLabel_LabelStyle(), this.getCMMNLabelStyle(), null, "labelStyle", null, 0, 1, CMMNLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(cmmnLabelStyleEClass, CMMNLabelStyle.class, "CMMNLabelStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCMMNLabelStyle_Font(), theDcPackage.getFont(), null, "font", null, 1, 1, CMMNLabelStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(cmmnPlaneEClass, CMMNPlane.class, "CMMNPlane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCMMNPlane_CmmnElement(), theCmmn1Package.getTDefinitions(), null, "cmmnElement", null, 0, 1, CMMNPlane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(cmmnShapeEClass, CMMNShape.class, "CMMNShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCMMNShape_CMMNLabel(), this.getCMMNLabel(), null, "cMMNLabel", null, 0, 1, CMMNShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCMMNShape_CmmnElement(), theCmmn1Package.getTCmmnElement(), null, "cmmnElement", null, 0, 1, CMMNShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCMMNShape_IsExpanded(), theXMLTypePackage.getBoolean(), "isExpanded", null, 0, 1, CMMNShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCMMNShape_IsHorizontal(), theXMLTypePackage.getBoolean(), "isHorizontal", null, 0, 1, CMMNShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCMMNShape_IsMarkerVisible(), theXMLTypePackage.getBoolean(), "isMarkerVisible", null, 0, 1, CMMNShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCMMNShape_ChildShapes(), theDiPackage.getDiagramElement(), null, "childShapes", null, 0, -1, CMMNShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CMMNDiagram(), this.getCMMNDiagram(), null, "cMMNDiagram", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CMMNEdge(), this.getCMMNEdge(), null, "cMMNEdge", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CMMNLabel(), this.getCMMNLabel(), null, "cMMNLabel", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CMMNLabelStyle(), this.getCMMNLabelStyle(), null, "cMMNLabelStyle", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CMMNPlane(), this.getCMMNPlane(), null, "cMMNPlane", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CMMNShape(), this.getCMMNShape(), null, "cMMNShape", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

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
          (cmmnDiagramEClass, 
           source, 
           new String[] {
             "name", "CMMNDiagram",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getCMMNDiagram_CMMNPlane(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNPlane",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getCMMNDiagram_CMMNLabelStyle(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNLabelStyle",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (cmmnEdgeEClass, 
           source, 
           new String[] {
             "name", "CMMNEdge",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getCMMNEdge_CMMNLabel(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNLabel",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getCMMNEdge_CmmnElement(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "CMMNElement"
           });	
        addAnnotation
          (getCMMNEdge_SourceElement(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sourceElement"
           });	
        addAnnotation
          (getCMMNEdge_TargetElement(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "targetElement"
           });	
        addAnnotation
          (cmmnLabelEClass, 
           source, 
           new String[] {
             "name", "CMMNLabel",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getCMMNLabel_LabelStyle(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "labelStyle"
           });	
        addAnnotation
          (cmmnLabelStyleEClass, 
           source, 
           new String[] {
             "name", "CMMNLabelStyle",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getCMMNLabelStyle_Font(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "Font",
             "namespace", "http://www.omg.org/spec/DD/20150101/DC"
           });	
        addAnnotation
          (cmmnPlaneEClass, 
           source, 
           new String[] {
             "name", "CMMNPlane",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getCMMNPlane_CmmnElement(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "CMMNElement"
           });	
        addAnnotation
          (cmmnShapeEClass, 
           source, 
           new String[] {
             "name", "CMMNShape",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getCMMNShape_CMMNLabel(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNLabel",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getCMMNShape_CmmnElement(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "CMMNElement"
           });	
        addAnnotation
          (getCMMNShape_IsExpanded(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "isExpanded"
           });	
        addAnnotation
          (getCMMNShape_IsHorizontal(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "isHorizontal"
           });	
        addAnnotation
          (getCMMNShape_IsMarkerVisible(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "isMarkerVisible"
           });	
        addAnnotation
          (documentRootEClass, 
           source, 
           new String[] {
             "name", "",
             "kind", "mixed"
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
        addAnnotation
          (getDocumentRoot_CMMNDiagram(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNDiagram",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CMMNEdge(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNEdge",
             "namespace", "##targetNamespace",
             "affiliation", "http://www.omg.org/spec/DD/20150101/DI#DiagramElement"
           });	
        addAnnotation
          (getDocumentRoot_CMMNLabel(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNLabel",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CMMNLabelStyle(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNLabelStyle",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CMMNPlane(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNPlane",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CMMNShape(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNShape",
             "namespace", "##targetNamespace",
             "affiliation", "http://www.omg.org/spec/DD/20150101/DI#DiagramElement"
           });
    }

} //CmmnDiPackageImpl
