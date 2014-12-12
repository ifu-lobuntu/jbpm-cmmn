/**
 */
package org.eclipse.cmmndi.impl;

import org.eclipse.cmmndi.CMMNLabel;
import org.eclipse.cmmndi.CMMNLabelStyle;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.dd.cmmn.di.impl.LabelImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CMMN Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNLabelImpl#getLabelStyle <em>Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CMMNLabelImpl extends LabelImpl implements CMMNLabel {
    /**
     * The cached value of the '{@link #getLabelStyle() <em>Label Style</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelStyle()
     * @generated
     * @ordered
     */
    protected CMMNLabelStyle labelStyle;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CMMNLabelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CmmnDiPackage.Literals.CMMN_LABEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNLabelStyle getLabelStyle() {
        if (labelStyle != null && labelStyle.eIsProxy()) {
            InternalEObject oldLabelStyle = (InternalEObject)labelStyle;
            labelStyle = (CMMNLabelStyle)eResolveProxy(oldLabelStyle);
            if (labelStyle != oldLabelStyle) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CmmnDiPackage.CMMN_LABEL__LABEL_STYLE, oldLabelStyle, labelStyle));
            }
        }
        return labelStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNLabelStyle basicGetLabelStyle() {
        return labelStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabelStyle(CMMNLabelStyle newLabelStyle) {
        CMMNLabelStyle oldLabelStyle = labelStyle;
        labelStyle = newLabelStyle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_LABEL__LABEL_STYLE, oldLabelStyle, labelStyle));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CmmnDiPackage.CMMN_LABEL__LABEL_STYLE:
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
            case CmmnDiPackage.CMMN_LABEL__LABEL_STYLE:
                setLabelStyle((CMMNLabelStyle)newValue);
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
            case CmmnDiPackage.CMMN_LABEL__LABEL_STYLE:
                setLabelStyle((CMMNLabelStyle)null);
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
            case CmmnDiPackage.CMMN_LABEL__LABEL_STYLE:
                return labelStyle != null;
        }
        return super.eIsSet(featureID);
    }

} //CMMNLabelImpl
