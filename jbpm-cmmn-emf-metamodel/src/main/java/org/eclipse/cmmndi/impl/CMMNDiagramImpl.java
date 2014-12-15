/**
 */
package org.eclipse.cmmndi.impl;

import java.util.Collection;

import org.eclipse.cmmndi.CMMNDiagram;
import org.eclipse.cmmndi.CMMNLabelStyle;
import org.eclipse.cmmndi.CMMNPlane;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.dd.cmmn.di.DiagramElement;
import org.eclipse.dd.cmmn.di.impl.DiagramImpl;
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
 * An implementation of the model object '<em><b>CMMN Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNDiagramImpl#getCMMNPlane <em>CMMN Plane</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNDiagramImpl#getCMMNLabelStyle <em>CMMN Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CMMNDiagramImpl extends DiagramImpl implements CMMNDiagram {
    /**
     * The cached value of the '{@link #getCMMNPlane() <em>CMMN Plane</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCMMNPlane()
     * @generated
     * @ordered
     */
    protected CMMNPlane cMMNPlane;

    /**
     * The cached value of the '{@link #getCMMNLabelStyle() <em>CMMN Label Style</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCMMNLabelStyle()
     * @generated
     * @ordered
     */
    protected EList<CMMNLabelStyle> cMMNLabelStyle;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CMMNDiagramImpl() {
        super();
    }

    @Override
    public DiagramElement getRootElement() {
        return this.getCMMNPlane();
    }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CmmnDiPackage.Literals.CMMN_DIAGRAM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNPlane getCMMNPlane() {
        return cMMNPlane;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCMMNPlane(CMMNPlane newCMMNPlane, NotificationChain msgs) {
        CMMNPlane oldCMMNPlane = cMMNPlane;
        cMMNPlane = newCMMNPlane;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE, oldCMMNPlane, newCMMNPlane);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMMNPlane(CMMNPlane newCMMNPlane) {
        if (newCMMNPlane != cMMNPlane) {
            NotificationChain msgs = null;
            if (cMMNPlane != null)
                msgs = ((InternalEObject)cMMNPlane).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE, null, msgs);
            if (newCMMNPlane != null)
                msgs = ((InternalEObject)newCMMNPlane).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE, null, msgs);
            msgs = basicSetCMMNPlane(newCMMNPlane, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE, newCMMNPlane, newCMMNPlane));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<CMMNLabelStyle> getCMMNLabelStyle() {
        if (cMMNLabelStyle == null) {
            cMMNLabelStyle = new EObjectContainmentEList<CMMNLabelStyle>(CMMNLabelStyle.class, this, CmmnDiPackage.CMMN_DIAGRAM__CMMN_LABEL_STYLE);
        }
        return cMMNLabelStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE:
                return basicSetCMMNPlane(null, msgs);
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_LABEL_STYLE:
                return ((InternalEList<?>)getCMMNLabelStyle()).basicRemove(otherEnd, msgs);
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
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE:
                return getCMMNPlane();
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_LABEL_STYLE:
                return getCMMNLabelStyle();
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
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE:
                setCMMNPlane((CMMNPlane)newValue);
                return;
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_LABEL_STYLE:
                getCMMNLabelStyle().clear();
                getCMMNLabelStyle().addAll((Collection<? extends CMMNLabelStyle>)newValue);
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
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE:
                setCMMNPlane((CMMNPlane)null);
                return;
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_LABEL_STYLE:
                getCMMNLabelStyle().clear();
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
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_PLANE:
                return cMMNPlane != null;
            case CmmnDiPackage.CMMN_DIAGRAM__CMMN_LABEL_STYLE:
                return cMMNLabelStyle != null && !cMMNLabelStyle.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //CMMNDiagramImpl
