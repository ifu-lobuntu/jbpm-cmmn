/**
 */
package org.eclipse.uml2.di.umldi.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.uml2.uml.internal.resource.UMLLoadImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.di.umldi.util.UMLDIResourceFactoryImpl
 * @generated
 */
public class UMLDIResourceImpl extends XMIResourceImpl {
    /**
     * Creates an instance of the resource.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param uri the URI of the new resource.
     * @generated
     */
    public UMLDIResourceImpl(URI uri) {
        super(uri);
    }
    @Override
    protected XMLLoad createXMLLoad() {
        return new UMLLoadImpl(createXMLHelper());
    }

    @Override
    protected boolean useIDAttributes() {
        return false;
    }

    @Override
    protected boolean useUUIDs() {
        return true;
    }
} //UMLDIResourceImpl
