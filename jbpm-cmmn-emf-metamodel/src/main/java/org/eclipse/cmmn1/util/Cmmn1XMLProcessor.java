/**
 */
package org.eclipse.cmmn1.util;

import java.util.Map;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Cmmn1XMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cmmn1XMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        Cmmn1Package.eINSTANCE.eClass();
    }
    
    /**
     * Register for "*" and "xml" file extensions the Cmmn1ResourceFactoryImpl factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new Cmmn1ResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new Cmmn1ResourceFactoryImpl());
        }
        return registrations;
    }

} //Cmmn1XMLProcessor
