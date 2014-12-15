/**
 */
package org.eclipse.cmmn1;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getApplicabilityRule <em>Applicability Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getCase <em>Case</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getCaseFile <em>Case File</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getCaseFileItem <em>Case File Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getCaseFileItemDefinition <em>Case File Item Definition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getCaseFileItemOnPart <em>Case File Item On Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getOnPart <em>On Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getCaseFileItemStartTrigger <em>Case File Item Start Trigger</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getTimerStart <em>Timer Start</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getCaseParameter <em>Case Parameter</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getCaseTask <em>Case Task</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getTask <em>Task</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getPlanItemDefinition <em>Plan Item Definition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getDiscretionaryItem <em>Discretionary Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getTableItem <em>Table Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getEvent <em>Event</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getHumanTask <em>Human Task</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getIfPart <em>If Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getManualActivationRule <em>Manual Activation Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getMilestone <em>Milestone</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getParameterMapping <em>Parameter Mapping</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getPlanFragment <em>Plan Fragment</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getPlanItem <em>Plan Item</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getPlanItemControl <em>Plan Item Control</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getPlanItemOnPart <em>Plan Item On Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getPlanItemStartTrigger <em>Plan Item Start Trigger</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getPlanningTable <em>Planning Table</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getProcess <em>Process</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getProcessParameter <em>Process Parameter</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getProcessTask <em>Process Task</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getRepetitionRule <em>Repetition Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getRequiredRule <em>Required Rule</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getSentry <em>Sentry</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getStage <em>Stage</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getTimerEvent <em>Timer Event</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.DocumentRoot#getUserEvent <em>User Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
    /**
     * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mixed</em>' attribute list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Mixed()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='elementWildcard' name=':mixed'"
     * @generated
     */
    FeatureMap getMixed();

    /**
     * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>XMLNS Prefix Map</em>' map.
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_XMLNSPrefixMap()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
     *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
     * @generated
     */
    EMap<String, String> getXMLNSPrefixMap();

    /**
     * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>XSI Schema Location</em>' map.
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_XSISchemaLocation()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
     *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
     * @generated
     */
    EMap<String, String> getXSISchemaLocation();

    /**
     * Returns the value of the '<em><b>Applicability Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Applicability Rule</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Applicability Rule</em>' containment reference.
     * @see #setApplicabilityRule(TApplicabilityRule)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_ApplicabilityRule()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='applicabilityRule' namespace='##targetNamespace'"
     * @generated
     */
    TApplicabilityRule getApplicabilityRule();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getApplicabilityRule <em>Applicability Rule</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Applicability Rule</em>' containment reference.
     * @see #getApplicabilityRule()
     * @generated
     */
    void setApplicabilityRule(TApplicabilityRule value);

    /**
     * Returns the value of the '<em><b>Case</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         case is the root element for all CMMN case models. It is the container
     *         for the Case File and Plan Model.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case</em>' containment reference.
     * @see #setCase(TCase)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Case()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='case' namespace='##targetNamespace'"
     * @generated
     */
    TCase getCase();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getCase <em>Case</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case</em>' containment reference.
     * @see #getCase()
     * @generated
     */
    void setCase(TCase value);

    /**
     * Returns the value of the '<em><b>Case File</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         caseFile is the root element for the CMMN Case File Model
     *         and is a container for CaseFileItems.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case File</em>' containment reference.
     * @see #setCaseFile(TCaseFile)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_CaseFile()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='caseFile' namespace='##targetNamespace'"
     * @generated
     */
    TCaseFile getCaseFile();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getCaseFile <em>Case File</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case File</em>' containment reference.
     * @see #getCaseFile()
     * @generated
     */
    void setCaseFile(TCaseFile value);

    /**
     * Returns the value of the '<em><b>Case File Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         caseFileItem is the root element for CMMN data.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case File Item</em>' containment reference.
     * @see #setCaseFileItem(TCaseFileItem)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_CaseFileItem()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='caseFileItem' namespace='##targetNamespace'"
     * @generated
     */
    TCaseFileItem getCaseFileItem();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getCaseFileItem <em>Case File Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case File Item</em>' containment reference.
     * @see #getCaseFileItem()
     * @generated
     */
    void setCaseFileItem(TCaseFileItem value);

    /**
     * Returns the value of the '<em><b>Case File Item Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         caseFileItemDefinition defines the type of a "caseFileItem".
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case File Item Definition</em>' containment reference.
     * @see #setCaseFileItemDefinition(TCaseFileItemDefinition)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_CaseFileItemDefinition()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='caseFileItemDefinition' namespace='##targetNamespace'"
     * @generated
     */
    TCaseFileItemDefinition getCaseFileItemDefinition();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getCaseFileItemDefinition <em>Case File Item Definition</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case File Item Definition</em>' containment reference.
     * @see #getCaseFileItemDefinition()
     * @generated
     */
    void setCaseFileItemDefinition(TCaseFileItemDefinition value);

    /**
     * Returns the value of the '<em><b>Case File Item On Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Case File Item On Part</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Case File Item On Part</em>' containment reference.
     * @see #setCaseFileItemOnPart(TCaseFileItemOnPart)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_CaseFileItemOnPart()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='caseFileItemOnPart' namespace='##targetNamespace' affiliation='onPart'"
     * @generated
     */
    TCaseFileItemOnPart getCaseFileItemOnPart();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getCaseFileItemOnPart <em>Case File Item On Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case File Item On Part</em>' containment reference.
     * @see #getCaseFileItemOnPart()
     * @generated
     */
    void setCaseFileItemOnPart(TCaseFileItemOnPart value);

    /**
     * Returns the value of the '<em><b>On Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Part</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Part</em>' containment reference.
     * @see #setOnPart(TOnPart)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_OnPart()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='onPart' namespace='##targetNamespace'"
     * @generated
     */
    TOnPart getOnPart();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getOnPart <em>On Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Part</em>' containment reference.
     * @see #getOnPart()
     * @generated
     */
    void setOnPart(TOnPart value);

    /**
     * Returns the value of the '<em><b>Case File Item Start Trigger</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Case File Item Start Trigger</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Case File Item Start Trigger</em>' containment reference.
     * @see #setCaseFileItemStartTrigger(TCaseFileItemStartTrigger)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_CaseFileItemStartTrigger()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='caseFileItemStartTrigger' namespace='##targetNamespace' affiliation='timerStart'"
     * @generated
     */
    TCaseFileItemStartTrigger getCaseFileItemStartTrigger();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getCaseFileItemStartTrigger <em>Case File Item Start Trigger</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case File Item Start Trigger</em>' containment reference.
     * @see #getCaseFileItemStartTrigger()
     * @generated
     */
    void setCaseFileItemStartTrigger(TCaseFileItemStartTrigger value);

    /**
     * Returns the value of the '<em><b>Timer Start</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timer Start</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timer Start</em>' containment reference.
     * @see #setTimerStart(TStartTrigger)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_TimerStart()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='timerStart' namespace='##targetNamespace'"
     * @generated
     */
    TStartTrigger getTimerStart();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getTimerStart <em>Timer Start</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timer Start</em>' containment reference.
     * @see #getTimerStart()
     * @generated
     */
    void setTimerStart(TStartTrigger value);

    /**
     * Returns the value of the '<em><b>Case Parameter</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Case Parameter</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Case Parameter</em>' containment reference.
     * @see #setCaseParameter(TCaseParameter)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_CaseParameter()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='caseParameter' namespace='##targetNamespace' affiliation='parameter'"
     * @generated
     */
    TCaseParameter getCaseParameter();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getCaseParameter <em>Case Parameter</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case Parameter</em>' containment reference.
     * @see #getCaseParameter()
     * @generated
     */
    void setCaseParameter(TCaseParameter value);

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' containment reference.
     * @see #setParameter(TParameter)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Parameter()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='parameter' namespace='##targetNamespace'"
     * @generated
     */
    TParameter getParameter();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getParameter <em>Parameter</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' containment reference.
     * @see #getParameter()
     * @generated
     */
    void setParameter(TParameter value);

    /**
     * Returns the value of the '<em><b>Case Task</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         caseTask is the root element for CaseTask in the Case Model and
     *         comprises of ParameterMappings and a reference to a Case
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case Task</em>' containment reference.
     * @see #setCaseTask(TCaseTask)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_CaseTask()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='caseTask' namespace='##targetNamespace' affiliation='task'"
     * @generated
     */
    TCaseTask getCaseTask();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getCaseTask <em>Case Task</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case Task</em>' containment reference.
     * @see #getCaseTask()
     * @generated
     */
    void setCaseTask(TCaseTask value);

    /**
     * Returns the value of the '<em><b>Task</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         task represents an (abstract) Task in the Case Model and comprises
     *         of inputs, outputs and a flag if the task is blocking or not.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Task</em>' containment reference.
     * @see #setTask(TTask)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Task()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='task' namespace='##targetNamespace' affiliation='planItemDefinition'"
     * @generated
     */
    TTask getTask();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getTask <em>Task</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Task</em>' containment reference.
     * @see #getTask()
     * @generated
     */
    void setTask(TTask value);

    /**
     * Returns the value of the '<em><b>Plan Item Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plan Item Definition</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plan Item Definition</em>' containment reference.
     * @see #setPlanItemDefinition(TPlanItemDefinition)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_PlanItemDefinition()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='planItemDefinition' namespace='##targetNamespace'"
     * @generated
     */
    TPlanItemDefinition getPlanItemDefinition();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getPlanItemDefinition <em>Plan Item Definition</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plan Item Definition</em>' containment reference.
     * @see #getPlanItemDefinition()
     * @generated
     */
    void setPlanItemDefinition(TPlanItemDefinition value);

    /**
     * Returns the value of the '<em><b>Definitions</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         definitions is the root element of ALL CMMN elements. It is used as a container
     *         for CMMN elements that might be re-used.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Definitions</em>' containment reference.
     * @see #setDefinitions(TDefinitions)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Definitions()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='definitions' namespace='##targetNamespace'"
     * @generated
     */
    TDefinitions getDefinitions();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getDefinitions <em>Definitions</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Definitions</em>' containment reference.
     * @see #getDefinitions()
     * @generated
     */
    void setDefinitions(TDefinitions value);

    /**
     * Returns the value of the '<em><b>Discretionary Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Discretionary Item</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Discretionary Item</em>' containment reference.
     * @see #setDiscretionaryItem(TDiscretionaryItem)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_DiscretionaryItem()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='discretionaryItem' namespace='##targetNamespace' affiliation='tableItem'"
     * @generated
     */
    TDiscretionaryItem getDiscretionaryItem();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getDiscretionaryItem <em>Discretionary Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Discretionary Item</em>' containment reference.
     * @see #getDiscretionaryItem()
     * @generated
     */
    void setDiscretionaryItem(TDiscretionaryItem value);

    /**
     * Returns the value of the '<em><b>Table Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Table Item</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Table Item</em>' containment reference.
     * @see #setTableItem(TTableItem)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_TableItem()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='tableItem' namespace='##targetNamespace'"
     * @generated
     */
    TTableItem getTableItem();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getTableItem <em>Table Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Table Item</em>' containment reference.
     * @see #getTableItem()
     * @generated
     */
    void setTableItem(TTableItem value);

    /**
     * Returns the value of the '<em><b>Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         event represents an (abstract) Event in the Case Model.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Event</em>' containment reference.
     * @see #setEvent(TEvent)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Event()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='event' namespace='##targetNamespace' affiliation='planItemDefinition'"
     * @generated
     */
    TEvent getEvent();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getEvent <em>Event</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Event</em>' containment reference.
     * @see #getEvent()
     * @generated
     */
    void setEvent(TEvent value);

    /**
     * Returns the value of the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' containment reference.
     * @see #setExpression(TExpression)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Expression()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='expression' namespace='##targetNamespace'"
     * @generated
     */
    TExpression getExpression();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getExpression <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' containment reference.
     * @see #getExpression()
     * @generated
     */
    void setExpression(TExpression value);

    /**
     * Returns the value of the '<em><b>Human Task</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         humanTask represents a HumanTask in the Case Model and comprises of
     *         zero or one PlanningTable and a reference to a Role (the performer of
     *         the human task).
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Human Task</em>' containment reference.
     * @see #setHumanTask(THumanTask)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_HumanTask()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='humanTask' namespace='##targetNamespace' affiliation='task'"
     * @generated
     */
    THumanTask getHumanTask();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getHumanTask <em>Human Task</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Human Task</em>' containment reference.
     * @see #getHumanTask()
     * @generated
     */
    void setHumanTask(THumanTask value);

    /**
     * Returns the value of the '<em><b>If Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>If Part</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>If Part</em>' containment reference.
     * @see #setIfPart(TIfPart)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_IfPart()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='ifPart' namespace='##targetNamespace'"
     * @generated
     */
    TIfPart getIfPart();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getIfPart <em>If Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>If Part</em>' containment reference.
     * @see #getIfPart()
     * @generated
     */
    void setIfPart(TIfPart value);

    /**
     * Returns the value of the '<em><b>Import</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' containment reference.
     * @see #setImport(TImport)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Import()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace'"
     * @generated
     */
    TImport getImport();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getImport <em>Import</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' containment reference.
     * @see #getImport()
     * @generated
     */
    void setImport(TImport value);

    /**
     * Returns the value of the '<em><b>Manual Activation Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         manualActivationRule is the root element for specifying an
     *         manual activation rule for a PlanItemDefinition element.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Manual Activation Rule</em>' containment reference.
     * @see #setManualActivationRule(TManualActivationRule)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_ManualActivationRule()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='manualActivationRule' namespace='##targetNamespace'"
     * @generated
     */
    TManualActivationRule getManualActivationRule();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getManualActivationRule <em>Manual Activation Rule</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Manual Activation Rule</em>' containment reference.
     * @see #getManualActivationRule()
     * @generated
     */
    void setManualActivationRule(TManualActivationRule value);

    /**
     * Returns the value of the '<em><b>Milestone</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Milestone</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Milestone</em>' containment reference.
     * @see #setMilestone(TMilestone)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Milestone()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='milestone' namespace='##targetNamespace' affiliation='planItemDefinition'"
     * @generated
     */
    TMilestone getMilestone();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getMilestone <em>Milestone</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Milestone</em>' containment reference.
     * @see #getMilestone()
     * @generated
     */
    void setMilestone(TMilestone value);

    /**
     * Returns the value of the '<em><b>Parameter Mapping</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Mapping</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter Mapping</em>' containment reference.
     * @see #setParameterMapping(TParameterMapping)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_ParameterMapping()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='parameterMapping' namespace='##targetNamespace'"
     * @generated
     */
    TParameterMapping getParameterMapping();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getParameterMapping <em>Parameter Mapping</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter Mapping</em>' containment reference.
     * @see #getParameterMapping()
     * @generated
     */
    void setParameterMapping(TParameterMapping value);

    /**
     * Returns the value of the '<em><b>Plan Fragment</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         planFragment is the root element for PlanItems that should go into
     *         the plan as a unit.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Plan Fragment</em>' containment reference.
     * @see #setPlanFragment(TPlanFragment)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_PlanFragment()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='planFragment' namespace='##targetNamespace' affiliation='planItemDefinition'"
     * @generated
     */
    TPlanFragment getPlanFragment();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getPlanFragment <em>Plan Fragment</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plan Fragment</em>' containment reference.
     * @see #getPlanFragment()
     * @generated
     */
    void setPlanFragment(TPlanFragment value);

    /**
     * Returns the value of the '<em><b>Plan Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plan Item</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plan Item</em>' containment reference.
     * @see #setPlanItem(TPlanItem)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_PlanItem()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='planItem' namespace='##targetNamespace'"
     * @generated
     */
    TPlanItem getPlanItem();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getPlanItem <em>Plan Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plan Item</em>' containment reference.
     * @see #getPlanItem()
     * @generated
     */
    void setPlanItem(TPlanItem value);

    /**
     * Returns the value of the '<em><b>Plan Item Control</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         planItemControl is the root element for Case Plan Control elements
     *         including the RepetitionRule, RequiredRule and ManualActivationRule.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Plan Item Control</em>' containment reference.
     * @see #setPlanItemControl(TPlanItemControl)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_PlanItemControl()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='planItemControl' namespace='##targetNamespace'"
     * @generated
     */
    TPlanItemControl getPlanItemControl();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getPlanItemControl <em>Plan Item Control</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plan Item Control</em>' containment reference.
     * @see #getPlanItemControl()
     * @generated
     */
    void setPlanItemControl(TPlanItemControl value);

    /**
     * Returns the value of the '<em><b>Plan Item On Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plan Item On Part</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plan Item On Part</em>' containment reference.
     * @see #setPlanItemOnPart(TPlanItemOnPart)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_PlanItemOnPart()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='planItemOnPart' namespace='##targetNamespace' affiliation='onPart'"
     * @generated
     */
    TPlanItemOnPart getPlanItemOnPart();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getPlanItemOnPart <em>Plan Item On Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plan Item On Part</em>' containment reference.
     * @see #getPlanItemOnPart()
     * @generated
     */
    void setPlanItemOnPart(TPlanItemOnPart value);

    /**
     * Returns the value of the '<em><b>Plan Item Start Trigger</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plan Item Start Trigger</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plan Item Start Trigger</em>' containment reference.
     * @see #setPlanItemStartTrigger(TPlanItemStartTrigger)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_PlanItemStartTrigger()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='planItemStartTrigger' namespace='##targetNamespace' affiliation='timerStart'"
     * @generated
     */
    TPlanItemStartTrigger getPlanItemStartTrigger();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getPlanItemStartTrigger <em>Plan Item Start Trigger</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plan Item Start Trigger</em>' containment reference.
     * @see #getPlanItemStartTrigger()
     * @generated
     */
    void setPlanItemStartTrigger(TPlanItemStartTrigger value);

    /**
     * Returns the value of the '<em><b>Planning Table</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Planning Table</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Planning Table</em>' containment reference.
     * @see #setPlanningTable(TPlanningTable)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_PlanningTable()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='planningTable' namespace='##targetNamespace' affiliation='tableItem'"
     * @generated
     */
    TPlanningTable getPlanningTable();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getPlanningTable <em>Planning Table</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Planning Table</em>' containment reference.
     * @see #getPlanningTable()
     * @generated
     */
    void setPlanningTable(TPlanningTable value);

    /**
     * Returns the value of the '<em><b>Process</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         process represents an (abstract) Business Process in CMMN. It has
     *         a implementationType, inputs and outputs and can be referred from
     *         a ProcessTask.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Process</em>' containment reference.
     * @see #setProcess(TProcess)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Process()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='process' namespace='##targetNamespace'"
     * @generated
     */
    TProcess getProcess();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getProcess <em>Process</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Process</em>' containment reference.
     * @see #getProcess()
     * @generated
     */
    void setProcess(TProcess value);

    /**
     * Returns the value of the '<em><b>Process Parameter</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Process Parameter</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Process Parameter</em>' containment reference.
     * @see #setProcessParameter(TProcessParameter)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_ProcessParameter()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='processParameter' namespace='##targetNamespace' affiliation='parameter'"
     * @generated
     */
    TProcessParameter getProcessParameter();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getProcessParameter <em>Process Parameter</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Process Parameter</em>' containment reference.
     * @see #getProcessParameter()
     * @generated
     */
    void setProcessParameter(TProcessParameter value);

    /**
     * Returns the value of the '<em><b>Process Task</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         processTask represents a ProcessTask in the Case Model and comprises of
     *         ParameterMappings and a reference to an (abstract) Process.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Process Task</em>' containment reference.
     * @see #setProcessTask(TProcessTask)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_ProcessTask()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='processTask' namespace='##targetNamespace' affiliation='task'"
     * @generated
     */
    TProcessTask getProcessTask();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getProcessTask <em>Process Task</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Process Task</em>' containment reference.
     * @see #getProcessTask()
     * @generated
     */
    void setProcessTask(TProcessTask value);

    /**
     * Returns the value of the '<em><b>Property</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Property</em>' containment reference.
     * @see #setProperty(TProperty)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Property()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
     * @generated
     */
    TProperty getProperty();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getProperty <em>Property</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property</em>' containment reference.
     * @see #getProperty()
     * @generated
     */
    void setProperty(TProperty value);

    /**
     * Returns the value of the '<em><b>Repetition Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         repetitionRule is the root element for specifying a
     *         repetition rule for a PlanItemDefinition element.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Repetition Rule</em>' containment reference.
     * @see #setRepetitionRule(TRepetitionRule)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_RepetitionRule()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='repetitionRule' namespace='##targetNamespace'"
     * @generated
     */
    TRepetitionRule getRepetitionRule();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getRepetitionRule <em>Repetition Rule</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Repetition Rule</em>' containment reference.
     * @see #getRepetitionRule()
     * @generated
     */
    void setRepetitionRule(TRepetitionRule value);

    /**
     * Returns the value of the '<em><b>Required Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         requiredRule is the root element for specifying a
     *         required rule for a PlanItemDefinition element.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Required Rule</em>' containment reference.
     * @see #setRequiredRule(TRequiredRule)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_RequiredRule()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='requiredRule' namespace='##targetNamespace'"
     * @generated
     */
    TRequiredRule getRequiredRule();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getRequiredRule <em>Required Rule</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Required Rule</em>' containment reference.
     * @see #getRequiredRule()
     * @generated
     */
    void setRequiredRule(TRequiredRule value);

    /**
     * Returns the value of the '<em><b>Role</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         role is the root element for Case Roles.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Role</em>' containment reference.
     * @see #setRole(TRole)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Role()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='role' namespace='##targetNamespace'"
     * @generated
     */
    TRole getRole();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getRole <em>Role</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Role</em>' containment reference.
     * @see #getRole()
     * @generated
     */
    void setRole(TRole value);

    /**
     * Returns the value of the '<em><b>Sentry</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         sentry is the root element of "Sentry" in the Case Model and
     *         comprises of zero or more OnParts and zero or one IfPart.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Sentry</em>' containment reference.
     * @see #setSentry(TSentry)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Sentry()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='sentry' namespace='##targetNamespace'"
     * @generated
     */
    TSentry getSentry();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getSentry <em>Sentry</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sentry</em>' containment reference.
     * @see #getSentry()
     * @generated
     */
    void setSentry(TSentry value);

    /**
     * Returns the value of the '<em><b>Stage</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         stage represents a Stage in the Case Model and comprises of
     *         zero or one PlanningTable, zero or more PlanItemDefinition elements
     *         and if the Stage is the outermost Stage, zero or more references to
     *         exit criteria Sentries.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Stage</em>' containment reference.
     * @see #setStage(TStage)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_Stage()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='stage' namespace='##targetNamespace' affiliation='planItemDefinition'"
     * @generated
     */
    TStage getStage();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getStage <em>Stage</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stage</em>' containment reference.
     * @see #getStage()
     * @generated
     */
    void setStage(TStage value);

    /**
     * Returns the value of the '<em><b>Timer Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timer Event</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timer Event</em>' containment reference.
     * @see #setTimerEvent(TTimerEvent)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_TimerEvent()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='timerEvent' namespace='##targetNamespace' affiliation='event'"
     * @generated
     */
    TTimerEvent getTimerEvent();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getTimerEvent <em>Timer Event</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timer Event</em>' containment reference.
     * @see #getTimerEvent()
     * @generated
     */
    void setTimerEvent(TTimerEvent value);

    /**
     * Returns the value of the '<em><b>User Event</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>User Event</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>User Event</em>' containment reference.
     * @see #setUserEvent(TUserEvent)
     * @see org.eclipse.cmmn1.Cmmn1Package#getDocumentRoot_UserEvent()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='userEvent' namespace='##targetNamespace' affiliation='event'"
     * @generated
     */
    TUserEvent getUserEvent();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.DocumentRoot#getUserEvent <em>User Event</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>User Event</em>' containment reference.
     * @see #getUserEvent()
     * @generated
     */
    void setUserEvent(TUserEvent value);

} // DocumentRoot
