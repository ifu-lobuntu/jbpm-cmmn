/**
 */
package org.eclipse.dd.cmmn.di;

import org.eclipse.dd.cmmn.dc.Point;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.dd.cmmn.di.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.dd.cmmn.di.Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.dd.cmmn.di.Edge#getWaypoint <em>Waypoint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.dd.cmmn.di.DiPackage#getEdge()
 * @model abstract="true"
 *        extendedMetaData="name='Edge' kind='elementOnly'"
 * @generated
 */
public interface Edge extends DiagramElement {
    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see org.eclipse.dd.cmmn.di.DiPackage#getEdge_Source()
     * @model transient="true" changeable="false" derived="true" ordered="false"
     * @generated
     */
    DiagramElement getSource();

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see org.eclipse.dd.cmmn.di.DiPackage#getEdge_Target()
     * @model transient="true" changeable="false" derived="true" ordered="false"
     * @generated
     */
    DiagramElement getTarget();

    /**
     * Returns the value of the '<em><b>Waypoint</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.dd.cmmn.dc.Point}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Waypoint</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Waypoint</em>' containment reference list.
     * @see org.eclipse.dd.cmmn.di.DiPackage#getEdge_Waypoint()
     * @model containment="true" lower="2"
     *        extendedMetaData="kind='element' name='waypoint' namespace='http://www.omg.org/spec/DD/20150101/DI'"
     * @generated
     */
    EList<Point> getWaypoint();

} // Edge
