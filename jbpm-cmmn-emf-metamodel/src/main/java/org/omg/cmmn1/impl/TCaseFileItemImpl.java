/**
 */
package org.omg.cmmn1.impl;

import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.cmmn1.Cmmn1Package;
import org.omg.cmmn1.MultiplicityEnum;
import org.omg.cmmn1.TCaseFileItem;
import org.omg.cmmn1.TChildren;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCase File Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.cmmn1.impl.TCaseFileItemImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TCaseFileItemImpl#getDefinitionRef <em>Definition Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TCaseFileItemImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TCaseFileItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TCaseFileItemImpl#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.impl.TCaseFileItemImpl#getTargetRefs <em>Target Refs</em>}</li>
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
	 * The default value of the '{@link #getDefinitionRef() <em>Definition Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionRef()
	 * @generated
	 * @ordered
	 */
	protected static final QName DEFINITION_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinitionRef() <em>Definition Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionRef()
	 * @generated
	 * @ordered
	 */
	protected QName definitionRef = DEFINITION_REF_EDEFAULT;

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
	 * The default value of the '{@link #getSourceRef() <em>Source Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRef()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceRef() <em>Source Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRef()
	 * @generated
	 * @ordered
	 */
	protected String sourceRef = SOURCE_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetRefs() <em>Target Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRefs()
	 * @generated
	 * @ordered
	 */
	protected static final List<String> TARGET_REFS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetRefs() <em>Target Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRefs()
	 * @generated
	 * @ordered
	 */
	protected List<String> targetRefs = TARGET_REFS_EDEFAULT;

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
	public QName getDefinitionRef() {
		return definitionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitionRef(QName newDefinitionRef) {
		QName oldDefinitionRef = definitionRef;
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
	public String getSourceRef() {
		return sourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRef(String newSourceRef) {
		String oldSourceRef = sourceRef;
		sourceRef = newSourceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF, oldSourceRef, sourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getTargetRefs() {
		return targetRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRefs(List<String> newTargetRefs) {
		List<String> oldTargetRefs = targetRefs;
		targetRefs = newTargetRefs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS, oldTargetRefs, targetRefs));
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
				return getDefinitionRef();
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
				setDefinitionRef((QName)newValue);
				return;
			case Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY:
				setMultiplicity((MultiplicityEnum)newValue);
				return;
			case Cmmn1Package.TCASE_FILE_ITEM__NAME:
				setName((String)newValue);
				return;
			case Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF:
				setSourceRef((String)newValue);
				return;
			case Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS:
				setTargetRefs((List<String>)newValue);
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
				setDefinitionRef(DEFINITION_REF_EDEFAULT);
				return;
			case Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY:
				unsetMultiplicity();
				return;
			case Cmmn1Package.TCASE_FILE_ITEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF:
				setSourceRef(SOURCE_REF_EDEFAULT);
				return;
			case Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS:
				setTargetRefs(TARGET_REFS_EDEFAULT);
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
				return DEFINITION_REF_EDEFAULT == null ? definitionRef != null : !DEFINITION_REF_EDEFAULT.equals(definitionRef);
			case Cmmn1Package.TCASE_FILE_ITEM__MULTIPLICITY:
				return isSetMultiplicity();
			case Cmmn1Package.TCASE_FILE_ITEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Cmmn1Package.TCASE_FILE_ITEM__SOURCE_REF:
				return SOURCE_REF_EDEFAULT == null ? sourceRef != null : !SOURCE_REF_EDEFAULT.equals(sourceRef);
			case Cmmn1Package.TCASE_FILE_ITEM__TARGET_REFS:
				return TARGET_REFS_EDEFAULT == null ? targetRefs != null : !TARGET_REFS_EDEFAULT.equals(targetRefs);
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
		result.append(" (definitionRef: ");
		result.append(definitionRef);
		result.append(", multiplicity: ");
		if (multiplicityESet) result.append(multiplicity); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", sourceRef: ");
		result.append(sourceRef);
		result.append(", targetRefs: ");
		result.append(targetRefs);
		result.append(')');
		return result.toString();
	}

} //TCaseFileItemImpl
