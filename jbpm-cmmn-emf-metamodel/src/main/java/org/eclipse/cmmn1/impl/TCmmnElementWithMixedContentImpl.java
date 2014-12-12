/**
 */
package org.eclipse.cmmn1.impl;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TCmmnElementWithMixedContent;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCmmn Element With Mixed Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TCmmnElementWithMixedContentImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCmmnElementWithMixedContentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCmmnElementWithMixedContentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCmmnElementWithMixedContentImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TCmmnElementWithMixedContentImpl extends MinimalEObjectImpl.Container implements TCmmnElementWithMixedContent {
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
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAnyAttribute()
     * @generated
     * @ordered
     */
    protected FeatureMap anyAttribute;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TCmmnElementWithMixedContentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TCMMN_ELEMENT_WITH_MIXED_CONTENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getMixed() {
        if (mixed == null) {
            mixed = new BasicFeatureMap(this, Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__MIXED);
        }
        return mixed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getAnyAttribute() {
        if (anyAttribute == null) {
            anyAttribute = new BasicFeatureMap(this, Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ANY_ATTRIBUTE);
        }
        return anyAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__MIXED:
                return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ANY_ATTRIBUTE:
                return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__MIXED:
                if (coreType) return getMixed();
                return ((FeatureMap.Internal)getMixed()).getWrapper();
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__DESCRIPTION:
                return getDescription();
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ID:
                return getId();
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ANY_ATTRIBUTE:
                if (coreType) return getAnyAttribute();
                return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
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
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__MIXED:
                ((FeatureMap.Internal)getMixed()).set(newValue);
                return;
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ID:
                setId((String)newValue);
                return;
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ANY_ATTRIBUTE:
                ((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__MIXED:
                getMixed().clear();
                return;
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ID:
                setId(ID_EDEFAULT);
                return;
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ANY_ATTRIBUTE:
                getAnyAttribute().clear();
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
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__MIXED:
                return mixed != null && !mixed.isEmpty();
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case Cmmn1Package.TCMMN_ELEMENT_WITH_MIXED_CONTENT__ANY_ATTRIBUTE:
                return anyAttribute != null && !anyAttribute.isEmpty();
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
        result.append(", description: ");
        result.append(description);
        result.append(", id: ");
        result.append(id);
        result.append(", anyAttribute: ");
        result.append(anyAttribute);
        result.append(')');
        return result.toString();
    }

} //TCmmnElementWithMixedContentImpl
