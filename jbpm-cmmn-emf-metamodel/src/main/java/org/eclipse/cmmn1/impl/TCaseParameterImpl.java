/**
 */
package org.eclipse.cmmn1.impl;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TCaseFileItem;
import org.eclipse.cmmn1.TCaseParameter;
import org.eclipse.cmmn1.TExpression;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCase Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseParameterImpl#getBindingRefinement <em>Binding Refinement</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseParameterImpl#getBindingRef <em>Binding Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCaseParameterImpl extends TParameterImpl implements TCaseParameter {
    /**
     * The cached value of the '{@link #getBindingRefinement() <em>Binding Refinement</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBindingRefinement()
     * @generated
     * @ordered
     */
    protected TExpression bindingRefinement;

    /**
     * The cached value of the '{@link #getBindingRef() <em>Binding Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBindingRef()
     * @generated
     * @ordered
     */
    protected TCaseFileItem bindingRef;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TCaseParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TCASE_PARAMETER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TExpression getBindingRefinement() {
        return bindingRefinement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBindingRefinement(TExpression newBindingRefinement, NotificationChain msgs) {
        TExpression oldBindingRefinement = bindingRefinement;
        bindingRefinement = newBindingRefinement;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT, oldBindingRefinement, newBindingRefinement);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBindingRefinement(TExpression newBindingRefinement) {
        if (newBindingRefinement != bindingRefinement) {
            NotificationChain msgs = null;
            if (bindingRefinement != null)
                msgs = ((InternalEObject)bindingRefinement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT, null, msgs);
            if (newBindingRefinement != null)
                msgs = ((InternalEObject)newBindingRefinement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT, null, msgs);
            msgs = basicSetBindingRefinement(newBindingRefinement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT, newBindingRefinement, newBindingRefinement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItem getBindingRef() {
        if (bindingRef != null && bindingRef.eIsProxy()) {
            InternalEObject oldBindingRef = (InternalEObject)bindingRef;
            bindingRef = (TCaseFileItem)eResolveProxy(oldBindingRef);
            if (bindingRef != oldBindingRef) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Cmmn1Package.TCASE_PARAMETER__BINDING_REF, oldBindingRef, bindingRef));
            }
        }
        return bindingRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItem basicGetBindingRef() {
        return bindingRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBindingRef(TCaseFileItem newBindingRef) {
        TCaseFileItem oldBindingRef = bindingRef;
        bindingRef = newBindingRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_PARAMETER__BINDING_REF, oldBindingRef, bindingRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT:
                return basicSetBindingRefinement(null, msgs);
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
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT:
                return getBindingRefinement();
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REF:
                if (resolve) return getBindingRef();
                return basicGetBindingRef();
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
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT:
                setBindingRefinement((TExpression)newValue);
                return;
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REF:
                setBindingRef((TCaseFileItem)newValue);
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
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT:
                setBindingRefinement((TExpression)null);
                return;
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REF:
                setBindingRef((TCaseFileItem)null);
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
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REFINEMENT:
                return bindingRefinement != null;
            case Cmmn1Package.TCASE_PARAMETER__BINDING_REF:
                return bindingRef != null;
        }
        return super.eIsSet(featureID);
    }

} //TCaseParameterImpl
