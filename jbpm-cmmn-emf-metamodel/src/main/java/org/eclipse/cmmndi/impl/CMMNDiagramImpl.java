/**
 */
package org.eclipse.cmmndi.impl;

import java.util.Collection;

import org.eclipse.cmmndi.CMMNDiagram;
import org.eclipse.cmmndi.CMMNLabelStyle;
import org.eclipse.cmmndi.CMMNPlane;
import org.eclipse.cmmndi.CmmnDiPackage;
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
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNDiagramImpl#getPlane <em>Plane</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNDiagramImpl#getLabelStyle <em>Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CMMNDiagramImpl extends DiagramImpl implements CMMNDiagram {
    /**
     * The cached value of the '{@link #getPlane() <em>Plane</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPlane()
     * @generated
     * @ordered
     */
    protected CMMNPlane plane;

    /**
     * The cached value of the '{@link #getLabelStyle() <em>Label Style</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelStyle()
     * @generated
     * @ordered
     */
    protected EList<CMMNLabelStyle> labelStyle;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CMMNDiagramImpl() {
        super();
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
    public CMMNPlane getPlane() {
        return plane;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPlane(CMMNPlane newPlane, NotificationChain msgs) {
        CMMNPlane oldPlane = plane;
        plane = newPlane;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_DIAGRAM__PLANE, oldPlane, newPlane);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPlane(CMMNPlane newPlane) {
        if (newPlane != plane) {
            NotificationChain msgs = null;
            if (plane != null)
                msgs = ((InternalEObject)plane).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_DIAGRAM__PLANE, null, msgs);
            if (newPlane != null)
                msgs = ((InternalEObject)newPlane).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_DIAGRAM__PLANE, null, msgs);
            msgs = basicSetPlane(newPlane, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_DIAGRAM__PLANE, newPlane, newPlane));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<CMMNLabelStyle> getLabelStyle() {
        if (labelStyle == null) {
            labelStyle = new EObjectContainmentEList<CMMNLabelStyle>(CMMNLabelStyle.class, this, CmmnDiPackage.CMMN_DIAGRAM__LABEL_STYLE);
        }
        return labelStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CmmnDiPackage.CMMN_DIAGRAM__PLANE:
                return basicSetPlane(null, msgs);
            case CmmnDiPackage.CMMN_DIAGRAM__LABEL_STYLE:
                return ((InternalEList<?>)getLabelStyle()).basicRemove(otherEnd, msgs);
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
            case CmmnDiPackage.CMMN_DIAGRAM__PLANE:
                return getPlane();
            case CmmnDiPackage.CMMN_DIAGRAM__LABEL_STYLE:
                return getLabelStyle();
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
            case CmmnDiPackage.CMMN_DIAGRAM__PLANE:
                setPlane((CMMNPlane)newValue);
                return;
            case CmmnDiPackage.CMMN_DIAGRAM__LABEL_STYLE:
                getLabelStyle().clear();
                getLabelStyle().addAll((Collection<? extends CMMNLabelStyle>)newValue);
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
            case CmmnDiPackage.CMMN_DIAGRAM__PLANE:
                setPlane((CMMNPlane)null);
                return;
            case CmmnDiPackage.CMMN_DIAGRAM__LABEL_STYLE:
                getLabelStyle().clear();
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
            case CmmnDiPackage.CMMN_DIAGRAM__PLANE:
                return plane != null;
            case CmmnDiPackage.CMMN_DIAGRAM__LABEL_STYLE:
                return labelStyle != null && !labelStyle.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //CMMNDiagramImpl
