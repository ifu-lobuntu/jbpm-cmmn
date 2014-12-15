/**
 */
package org.eclipse.cmmndi;

import org.eclipse.cmmn1.TDefinitions;
import org.eclipse.dd.cmmn.di.Plane;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CMMN Plane</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmndi.CMMNPlane#getCmmnElement <em>Cmmn Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNPlane()
 * @model extendedMetaData="name='CMMNPlane' kind='elementOnly'"
 * @generated
 */
public interface CMMNPlane extends Plane {
    /**
     * Returns the value of the '<em><b>Cmmn Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cmmn Element</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cmmn Element</em>' reference.
     * @see #setCmmnElement(TDefinitions)
     * @see org.eclipse.cmmndi.CmmnDiPackage#getCMMNPlane_CmmnElement()
     * @model extendedMetaData="kind='attribute' name='CMMNElement'"
     * @generated
     */
    TDefinitions getCmmnElement();

    /**
     * Sets the value of the '{@link org.eclipse.cmmndi.CMMNPlane#getCmmnElement <em>Cmmn Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cmmn Element</em>' reference.
     * @see #getCmmnElement()
     * @generated
     */
    void setCmmnElement(TDefinitions value);

} // CMMNPlane
