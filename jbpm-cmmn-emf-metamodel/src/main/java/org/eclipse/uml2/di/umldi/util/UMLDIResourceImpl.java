/**
 */
package org.eclipse.uml2.di.umldi.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl;
import org.eclipse.uml2.di.umldi.UMLDIPackage;
import org.eclipse.uml2.uml.internal.resource.UMLLoadImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.uml2.di.umldi.util.UMLDIResourceFactoryImpl
 * @generated
 */
public class UMLDIResourceImpl extends XMIResourceImpl {
    private static List<EClass> referrables = new ArrayList<EClass>();
    static {
        referrables.add(UMLDIPackage.eINSTANCE.getUMLEdge());
        referrables.add(UMLDIPackage.eINSTANCE.getUMLShape());
        referrables.add(UMLDIPackage.eINSTANCE.getUMLPlane());
    }

    /**
     * Creates an instance of the resource. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param uri
     *            the URI of the new resource.
     * @generated
     */
    public UMLDIResourceImpl(URI uri) {
        super(uri);
    }

    @Override
    protected XMLLoad createXMLLoad() {
        return new UMLLoadImpl(createXMLHelper());
    }

    protected XMLSave createXMLSave() {
        prepareSave();
        return super.createXMLSave();
    }

    protected void prepareSave() {
        EObject cur;
        for (Iterator<EObject> iter = getAllContents(); iter.hasNext();) {
            cur = iter.next();
            setIdIfNotSet(cur);
        }
    }

    protected void setIdIfNotSet(EObject obj) {
        if (obj.eClass() != null && referrables.contains(obj.eClass())) {
            if (getID(obj) == null) {
                setID(obj, EcoreUtil.generateUUID());
            }
        }
    }

    @Override
    protected boolean useIDAttributes() {
        return false;
    }

    @Override
    protected boolean useUUIDs() {
        return true;
    }
} // UMLDIResourceImpl
