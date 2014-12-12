/**
 */
package org.eclipse.cmmndi.impl;

import org.eclipse.cmmn1.TCmmnElement;
import org.eclipse.cmmndi.CMMNEdge;
import org.eclipse.cmmndi.CMMNLabel;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.cmmndi.MessageVisibleKind;
import org.eclipse.dd.cmmn.di.DiagramElement;
import org.eclipse.dd.cmmn.di.impl.LabeledEdgeImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CMMN Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getCmmnElement <em>Cmmn Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getMessageVisibleKind <em>Message Visible Kind</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNEdgeImpl#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CMMNEdgeImpl extends LabeledEdgeImpl implements CMMNEdge {
    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected CMMNLabel label;

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
     * The default value of the '{@link #getMessageVisibleKind() <em>Message Visible Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessageVisibleKind()
     * @generated
     * @ordered
     */
    protected static final MessageVisibleKind MESSAGE_VISIBLE_KIND_EDEFAULT = MessageVisibleKind.INITIATING;

    /**
     * The cached value of the '{@link #getMessageVisibleKind() <em>Message Visible Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessageVisibleKind()
     * @generated
     * @ordered
     */
    protected MessageVisibleKind messageVisibleKind = MESSAGE_VISIBLE_KIND_EDEFAULT;

    /**
     * This is true if the Message Visible Kind attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean messageVisibleKindESet;

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
    public CMMNLabel getLabel() {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLabel(CMMNLabel newLabel, NotificationChain msgs) {
        CMMNLabel oldLabel = label;
        label = newLabel;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_EDGE__LABEL, oldLabel, newLabel);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel(CMMNLabel newLabel) {
        if (newLabel != label) {
            NotificationChain msgs = null;
            if (label != null)
                msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_EDGE__LABEL, null, msgs);
            if (newLabel != null)
                msgs = ((InternalEObject)newLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_EDGE__LABEL, null, msgs);
            msgs = basicSetLabel(newLabel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_EDGE__LABEL, newLabel, newLabel));
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
    public MessageVisibleKind getMessageVisibleKind() {
        return messageVisibleKind;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMessageVisibleKind(MessageVisibleKind newMessageVisibleKind) {
        MessageVisibleKind oldMessageVisibleKind = messageVisibleKind;
        messageVisibleKind = newMessageVisibleKind == null ? MESSAGE_VISIBLE_KIND_EDEFAULT : newMessageVisibleKind;
        boolean oldMessageVisibleKindESet = messageVisibleKindESet;
        messageVisibleKindESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_EDGE__MESSAGE_VISIBLE_KIND, oldMessageVisibleKind, messageVisibleKind, !oldMessageVisibleKindESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetMessageVisibleKind() {
        MessageVisibleKind oldMessageVisibleKind = messageVisibleKind;
        boolean oldMessageVisibleKindESet = messageVisibleKindESet;
        messageVisibleKind = MESSAGE_VISIBLE_KIND_EDEFAULT;
        messageVisibleKindESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, CmmnDiPackage.CMMN_EDGE__MESSAGE_VISIBLE_KIND, oldMessageVisibleKind, MESSAGE_VISIBLE_KIND_EDEFAULT, oldMessageVisibleKindESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetMessageVisibleKind() {
        return messageVisibleKindESet;
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
            case CmmnDiPackage.CMMN_EDGE__LABEL:
                return basicSetLabel(null, msgs);
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
            case CmmnDiPackage.CMMN_EDGE__LABEL:
                return getLabel();
            case CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT:
                if (resolve) return getCmmnElement();
                return basicGetCmmnElement();
            case CmmnDiPackage.CMMN_EDGE__MESSAGE_VISIBLE_KIND:
                return getMessageVisibleKind();
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
            case CmmnDiPackage.CMMN_EDGE__LABEL:
                setLabel((CMMNLabel)newValue);
                return;
            case CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT:
                setCmmnElement((TCmmnElement)newValue);
                return;
            case CmmnDiPackage.CMMN_EDGE__MESSAGE_VISIBLE_KIND:
                setMessageVisibleKind((MessageVisibleKind)newValue);
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
            case CmmnDiPackage.CMMN_EDGE__LABEL:
                setLabel((CMMNLabel)null);
                return;
            case CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT:
                setCmmnElement((TCmmnElement)null);
                return;
            case CmmnDiPackage.CMMN_EDGE__MESSAGE_VISIBLE_KIND:
                unsetMessageVisibleKind();
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
            case CmmnDiPackage.CMMN_EDGE__LABEL:
                return label != null;
            case CmmnDiPackage.CMMN_EDGE__CMMN_ELEMENT:
                return cmmnElement != null;
            case CmmnDiPackage.CMMN_EDGE__MESSAGE_VISIBLE_KIND:
                return isSetMessageVisibleKind();
            case CmmnDiPackage.CMMN_EDGE__SOURCE_ELEMENT:
                return sourceElement != null;
            case CmmnDiPackage.CMMN_EDGE__TARGET_ELEMENT:
                return targetElement != null;
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
        result.append(" (messageVisibleKind: ");
        if (messageVisibleKindESet) result.append(messageVisibleKind); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //CMMNEdgeImpl
