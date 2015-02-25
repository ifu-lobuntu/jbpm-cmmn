/**
 */
package org.eclipse.uml2.di.umldi.util;

import org.eclipse.cmmn1.Switch;
import org.eclipse.dd.cmmn.di.Diagram;
import org.eclipse.dd.cmmn.di.DiagramElement;
import org.eclipse.dd.cmmn.di.Edge;
import org.eclipse.dd.cmmn.di.Label;
import org.eclipse.dd.cmmn.di.LabeledEdge;
import org.eclipse.dd.cmmn.di.LabeledShape;
import org.eclipse.dd.cmmn.di.Node;
import org.eclipse.dd.cmmn.di.Plane;
import org.eclipse.dd.cmmn.di.Shape;
import org.eclipse.dd.cmmn.di.Style;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.di.umldi.DocumentRoot;
import org.eclipse.uml2.di.umldi.UMLDIPackage;
import org.eclipse.uml2.di.umldi.UMLDiagram;
import org.eclipse.uml2.di.umldi.UMLEdge;
import org.eclipse.uml2.di.umldi.UMLLabel;
import org.eclipse.uml2.di.umldi.UMLLabelStyle;
import org.eclipse.uml2.di.umldi.UMLPlane;
import org.eclipse.uml2.di.umldi.UMLShape;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.di.umldi.UMLDIPackage
 * @generated
 */
public class UMLDISwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static UMLDIPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLDISwitch() {
        if (modelPackage == null) {
            modelPackage = UMLDIPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case UMLDIPackage.UML_DIAGRAM: {
                UMLDiagram umlDiagram = (UMLDiagram)theEObject;
                T result = caseUMLDiagram(umlDiagram);
                if (result == null) result = caseDiagram(umlDiagram);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLDIPackage.UML_EDGE: {
                UMLEdge umlEdge = (UMLEdge)theEObject;
                T result = caseUMLEdge(umlEdge);
                if (result == null) result = caseLabeledEdge(umlEdge);
                if (result == null) result = caseEdge(umlEdge);
                if (result == null) result = caseDiagramElement(umlEdge);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLDIPackage.UML_LABEL: {
                UMLLabel umlLabel = (UMLLabel)theEObject;
                T result = caseUMLLabel(umlLabel);
                if (result == null) result = caseLabel(umlLabel);
                if (result == null) result = caseNode(umlLabel);
                if (result == null) result = caseDiagramElement(umlLabel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLDIPackage.UML_LABEL_STYLE: {
                UMLLabelStyle umlLabelStyle = (UMLLabelStyle)theEObject;
                T result = caseUMLLabelStyle(umlLabelStyle);
                if (result == null) result = caseStyle(umlLabelStyle);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLDIPackage.UML_PLANE: {
                UMLPlane umlPlane = (UMLPlane)theEObject;
                T result = caseUMLPlane(umlPlane);
                if (result == null) result = casePlane(umlPlane);
                if (result == null) result = caseNode(umlPlane);
                if (result == null) result = caseDiagramElement(umlPlane);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLDIPackage.UML_SHAPE: {
                UMLShape umlShape = (UMLShape)theEObject;
                T result = caseUMLShape(umlShape);
                if (result == null) result = caseLabeledShape(umlShape);
                if (result == null) result = caseShape(umlShape);
                if (result == null) result = caseNode(umlShape);
                if (result == null) result = caseDiagramElement(umlShape);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLDIPackage.DOCUMENT_ROOT: {
                DocumentRoot documentRoot = (DocumentRoot)theEObject;
                T result = caseDocumentRoot(documentRoot);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>UML Diagram</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UML Diagram</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUMLDiagram(UMLDiagram object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>UML Edge</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UML Edge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUMLEdge(UMLEdge object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>UML Label</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UML Label</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUMLLabel(UMLLabel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>UML Label Style</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UML Label Style</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUMLLabelStyle(UMLLabelStyle object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>UML Plane</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UML Plane</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUMLPlane(UMLPlane object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>UML Shape</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UML Shape</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUMLShape(UMLShape object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentRoot(DocumentRoot object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDiagram(Diagram object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Diagram Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Diagram Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDiagramElement(DiagramElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEdge(Edge object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Labeled Edge</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Labeled Edge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLabeledEdge(LabeledEdge object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNode(Node object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Label</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLabel(Label object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Style</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Style</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStyle(Style object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Plane</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Plane</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePlane(Plane object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Shape</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Shape</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseShape(Shape object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Labeled Shape</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Labeled Shape</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLabeledShape(LabeledShape object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //UMLDISwitch
