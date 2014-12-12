/**
 */
package org.eclipse.cmmndi.impl;

import org.eclipse.cmmndi.CMMNDiagram;
import org.eclipse.cmmndi.CMMNEdge;
import org.eclipse.cmmndi.CMMNLabel;
import org.eclipse.cmmndi.CMMNLabelStyle;
import org.eclipse.cmmndi.CMMNPlane;
import org.eclipse.cmmndi.CMMNShape;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.cmmndi.DocumentRoot;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getCMMNDiagram <em>CMMN Diagram</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getCMMNEdge <em>CMMN Edge</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getCMMNLabel <em>CMMN Label</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getCMMNLabelStyle <em>CMMN Label Style</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getCMMNPlane <em>CMMN Plane</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.impl.DocumentRootImpl#getCMMNShape <em>CMMN Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
    /**
     * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMixed()
     * @generated
     * @ordered
     */
    protected FeatureMap mixed;

    /**
     * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXMLNSPrefixMap()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xMLNSPrefixMap;

    /**
     * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXSISchemaLocation()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xSISchemaLocation;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocumentRootImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CmmnDiPackage.Literals.DOCUMENT_ROOT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getMixed() {
        if (mixed == null) {
            mixed = new BasicFeatureMap(this, CmmnDiPackage.DOCUMENT_ROOT__MIXED);
        }
        return mixed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getXMLNSPrefixMap() {
        if (xMLNSPrefixMap == null) {
            xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, CmmnDiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        }
        return xMLNSPrefixMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getXSISchemaLocation() {
        if (xSISchemaLocation == null) {
            xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, CmmnDiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        }
        return xSISchemaLocation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNDiagram getCMMNDiagram() {
        return (CMMNDiagram)getMixed().get(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_DIAGRAM, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCMMNDiagram(CMMNDiagram newCMMNDiagram, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_DIAGRAM, newCMMNDiagram, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMMNDiagram(CMMNDiagram newCMMNDiagram) {
        ((FeatureMap.Internal)getMixed()).set(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_DIAGRAM, newCMMNDiagram);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNEdge getCMMNEdge() {
        return (CMMNEdge)getMixed().get(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_EDGE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCMMNEdge(CMMNEdge newCMMNEdge, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_EDGE, newCMMNEdge, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMMNEdge(CMMNEdge newCMMNEdge) {
        ((FeatureMap.Internal)getMixed()).set(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_EDGE, newCMMNEdge);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNLabel getCMMNLabel() {
        return (CMMNLabel)getMixed().get(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_LABEL, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCMMNLabel(CMMNLabel newCMMNLabel, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_LABEL, newCMMNLabel, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMMNLabel(CMMNLabel newCMMNLabel) {
        ((FeatureMap.Internal)getMixed()).set(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_LABEL, newCMMNLabel);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNLabelStyle getCMMNLabelStyle() {
        return (CMMNLabelStyle)getMixed().get(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_LABEL_STYLE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCMMNLabelStyle(CMMNLabelStyle newCMMNLabelStyle, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_LABEL_STYLE, newCMMNLabelStyle, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMMNLabelStyle(CMMNLabelStyle newCMMNLabelStyle) {
        ((FeatureMap.Internal)getMixed()).set(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_LABEL_STYLE, newCMMNLabelStyle);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNPlane getCMMNPlane() {
        return (CMMNPlane)getMixed().get(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_PLANE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCMMNPlane(CMMNPlane newCMMNPlane, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_PLANE, newCMMNPlane, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMMNPlane(CMMNPlane newCMMNPlane) {
        ((FeatureMap.Internal)getMixed()).set(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_PLANE, newCMMNPlane);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMNShape getCMMNShape() {
        return (CMMNShape)getMixed().get(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_SHAPE, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCMMNShape(CMMNShape newCMMNShape, NotificationChain msgs) {
        return ((FeatureMap.Internal)getMixed()).basicAdd(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_SHAPE, newCMMNShape, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCMMNShape(CMMNShape newCMMNShape) {
        ((FeatureMap.Internal)getMixed()).set(CmmnDiPackage.Literals.DOCUMENT_ROOT__CMMN_SHAPE, newCMMNShape);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CmmnDiPackage.DOCUMENT_ROOT__MIXED:
                return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
            case CmmnDiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
            case CmmnDiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_DIAGRAM:
                return basicSetCMMNDiagram(null, msgs);
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_EDGE:
                return basicSetCMMNEdge(null, msgs);
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL:
                return basicSetCMMNLabel(null, msgs);
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL_STYLE:
                return basicSetCMMNLabelStyle(null, msgs);
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_PLANE:
                return basicSetCMMNPlane(null, msgs);
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_SHAPE:
                return basicSetCMMNShape(null, msgs);
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
            case CmmnDiPackage.DOCUMENT_ROOT__MIXED:
                if (coreType) return getMixed();
                return ((FeatureMap.Internal)getMixed()).getWrapper();
            case CmmnDiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                if (coreType) return getXMLNSPrefixMap();
                else return getXMLNSPrefixMap().map();
            case CmmnDiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                if (coreType) return getXSISchemaLocation();
                else return getXSISchemaLocation().map();
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_DIAGRAM:
                return getCMMNDiagram();
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_EDGE:
                return getCMMNEdge();
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL:
                return getCMMNLabel();
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL_STYLE:
                return getCMMNLabelStyle();
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_PLANE:
                return getCMMNPlane();
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_SHAPE:
                return getCMMNShape();
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
            case CmmnDiPackage.DOCUMENT_ROOT__MIXED:
                ((FeatureMap.Internal)getMixed()).set(newValue);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                ((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                ((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_DIAGRAM:
                setCMMNDiagram((CMMNDiagram)newValue);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_EDGE:
                setCMMNEdge((CMMNEdge)newValue);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL:
                setCMMNLabel((CMMNLabel)newValue);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL_STYLE:
                setCMMNLabelStyle((CMMNLabelStyle)newValue);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_PLANE:
                setCMMNPlane((CMMNPlane)newValue);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_SHAPE:
                setCMMNShape((CMMNShape)newValue);
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
            case CmmnDiPackage.DOCUMENT_ROOT__MIXED:
                getMixed().clear();
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                getXMLNSPrefixMap().clear();
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                getXSISchemaLocation().clear();
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_DIAGRAM:
                setCMMNDiagram((CMMNDiagram)null);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_EDGE:
                setCMMNEdge((CMMNEdge)null);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL:
                setCMMNLabel((CMMNLabel)null);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL_STYLE:
                setCMMNLabelStyle((CMMNLabelStyle)null);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_PLANE:
                setCMMNPlane((CMMNPlane)null);
                return;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_SHAPE:
                setCMMNShape((CMMNShape)null);
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
            case CmmnDiPackage.DOCUMENT_ROOT__MIXED:
                return mixed != null && !mixed.isEmpty();
            case CmmnDiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
            case CmmnDiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_DIAGRAM:
                return getCMMNDiagram() != null;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_EDGE:
                return getCMMNEdge() != null;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL:
                return getCMMNLabel() != null;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_LABEL_STYLE:
                return getCMMNLabelStyle() != null;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_PLANE:
                return getCMMNPlane() != null;
            case CmmnDiPackage.DOCUMENT_ROOT__CMMN_SHAPE:
                return getCMMNShape() != null;
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
        result.append(" (mixed: ");
        result.append(mixed);
        result.append(')');
        return result.toString();
    }

} //DocumentRootImpl
