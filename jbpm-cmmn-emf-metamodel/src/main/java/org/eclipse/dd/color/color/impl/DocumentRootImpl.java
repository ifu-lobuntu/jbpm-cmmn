/**
 */
package org.eclipse.dd.color.color.impl;

import org.eclipse.dd.color.color.ColorPackage;
import org.eclipse.dd.color.color.DocumentRoot;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
 *   <li>{@link org.eclipse.dd.color.color.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.dd.color.color.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.dd.color.color.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.dd.color.color.impl.DocumentRootImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.dd.color.color.impl.DocumentRootImpl#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link org.eclipse.dd.color.color.impl.DocumentRootImpl#getColor <em>Color</em>}</li>
 *   <li>{@link org.eclipse.dd.color.color.impl.DocumentRootImpl#getFontSize <em>Font Size</em>}</li>
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
     * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final String BACKGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected String backgroundColor = BACKGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBorderColor()
     * @generated
     * @ordered
     */
    protected static final String BORDER_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBorderColor()
     * @generated
     * @ordered
     */
    protected String borderColor = BORDER_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColor()
     * @generated
     * @ordered
     */
    protected static final String COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColor()
     * @generated
     * @ordered
     */
    protected String color = COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFontSize()
     * @generated
     * @ordered
     */
    protected static final Integer FONT_SIZE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFontSize() <em>Font Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFontSize()
     * @generated
     * @ordered
     */
    protected Integer fontSize = FONT_SIZE_EDEFAULT;

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
        return ColorPackage.Literals.DOCUMENT_ROOT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getMixed() {
        if (mixed == null) {
            mixed = new BasicFeatureMap(this, ColorPackage.DOCUMENT_ROOT__MIXED);
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
            xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ColorPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
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
            xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ColorPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        }
        return xSISchemaLocation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBackgroundColor(String newBackgroundColor) {
        String oldBackgroundColor = backgroundColor;
        backgroundColor = newBackgroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ColorPackage.DOCUMENT_ROOT__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBorderColor() {
        return borderColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBorderColor(String newBorderColor) {
        String oldBorderColor = borderColor;
        borderColor = newBorderColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ColorPackage.DOCUMENT_ROOT__BORDER_COLOR, oldBorderColor, borderColor));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getColor() {
        return color;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setColor(String newColor) {
        String oldColor = color;
        color = newColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ColorPackage.DOCUMENT_ROOT__COLOR, oldColor, color));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFontSize(Integer newFontSize) {
        Integer oldFontSize = fontSize;
        fontSize = newFontSize;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ColorPackage.DOCUMENT_ROOT__FONT_SIZE, oldFontSize, fontSize));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ColorPackage.DOCUMENT_ROOT__MIXED:
                return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
            case ColorPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
            case ColorPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
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
            case ColorPackage.DOCUMENT_ROOT__MIXED:
                if (coreType) return getMixed();
                return ((FeatureMap.Internal)getMixed()).getWrapper();
            case ColorPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                if (coreType) return getXMLNSPrefixMap();
                else return getXMLNSPrefixMap().map();
            case ColorPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                if (coreType) return getXSISchemaLocation();
                else return getXSISchemaLocation().map();
            case ColorPackage.DOCUMENT_ROOT__BACKGROUND_COLOR:
                return getBackgroundColor();
            case ColorPackage.DOCUMENT_ROOT__BORDER_COLOR:
                return getBorderColor();
            case ColorPackage.DOCUMENT_ROOT__COLOR:
                return getColor();
            case ColorPackage.DOCUMENT_ROOT__FONT_SIZE:
                return getFontSize();
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
            case ColorPackage.DOCUMENT_ROOT__MIXED:
                ((FeatureMap.Internal)getMixed()).set(newValue);
                return;
            case ColorPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                ((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
                return;
            case ColorPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                ((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
                return;
            case ColorPackage.DOCUMENT_ROOT__BACKGROUND_COLOR:
                setBackgroundColor((String)newValue);
                return;
            case ColorPackage.DOCUMENT_ROOT__BORDER_COLOR:
                setBorderColor((String)newValue);
                return;
            case ColorPackage.DOCUMENT_ROOT__COLOR:
                setColor((String)newValue);
                return;
            case ColorPackage.DOCUMENT_ROOT__FONT_SIZE:
                setFontSize((Integer)newValue);
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
            case ColorPackage.DOCUMENT_ROOT__MIXED:
                getMixed().clear();
                return;
            case ColorPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                getXMLNSPrefixMap().clear();
                return;
            case ColorPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                getXSISchemaLocation().clear();
                return;
            case ColorPackage.DOCUMENT_ROOT__BACKGROUND_COLOR:
                setBackgroundColor(BACKGROUND_COLOR_EDEFAULT);
                return;
            case ColorPackage.DOCUMENT_ROOT__BORDER_COLOR:
                setBorderColor(BORDER_COLOR_EDEFAULT);
                return;
            case ColorPackage.DOCUMENT_ROOT__COLOR:
                setColor(COLOR_EDEFAULT);
                return;
            case ColorPackage.DOCUMENT_ROOT__FONT_SIZE:
                setFontSize(FONT_SIZE_EDEFAULT);
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
            case ColorPackage.DOCUMENT_ROOT__MIXED:
                return mixed != null && !mixed.isEmpty();
            case ColorPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
            case ColorPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
            case ColorPackage.DOCUMENT_ROOT__BACKGROUND_COLOR:
                return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals(backgroundColor);
            case ColorPackage.DOCUMENT_ROOT__BORDER_COLOR:
                return BORDER_COLOR_EDEFAULT == null ? borderColor != null : !BORDER_COLOR_EDEFAULT.equals(borderColor);
            case ColorPackage.DOCUMENT_ROOT__COLOR:
                return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
            case ColorPackage.DOCUMENT_ROOT__FONT_SIZE:
                return FONT_SIZE_EDEFAULT == null ? fontSize != null : !FONT_SIZE_EDEFAULT.equals(fontSize);
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
        result.append(", backgroundColor: ");
        result.append(backgroundColor);
        result.append(", borderColor: ");
        result.append(borderColor);
        result.append(", color: ");
        result.append(color);
        result.append(", fontSize: ");
        result.append(fontSize);
        result.append(')');
        return result.toString();
    }

} //DocumentRootImpl
