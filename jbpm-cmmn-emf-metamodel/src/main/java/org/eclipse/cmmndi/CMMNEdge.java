/**
 */
package org.eclipse.cmmndi;

import org.eclipse.cmmn1.TCmmnElement;
import org.eclipse.dd.cmmn.di.DiagramElement;
import org.eclipse.dd.cmmn.di.LabeledEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CMMN Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.CMMNEdge#getCMMNLabel <em>CMMN Label</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNEdge#getCmmnElement <em>Cmmn Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNEdge#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNEdge#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNEdge()
 * @model extendedMetaData="name='CMMNEdge' kind='elementOnly'"
 * @generated
 */
public interface CMMNEdge extends LabeledEdge {
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
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNEdge_CMMNLabel()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='CMMNLabel' namespace='##targetNamespace'"
     * @generated
     */
    CMMNLabel getCMMNLabel();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNEdge#getCMMNLabel <em>CMMN Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMMN Label</em>' containment reference.
     * @see #getCMMNLabel()
     * @generated
     */
    void setCMMNLabel(CMMNLabel value);

    /**
     * Returns the value of the '<em><b>Cmmn Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cmmn Element</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cmmn Element</em>' reference.
     * @see #setCmmnElement(TCmmnElement)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNEdge_CmmnElement()
     * @model extendedMetaData="kind='attribute' name='CMMNElement'"
     * @generated
     */
    TCmmnElement getCmmnElement();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNEdge#getCmmnElement <em>Cmmn Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cmmn Element</em>' reference.
     * @see #getCmmnElement()
     * @generated
     */
    void setCmmnElement(TCmmnElement value);

    /**
     * Returns the value of the '<em><b>Source Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Element</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Element</em>' reference.
     * @see #setSourceElement(DiagramElement)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNEdge_SourceElement()
     * @model extendedMetaData="kind='attribute' name='sourceElement'"
     * @generated
     */
    DiagramElement getSourceElement();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNEdge#getSourceElement <em>Source Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Element</em>' reference.
     * @see #getSourceElement()
     * @generated
     */
    void setSourceElement(DiagramElement value);

    /**
     * Returns the value of the '<em><b>Target Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Element</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Element</em>' reference.
     * @see #setTargetElement(DiagramElement)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNEdge_TargetElement()
     * @model extendedMetaData="kind='attribute' name='targetElement'"
     * @generated
     */
    DiagramElement getTargetElement();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNEdge#getTargetElement <em>Target Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Element</em>' reference.
     * @see #getTargetElement()
     * @generated
     */
    void setTargetElement(DiagramElement value);

} // CMMNEdge
