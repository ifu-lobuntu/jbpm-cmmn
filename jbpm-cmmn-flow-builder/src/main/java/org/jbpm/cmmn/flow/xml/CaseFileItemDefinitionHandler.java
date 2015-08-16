package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinition;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinitionType;
import org.jbpm.cmmn.flow.core.impl.CaseFileItemDefinitionImpl;
import org.jbpm.cmmn.flow.core.impl.DefinitionsImpl;
import org.jbpm.cmmn.flow.util.NamespacePackageConverter;
import org.jbpm.compiler.xml.ProcessBuildData;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;

public class CaseFileItemDefinitionHandler extends BaseAbstractHandler implements Handler {

    public CaseFileItemDefinitionHandler() {
        if ((this.validParents == null) && (this.validPeers == null)) {
            this.validParents = new HashSet<Class<?>>();
            this.validParents.add(DefinitionsImpl.class);

            this.validPeers = new HashSet<Class<?>>();
            this.validPeers.add(null);
            this.validPeers.add(CaseFileItemDefinitionImpl.class);
            this.validPeers.add(RuleFlowProcess.class);
            this.allowNesting = false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object start(final String uri, final String localName, final Attributes attrs, final ExtensibleXmlParser parser) throws SAXException {
        parser.startElementBuilder(localName, attrs);
        String id = attrs.getValue("id");
        ProcessBuildData buildData = (ProcessBuildData) parser.getData();
        Map<String, CaseFileItemDefinition> itemDefinitions = (Map<String, CaseFileItemDefinition>) buildData
                .getMetaData(DefinitionsHandler.CASE_FILE_ITEM_DEFINITIONS);
        CaseFileItemDefinition caseFileItemDefinition = new CaseFileItemDefinitionImpl(id);
        caseFileItemDefinition.setDefinitionType(CaseFileItemDefinitionType.resolveByUri(attrs.getValue("definitionType")));
        itemDefinitions.put(id, caseFileItemDefinition);
        String structureRef = attrs.getValue("structureRef");
        if (structureRef == null || structureRef.trim().length() == 0) {
            structureRef = "java.lang.Object";
        } else if (structureRef.contains(":")) {
            try {
                Field nsf = ExtensibleXmlParser.class.getDeclaredField("namespaces");
                nsf.setAccessible(true);
                Map<String, String> nsMap = (Map<String, String>) nsf.get(parser);
                String namespace = nsMap.get(structureRef.substring(0, structureRef.lastIndexOf(':')));
                String localPart = structureRef.substring(structureRef.lastIndexOf(':') + 1);
                if (caseFileItemDefinition.getDefinitionType() == CaseFileItemDefinitionType.UML_CLASS) {
                    structureRef = NamespacePackageConverter.toPackage(new URL(namespace)) + "." + localPart;
                } else {
                    structureRef = namespace + "#" + localPart;
                }
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        caseFileItemDefinition.setStructureRef(structureRef);
        return caseFileItemDefinition;
    }

    @Override
    public Object end(final String uri, final String localName, final ExtensibleXmlParser parser) throws SAXException {
        Element e = parser.endElementBuilder();
        return parser.getCurrent();
    }

    @Override
    public Class<?> generateNodeFor() {
        return CaseFileItemDefinitionImpl.class;
    }

}
