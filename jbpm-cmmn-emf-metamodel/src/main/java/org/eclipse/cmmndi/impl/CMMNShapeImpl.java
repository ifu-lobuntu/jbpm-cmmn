/**
 */
package org.eclipse.cmmndi.impl;

import java.util.Collection;
import org.eclipse.cmmn1.TCmmnElement;
import org.eclipse.cmmndi.CMMNLabel;
import org.eclipse.cmmndi.CMMNShape;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.dd.cmmn.di.DiagramElement;
import org.eclipse.dd.cmmn.di.impl.LabeledShapeImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CMMN Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNShapeImpl#getCMMNLabel <em>CMMN Label</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNShapeImpl#getCmmnElement <em>Cmmn Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNShapeImpl#isIsExpanded <em>Is Expanded</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNShapeImpl#isIsHorizontal <em>Is Horizontal</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNShapeImpl#isIsMarkerVisible <em>Is Marker Visible</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.CMMNShapeImpl#getChildShapes <em>Child Shapes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CMMNShapeImpl extends LabeledShapeImpl implements CMMNShape {
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
     * The default value of the '{@link #isIsExpanded() <em>Is Expanded</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsExpanded()
     * @generated
     * @ordered
     */
    protected static final boolean IS_EXPANDED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsExpanded() <em>Is Expanded</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsExpanded()
     * @generated
     * @ordered
     */
    protected boolean isExpanded = IS_EXPANDED_EDEFAULT;

    /**
     * This is true if the Is Expanded attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean isExpandedESet;

    /**
     * The default value of the '{@link #isIsHorizontal() <em>Is Horizontal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsHorizontal()
     * @generated
     * @ordered
     */
    protected static final boolean IS_HORIZONTAL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsHorizontal() <em>Is Horizontal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsHorizontal()
     * @generated
     * @ordered
     */
    protected boolean isHorizontal = IS_HORIZONTAL_EDEFAULT;

    /**
     * This is true if the Is Horizontal attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean isHorizontalESet;

    /**
     * The default value of the '{@link #isIsMarkerVisible() <em>Is Marker Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsMarkerVisible()
     * @generated
     * @ordered
     */
    protected static final boolean IS_MARKER_VISIBLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsMarkerVisible() <em>Is Marker Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsMarkerVisible()
     * @generated
     * @ordered
     */
    protected boolean isMarkerVisible = IS_MARKER_VISIBLE_EDEFAULT;

    /**
     * This is true if the Is Marker Visible attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean isMarkerVisibleESet;

    /**
     * The cached value of the '{@link #getChildShapes() <em>Child Shapes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildShapes()
     * @generated
     * @ordered
     */
    protected EList<DiagramElement> childShapes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CMMNShapeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CmmnDiPackage.Literals.CMMN_SHAPE;
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL, oldCMMNLabel, newCMMNLabel);
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
                msgs = ((InternalEObject)cMMNLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL, null, msgs);
            if (newCMMNLabel != null)
                msgs = ((InternalEObject)newCMMNLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL, null, msgs);
            msgs = basicSetCMMNLabel(newCMMNLabel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL, newCMMNLabel, newCMMNLabel));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CmmnDiPackage.CMMN_SHAPE__CMMN_ELEMENT, oldCmmnElement, cmmnElement));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_SHAPE__CMMN_ELEMENT, oldCmmnElement, cmmnElement));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsExpanded() {
        return isExpanded;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsExpanded(boolean newIsExpanded) {
        boolean oldIsExpanded = isExpanded;
        isExpanded = newIsExpanded;
        boolean oldIsExpandedESet = isExpandedESet;
        isExpandedESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_SHAPE__IS_EXPANDED, oldIsExpanded, isExpanded, !oldIsExpandedESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetIsExpanded() {
        boolean oldIsExpanded = isExpanded;
        boolean oldIsExpandedESet = isExpandedESet;
        isExpanded = IS_EXPANDED_EDEFAULT;
        isExpandedESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, CmmnDiPackage.CMMN_SHAPE__IS_EXPANDED, oldIsExpanded, IS_EXPANDED_EDEFAULT, oldIsExpandedESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetIsExpanded() {
        return isExpandedESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsHorizontal() {
        return isHorizontal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsHorizontal(boolean newIsHorizontal) {
        boolean oldIsHorizontal = isHorizontal;
        isHorizontal = newIsHorizontal;
        boolean oldIsHorizontalESet = isHorizontalESet;
        isHorizontalESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_SHAPE__IS_HORIZONTAL, oldIsHorizontal, isHorizontal, !oldIsHorizontalESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetIsHorizontal() {
        boolean oldIsHorizontal = isHorizontal;
        boolean oldIsHorizontalESet = isHorizontalESet;
        isHorizontal = IS_HORIZONTAL_EDEFAULT;
        isHorizontalESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, CmmnDiPackage.CMMN_SHAPE__IS_HORIZONTAL, oldIsHorizontal, IS_HORIZONTAL_EDEFAULT, oldIsHorizontalESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetIsHorizontal() {
        return isHorizontalESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsMarkerVisible() {
        return isMarkerVisible;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsMarkerVisible(boolean newIsMarkerVisible) {
        boolean oldIsMarkerVisible = isMarkerVisible;
        isMarkerVisible = newIsMarkerVisible;
        boolean oldIsMarkerVisibleESet = isMarkerVisibleESet;
        isMarkerVisibleESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CmmnDiPackage.CMMN_SHAPE__IS_MARKER_VISIBLE, oldIsMarkerVisible, isMarkerVisible, !oldIsMarkerVisibleESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetIsMarkerVisible() {
        boolean oldIsMarkerVisible = isMarkerVisible;
        boolean oldIsMarkerVisibleESet = isMarkerVisibleESet;
        isMarkerVisible = IS_MARKER_VISIBLE_EDEFAULT;
        isMarkerVisibleESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, CmmnDiPackage.CMMN_SHAPE__IS_MARKER_VISIBLE, oldIsMarkerVisible, IS_MARKER_VISIBLE_EDEFAULT, oldIsMarkerVisibleESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetIsMarkerVisible() {
        return isMarkerVisibleESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DiagramElement> getChildShapes() {
        if (childShapes == null) {
            childShapes = new EObjectContainmentEList<DiagramElement>(DiagramElement.class, this, CmmnDiPackage.CMMN_SHAPE__CHILD_SHAPES);
        }
        return childShapes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL:
                return basicSetCMMNLabel(null, msgs);
            case CmmnDiPackage.CMMN_SHAPE__CHILD_SHAPES:
                return ((InternalEList<?>)getChildShapes()).basicRemove(otherEnd, msgs);
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
            case CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL:
                return getCMMNLabel();
            case CmmnDiPackage.CMMN_SHAPE__CMMN_ELEMENT:
                if (resolve) return getCmmnElement();
                return basicGetCmmnElement();
            case CmmnDiPackage.CMMN_SHAPE__IS_EXPANDED:
                return isIsExpanded();
            case CmmnDiPackage.CMMN_SHAPE__IS_HORIZONTAL:
                return isIsHorizontal();
            case CmmnDiPackage.CMMN_SHAPE__IS_MARKER_VISIBLE:
                return isIsMarkerVisible();
            case CmmnDiPackage.CMMN_SHAPE__CHILD_SHAPES:
                return getChildShapes();
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
            case CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL:
                setCMMNLabel((CMMNLabel)newValue);
                return;
            case CmmnDiPackage.CMMN_SHAPE__CMMN_ELEMENT:
                setCmmnElement((TCmmnElement)newValue);
                return;
            case CmmnDiPackage.CMMN_SHAPE__IS_EXPANDED:
                setIsExpanded((Boolean)newValue);
                return;
            case CmmnDiPackage.CMMN_SHAPE__IS_HORIZONTAL:
                setIsHorizontal((Boolean)newValue);
                return;
            case CmmnDiPackage.CMMN_SHAPE__IS_MARKER_VISIBLE:
                setIsMarkerVisible((Boolean)newValue);
                return;
            case CmmnDiPackage.CMMN_SHAPE__CHILD_SHAPES:
                getChildShapes().clear();
                getChildShapes().addAll((Collection<? extends DiagramElement>)newValue);
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
            case CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL:
                setCMMNLabel((CMMNLabel)null);
                return;
            case CmmnDiPackage.CMMN_SHAPE__CMMN_ELEMENT:
                setCmmnElement((TCmmnElement)null);
                return;
            case CmmnDiPackage.CMMN_SHAPE__IS_EXPANDED:
                unsetIsExpanded();
                return;
            case CmmnDiPackage.CMMN_SHAPE__IS_HORIZONTAL:
                unsetIsHorizontal();
                return;
            case CmmnDiPackage.CMMN_SHAPE__IS_MARKER_VISIBLE:
                unsetIsMarkerVisible();
                return;
            case CmmnDiPackage.CMMN_SHAPE__CHILD_SHAPES:
                getChildShapes().clear();
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
            case CmmnDiPackage.CMMN_SHAPE__CMMN_LABEL:
                return cMMNLabel != null;
            case CmmnDiPackage.CMMN_SHAPE__CMMN_ELEMENT:
                return cmmnElement != null;
            case CmmnDiPackage.CMMN_SHAPE__IS_EXPANDED:
                return isSetIsExpanded();
            case CmmnDiPackage.CMMN_SHAPE__IS_HORIZONTAL:
                return isSetIsHorizontal();
            case CmmnDiPackage.CMMN_SHAPE__IS_MARKER_VISIBLE:
                return isSetIsMarkerVisible();
            case CmmnDiPackage.CMMN_SHAPE__CHILD_SHAPES:
                return childShapes != null && !childShapes.isEmpty();
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
        result.append(" (isExpanded: ");
        if (isExpandedESet) result.append(isExpanded); else result.append("<unset>");
        result.append(", isHorizontal: ");
        if (isHorizontalESet) result.append(isHorizontal); else result.append("<unset>");
        result.append(", isMarkerVisible: ");
        if (isMarkerVisibleESet) result.append(isMarkerVisible); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

    @Override
    public EList<DiagramElement> getOwnedElement() {
        return getChildShapes();
    }
} //CMMNShapeImpl
