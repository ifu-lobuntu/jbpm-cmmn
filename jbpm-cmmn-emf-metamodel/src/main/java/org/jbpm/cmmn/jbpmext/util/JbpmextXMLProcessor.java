/**
 */
package org.jbpm.cmmn.jbpmext.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.jbpm.cmmn.jbpmext.JbpmextPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JbpmextXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JbpmextXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        JbpmextPackage.eINSTANCE.eClass();
    }
    
    /**
     * Register for "*" and "xml" file extensions the JbpmextResourceFactoryImpl factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (registrations == null) {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new JbpmextResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new JbpmextResourceFactoryImpl());
        }
        return registrations;
    }

} //JbpmextXMLProcessor
