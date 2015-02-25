/**
 */
package org.eclipse.uml2.di.umldi.impl;

import java.util.Collection;

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
import org.eclipse.uml2.di.umldi.UMLDIPackage;
import org.eclipse.uml2.di.umldi.UMLDiagram;
import org.eclipse.uml2.di.umldi.UMLLabelStyle;
import org.eclipse.uml2.di.umldi.UMLPlane;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.di.umldi.impl.UMLDiagramImpl#getUmlPlane <em>Uml Plane</em>}</li>
 *   <li>{@link org.eclipse.uml2.di.umldi.impl.UMLDiagramImpl#getLabelStyle <em>Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLDiagramImpl extends DiagramImpl implements UMLDiagram {
    /**
     * The cached value of the '{@link #getUmlPlane() <em>Uml Plane</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUmlPlane()
     * @generated
     * @ordered
     */
    protected UMLPlane umlPlane;

    /**
     * The cached value of the '{@link #getLabelStyle() <em>Label Style</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabelStyle()
     * @generated
     * @ordered
     */
    protected EList<UMLLabelStyle> labelStyle;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UMLDiagramImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UMLDIPackage.Literals.UML_DIAGRAM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLPlane getUmlPlane() {
        return umlPlane;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUmlPlane(UMLPlane newUmlPlane, NotificationChain msgs) {
        UMLPlane oldUmlPlane = umlPlane;
        umlPlane = newUmlPlane;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.UML_DIAGRAM__UML_PLANE, oldUmlPlane, newUmlPlane);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUmlPlane(UMLPlane newUmlPlane) {
        if (newUmlPlane != umlPlane) {
            NotificationChain msgs = null;
            if (umlPlane != null)
                msgs = ((InternalEObject)umlPlane).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.UML_DIAGRAM__UML_PLANE, null, msgs);
            if (newUmlPlane != null)
                msgs = ((InternalEObject)newUmlPlane).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.UML_DIAGRAM__UML_PLANE, null, msgs);
            msgs = basicSetUmlPlane(newUmlPlane, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.UML_DIAGRAM__UML_PLANE, newUmlPlane, newUmlPlane));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<UMLLabelStyle> getLabelStyle() {
        if (labelStyle == null) {
            labelStyle = new EObjectContainmentEList<UMLLabelStyle>(UMLLabelStyle.class, this, UMLDIPackage.UML_DIAGRAM__LABEL_STYLE);
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
            case UMLDIPackage.UML_DIAGRAM__UML_PLANE:
                return basicSetUmlPlane(null, msgs);
            case UMLDIPackage.UML_DIAGRAM__LABEL_STYLE:
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
            case UMLDIPackage.UML_DIAGRAM__UML_PLANE:
                return getUmlPlane();
            case UMLDIPackage.UML_DIAGRAM__LABEL_STYLE:
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
            case UMLDIPackage.UML_DIAGRAM__UML_PLANE:
                setUmlPlane((UMLPlane)newValue);
                return;
            case UMLDIPackage.UML_DIAGRAM__LABEL_STYLE:
                getLabelStyle().clear();
                getLabelStyle().addAll((Collection<? extends UMLLabelStyle>)newValue);
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
            case UMLDIPackage.UML_DIAGRAM__UML_PLANE:
                setUmlPlane((UMLPlane)null);
                return;
            case UMLDIPackage.UML_DIAGRAM__LABEL_STYLE:
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
            case UMLDIPackage.UML_DIAGRAM__UML_PLANE:
                return umlPlane != null;
            case UMLDIPackage.UML_DIAGRAM__LABEL_STYLE:
                return labelStyle != null && !labelStyle.isEmpty();
        }
        return super.eIsSet(featureID);
    }
    @Override
    public DiagramElement getRootElement() {
        return getUmlPlane();
    }
} //UMLDiagramImpl
