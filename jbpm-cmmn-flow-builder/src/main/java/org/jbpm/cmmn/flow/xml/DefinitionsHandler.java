package org.jbpm.cmmn.flow.xml;

import org.drools.core.process.core.datatype.DataType;
import org.drools.core.process.core.datatype.impl.type.*;
import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.datatypes.CollectionDataType;
import org.jbpm.cmmn.flow.common.impl.CaseFileItemStandardEventNodeImpl;
import org.jbpm.cmmn.flow.common.impl.PlanItemStandardEventNode;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinition;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinitionType;
import org.jbpm.cmmn.flow.core.Definitions;
import org.jbpm.cmmn.flow.core.impl.CaseFileItemDefinitionImpl;
import org.jbpm.cmmn.flow.core.impl.CaseFileItemImpl;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.DefinitionsImpl;
import org.jbpm.compiler.xml.ProcessBuildData;
import org.jbpm.process.core.context.variable.Variable;
import org.jbpm.process.core.context.variable.VariableScope;
import org.kie.api.definition.process.Node;
import org.kie.api.definition.process.Process;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DefinitionsHandler extends BaseAbstractHandler implements Handler {
    private static final Map<CaseFileItemDefinitionType, TypeMap> TYPE_MAP_REGISTRY = new HashMap<CaseFileItemDefinitionType, TypeMap>();
    public static final String CASE_FILE_ITEM_DEFINITIONS = "CaseFileItemDefinitionImpl";

    public static void registerTypeMap(CaseFileItemDefinitionType typeSystem, TypeMap map) {
        TYPE_MAP_REGISTRY.put(typeSystem, map);
    }

    public DefinitionsHandler() {
        if ((this.validParents == null) && (this.validPeers == null)) {
            this.validParents = new HashSet<Class<?>>();
            this.validParents.add(null);

            this.validPeers = new HashSet<Class<?>>();
            this.validPeers.add(null);

            this.allowNesting = false;
        }
    }

    @Override
    public Object start(final String uri, final String localName, final Attributes attrs, final ExtensibleXmlParser parser) throws SAXException {
        parser.startElementBuilder(localName, attrs);
        ((ProcessBuildData) parser.getData()).setMetaData(CASE_FILE_ITEM_DEFINITIONS, new HashMap<String, CaseFileItemDefinitionImpl>());
        return new DefinitionsImpl();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object end(final String uri, final String localName, final ExtensibleXmlParser parser) throws SAXException {
        final Element element = parser.endElementBuilder();
        Definitions definitions = (Definitions) parser.getCurrent();
        String namespace = element.getAttribute("targetNamespace");
        List<Process> processes = ((ProcessBuildData) parser.getData()).getProcesses();
        Map<String, CaseFileItemDefinition> itemDefinitions = (Map<String, CaseFileItemDefinition>) ((ProcessBuildData) parser.getData())
                .getMetaData(CASE_FILE_ITEM_DEFINITIONS);
        for (Process process : processes) {
            CaseImpl cas = (CaseImpl) process;
            cas.setMetaData("TargetNamespace", namespace);
            setVariablesDataType(cas, itemDefinitions);
        }
        definitions.setTargetNamespace(namespace);
        return definitions;
    }

    @Override
    public Class<?> generateNodeFor() {
        return DefinitionsImpl.class;
    }

    private void setVariablesDataType(CaseImpl container, Map<String, CaseFileItemDefinition> itemDefinitions) {
        VariableScope variableScope = (VariableScope) container.getDefaultContext(VariableScope.VARIABLE_SCOPE);
        if (variableScope != null) {
            for (Variable variable : variableScope.getVariables()) {
                if (variable instanceof CaseFileItem) {
                    setVariableDataType(container,(CaseFileItemImpl) variable, itemDefinitions);
                }
            }
        }
        for (Node node : container.getNodes()) {
            if (node instanceof CaseFileItemStandardEventNodeImpl) {
                CaseFileItemStandardEventNodeImpl i = (CaseFileItemStandardEventNodeImpl) node;
                i.getVariable().setType(i.getSourceCaseFileItem().getType());
            } else if (node instanceof PlanItemStandardEventNode) {
                ((PlanItemStandardEventNode) node).getVariable().setType(new ObjectDataType("org.jbpm.services.task.impl.model.TaskImpl"));

            }
        }
    }

    private void setVariableDataType(CaseImpl container, CaseFileItemImpl variable, Map<String, CaseFileItemDefinition> itemDefinitions) {
        // retrieve type from item impl
        String definitionRef = variable.getDefinitionRef();
        if (UndefinedDataType.getInstance().equals(variable.getType()) && itemDefinitions != null && definitionRef != null) {
            DataType dataType = new ObjectDataType();
            CaseFileItemDefinition itemDefinition = itemDefinitions.get(definitionRef);
            variable.setDefinition(itemDefinition);
            if (itemDefinition != null) {
                TypeMap typeMap = TYPE_MAP_REGISTRY.get(itemDefinition.getDefinitionType());
                String type = typeMap.getType(itemDefinition.getStructureRef());
                if ("java.lang.Boolean".equals(type) || "Boolean".equals(type)) {
                    dataType = new BooleanDataType();
                } else if ("java.lang.Integer".equals(type) || "Integer".equals(type)) {
                    dataType = new IntegerDataType();
                } else if ("java.lang.Float".equals(type) || "Float".equals(type)) {
                    dataType = new FloatDataType();
                } else if ("java.lang.String".equals(type) || "String".equals(type)) {
                    dataType = new StringDataType();
                } else if ("java.lang.Object".equals(type) || "Object".equals(type)) {
                    dataType = new ObjectDataType(type);
                } else {
                    container.getImports().add(type);
                    dataType = new ObjectDataType(type);
                }
            }
            if (variable.isCollection()) {
                String className = "java.util.Collection";
                if (variable.isUnique()) {
                    className = "java.util.Set";
                }
                if (variable.isOrdered()) {
                    className = "java.util.List";
                }
                CollectionDataType c = new CollectionDataType(className);
                c.setElementClassName(dataType.getStringType());
                dataType = c;
            }
            variable.setType(dataType);
        }
    }

}
