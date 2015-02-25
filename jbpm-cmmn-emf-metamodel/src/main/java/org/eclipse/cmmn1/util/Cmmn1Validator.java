/**
 */
package org.eclipse.cmmn1.util;

import java.util.Map;

import org.eclipse.cmmn1.CaseFileItemTransition;
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
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.cmmn1.Cmmn1Package
 * @generated
 */
public class Cmmn1Validator extends EObjectValidator {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final Cmmn1Validator INSTANCE = new Cmmn1Validator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.cmmn1";

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * The cached base package validator.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XMLTypeValidator xmlTypeValidator;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cmmn1Validator() {
        super();
        xmlTypeValidator = XMLTypeValidator.INSTANCE;
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
      return Cmmn1Package.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case Cmmn1Package.DOCUMENT_ROOT:
                return validateDocumentRoot((DocumentRoot)value, diagnostics, context);
            case Cmmn1Package.TAPPLICABILITY_RULE:
                return validateTApplicabilityRule((TApplicabilityRule)value, diagnostics, context);
            case Cmmn1Package.TCASE:
                return validateTCase((TCase)value, diagnostics, context);
            case Cmmn1Package.TCASE_FILE:
                return validateTCaseFile((TCaseFile)value, diagnostics, context);
            case Cmmn1Package.TCASE_FILE_ITEM:
                return validateTCaseFileItem((TCaseFileItem)value, diagnostics, context);
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION:
                return validateTCaseFileItemDefinition((TCaseFileItemDefinition)value, diagnostics, context);
            case Cmmn1Package.TCASE_FILE_ITEM_ON_PART:
                return validateTCaseFileItemOnPart((TCaseFileItemOnPart)value, diagnostics, context);
            case Cmmn1Package.TCASE_FILE_ITEM_START_TRIGGER:
                return validateTCaseFileItemStartTrigger((TCaseFileItemStartTrigger)value, diagnostics, context);
            case Cmmn1Package.TCASE_PARAMETER:
                return validateTCaseParameter((TCaseParameter)value, diagnostics, context);
            case Cmmn1Package.TCASE_TASK:
                return validateTCaseTask((TCaseTask)value, diagnostics, context);
            case Cmmn1Package.TCHILDREN:
                return validateTChildren((TChildren)value, diagnostics, context);
            case Cmmn1Package.TCMMN_ELEMENT:
                return validateTCmmnElement((TCmmnElement)value, diagnostics, context);
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT:
                return validateTCmmnElementWithMixedContent((TCmmnElementWithMixedContent)value, diagnostics, context);
            case Cmmn1Package.TDEFINITIONS:
                return validateTDefinitions((TDefinitions)value, diagnostics, context);
            case Cmmn1Package.TDISCRETIONARY_ITEM:
                return validateTDiscretionaryItem((TDiscretionaryItem)value, diagnostics, context);
            case Cmmn1Package.TEVENT:
                return validateTEvent((TEvent)value, diagnostics, context);
            case Cmmn1Package.TEXPRESSION:
                return validateTExpression((TExpression)value, diagnostics, context);
            case Cmmn1Package.THUMAN_TASK:
                return validateTHumanTask((THumanTask)value, diagnostics, context);
            case Cmmn1Package.TIF_PART:
                return validateTIfPart((TIfPart)value, diagnostics, context);
            case Cmmn1Package.TIMPORT:
                return validateTImport((TImport)value, diagnostics, context);
            case Cmmn1Package.TMANUAL_ACTIVATION_RULE:
                return validateTManualActivationRule((TManualActivationRule)value, diagnostics, context);
            case Cmmn1Package.TMILESTONE:
                return validateTMilestone((TMilestone)value, diagnostics, context);
            case Cmmn1Package.TON_PART:
                return validateTOnPart((TOnPart)value, diagnostics, context);
            case Cmmn1Package.TPARAMETER:
                return validateTParameter((TParameter)value, diagnostics, context);
            case Cmmn1Package.TPARAMETER_MAPPING:
                return validateTParameterMapping((TParameterMapping)value, diagnostics, context);
            case Cmmn1Package.TPLAN_FRAGMENT:
                return validateTPlanFragment((TPlanFragment)value, diagnostics, context);
            case Cmmn1Package.TPLAN_ITEM:
                return validateTPlanItem((TPlanItem)value, diagnostics, context);
            case Cmmn1Package.TPLAN_ITEM_CONTROL:
                return validateTPlanItemControl((TPlanItemControl)value, diagnostics, context);
            case Cmmn1Package.TPLAN_ITEM_DEFINITION:
                return validateTPlanItemDefinition((TPlanItemDefinition)value, diagnostics, context);
            case Cmmn1Package.TPLAN_ITEM_ON_PART:
                return validateTPlanItemOnPart((TPlanItemOnPart)value, diagnostics, context);
            case Cmmn1Package.TPLAN_ITEM_START_TRIGGER:
                return validateTPlanItemStartTrigger((TPlanItemStartTrigger)value, diagnostics, context);
            case Cmmn1Package.TPLANNING_TABLE:
                return validateTPlanningTable((TPlanningTable)value, diagnostics, context);
            case Cmmn1Package.TPROCESS:
                return validateTProcess((TProcess)value, diagnostics, context);
            case Cmmn1Package.TPROCESS_PARAMETER:
                return validateTProcessParameter((TProcessParameter)value, diagnostics, context);
            case Cmmn1Package.TPROCESS_TASK:
                return validateTProcessTask((TProcessTask)value, diagnostics, context);
            case Cmmn1Package.TPROPERTY:
                return validateTProperty((TProperty)value, diagnostics, context);
            case Cmmn1Package.TREPETITION_RULE:
                return validateTRepetitionRule((TRepetitionRule)value, diagnostics, context);
            case Cmmn1Package.TREQUIRED_RULE:
                return validateTRequiredRule((TRequiredRule)value, diagnostics, context);
            case Cmmn1Package.TROLE:
                return validateTRole((TRole)value, diagnostics, context);
            case Cmmn1Package.TSENTRY:
                return validateTSentry((TSentry)value, diagnostics, context);
            case Cmmn1Package.TSTAGE:
                return validateTStage((TStage)value, diagnostics, context);
            case Cmmn1Package.TSTART_TRIGGER:
                return validateTStartTrigger((TStartTrigger)value, diagnostics, context);
            case Cmmn1Package.TTABLE_ITEM:
                return validateTTableItem((TTableItem)value, diagnostics, context);
            case Cmmn1Package.TTASK:
                return validateTTask((TTask)value, diagnostics, context);
            case Cmmn1Package.TTIMER_EVENT:
                return validateTTimerEvent((TTimerEvent)value, diagnostics, context);
            case Cmmn1Package.TUSER_EVENT:
                return validateTUserEvent((TUserEvent)value, diagnostics, context);
            case Cmmn1Package.CASE_FILE_ITEM_TRANSITION:
                return validateCaseFileItemTransition((CaseFileItemTransition)value, diagnostics, context);
            case Cmmn1Package.DEFINITION_TYPE_ENUM_MEMBER1:
                return validateDefinitionTypeEnumMember1((DefinitionTypeEnumMember1)value, diagnostics, context);
            case Cmmn1Package.MULTIPLICITY_ENUM:
                return validateMultiplicityEnum((MultiplicityEnum)value, diagnostics, context);
            case Cmmn1Package.PLAN_ITEM_TRANSITION:
                return validatePlanItemTransition((PlanItemTransition)value, diagnostics, context);
            case Cmmn1Package.PROCESS_TYPE_ENUM_MEMBER1:
                return validateProcessTypeEnumMember1((ProcessTypeEnumMember1)value, diagnostics, context);
            case Cmmn1Package.CASE_FILE_ITEM_TRANSITION_OBJECT:
                return validateCaseFileItemTransitionObject((CaseFileItemTransition)value, diagnostics, context);
            case Cmmn1Package.DEFINITION_TYPE_ENUM:
                return validateDefinitionTypeEnum(value, diagnostics, context);
            case Cmmn1Package.DEFINITION_TYPE_ENUM_MEMBER1_OBJECT:
                return validateDefinitionTypeEnumMember1Object((DefinitionTypeEnumMember1)value, diagnostics, context);
            case Cmmn1Package.MULTIPLICITY_ENUM_OBJECT:
                return validateMultiplicityEnumObject((MultiplicityEnum)value, diagnostics, context);
            case Cmmn1Package.PLAN_ITEM_TRANSITION_OBJECT:
                return validatePlanItemTransitionObject((PlanItemTransition)value, diagnostics, context);
            case Cmmn1Package.PROCESS_TYPE_ENUM:
                return validateProcessTypeEnum(value, diagnostics, context);
            case Cmmn1Package.PROCESS_TYPE_ENUM_MEMBER1_OBJECT:
                return validateProcessTypeEnumMember1Object((ProcessTypeEnumMember1)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDocumentRoot(DocumentRoot documentRoot, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(documentRoot, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTApplicabilityRule(TApplicabilityRule tApplicabilityRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tApplicabilityRule, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCase(TCase tCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCase, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCaseFile(TCaseFile tCaseFile, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCaseFile, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCaseFileItem(TCaseFileItem tCaseFileItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCaseFileItem, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCaseFileItemDefinition(TCaseFileItemDefinition tCaseFileItemDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCaseFileItemDefinition, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCaseFileItemOnPart(TCaseFileItemOnPart tCaseFileItemOnPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCaseFileItemOnPart, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCaseFileItemStartTrigger(TCaseFileItemStartTrigger tCaseFileItemStartTrigger, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCaseFileItemStartTrigger, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCaseParameter(TCaseParameter tCaseParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCaseParameter, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCaseTask(TCaseTask tCaseTask, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCaseTask, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTChildren(TChildren tChildren, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tChildren, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCmmnElement(TCmmnElement tCmmnElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCmmnElement, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTCmmnElementWithMixedContent(TCmmnElementWithMixedContent tCmmnElementWithMixedContent, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tCmmnElementWithMixedContent, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTDefinitions(TDefinitions tDefinitions, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tDefinitions, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTDiscretionaryItem(TDiscretionaryItem tDiscretionaryItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tDiscretionaryItem, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTEvent(TEvent tEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tEvent, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTExpression(TExpression tExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tExpression, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTHumanTask(THumanTask tHumanTask, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tHumanTask, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTIfPart(TIfPart tIfPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tIfPart, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTImport(TImport tImport, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tImport, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTManualActivationRule(TManualActivationRule tManualActivationRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tManualActivationRule, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTMilestone(TMilestone tMilestone, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tMilestone, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTOnPart(TOnPart tOnPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tOnPart, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTParameter(TParameter tParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tParameter, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTParameterMapping(TParameterMapping tParameterMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tParameterMapping, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTPlanFragment(TPlanFragment tPlanFragment, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tPlanFragment, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTPlanItem(TPlanItem tPlanItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tPlanItem, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTPlanItemControl(TPlanItemControl tPlanItemControl, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tPlanItemControl, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTPlanItemDefinition(TPlanItemDefinition tPlanItemDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tPlanItemDefinition, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTPlanItemOnPart(TPlanItemOnPart tPlanItemOnPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tPlanItemOnPart, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTPlanItemStartTrigger(TPlanItemStartTrigger tPlanItemStartTrigger, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tPlanItemStartTrigger, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTPlanningTable(TPlanningTable tPlanningTable, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tPlanningTable, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTProcess(TProcess tProcess, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tProcess, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTProcessParameter(TProcessParameter tProcessParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tProcessParameter, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTProcessTask(TProcessTask tProcessTask, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tProcessTask, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTProperty(TProperty tProperty, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tProperty, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTRepetitionRule(TRepetitionRule tRepetitionRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tRepetitionRule, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTRequiredRule(TRequiredRule tRequiredRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tRequiredRule, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTRole(TRole tRole, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tRole, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTSentry(TSentry tSentry, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tSentry, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTStage(TStage tStage, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tStage, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTStartTrigger(TStartTrigger tStartTrigger, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tStartTrigger, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTTableItem(TTableItem tTableItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tTableItem, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTTask(TTask tTask, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tTask, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTTimerEvent(TTimerEvent tTimerEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tTimerEvent, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTUserEvent(TUserEvent tUserEvent, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(tUserEvent, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCaseFileItemTransition(CaseFileItemTransition caseFileItemTransition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDefinitionTypeEnumMember1(DefinitionTypeEnumMember1 definitionTypeEnumMember1, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMultiplicityEnum(MultiplicityEnum multiplicityEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePlanItemTransition(PlanItemTransition planItemTransition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateProcessTypeEnumMember1(ProcessTypeEnumMember1 processTypeEnumMember1, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCaseFileItemTransitionObject(CaseFileItemTransition caseFileItemTransitionObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDefinitionTypeEnum(Object definitionTypeEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validateDefinitionTypeEnum_MemberTypes(definitionTypeEnum, diagnostics, context);
        return result;
    }

    /**
     * Validates the MemberTypes constraint of '<em>Definition Type Enum</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDefinitionTypeEnum_MemberTypes(Object definitionTypeEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (diagnostics != null) {
            BasicDiagnostic tempDiagnostics = new BasicDiagnostic();
            if (XMLTypePackage.Literals.ANY_URI.isInstance(definitionTypeEnum)) {
                if (xmlTypeValidator.validateAnyURI((String)definitionTypeEnum, tempDiagnostics, context)) return true;
            }
            if (Cmmn1Package.Literals.DEFINITION_TYPE_ENUM_MEMBER1.isInstance(definitionTypeEnum)) {
                if (validateDefinitionTypeEnumMember1((DefinitionTypeEnumMember1)definitionTypeEnum, tempDiagnostics, context)) return true;
            }
            for (Diagnostic diagnostic : tempDiagnostics.getChildren()) {
                diagnostics.add(diagnostic);
            }
        }
        else {
            if (XMLTypePackage.Literals.ANY_URI.isInstance(definitionTypeEnum)) {
                if (xmlTypeValidator.validateAnyURI((String)definitionTypeEnum, null, context)) return true;
            }
            if (Cmmn1Package.Literals.DEFINITION_TYPE_ENUM_MEMBER1.isInstance(definitionTypeEnum)) {
                if (validateDefinitionTypeEnumMember1((DefinitionTypeEnumMember1)definitionTypeEnum, null, context)) return true;
            }
        }
        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDefinitionTypeEnumMember1Object(DefinitionTypeEnumMember1 definitionTypeEnumMember1Object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMultiplicityEnumObject(MultiplicityEnum multiplicityEnumObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePlanItemTransitionObject(PlanItemTransition planItemTransitionObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateProcessTypeEnum(Object processTypeEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validateProcessTypeEnum_MemberTypes(processTypeEnum, diagnostics, context);
        return result;
    }

    /**
     * Validates the MemberTypes constraint of '<em>Process Type Enum</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateProcessTypeEnum_MemberTypes(Object processTypeEnum, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (diagnostics != null) {
            BasicDiagnostic tempDiagnostics = new BasicDiagnostic();
            if (XMLTypePackage.Literals.ANY_URI.isInstance(processTypeEnum)) {
                if (xmlTypeValidator.validateAnyURI((String)processTypeEnum, tempDiagnostics, context)) return true;
            }
            if (Cmmn1Package.Literals.PROCESS_TYPE_ENUM_MEMBER1.isInstance(processTypeEnum)) {
                if (validateProcessTypeEnumMember1((ProcessTypeEnumMember1)processTypeEnum, tempDiagnostics, context)) return true;
            }
            for (Diagnostic diagnostic : tempDiagnostics.getChildren()) {
                diagnostics.add(diagnostic);
            }
        }
        else {
            if (XMLTypePackage.Literals.ANY_URI.isInstance(processTypeEnum)) {
                if (xmlTypeValidator.validateAnyURI((String)processTypeEnum, null, context)) return true;
            }
            if (Cmmn1Package.Literals.PROCESS_TYPE_ENUM_MEMBER1.isInstance(processTypeEnum)) {
                if (validateProcessTypeEnumMember1((ProcessTypeEnumMember1)processTypeEnum, null, context)) return true;
            }
        }
        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateProcessTypeEnumMember1Object(ProcessTypeEnumMember1 processTypeEnumMember1Object, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

} //Cmmn1Validator
