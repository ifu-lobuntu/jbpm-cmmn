/**
 */
package org.eclipse.cmmndi;

import javax.xml.namespace.QName;

import org.eclipse.cmmn1.TCmmnElement;
import org.eclipse.dd.cmmn.di.LabeledShape;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CMMN Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.CMMNShape#getCMMNLabel <em>CMMN Label</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNShape#getChoreographyActivityShape <em>Choreography Activity Shape</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNShape#getCmmnElement <em>Cmmn Element</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNShape#isIsExpanded <em>Is Expanded</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNShape#isIsHorizontal <em>Is Horizontal</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNShape#isIsMessageVisible <em>Is Message Visible</em>}</li>
 *   <li>{@link org.eclipse.cmmndi.CMMNShape#getParticipantBandKind <em>Participant Band Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape()
 * @model extendedMetaData="name='CMMNShape' kind='elementOnly'"
 * @generated
 */
public interface CMMNShape extends LabeledShape {
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
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape_CMMNLabel()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='CMMNLabel' namespace='##targetNamespace'"
     * @generated
     */
    CMMNLabel getCMMNLabel();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNShape#getCMMNLabel <em>CMMN Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>CMMN Label</em>' containment reference.
     * @see #getCMMNLabel()
     * @generated
     */
    void setCMMNLabel(CMMNLabel value);

    /**
     * Returns the value of the '<em><b>Choreography Activity Shape</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Choreography Activity Shape</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Choreography Activity Shape</em>' attribute.
     * @see #setChoreographyActivityShape(QName)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape_ChoreographyActivityShape()
     * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
     *        extendedMetaData="kind='attribute' name='choreographyActivityShape'"
     * @generated
     */
    QName getChoreographyActivityShape();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNShape#getChoreographyActivityShape <em>Choreography Activity Shape</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Choreography Activity Shape</em>' attribute.
     * @see #getChoreographyActivityShape()
     * @generated
     */
    void setChoreographyActivityShape(QName value);

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
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape_CmmnElement()
     * @model extendedMetaData="kind='attribute' name='CMMNElement'"
     * @generated
     */
    TCmmnElement getCmmnElement();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNShape#getCmmnElement <em>Cmmn Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cmmn Element</em>' reference.
     * @see #getCmmnElement()
     * @generated
     */
    void setCmmnElement(TCmmnElement value);

    /**
     * Returns the value of the '<em><b>Is Expanded</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Expanded</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Expanded</em>' attribute.
     * @see #isSetIsExpanded()
     * @see #unsetIsExpanded()
     * @see #setIsExpanded(boolean)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape_IsExpanded()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='isExpanded'"
     * @generated
     */
    boolean isIsExpanded();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsExpanded <em>Is Expanded</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Expanded</em>' attribute.
     * @see #isSetIsExpanded()
     * @see #unsetIsExpanded()
     * @see #isIsExpanded()
     * @generated
     */
    void setIsExpanded(boolean value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsExpanded <em>Is Expanded</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetIsExpanded()
     * @see #isIsExpanded()
     * @see #setIsExpanded(boolean)
     * @generated
     */
    void unsetIsExpanded();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsExpanded <em>Is Expanded</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Is Expanded</em>' attribute is set.
     * @see #unsetIsExpanded()
     * @see #isIsExpanded()
     * @see #setIsExpanded(boolean)
     * @generated
     */
    boolean isSetIsExpanded();

    /**
     * Returns the value of the '<em><b>Is Horizontal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Horizontal</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Horizontal</em>' attribute.
     * @see #isSetIsHorizontal()
     * @see #unsetIsHorizontal()
     * @see #setIsHorizontal(boolean)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape_IsHorizontal()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='isHorizontal'"
     * @generated
     */
    boolean isIsHorizontal();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsHorizontal <em>Is Horizontal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Horizontal</em>' attribute.
     * @see #isSetIsHorizontal()
     * @see #unsetIsHorizontal()
     * @see #isIsHorizontal()
     * @generated
     */
    void setIsHorizontal(boolean value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsHorizontal <em>Is Horizontal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetIsHorizontal()
     * @see #isIsHorizontal()
     * @see #setIsHorizontal(boolean)
     * @generated
     */
    void unsetIsHorizontal();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsHorizontal <em>Is Horizontal</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Is Horizontal</em>' attribute is set.
     * @see #unsetIsHorizontal()
     * @see #isIsHorizontal()
     * @see #setIsHorizontal(boolean)
     * @generated
     */
    boolean isSetIsHorizontal();

    /**
     * Returns the value of the '<em><b>Is Marker Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Marker Visible</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Marker Visible</em>' attribute.
     * @see #isSetIsMarkerVisible()
     * @see #unsetIsMarkerVisible()
     * @see #setIsMarkerVisible(boolean)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape_IsMarkerVisible()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='isMarkerVisible'"
     * @generated
     */
    boolean isIsMarkerVisible();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Marker Visible</em>' attribute.
     * @see #isSetIsMarkerVisible()
     * @see #unsetIsMarkerVisible()
     * @see #isIsMarkerVisible()
     * @generated
     */
    void setIsMarkerVisible(boolean value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetIsMarkerVisible()
     * @see #isIsMarkerVisible()
     * @see #setIsMarkerVisible(boolean)
     * @generated
     */
    void unsetIsMarkerVisible();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Is Marker Visible</em>' attribute is set.
     * @see #unsetIsMarkerVisible()
     * @see #isIsMarkerVisible()
     * @see #setIsMarkerVisible(boolean)
     * @generated
     */
    boolean isSetIsMarkerVisible();

    /**
     * Returns the value of the '<em><b>Is Message Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Message Visible</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Message Visible</em>' attribute.
     * @see #isSetIsMessageVisible()
     * @see #unsetIsMessageVisible()
     * @see #setIsMessageVisible(boolean)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape_IsMessageVisible()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='isMessageVisible'"
     * @generated
     */
    boolean isIsMessageVisible();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsMessageVisible <em>Is Message Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Message Visible</em>' attribute.
     * @see #isSetIsMessageVisible()
     * @see #unsetIsMessageVisible()
     * @see #isIsMessageVisible()
     * @generated
     */
    void setIsMessageVisible(boolean value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsMessageVisible <em>Is Message Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetIsMessageVisible()
     * @see #isIsMessageVisible()
     * @see #setIsMessageVisible(boolean)
     * @generated
     */
    void unsetIsMessageVisible();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmndi.CMMNShape#isIsMessageVisible <em>Is Message Visible</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Is Message Visible</em>' attribute is set.
     * @see #unsetIsMessageVisible()
     * @see #isIsMessageVisible()
     * @see #setIsMessageVisible(boolean)
     * @generated
     */
    boolean isSetIsMessageVisible();

    /**
     * Returns the value of the '<em><b>Participant Band Kind</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.cmmndi.ParticipantBandKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Participant Band Kind</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Participant Band Kind</em>' attribute.
     * @see org.eclipse.cmmndi.ParticipantBandKind
     * @see #isSetParticipantBandKind()
     * @see #unsetParticipantBandKind()
     * @see #setParticipantBandKind(ParticipantBandKind)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNShape_ParticipantBandKind()
     * @model unsettable="true"
     *        extendedMetaData="kind='attribute' name='participantBandKind'"
     * @generated
     */
    ParticipantBandKind getParticipantBandKind();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNShape#getParticipantBandKind <em>Participant Band Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Participant Band Kind</em>' attribute.
     * @see org.eclipse.cmmndi.ParticipantBandKind
     * @see #isSetParticipantBandKind()
     * @see #unsetParticipantBandKind()
     * @see #getParticipantBandKind()
     * @generated
     */
    void setParticipantBandKind(ParticipantBandKind value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmndi.CMMNShape#getParticipantBandKind <em>Participant Band Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetParticipantBandKind()
     * @see #getParticipantBandKind()
     * @see #setParticipantBandKind(ParticipantBandKind)
     * @generated
     */
    void unsetParticipantBandKind();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmndi.CMMNShape#getParticipantBandKind <em>Participant Band Kind</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Participant Band Kind</em>' attribute is set.
     * @see #unsetParticipantBandKind()
     * @see #getParticipantBandKind()
     * @see #setParticipantBandKind(ParticipantBandKind)
     * @generated
     */
    boolean isSetParticipantBandKind();

} // CMMNShape
