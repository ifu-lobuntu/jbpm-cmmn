/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import javax.xml.namespace.QName;

import org.eclipse.cmmn1.Cmmn1Factory;
import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TCaseFileItemDefinition;
import org.eclipse.cmmn1.TProperty;
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
 * An implementation of the model object '<em><b>TCase File Item Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemDefinitionImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemDefinitionImpl#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemDefinitionImpl#getImportRef <em>Import Ref</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TCaseFileItemDefinitionImpl#getStructureRef <em>Structure Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCaseFileItemDefinitionImpl extends TCmmnElementImpl implements TCaseFileItemDefinition {
    /**
     * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperty()
     * @generated
     * @ordered
     */
    protected EList<TProperty> property;

    /**
     * The default value of the '{@link #getDefinitionType() <em>Definition Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefinitionType()
     * @generated
     * @ordered
     */
    protected static final Object DEFINITION_TYPE_EDEFAULT = Cmmn1Factory.eINSTANCE.createFromString(Cmmn1Package.eINSTANCE.getDefinitionTypeEnum(), "http://www.omg.org/spec/CMMN/DefinitionType/Unspecified");

    /**
     * The cached value of the '{@link #getDefinitionType() <em>Definition Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefinitionType()
     * @generated
     * @ordered
     */
    protected Object definitionType = DEFINITION_TYPE_EDEFAULT;

    /**
     * This is true if the Definition Type attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean definitionTypeESet;

    /**
     * The default value of the '{@link #getImportRef() <em>Import Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportRef()
     * @generated
     * @ordered
     */
    protected static final QName IMPORT_REF_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImportRef() <em>Import Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportRef()
     * @generated
     * @ordered
     */
    protected QName importRef = IMPORT_REF_EDEFAULT;

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
     * The default value of the '{@link #getStructureRef() <em>Structure Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStructureRef()
     * @generated
     * @ordered
     */
    protected static final QName STRUCTURE_REF_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStructureRef() <em>Structure Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStructureRef()
     * @generated
     * @ordered
     */
    protected QName structureRef = STRUCTURE_REF_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TCaseFileItemDefinitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TCASE_FILE_ITEM_DEFINITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TProperty> getProperty() {
        if (property == null) {
            property = new EObjectContainmentEList<TProperty>(TProperty.class, this, Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__PROPERTY);
        }
        return property;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getDefinitionType() {
        return definitionType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefinitionType(Object newDefinitionType) {
        Object oldDefinitionType = definitionType;
        definitionType = newDefinitionType;
        boolean oldDefinitionTypeESet = definitionTypeESet;
        definitionTypeESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__DEFINITION_TYPE, oldDefinitionType, definitionType, !oldDefinitionTypeESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetDefinitionType() {
        Object oldDefinitionType = definitionType;
        boolean oldDefinitionTypeESet = definitionTypeESet;
        definitionType = DEFINITION_TYPE_EDEFAULT;
        definitionTypeESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__DEFINITION_TYPE, oldDefinitionType, DEFINITION_TYPE_EDEFAULT, oldDefinitionTypeESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetDefinitionType() {
        return definitionTypeESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QName getImportRef() {
        return importRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImportRef(QName newImportRef) {
        QName oldImportRef = importRef;
        importRef = newImportRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__IMPORT_REF, oldImportRef, importRef));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QName getStructureRef() {
        return structureRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStructureRef(QName newStructureRef) {
        QName oldStructureRef = structureRef;
        structureRef = newStructureRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__STRUCTURE_REF, oldStructureRef, structureRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__PROPERTY:
                return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
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
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__PROPERTY:
                return getProperty();
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__DEFINITION_TYPE:
                return getDefinitionType();
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__IMPORT_REF:
                return getImportRef();
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__NAME:
                return getName();
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__STRUCTURE_REF:
                return getStructureRef();
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
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__PROPERTY:
                getProperty().clear();
                getProperty().addAll((Collection<? extends TProperty>)newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__DEFINITION_TYPE:
                setDefinitionType(newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__IMPORT_REF:
                setImportRef((QName)newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__NAME:
                setName((String)newValue);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__STRUCTURE_REF:
                setStructureRef((QName)newValue);
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
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__PROPERTY:
                getProperty().clear();
                return;
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__DEFINITION_TYPE:
                unsetDefinitionType();
                return;
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__IMPORT_REF:
                setImportRef(IMPORT_REF_EDEFAULT);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__STRUCTURE_REF:
                setStructureRef(STRUCTURE_REF_EDEFAULT);
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
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__PROPERTY:
                return property != null && !property.isEmpty();
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__DEFINITION_TYPE:
                return isSetDefinitionType();
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__IMPORT_REF:
                return IMPORT_REF_EDEFAULT == null ? importRef != null : !IMPORT_REF_EDEFAULT.equals(importRef);
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Cmmn1Package.TCASE_FILE_ITEM_DEFINITION__STRUCTURE_REF:
                return STRUCTURE_REF_EDEFAULT == null ? structureRef != null : !STRUCTURE_REF_EDEFAULT.equals(structureRef);
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
        result.append(" (definitionType: ");
        if (definitionTypeESet) result.append(definitionType); else result.append("<unset>");
        result.append(", importRef: ");
        result.append(importRef);
        result.append(", name: ");
        result.append(name);
        result.append(", structureRef: ");
        result.append(structureRef);
        result.append(')');
        return result.toString();
    }

} //TCaseFileItemDefinitionImpl
