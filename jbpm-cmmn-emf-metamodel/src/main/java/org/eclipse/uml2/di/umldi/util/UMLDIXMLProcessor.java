/**
 */
package org.eclipse.uml2.di.umldi.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.uml2.di.umldi.UMLDIPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLDIXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLDIXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        UMLDIPackage.eINSTANCE.eClass();
    }
    
    /**
     * Register for "*" and "xml" file extensions the UMLDIResourceFactoryImpl factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new UMLDIResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new UMLDIResourceFactoryImpl());
        }
        return registrations;
    }

} //UMLDIXMLProcessor
