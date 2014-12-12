/**
 */
package org.eclipse.cmmndi;

import org.eclipse.dd.cmmn.di.Label;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CMMN Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.CMMNLabel#getLabelStyle <em>Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNLabel()
 * @model extendedMetaData="name='CMMNLabel' kind='elementOnly'"
 * @generated
 */
public interface CMMNLabel extends Label {
    /**
     * Returns the value of the '<em><b>Label Style</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label Style</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label Style</em>' reference.
     * @see #setLabelStyle(CMMNLabelStyle)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNLabel_LabelStyle()
     * @model extendedMetaData="kind='attribute' name='labelStyle'"
     * @generated
     */
    CMMNLabelStyle getLabelStyle();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNLabel#getLabelStyle <em>Label Style</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label Style</em>' reference.
     * @see #getLabelStyle()
     * @generated
     */
    void setLabelStyle(CMMNLabelStyle value);

} // CMMNLabel
