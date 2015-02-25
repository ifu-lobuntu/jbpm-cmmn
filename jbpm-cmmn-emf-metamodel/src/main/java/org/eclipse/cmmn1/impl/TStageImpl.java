/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TPlanItemDefinition;
import org.eclipse.cmmn1.TPlanningTable;
import org.eclipse.cmmn1.TSentry;
import org.eclipse.cmmn1.TStage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TStage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TStageImpl#getPlanningTable <em>Planning Table</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TStageImpl#getPlanItemDefinitionGroup <em>Plan Item Definition Group</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TStageImpl#getPlanItemDefinition <em>Plan Item Definition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TStageImpl#isAutoComplete <em>Auto Complete</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TStageImpl#getExitCriteriaRefs <em>Exit Criteria Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TStageImpl extends TPlanFragmentImpl implements TStage {
    /**
     * The cached value of the '{@link #getPlanningTable() <em>Planning Table</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPlanningTable()
     * @generated
     * @ordered
     */
    protected TPlanningTable planningTable;

    /**
     * The cached value of the '{@link #getPlanItemDefinitionGroup() <em>Plan Item Definition Group</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPlanItemDefinitionGroup()
     * @generated
     * @ordered
     */
    protected FeatureMap planItemDefinitionGroup;

    /**
     * The default value of the '{@link #isAutoComplete() <em>Auto Complete</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAutoComplete()
     * @generated
     * @ordered
     */
    protected static final boolean AUTO_COMPLETE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAutoComplete() <em>Auto Complete</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAutoComplete()
     * @generated
     * @ordered
     */
    protected boolean autoComplete = AUTO_COMPLETE_EDEFAULT;

    /**
     * This is true if the Auto Complete attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean autoCompleteESet;

    /**
     * The cached value of the '{@link #getExitCriteriaRefs() <em>Exit Criteria Refs</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExitCriteriaRefs()
     * @generated
     * @ordered
     */
    protected EList<TSentry> exitCriteriaRefs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TStageImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TSTAGE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TPlanningTable getPlanningTable() {
        return planningTable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlanningTable(TPlanningTable newPlanningTable, NotificationChain msgs) {
        TPlanningTable oldPlanningTable = planningTable;
        planningTable = newPlanningTable;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TSTAGE__PLANNING_TABLE, oldPlanningTable, newPlanningTable);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlanningTable(TPlanningTable newPlanningTable) {
        if (newPlanningTable != planningTable) {
            NotificationChain msgs = null;
            if (planningTable != null)
                msgs = ((InternalEObject)planningTable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TSTAGE__PLANNING_TABLE, null, msgs);
            if (newPlanningTable != null)
                msgs = ((InternalEObject)newPlanningTable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TSTAGE__PLANNING_TABLE, null, msgs);
            msgs = basicSetPlanningTable(newPlanningTable, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TSTAGE__PLANNING_TABLE, newPlanningTable, newPlanningTable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getPlanItemDefinitionGroup() {
        if (planItemDefinitionGroup == null) {
            planItemDefinitionGroup = new BasicFeatureMap(this, Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION_GROUP);
        }
        return planItemDefinitionGroup;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TPlanItemDefinition> getPlanItemDefinition() {
        return getPlanItemDefinitionGroup().list(Cmmn1Package.Literals.TSTAGE__PLAN_ITEM_DEFINITION);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAutoComplete() {
        return autoComplete;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAutoComplete(boolean newAutoComplete) {
        boolean oldAutoComplete = autoComplete;
        autoComplete = newAutoComplete;
        boolean oldAutoCompleteESet = autoCompleteESet;
        autoCompleteESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TSTAGE__AUTO_COMPLETE, oldAutoComplete, autoComplete, !oldAutoCompleteESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetAutoComplete() {
        boolean oldAutoComplete = autoComplete;
        boolean oldAutoCompleteESet = autoCompleteESet;
        autoComplete = AUTO_COMPLETE_EDEFAULT;
        autoCompleteESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, Cmmn1Package.TSTAGE__AUTO_COMPLETE, oldAutoComplete, AUTO_COMPLETE_EDEFAULT, oldAutoCompleteESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetAutoComplete() {
        return autoCompleteESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TSentry> getExitCriteriaRefs() {
        if (exitCriteriaRefs == null) {
            exitCriteriaRefs = new EObjectResolvingEList<TSentry>(TSentry.class, this, Cmmn1Package.TSTAGE__EXIT_CRITERIA_REFS);
        }
        return exitCriteriaRefs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TSTAGE__PLANNING_TABLE:
                return basicSetPlanningTable(null, msgs);
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION_GROUP:
                return ((InternalEList<?>)getPlanItemDefinitionGroup()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION:
                return ((InternalEList<?>)getPlanItemDefinition()).basicRemove(otherEnd, msgs);
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
            case Cmmn1Package.TSTAGE__PLANNING_TABLE:
                return getPlanningTable();
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION_GROUP:
                if (coreType) return getPlanItemDefinitionGroup();
                return ((FeatureMap.Internal)getPlanItemDefinitionGroup()).getWrapper();
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION:
                return getPlanItemDefinition();
            case Cmmn1Package.TSTAGE__AUTO_COMPLETE:
                return isAutoComplete();
            case Cmmn1Package.TSTAGE__EXIT_CRITERIA_REFS:
                return getExitCriteriaRefs();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case Cmmn1Package.TSTAGE__PLANNING_TABLE:
                setPlanningTable((TPlanningTable)newValue);
                return;
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION_GROUP:
                ((FeatureMap.Internal)getPlanItemDefinitionGroup()).set(newValue);
                return;
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION:
                getPlanItemDefinition().clear();
                getPlanItemDefinition().addAll((Collection<? extends TPlanItemDefinition>)newValue);
                return;
            case Cmmn1Package.TSTAGE__AUTO_COMPLETE:
                setAutoComplete((Boolean)newValue);
                return;
            case Cmmn1Package.TSTAGE__EXIT_CRITERIA_REFS:
                getExitCriteriaRefs().clear();
                getExitCriteriaRefs().addAll((Collection<? extends TSentry>)newValue);
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
            case Cmmn1Package.TSTAGE__PLANNING_TABLE:
                setPlanningTable((TPlanningTable)null);
                return;
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION_GROUP:
                getPlanItemDefinitionGroup().clear();
                return;
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION:
                getPlanItemDefinition().clear();
                return;
            case Cmmn1Package.TSTAGE__AUTO_COMPLETE:
                unsetAutoComplete();
                return;
            case Cmmn1Package.TSTAGE__EXIT_CRITERIA_REFS:
                getExitCriteriaRefs().clear();
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
            case Cmmn1Package.TSTAGE__PLANNING_TABLE:
                return planningTable != null;
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION_GROUP:
                return planItemDefinitionGroup != null && !planItemDefinitionGroup.isEmpty();
            case Cmmn1Package.TSTAGE__PLAN_ITEM_DEFINITION:
                return !getPlanItemDefinition().isEmpty();
            case Cmmn1Package.TSTAGE__AUTO_COMPLETE:
                return isSetAutoComplete();
            case Cmmn1Package.TSTAGE__EXIT_CRITERIA_REFS:
                return exitCriteriaRefs != null && !exitCriteriaRefs.isEmpty();
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
        result.append(" (planItemDefinitionGroup: ");
        result.append(planItemDefinitionGroup);
        result.append(", autoComplete: ");
        if (autoCompleteESet) result.append(autoComplete); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //TStageImpl
