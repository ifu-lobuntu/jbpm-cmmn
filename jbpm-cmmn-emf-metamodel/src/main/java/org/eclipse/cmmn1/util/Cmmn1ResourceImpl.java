/**
 */
package org.eclipse.cmmn1.util;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.cmmn1.util.Cmmn1ResourceFactoryImpl
 * @generated
 */
public class Cmmn1ResourceImpl extends XMLResourceImpl {
    /**
     * Creates an instance of the resource.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param uri the URI of the new resource.
     * @generated
     */
    public Cmmn1ResourceImpl(URI uri) {
        super(uri);
    }

    @Override
    protected XMLSave createXMLSave() {
        //TODO find a better place to do this
        TreeIterator<EObject> allContents = getAllContents();
        while (allContents.hasNext()) {
            EObject eObject = allContents.next();
            EStructuralFeature id = eObject.eClass().getEStructuralFeature("id");
            if(id instanceof EAttribute && eObject.eGet(id)==null){
                eObject.eSet(id, EcoreUtil.generateUUID());
            }
        }
        return super.createXMLSave();
    }

} // Cmmn1ResourceImpl
