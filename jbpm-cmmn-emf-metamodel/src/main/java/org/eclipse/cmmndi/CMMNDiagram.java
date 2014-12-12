/**
 */
package org.eclipse.cmmndi;

import org.eclipse.dd.cmmn.di.Diagram;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CMMN Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.CMMNDiagram#getPlane <em>Plane</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNDiagram#getLabelStyle <em>Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNDiagram()
 * @model extendedMetaData="name='CMMNDiagram' kind='elementOnly'"
 * @generated
 */
public interface CMMNDiagram extends Diagram {
    /**
     * Returns the value of the '<em><b>Plane</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plane</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plane</em>' containment reference.
     * @see #setPlane(CMMNPlane)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNDiagram_Plane()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='CMMNPlane' namespace='##targetNamespace'"
     * @generated
     */
    CMMNPlane getPlane();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNDiagram#getPlane <em>Plane</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plane</em>' containment reference.
     * @see #getPlane()
     * @generated
     */
    void setPlane(CMMNPlane value);

    /**
     * Returns the value of the '<em><b>Label Style</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmndi.CMMNLabelStyle}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label Style</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label Style</em>' containment reference list.
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNDiagram_LabelStyle()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='CMMNLabelStyle' namespace='##targetNamespace'"
     * @generated
     */
    EList<CMMNLabelStyle> getLabelStyle();

} // CMMNDiagram
