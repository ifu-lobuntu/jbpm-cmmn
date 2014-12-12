/**
 */
package org.eclipse.cmmn1.impl;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.DocumentRoot;
import org.eclipse.cmmn1.TApplicabilityRule;
import org.eclipse.cmmn1.TCase;
import org.eclipse.cmmn1.TCaseFile;
import org.eclipse.cmmn1.TCaseFileItem;
import org.eclipse.cmmn1.TCaseFileItemDefinition;
import org.eclipse.cmmn1.TCaseFileItemOnPart;
import org.eclipse.cmmn1.TCaseFileItemStartTrigger;
import org.eclipse.cmmn1.TCaseParameter;
import org.eclipse.cmmn1.TCaseTask;
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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getApplicabilityRule <em>Applicability Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getCase <em>Case</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getCaseFile <em>Case File</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getCaseFileItem <em>Case File Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getCaseFileItemDefinition <em>Case File Item Definition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getCaseFileItemOnPart <em>Case File Item On Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getOnPart <em>On Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getCaseFileItemStartTrigger <em>Case File Item Start Trigger</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getTimerStart <em>Timer Start</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getCaseParameter <em>Case Parameter</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getCaseTask <em>Case Task</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getTask <em>Task</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getPlanItemDefinition <em>Plan Item Definition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getDiscretionaryItem <em>Discretionary Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getTableItem <em>Table Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getHumanTask <em>Human Task</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getIfPart <em>If Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getManualActivationRule <em>Manual Activation Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getMilestone <em>Milestone</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getPlanFragment <em>Plan Fragment</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getPlanItem <em>Plan Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getPlanItemControl <em>Plan Item Control</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getPlanItemOnPart <em>Plan Item On Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getPlanItemStartTrigger <em>Plan Item Start Trigger</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getPlanningTable <em>Planning Table</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getProcessParameter <em>Process Parameter</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getProcessTask <em>Process Task</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getRepetitionRule <em>Repetition Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getRequiredRule <em>Required Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getSentry <em>Sentry</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getTimerEvent <em>Timer Event</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.DocumentRootImpl#getUserEvent <em>User Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
    /**
     * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMixed()
     * @generated
     * @ordered
     */
    protected FeatureMap mixed;

    /**
     * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXMLNSPrefixMap()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xMLNSPrefixMap;

    /**
     * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXSISchemaLocation()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xSISchemaLocation;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocumentRootImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.DOCUMENT_ROOT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getMixed() {
        if (mixed == null) {
            mixed = new BasicFeatureMap(this, Cmmn1Package.DOCUMENT_ROOT__MIXED);
        }
        return mixed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getXMLNSPrefixMap() {
        if (xMLNSPrefixMap == null) {
            xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Cmmn1Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        }
        return xMLNSPrefixMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getXSISchemaLocation() {
        if (xSISchemaLocation == null) {
            xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Cmmn1Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        }
        return xSISchemaLocation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TApplicabilityRule getApplicabilityRule() {
        return (TApplicabilityRule)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__APPLICABILITY_RULE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetApplicabilityRule(TApplicabilityRule newApplicabilityRule, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__APPLICABILITY_RULE, newApplicabilityRule, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setApplicabilityRule(TApplicabilityRule newApplicabilityRule) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__APPLICABILITY_RULE, newApplicabilityRule);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCase getCase() {
        return (TCase)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCase(TCase newCase, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE, newCase, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCase(TCase newCase) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE, newCase);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFile getCaseFile() {
        return (TCaseFile)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCaseFile(TCaseFile newCaseFile, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE, newCaseFile, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCaseFile(TCaseFile newCaseFile) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE, newCaseFile);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItem getCaseFileItem() {
        return (TCaseFileItem)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCaseFileItem(TCaseFileItem newCaseFileItem, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM, newCaseFileItem, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCaseFileItem(TCaseFileItem newCaseFileItem) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM, newCaseFileItem);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItemDefinition getCaseFileItemDefinition() {
        return (TCaseFileItemDefinition)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCaseFileItemDefinition(TCaseFileItemDefinition newCaseFileItemDefinition, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION, newCaseFileItemDefinition, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCaseFileItemDefinition(TCaseFileItemDefinition newCaseFileItemDefinition) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION, newCaseFileItemDefinition);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItemOnPart getCaseFileItemOnPart() {
        return (TCaseFileItemOnPart)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCaseFileItemOnPart(TCaseFileItemOnPart newCaseFileItemOnPart, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART, newCaseFileItemOnPart, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCaseFileItemOnPart(TCaseFileItemOnPart newCaseFileItemOnPart) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART, newCaseFileItemOnPart);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TOnPart getOnPart() {
        return (TOnPart)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__ON_PART, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOnPart(TOnPart newOnPart, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__ON_PART, newOnPart, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnPart(TOnPart newOnPart) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__ON_PART, newOnPart);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItemStartTrigger getCaseFileItemStartTrigger() {
        return (TCaseFileItemStartTrigger)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCaseFileItemStartTrigger(TCaseFileItemStartTrigger newCaseFileItemStartTrigger, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER, newCaseFileItemStartTrigger, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCaseFileItemStartTrigger(TCaseFileItemStartTrigger newCaseFileItemStartTrigger) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER, newCaseFileItemStartTrigger);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TStartTrigger getTimerStart() {
        return (TStartTrigger)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__TIMER_START, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTimerStart(TStartTrigger newTimerStart, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__TIMER_START, newTimerStart, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimerStart(TStartTrigger newTimerStart) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__TIMER_START, newTimerStart);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseParameter getCaseParameter() {
        return (TCaseParameter)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_PARAMETER, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCaseParameter(TCaseParameter newCaseParameter, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_PARAMETER, newCaseParameter, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCaseParameter(TCaseParameter newCaseParameter) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_PARAMETER, newCaseParameter);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TParameter getParameter() {
        return (TParameter)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PARAMETER, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(TParameter newParameter, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PARAMETER, newParameter, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(TParameter newParameter) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PARAMETER, newParameter);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseTask getCaseTask() {
        return (TCaseTask)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_TASK, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCaseTask(TCaseTask newCaseTask, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_TASK, newCaseTask, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCaseTask(TCaseTask newCaseTask) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__CASE_TASK, newCaseTask);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TTask getTask() {
        return (TTask)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__TASK, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTask(TTask newTask, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__TASK, newTask, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTask(TTask newTask) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__TASK, newTask);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItemDefinition getPlanItemDefinition() {
        return (TPlanItemDefinition)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_DEFINITION, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlanItemDefinition(TPlanItemDefinition newPlanItemDefinition, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_DEFINITION, newPlanItemDefinition, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlanItemDefinition(TPlanItemDefinition newPlanItemDefinition) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_DEFINITION, newPlanItemDefinition);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TDefinitions getDefinitions() {
        return (TDefinitions)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__DEFINITIONS, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefinitions(TDefinitions newDefinitions, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__DEFINITIONS, newDefinitions, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefinitions(TDefinitions newDefinitions) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__DEFINITIONS, newDefinitions);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TDiscretionaryItem getDiscretionaryItem() {
        return (TDiscretionaryItem)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__DISCRETIONARY_ITEM, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDiscretionaryItem(TDiscretionaryItem newDiscretionaryItem, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__DISCRETIONARY_ITEM, newDiscretionaryItem, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDiscretionaryItem(TDiscretionaryItem newDiscretionaryItem) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__DISCRETIONARY_ITEM, newDiscretionaryItem);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TTableItem getTableItem() {
        return (TTableItem)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__TABLE_ITEM, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTableItem(TTableItem newTableItem, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__TABLE_ITEM, newTableItem, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTableItem(TTableItem newTableItem) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__TABLE_ITEM, newTableItem);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TEvent getEvent() {
        return (TEvent)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__EVENT, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEvent(TEvent newEvent, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__EVENT, newEvent, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEvent(TEvent newEvent) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__EVENT, newEvent);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TExpression getExpression() {
        return (TExpression)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__EXPRESSION, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetExpression(TExpression newExpression, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__EXPRESSION, newExpression, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpression(TExpression newExpression) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__EXPRESSION, newExpression);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public THumanTask getHumanTask() {
        return (THumanTask)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__HUMAN_TASK, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetHumanTask(THumanTask newHumanTask, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__HUMAN_TASK, newHumanTask, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHumanTask(THumanTask newHumanTask) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__HUMAN_TASK, newHumanTask);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TIfPart getIfPart() {
        return (TIfPart)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__IF_PART, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetIfPart(TIfPart newIfPart, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__IF_PART, newIfPart, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIfPart(TIfPart newIfPart) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__IF_PART, newIfPart);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TImport getImport() {
        return (TImport)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__IMPORT, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetImport(TImport newImport, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__IMPORT, newImport, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImport(TImport newImport) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__IMPORT, newImport);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TManualActivationRule getManualActivationRule() {
        return (TManualActivationRule)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetManualActivationRule(TManualActivationRule newManualActivationRule, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE, newManualActivationRule, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setManualActivationRule(TManualActivationRule newManualActivationRule) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE, newManualActivationRule);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TMilestone getMilestone() {
        return (TMilestone)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__MILESTONE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMilestone(TMilestone newMilestone, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__MILESTONE, newMilestone, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMilestone(TMilestone newMilestone) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__MILESTONE, newMilestone);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TParameterMapping getParameterMapping() {
        return (TParameterMapping)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PARAMETER_MAPPING, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameterMapping(TParameterMapping newParameterMapping, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PARAMETER_MAPPING, newParameterMapping, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameterMapping(TParameterMapping newParameterMapping) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PARAMETER_MAPPING, newParameterMapping);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanFragment getPlanFragment() {
        return (TPlanFragment)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_FRAGMENT, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlanFragment(TPlanFragment newPlanFragment, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_FRAGMENT, newPlanFragment, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlanFragment(TPlanFragment newPlanFragment) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_FRAGMENT, newPlanFragment);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItem getPlanItem() {
        return (TPlanItem)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlanItem(TPlanItem newPlanItem, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM, newPlanItem, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlanItem(TPlanItem newPlanItem) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM, newPlanItem);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItemControl getPlanItemControl() {
        return (TPlanItemControl)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_CONTROL, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlanItemControl(TPlanItemControl newPlanItemControl, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_CONTROL, newPlanItemControl, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlanItemControl(TPlanItemControl newPlanItemControl) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_CONTROL, newPlanItemControl);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItemOnPart getPlanItemOnPart() {
        return (TPlanItemOnPart)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_ON_PART, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlanItemOnPart(TPlanItemOnPart newPlanItemOnPart, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_ON_PART, newPlanItemOnPart, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlanItemOnPart(TPlanItemOnPart newPlanItemOnPart) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_ON_PART, newPlanItemOnPart);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanItemStartTrigger getPlanItemStartTrigger() {
        return (TPlanItemStartTrigger)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlanItemStartTrigger(TPlanItemStartTrigger newPlanItemStartTrigger, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER, newPlanItemStartTrigger, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlanItemStartTrigger(TPlanItemStartTrigger newPlanItemStartTrigger) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER, newPlanItemStartTrigger);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanningTable getPlanningTable() {
        return (TPlanningTable)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PLANNING_TABLE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlanningTable(TPlanningTable newPlanningTable, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PLANNING_TABLE, newPlanningTable, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlanningTable(TPlanningTable newPlanningTable) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PLANNING_TABLE, newPlanningTable);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TProcess getProcess() {
        return (TProcess)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProcess(TProcess newProcess, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS, newProcess, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProcess(TProcess newProcess) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS, newProcess);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TProcessParameter getProcessParameter() {
        return (TProcessParameter)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS_PARAMETER, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProcessParameter(TProcessParameter newProcessParameter, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS_PARAMETER, newProcessParameter, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProcessParameter(TProcessParameter newProcessParameter) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS_PARAMETER, newProcessParameter);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TProcessTask getProcessTask() {
        return (TProcessTask)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS_TASK, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProcessTask(TProcessTask newProcessTask, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS_TASK, newProcessTask, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProcessTask(TProcessTask newProcessTask) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PROCESS_TASK, newProcessTask);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TProperty getProperty() {
        return (TProperty)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__PROPERTY, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProperty(TProperty newProperty, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__PROPERTY, newProperty, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProperty(TProperty newProperty) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__PROPERTY, newProperty);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRepetitionRule getRepetitionRule() {
        return (TRepetitionRule)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__REPETITION_RULE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRepetitionRule(TRepetitionRule newRepetitionRule, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__REPETITION_RULE, newRepetitionRule, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRepetitionRule(TRepetitionRule newRepetitionRule) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__REPETITION_RULE, newRepetitionRule);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRequiredRule getRequiredRule() {
        return (TRequiredRule)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__REQUIRED_RULE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRequiredRule(TRequiredRule newRequiredRule, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__REQUIRED_RULE, newRequiredRule, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequiredRule(TRequiredRule newRequiredRule) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__REQUIRED_RULE, newRequiredRule);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TRole getRole() {
        return (TRole)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__ROLE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRole(TRole newRole, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__ROLE, newRole, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRole(TRole newRole) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__ROLE, newRole);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TSentry getSentry() {
        return (TSentry)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__SENTRY, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSentry(TSentry newSentry, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__SENTRY, newSentry, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSentry(TSentry newSentry) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__SENTRY, newSentry);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TStage getStage() {
        return (TStage)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__STAGE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStage(TStage newStage, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__STAGE, newStage, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStage(TStage newStage) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__STAGE, newStage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TTimerEvent getTimerEvent() {
        return (TTimerEvent)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__TIMER_EVENT, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTimerEvent(TTimerEvent newTimerEvent, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__TIMER_EVENT, newTimerEvent, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimerEvent(TTimerEvent newTimerEvent) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__TIMER_EVENT, newTimerEvent);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TUserEvent getUserEvent() {
        return (TUserEvent)getMixed().get(Cmmn1Package.Literals.DOCUMENT_ROOT__USER_EVENT, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUserEvent(TUserEvent newUserEvent, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(Cmmn1Package.Literals.DOCUMENT_ROOT__USER_EVENT, newUserEvent, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUserEvent(TUserEvent newUserEvent) {
        ((FeatureMap.Internal)getMixed()).set(Cmmn1Package.Literals.DOCUMENT_ROOT__USER_EVENT, newUserEvent);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.DOCUMENT_ROOT__MIXED:
                return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__APPLICABILITY_RULE:
                return basicSetApplicabilityRule(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__CASE:
                return basicSetCase(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE:
                return basicSetCaseFile(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM:
                return basicSetCaseFileItem(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION:
                return basicSetCaseFileItemDefinition(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART:
                return basicSetCaseFileItemOnPart(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__ON_PART:
                return basicSetOnPart(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER:
                return basicSetCaseFileItemStartTrigger(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_START:
                return basicSetTimerStart(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__CASE_PARAMETER:
                return basicSetCaseParameter(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER:
                return basicSetParameter(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__CASE_TASK:
                return basicSetCaseTask(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__TASK:
                return basicSetTask(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_DEFINITION:
                return basicSetPlanItemDefinition(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__DEFINITIONS:
                return basicSetDefinitions(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__DISCRETIONARY_ITEM:
                return basicSetDiscretionaryItem(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__TABLE_ITEM:
                return basicSetTableItem(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__EVENT:
                return basicSetEvent(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__EXPRESSION:
                return basicSetExpression(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__HUMAN_TASK:
                return basicSetHumanTask(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__IF_PART:
                return basicSetIfPart(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__IMPORT:
                return basicSetImport(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE:
                return basicSetManualActivationRule(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__MILESTONE:
                return basicSetMilestone(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER_MAPPING:
                return basicSetParameterMapping(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_FRAGMENT:
                return basicSetPlanFragment(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM:
                return basicSetPlanItem(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_CONTROL:
                return basicSetPlanItemControl(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_ON_PART:
                return basicSetPlanItemOnPart(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER:
                return basicSetPlanItemStartTrigger(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PLANNING_TABLE:
                return basicSetPlanningTable(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS:
                return basicSetProcess(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_PARAMETER:
                return basicSetProcessParameter(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_TASK:
                return basicSetProcessTask(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__PROPERTY:
                return basicSetProperty(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__REPETITION_RULE:
                return basicSetRepetitionRule(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__REQUIRED_RULE:
                return basicSetRequiredRule(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__ROLE:
                return basicSetRole(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__SENTRY:
                return basicSetSentry(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__STAGE:
                return basicSetStage(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_EVENT:
                return basicSetTimerEvent(null, msgs);
            case Cmmn1Package.DOCUMENT_ROOT__USER_EVENT:
                return basicSetUserEvent(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case Cmmn1Package.DOCUMENT_ROOT__MIXED:
                if (coreType) return getMixed();
                return ((FeatureMap.Internal)getMixed()).getWrapper();
            case Cmmn1Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                if (coreType) return getXMLNSPrefixMap();
                else return getXMLNSPrefixMap().map();
            case Cmmn1Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                if (coreType) return getXSISchemaLocation();
                else return getXSISchemaLocation().map();
            case Cmmn1Package.DOCUMENT_ROOT__APPLICABILITY_RULE:
                return getApplicabilityRule();
            case Cmmn1Package.DOCUMENT_ROOT__CASE:
                return getCase();
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE:
                return getCaseFile();
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM:
                return getCaseFileItem();
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION:
                return getCaseFileItemDefinition();
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART:
                return getCaseFileItemOnPart();
            case Cmmn1Package.DOCUMENT_ROOT__ON_PART:
                return getOnPart();
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER:
                return getCaseFileItemStartTrigger();
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_START:
                return getTimerStart();
            case Cmmn1Package.DOCUMENT_ROOT__CASE_PARAMETER:
                return getCaseParameter();
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER:
                return getParameter();
            case Cmmn1Package.DOCUMENT_ROOT__CASE_TASK:
                return getCaseTask();
            case Cmmn1Package.DOCUMENT_ROOT__TASK:
                return getTask();
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_DEFINITION:
                return getPlanItemDefinition();
            case Cmmn1Package.DOCUMENT_ROOT__DEFINITIONS:
                return getDefinitions();
            case Cmmn1Package.DOCUMENT_ROOT__DISCRETIONARY_ITEM:
                return getDiscretionaryItem();
            case Cmmn1Package.DOCUMENT_ROOT__TABLE_ITEM:
                return getTableItem();
            case Cmmn1Package.DOCUMENT_ROOT__EVENT:
                return getEvent();
            case Cmmn1Package.DOCUMENT_ROOT__EXPRESSION:
                return getExpression();
            case Cmmn1Package.DOCUMENT_ROOT__HUMAN_TASK:
                return getHumanTask();
            case Cmmn1Package.DOCUMENT_ROOT__IF_PART:
                return getIfPart();
            case Cmmn1Package.DOCUMENT_ROOT__IMPORT:
                return getImport();
            case Cmmn1Package.DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE:
                return getManualActivationRule();
            case Cmmn1Package.DOCUMENT_ROOT__MILESTONE:
                return getMilestone();
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER_MAPPING:
                return getParameterMapping();
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_FRAGMENT:
                return getPlanFragment();
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM:
                return getPlanItem();
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_CONTROL:
                return getPlanItemControl();
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_ON_PART:
                return getPlanItemOnPart();
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER:
                return getPlanItemStartTrigger();
            case Cmmn1Package.DOCUMENT_ROOT__PLANNING_TABLE:
                return getPlanningTable();
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS:
                return getProcess();
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_PARAMETER:
                return getProcessParameter();
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_TASK:
                return getProcessTask();
            case Cmmn1Package.DOCUMENT_ROOT__PROPERTY:
                return getProperty();
            case Cmmn1Package.DOCUMENT_ROOT__REPETITION_RULE:
                return getRepetitionRule();
            case Cmmn1Package.DOCUMENT_ROOT__REQUIRED_RULE:
                return getRequiredRule();
            case Cmmn1Package.DOCUMENT_ROOT__ROLE:
                return getRole();
            case Cmmn1Package.DOCUMENT_ROOT__SENTRY:
                return getSentry();
            case Cmmn1Package.DOCUMENT_ROOT__STAGE:
                return getStage();
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_EVENT:
                return getTimerEvent();
            case Cmmn1Package.DOCUMENT_ROOT__USER_EVENT:
                return getUserEvent();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case Cmmn1Package.DOCUMENT_ROOT__MIXED:
                ((FeatureMap.Internal)getMixed()).set(newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                ((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                ((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__APPLICABILITY_RULE:
                setApplicabilityRule((TApplicabilityRule)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE:
                setCase((TCase)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE:
                setCaseFile((TCaseFile)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM:
                setCaseFileItem((TCaseFileItem)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION:
                setCaseFileItemDefinition((TCaseFileItemDefinition)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART:
                setCaseFileItemOnPart((TCaseFileItemOnPart)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__ON_PART:
                setOnPart((TOnPart)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER:
                setCaseFileItemStartTrigger((TCaseFileItemStartTrigger)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_START:
                setTimerStart((TStartTrigger)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_PARAMETER:
                setCaseParameter((TCaseParameter)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER:
                setParameter((TParameter)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_TASK:
                setCaseTask((TCaseTask)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__TASK:
                setTask((TTask)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_DEFINITION:
                setPlanItemDefinition((TPlanItemDefinition)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__DEFINITIONS:
                setDefinitions((TDefinitions)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__DISCRETIONARY_ITEM:
                setDiscretionaryItem((TDiscretionaryItem)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__TABLE_ITEM:
                setTableItem((TTableItem)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__EVENT:
                setEvent((TEvent)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__EXPRESSION:
                setExpression((TExpression)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__HUMAN_TASK:
                setHumanTask((THumanTask)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__IF_PART:
                setIfPart((TIfPart)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__IMPORT:
                setImport((TImport)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE:
                setManualActivationRule((TManualActivationRule)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__MILESTONE:
                setMilestone((TMilestone)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER_MAPPING:
                setParameterMapping((TParameterMapping)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_FRAGMENT:
                setPlanFragment((TPlanFragment)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM:
                setPlanItem((TPlanItem)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_CONTROL:
                setPlanItemControl((TPlanItemControl)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_ON_PART:
                setPlanItemOnPart((TPlanItemOnPart)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER:
                setPlanItemStartTrigger((TPlanItemStartTrigger)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLANNING_TABLE:
                setPlanningTable((TPlanningTable)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS:
                setProcess((TProcess)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_PARAMETER:
                setProcessParameter((TProcessParameter)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_TASK:
                setProcessTask((TProcessTask)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PROPERTY:
                setProperty((TProperty)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__REPETITION_RULE:
                setRepetitionRule((TRepetitionRule)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__REQUIRED_RULE:
                setRequiredRule((TRequiredRule)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__ROLE:
                setRole((TRole)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__SENTRY:
                setSentry((TSentry)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__STAGE:
                setStage((TStage)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_EVENT:
                setTimerEvent((TTimerEvent)newValue);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__USER_EVENT:
                setUserEvent((TUserEvent)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case Cmmn1Package.DOCUMENT_ROOT__MIXED:
                getMixed().clear();
                return;
            case Cmmn1Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                getXMLNSPrefixMap().clear();
                return;
            case Cmmn1Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                getXSISchemaLocation().clear();
                return;
            case Cmmn1Package.DOCUMENT_ROOT__APPLICABILITY_RULE:
                setApplicabilityRule((TApplicabilityRule)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE:
                setCase((TCase)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE:
                setCaseFile((TCaseFile)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM:
                setCaseFileItem((TCaseFileItem)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION:
                setCaseFileItemDefinition((TCaseFileItemDefinition)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART:
                setCaseFileItemOnPart((TCaseFileItemOnPart)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__ON_PART:
                setOnPart((TOnPart)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER:
                setCaseFileItemStartTrigger((TCaseFileItemStartTrigger)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_START:
                setTimerStart((TStartTrigger)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_PARAMETER:
                setCaseParameter((TCaseParameter)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER:
                setParameter((TParameter)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_TASK:
                setCaseTask((TCaseTask)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__TASK:
                setTask((TTask)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_DEFINITION:
                setPlanItemDefinition((TPlanItemDefinition)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__DEFINITIONS:
                setDefinitions((TDefinitions)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__DISCRETIONARY_ITEM:
                setDiscretionaryItem((TDiscretionaryItem)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__TABLE_ITEM:
                setTableItem((TTableItem)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__EVENT:
                setEvent((TEvent)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__EXPRESSION:
                setExpression((TExpression)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__HUMAN_TASK:
                setHumanTask((THumanTask)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__IF_PART:
                setIfPart((TIfPart)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__IMPORT:
                setImport((TImport)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE:
                setManualActivationRule((TManualActivationRule)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__MILESTONE:
                setMilestone((TMilestone)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER_MAPPING:
                setParameterMapping((TParameterMapping)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_FRAGMENT:
                setPlanFragment((TPlanFragment)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM:
                setPlanItem((TPlanItem)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_CONTROL:
                setPlanItemControl((TPlanItemControl)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_ON_PART:
                setPlanItemOnPart((TPlanItemOnPart)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER:
                setPlanItemStartTrigger((TPlanItemStartTrigger)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PLANNING_TABLE:
                setPlanningTable((TPlanningTable)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS:
                setProcess((TProcess)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_PARAMETER:
                setProcessParameter((TProcessParameter)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_TASK:
                setProcessTask((TProcessTask)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__PROPERTY:
                setProperty((TProperty)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__REPETITION_RULE:
                setRepetitionRule((TRepetitionRule)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__REQUIRED_RULE:
                setRequiredRule((TRequiredRule)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__ROLE:
                setRole((TRole)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__SENTRY:
                setSentry((TSentry)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__STAGE:
                setStage((TStage)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_EVENT:
                setTimerEvent((TTimerEvent)null);
                return;
            case Cmmn1Package.DOCUMENT_ROOT__USER_EVENT:
                setUserEvent((TUserEvent)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case Cmmn1Package.DOCUMENT_ROOT__MIXED:
                return mixed != null && !mixed.isEmpty();
            case Cmmn1Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
            case Cmmn1Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
            case Cmmn1Package.DOCUMENT_ROOT__APPLICABILITY_RULE:
                return getApplicabilityRule() != null;
            case Cmmn1Package.DOCUMENT_ROOT__CASE:
                return getCase() != null;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE:
                return getCaseFile() != null;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM:
                return getCaseFileItem() != null;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_DEFINITION:
                return getCaseFileItemDefinition() != null;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_ON_PART:
                return getCaseFileItemOnPart() != null;
            case Cmmn1Package.DOCUMENT_ROOT__ON_PART:
                return getOnPart() != null;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_FILE_ITEM_START_TRIGGER:
                return getCaseFileItemStartTrigger() != null;
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_START:
                return getTimerStart() != null;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_PARAMETER:
                return getCaseParameter() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER:
                return getParameter() != null;
            case Cmmn1Package.DOCUMENT_ROOT__CASE_TASK:
                return getCaseTask() != null;
            case Cmmn1Package.DOCUMENT_ROOT__TASK:
                return getTask() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_DEFINITION:
                return getPlanItemDefinition() != null;
            case Cmmn1Package.DOCUMENT_ROOT__DEFINITIONS:
                return getDefinitions() != null;
            case Cmmn1Package.DOCUMENT_ROOT__DISCRETIONARY_ITEM:
                return getDiscretionaryItem() != null;
            case Cmmn1Package.DOCUMENT_ROOT__TABLE_ITEM:
                return getTableItem() != null;
            case Cmmn1Package.DOCUMENT_ROOT__EVENT:
                return getEvent() != null;
            case Cmmn1Package.DOCUMENT_ROOT__EXPRESSION:
                return getExpression() != null;
            case Cmmn1Package.DOCUMENT_ROOT__HUMAN_TASK:
                return getHumanTask() != null;
            case Cmmn1Package.DOCUMENT_ROOT__IF_PART:
                return getIfPart() != null;
            case Cmmn1Package.DOCUMENT_ROOT__IMPORT:
                return getImport() != null;
            case Cmmn1Package.DOCUMENT_ROOT__MANUAL_ACTIVATION_RULE:
                return getManualActivationRule() != null;
            case Cmmn1Package.DOCUMENT_ROOT__MILESTONE:
                return getMilestone() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PARAMETER_MAPPING:
                return getParameterMapping() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_FRAGMENT:
                return getPlanFragment() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM:
                return getPlanItem() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_CONTROL:
                return getPlanItemControl() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_ON_PART:
                return getPlanItemOnPart() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PLAN_ITEM_START_TRIGGER:
                return getPlanItemStartTrigger() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PLANNING_TABLE:
                return getPlanningTable() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS:
                return getProcess() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_PARAMETER:
                return getProcessParameter() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PROCESS_TASK:
                return getProcessTask() != null;
            case Cmmn1Package.DOCUMENT_ROOT__PROPERTY:
                return getProperty() != null;
            case Cmmn1Package.DOCUMENT_ROOT__REPETITION_RULE:
                return getRepetitionRule() != null;
            case Cmmn1Package.DOCUMENT_ROOT__REQUIRED_RULE:
                return getRequiredRule() != null;
            case Cmmn1Package.DOCUMENT_ROOT__ROLE:
                return getRole() != null;
            case Cmmn1Package.DOCUMENT_ROOT__SENTRY:
                return getSentry() != null;
            case Cmmn1Package.DOCUMENT_ROOT__STAGE:
                return getStage() != null;
            case Cmmn1Package.DOCUMENT_ROOT__TIMER_EVENT:
                return getTimerEvent() != null;
            case Cmmn1Package.DOCUMENT_ROOT__USER_EVENT:
                return getUserEvent() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (mixed: ");
        result.append(mixed);
        result.append(')');
        return result.toString();
    }

} //DocumentRootImpl
