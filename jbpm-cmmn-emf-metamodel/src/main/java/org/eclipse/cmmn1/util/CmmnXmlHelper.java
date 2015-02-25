package org.eclipse.cmmn1.util;

import javax.xml.XMLConstants;

import org.eclipse.bpmn2.Definitions;
import org.eclipse.cmmn1.TDefinitions;
import org.eclipse.cmmn1.TImport;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;

public class CmmnXmlHelper extends XMLHelperImpl {

    public CmmnXmlHelper(Cmmn1ResourceImpl resource) {
        super(resource);
    }

    private TDefinitions getDefinitions() {
        return ImportHelper.getDefinitions(getResource());
    }

    /**
     * Checks if the given prefix is pointing to the current target namespace and thus is optional.
     * The method is called during load.
     * @param prefix The prefix or null, if no prefix is given (interpreted as default namespace).
     * @return <code>true</code>, if the namespace associated with the prefix equals the target namespace
     * of this Definitions.
     * If prefix is null or the empty string, then the default namespace is compared with the target namespace.
     * If prefix is null/empty and default namespace is not defined, <code>true</code> if the target namespace
     * is not defined either.
     *
     * <p>
     * The above rules describe a strict interpretation of the rules for QName resolution.
     * This method relaxes these rules and additionally returns <code>true</code> in the following cases:
     * <ul>
     * <li>prefix is null/empty, no default namespace (regardless of target namespace)</li>
     * <li>prefix is null/empty, default namespace is not {@linkplain ImportHelper#findImportForNamespace(Definitions, String) mapped by an import element}.</li>
     * </ul>
     * </p>
     */
    public boolean isTargetNamespace(String prefix) {
        if (prefix == null)
            prefix = XMLConstants.DEFAULT_NS_PREFIX;
        final String prefixNs = this.getNamespaceURI(prefix);

        if (prefixNs == null) {
            if (XMLConstants.DEFAULT_NS_PREFIX.equals(prefix))
                /*
                 * The (empty) prefix points to {no namespace}, because no default namespace is defined.
                 * This would be OK if target namespace is undefined as well (meaning {no namespace}).
                 *
                 * However, we employ a relaxed interpretation and do not require that
                 *   getDefinitions().getTargetNamespace() == null (i.e. target namespace == {no namespace})
                 * Every unprefixed QName is interpreted as local reference, if the default namespace is not defined.
                 */
                return true;

            // the non-empty prefix is not mapped to a namespace
            throw new IllegalArgumentException(String.format("The prefix '%s' is not valid.",
                    prefix));
        }

        // result with strict evaluation: return prefixNs.equals(getDefinitions().getTargetNamespace())
        if (prefixNs.equals(getDefinitions().getTargetNamespace()))
            return true;
        else if (XMLConstants.DEFAULT_NS_PREFIX.equals(prefix)
                && ImportHelper.findImportForNamespace(getDefinitions(), prefixNs) == null) {
            // The default namespace is not mapped to a location by an import element.
            // Guess that the unprefixed QName should point to a local element (relaxed interpretation)
            // TODO: emit warning
            return true;
        } else
            return false;
    }

    /**
     * Looks up the given prefix in the list of BPMN import elements and returns - if found - the corresponding file location.
     * The method is called during load.
     * @param prefix
     * @return
     */
    public URI getPathForPrefix(String prefix) {
        String ns = this.getNamespaceURI(prefix == null ? XMLConstants.DEFAULT_NS_PREFIX
                : prefix);
        if (ns != null) {
            TImport imp = ImportHelper.findImportForNamespace(getDefinitions(), ns);
            if (imp != null)
                return URI.createURI(imp.getLocation()).resolve(
                        ImportHelper.makeURICanonical(getResource().getURI()));
            else {
                return URI.createURI(ns);
            }
        }
        return URI.createURI("");
    }

    /**
     * Partly stolen from XmlHelperImpl.setPrefixToNamespaceMap().
     * Ensuring that namespace declaration is saved seems to be really tricky.
     * We will necessarily create a dummy package to ensure that later XmlSaveImpl.addNamespaceDeclarations() writes the ns declaration for us
     * @param namespace
     * @return
     */
    private String getPrefixDuringSave(String namespace) {
        if (urisToPrefixes.containsKey(namespace))
            return urisToPrefixes.get(namespace).get(0);

        EPackage ePackage = extendedMetaData.getPackage(namespace);
        if (ePackage == null) {
            ePackage = extendedMetaData.demandPackage(namespace);
            // This will internally create a nice prefix
        }

        String prefix;
        if (namespace.equals(getDefinitions().getTargetNamespace()))
            // try to use the default namespace (xmlns="...") for local references
            prefix = XMLConstants.DEFAULT_NS_PREFIX;
        else
            prefix = ePackage.getNsPrefix();

        // Make prefix unique
        String originalPrefix = prefix + "_";
        int discr = 0;
        while (prefixesToURIs.containsKey(prefix)
                && !prefixesToURIs.get(prefix).equals(namespace))
            prefix = originalPrefix + discr++;

        // I'm not sure if the following code is needed, but I keep it to avoid inconsistencies
        if (!packages.containsKey(ePackage)) {
            packages.put(ePackage, prefix);
        }
        prefixesToURIs.put(prefix, namespace);
        return prefix;
    }

    /**
     * This is called on save to convert from a file-based URI to a namespace prefix.
     * It might be necessary to add a new namespace declaration to the file, if  the
     * namespace was not known to far.
     * @param referenced Absolute or relative to current working directory.
     * @return
     */
    public String getNsPrefix(URI referenced) {
        String ns = null;
        String prefix = "";

        URI referencedAbs = ImportHelper.makeURICanonical(referenced);
        URI thisAbs = ImportHelper.makeURICanonical(getResource().getURI());
        URI relativeToThis = referencedAbs.deresolve(thisAbs);
        if (relativeToThis.isEmpty())
            // reference to local element
            ns = getDefinitions().getTargetNamespace();
        else {
            TImport impForRef = ImportHelper.findImportForLocation(getDefinitions(), referenced);
            if (impForRef != null)
                ns = impForRef.getNamespace();
        }
        if (ns != null) {
            prefix = getPrefixDuringSave(ns);
        }
        return prefix;
    }
}