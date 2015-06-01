package org.jbpm.cmmn.flow.xml;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.drools.core.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.process.core.datatype.impl.type.StringDataType;
import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.datatypes.CollectionDataType;
import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinition;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.Definitions;
import org.jbpm.cmmn.flow.core.PlanItemDefinition;
import org.jbpm.cmmn.flow.core.PlanningTable;
import org.jbpm.cmmn.flow.core.PlanningTableContainer;
import org.jbpm.cmmn.flow.core.TableItem;
import org.jbpm.cmmn.flow.core.TaskDefinition;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.Stage;
import org.jbpm.cmmn.flow.core.planitem.SentryImpl;
import org.jbpm.cmmn.flow.core.planitem.StagePlanItem;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.core.planning.PlanningTableImpl;
import org.jbpm.cmmn.flow.core.planning.TableItemImpl;
import org.jbpm.cmmn.flow.core.task.CaseTask;
import org.jbpm.cmmn.flow.core.task.HumanTask;
import org.jbpm.cmmn.instance.CaseEvent;
import org.jbpm.compiler.xml.ProcessBuildData;
import org.jbpm.process.core.context.variable.Variable;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.workflow.core.NodeContainer;
import org.kie.api.definition.process.Node;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class CaseHandler extends PlanItemContainerHandler implements Handler {
    public static final String CURRENT_EVENT = "currentEvent";

    public CaseHandler() {
        if ((this.validParents == null) && (this.validPeers == null)) {
            this.validParents = new HashSet<Class<?>>();
            this.validParents.add(Definitions.class);
            this.validPeers = new HashSet<Class<?>>();
            this.validPeers.add(null);
            this.validPeers.add(CaseFileItemDefinition.class);
            this.validPeers.add(RuleFlowProcess.class);
        }
    }

    @Override
    public Object start(final String uri, final String localName, final Attributes attrs, final ExtensibleXmlParser parser) throws SAXException {
        parser.startElementBuilder(localName, attrs);
        IdGenerator.reset();
        String id = attrs.getValue("id");
        String name = attrs.getValue("name");
        String packageName = attrs.getValue("http://www.jboss.org/drools", "packageName");
        CaseImpl process = new CaseImpl();
        process.setId(id);
        if (name == null) {
            name = id;
        }
        process.setName(name);
        process.setType("RuleFlow");
        if (packageName == null) {
            packageName = "org.pavanecce.cmmn.jbpm";
        }
        process.setPackageName(packageName);
        process.setDynamic(true);
        ((ProcessBuildData) parser.getData()).addProcess(process);
        super.startNodeContainer(process, parser);
        VariableScope variableScope = (VariableScope) process.getDefaultContext(VariableScope.VARIABLE_SCOPE);
        List<Variable> variables = variableScope.getVariables();
        Variable var = new Variable();
        var.setName(CURRENT_EVENT);
        var.setType(new ObjectDataType(CaseEvent.class.getName()));
        variables.add(var);
        Set<String> roleNames = new HashSet<String>();
        Collection<CaseRole> roles = process.getRoles();
        for (CaseRole role : roles) {
            roleNames.add(role.getName());
            Variable caseRole = new Variable();
            caseRole.setName(role.getName());
            CollectionDataType coll = new CollectionDataType();
            coll.setElementClassName("java.lang.String");
            caseRole.setType(coll);
            variables.add(caseRole);
        }

        if (!roleNames.contains(WorkItemParameters.INITIATOR)) {
            Variable initiator = new Variable();
            initiator.setName(WorkItemParameters.INITIATOR);
            initiator.setType(new StringDataType());
            variables.add(initiator);
        }
        if (!roleNames.contains(WorkItemParameters.CASE_OWNER)) {
            Variable caseOwner = new Variable();
            caseOwner.setName(WorkItemParameters.CASE_OWNER);
            caseOwner.setType(new StringDataType());
            variables.add(caseOwner);
        }
        return process;
    }

    @Override
    public Object end(final String uri, final String localName, final ExtensibleXmlParser parser) throws SAXException {
        Element el = (Element) parser.endElementBuilder();
        CaseImpl process = (CaseImpl) parser.getCurrent();
        Element cpm = (Element) el.getElementsByTagName("casePlanModel").item(0);
        process.setAutoComplete("true".equals(cpm.getAttribute("autoComplete")));
        VariableScope variableScope = process.getVariableScope();
        List<Variable> variables = variableScope.getVariables();
        for (Variable variable : variables) {
            if (variable instanceof CaseFileItem) {
                CaseFileItem c = (CaseFileItem) variable;
                for (Entry<String, CaseFileItem> entry : c.getTargets().entrySet()) {
                    if (entry.getValue() == null) {
                        entry.setValue(findCaseFileItemById(variableScope, entry.getKey()));
                    }
                }
            }
        }
        linkParametersToCaseFileItems(variableScope, process.getInputParameters());
        linkParametersToCaseFileItems(variableScope, process.getOutputParameters());
        doRoleAndDefinitionMapping(process.getPlanItemDefinitions(), process.getRoles(), process.getPlanningTable());
        Collection<PlanItemDefinition> planItemDefinitions = process.getPlanItemDefinitions();
        for (PlanItemDefinition pi : planItemDefinitions) {
            if (pi instanceof TaskDefinition) {
                if (pi instanceof HumanTask) {
                    HumanTask ht = (HumanTask) pi;
                    Collection<CaseRole> roles = process.getRoles();
                    for (CaseRole role : roles) {
                        if (role.getElementId().equals(ht.getPerformerRef())) {
                            ht.setPerformer(role);
                        }
                    }
                    doRoleAndDefinitionMapping(process.getPlanItemDefinitions(), roles, ht.getPlanningTable());
                }
                linkParametersToCaseFileItems(variableScope, ((TaskDefinition) pi).getInputs());
                linkParametersToCaseFileItems(variableScope, ((TaskDefinition) pi).getOutputs());
            } else if (pi instanceof Stage) {
                doRoleAndDefinitionMapping(process.getPlanItemDefinitions(), process.getRoles(), ((Stage) pi).getPlanningTable());
            }
        }
        linkPlanItems(process, parser);
        for (PlanItemDefinition planItemDefinition : planItemDefinitions) {
            if (planItemDefinition instanceof Stage) {
                super.linkPlanItems((Stage) planItemDefinition, parser);
            }
        }
        linkDiscretionaryItemCriteria(process.getPlanningTable(), process);

        for (PlanItemDefinition planItemDefinition : planItemDefinitions) {
            if (planItemDefinition instanceof PlanningTableContainer) {
                PlanningTable planningTable = ((PlanningTableContainer) planItemDefinition).getPlanningTable();
                linkDiscretionaryItemCriteria(planningTable, process);
            }
        }
        copyStagePlanItems(process);
        copyDiscretionaryItems(process);
        String exitsString = cpm.getAttribute("exitCriteriaRefs");
        if (exitsString != null) {
            String[] exitCriteriaRefs = exitsString.split("\\ ");
            for (String string : exitCriteriaRefs) {
                for (Node node : process.getNodes()) {
                    if (node instanceof SentryImpl && ((SentryImpl) node).getElementId().equals(string)) {
                        ((SentryImpl) node).setExitsCase(true);
                    }
                }
            }
        }
        return process;
    }

    private void linkDiscretionaryItemCriteria(PlanningTable planningTable, Case theCase) {
        if (planningTable != null) {
            for (TableItem tableItem : planningTable.getTableItems()) {
                if (tableItem instanceof DiscretionaryItemImpl) {
                    linkDiscretionaryItemCriteria(tableItem.getParentTable().getFirstPlanItemContainer(), (DiscretionaryItemImpl<?>) tableItem);
                } else {
                    linkDiscretionaryItemCriteria((PlanningTableImpl) tableItem, theCase);
                }
            }
        }
    }

    private void copyDiscretionaryItems(NodeContainer nc) {
        if (nc instanceof PlanningTableContainer) {
            PlanningTable pt = ((PlanningTableContainer) nc).getPlanningTable();
            if (pt != null) {
                copyDiscretionaryItemsInTable(pt);
            }
            Node[] nodes = nc.getNodes();
            for (Node node : nodes) {
                if (node instanceof NodeContainer) {
                    copyDiscretionaryItems((NodeContainer) node);
                }
            }
        }
    }

    private void copyDiscretionaryItemsInTable(PlanningTable pt) {
        for (TableItem ti : pt.getTableItems()) {
            if (ti instanceof DiscretionaryItemImpl
                    && (((DiscretionaryItemImpl<?>) ti).getDefinition() instanceof Stage || ((DiscretionaryItemImpl<?>) ti).getDefinition() instanceof CaseTask)) {
//                ((DiscretionaryItemImpl<?>) ti).copyFromDefinition();
            } else if (ti instanceof PlanningTableImpl) {
                copyDiscretionaryItemsInTable((PlanningTableImpl) ti);
            }
        }
    }

    private void copyStagePlanItems(NodeContainer nc) {
        Node[] nodes = nc.getNodes();
        for (Node node : nodes) {
            if (node instanceof StagePlanItem) {
                StagePlanItem spi = (StagePlanItem) node;
                spi.copyFromStage();
                copyStagePlanItems(spi);
            }
        }
    }

    @SuppressWarnings("unchecked")
    protected void doRoleAndDefinitionMapping(Collection<PlanItemDefinition> defs, Collection<CaseRole> roles, TableItem pt) {
        if (pt != null) {
            doRoleMapping(defs, roles, pt.getAuthorizedRoles());
            if (pt instanceof PlanningTableImpl) {
                Collection<TableItemImpl> tableItems = ((PlanningTableImpl) pt).getTableItems();
                for (TableItem tableItem : tableItems) {
                    doRoleMapping(defs, roles, tableItem.getAuthorizedRoles());
                    doRoleAndDefinitionMapping(defs, roles, tableItem);
                }
            } else {
                for (PlanItemDefinition pid : defs) {
                    @SuppressWarnings("rawtypes")
                    DiscretionaryItemImpl di = (DiscretionaryItemImpl<?>) pt;
                    if (pid.getElementId().equals(di.getDefinitionRef())) {
                        di.setDefinition(pid);
                    }
                }
            }
        }
    }

    protected void doRoleMapping(Collection<PlanItemDefinition> defs, Collection<CaseRole> roles, Map<String, CaseRole> authorizedRoles) {
        Set<Entry<String, CaseRole>> entrySet = authorizedRoles.entrySet();
        for (Entry<String, CaseRole> entry : entrySet) {
            for (CaseRole role : roles) {
                if (entry.getValue() == null && entry.getKey().equals(role.getElementId())) {
                    entry.setValue(role);
                }
            }
        }
    }

    private void linkParametersToCaseFileItems(VariableScope variableScope, Collection<CaseParameter> inputParameters) {
        for (CaseParameter caseParameter : inputParameters) {
            caseParameter.setBoundVariable(findCaseFileItemById(variableScope, caseParameter.getBindingRef()));
        }
    }

    @Override
    public Class<?> generateNodeFor() {
        return CaseImpl.class;
    }

}
