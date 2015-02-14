/**
 */
package org.eclipse.cmmn1.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.cmmn1.Cmmn1Factory;
import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TDefinitions;
import org.eclipse.cmmn1.TImport;
import org.eclipse.cmmndi.CmmnDiPackage;
import org.eclipse.dd.cmmn.di.DiPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.cmmn1.util.Cmmn1ResourceFactoryImpl
 * @generated
 */
public class Cmmn1ResourceImpl extends XMLResourceImpl {
    private static Set<EClass> referrables = new HashSet<EClass>();
    static {
        referrables.add(Cmmn1Package.eINSTANCE.getTApplicabilityRule());
        referrables.add(Cmmn1Package.eINSTANCE.getTCase());
        referrables.add(Cmmn1Package.eINSTANCE.getTCaseFileItem());
        referrables.add(Cmmn1Package.eINSTANCE.getTCaseFileItemDefinition());
        referrables.add(Cmmn1Package.eINSTANCE.getTCaseFileItemOnPart());
        referrables.add(Cmmn1Package.eINSTANCE.getTCaseFileItemStartTrigger());
        referrables.add(Cmmn1Package.eINSTANCE.getTCaseParameter());
        referrables.add(Cmmn1Package.eINSTANCE.getTCaseTask());
        referrables.add(Cmmn1Package.eINSTANCE.getTDefinitions());
        referrables.add(Cmmn1Package.eINSTANCE.getTDiscretionaryItem());
        referrables.add(Cmmn1Package.eINSTANCE.getTHumanTask());
        referrables.add(Cmmn1Package.eINSTANCE.getTPlanFragment());
        referrables.add(Cmmn1Package.eINSTANCE.getTPlanItem());
        referrables.add(Cmmn1Package.eINSTANCE.getTPlanItemOnPart());
        referrables.add(Cmmn1Package.eINSTANCE.getTPlanItemStartTrigger());
        referrables.add(Cmmn1Package.eINSTANCE.getTProcess());
        referrables.add(Cmmn1Package.eINSTANCE.getTProcessParameter());
        referrables.add(Cmmn1Package.eINSTANCE.getTRole());
        referrables.add(Cmmn1Package.eINSTANCE.getTSentry());
        referrables.add(Cmmn1Package.eINSTANCE.getTStage());
        referrables.add(Cmmn1Package.eINSTANCE.getTTimerEvent());
        referrables.add(Cmmn1Package.eINSTANCE.getTProperty());
        referrables.add(CmmnDiPackage.eINSTANCE.getCMMNShape());
        referrables.add(CmmnDiPackage.eINSTANCE.getCMMNEdge());
    }
    private CmmnXmlHelper xmlHelper;
    private QNameURIHandler uriHandler;

    /**
     * Creates an instance of the resource.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param uri the URI of the new resource.
     * @generated
     */
    public Cmmn1ResourceImpl(URI uri) {
        super(uri);
        this.xmlHelper=new CmmnXmlHelper(this);
        this.uriHandler=new QNameURIHandler(xmlHelper);
        this.getDefaultLoadOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);
        this.getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);

    }

    @Override
    protected XMLHelper createXMLHelper() {
        return this.xmlHelper;
    }

    @Override
    protected XMLLoad createXMLLoad() {
        return new XMLLoadImpl(createXMLHelper()) {
            @Override
            protected DefaultHandler makeDefaultHandler() {
                return new CmmnXmlHandler(resource, helper, options);
            }
        };
    }

    // This method is called by all save methods - save(Document,...),
    // doSave(Writer/OutputStream, ...) - in superclasses.
    @Override
    protected XMLSave createXMLSave() {
        prepareSave();
        return new XMLSaveImpl(createXMLHelper()) {
            @Override
            protected boolean shouldSaveFeature(EObject o, EStructuralFeature f) {
                return super.shouldSaveFeature(o, f);
            }
        };
    }

    /**
     * Prepares this resource for saving.
     *
     * Sets all ID attributes of contained and referenced objects that are not
     * yet set, to a generated UUID.
     */
    protected void prepareSave() {
        EObject cur;
        TDefinitions thisDefinitions = ImportHelper.getDefinitions(this);
        for (Iterator<EObject> iter = getAllContents(); iter.hasNext();) {
            cur = iter.next();

            setIdIfNotSet(cur);

            for (EObject referenced : cur.eCrossReferences()) {
                setIdIfNotSet(referenced);
                if (thisDefinitions != null) {
                    Resource refResource = referenced.eResource();
                    if (refResource != null && refResource != this) {
                        createImportIfNecessary(thisDefinitions, refResource);
                    }
                }
            }
        }
    }
    /**
     * Looks for an import of the referenced resource from the given definitions object.
     * If none is found, the method creates a new import element.
     * @param definitions The model that references an object contained in <code>reference</code>
     * and thus needs an import element to <code>reference</code>.
     * @param referenced The resource which needs to be imported into <code>definitions</code>.
     */
    protected void createImportIfNecessary(TDefinitions definitions, Resource referenced) {
        if (ImportHelper.findImportForLocation(definitions, referenced.getURI()) == null) {
            URI referencingURI = ImportHelper.makeURICanonical(definitions.eResource().getURI());
            URI referencedURI = ImportHelper.makeURICanonical(referenced.getURI());

            TDefinitions importedDef = ImportHelper.getDefinitions(referenced);
            // only handle CMMN imports (with declared target namespace)
            if (importedDef != null && importedDef.getTargetNamespace() != null) {
//                TImport newImport = Cmmn1Factory.eINSTANCE.createTImport();
//                newImport.setImportType(NamespaceHelper.xmiToXsdNamespaceUri(Cmmn1Package.eNS_URI));
//                newImport.setNamespace(importedDef.getTargetNamespace());
//                // Counterpart: location.resolve(referencingURI) == referencedURI !
//                newImport.setLocation(referencedURI.deresolve(referencingURI).toString());
//                definitions.getImport().add(newImport);
            }
        }
    }


    /**
     * Set the ID attribute of cur to a generated ID, if it is not already set.
     *
     * @param obj
     *            The object whose ID should be set.
     */
    protected static void setIdIfNotSet(EObject obj) {
        if (obj.eClass() != null && referrables.contains(obj.eClass())) {
            EStructuralFeature idAttr = obj.eClass().getEIDAttribute();
            if (idAttr != null && !obj.eIsSet(idAttr)) {
                obj.eSet(idAttr, EcoreUtil.generateUUID());
            }
        }
    }
} // Cmmn1ResourceImpl
