/**
 */
package org.eclipse.cmmndi.impl;

import org.eclipse.cmmn1.TCmmnElement;
import org.eclipse.cmmndi.CMMNEdge;
import org.eclipse.cmmndi.CMMNLabel;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.dd.cmmn.di.DiagramElement;
import org.eclipse.dd.cmmn.di.impl.LabeledEdgeImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CMMN Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getCMMNLabel <em>CMMN Label</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getCmmnElement <em>Cmmn Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CMMNEdgeImpl extends LabeledEdgeImpl implements CMMNEdge {
    /**
     * The cached value of the '{@link #getCMMNLabel() <em>CMMN Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCMMNLabel()
     * @generated
     * @ordered
     */
    protected CMMNLabel cMMNLabel;

    /**
     * The cached value of the '{@link #getCmmnElement() <em>Cmmn Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCmmnElement()
     * @generated
     * @ordered
     */
    protected TCmmnElement cmmnElement;

    /**
     * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceElement()
     * @generated
     * @ordered
     */
    protected DiagramElement sourceElement;

    /**
     * The cached value of the '{@link #getTargetElement() <em>Target Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetElement()
     * @generated
     * @ordered
     */
    protected DiagramElement targetElement;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CMMNEdgeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CmmnDiPackage.Literals.CMMN_EDGE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNLabel getCMMNLabel() {
        return cMMNLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCMMNLabel(CMMNLabel newCMMNLabel, NotificationChain msgs) {
        CMMNLabel oldCMMNLabel = cMMNLabel;
        cMMNLabel = newCMMNLabel;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_EDGE__CMMN_LABEL, oldCMMNLabel, newCMMNLabel);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMMNLabel(CMMNLabel newCMMNLabel) {
        if (newCMMNLabel != cMMNLabel) {
            NotificationChain msgs = null;
            if (cMMNLabel != null)
                msgs = ((InternalEObject)cMMNLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_EDGE__CMMN_LABEL, null, msgs);
            if (newCMMNLabel != null)
                msgs = ((InternalEObject)newCMMNLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_EDGE__CMMN_LABEL, null, msgs);
            msgs = basicSetCMMNLabel(newCMMNLabel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_EDGE__CMMN_LABEL, newCMMNLabel, newCMMNLabel));
    }

    @Override
    public DiagramElement getSource() {
        return getSourceElement();
    }
    @Override
    public DiagramElement getTarget() {
        return getTargetElement();
    }

    @Override
    public EObject getModelElement() {
        return getCmmnElement();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCmmnElement getCmmnElement() {
        if (cmmnElement != null && cmmnElement.eIsProxy()) {
            InternalEObject oldCmmnElement = (InternalEObject)cmmnElement;
            cmmnElement = (TCmmnElement)eResolveProxy(oldCmmnElement);
            if (cmmnElement != oldCmmnElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT, oldCmmnElement, cmmnElement));
            }
        }
        return cmmnElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TCmmnElement basicGetCmmnElement() {
        return cmmnElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCmmnElement(TCmmnElement newCmmnElement) {
        TCmmnElement oldCmmnElement = cmmnElement;
        cmmnElement = newCmmnElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT, oldCmmnElement, cmmnElement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramElement getSourceElement() {
        if (sourceElement != null && sourceElement.eIsProxy()) {
            InternalEObject oldSourceElement = (InternalEObject)sourceElement;
            sourceElement = (DiagramElement)eResolveProxy(oldSourceElement);
            if (sourceElement != oldSourceElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CmmnDiPackage.CMMN_EDGE__SOURCE_ELEMENT, oldSourceElement, sourceElement));
            }
        }
        return sourceElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramElement basicGetSourceElement() {
        return sourceElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceElement(DiagramElement newSourceElement) {
        DiagramElement oldSourceElement = sourceElement;
        sourceElement = newSourceElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_EDGE__SOURCE_ELEMENT, oldSourceElement, sourceElement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramElement getTargetElement() {
        if (targetElement != null && targetElement.eIsProxy()) {
            InternalEObject oldTargetElement = (InternalEObject)targetElement;
            targetElement = (DiagramElement)eResolveProxy(oldTargetElement);
            if (targetElement != oldTargetElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CmmnDiPackage.CMMN_EDGE__TARGET_ELEMENT, oldTargetElement, targetElement));
            }
        }
        return targetElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramElement basicGetTargetElement() {
        return targetElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetElement(DiagramElement newTargetElement) {
        DiagramElement oldTargetElement = targetElement;
        targetElement = newTargetElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_EDGE__TARGET_ELEMENT, oldTargetElement, targetElement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CmmnDiPackage.CMMN_EDGE__CMMN_LABEL:
                return basicSetCMMNLabel(null, msgs);
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
            case CmmnDiPackage.CMMN_EDGE__CMMN_LABEL:
                return getCMMNLabel();
            case CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT:
                if (resolve) return getCmmnElement();
                return basicGetCmmnElement();
            case CmmnDiPackage.CMMN_EDGE__SOURCE_ELEMENT:
                if (resolve) return getSourceElement();
                return basicGetSourceElement();
            case CmmnDiPackage.CMMN_EDGE__TARGET_ELEMENT:
                if (resolve) return getTargetElement();
                return basicGetTargetElement();
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
            case CmmnDiPackage.CMMN_EDGE__CMMN_LABEL:
                setCMMNLabel((CMMNLabel)newValue);
                return;
            case CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT:
                setCmmnElement((TCmmnElement)newValue);
                return;
            case CmmnDiPackage.CMMN_EDGE__SOURCE_ELEMENT:
                setSourceElement((DiagramElement)newValue);
                return;
            case CmmnDiPackage.CMMN_EDGE__TARGET_ELEMENT:
                setTargetElement((DiagramElement)newValue);
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
            case CmmnDiPackage.CMMN_EDGE__CMMN_LABEL:
                setCMMNLabel((CMMNLabel)null);
                return;
            case CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT:
                setCmmnElement((TCmmnElement)null);
                return;
            case CmmnDiPackage.CMMN_EDGE__SOURCE_ELEMENT:
                setSourceElement((DiagramElement)null);
                return;
            case CmmnDiPackage.CMMN_EDGE__TARGET_ELEMENT:
                setTargetElement((DiagramElement)null);
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
            case CmmnDiPackage.CMMN_EDGE__CMMN_LABEL:
                return cMMNLabel != null;
            case CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT:
                return cmmnElement != null;
            case CmmnDiPackage.CMMN_EDGE__SOURCE_ELEMENT:
                return sourceElement != null;
            case CmmnDiPackage.CMMN_EDGE__TARGET_ELEMENT:
                return targetElement != null;
        }
        return super.eIsSet(featureID);
    }

} //CMMNEdgeImpl
