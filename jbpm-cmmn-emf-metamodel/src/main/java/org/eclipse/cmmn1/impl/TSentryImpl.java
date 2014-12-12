/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TIfPart;
import org.eclipse.cmmn1.TOnPart;
import org.eclipse.cmmn1.TSentry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TSentry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TSentryImpl#getOnPartGroup <em>On Part Group</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TSentryImpl#getOnPart <em>On Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TSentryImpl#getIfPart <em>If Part</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TSentryImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TSentryImpl extends TCmmnElementImpl implements TSentry {
    /**
     * The cached value of the '{@link #getOnPartGroup() <em>On Part Group</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnPartGroup()
     * @generated
     * @ordered
     */
    protected FeatureMap onPartGroup;

    /**
     * The cached value of the '{@link #getIfPart() <em>If Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIfPart()
     * @generated
     * @ordered
     */
    protected TIfPart ifPart;

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
    protected TSentryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TSENTRY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getOnPartGroup() {
        if (onPartGroup == null) {
            onPartGroup = new BasicFeatureMap(this, Cmmn1Package.TSENTRY__ON_PART_GROUP);
        }
        return onPartGroup;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TOnPart> getOnPart() {
        return getOnPartGroup().list(Cmmn1Package.Literals.TSENTRY__ON_PART);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TIfPart getIfPart() {
        return ifPart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetIfPart(TIfPart newIfPart, NotificationChain msgs) {
        TIfPart oldIfPart = ifPart;
        ifPart = newIfPart;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TSENTRY__IF_PART, oldIfPart, newIfPart);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIfPart(TIfPart newIfPart) {
        if (newIfPart != ifPart) {
            NotificationChain msgs = null;
            if (ifPart != null)
                msgs = ((InternalEObject)ifPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TSENTRY__IF_PART, null, msgs);
            if (newIfPart != null)
                msgs = ((InternalEObject)newIfPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TSENTRY__IF_PART, null, msgs);
            msgs = basicSetIfPart(newIfPart, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TSENTRY__IF_PART, newIfPart, newIfPart));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TSENTRY__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TSENTRY__ON_PART_GROUP:
                return ((InternalEList<?>)getOnPartGroup()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TSENTRY__ON_PART:
                return ((InternalEList<?>)getOnPart()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TSENTRY__IF_PART:
                return basicSetIfPart(null, msgs);
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
            case Cmmn1Package.TSENTRY__ON_PART_GROUP:
                if (coreType) return getOnPartGroup();
                return ((FeatureMap.Internal)getOnPartGroup()).getWrapper();
            case Cmmn1Package.TSENTRY__ON_PART:
                return getOnPart();
            case Cmmn1Package.TSENTRY__IF_PART:
                return getIfPart();
            case Cmmn1Package.TSENTRY__NAME:
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
            case Cmmn1Package.TSENTRY__ON_PART_GROUP:
                ((FeatureMap.Internal)getOnPartGroup()).set(newValue);
                return;
            case Cmmn1Package.TSENTRY__ON_PART:
                getOnPart().clear();
                getOnPart().addAll((Collection<? extends TOnPart>)newValue);
                return;
            case Cmmn1Package.TSENTRY__IF_PART:
                setIfPart((TIfPart)newValue);
                return;
            case Cmmn1Package.TSENTRY__NAME:
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
            case Cmmn1Package.TSENTRY__ON_PART_GROUP:
                getOnPartGroup().clear();
                return;
            case Cmmn1Package.TSENTRY__ON_PART:
                getOnPart().clear();
                return;
            case Cmmn1Package.TSENTRY__IF_PART:
                setIfPart((TIfPart)null);
                return;
            case Cmmn1Package.TSENTRY__NAME:
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
            case Cmmn1Package.TSENTRY__ON_PART_GROUP:
                return onPartGroup != null && !onPartGroup.isEmpty();
            case Cmmn1Package.TSENTRY__ON_PART:
                return !getOnPart().isEmpty();
            case Cmmn1Package.TSENTRY__IF_PART:
                return ifPart != null;
            case Cmmn1Package.TSENTRY__NAME:
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
        result.append(" (onPartGroup: ");
        result.append(onPartGroup);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //TSentryImpl
