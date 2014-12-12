/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TCaseParameter;
import org.eclipse.cmmn1.TTask;
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
 * An implementation of the model object '<em><b>TTask</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TTaskImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TTaskImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TTaskImpl#isIsBlocking <em>Is Blocking</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TTaskImpl extends TPlanItemDefinitionImpl implements TTask {
    /**
     * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputs()
     * @generated
     * @ordered
     */
    protected EList<TCaseParameter> inputs;

    /**
     * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputs()
     * @generated
     * @ordered
     */
    protected EList<TCaseParameter> outputs;

    /**
     * The default value of the '{@link #isIsBlocking() <em>Is Blocking</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsBlocking()
     * @generated
     * @ordered
     */
    protected static final boolean IS_BLOCKING_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isIsBlocking() <em>Is Blocking</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsBlocking()
     * @generated
     * @ordered
     */
    protected boolean isBlocking = IS_BLOCKING_EDEFAULT;

    /**
     * This is true if the Is Blocking attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean isBlockingESet;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TTaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TTASK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TCaseParameter> getInputs() {
        if (inputs == null) {
            inputs = new EObjectContainmentEList<TCaseParameter>(TCaseParameter.class, this, Cmmn1Package.TTASK__INPUTS);
        }
        return inputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TCaseParameter> getOutputs() {
        if (outputs == null) {
            outputs = new EObjectContainmentEList<TCaseParameter>(TCaseParameter.class, this, Cmmn1Package.TTASK__OUTPUTS);
        }
        return outputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsBlocking() {
        return isBlocking;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsBlocking(boolean newIsBlocking) {
        boolean oldIsBlocking = isBlocking;
        isBlocking = newIsBlocking;
        boolean oldIsBlockingESet = isBlockingESet;
        isBlockingESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TTASK__IS_BLOCKING, oldIsBlocking, isBlocking, !oldIsBlockingESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetIsBlocking() {
        boolean oldIsBlocking = isBlocking;
        boolean oldIsBlockingESet = isBlockingESet;
        isBlocking = IS_BLOCKING_EDEFAULT;
        isBlockingESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, Cmmn1Package.TTASK__IS_BLOCKING, oldIsBlocking, IS_BLOCKING_EDEFAULT, oldIsBlockingESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetIsBlocking() {
        return isBlockingESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TTASK__INPUTS:
                return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TTASK__OUTPUTS:
                return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
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
            case Cmmn1Package.TTASK__INPUTS:
                return getInputs();
            case Cmmn1Package.TTASK__OUTPUTS:
                return getOutputs();
            case Cmmn1Package.TTASK__IS_BLOCKING:
                return isIsBlocking();
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
            case Cmmn1Package.TTASK__INPUTS:
                getInputs().clear();
                getInputs().addAll((Collection<? extends TCaseParameter>)newValue);
                return;
            case Cmmn1Package.TTASK__OUTPUTS:
                getOutputs().clear();
                getOutputs().addAll((Collection<? extends TCaseParameter>)newValue);
                return;
            case Cmmn1Package.TTASK__IS_BLOCKING:
                setIsBlocking((Boolean)newValue);
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
            case Cmmn1Package.TTASK__INPUTS:
                getInputs().clear();
                return;
            case Cmmn1Package.TTASK__OUTPUTS:
                getOutputs().clear();
                return;
            case Cmmn1Package.TTASK__IS_BLOCKING:
                unsetIsBlocking();
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
            case Cmmn1Package.TTASK__INPUTS:
                return inputs != null && !inputs.isEmpty();
            case Cmmn1Package.TTASK__OUTPUTS:
                return outputs != null && !outputs.isEmpty();
            case Cmmn1Package.TTASK__IS_BLOCKING:
                return isSetIsBlocking();
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
        result.append(" (isBlocking: ");
        if (isBlockingESet) result.append(isBlocking); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //TTaskImpl
