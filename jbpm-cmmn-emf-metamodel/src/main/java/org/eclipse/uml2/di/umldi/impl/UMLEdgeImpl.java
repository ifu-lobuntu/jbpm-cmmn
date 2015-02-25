/**
 */
package org.eclipse.uml2.di.umldi.impl;

import org.eclipse.dd.cmmn.di.DiagramElement;
import org.eclipse.dd.cmmn.di.impl.LabeledEdgeImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.di.umldi.UMLDIPackage;
import org.eclipse.uml2.di.umldi.UMLEdge;
import org.eclipse.uml2.di.umldi.UMLLabel;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.di.umldi.impl.UMLEdgeImpl#getUmlLabel <em>Uml Label</em>}</li>
 *   <li>{@link org.eclipse.uml2.di.umldi.impl.UMLEdgeImpl#getUmlElement <em>Uml Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.di.umldi.impl.UMLEdgeImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.di.umldi.impl.UMLEdgeImpl#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLEdgeImpl extends LabeledEdgeImpl implements UMLEdge {
    /**
     * The cached value of the '{@link #getUmlLabel() <em>Uml Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUmlLabel()
     * @generated
     * @ordered
     */
    protected UMLLabel umlLabel;

    /**
     * The cached value of the '{@link #getUmlElement() <em>Uml Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUmlElement()
     * @generated
     * @ordered
     */
    protected Element umlElement;

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
    protected UMLEdgeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UMLDIPackage.Literals.UML_EDGE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLLabel getUmlLabel() {
        return umlLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUmlLabel(UMLLabel newUmlLabel, NotificationChain msgs) {
        UMLLabel oldUmlLabel = umlLabel;
        umlLabel = newUmlLabel;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.UML_EDGE__UML_LABEL, oldUmlLabel, newUmlLabel);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUmlLabel(UMLLabel newUmlLabel) {
        if (newUmlLabel != umlLabel) {
            NotificationChain msgs = null;
            if (umlLabel != null)
                msgs = ((InternalEObject)umlLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.UML_EDGE__UML_LABEL, null, msgs);
            if (newUmlLabel != null)
                msgs = ((InternalEObject)newUmlLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.UML_EDGE__UML_LABEL, null, msgs);
            msgs = basicSetUmlLabel(newUmlLabel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.UML_EDGE__UML_LABEL, newUmlLabel, newUmlLabel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Element getUmlElement() {
        if (umlElement != null && umlElement.eIsProxy()) {
            InternalEObject oldUmlElement = (InternalEObject)umlElement;
            umlElement = (Element)eResolveProxy(oldUmlElement);
            if (umlElement != oldUmlElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDIPackage.UML_EDGE__UML_ELEMENT, oldUmlElement, umlElement));
            }
        }
        return umlElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Element basicGetUmlElement() {
        return umlElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUmlElement(Element newUmlElement) {
        Element oldUmlElement = umlElement;
        umlElement = newUmlElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.UML_EDGE__UML_ELEMENT, oldUmlElement, umlElement));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDIPackage.UML_EDGE__SOURCE_ELEMENT, oldSourceElement, sourceElement));
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
            eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.UML_EDGE__SOURCE_ELEMENT, oldSourceElement, sourceElement));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDIPackage.UML_EDGE__TARGET_ELEMENT, oldTargetElement, targetElement));
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
            eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.UML_EDGE__TARGET_ELEMENT, oldTargetElement, targetElement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UMLDIPackage.UML_EDGE__UML_LABEL:
                return basicSetUmlLabel(null, msgs);
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
            case UMLDIPackage.UML_EDGE__UML_LABEL:
                return getUmlLabel();
            case UMLDIPackage.UML_EDGE__UML_ELEMENT:
                if (resolve) return getUmlElement();
                return basicGetUmlElement();
            case UMLDIPackage.UML_EDGE__SOURCE_ELEMENT:
                if (resolve) return getSourceElement();
                return basicGetSourceElement();
            case UMLDIPackage.UML_EDGE__TARGET_ELEMENT:
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
            case UMLDIPackage.UML_EDGE__UML_LABEL:
                setUmlLabel((UMLLabel)newValue);
                return;
            case UMLDIPackage.UML_EDGE__UML_ELEMENT:
                setUmlElement((Element)newValue);
                return;
            case UMLDIPackage.UML_EDGE__SOURCE_ELEMENT:
                setSourceElement((DiagramElement)newValue);
                return;
            case UMLDIPackage.UML_EDGE__TARGET_ELEMENT:
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
            case UMLDIPackage.UML_EDGE__UML_LABEL:
                setUmlLabel((UMLLabel)null);
                return;
            case UMLDIPackage.UML_EDGE__UML_ELEMENT:
                setUmlElement((Element)null);
                return;
            case UMLDIPackage.UML_EDGE__SOURCE_ELEMENT:
                setSourceElement((DiagramElement)null);
                return;
            case UMLDIPackage.UML_EDGE__TARGET_ELEMENT:
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
            case UMLDIPackage.UML_EDGE__UML_LABEL:
                return umlLabel != null;
            case UMLDIPackage.UML_EDGE__UML_ELEMENT:
                return umlElement != null;
            case UMLDIPackage.UML_EDGE__SOURCE_ELEMENT:
                return sourceElement != null;
            case UMLDIPackage.UML_EDGE__TARGET_ELEMENT:
                return targetElement != null;
        }
        return super.eIsSet(featureID);
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
        return getUmlElement();
    }
} //UMLEdgeImpl
