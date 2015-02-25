/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.MultiplicityEnum;
import org.eclipse.cmmn1.TCaseFileItem;
import org.eclipse.cmmn1.TCaseFileItemDefinition;
import org.eclipse.cmmn1.TChildren;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCase File Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemImpl#getDefinitionRef <em>Definition Ref</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemImpl#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemImpl#getTargetRefs <em>Target Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCaseFileItemImpl extends TCmmnElementImpl implements TCaseFileItem {
    /**
     * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildren()
     * @generated
     * @ordered
     */
    protected TChildren children;

    /**
     * The cached value of the '{@link #getDefinitionRef() <em>Definition Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefinitionRef()
     * @generated
     * @ordered
     */
    protected TCaseFileItemDefinition definitionRef;

    /**
     * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMultiplicity()
     * @generated
     * @ordered
     */
    protected static final MultiplicityEnum MULTIPLICITY_EDEFAULT = MultiplicityEnum.UNSPECIFIED;

    /**
     * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMultiplicity()
     * @generated
     * @ordered
     */
    protected MultiplicityEnum multiplicity = MULTIPLICITY_EDEFAULT;

    /**
     * This is true if the Multiplicity attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean multiplicityESet;

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
     * The cached value of the '{@link #getSourceRef() <em>Source Ref</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceRef()
     * @generated
     * @ordered
     */
    protected EList<TCaseFileItem> sourceRef;

    /**
     * The cached value of the '{@link #getTargetRefs() <em>Target Refs</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetRefs()
     * @generated
     * @ordered
     */
    protected EList<TCaseFileItem> targetRefs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TCaseFileItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TCASE_FILE_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TChildren getChildren() {
        return children;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetChildren(TChildren newChildren, NotificationChain msgs) {
        TChildren oldChildren = children;
        children = newChildren;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM__CHILDREN, oldChildren, newChildren);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setChildren(TChildren newChildren) {
        if (newChildren != children) {
            NotificationChain msgs = null;
            if (children != null)
                msgs = ((InternalEObject)children).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TCASE_FILE_ITEM__CHILDREN, null, msgs);
            if (newChildren != null)
                msgs = ((InternalEObject)newChildren).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TCASE_FILE_ITEM__CHILDREN, null, msgs);
            msgs = basicSetChildren(newChildren, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM__CHILDREN, newChildren, newChildren));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItemDefinition getDefinitionRef() {
        if (definitionRef != null && definitionRef.eIsProxy()) {
            InternalEObject oldDefinitionRef = (InternalEObject)definitionRef;
            definitionRef = (TCaseFileItemDefinition)eResolveProxy(oldDefinitionRef);
            if (definitionRef != oldDefinitionRef) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Cmmn1Package.TCASE_FILE_ITEM__DEFINITION_REF, oldDefinitionRef, definitionRef));
            }
        }
        return definitionRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCaseFileItemDefinition basicGetDefinitionRef() {
        return definitionRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefinitionRef(TCaseFileItemDefinition newDefinitionRef) {
        TCaseFileItemDefinition oldDefinitionRef = definitionRef;
        definitionRef = newDefinitionRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM__DEFINITION_REF, oldDefinitionRef, definitionRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MultiplicityEnum getMultiplicity() {
        return multiplicity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMultiplicity(MultiplicityEnum newMultiplicity) {
        MultiplicityEnum oldMultiplicity = multiplicity;
        multiplicity = newMultiplicity == null ? MULTIPLICITY_EDEFAULT : newMultiplicity;
        boolean oldMultiplicityESet = multiplicityESet;
        multiplicityESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY, oldMultiplicity, multiplicity, !oldMultiplicityESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetMultiplicity() {
        MultiplicityEnum oldMultiplicity = multiplicity;
        boolean oldMultiplicityESet = multiplicityESet;
        multiplicity = MULTIPLICITY_EDEFAULT;
        multiplicityESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY, oldMultiplicity, MULTIPLICITY_EDEFAULT, oldMultiplicityESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetMultiplicity() {
        return multiplicityESet;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TCaseFileItem> getSourceRef() {
        if (sourceRef == null) {
            sourceRef = new EObjectResolvingEList<TCaseFileItem>(TCaseFileItem.class, this, Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF);
        }
        return sourceRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TCaseFileItem> getTargetRefs() {
        if (targetRefs == null) {
            targetRefs = new EObjectResolvingEList<TCaseFileItem>(TCaseFileItem.class, this, Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS);
        }
        return targetRefs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TCASE_FILE_ITEM__CHILDREN:
                return basicSetChildren(null, msgs);
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
            case Cmmn1Package.TCASE_FILE_ITEM__CHILDREN:
                return getChildren();
            case Cmmn1Package.TCASE_FILE_ITEM__DEFINITION_REF:
                if (resolve) return getDefinitionRef();
                return basicGetDefinitionRef();
            case Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY:
                return getMultiplicity();
            case Cmmn1Package.TCASE_FILE_ITEM__NAME:
                return getName();
            case Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF:
                return getSourceRef();
            case Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS:
                return getTargetRefs();
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
            case Cmmn1Package.TCASE_FILE_ITEM__CHILDREN:
                setChildren((TChildren)newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__DEFINITION_REF:
                setDefinitionRef((TCaseFileItemDefinition)newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY:
                setMultiplicity((MultiplicityEnum)newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__NAME:
                setName((String)newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF:
                getSourceRef().clear();
                getSourceRef().addAll((Collection<? extends TCaseFileItem>)newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS:
                getTargetRefs().clear();
                getTargetRefs().addAll((Collection<? extends TCaseFileItem>)newValue);
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
            case Cmmn1Package.TCASE_FILE_ITEM__CHILDREN:
                setChildren((TChildren)null);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__DEFINITION_REF:
                setDefinitionRef((TCaseFileItemDefinition)null);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY:
                unsetMultiplicity();
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF:
                getSourceRef().clear();
                return;
            case Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS:
                getTargetRefs().clear();
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
            case Cmmn1Package.TCASE_FILE_ITEM__CHILDREN:
                return children != null;
            case Cmmn1Package.TCASE_FILE_ITEM__DEFINITION_REF:
                return definitionRef != null;
            case Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY:
                return isSetMultiplicity();
            case Cmmn1Package.TCASE_FILE_ITEM__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF:
                return sourceRef != null && !sourceRef.isEmpty();
            case Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS:
                return targetRefs != null && !targetRefs.isEmpty();
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
        result.append(" (multiplicity: ");
        if (multiplicityESet) result.append(multiplicity); else result.append("<unset>");
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //TCaseFileItemImpl
