/**
 */
package org.eclipse.uml2.di.umldi.impl;

import org.eclipse.dd.cmmn.di.impl.LabelImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.di.umldi.UMLDIPackage;
import org.eclipse.uml2.di.umldi.UMLLabel;
import org.eclipse.uml2.di.umldi.UMLLabelStyle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.di.umldi.impl.UMLLabelImpl#getLabelStyle <em>Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLLabelImpl extends LabelImpl implements UMLLabel {
    /**
     * The cached value of the '{@link #getLabelStyle() <em>Label Style</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelStyle()
     * @generated
     * @ordered
     */
    protected UMLLabelStyle labelStyle;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UMLLabelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UMLDIPackage.Literals.UML_LABEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLLabelStyle getLabelStyle() {
        if (labelStyle != null && labelStyle.eIsProxy()) {
            InternalEObject oldLabelStyle = (InternalEObject)labelStyle;
            labelStyle = (UMLLabelStyle)eResolveProxy(oldLabelStyle);
            if (labelStyle != oldLabelStyle) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDIPackage.UML_LABEL__LABEL_STYLE, oldLabelStyle, labelStyle));
            }
        }
        return labelStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLLabelStyle basicGetLabelStyle() {
        return labelStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabelStyle(UMLLabelStyle newLabelStyle) {
        UMLLabelStyle oldLabelStyle = labelStyle;
        labelStyle = newLabelStyle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.UML_LABEL__LABEL_STYLE, oldLabelStyle, labelStyle));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UMLDIPackage.UML_LABEL__LABEL_STYLE:
                if (resolve) return getLabelStyle();
                return basicGetLabelStyle();
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
            case UMLDIPackage.UML_LABEL__LABEL_STYLE:
                setLabelStyle((UMLLabelStyle)newValue);
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
            case UMLDIPackage.UML_LABEL__LABEL_STYLE:
                setLabelStyle((UMLLabelStyle)null);
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
            case UMLDIPackage.UML_LABEL__LABEL_STYLE:
                return labelStyle != null;
        }
        return super.eIsSet(featureID);
    }

} //UMLLabelImpl
