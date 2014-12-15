/**
 */
package org.eclipse.cmmn1.impl;

import org.eclipse.cmmn1.CaseFileItemTransition;
import org.eclipse.cmmn1.Cmmn1Factory;
import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.DefinitionTypeEnumMember1;
import org.eclipse.cmmn1.DocumentRoot;
import org.eclipse.cmmn1.MultiplicityEnum;
import org.eclipse.cmmn1.PlanItemTransition;
import org.eclipse.cmmn1.ProcessTypeEnumMember1;
import org.eclipse.cmmn1.TApplicabilityRule;
import org.eclipse.cmmn1.TCase;
import org.eclipse.cmmn1.TCaseFile;
import org.eclipse.cmmn1.TCaseFileItem;
import org.eclipse.cmmn1.TCaseFileItemDefinition;
import org.eclipse.cmmn1.TCaseFileItemOnPart;
import org.eclipse.cmmn1.TCaseFileItemStartTrigger;
import org.eclipse.cmmn1.TCaseParameter;
import org.eclipse.cmmn1.TCaseTask;
import org.eclipse.cmmn1.TChildren;
import org.eclipse.cmmn1.TCmmnElement;
import org.eclipse.cmmn1.TCmmnElementWithMixedContent;
import org.eclipse.cmmn1.TDefinitions;
import org.eclipse.cmmn1.TDiscretionaryItem;
import org.eclipse.cmmn1.TEvent;
import org.eclipse.cmmn1.TExpression;
import org.eclipse.cmmn1.THumanTask;
import org.eclipse.cmmn1.TIfPart;
import org.eclipse.cmmn1.TImport;
import org.eclipse.cmmn1.TManualActivationRule;
import org.eclipse.cmmn1.TMilestone;
import org.eclipse.cmmn1.TOnPart;
import org.eclipse.cmmn1.TParameter;
import org.eclipse.cmmn1.TParameterMapping;
import org.eclipse.cmmn1.TPlanFragment;
import org.eclipse.cmmn1.TPlanItem;
import org.eclipse.cmmn1.TPlanItemControl;
import org.eclipse.cmmn1.TPlanItemDefinition;
import org.eclipse.cmmn1.TPlanItemOnPart;
import org.eclipse.cmmn1.TPlanItemStartTrigger;
import org.eclipse.cmmn1.TPlanningTable;
import org.eclipse.cmmn1.TProcess;
import org.eclipse.cmmn1.TProcessParameter;
import org.eclipse.cmmn1.TProcessTask;
import org.eclipse.cmmn1.TProperty;
import org.eclipse.cmmn1.TRepetitionRule;
import org.eclipse.cmmn1.TRequiredRule;
import org.eclipse.cmmn1.TRole;
import org.eclipse.cmmn1.TSentry;
import org.eclipse.cmmn1.TStage;
import org.eclipse.cmmn1.TStartTrigger;
import org.eclipse.cmmn1.TTableItem;
import org.eclipse.cmmn1.TTask;
import org.eclipse.cmmn1.TTimerEvent;
import org.eclipse.cmmn1.TUserEvent;
import org.eclipse.cmmn1.util.Cmmn1Validator;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.cmmndi.impl.CmmnDiPackageImpl;
import org.eclipse.dd.cmmn.dc.DcPackage;
import org.eclipse.dd.cmmn.dc.impl.DcPackageImpl;
import org.eclipse.dd.cmmn.di.DiPackage;
import org.eclipse.dd.cmmn.di.impl.DiPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Cmmn1PackageImpl extends EPackageImpl implements Cmmn1Package {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tApplicabilityRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCaseEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCaseFileEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCaseFileItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCaseFileItemDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCaseFileItemOnPartEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCaseFileItemStartTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCaseParameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCaseTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tChildrenEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCmmnElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tCmmnElementWithMixedContentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tDefinitionsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tDiscretionaryItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tExpressionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tHumanTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tIfPartEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tManualActivationRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tMilestoneEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tOnPartEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tParameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tParameterMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tPlanFragmentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tPlanItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tPlanItemControlEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tPlanItemDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tPlanItemOnPartEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tPlanItemStartTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tPlanningTableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tProcessEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tProcessParameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tProcessTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tRepetitionRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tRequiredRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tRoleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tSentryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tStageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tStartTriggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tTableItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tTaskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tTimerEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tUserEventEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum caseFileItemTransitionEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum definitionTypeEnumMember1EEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum multiplicityEnumEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum planItemTransitionEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum processTypeEnumMember1EEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType caseFileItemTransitionObjectEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType definitionTypeEnumEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType definitionTypeEnumMember1ObjectEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType multiplicityEnumObjectEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType planItemTransitionObjectEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType processTypeEnumEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType processTypeEnumMember1ObjectEDataType = null;

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
     * @see org.eclipse.cmmn1.Cmmn1Package#eNS_URI
     * @see #init()
     * @generated
     */
    private Cmmn1PackageImpl() {
        super(eNS_URI, Cmmn1Factory.eINSTANCE);
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
     * <p>This method is used to initialize {@link Cmmn1Package#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static Cmmn1Package init() {
        if (isInited) return (Cmmn1Package)EPackage.Registry.INSTANCE.getEPackage(Cmmn1Package.eNS_URI);

        // Obtain or create and register package
        Cmmn1PackageImpl theCmmn1Package = (Cmmn1PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Cmmn1PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Cmmn1PackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        DcPackageImpl theDcPackage = (DcPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) instanceof DcPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) : DcPackage.eINSTANCE);
        CmmnDiPackageImpl theCmmnDiPackage = (CmmnDiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CmmnDiPackage.eNS_URI) instanceof CmmnDiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CmmnDiPackage.eNS_URI) : CmmnDiPackage.eINSTANCE);
        DiPackageImpl theDiPackage = (DiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) instanceof DiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) : DiPackage.eINSTANCE);

        // Create package meta-data objects
        theCmmn1Package.createPackageContents();
        theDcPackage.createPackageContents();
        theCmmnDiPackage.createPackageContents();
        theDiPackage.createPackageContents();

        // Initialize created meta-data
        theCmmn1Package.initializePackageContents();
        theDcPackage.initializePackageContents();
        theCmmnDiPackage.initializePackageContents();
        theDiPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put
            (theCmmn1Package, 
             new EValidator.Descriptor() {
                 public EValidator getEValidator() {
                     return Cmmn1Validator.INSTANCE;
                 }
             });

        // Mark meta-data to indicate it can't be changed
        theCmmn1Package.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(Cmmn1Package.eNS_URI, theCmmn1Package);
        return theCmmn1Package;
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
    public EReference getDocumentRoot_ApplicabilityRule() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Case() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CaseFile() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CaseFileItem() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CaseFileItemDefinition() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CaseFileItemOnPart() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_OnPart() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CaseFileItemStartTrigger() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_TimerStart() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CaseParameter() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Parameter() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_CaseTask() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Task() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_PlanItemDefinition() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Definitions() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_DiscretionaryItem() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_TableItem() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Event() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Expression() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_HumanTask() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_IfPart() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Import() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(24);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_ManualActivationRule() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(25);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Milestone() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(26);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_ParameterMapping() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(27);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_PlanFragment() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(28);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_PlanItem() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(29);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_PlanItemControl() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(30);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_PlanItemOnPart() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(31);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_PlanItemStartTrigger() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(32);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_PlanningTable() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(33);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Process() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(34);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_ProcessParameter() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(35);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_ProcessTask() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(36);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Property() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(37);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_RepetitionRule() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(38);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_RequiredRule() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(39);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Role() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(40);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Sentry() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(41);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Stage() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(42);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_TimerEvent() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(43);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_UserEvent() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(44);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTApplicabilityRule() {
        return tApplicabilityRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTApplicabilityRule_Condition() {
        return (EReference)tApplicabilityRuleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTApplicabilityRule_ContextRef() {
        return (EReference)tApplicabilityRuleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCase() {
        return tCaseEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCase_CaseFileModel() {
        return (EReference)tCaseEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCase_CasePlanModel() {
        return (EReference)tCaseEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCase_CaseRoles() {
        return (EReference)tCaseEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCase_Input() {
        return (EReference)tCaseEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCase_Output() {
        return (EReference)tCaseEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCase_Name() {
        return (EAttribute)tCaseEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCaseFile() {
        return tCaseFileEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseFile_CaseFileItem() {
        return (EReference)tCaseFileEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCaseFileItem() {
        return tCaseFileItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseFileItem_Children() {
        return (EReference)tCaseFileItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseFileItem_DefinitionRef() {
        return (EReference)tCaseFileItemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCaseFileItem_Multiplicity() {
        return (EAttribute)tCaseFileItemEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCaseFileItem_Name() {
        return (EAttribute)tCaseFileItemEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseFileItem_SourceRef() {
        return (EReference)tCaseFileItemEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseFileItem_TargetRefs() {
        return (EReference)tCaseFileItemEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCaseFileItemDefinition() {
        return tCaseFileItemDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseFileItemDefinition_Property() {
        return (EReference)tCaseFileItemDefinitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCaseFileItemDefinition_DefinitionType() {
        return (EAttribute)tCaseFileItemDefinitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCaseFileItemDefinition_ImportRef() {
        return (EAttribute)tCaseFileItemDefinitionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCaseFileItemDefinition_Name() {
        return (EAttribute)tCaseFileItemDefinitionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCaseFileItemDefinition_StructureRef() {
        return (EAttribute)tCaseFileItemDefinitionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCaseFileItemOnPart() {
        return tCaseFileItemOnPartEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCaseFileItemOnPart_StandardEvent() {
        return (EAttribute)tCaseFileItemOnPartEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseFileItemOnPart_SourceRef() {
        return (EReference)tCaseFileItemOnPartEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCaseFileItemStartTrigger() {
        return tCaseFileItemStartTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCaseFileItemStartTrigger_StandardEvent() {
        return (EAttribute)tCaseFileItemStartTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseFileItemStartTrigger_SourceRef() {
        return (EReference)tCaseFileItemStartTriggerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCaseParameter() {
        return tCaseParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseParameter_BindingRefinement() {
        return (EReference)tCaseParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseParameter_BindingRef() {
        return (EReference)tCaseParameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCaseTask() {
        return tCaseTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseTask_ParameterMapping() {
        return (EReference)tCaseTaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTCaseTask_CaseRef() {
        return (EReference)tCaseTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTChildren() {
        return tChildrenEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTChildren_CaseFileItem() {
        return (EReference)tChildrenEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCmmnElement() {
        return tCmmnElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCmmnElement_Description() {
        return (EAttribute)tCmmnElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCmmnElement_Id() {
        return (EAttribute)tCmmnElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCmmnElement_AnyAttribute() {
        return (EAttribute)tCmmnElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTCmmnElementWithMixedContent() {
        return tCmmnElementWithMixedContentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCmmnElementWithMixedContent_Mixed() {
        return (EAttribute)tCmmnElementWithMixedContentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCmmnElementWithMixedContent_Description() {
        return (EAttribute)tCmmnElementWithMixedContentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCmmnElementWithMixedContent_Id() {
        return (EAttribute)tCmmnElementWithMixedContentEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTCmmnElementWithMixedContent_AnyAttribute() {
        return (EAttribute)tCmmnElementWithMixedContentEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTDefinitions() {
        return tDefinitionsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDefinitions_Import() {
        return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDefinitions_CaseFileItemDefinition() {
        return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDefinitions_Case() {
        return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDefinitions_Process() {
        return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDefinitions_CMMNDiagram() {
        return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_Author() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_CreationDate() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_Exporter() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_ExporterVersion() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_ExpressionLanguage() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_Id() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_Name() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_TargetNamespace() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTDefinitions_AnyAttribute() {
        return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTDiscretionaryItem() {
        return tDiscretionaryItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDiscretionaryItem_ItemControl() {
        return (EReference)tDiscretionaryItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDiscretionaryItem_DefinitionRef() {
        return (EReference)tDiscretionaryItemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDiscretionaryItem_EntryCriteriaRefs() {
        return (EReference)tDiscretionaryItemEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTDiscretionaryItem_ExitCriteriaRefs() {
        return (EReference)tDiscretionaryItemEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTEvent() {
        return tEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTExpression() {
        return tExpressionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTExpression_Body() {
        return (EAttribute)tExpressionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTExpression_Language() {
        return (EAttribute)tExpressionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTHumanTask() {
        return tHumanTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTHumanTask_PlanningTable() {
        return (EReference)tHumanTaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTHumanTask_PerformerRef() {
        return (EReference)tHumanTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTIfPart() {
        return tIfPartEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTIfPart_Condition() {
        return (EReference)tIfPartEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTIfPart_ContextRef() {
        return (EReference)tIfPartEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTImport() {
        return tImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTImport_ImportType() {
        return (EAttribute)tImportEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTImport_Location() {
        return (EAttribute)tImportEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTImport_Namespace() {
        return (EAttribute)tImportEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTManualActivationRule() {
        return tManualActivationRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTManualActivationRule_Condition() {
        return (EReference)tManualActivationRuleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTManualActivationRule_ContextRef() {
        return (EReference)tManualActivationRuleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTManualActivationRule_Name() {
        return (EAttribute)tManualActivationRuleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTMilestone() {
        return tMilestoneEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTOnPart() {
        return tOnPartEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTParameter() {
        return tParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTParameter_Name() {
        return (EAttribute)tParameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTParameterMapping() {
        return tParameterMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTParameterMapping_Transformation() {
        return (EReference)tParameterMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTParameterMapping_SourceRef() {
        return (EReference)tParameterMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTParameterMapping_TargetRef() {
        return (EReference)tParameterMappingEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTPlanFragment() {
        return tPlanFragmentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanFragment_PlanItem() {
        return (EReference)tPlanFragmentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanFragment_Sentry() {
        return (EReference)tPlanFragmentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTPlanItem() {
        return tPlanItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItem_ItemControl() {
        return (EReference)tPlanItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItem_DefinitionRef() {
        return (EReference)tPlanItemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItem_EntryCriteriaRefs() {
        return (EReference)tPlanItemEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItem_ExitCriteriaRefs() {
        return (EReference)tPlanItemEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTPlanItem_Name() {
        return (EAttribute)tPlanItemEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTPlanItemControl() {
        return tPlanItemControlEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItemControl_RepetitionRule() {
        return (EReference)tPlanItemControlEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItemControl_RequiredRule() {
        return (EReference)tPlanItemControlEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItemControl_ManualActivationRule() {
        return (EReference)tPlanItemControlEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTPlanItemDefinition() {
        return tPlanItemDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItemDefinition_DefaultControl() {
        return (EReference)tPlanItemDefinitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTPlanItemDefinition_Name() {
        return (EAttribute)tPlanItemDefinitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTPlanItemOnPart() {
        return tPlanItemOnPartEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTPlanItemOnPart_StandardEvent() {
        return (EAttribute)tPlanItemOnPartEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItemOnPart_SentryRef() {
        return (EReference)tPlanItemOnPartEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItemOnPart_SourceRef() {
        return (EReference)tPlanItemOnPartEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTPlanItemStartTrigger() {
        return tPlanItemStartTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTPlanItemStartTrigger_StandardEvent() {
        return (EAttribute)tPlanItemStartTriggerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanItemStartTrigger_SourceRef() {
        return (EReference)tPlanItemStartTriggerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTPlanningTable() {
        return tPlanningTableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTPlanningTable_TableItemGroup() {
        return (EAttribute)tPlanningTableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanningTable_TableItem() {
        return (EReference)tPlanningTableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTPlanningTable_ApplicabilityRule() {
        return (EReference)tPlanningTableEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTProcess() {
        return tProcessEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTProcess_Input() {
        return (EReference)tProcessEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTProcess_Output() {
        return (EReference)tProcessEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTProcess_ImplementationType() {
        return (EAttribute)tProcessEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTProcess_Name() {
        return (EAttribute)tProcessEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTProcessParameter() {
        return tProcessParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTProcessTask() {
        return tProcessTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTProcessTask_ParameterMapping() {
        return (EReference)tProcessTaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTProcessTask_ProcessRef() {
        return (EReference)tProcessTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTProperty() {
        return tPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTProperty_Name() {
        return (EAttribute)tPropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTProperty_Type() {
        return (EAttribute)tPropertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTRepetitionRule() {
        return tRepetitionRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTRepetitionRule_Condition() {
        return (EReference)tRepetitionRuleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTRepetitionRule_ContextRef() {
        return (EReference)tRepetitionRuleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTRepetitionRule_Name() {
        return (EAttribute)tRepetitionRuleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTRequiredRule() {
        return tRequiredRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTRequiredRule_Condition() {
        return (EReference)tRequiredRuleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTRequiredRule_ContextRef() {
        return (EReference)tRequiredRuleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTRequiredRule_Name() {
        return (EAttribute)tRequiredRuleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTRole() {
        return tRoleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTRole_Name() {
        return (EAttribute)tRoleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTSentry() {
        return tSentryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTSentry_OnPartGroup() {
        return (EAttribute)tSentryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTSentry_OnPart() {
        return (EReference)tSentryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTSentry_IfPart() {
        return (EReference)tSentryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTSentry_Name() {
        return (EAttribute)tSentryEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTStage() {
        return tStageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTStage_PlanningTable() {
        return (EReference)tStageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTStage_PlanItemDefinitionGroup() {
        return (EAttribute)tStageEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTStage_PlanItemDefinition() {
        return (EReference)tStageEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTStage_AutoComplete() {
        return (EAttribute)tStageEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTStage_ExitCriteriaRefs() {
        return (EReference)tStageEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTStartTrigger() {
        return tStartTriggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTTableItem() {
        return tTableItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTTableItem_ApplicabilityRuleRefs() {
        return (EReference)tTableItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTTableItem_AuthorizedRoleRefs() {
        return (EReference)tTableItemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTTask() {
        return tTaskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTTask_Inputs() {
        return (EReference)tTaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTTask_Outputs() {
        return (EReference)tTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTTask_IsBlocking() {
        return (EAttribute)tTaskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTTimerEvent() {
        return tTimerEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTTimerEvent_TimerExpression() {
        return (EReference)tTimerEventEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTTimerEvent_TimerStartGroup() {
        return (EAttribute)tTimerEventEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTTimerEvent_TimerStart() {
        return (EReference)tTimerEventEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTUserEvent() {
        return tUserEventEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getCaseFileItemTransition() {
        return caseFileItemTransitionEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getDefinitionTypeEnumMember1() {
        return definitionTypeEnumMember1EEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getMultiplicityEnum() {
        return multiplicityEnumEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPlanItemTransition() {
        return planItemTransitionEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getProcessTypeEnumMember1() {
        return processTypeEnumMember1EEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getCaseFileItemTransitionObject() {
        return caseFileItemTransitionObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getDefinitionTypeEnum() {
        return definitionTypeEnumEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getDefinitionTypeEnumMember1Object() {
        return definitionTypeEnumMember1ObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getMultiplicityEnumObject() {
        return multiplicityEnumObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPlanItemTransitionObject() {
        return planItemTransitionObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getProcessTypeEnum() {
        return processTypeEnumEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getProcessTypeEnumMember1Object() {
        return processTypeEnumMember1ObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cmmn1Factory getCmmn1Factory() {
        return (Cmmn1Factory)getEFactoryInstance();
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
        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__APPLICABILITY_RULE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CASE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CASE_FILE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CASE_FILE_ITEM);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ON_PART);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__TIMER_START);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CASE_PARAMETER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PARAMETER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CASE_TASK);
        createEReference(documentRootEClass, DOCUMENT_ROOT__TASK);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PLAN_ITEM_DEFINITION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DEFINITIONS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DISCRETIONARY_ITEM);
        createEReference(documentRootEClass, DOCUMENT_ROOT__TABLE_ITEM);
        createEReference(documentRootEClass, DOCUMENT_ROOT__EVENT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__EXPRESSION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__HUMAN_TASK);
        createEReference(documentRootEClass, DOCUMENT_ROOT__IF_PART);
        createEReference(documentRootEClass, DOCUMENT_ROOT__IMPORT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MILESTONE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PARAMETER_MAPPING);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PLAN_FRAGMENT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PLAN_ITEM);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PLAN_ITEM_CONTROL);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PLAN_ITEM_ON_PART);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PLANNING_TABLE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROCESS);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROCESS_PARAMETER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROCESS_TASK);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__REPETITION_RULE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__REQUIRED_RULE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__ROLE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__SENTRY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__STAGE);
        createEReference(documentRootEClass, DOCUMENT_ROOT__TIMER_EVENT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__USER_EVENT);

        tApplicabilityRuleEClass = createEClass(TAPPLICABILITY_RULE);
        createEReference(tApplicabilityRuleEClass, TAPPLICABILITY_RULE__CONDITION);
        createEReference(tApplicabilityRuleEClass, TAPPLICABILITY_RULE__CONTEXT_REF);

        tCaseEClass = createEClass(TCASE);
        createEReference(tCaseEClass, TCASE__CASE_FILE_MODEL);
        createEReference(tCaseEClass, TCASE__CASE_PLAN_MODEL);
        createEReference(tCaseEClass, TCASE__CASE_ROLES);
        createEReference(tCaseEClass, TCASE__INPUT);
        createEReference(tCaseEClass, TCASE__OUTPUT);
        createEAttribute(tCaseEClass, TCASE__NAME);

        tCaseFileEClass = createEClass(TCASE_FILE);
        createEReference(tCaseFileEClass, TCASE_FILE__CASE_FILE_ITEM);

        tCaseFileItemEClass = createEClass(TCASE_FILE_ITEM);
        createEReference(tCaseFileItemEClass, TCASE_FILE_ITEM__CHILDREN);
        createEReference(tCaseFileItemEClass, TCASE_FILE_ITEM__DEFINITION_REF);
        createEAttribute(tCaseFileItemEClass, TCASE_FILE_ITEM__MULTIPLICITY);
        createEAttribute(tCaseFileItemEClass, TCASE_FILE_ITEM__NAME);
        createEReference(tCaseFileItemEClass, TCASE_FILE_ITEM__SOURCE_REF);
        createEReference(tCaseFileItemEClass, TCASE_FILE_ITEM__TARGET_REFS);

        tCaseFileItemDefinitionEClass = createEClass(TCASE_FILE_ITEM_DEFINITION);
        createEReference(tCaseFileItemDefinitionEClass, TCASE_FILE_ITEM_DEFINITION__PROPERTY);
        createEAttribute(tCaseFileItemDefinitionEClass, TCASE_FILE_ITEM_DEFINITION__DEFINITION_TYPE);
        createEAttribute(tCaseFileItemDefinitionEClass, TCASE_FILE_ITEM_DEFINITION__IMPORT_REF);
        createEAttribute(tCaseFileItemDefinitionEClass, TCASE_FILE_ITEM_DEFINITION__NAME);
        createEAttribute(tCaseFileItemDefinitionEClass, TCASE_FILE_ITEM_DEFINITION__STRUCTURE_REF);

        tCaseFileItemOnPartEClass = createEClass(TCASE_FILE_ITEM_ON_PART);
        createEAttribute(tCaseFileItemOnPartEClass, TCASE_FILE_ITEM_ON_PART__STANDARD_EVENT);
        createEReference(tCaseFileItemOnPartEClass, TCASE_FILE_ITEM_ON_PART__SOURCE_REF);

        tCaseFileItemStartTriggerEClass = createEClass(TCASE_FILE_ITEM_START_TRIGGER);
        createEAttribute(tCaseFileItemStartTriggerEClass, TCASE_FILE_ITEM_START_TRIGGER__STANDARD_EVENT);
        createEReference(tCaseFileItemStartTriggerEClass, TCASE_FILE_ITEM_START_TRIGGER__SOURCE_REF);

        tCaseParameterEClass = createEClass(TCASE_PARAMETER);
        createEReference(tCaseParameterEClass, TCASE_PARAMETER__BINDING_REFINEMENT);
        createEReference(tCaseParameterEClass, TCASE_PARAMETER__BINDING_REF);

        tCaseTaskEClass = createEClass(TCASE_TASK);
        createEReference(tCaseTaskEClass, TCASE_TASK__PARAMETER_MAPPING);
        createEReference(tCaseTaskEClass, TCASE_TASK__CASE_REF);

        tChildrenEClass = createEClass(TCHILDREN);
        createEReference(tChildrenEClass, TCHILDREN__CASE_FILE_ITEM);

        tCmmnElementEClass = createEClass(TCMMN_ELEMENT);
        createEAttribute(tCmmnElementEClass, TCMMN_ELEMENT__DESCRIPTION);
        createEAttribute(tCmmnElementEClass, TCMMN_ELEMENT__ID);
        createEAttribute(tCmmnElementEClass, TCMMN_ELEMENT__ANY_ATTRIBUTE);

        tCmmnElementWithMixedContentEClass = createEClass(TCMMN_ELEMENT_WITH_MIXED_CONTENT);
        createEAttribute(tCmmnElementWithMixedContentEClass, TCMMN_ELEMENT_WITH_MIXED_CONTENT__MIXED);
        createEAttribute(tCmmnElementWithMixedContentEClass, TCMMN_ELEMENT_WITH_MIXED_CONTENT__DESCRIPTION);
        createEAttribute(tCmmnElementWithMixedContentEClass, TCMMN_ELEMENT_WITH_MIXED_CONTENT__ID);
        createEAttribute(tCmmnElementWithMixedContentEClass, TCMMN_ELEMENT_WITH_MIXED_CONTENT__ANY_ATTRIBUTE);

        tDefinitionsEClass = createEClass(TDEFINITIONS);
        createEReference(tDefinitionsEClass, TDEFINITIONS__IMPORT);
        createEReference(tDefinitionsEClass, TDEFINITIONS__CASE_FILE_ITEM_DEFINITION);
        createEReference(tDefinitionsEClass, TDEFINITIONS__CASE);
        createEReference(tDefinitionsEClass, TDEFINITIONS__PROCESS);
        createEReference(tDefinitionsEClass, TDEFINITIONS__CMMN_DIAGRAM);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__AUTHOR);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__CREATION_DATE);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__EXPORTER);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__EXPORTER_VERSION);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__EXPRESSION_LANGUAGE);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__ID);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__NAME);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__TARGET_NAMESPACE);
        createEAttribute(tDefinitionsEClass, TDEFINITIONS__ANY_ATTRIBUTE);

        tDiscretionaryItemEClass = createEClass(TDISCRETIONARY_ITEM);
        createEReference(tDiscretionaryItemEClass, TDISCRETIONARY_ITEM__ITEM_CONTROL);
        createEReference(tDiscretionaryItemEClass, TDISCRETIONARY_ITEM__DEFINITION_REF);
        createEReference(tDiscretionaryItemEClass, TDISCRETIONARY_ITEM__ENTRY_CRITERIA_REFS);
        createEReference(tDiscretionaryItemEClass, TDISCRETIONARY_ITEM__EXIT_CRITERIA_REFS);

        tEventEClass = createEClass(TEVENT);

        tExpressionEClass = createEClass(TEXPRESSION);
        createEAttribute(tExpressionEClass, TEXPRESSION__BODY);
        createEAttribute(tExpressionEClass, TEXPRESSION__LANGUAGE);

        tHumanTaskEClass = createEClass(THUMAN_TASK);
        createEReference(tHumanTaskEClass, THUMAN_TASK__PLANNING_TABLE);
        createEReference(tHumanTaskEClass, THUMAN_TASK__PERFORMER_REF);

        tIfPartEClass = createEClass(TIF_PART);
        createEReference(tIfPartEClass, TIF_PART__CONDITION);
        createEReference(tIfPartEClass, TIF_PART__CONTEXT_REF);

        tImportEClass = createEClass(TIMPORT);
        createEAttribute(tImportEClass, TIMPORT__IMPORT_TYPE);
        createEAttribute(tImportEClass, TIMPORT__LOCATION);
        createEAttribute(tImportEClass, TIMPORT__NAMESPACE);

        tManualActivationRuleEClass = createEClass(TMANUAL_ACTIVATION_RULE);
        createEReference(tManualActivationRuleEClass, TMANUAL_ACTIVATION_RULE__CONDITION);
        createEReference(tManualActivationRuleEClass, TMANUAL_ACTIVATION_RULE__CONTEXT_REF);
        createEAttribute(tManualActivationRuleEClass, TMANUAL_ACTIVATION_RULE__NAME);

        tMilestoneEClass = createEClass(TMILESTONE);

        tOnPartEClass = createEClass(TON_PART);

        tParameterEClass = createEClass(TPARAMETER);
        createEAttribute(tParameterEClass, TPARAMETER__NAME);

        tParameterMappingEClass = createEClass(TPARAMETER_MAPPING);
        createEReference(tParameterMappingEClass, TPARAMETER_MAPPING__TRANSFORMATION);
        createEReference(tParameterMappingEClass, TPARAMETER_MAPPING__SOURCE_REF);
        createEReference(tParameterMappingEClass, TPARAMETER_MAPPING__TARGET_REF);

        tPlanFragmentEClass = createEClass(TPLAN_FRAGMENT);
        createEReference(tPlanFragmentEClass, TPLAN_FRAGMENT__PLAN_ITEM);
        createEReference(tPlanFragmentEClass, TPLAN_FRAGMENT__SENTRY);

        tPlanItemEClass = createEClass(TPLAN_ITEM);
        createEReference(tPlanItemEClass, TPLAN_ITEM__ITEM_CONTROL);
        createEReference(tPlanItemEClass, TPLAN_ITEM__DEFINITION_REF);
        createEReference(tPlanItemEClass, TPLAN_ITEM__ENTRY_CRITERIA_REFS);
        createEReference(tPlanItemEClass, TPLAN_ITEM__EXIT_CRITERIA_REFS);
        createEAttribute(tPlanItemEClass, TPLAN_ITEM__NAME);

        tPlanItemControlEClass = createEClass(TPLAN_ITEM_CONTROL);
        createEReference(tPlanItemControlEClass, TPLAN_ITEM_CONTROL__REPETITION_RULE);
        createEReference(tPlanItemControlEClass, TPLAN_ITEM_CONTROL__REQUIRED_RULE);
        createEReference(tPlanItemControlEClass, TPLAN_ITEM_CONTROL__MANUAL_ACTIVATION_RULE);

        tPlanItemDefinitionEClass = createEClass(TPLAN_ITEM_DEFINITION);
        createEReference(tPlanItemDefinitionEClass, TPLAN_ITEM_DEFINITION__DEFAULT_CONTROL);
        createEAttribute(tPlanItemDefinitionEClass, TPLAN_ITEM_DEFINITION__NAME);

        tPlanItemOnPartEClass = createEClass(TPLAN_ITEM_ON_PART);
        createEAttribute(tPlanItemOnPartEClass, TPLAN_ITEM_ON_PART__STANDARD_EVENT);
        createEReference(tPlanItemOnPartEClass, TPLAN_ITEM_ON_PART__SENTRY_REF);
        createEReference(tPlanItemOnPartEClass, TPLAN_ITEM_ON_PART__SOURCE_REF);

        tPlanItemStartTriggerEClass = createEClass(TPLAN_ITEM_START_TRIGGER);
        createEAttribute(tPlanItemStartTriggerEClass, TPLAN_ITEM_START_TRIGGER__STANDARD_EVENT);
        createEReference(tPlanItemStartTriggerEClass, TPLAN_ITEM_START_TRIGGER__SOURCE_REF);

        tPlanningTableEClass = createEClass(TPLANNING_TABLE);
        createEAttribute(tPlanningTableEClass, TPLANNING_TABLE__TABLE_ITEM_GROUP);
        createEReference(tPlanningTableEClass, TPLANNING_TABLE__TABLE_ITEM);
        createEReference(tPlanningTableEClass, TPLANNING_TABLE__APPLICABILITY_RULE);

        tProcessEClass = createEClass(TPROCESS);
        createEReference(tProcessEClass, TPROCESS__INPUT);
        createEReference(tProcessEClass, TPROCESS__OUTPUT);
        createEAttribute(tProcessEClass, TPROCESS__IMPLEMENTATION_TYPE);
        createEAttribute(tProcessEClass, TPROCESS__NAME);

        tProcessParameterEClass = createEClass(TPROCESS_PARAMETER);

        tProcessTaskEClass = createEClass(TPROCESS_TASK);
        createEReference(tProcessTaskEClass, TPROCESS_TASK__PARAMETER_MAPPING);
        createEReference(tProcessTaskEClass, TPROCESS_TASK__PROCESS_REF);

        tPropertyEClass = createEClass(TPROPERTY);
        createEAttribute(tPropertyEClass, TPROPERTY__NAME);
        createEAttribute(tPropertyEClass, TPROPERTY__TYPE);

        tRepetitionRuleEClass = createEClass(TREPETITION_RULE);
        createEReference(tRepetitionRuleEClass, TREPETITION_RULE__CONDITION);
        createEReference(tRepetitionRuleEClass, TREPETITION_RULE__CONTEXT_REF);
        createEAttribute(tRepetitionRuleEClass, TREPETITION_RULE__NAME);

        tRequiredRuleEClass = createEClass(TREQUIRED_RULE);
        createEReference(tRequiredRuleEClass, TREQUIRED_RULE__CONDITION);
        createEReference(tRequiredRuleEClass, TREQUIRED_RULE__CONTEXT_REF);
        createEAttribute(tRequiredRuleEClass, TREQUIRED_RULE__NAME);

        tRoleEClass = createEClass(TROLE);
        createEAttribute(tRoleEClass, TROLE__NAME);

        tSentryEClass = createEClass(TSENTRY);
        createEAttribute(tSentryEClass, TSENTRY__ON_PART_GROUP);
        createEReference(tSentryEClass, TSENTRY__ON_PART);
        createEReference(tSentryEClass, TSENTRY__IF_PART);
        createEAttribute(tSentryEClass, TSENTRY__NAME);

        tStageEClass = createEClass(TSTAGE);
        createEReference(tStageEClass, TSTAGE__PLANNING_TABLE);
        createEAttribute(tStageEClass, TSTAGE__PLAN_ITEM_DEFINITION_GROUP);
        createEReference(tStageEClass, TSTAGE__PLAN_ITEM_DEFINITION);
        createEAttribute(tStageEClass, TSTAGE__AUTO_COMPLETE);
        createEReference(tStageEClass, TSTAGE__EXIT_CRITERIA_REFS);

        tStartTriggerEClass = createEClass(TSTART_TRIGGER);

        tTableItemEClass = createEClass(TTABLE_ITEM);
        createEReference(tTableItemEClass, TTABLE_ITEM__APPLICABILITY_RULE_REFS);
        createEReference(tTableItemEClass, TTABLE_ITEM__AUTHORIZED_ROLE_REFS);

        tTaskEClass = createEClass(TTASK);
        createEReference(tTaskEClass, TTASK__INPUTS);
        createEReference(tTaskEClass, TTASK__OUTPUTS);
        createEAttribute(tTaskEClass, TTASK__IS_BLOCKING);

        tTimerEventEClass = createEClass(TTIMER_EVENT);
        createEReference(tTimerEventEClass, TTIMER_EVENT__TIMER_EXPRESSION);
        createEAttribute(tTimerEventEClass, TTIMER_EVENT__TIMER_START_GROUP);
        createEReference(tTimerEventEClass, TTIMER_EVENT__TIMER_START);

        tUserEventEClass = createEClass(TUSER_EVENT);

        // Create enums
        caseFileItemTransitionEEnum = createEEnum(CASE_FILE_ITEM_TRANSITION);
        definitionTypeEnumMember1EEnum = createEEnum(DEFINITION_TYPE_ENUM_MEMBER1);
        multiplicityEnumEEnum = createEEnum(MULTIPLICITY_ENUM);
        planItemTransitionEEnum = createEEnum(PLAN_ITEM_TRANSITION);
        processTypeEnumMember1EEnum = createEEnum(PROCESS_TYPE_ENUM_MEMBER1);

        // Create data types
        caseFileItemTransitionObjectEDataType = createEDataType(CASE_FILE_ITEM_TRANSITION_OBJECT);
        definitionTypeEnumEDataType = createEDataType(DEFINITION_TYPE_ENUM);
        definitionTypeEnumMember1ObjectEDataType = createEDataType(DEFINITION_TYPE_ENUM_MEMBER1_OBJECT);
        multiplicityEnumObjectEDataType = createEDataType(MULTIPLICITY_ENUM_OBJECT);
        planItemTransitionObjectEDataType = createEDataType(PLAN_ITEM_TRANSITION_OBJECT);
        processTypeEnumEDataType = createEDataType(PROCESS_TYPE_ENUM);
        processTypeEnumMember1ObjectEDataType = createEDataType(PROCESS_TYPE_ENUM_MEMBER1_OBJECT);
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
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
        CmmnDiPackage theCmmnDiPackage = (CmmnDiPackage)EPackage.Registry.INSTANCE.getEPackage(CmmnDiPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        tApplicabilityRuleEClass.getESuperTypes().add(this.getTCmmnElement());
        tCaseEClass.getESuperTypes().add(this.getTCmmnElement());
        tCaseFileEClass.getESuperTypes().add(this.getTCmmnElement());
        tCaseFileItemEClass.getESuperTypes().add(this.getTCmmnElement());
        tCaseFileItemDefinitionEClass.getESuperTypes().add(this.getTCmmnElement());
        tCaseFileItemOnPartEClass.getESuperTypes().add(this.getTOnPart());
        tCaseFileItemStartTriggerEClass.getESuperTypes().add(this.getTStartTrigger());
        tCaseParameterEClass.getESuperTypes().add(this.getTParameter());
        tCaseTaskEClass.getESuperTypes().add(this.getTTask());
        tChildrenEClass.getESuperTypes().add(this.getTCmmnElement());
        tDiscretionaryItemEClass.getESuperTypes().add(this.getTTableItem());
        tEventEClass.getESuperTypes().add(this.getTPlanItemDefinition());
        tExpressionEClass.getESuperTypes().add(this.getTCmmnElementWithMixedContent());
        tHumanTaskEClass.getESuperTypes().add(this.getTTask());
        tIfPartEClass.getESuperTypes().add(this.getTCmmnElement());
        tManualActivationRuleEClass.getESuperTypes().add(this.getTCmmnElement());
        tMilestoneEClass.getESuperTypes().add(this.getTPlanItemDefinition());
        tOnPartEClass.getESuperTypes().add(this.getTCmmnElement());
        tParameterEClass.getESuperTypes().add(this.getTCmmnElement());
        tParameterMappingEClass.getESuperTypes().add(this.getTCmmnElement());
        tPlanFragmentEClass.getESuperTypes().add(this.getTPlanItemDefinition());
        tPlanItemEClass.getESuperTypes().add(this.getTCmmnElement());
        tPlanItemControlEClass.getESuperTypes().add(this.getTCmmnElement());
        tPlanItemDefinitionEClass.getESuperTypes().add(this.getTCmmnElement());
        tPlanItemOnPartEClass.getESuperTypes().add(this.getTOnPart());
        tPlanItemStartTriggerEClass.getESuperTypes().add(this.getTStartTrigger());
        tPlanningTableEClass.getESuperTypes().add(this.getTTableItem());
        tProcessEClass.getESuperTypes().add(this.getTCmmnElement());
        tProcessParameterEClass.getESuperTypes().add(this.getTParameter());
        tProcessTaskEClass.getESuperTypes().add(this.getTTask());
        tPropertyEClass.getESuperTypes().add(this.getTCmmnElement());
        tRepetitionRuleEClass.getESuperTypes().add(this.getTCmmnElement());
        tRequiredRuleEClass.getESuperTypes().add(this.getTCmmnElement());
        tRoleEClass.getESuperTypes().add(this.getTCmmnElement());
        tSentryEClass.getESuperTypes().add(this.getTCmmnElement());
        tStageEClass.getESuperTypes().add(this.getTPlanFragment());
        tStartTriggerEClass.getESuperTypes().add(this.getTCmmnElement());
        tTableItemEClass.getESuperTypes().add(this.getTCmmnElement());
        tTaskEClass.getESuperTypes().add(this.getTPlanItemDefinition());
        tTimerEventEClass.getESuperTypes().add(this.getTEvent());
        tUserEventEClass.getESuperTypes().add(this.getTEvent());

        // Initialize classes, features, and operations; add parameters
        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ApplicabilityRule(), this.getTApplicabilityRule(), null, "applicabilityRule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Case(), this.getTCase(), null, "case", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CaseFile(), this.getTCaseFile(), null, "caseFile", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CaseFileItem(), this.getTCaseFileItem(), null, "caseFileItem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CaseFileItemDefinition(), this.getTCaseFileItemDefinition(), null, "caseFileItemDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CaseFileItemOnPart(), this.getTCaseFileItemOnPart(), null, "caseFileItemOnPart", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_OnPart(), this.getTOnPart(), null, "onPart", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CaseFileItemStartTrigger(), this.getTCaseFileItemStartTrigger(), null, "caseFileItemStartTrigger", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_TimerStart(), this.getTStartTrigger(), null, "timerStart", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CaseParameter(), this.getTCaseParameter(), null, "caseParameter", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Parameter(), this.getTParameter(), null, "parameter", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CaseTask(), this.getTCaseTask(), null, "caseTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Task(), this.getTTask(), null, "task", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PlanItemDefinition(), this.getTPlanItemDefinition(), null, "planItemDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Definitions(), this.getTDefinitions(), null, "definitions", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_DiscretionaryItem(), this.getTDiscretionaryItem(), null, "discretionaryItem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_TableItem(), this.getTTableItem(), null, "tableItem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Event(), this.getTEvent(), null, "event", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Expression(), this.getTExpression(), null, "expression", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_HumanTask(), this.getTHumanTask(), null, "humanTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_IfPart(), this.getTIfPart(), null, "ifPart", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Import(), this.getTImport(), null, "import", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ManualActivationRule(), this.getTManualActivationRule(), null, "manualActivationRule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Milestone(), this.getTMilestone(), null, "milestone", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ParameterMapping(), this.getTParameterMapping(), null, "parameterMapping", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PlanFragment(), this.getTPlanFragment(), null, "planFragment", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PlanItem(), this.getTPlanItem(), null, "planItem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PlanItemControl(), this.getTPlanItemControl(), null, "planItemControl", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PlanItemOnPart(), this.getTPlanItemOnPart(), null, "planItemOnPart", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PlanItemStartTrigger(), this.getTPlanItemStartTrigger(), null, "planItemStartTrigger", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_PlanningTable(), this.getTPlanningTable(), null, "planningTable", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Process(), this.getTProcess(), null, "process", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ProcessParameter(), this.getTProcessParameter(), null, "processParameter", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_ProcessTask(), this.getTProcessTask(), null, "processTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Property(), this.getTProperty(), null, "property", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RepetitionRule(), this.getTRepetitionRule(), null, "repetitionRule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_RequiredRule(), this.getTRequiredRule(), null, "requiredRule", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Role(), this.getTRole(), null, "role", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Sentry(), this.getTSentry(), null, "sentry", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Stage(), this.getTStage(), null, "stage", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_TimerEvent(), this.getTTimerEvent(), null, "timerEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_UserEvent(), this.getTUserEvent(), null, "userEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(tApplicabilityRuleEClass, TApplicabilityRule.class, "TApplicabilityRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTApplicabilityRule_Condition(), this.getTExpression(), null, "condition", null, 0, 1, TApplicabilityRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTApplicabilityRule_ContextRef(), this.getTCaseFileItem(), null, "contextRef", null, 0, 1, TApplicabilityRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCaseEClass, TCase.class, "TCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTCase_CaseFileModel(), this.getTCaseFile(), null, "caseFileModel", null, 0, 1, TCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCase_CasePlanModel(), this.getTStage(), null, "casePlanModel", null, 0, 1, TCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCase_CaseRoles(), this.getTRole(), null, "caseRoles", null, 0, -1, TCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCase_Input(), this.getTCaseParameter(), null, "input", null, 0, -1, TCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCase_Output(), this.getTCaseParameter(), null, "output", null, 0, -1, TCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCase_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCaseFileEClass, TCaseFile.class, "TCaseFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTCaseFile_CaseFileItem(), this.getTCaseFileItem(), null, "caseFileItem", null, 0, -1, TCaseFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCaseFileItemEClass, TCaseFileItem.class, "TCaseFileItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTCaseFileItem_Children(), this.getTChildren(), null, "children", null, 0, 1, TCaseFileItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCaseFileItem_DefinitionRef(), this.getTCaseFileItemDefinition(), null, "definitionRef", null, 0, 1, TCaseFileItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCaseFileItem_Multiplicity(), this.getMultiplicityEnum(), "multiplicity", "Unspecified", 0, 1, TCaseFileItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCaseFileItem_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TCaseFileItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCaseFileItem_SourceRef(), this.getTCaseFileItem(), null, "sourceRef", null, 0, -1, TCaseFileItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCaseFileItem_TargetRefs(), this.getTCaseFileItem(), null, "targetRefs", null, 0, -1, TCaseFileItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCaseFileItemDefinitionEClass, TCaseFileItemDefinition.class, "TCaseFileItemDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTCaseFileItemDefinition_Property(), this.getTProperty(), null, "property", null, 0, -1, TCaseFileItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCaseFileItemDefinition_DefinitionType(), this.getDefinitionTypeEnum(), "definitionType", "http://www.omg.org/spec/CMMN/DefinitionType/Unspecified", 0, 1, TCaseFileItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCaseFileItemDefinition_ImportRef(), theXMLTypePackage.getQName(), "importRef", null, 0, 1, TCaseFileItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCaseFileItemDefinition_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TCaseFileItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCaseFileItemDefinition_StructureRef(), theXMLTypePackage.getQName(), "structureRef", null, 0, 1, TCaseFileItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCaseFileItemOnPartEClass, TCaseFileItemOnPart.class, "TCaseFileItemOnPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTCaseFileItemOnPart_StandardEvent(), this.getCaseFileItemTransition(), "standardEvent", null, 0, 1, TCaseFileItemOnPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCaseFileItemOnPart_SourceRef(), this.getTCaseFileItem(), null, "sourceRef", null, 0, 1, TCaseFileItemOnPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCaseFileItemStartTriggerEClass, TCaseFileItemStartTrigger.class, "TCaseFileItemStartTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTCaseFileItemStartTrigger_StandardEvent(), this.getCaseFileItemTransition(), "standardEvent", null, 0, 1, TCaseFileItemStartTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCaseFileItemStartTrigger_SourceRef(), this.getTCaseFileItem(), null, "sourceRef", null, 0, 1, TCaseFileItemStartTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCaseParameterEClass, TCaseParameter.class, "TCaseParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTCaseParameter_BindingRefinement(), this.getTExpression(), null, "bindingRefinement", null, 0, 1, TCaseParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCaseParameter_BindingRef(), this.getTCaseFileItem(), null, "bindingRef", null, 0, 1, TCaseParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCaseTaskEClass, TCaseTask.class, "TCaseTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTCaseTask_ParameterMapping(), this.getTParameterMapping(), null, "parameterMapping", null, 0, -1, TCaseTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTCaseTask_CaseRef(), this.getTCase(), null, "caseRef", null, 0, 1, TCaseTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tChildrenEClass, TChildren.class, "TChildren", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTChildren_CaseFileItem(), this.getTCaseFileItem(), null, "caseFileItem", null, 0, -1, TChildren.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCmmnElementEClass, TCmmnElement.class, "TCmmnElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTCmmnElement_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, TCmmnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCmmnElement_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, TCmmnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCmmnElement_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TCmmnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tCmmnElementWithMixedContentEClass, TCmmnElementWithMixedContent.class, "TCmmnElementWithMixedContent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTCmmnElementWithMixedContent_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TCmmnElementWithMixedContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCmmnElementWithMixedContent_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, TCmmnElementWithMixedContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCmmnElementWithMixedContent_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, TCmmnElementWithMixedContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTCmmnElementWithMixedContent_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TCmmnElementWithMixedContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tDefinitionsEClass, TDefinitions.class, "TDefinitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTDefinitions_Import(), this.getTImport(), null, "import", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTDefinitions_CaseFileItemDefinition(), this.getTCaseFileItemDefinition(), null, "caseFileItemDefinition", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTDefinitions_Case(), this.getTCase(), null, "case", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTDefinitions_Process(), this.getTProcess(), null, "process", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTDefinitions_CMMNDiagram(), theCmmnDiPackage.getCMMNDiagram(), null, "cMMNDiagram", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_Author(), theXMLTypePackage.getString(), "author", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_CreationDate(), theXMLTypePackage.getDateTime(), "creationDate", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_Exporter(), theXMLTypePackage.getString(), "exporter", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_ExporterVersion(), theXMLTypePackage.getString(), "exporterVersion", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", "http://www.w3.org/1999/XPath", 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 1, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTDefinitions_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tDiscretionaryItemEClass, TDiscretionaryItem.class, "TDiscretionaryItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTDiscretionaryItem_ItemControl(), this.getTPlanItemControl(), null, "itemControl", null, 0, 1, TDiscretionaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTDiscretionaryItem_DefinitionRef(), this.getTPlanItemDefinition(), null, "definitionRef", null, 0, 1, TDiscretionaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTDiscretionaryItem_EntryCriteriaRefs(), this.getTSentry(), null, "entryCriteriaRefs", null, 0, -1, TDiscretionaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTDiscretionaryItem_ExitCriteriaRefs(), this.getTSentry(), null, "exitCriteriaRefs", null, 0, -1, TDiscretionaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tEventEClass, TEvent.class, "TEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tExpressionEClass, TExpression.class, "TExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTExpression_Body(), theXMLTypePackage.getString(), "body", null, 0, 1, TExpression.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getTExpression_Language(), theXMLTypePackage.getAnyURI(), "language", "http://www.w3.org/1999/XPath", 0, 1, TExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tHumanTaskEClass, THumanTask.class, "THumanTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTHumanTask_PlanningTable(), this.getTPlanningTable(), null, "planningTable", null, 0, -1, THumanTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTHumanTask_PerformerRef(), this.getTRole(), null, "performerRef", null, 0, 1, THumanTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tIfPartEClass, TIfPart.class, "TIfPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTIfPart_Condition(), this.getTExpression(), null, "condition", null, 0, -1, TIfPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTIfPart_ContextRef(), this.getTCaseFileItem(), null, "contextRef", null, 0, 1, TIfPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tImportEClass, TImport.class, "TImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTImport_ImportType(), theXMLTypePackage.getAnyURI(), "importType", null, 1, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTImport_Location(), theXMLTypePackage.getString(), "location", null, 1, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTImport_Namespace(), theXMLTypePackage.getAnyURI(), "namespace", null, 0, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tManualActivationRuleEClass, TManualActivationRule.class, "TManualActivationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTManualActivationRule_Condition(), this.getTExpression(), null, "condition", null, 0, 1, TManualActivationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTManualActivationRule_ContextRef(), this.getTCaseFileItem(), null, "contextRef", null, 0, 1, TManualActivationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTManualActivationRule_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TManualActivationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tMilestoneEClass, TMilestone.class, "TMilestone", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tOnPartEClass, TOnPart.class, "TOnPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tParameterEClass, TParameter.class, "TParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTParameter_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tParameterMappingEClass, TParameterMapping.class, "TParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTParameterMapping_Transformation(), this.getTExpression(), null, "transformation", null, 0, 1, TParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTParameterMapping_SourceRef(), this.getTParameter(), null, "sourceRef", null, 0, 1, TParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTParameterMapping_TargetRef(), this.getTParameter(), null, "targetRef", null, 0, 1, TParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tPlanFragmentEClass, TPlanFragment.class, "TPlanFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTPlanFragment_PlanItem(), this.getTPlanItem(), null, "planItem", null, 0, -1, TPlanFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanFragment_Sentry(), this.getTSentry(), null, "sentry", null, 0, -1, TPlanFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tPlanItemEClass, TPlanItem.class, "TPlanItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTPlanItem_ItemControl(), this.getTPlanItemControl(), null, "itemControl", null, 0, 1, TPlanItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanItem_DefinitionRef(), this.getTPlanItemDefinition(), null, "definitionRef", null, 0, 1, TPlanItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanItem_EntryCriteriaRefs(), this.getTSentry(), null, "entryCriteriaRefs", null, 0, -1, TPlanItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanItem_ExitCriteriaRefs(), this.getTSentry(), null, "exitCriteriaRefs", null, 0, -1, TPlanItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTPlanItem_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TPlanItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tPlanItemControlEClass, TPlanItemControl.class, "TPlanItemControl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTPlanItemControl_RepetitionRule(), this.getTRepetitionRule(), null, "repetitionRule", null, 0, 1, TPlanItemControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanItemControl_RequiredRule(), this.getTRequiredRule(), null, "requiredRule", null, 0, 1, TPlanItemControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanItemControl_ManualActivationRule(), this.getTManualActivationRule(), null, "manualActivationRule", null, 0, 1, TPlanItemControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tPlanItemDefinitionEClass, TPlanItemDefinition.class, "TPlanItemDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTPlanItemDefinition_DefaultControl(), this.getTPlanItemControl(), null, "defaultControl", null, 0, 1, TPlanItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTPlanItemDefinition_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TPlanItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tPlanItemOnPartEClass, TPlanItemOnPart.class, "TPlanItemOnPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTPlanItemOnPart_StandardEvent(), this.getPlanItemTransition(), "standardEvent", null, 0, 1, TPlanItemOnPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanItemOnPart_SentryRef(), this.getTSentry(), null, "sentryRef", null, 0, 1, TPlanItemOnPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanItemOnPart_SourceRef(), this.getTPlanItem(), null, "sourceRef", null, 0, 1, TPlanItemOnPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tPlanItemStartTriggerEClass, TPlanItemStartTrigger.class, "TPlanItemStartTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTPlanItemStartTrigger_StandardEvent(), this.getPlanItemTransition(), "standardEvent", null, 0, 1, TPlanItemStartTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanItemStartTrigger_SourceRef(), this.getTPlanItem(), null, "sourceRef", null, 0, 1, TPlanItemStartTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tPlanningTableEClass, TPlanningTable.class, "TPlanningTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTPlanningTable_TableItemGroup(), ecorePackage.getEFeatureMapEntry(), "tableItemGroup", null, 0, -1, TPlanningTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanningTable_TableItem(), this.getTTableItem(), null, "tableItem", null, 0, -1, TPlanningTable.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getTPlanningTable_ApplicabilityRule(), this.getTApplicabilityRule(), null, "applicabilityRule", null, 0, -1, TPlanningTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tProcessEClass, TProcess.class, "TProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTProcess_Input(), this.getTProcessParameter(), null, "input", null, 0, -1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTProcess_Output(), this.getTProcessParameter(), null, "output", null, 0, -1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTProcess_ImplementationType(), theXMLTypePackage.getAnyURI(), "implementationType", "http://www.omg.org/spec/CMMN/ProcessType/Unspecified", 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTProcess_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tProcessParameterEClass, TProcessParameter.class, "TProcessParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tProcessTaskEClass, TProcessTask.class, "TProcessTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTProcessTask_ParameterMapping(), this.getTParameterMapping(), null, "parameterMapping", null, 0, -1, TProcessTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTProcessTask_ProcessRef(), this.getTProcess(), null, "processRef", null, 0, 1, TProcessTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tPropertyEClass, TProperty.class, "TProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTProperty_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTProperty_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, TProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tRepetitionRuleEClass, TRepetitionRule.class, "TRepetitionRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTRepetitionRule_Condition(), this.getTExpression(), null, "condition", null, 0, 1, TRepetitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTRepetitionRule_ContextRef(), this.getTCaseFileItem(), null, "contextRef", null, 0, 1, TRepetitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTRepetitionRule_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TRepetitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tRequiredRuleEClass, TRequiredRule.class, "TRequiredRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTRequiredRule_Condition(), this.getTExpression(), null, "condition", null, 0, 1, TRequiredRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTRequiredRule_ContextRef(), this.getTCaseFileItem(), null, "contextRef", null, 0, 1, TRequiredRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTRequiredRule_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TRequiredRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tRoleEClass, TRole.class, "TRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTRole_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tSentryEClass, TSentry.class, "TSentry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTSentry_OnPartGroup(), ecorePackage.getEFeatureMapEntry(), "onPartGroup", null, 0, -1, TSentry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTSentry_OnPart(), this.getTOnPart(), null, "onPart", null, 0, -1, TSentry.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getTSentry_IfPart(), this.getTIfPart(), null, "ifPart", null, 0, 1, TSentry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTSentry_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TSentry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tStageEClass, TStage.class, "TStage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTStage_PlanningTable(), this.getTPlanningTable(), null, "planningTable", null, 0, 1, TStage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTStage_PlanItemDefinitionGroup(), ecorePackage.getEFeatureMapEntry(), "planItemDefinitionGroup", null, 0, -1, TStage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTStage_PlanItemDefinition(), this.getTPlanItemDefinition(), null, "planItemDefinition", null, 0, -1, TStage.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getTStage_AutoComplete(), theXMLTypePackage.getBoolean(), "autoComplete", "false", 0, 1, TStage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTStage_ExitCriteriaRefs(), this.getTSentry(), null, "exitCriteriaRefs", null, 0, -1, TStage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tStartTriggerEClass, TStartTrigger.class, "TStartTrigger", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tTableItemEClass, TTableItem.class, "TTableItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTTableItem_ApplicabilityRuleRefs(), this.getTApplicabilityRule(), null, "applicabilityRuleRefs", null, 0, -1, TTableItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTTableItem_AuthorizedRoleRefs(), this.getTRole(), null, "authorizedRoleRefs", null, 0, -1, TTableItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tTaskEClass, TTask.class, "TTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTTask_Inputs(), this.getTCaseParameter(), null, "inputs", null, 0, -1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTTask_Outputs(), this.getTCaseParameter(), null, "outputs", null, 0, -1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTTask_IsBlocking(), theXMLTypePackage.getBoolean(), "isBlocking", "true", 0, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tTimerEventEClass, TTimerEvent.class, "TTimerEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTTimerEvent_TimerExpression(), this.getTExpression(), null, "timerExpression", null, 0, 1, TTimerEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTTimerEvent_TimerStartGroup(), ecorePackage.getEFeatureMapEntry(), "timerStartGroup", null, 0, 1, TTimerEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTTimerEvent_TimerStart(), this.getTStartTrigger(), null, "timerStart", null, 0, 1, TTimerEvent.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(tUserEventEClass, TUserEvent.class, "TUserEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        initEEnum(caseFileItemTransitionEEnum, CaseFileItemTransition.class, "CaseFileItemTransition");
        addEEnumLiteral(caseFileItemTransitionEEnum, CaseFileItemTransition.ADD_CHILD);
        addEEnumLiteral(caseFileItemTransitionEEnum, CaseFileItemTransition.ADD_REFERENCE);
        addEEnumLiteral(caseFileItemTransitionEEnum, CaseFileItemTransition.CREATE);
        addEEnumLiteral(caseFileItemTransitionEEnum, CaseFileItemTransition.DELETE);
        addEEnumLiteral(caseFileItemTransitionEEnum, CaseFileItemTransition.REMOVE_CHILD);
        addEEnumLiteral(caseFileItemTransitionEEnum, CaseFileItemTransition.REMOVE_REFERENCE);
        addEEnumLiteral(caseFileItemTransitionEEnum, CaseFileItemTransition.REPLACE);
        addEEnumLiteral(caseFileItemTransitionEEnum, CaseFileItemTransition.UPDATE);

        initEEnum(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.class, "DefinitionTypeEnumMember1");
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_CMIS_FOLDER);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_CMIS_DOCUMENT);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_CMIS_RELATIONSHIP);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_XSD_ELEMENT);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_XSD_COMPLEX_TYPE);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_XSD_SIMPLE_TYPE);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_WSDL_MESSAGE);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_UML_CLASS);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_UNKNOWN);
        addEEnumLiteral(definitionTypeEnumMember1EEnum, DefinitionTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_DEFINITION_TYPE_UNSPECIFIED);

        initEEnum(multiplicityEnumEEnum, MultiplicityEnum.class, "MultiplicityEnum");
        addEEnumLiteral(multiplicityEnumEEnum, MultiplicityEnum.ZERO_OR_ONE);
        addEEnumLiteral(multiplicityEnumEEnum, MultiplicityEnum.ZERO_OR_MORE);
        addEEnumLiteral(multiplicityEnumEEnum, MultiplicityEnum.EXACTLY_ONE);
        addEEnumLiteral(multiplicityEnumEEnum, MultiplicityEnum.ONE_OR_MORE);
        addEEnumLiteral(multiplicityEnumEEnum, MultiplicityEnum.UNSPECIFIED);
        addEEnumLiteral(multiplicityEnumEEnum, MultiplicityEnum.UNKNOWN);

        initEEnum(planItemTransitionEEnum, PlanItemTransition.class, "PlanItemTransition");
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.CLOSE);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.COMPLETE);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.CREATE);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.DISABLE);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.ENABLE);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.EXIT);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.FAULT);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.MANUAL_START);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.OCCUR);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.PARENT_RESUME);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.PARENT_SUSPEND);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.REACTIVATE);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.REENABLE);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.RESUME);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.START);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.SUSPEND);
        addEEnumLiteral(planItemTransitionEEnum, PlanItemTransition.TERMINATE);

        initEEnum(processTypeEnumMember1EEnum, ProcessTypeEnumMember1.class, "ProcessTypeEnumMember1");
        addEEnumLiteral(processTypeEnumMember1EEnum, ProcessTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_PROCESS_TYPE_BPMN20);
        addEEnumLiteral(processTypeEnumMember1EEnum, ProcessTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_PROCESS_TYPE_XPDL2);
        addEEnumLiteral(processTypeEnumMember1EEnum, ProcessTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_PROCESS_TYPE_WSBPEL20);
        addEEnumLiteral(processTypeEnumMember1EEnum, ProcessTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_PROCESS_TYPE_WSBPEL1);
        addEEnumLiteral(processTypeEnumMember1EEnum, ProcessTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_PROCESS_TYPE_UNKNOWN);
        addEEnumLiteral(processTypeEnumMember1EEnum, ProcessTypeEnumMember1.HTTP_WWW_OMG_ORG_SPEC_CMMN_PROCESS_TYPE_UNSPECIFIED);

        // Initialize data types
        initEDataType(caseFileItemTransitionObjectEDataType, CaseFileItemTransition.class, "CaseFileItemTransitionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(definitionTypeEnumEDataType, Object.class, "DefinitionTypeEnum", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(definitionTypeEnumMember1ObjectEDataType, DefinitionTypeEnumMember1.class, "DefinitionTypeEnumMember1Object", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(multiplicityEnumObjectEDataType, MultiplicityEnum.class, "MultiplicityEnumObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(planItemTransitionObjectEDataType, PlanItemTransition.class, "PlanItemTransitionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(processTypeEnumEDataType, Object.class, "ProcessTypeEnum", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(processTypeEnumMember1ObjectEDataType, ProcessTypeEnumMember1.class, "ProcessTypeEnumMember1Object", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
          (caseFileItemTransitionEEnum, 
           source, 
           new String[] {
             "name", "CaseFileItemTransition"
           });	
        addAnnotation
          (caseFileItemTransitionObjectEDataType, 
           source, 
           new String[] {
             "name", "CaseFileItemTransition:Object",
             "baseType", "CaseFileItemTransition"
           });	
        addAnnotation
          (definitionTypeEnumEDataType, 
           source, 
           new String[] {
             "name", "DefinitionTypeEnum",
             "memberTypes", "http://www.eclipse.org/emf/2003/XMLType#anyURI DefinitionTypeEnum_._member_._1"
           });	
        addAnnotation
          (definitionTypeEnumMember1EEnum, 
           source, 
           new String[] {
             "name", "DefinitionTypeEnum_._member_._1"
           });	
        addAnnotation
          (definitionTypeEnumMember1ObjectEDataType, 
           source, 
           new String[] {
             "name", "DefinitionTypeEnum_._member_._1:Object",
             "baseType", "DefinitionTypeEnum_._member_._1"
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
          (getDocumentRoot_ApplicabilityRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "applicabilityRule",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Case(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "case",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CaseFile(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFile",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CaseFileItem(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFileItem",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CaseFileItemDefinition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFileItemDefinition",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CaseFileItemOnPart(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFileItemOnPart",
             "namespace", "##targetNamespace",
             "affiliation", "onPart"
           });	
        addAnnotation
          (getDocumentRoot_OnPart(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "onPart",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CaseFileItemStartTrigger(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFileItemStartTrigger",
             "namespace", "##targetNamespace",
             "affiliation", "timerStart"
           });	
        addAnnotation
          (getDocumentRoot_TimerStart(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "timerStart",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CaseParameter(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseParameter",
             "namespace", "##targetNamespace",
             "affiliation", "parameter"
           });	
        addAnnotation
          (getDocumentRoot_Parameter(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "parameter",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_CaseTask(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseTask",
             "namespace", "##targetNamespace",
             "affiliation", "task"
           });	
        addAnnotation
          (getDocumentRoot_Task(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "task",
             "namespace", "##targetNamespace",
             "affiliation", "planItemDefinition"
           });	
        addAnnotation
          (getDocumentRoot_PlanItemDefinition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planItemDefinition",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Definitions(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "definitions",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_DiscretionaryItem(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "discretionaryItem",
             "namespace", "##targetNamespace",
             "affiliation", "tableItem"
           });	
        addAnnotation
          (getDocumentRoot_TableItem(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "tableItem",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Event(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "event",
             "namespace", "##targetNamespace",
             "affiliation", "planItemDefinition"
           });	
        addAnnotation
          (getDocumentRoot_Expression(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "expression",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_HumanTask(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "humanTask",
             "namespace", "##targetNamespace",
             "affiliation", "task"
           });	
        addAnnotation
          (getDocumentRoot_IfPart(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "ifPart",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Import(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "import",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_ManualActivationRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "manualActivationRule",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Milestone(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "milestone",
             "namespace", "##targetNamespace",
             "affiliation", "planItemDefinition"
           });	
        addAnnotation
          (getDocumentRoot_ParameterMapping(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "parameterMapping",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_PlanFragment(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planFragment",
             "namespace", "##targetNamespace",
             "affiliation", "planItemDefinition"
           });	
        addAnnotation
          (getDocumentRoot_PlanItem(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planItem",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_PlanItemControl(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planItemControl",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_PlanItemOnPart(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planItemOnPart",
             "namespace", "##targetNamespace",
             "affiliation", "onPart"
           });	
        addAnnotation
          (getDocumentRoot_PlanItemStartTrigger(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planItemStartTrigger",
             "namespace", "##targetNamespace",
             "affiliation", "timerStart"
           });	
        addAnnotation
          (getDocumentRoot_PlanningTable(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planningTable",
             "namespace", "##targetNamespace",
             "affiliation", "tableItem"
           });	
        addAnnotation
          (getDocumentRoot_Process(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "process",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_ProcessParameter(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "processParameter",
             "namespace", "##targetNamespace",
             "affiliation", "parameter"
           });	
        addAnnotation
          (getDocumentRoot_ProcessTask(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "processTask",
             "namespace", "##targetNamespace",
             "affiliation", "task"
           });	
        addAnnotation
          (getDocumentRoot_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_RepetitionRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "repetitionRule",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_RequiredRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "requiredRule",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Role(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "role",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Sentry(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "sentry",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Stage(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "stage",
             "namespace", "##targetNamespace",
             "affiliation", "planItemDefinition"
           });	
        addAnnotation
          (getDocumentRoot_TimerEvent(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "timerEvent",
             "namespace", "##targetNamespace",
             "affiliation", "event"
           });	
        addAnnotation
          (getDocumentRoot_UserEvent(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "userEvent",
             "namespace", "##targetNamespace",
             "affiliation", "event"
           });	
        addAnnotation
          (multiplicityEnumEEnum, 
           source, 
           new String[] {
             "name", "MultiplicityEnum"
           });	
        addAnnotation
          (multiplicityEnumObjectEDataType, 
           source, 
           new String[] {
             "name", "MultiplicityEnum:Object",
             "baseType", "MultiplicityEnum"
           });	
        addAnnotation
          (planItemTransitionEEnum, 
           source, 
           new String[] {
             "name", "PlanItemTransition"
           });	
        addAnnotation
          (planItemTransitionObjectEDataType, 
           source, 
           new String[] {
             "name", "PlanItemTransition:Object",
             "baseType", "PlanItemTransition"
           });	
        addAnnotation
          (processTypeEnumEDataType, 
           source, 
           new String[] {
             "name", "ProcessTypeEnum",
             "memberTypes", "http://www.eclipse.org/emf/2003/XMLType#anyURI ProcessTypeEnum_._member_._1"
           });	
        addAnnotation
          (processTypeEnumMember1EEnum, 
           source, 
           new String[] {
             "name", "ProcessTypeEnum_._member_._1"
           });	
        addAnnotation
          (processTypeEnumMember1ObjectEDataType, 
           source, 
           new String[] {
             "name", "ProcessTypeEnum_._member_._1:Object",
             "baseType", "ProcessTypeEnum_._member_._1"
           });	
        addAnnotation
          (tApplicabilityRuleEClass, 
           source, 
           new String[] {
             "name", "tApplicabilityRule",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTApplicabilityRule_Condition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "condition",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTApplicabilityRule_ContextRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "contextRef"
           });	
        addAnnotation
          (tCaseEClass, 
           source, 
           new String[] {
             "name", "tCase",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTCase_CaseFileModel(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFileModel",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCase_CasePlanModel(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "casePlanModel",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCase_CaseRoles(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseRoles",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCase_Input(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "input",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCase_Output(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "output",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCase_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tCaseFileEClass, 
           source, 
           new String[] {
             "name", "tCaseFile",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTCaseFile_CaseFileItem(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFileItem",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (tCaseFileItemEClass, 
           source, 
           new String[] {
             "name", "tCaseFileItem",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTCaseFileItem_Children(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "children",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCaseFileItem_DefinitionRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "definitionRef"
           });	
        addAnnotation
          (getTCaseFileItem_Multiplicity(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "multiplicity"
           });	
        addAnnotation
          (getTCaseFileItem_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (getTCaseFileItem_SourceRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sourceRef"
           });	
        addAnnotation
          (getTCaseFileItem_TargetRefs(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "targetRefs"
           });	
        addAnnotation
          (tCaseFileItemDefinitionEClass, 
           source, 
           new String[] {
             "name", "tCaseFileItemDefinition",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTCaseFileItemDefinition_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCaseFileItemDefinition_DefinitionType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "definitionType"
           });	
        addAnnotation
          (getTCaseFileItemDefinition_ImportRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importRef"
           });	
        addAnnotation
          (getTCaseFileItemDefinition_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (getTCaseFileItemDefinition_StructureRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "structureRef"
           });	
        addAnnotation
          (tCaseFileItemOnPartEClass, 
           source, 
           new String[] {
             "name", "tCaseFileItemOnPart",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTCaseFileItemOnPart_StandardEvent(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "standardEvent",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCaseFileItemOnPart_SourceRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sourceRef"
           });	
        addAnnotation
          (tCaseFileItemStartTriggerEClass, 
           source, 
           new String[] {
             "name", "tCaseFileItemStartTrigger",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTCaseFileItemStartTrigger_StandardEvent(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "standardEvent",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCaseFileItemStartTrigger_SourceRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sourceRef"
           });	
        addAnnotation
          (tCaseParameterEClass, 
           source, 
           new String[] {
             "name", "tCaseParameter",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTCaseParameter_BindingRefinement(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "bindingRefinement",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCaseParameter_BindingRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "bindingRef"
           });	
        addAnnotation
          (tCaseTaskEClass, 
           source, 
           new String[] {
             "name", "tCaseTask",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTCaseTask_ParameterMapping(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "parameterMapping",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTCaseTask_CaseRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "caseRef"
           });	
        addAnnotation
          (tChildrenEClass, 
           source, 
           new String[] {
             "name", "tChildren",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTChildren_CaseFileItem(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFileItem",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (tCmmnElementEClass, 
           source, 
           new String[] {
             "name", "tCmmnElement",
             "kind", "empty"
           });	
        addAnnotation
          (getTCmmnElement_Description(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "description"
           });	
        addAnnotation
          (getTCmmnElement_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (getTCmmnElement_AnyAttribute(), 
           source, 
           new String[] {
             "kind", "attributeWildcard",
             "wildcards", "##other",
             "name", ":2",
             "processing", "lax"
           });	
        addAnnotation
          (tCmmnElementWithMixedContentEClass, 
           source, 
           new String[] {
             "name", "tCmmnElementWithMixedContent",
             "kind", "mixed"
           });	
        addAnnotation
          (getTCmmnElementWithMixedContent_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getTCmmnElementWithMixedContent_Description(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "description"
           });	
        addAnnotation
          (getTCmmnElementWithMixedContent_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (getTCmmnElementWithMixedContent_AnyAttribute(), 
           source, 
           new String[] {
             "kind", "attributeWildcard",
             "wildcards", "##other",
             "name", ":3",
             "processing", "lax"
           });	
        addAnnotation
          (tDefinitionsEClass, 
           source, 
           new String[] {
             "name", "tDefinitions",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTDefinitions_Import(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "import",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTDefinitions_CaseFileItemDefinition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "caseFileItemDefinition",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTDefinitions_Case(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "case",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTDefinitions_Process(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "process",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTDefinitions_CMMNDiagram(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "CMMNDiagram",
             "namespace", "http://www.omg.org/spec/CMMN/20131201/DI"
           });	
        addAnnotation
          (getTDefinitions_Author(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "author"
           });	
        addAnnotation
          (getTDefinitions_CreationDate(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "creationDate"
           });	
        addAnnotation
          (getTDefinitions_Exporter(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "exporter"
           });	
        addAnnotation
          (getTDefinitions_ExporterVersion(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "exporterVersion"
           });	
        addAnnotation
          (getTDefinitions_ExpressionLanguage(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "expressionLanguage"
           });	
        addAnnotation
          (getTDefinitions_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (getTDefinitions_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (getTDefinitions_TargetNamespace(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "targetNamespace"
           });	
        addAnnotation
          (getTDefinitions_AnyAttribute(), 
           source, 
           new String[] {
             "kind", "attributeWildcard",
             "wildcards", "##other",
             "name", ":13",
             "processing", "lax"
           });	
        addAnnotation
          (tDiscretionaryItemEClass, 
           source, 
           new String[] {
             "name", "tDiscretionaryItem",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTDiscretionaryItem_ItemControl(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "itemControl",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTDiscretionaryItem_DefinitionRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "definitionRef"
           });	
        addAnnotation
          (getTDiscretionaryItem_EntryCriteriaRefs(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "entryCriteriaRefs"
           });	
        addAnnotation
          (getTDiscretionaryItem_ExitCriteriaRefs(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "exitCriteriaRefs"
           });	
        addAnnotation
          (tEventEClass, 
           source, 
           new String[] {
             "name", "tEvent",
             "kind", "elementOnly"
           });	
        addAnnotation
          (tExpressionEClass, 
           source, 
           new String[] {
             "name", "tExpression",
             "kind", "mixed"
           });	
        addAnnotation
          (getTExpression_Body(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "body",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTExpression_Language(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "language"
           });	
        addAnnotation
          (tHumanTaskEClass, 
           source, 
           new String[] {
             "name", "tHumanTask",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTHumanTask_PlanningTable(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planningTable",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTHumanTask_PerformerRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "performerRef"
           });	
        addAnnotation
          (tIfPartEClass, 
           source, 
           new String[] {
             "name", "tIfPart",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTIfPart_Condition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "condition",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTIfPart_ContextRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "contextRef"
           });	
        addAnnotation
          (tImportEClass, 
           source, 
           new String[] {
             "name", "tImport",
             "kind", "empty"
           });	
        addAnnotation
          (getTImport_ImportType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "importType"
           });	
        addAnnotation
          (getTImport_Location(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "location"
           });	
        addAnnotation
          (getTImport_Namespace(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "namespace"
           });	
        addAnnotation
          (tManualActivationRuleEClass, 
           source, 
           new String[] {
             "name", "tManualActivationRule",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTManualActivationRule_Condition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "condition",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTManualActivationRule_ContextRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "contextRef"
           });	
        addAnnotation
          (getTManualActivationRule_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tMilestoneEClass, 
           source, 
           new String[] {
             "name", "tMilestone",
             "kind", "elementOnly"
           });	
        addAnnotation
          (tOnPartEClass, 
           source, 
           new String[] {
             "name", "tOnPart",
             "kind", "empty"
           });	
        addAnnotation
          (tParameterEClass, 
           source, 
           new String[] {
             "name", "tParameter",
             "kind", "empty"
           });	
        addAnnotation
          (getTParameter_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tParameterMappingEClass, 
           source, 
           new String[] {
             "name", "tParameterMapping",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTParameterMapping_Transformation(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "transformation",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTParameterMapping_SourceRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sourceRef"
           });	
        addAnnotation
          (getTParameterMapping_TargetRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "targetRef"
           });	
        addAnnotation
          (tPlanFragmentEClass, 
           source, 
           new String[] {
             "name", "tPlanFragment",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTPlanFragment_PlanItem(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planItem",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTPlanFragment_Sentry(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "sentry",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (tPlanItemEClass, 
           source, 
           new String[] {
             "name", "tPlanItem",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTPlanItem_ItemControl(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "itemControl",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTPlanItem_DefinitionRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "definitionRef"
           });	
        addAnnotation
          (getTPlanItem_EntryCriteriaRefs(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "entryCriteriaRefs"
           });	
        addAnnotation
          (getTPlanItem_ExitCriteriaRefs(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "exitCriteriaRefs"
           });	
        addAnnotation
          (getTPlanItem_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tPlanItemControlEClass, 
           source, 
           new String[] {
             "name", "tPlanItemControl",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTPlanItemControl_RepetitionRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "repetitionRule",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTPlanItemControl_RequiredRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "requiredRule",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTPlanItemControl_ManualActivationRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "manualActivationRule",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (tPlanItemDefinitionEClass, 
           source, 
           new String[] {
             "name", "tPlanItemDefinition",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTPlanItemDefinition_DefaultControl(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "defaultControl",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTPlanItemDefinition_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tPlanItemOnPartEClass, 
           source, 
           new String[] {
             "name", "tPlanItemOnPart",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTPlanItemOnPart_StandardEvent(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "standardEvent",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTPlanItemOnPart_SentryRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sentryRef"
           });	
        addAnnotation
          (getTPlanItemOnPart_SourceRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sourceRef"
           });	
        addAnnotation
          (tPlanItemStartTriggerEClass, 
           source, 
           new String[] {
             "name", "tPlanItemStartTrigger",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTPlanItemStartTrigger_StandardEvent(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "standardEvent",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTPlanItemStartTrigger_SourceRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sourceRef"
           });	
        addAnnotation
          (tPlanningTableEClass, 
           source, 
           new String[] {
             "name", "tPlanningTable",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTPlanningTable_TableItemGroup(), 
           source, 
           new String[] {
             "kind", "group",
             "name", "tableItem:group",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTPlanningTable_TableItem(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "tableItem",
             "namespace", "##targetNamespace",
             "group", "tableItem:group"
           });	
        addAnnotation
          (getTPlanningTable_ApplicabilityRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "applicabilityRule",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (tProcessEClass, 
           source, 
           new String[] {
             "name", "tProcess",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTProcess_Input(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "input",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTProcess_Output(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "output",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTProcess_ImplementationType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "implementationType"
           });	
        addAnnotation
          (getTProcess_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tProcessParameterEClass, 
           source, 
           new String[] {
             "name", "tProcessParameter",
             "kind", "empty"
           });	
        addAnnotation
          (tProcessTaskEClass, 
           source, 
           new String[] {
             "name", "tProcessTask",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTProcessTask_ParameterMapping(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "parameterMapping",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTProcessTask_ProcessRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "processRef"
           });	
        addAnnotation
          (tPropertyEClass, 
           source, 
           new String[] {
             "name", "tProperty",
             "kind", "empty"
           });	
        addAnnotation
          (getTProperty_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (getTProperty_Type(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "type"
           });	
        addAnnotation
          (tRepetitionRuleEClass, 
           source, 
           new String[] {
             "name", "tRepetitionRule",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTRepetitionRule_Condition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "condition",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTRepetitionRule_ContextRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "contextRef"
           });	
        addAnnotation
          (getTRepetitionRule_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tRequiredRuleEClass, 
           source, 
           new String[] {
             "name", "tRequiredRule",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTRequiredRule_Condition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "condition",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTRequiredRule_ContextRef(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "contextRef"
           });	
        addAnnotation
          (getTRequiredRule_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tRoleEClass, 
           source, 
           new String[] {
             "name", "tRole",
             "kind", "empty"
           });	
        addAnnotation
          (getTRole_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tSentryEClass, 
           source, 
           new String[] {
             "name", "tSentry",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTSentry_OnPartGroup(), 
           source, 
           new String[] {
             "kind", "group",
             "name", "onPart:group",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTSentry_OnPart(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "onPart",
             "namespace", "##targetNamespace",
             "group", "onPart:group"
           });	
        addAnnotation
          (getTSentry_IfPart(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "ifPart",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTSentry_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (tStageEClass, 
           source, 
           new String[] {
             "name", "tStage",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTStage_PlanningTable(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planningTable",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTStage_PlanItemDefinitionGroup(), 
           source, 
           new String[] {
             "kind", "group",
             "name", "planItemDefinition:group",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTStage_PlanItemDefinition(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "planItemDefinition",
             "namespace", "##targetNamespace",
             "group", "planItemDefinition:group"
           });	
        addAnnotation
          (getTStage_AutoComplete(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "autoComplete"
           });	
        addAnnotation
          (getTStage_ExitCriteriaRefs(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "exitCriteriaRefs"
           });	
        addAnnotation
          (tStartTriggerEClass, 
           source, 
           new String[] {
             "name", "tStartTrigger",
             "kind", "empty"
           });	
        addAnnotation
          (tTableItemEClass, 
           source, 
           new String[] {
             "name", "tTableItem",
             "kind", "empty"
           });	
        addAnnotation
          (getTTableItem_ApplicabilityRuleRefs(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "applicabilityRuleRefs"
           });	
        addAnnotation
          (getTTableItem_AuthorizedRoleRefs(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "authorizedRoleRefs"
           });	
        addAnnotation
          (tTaskEClass, 
           source, 
           new String[] {
             "name", "tTask",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTTask_Inputs(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "inputs",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTTask_Outputs(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "outputs",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTTask_IsBlocking(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "isBlocking"
           });	
        addAnnotation
          (tTimerEventEClass, 
           source, 
           new String[] {
             "name", "tTimerEvent",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getTTimerEvent_TimerExpression(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "timerExpression",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTTimerEvent_TimerStartGroup(), 
           source, 
           new String[] {
             "kind", "group",
             "name", "timerStart:group",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getTTimerEvent_TimerStart(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "timerStart",
             "namespace", "##targetNamespace",
             "group", "timerStart:group"
           });	
        addAnnotation
          (tUserEventEClass, 
           source, 
           new String[] {
             "name", "tUserEvent",
             "kind", "elementOnly"
           });
    }

} //Cmmn1PackageImpl
