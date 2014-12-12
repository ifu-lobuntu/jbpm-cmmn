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
import org.eclipse.cmmn1.TDefinitions;
import org.eclipse.cmmn1.TDiscretionaryItem;
import org.eclipse.cmmn1.TEvent;
import org.eclipse.cmmn1.TExpression;
import org.eclipse.cmmn1.THumanTask;
import org.eclipse.cmmn1.TIfPart;
import org.eclipse.cmmn1.TImport;
import org.eclipse.cmmn1.TManualActivationRule;
import org.eclipse.cmmn1.TMilestone;
import org.eclipse.cmmn1.TParameterMapping;
import org.eclipse.cmmn1.TPlanFragment;
import org.eclipse.cmmn1.TPlanItem;
import org.eclipse.cmmn1.TPlanItemControl;
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
import org.eclipse.cmmn1.TTask;
import org.eclipse.cmmn1.TTimerEvent;
import org.eclipse.cmmn1.TUserEvent;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Cmmn1FactoryImpl extends EFactoryImpl implements Cmmn1Factory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Cmmn1Factory init() {
        try {
            Cmmn1Factory theCmmn1Factory = (Cmmn1Factory)EPackage.Registry.INSTANCE.getEFactory(Cmmn1Package.eNS_URI);
            if (theCmmn1Factory != null) {
                return theCmmn1Factory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Cmmn1FactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cmmn1FactoryImpl() {
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
            case Cmmn1Package.DOCUMENT_ROOT: return createDocumentRoot();
            case Cmmn1Package.TAPPLICABILITY_RULE: return createTApplicabilityRule();
            case Cmmn1Package.TCASE: return createTCase();
            case Cmmn1Package.TCASE_FILE: return createTCaseFile();
            case Cmmn1Package.TCASE_FILE_ITEM: return createTCaseFileItem();
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION: return createTCaseFileItemDefinition();
            case Cmmn1Package.TCASE_FILE_ITEM_ON_PART: return createTCaseFileItemOnPart();
            case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER: return createTCaseFileItemStartTrigger();
            case Cmmn1Package.TCASE_PARAMETER: return createTCaseParameter();
            case Cmmn1Package.TCASE_TASK: return createTCaseTask();
            case Cmmn1Package.TCHILDREN: return createTChildren();
            case Cmmn1Package.TDEFINITIONS: return createTDefinitions();
            case Cmmn1Package.TDISCRETIONARY_ITEM: return createTDiscretionaryItem();
            case Cmmn1Package.TEVENT: return createTEvent();
            case Cmmn1Package.TEXPRESSION: return createTExpression();
            case Cmmn1Package.THUMAN_TASK: return createTHumanTask();
            case Cmmn1Package.TIF_PART: return createTIfPart();
            case Cmmn1Package.TIMPORT: return createTImport();
            case Cmmn1Package.TMANUAL_ACTIVATION_RULE: return createTManualActivationRule();
            case Cmmn1Package.TMILESTONE: return createTMilestone();
            case Cmmn1Package.TPARAMETER_MAPPING: return createTParameterMapping();
            case Cmmn1Package.TPLAN_FRAGMENT: return createTPlanFragment();
            case Cmmn1Package.TPLAN_ITEM: return createTPlanItem();
            case Cmmn1Package.TPLAN_ITEM_CONTROL: return createTPlanItemControl();
            case Cmmn1Package.TPLAN_ITEM_ON_PART: return createTPlanItemOnPart();
            case Cmmn1Package.TPLAN_ITEM_START_TRIGGER: return createTPlanItemStartTrigger();
            case Cmmn1Package.TPLANNING_TABLE: return createTPlanningTable();
            case Cmmn1Package.TPROCESS: return createTProcess();
            case Cmmn1Package.TPROCESS_PARAMETER: return createTProcessParameter();
            case Cmmn1Package.TPROCESS_TASK: return createTProcessTask();
            case Cmmn1Package.TPROPERTY: return createTProperty();
            case Cmmn1Package.TREPETITION_RULE: return createTRepetitionRule();
            case Cmmn1Package.TREQUIRED_RULE: return createTRequiredRule();
            case Cmmn1Package.TROLE: return createTRole();
            case Cmmn1Package.TSENTRY: return createTSentry();
            case Cmmn1Package.TSTAGE: return createTStage();
            case Cmmn1Package.TTASK: return createTTask();
            case Cmmn1Package.TTIMER_EVENT: return createTTimerEvent();
            case Cmmn1Package.TUSER_EVENT: return createTUserEvent();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case Cmmn1Package.CASE_FILE_ITEM_TRANSITION:
                return createCaseFileItemTransitionFromString(eDataType, initialValue);
            case Cmmn1Package.DEFINITION_TYPE_ENUM_MEMBER1:
                return createDefinitionTypeEnumMember1FromString(eDataType, initialValue);
            case Cmmn1Package.MULTIPLICITY_ENUM:
                return createMultiplicityEnumFromString(eDataType, initialValue);
            case Cmmn1Package.PLAN_ITEM_TRANSITION:
                return createPlanItemTransitionFromString(eDataType, initialValue);
            case Cmmn1Package.PROCESS_TYPE_ENUM_MEMBER1:
                return createProcessTypeEnumMember1FromString(eDataType, initialValue);
            case Cmmn1Package.CASE_FILE_ITEM_TRANSITION_OBJECT:
                return createCaseFileItemTransitionObjectFromString(eDataType, initialValue);
            case Cmmn1Package.DEFINITION_TYPE_ENUM:
                return createDefinitionTypeEnumFromString(eDataType, initialValue);
            case Cmmn1Package.DEFINITION_TYPE_ENUM_MEMBER1_OBJECT:
                return createDefinitionTypeEnumMember1ObjectFromString(eDataType, initialValue);
            case Cmmn1Package.MULTIPLICITY_ENUM_OBJECT:
                return createMultiplicityEnumObjectFromString(eDataType, initialValue);
            case Cmmn1Package.PLAN_ITEM_TRANSITION_OBJECT:
                return createPlanItemTransitionObjectFromString(eDataType, initialValue);
            case Cmmn1Package.PROCESS_TYPE_ENUM:
                return createProcessTypeEnumFromString(eDataType, initialValue);
            case Cmmn1Package.PROCESS_TYPE_ENUM_MEMBER1_OBJECT:
                return createProcessTypeEnumMember1ObjectFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case Cmmn1Package.CASE_FILE_ITEM_TRANSITION:
                return convertCaseFileItemTransitionToString(eDataType, instanceValue);
            case Cmmn1Package.DEFINITION_TYPE_ENUM_MEMBER1:
                return convertDefinitionTypeEnumMember1ToString(eDataType, instanceValue);
            case Cmmn1Package.MULTIPLICITY_ENUM:
                return convertMultiplicityEnumToString(eDataType, instanceValue);
            case Cmmn1Package.PLAN_ITEM_TRANSITION:
                return convertPlanItemTransitionToString(eDataType, instanceValue);
            case Cmmn1Package.PROCESS_TYPE_ENUM_MEMBER1:
                return convertProcessTypeEnumMember1ToString(eDataType, instanceValue);
            case Cmmn1Package.CASE_FILE_ITEM_TRANSITION_OBJECT:
                return convertCaseFileItemTransitionObjectToString(eDataType, instanceValue);
            case Cmmn1Package.DEFINITION_TYPE_ENUM:
                return convertDefinitionTypeEnumToString(eDataType, instanceValue);
            case Cmmn1Package.DEFINITION_TYPE_ENUM_MEMBER1_OBJECT:
                return convertDefinitionTypeEnumMember1ObjectToString(eDataType, instanceValue);
            case Cmmn1Package.MULTIPLICITY_ENUM_OBJECT:
                return convertMultiplicityEnumObjectToString(eDataType, instanceValue);
            case Cmmn1Package.PLAN_ITEM_TRANSITION_OBJECT:
                return convertPlanItemTransitionObjectToString(eDataType, instanceValue);
            case Cmmn1Package.PROCESS_TYPE_ENUM:
                return convertProcessTypeEnumToString(eDataType, instanceValue);
            case Cmmn1Package.PROCESS_TYPE_ENUM_MEMBER1_OBJECT:
                return convertProcessTypeEnumMember1ObjectToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
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
    public TApplicabilityRule createTApplicabilityRule() {
        TApplicabilityRuleImpl tApplicabilityRule = new TApplicabilityRuleImpl();
        return tApplicabilityRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCase createTCase() {
        TCaseImpl tCase = new TCaseImpl();
        return tCase;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFile createTCaseFile() {
        TCaseFileImpl tCaseFile = new TCaseFileImpl();
        return tCaseFile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItem createTCaseFileItem() {
        TCaseFileItemImpl tCaseFileItem = new TCaseFileItemImpl();
        return tCaseFileItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItemDefinition createTCaseFileItemDefinition() {
        TCaseFileItemDefinitionImpl tCaseFileItemDefinition = new TCaseFileItemDefinitionImpl();
        return tCaseFileItemDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItemOnPart createTCaseFileItemOnPart() {
        TCaseFileItemOnPartImpl tCaseFileItemOnPart = new TCaseFileItemOnPartImpl();
        return tCaseFileItemOnPart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItemStartTrigger createTCaseFileItemStartTrigger() {
        TCaseFileItemStartTriggerImpl tCaseFileItemStartTrigger = new TCaseFileItemStartTriggerImpl();
        return tCaseFileItemStartTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseParameter createTCaseParameter() {
        TCaseParameterImpl tCaseParameter = new TCaseParameterImpl();
        return tCaseParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseTask createTCaseTask() {
        TCaseTaskImpl tCaseTask = new TCaseTaskImpl();
        return tCaseTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TChildren createTChildren() {
        TChildrenImpl tChildren = new TChildrenImpl();
        return tChildren;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TDefinitions createTDefinitions() {
        TDefinitionsImpl tDefinitions = new TDefinitionsImpl();
        return tDefinitions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TDiscretionaryItem createTDiscretionaryItem() {
        TDiscretionaryItemImpl tDiscretionaryItem = new TDiscretionaryItemImpl();
        return tDiscretionaryItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TEvent createTEvent() {
        TEventImpl tEvent = new TEventImpl();
        return tEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TExpression createTExpression() {
        TExpressionImpl tExpression = new TExpressionImpl();
        return tExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public THumanTask createTHumanTask() {
        THumanTaskImpl tHumanTask = new THumanTaskImpl();
        return tHumanTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TIfPart createTIfPart() {
        TIfPartImpl tIfPart = new TIfPartImpl();
        return tIfPart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TImport createTImport() {
        TImportImpl tImport = new TImportImpl();
        return tImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TManualActivationRule createTManualActivationRule() {
        TManualActivationRuleImpl tManualActivationRule = new TManualActivationRuleImpl();
        return tManualActivationRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TMilestone createTMilestone() {
        TMilestoneImpl tMilestone = new TMilestoneImpl();
        return tMilestone;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TParameterMapping createTParameterMapping() {
        TParameterMappingImpl tParameterMapping = new TParameterMappingImpl();
        return tParameterMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanFragment createTPlanFragment() {
        TPlanFragmentImpl tPlanFragment = new TPlanFragmentImpl();
        return tPlanFragment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItem createTPlanItem() {
        TPlanItemImpl tPlanItem = new TPlanItemImpl();
        return tPlanItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItemControl createTPlanItemControl() {
        TPlanItemControlImpl tPlanItemControl = new TPlanItemControlImpl();
        return tPlanItemControl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItemOnPart createTPlanItemOnPart() {
        TPlanItemOnPartImpl tPlanItemOnPart = new TPlanItemOnPartImpl();
        return tPlanItemOnPart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItemStartTrigger createTPlanItemStartTrigger() {
        TPlanItemStartTriggerImpl tPlanItemStartTrigger = new TPlanItemStartTriggerImpl();
        return tPlanItemStartTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanningTable createTPlanningTable() {
        TPlanningTableImpl tPlanningTable = new TPlanningTableImpl();
        return tPlanningTable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TProcess createTProcess() {
        TProcessImpl tProcess = new TProcessImpl();
        return tProcess;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TProcessParameter createTProcessParameter() {
        TProcessParameterImpl tProcessParameter = new TProcessParameterImpl();
        return tProcessParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TProcessTask createTProcessTask() {
        TProcessTaskImpl tProcessTask = new TProcessTaskImpl();
        return tProcessTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TProperty createTProperty() {
        TPropertyImpl tProperty = new TPropertyImpl();
        return tProperty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRepetitionRule createTRepetitionRule() {
        TRepetitionRuleImpl tRepetitionRule = new TRepetitionRuleImpl();
        return tRepetitionRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRequiredRule createTRequiredRule() {
        TRequiredRuleImpl tRequiredRule = new TRequiredRuleImpl();
        return tRequiredRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRole createTRole() {
        TRoleImpl tRole = new TRoleImpl();
        return tRole;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TSentry createTSentry() {
        TSentryImpl tSentry = new TSentryImpl();
        return tSentry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TStage createTStage() {
        TStageImpl tStage = new TStageImpl();
        return tStage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TTask createTTask() {
        TTaskImpl tTask = new TTaskImpl();
        return tTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TTimerEvent createTTimerEvent() {
        TTimerEventImpl tTimerEvent = new TTimerEventImpl();
        return tTimerEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TUserEvent createTUserEvent() {
        TUserEventImpl tUserEvent = new TUserEventImpl();
        return tUserEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CaseFileItemTransition createCaseFileItemTransitionFromString(EDataType eDataType, String initialValue) {
        CaseFileItemTransition result = CaseFileItemTransition.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertCaseFileItemTransitionToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DefinitionTypeEnumMember1 createDefinitionTypeEnumMember1FromString(EDataType eDataType, String initialValue) {
        DefinitionTypeEnumMember1 result = DefinitionTypeEnumMember1.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDefinitionTypeEnumMember1ToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MultiplicityEnum createMultiplicityEnumFromString(EDataType eDataType, String initialValue) {
        MultiplicityEnum result = MultiplicityEnum.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertMultiplicityEnumToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PlanItemTransition createPlanItemTransitionFromString(EDataType eDataType, String initialValue) {
        PlanItemTransition result = PlanItemTransition.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPlanItemTransitionToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessTypeEnumMember1 createProcessTypeEnumMember1FromString(EDataType eDataType, String initialValue) {
        ProcessTypeEnumMember1 result = ProcessTypeEnumMember1.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertProcessTypeEnumMember1ToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CaseFileItemTransition createCaseFileItemTransitionObjectFromString(EDataType eDataType, String initialValue) {
        return createCaseFileItemTransitionFromString(Cmmn1Package.Literals.CASE_FILE_ITEM_TRANSITION, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertCaseFileItemTransitionObjectToString(EDataType eDataType, Object instanceValue) {
        return convertCaseFileItemTransitionToString(Cmmn1Package.Literals.CASE_FILE_ITEM_TRANSITION, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object createDefinitionTypeEnumFromString(EDataType eDataType, String initialValue) {
        if (initialValue == null) return null;
        Object result = null;
        RuntimeException exception = null;
        try {
            result = XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.ANY_URI, initialValue);
            if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
                return result;
            }
        }
        catch (RuntimeException e) {
            exception = e;
        }
        try {
            result = createDefinitionTypeEnumMember1FromString(Cmmn1Package.Literals.DEFINITION_TYPE_ENUM_MEMBER1, initialValue);
            if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
                return result;
            }
        }
        catch (RuntimeException e) {
            exception = e;
        }
        if (result != null || exception == null) return result;
    
        throw exception;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDefinitionTypeEnumToString(EDataType eDataType, Object instanceValue) {
        if (instanceValue == null) return null;
        if (XMLTypePackage.Literals.ANY_URI.isInstance(instanceValue)) {
            try {
                String value = XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.ANY_URI, instanceValue);
                if (value != null) return value;
            }
            catch (Exception e) {
                // Keep trying other member types until all have failed.
            }
        }
        if (Cmmn1Package.Literals.DEFINITION_TYPE_ENUM_MEMBER1.isInstance(instanceValue)) {
            try {
                String value = convertDefinitionTypeEnumMember1ToString(Cmmn1Package.Literals.DEFINITION_TYPE_ENUM_MEMBER1, instanceValue);
                if (value != null) return value;
            }
            catch (Exception e) {
                // Keep trying other member types until all have failed.
            }
        }
        throw new IllegalArgumentException("Invalid value: '"+instanceValue+"' for datatype :"+eDataType.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DefinitionTypeEnumMember1 createDefinitionTypeEnumMember1ObjectFromString(EDataType eDataType, String initialValue) {
        return createDefinitionTypeEnumMember1FromString(Cmmn1Package.Literals.DEFINITION_TYPE_ENUM_MEMBER1, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDefinitionTypeEnumMember1ObjectToString(EDataType eDataType, Object instanceValue) {
        return convertDefinitionTypeEnumMember1ToString(Cmmn1Package.Literals.DEFINITION_TYPE_ENUM_MEMBER1, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MultiplicityEnum createMultiplicityEnumObjectFromString(EDataType eDataType, String initialValue) {
        return createMultiplicityEnumFromString(Cmmn1Package.Literals.MULTIPLICITY_ENUM, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertMultiplicityEnumObjectToString(EDataType eDataType, Object instanceValue) {
        return convertMultiplicityEnumToString(Cmmn1Package.Literals.MULTIPLICITY_ENUM, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PlanItemTransition createPlanItemTransitionObjectFromString(EDataType eDataType, String initialValue) {
        return createPlanItemTransitionFromString(Cmmn1Package.Literals.PLAN_ITEM_TRANSITION, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPlanItemTransitionObjectToString(EDataType eDataType, Object instanceValue) {
        return convertPlanItemTransitionToString(Cmmn1Package.Literals.PLAN_ITEM_TRANSITION, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object createProcessTypeEnumFromString(EDataType eDataType, String initialValue) {
        if (initialValue == null) return null;
        Object result = null;
        RuntimeException exception = null;
        try {
            result = XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.ANY_URI, initialValue);
            if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
                return result;
            }
        }
        catch (RuntimeException e) {
            exception = e;
        }
        try {
            result = createProcessTypeEnumMember1FromString(Cmmn1Package.Literals.PROCESS_TYPE_ENUM_MEMBER1, initialValue);
            if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
                return result;
            }
        }
        catch (RuntimeException e) {
            exception = e;
        }
        if (result != null || exception == null) return result;
    
        throw exception;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertProcessTypeEnumToString(EDataType eDataType, Object instanceValue) {
        if (instanceValue == null) return null;
        if (XMLTypePackage.Literals.ANY_URI.isInstance(instanceValue)) {
            try {
                String value = XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.ANY_URI, instanceValue);
                if (value != null) return value;
            }
            catch (Exception e) {
                // Keep trying other member types until all have failed.
            }
        }
        if (Cmmn1Package.Literals.PROCESS_TYPE_ENUM_MEMBER1.isInstance(instanceValue)) {
            try {
                String value = convertProcessTypeEnumMember1ToString(Cmmn1Package.Literals.PROCESS_TYPE_ENUM_MEMBER1, instanceValue);
                if (value != null) return value;
            }
            catch (Exception e) {
                // Keep trying other member types until all have failed.
            }
        }
        throw new IllegalArgumentException("Invalid value: '"+instanceValue+"' for datatype :"+eDataType.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessTypeEnumMember1 createProcessTypeEnumMember1ObjectFromString(EDataType eDataType, String initialValue) {
        return createProcessTypeEnumMember1FromString(Cmmn1Package.Literals.PROCESS_TYPE_ENUM_MEMBER1, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertProcessTypeEnumMember1ObjectToString(EDataType eDataType, Object instanceValue) {
        return convertProcessTypeEnumMember1ToString(Cmmn1Package.Literals.PROCESS_TYPE_ENUM_MEMBER1, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cmmn1Package getCmmn1Package() {
        return (Cmmn1Package)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static Cmmn1Package getPackage() {
        return Cmmn1Package.eINSTANCE;
    }

} //Cmmn1FactoryImpl
