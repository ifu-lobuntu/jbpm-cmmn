/**
 */
package org.eclipse.cmmndi;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getCMMNDiagram <em>CMMN Diagram</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getCMMNEdge <em>CMMN Edge</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getCMMNLabel <em>CMMN Label</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getCMMNLabelStyle <em>CMMN Label Style</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getCMMNPlane <em>CMMN Plane</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.DocumentRoot#getCMMNShape <em>CMMN Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
    /**
     * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mixed</em>' attribute list.
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_Mixed()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='elementWildcard' name=':mixed'"
     * @generated
     */
    FeatureMap getMixed();

    /**
     * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>XMLNS Prefix Map</em>' map.
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_XMLNSPrefixMap()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
     *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
     * @generated
     */
    EMap<String, String> getXMLNSPrefixMap();

    /**
     * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>XSI Schema Location</em>' map.
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_XSISchemaLocation()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
     *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
     * @generated
     */
    EMap<String, String> getXSISchemaLocation();

    /**
     * Returns the value of the '<em><b>CMMN Diagram</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CMMN Diagram</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CMMN Diagram</em>' containment reference.
     * @see #setCMMNDiagram(CMMNDiagram)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_CMMNDiagram()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='CMMNDiagram' namespace='##targetNamespace'"
     * @generated
     */
    CMMNDiagram getCMMNDiagram();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNDiagram <em>CMMN Diagram</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMMN Diagram</em>' containment reference.
     * @see #getCMMNDiagram()
     * @generated
     */
    void setCMMNDiagram(CMMNDiagram value);

    /**
     * Returns the value of the '<em><b>CMMN Edge</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CMMN Edge</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CMMN Edge</em>' containment reference.
     * @see #setCMMNEdge(CMMNEdge)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_CMMNEdge()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='CMMNEdge' namespace='##targetNamespace' affiliation='http://www.omg.org/spec/DD/20150101/DI#DiagramElement'"
     * @generated
     */
    CMMNEdge getCMMNEdge();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNEdge <em>CMMN Edge</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMMN Edge</em>' containment reference.
     * @see #getCMMNEdge()
     * @generated
     */
    void setCMMNEdge(CMMNEdge value);

    /**
     * Returns the value of the '<em><b>CMMN Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CMMN Label</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CMMN Label</em>' containment reference.
     * @see #setCMMNLabel(CMMNLabel)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_CMMNLabel()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='CMMNLabel' namespace='##targetNamespace'"
     * @generated
     */
    CMMNLabel getCMMNLabel();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNLabel <em>CMMN Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMMN Label</em>' containment reference.
     * @see #getCMMNLabel()
     * @generated
     */
    void setCMMNLabel(CMMNLabel value);

    /**
     * Returns the value of the '<em><b>CMMN Label Style</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CMMN Label Style</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CMMN Label Style</em>' containment reference.
     * @see #setCMMNLabelStyle(CMMNLabelStyle)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_CMMNLabelStyle()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='CMMNLabelStyle' namespace='##targetNamespace'"
     * @generated
     */
    CMMNLabelStyle getCMMNLabelStyle();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNLabelStyle <em>CMMN Label Style</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMMN Label Style</em>' containment reference.
     * @see #getCMMNLabelStyle()
     * @generated
     */
    void setCMMNLabelStyle(CMMNLabelStyle value);

    /**
     * Returns the value of the '<em><b>CMMN Plane</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CMMN Plane</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CMMN Plane</em>' containment reference.
     * @see #setCMMNPlane(CMMNPlane)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_CMMNPlane()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='CMMNPlane' namespace='##targetNamespace'"
     * @generated
     */
    CMMNPlane getCMMNPlane();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNPlane <em>CMMN Plane</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMMN Plane</em>' containment reference.
     * @see #getCMMNPlane()
     * @generated
     */
    void setCMMNPlane(CMMNPlane value);

    /**
     * Returns the value of the '<em><b>CMMN Shape</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CMMN Shape</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CMMN Shape</em>' containment reference.
     * @see #setCMMNShape(CMMNShape)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getDocumentRoot_CMMNShape()
     * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='CMMNShape' namespace='##targetNamespace' affiliation='http://www.omg.org/spec/DD/20150101/DI#DiagramElement'"
     * @generated
     */
    CMMNShape getCMMNShape();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.DocumentRoot#getCMMNShape <em>CMMN Shape</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMMN Shape</em>' containment reference.
     * @see #getCMMNShape()
     * @generated
     */
    void setCMMNShape(CMMNShape value);

} // DocumentRoot
