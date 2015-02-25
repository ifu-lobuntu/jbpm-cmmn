/**
 */
package org.eclipse.uml2.di.umldi.util;

import java.util.HashMap;

import org.eclipse.dd.cmmn.dc.DcPackage;
import org.eclipse.dd.cmmn.di.DiPackage;
import org.eclipse.dd.color.color.ColorPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.di.umldi.UMLDIPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.di.umldi.util.UMLDIResourceImpl
 * @generated
 */
public class UMLDIResourceFactoryImpl extends ResourceFactoryImpl {
    /**
     * Creates an instance of the resource factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLDIResourceFactoryImpl() {
        super();
    }

    /**
     * Creates an instance of the resource.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Resource createResource(URI uri) {
        UMLDIResourceImpl result = new UMLDIResourceImpl(uri);
        HashMap<String, Object> options = new HashMap<String, Object>();
        ExtendedMetaData emd = new BasicExtendedMetaData();
        emd.setQualified(UMLPackage.eINSTANCE, true);
        emd.setQualified(UMLDIPackage.eINSTANCE, true);
        emd.setQualified(DiPackage.eINSTANCE, true);
        emd.setQualified(DcPackage.eINSTANCE, true);
        emd.setQualified(ColorPackage.eINSTANCE, true);
        options.put(XMLResource.OPTION_EXTENDED_META_DATA, emd);
        options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, true);
        result.getDefaultLoadOptions().putAll(options);
        result.getDefaultSaveOptions().putAll(options);
        return result;

    }

} //UMLDIResourceFactoryImpl
