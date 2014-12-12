/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TCase;
import org.eclipse.cmmn1.TCaseFile;
import org.eclipse.cmmn1.TCaseParameter;
import org.eclipse.cmmn1.TRole;
import org.eclipse.cmmn1.TStage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCase</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseImpl#getCaseFileModel <em>Case File Model</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseImpl#getCasePlanModel <em>Case Plan Model</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseImpl#getCaseRoles <em>Case Roles</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCaseImpl extends TCmmnElementImpl implements TCase {
    /**
     * The cached value of the '{@link #getCaseFileModel() <em>Case File Model</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCaseFileModel()
     * @generated
     * @ordered
     */
    protected TCaseFile caseFileModel;

    /**
     * The cached value of the '{@link #getCasePlanModel() <em>Case Plan Model</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCasePlanModel()
     * @generated
     * @ordered
     */
    protected TStage casePlanModel;

    /**
     * The cached value of the '{@link #getCaseRoles() <em>Case Roles</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCaseRoles()
     * @generated
     * @ordered
     */
    protected EList<TRole> caseRoles;

    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInput()
     * @generated
     * @ordered
     */
    protected EList<TCaseParameter> input;

    /**
     * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutput()
     * @generated
     * @ordered
     */
    protected EList<TCaseParameter> output;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TCaseImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TCASE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFile getCaseFileModel() {
        return caseFileModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCaseFileModel(TCaseFile newCaseFileModel, NotificationChain msgs) {
        TCaseFile oldCaseFileModel = caseFileModel;
        caseFileModel = newCaseFileModel;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE__CASE_FILE_MODEL, oldCaseFileModel, newCaseFileModel);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCaseFileModel(TCaseFile newCaseFileModel) {
        if (newCaseFileModel != caseFileModel) {
            NotificationChain msgs = null;
            if (caseFileModel != null)
                msgs = ((InternalEObject)caseFileModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TCASE__CASE_FILE_MODEL, null, msgs);
            if (newCaseFileModel != null)
                msgs = ((InternalEObject)newCaseFileModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TCASE__CASE_FILE_MODEL, null, msgs);
            msgs = basicSetCaseFileModel(newCaseFileModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE__CASE_FILE_MODEL, newCaseFileModel, newCaseFileModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TStage getCasePlanModel() {
        return casePlanModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCasePlanModel(TStage newCasePlanModel, NotificationChain msgs) {
        TStage oldCasePlanModel = casePlanModel;
        casePlanModel = newCasePlanModel;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE__CASE_PLAN_MODEL, oldCasePlanModel, newCasePlanModel);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCasePlanModel(TStage newCasePlanModel) {
        if (newCasePlanModel != casePlanModel) {
            NotificationChain msgs = null;
            if (casePlanModel != null)
                msgs = ((InternalEObject)casePlanModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TCASE__CASE_PLAN_MODEL, null, msgs);
            if (newCasePlanModel != null)
                msgs = ((InternalEObject)newCasePlanModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TCASE__CASE_PLAN_MODEL, null, msgs);
            msgs = basicSetCasePlanModel(newCasePlanModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE__CASE_PLAN_MODEL, newCasePlanModel, newCasePlanModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TRole> getCaseRoles() {
        if (caseRoles == null) {
            caseRoles = new EObjectContainmentEList<TRole>(TRole.class, this, Cmmn1Package.TCASE__CASE_ROLES);
        }
        return caseRoles;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TCaseParameter> getInput() {
        if (input == null) {
            input = new EObjectContainmentEList<TCaseParameter>(TCaseParameter.class, this, Cmmn1Package.TCASE__INPUT);
        }
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TCaseParameter> getOutput() {
        if (output == null) {
            output = new EObjectContainmentEList<TCaseParameter>(TCaseParameter.class, this, Cmmn1Package.TCASE__OUTPUT);
        }
        return output;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TCASE__CASE_FILE_MODEL:
                return basicSetCaseFileModel(null, msgs);
            case Cmmn1Package.TCASE__CASE_PLAN_MODEL:
                return basicSetCasePlanModel(null, msgs);
            case Cmmn1Package.TCASE__CASE_ROLES:
                return ((InternalEList<?>)getCaseRoles()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TCASE__INPUT:
                return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TCASE__OUTPUT:
                return ((InternalEList<?>)getOutput()).basicRemove(otherEnd, msgs);
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
            case Cmmn1Package.TCASE__CASE_FILE_MODEL:
                return getCaseFileModel();
            case Cmmn1Package.TCASE__CASE_PLAN_MODEL:
                return getCasePlanModel();
            case Cmmn1Package.TCASE__CASE_ROLES:
                return getCaseRoles();
            case Cmmn1Package.TCASE__INPUT:
                return getInput();
            case Cmmn1Package.TCASE__OUTPUT:
                return getOutput();
            case Cmmn1Package.TCASE__NAME:
                return getName();
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
            case Cmmn1Package.TCASE__CASE_FILE_MODEL:
                setCaseFileModel((TCaseFile)newValue);
                return;
            case Cmmn1Package.TCASE__CASE_PLAN_MODEL:
                setCasePlanModel((TStage)newValue);
                return;
            case Cmmn1Package.TCASE__CASE_ROLES:
                getCaseRoles().clear();
                getCaseRoles().addAll((Collection<? extends TRole>)newValue);
                return;
            case Cmmn1Package.TCASE__INPUT:
                getInput().clear();
                getInput().addAll((Collection<? extends TCaseParameter>)newValue);
                return;
            case Cmmn1Package.TCASE__OUTPUT:
                getOutput().clear();
                getOutput().addAll((Collection<? extends TCaseParameter>)newValue);
                return;
            case Cmmn1Package.TCASE__NAME:
                setName((String)newValue);
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
            case Cmmn1Package.TCASE__CASE_FILE_MODEL:
                setCaseFileModel((TCaseFile)null);
                return;
            case Cmmn1Package.TCASE__CASE_PLAN_MODEL:
                setCasePlanModel((TStage)null);
                return;
            case Cmmn1Package.TCASE__CASE_ROLES:
                getCaseRoles().clear();
                return;
            case Cmmn1Package.TCASE__INPUT:
                getInput().clear();
                return;
            case Cmmn1Package.TCASE__OUTPUT:
                getOutput().clear();
                return;
            case Cmmn1Package.TCASE__NAME:
                setName(NAME_EDEFAULT);
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
            case Cmmn1Package.TCASE__CASE_FILE_MODEL:
                return caseFileModel != null;
            case Cmmn1Package.TCASE__CASE_PLAN_MODEL:
                return casePlanModel != null;
            case Cmmn1Package.TCASE__CASE_ROLES:
                return caseRoles != null && !caseRoles.isEmpty();
            case Cmmn1Package.TCASE__INPUT:
                return input != null && !input.isEmpty();
            case Cmmn1Package.TCASE__OUTPUT:
                return output != null && !output.isEmpty();
            case Cmmn1Package.TCASE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //TCaseImpl
