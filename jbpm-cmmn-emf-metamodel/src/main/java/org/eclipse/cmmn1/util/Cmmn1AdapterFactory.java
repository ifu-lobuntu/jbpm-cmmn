/**
 */
package org.eclipse.cmmn1.util;

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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.cmmn1.Cmmn1Package
 * @generated
 */
public class Cmmn1AdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static Cmmn1Package modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cmmn1AdapterFactory() {
        if (modelPackage == null) {
            modelPackage = Cmmn1Package.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Cmmn1Switch<Adapter> modelSwitch =
        new Cmmn1Switch<Adapter>() {
            @Override
            public Adapter caseDocumentRoot(DocumentRoot object) {
                return createDocumentRootAdapter();
            }
            @Override
            public Adapter caseTApplicabilityRule(TApplicabilityRule object) {
                return createTApplicabilityRuleAdapter();
            }
            @Override
            public Adapter caseTCase(TCase object) {
                return createTCaseAdapter();
            }
            @Override
            public Adapter caseTCaseFile(TCaseFile object) {
                return createTCaseFileAdapter();
            }
            @Override
            public Adapter caseTCaseFileItem(TCaseFileItem object) {
                return createTCaseFileItemAdapter();
            }
            @Override
            public Adapter caseTCaseFileItemDefinition(TCaseFileItemDefinition object) {
                return createTCaseFileItemDefinitionAdapter();
            }
            @Override
            public Adapter caseTCaseFileItemOnPart(TCaseFileItemOnPart object) {
                return createTCaseFileItemOnPartAdapter();
            }
            @Override
            public Adapter caseTCaseFileItemStartTrigger(TCaseFileItemStartTrigger object) {
                return createTCaseFileItemStartTriggerAdapter();
            }
            @Override
            public Adapter caseTCaseParameter(TCaseParameter object) {
                return createTCaseParameterAdapter();
            }
            @Override
            public Adapter caseTCaseTask(TCaseTask object) {
                return createTCaseTaskAdapter();
            }
            @Override
            public Adapter caseTChildren(TChildren object) {
                return createTChildrenAdapter();
            }
            @Override
            public Adapter caseTCmmnElement(TCmmnElement object) {
                return createTCmmnElementAdapter();
            }
            @Override
            public Adapter caseTCmmnElementWithMixedContent(TCmmnElementWithMixedContent object) {
                return createTCmmnElementWithMixedContentAdapter();
            }
            @Override
            public Adapter caseTDefinitions(TDefinitions object) {
                return createTDefinitionsAdapter();
            }
            @Override
            public Adapter caseTDiscretionaryItem(TDiscretionaryItem object) {
                return createTDiscretionaryItemAdapter();
            }
            @Override
            public Adapter caseTEvent(TEvent object) {
                return createTEventAdapter();
            }
            @Override
            public Adapter caseTExpression(TExpression object) {
                return createTExpressionAdapter();
            }
            @Override
            public Adapter caseTHumanTask(THumanTask object) {
                return createTHumanTaskAdapter();
            }
            @Override
            public Adapter caseTIfPart(TIfPart object) {
                return createTIfPartAdapter();
            }
            @Override
            public Adapter caseTImport(TImport object) {
                return createTImportAdapter();
            }
            @Override
            public Adapter caseTManualActivationRule(TManualActivationRule object) {
                return createTManualActivationRuleAdapter();
            }
            @Override
            public Adapter caseTMilestone(TMilestone object) {
                return createTMilestoneAdapter();
            }
            @Override
            public Adapter caseTOnPart(TOnPart object) {
                return createTOnPartAdapter();
            }
            @Override
            public Adapter caseTParameter(TParameter object) {
                return createTParameterAdapter();
            }
            @Override
            public Adapter caseTParameterMapping(TParameterMapping object) {
                return createTParameterMappingAdapter();
            }
            @Override
            public Adapter caseTPlanFragment(TPlanFragment object) {
                return createTPlanFragmentAdapter();
            }
            @Override
            public Adapter caseTPlanItem(TPlanItem object) {
                return createTPlanItemAdapter();
            }
            @Override
            public Adapter caseTPlanItemControl(TPlanItemControl object) {
                return createTPlanItemControlAdapter();
            }
            @Override
            public Adapter caseTPlanItemDefinition(TPlanItemDefinition object) {
                return createTPlanItemDefinitionAdapter();
            }
            @Override
            public Adapter caseTPlanItemOnPart(TPlanItemOnPart object) {
                return createTPlanItemOnPartAdapter();
            }
            @Override
            public Adapter caseTPlanItemStartTrigger(TPlanItemStartTrigger object) {
                return createTPlanItemStartTriggerAdapter();
            }
            @Override
            public Adapter caseTPlanningTable(TPlanningTable object) {
                return createTPlanningTableAdapter();
            }
            @Override
            public Adapter caseTProcess(TProcess object) {
                return createTProcessAdapter();
            }
            @Override
            public Adapter caseTProcessParameter(TProcessParameter object) {
                return createTProcessParameterAdapter();
            }
            @Override
            public Adapter caseTProcessTask(TProcessTask object) {
                return createTProcessTaskAdapter();
            }
            @Override
            public Adapter caseTProperty(TProperty object) {
                return createTPropertyAdapter();
            }
            @Override
            public Adapter caseTRepetitionRule(TRepetitionRule object) {
                return createTRepetitionRuleAdapter();
            }
            @Override
            public Adapter caseTRequiredRule(TRequiredRule object) {
                return createTRequiredRuleAdapter();
            }
            @Override
            public Adapter caseTRole(TRole object) {
                return createTRoleAdapter();
            }
            @Override
            public Adapter caseTSentry(TSentry object) {
                return createTSentryAdapter();
            }
            @Override
            public Adapter caseTStage(TStage object) {
                return createTStageAdapter();
            }
            @Override
            public Adapter caseTStartTrigger(TStartTrigger object) {
                return createTStartTriggerAdapter();
            }
            @Override
            public Adapter caseTTableItem(TTableItem object) {
                return createTTableItemAdapter();
            }
            @Override
            public Adapter caseTTask(TTask object) {
                return createTTaskAdapter();
            }
            @Override
            public Adapter caseTTimerEvent(TTimerEvent object) {
                return createTTimerEventAdapter();
            }
            @Override
            public Adapter caseTUserEvent(TUserEvent object) {
                return createTUserEventAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.DocumentRoot
     * @generated
     */
    public Adapter createDocumentRootAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TApplicabilityRule <em>TApplicability Rule</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TApplicabilityRule
     * @generated
     */
    public Adapter createTApplicabilityRuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCase <em>TCase</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCase
     * @generated
     */
    public Adapter createTCaseAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCaseFile <em>TCase File</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCaseFile
     * @generated
     */
    public Adapter createTCaseFileAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCaseFileItem <em>TCase File Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCaseFileItem
     * @generated
     */
    public Adapter createTCaseFileItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCaseFileItemDefinition <em>TCase File Item Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCaseFileItemDefinition
     * @generated
     */
    public Adapter createTCaseFileItemDefinitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCaseFileItemOnPart <em>TCase File Item On Part</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCaseFileItemOnPart
     * @generated
     */
    public Adapter createTCaseFileItemOnPartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCaseFileItemStartTrigger <em>TCase File Item Start Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCaseFileItemStartTrigger
     * @generated
     */
    public Adapter createTCaseFileItemStartTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCaseParameter <em>TCase Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCaseParameter
     * @generated
     */
    public Adapter createTCaseParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCaseTask <em>TCase Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCaseTask
     * @generated
     */
    public Adapter createTCaseTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TChildren <em>TChildren</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TChildren
     * @generated
     */
    public Adapter createTChildrenAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCmmnElement <em>TCmmn Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCmmnElement
     * @generated
     */
    public Adapter createTCmmnElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TCmmnElementWithMixedContent <em>TCmmn Element With Mixed Content</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TCmmnElementWithMixedContent
     * @generated
     */
    public Adapter createTCmmnElementWithMixedContentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TDefinitions <em>TDefinitions</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TDefinitions
     * @generated
     */
    public Adapter createTDefinitionsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TDiscretionaryItem <em>TDiscretionary Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TDiscretionaryItem
     * @generated
     */
    public Adapter createTDiscretionaryItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TEvent <em>TEvent</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TEvent
     * @generated
     */
    public Adapter createTEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TExpression <em>TExpression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TExpression
     * @generated
     */
    public Adapter createTExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.THumanTask <em>THuman Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.THumanTask
     * @generated
     */
    public Adapter createTHumanTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TIfPart <em>TIf Part</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TIfPart
     * @generated
     */
    public Adapter createTIfPartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TImport <em>TImport</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TImport
     * @generated
     */
    public Adapter createTImportAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TManualActivationRule <em>TManual Activation Rule</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TManualActivationRule
     * @generated
     */
    public Adapter createTManualActivationRuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TMilestone <em>TMilestone</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TMilestone
     * @generated
     */
    public Adapter createTMilestoneAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TOnPart <em>TOn Part</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TOnPart
     * @generated
     */
    public Adapter createTOnPartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TParameter <em>TParameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TParameter
     * @generated
     */
    public Adapter createTParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TParameterMapping <em>TParameter Mapping</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TParameterMapping
     * @generated
     */
    public Adapter createTParameterMappingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TPlanFragment <em>TPlan Fragment</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TPlanFragment
     * @generated
     */
    public Adapter createTPlanFragmentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TPlanItem <em>TPlan Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TPlanItem
     * @generated
     */
    public Adapter createTPlanItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TPlanItemControl <em>TPlan Item Control</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TPlanItemControl
     * @generated
     */
    public Adapter createTPlanItemControlAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TPlanItemDefinition <em>TPlan Item Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TPlanItemDefinition
     * @generated
     */
    public Adapter createTPlanItemDefinitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TPlanItemOnPart <em>TPlan Item On Part</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TPlanItemOnPart
     * @generated
     */
    public Adapter createTPlanItemOnPartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TPlanItemStartTrigger <em>TPlan Item Start Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TPlanItemStartTrigger
     * @generated
     */
    public Adapter createTPlanItemStartTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TPlanningTable <em>TPlanning Table</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TPlanningTable
     * @generated
     */
    public Adapter createTPlanningTableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TProcess <em>TProcess</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TProcess
     * @generated
     */
    public Adapter createTProcessAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TProcessParameter <em>TProcess Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TProcessParameter
     * @generated
     */
    public Adapter createTProcessParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TProcessTask <em>TProcess Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TProcessTask
     * @generated
     */
    public Adapter createTProcessTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TProperty <em>TProperty</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TProperty
     * @generated
     */
    public Adapter createTPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TRepetitionRule <em>TRepetition Rule</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TRepetitionRule
     * @generated
     */
    public Adapter createTRepetitionRuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TRequiredRule <em>TRequired Rule</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TRequiredRule
     * @generated
     */
    public Adapter createTRequiredRuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TRole <em>TRole</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TRole
     * @generated
     */
    public Adapter createTRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TSentry <em>TSentry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TSentry
     * @generated
     */
    public Adapter createTSentryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TStage <em>TStage</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TStage
     * @generated
     */
    public Adapter createTStageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TStartTrigger <em>TStart Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TStartTrigger
     * @generated
     */
    public Adapter createTStartTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TTableItem <em>TTable Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TTableItem
     * @generated
     */
    public Adapter createTTableItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TTask <em>TTask</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TTask
     * @generated
     */
    public Adapter createTTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TTimerEvent <em>TTimer Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TTimerEvent
     * @generated
     */
    public Adapter createTTimerEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.cmmn1.TUserEvent <em>TUser Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.cmmn1.TUserEvent
     * @generated
     */
    public Adapter createTUserEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //Cmmn1AdapterFactory
