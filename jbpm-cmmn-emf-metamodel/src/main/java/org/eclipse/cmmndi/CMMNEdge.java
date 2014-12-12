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
 *   <li>{@link org.eclipse.cmmndi.CMMNEdge#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNEdge#getCmmnElement <em>Cmmn Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}</li>
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
     * Returns the value of the '<em><b>Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' containment reference.
     * @see #setLabel(CMMNLabel)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNEdge_Label()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='CMMNLabel' namespace='##targetNamespace'"
     * @generated
     */
    CMMNLabel getLabel();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNEdge#getLabel <em>Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' containment reference.
     * @see #getLabel()
     * @generated
     */
    void setLabel(CMMNLabel value);

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
     * Returns the value of the '<em><b>Message Visible Kind</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.cmmndi.MessageVisibleKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Message Visible Kind</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Message Visible Kind</em>' attribute.
     * @see org.eclipse.cmmndi.MessageVisibleKind
     * @see #isSetMessageVisibleKind()
     * @see #unsetMessageVisibleKind()
     * @see #setMessageVisibleKind(MessageVisibleKind)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNEdge_MessageVisibleKind()
     * @model unsettable="true"
     *        extendedMetaData="kind='attribute' name='messageVisibleKind'"
     * @generated
     */
    MessageVisibleKind getMessageVisibleKind();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Message Visible Kind</em>' attribute.
     * @see org.eclipse.cmmndi.MessageVisibleKind
     * @see #isSetMessageVisibleKind()
     * @see #unsetMessageVisibleKind()
     * @see #getMessageVisibleKind()
     * @generated
     */
    void setMessageVisibleKind(MessageVisibleKind value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmndi.CMMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetMessageVisibleKind()
     * @see #getMessageVisibleKind()
     * @see #setMessageVisibleKind(MessageVisibleKind)
     * @generated
     */
    void unsetMessageVisibleKind();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmndi.CMMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Message Visible Kind</em>' attribute is set.
     * @see #unsetMessageVisibleKind()
     * @see #getMessageVisibleKind()
     * @see #setMessageVisibleKind(MessageVisibleKind)
     * @generated
     */
    boolean isSetMessageVisibleKind();

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
