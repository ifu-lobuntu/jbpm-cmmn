package org.jbpm.cmmn.flow.builder;

import org.drools.compiler.compiler.ReturnValueDescr;
import org.drools.compiler.lang.descr.ActionDescr;
import org.drools.compiler.lang.descr.ProcessDescr;
import org.drools.core.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.cmmn.datatypes.CollectionDataType;
import org.jbpm.cmmn.flow.common.ItemWithDefinition;
import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinitionType;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.PlanItemControlImpl;
import org.jbpm.cmmn.flow.definition.ParameterMapping;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.TaskDefinition;
import org.jbpm.cmmn.flow.definition.impl.TaskDefinitionImpl;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planning.ApplicabilityRule;
import org.jbpm.cmmn.flow.planning.PlanningTableContainer;
import org.jbpm.cmmn.flow.planning.TableItem;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.planning.impl.PlanningTableImpl;
import org.jbpm.cmmn.flow.planning.impl.TableItemImpl;
import org.jbpm.process.builder.ActionBuilder;
import org.jbpm.process.builder.ProcessBuildContext;
import org.jbpm.process.builder.ProcessNodeBuilder;
import org.jbpm.process.builder.ReturnValueEvaluatorBuilder;
import org.jbpm.process.builder.dialect.ProcessDialectRegistry;
import org.jbpm.process.core.context.variable.Variable;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.process.instance.impl.ReturnValueConstraintEvaluator;
import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.DroolsAction;
import org.jbpm.workflow.core.impl.ConstraintImpl;
import org.jbpm.workflow.core.impl.NodeImpl;
import org.kie.api.definition.process.Node;
import org.kie.api.definition.process.Process;

import java.util.Collection;

//TODO(ampie): PlanItemBuilder is a hack to get to items not in the processTree. 
public class PlanItemBuilder implements ProcessNodeBuilder {

    @Override
    public void build(Process process, ProcessDescr processDescr, ProcessBuildContext context, Node node) {
        processCaseOnce(process, processDescr, context, node);
        processPlanItem(processDescr, context, node);
    }

    protected void processCaseOnce(Process process, ProcessDescr processDescr, ProcessBuildContext context, Node node) {
        CaseImpl theCase = (CaseImpl) process;
        if (!theCase.isBuilt()) {
            processCaseInputParameters(process, context);
            if (((CaseImpl) process).getPlanningTable() != null) {
                processPlanningTable(processDescr, context, node, (PlanningTableImpl) theCase.getPlanningTable());
            }
            theCase.setBuilt(true);
        }
    }

    private void processPlanItem(ProcessDescr processDescr, ProcessBuildContext context, Node node) {
        ItemWithDefinition<?> item = (ItemWithDefinition<?>) node;
        if (item.getDefinition() instanceof PlanningTableContainer) {
            PlanningTableContainer ptc = (PlanningTableContainer) item.getDefinition();
            PlanningTableImpl planningTable = (PlanningTableImpl) ptc.getPlanningTable();
            if (planningTable != null) {
                processPlanningTable(processDescr, context, node, planningTable);
            }
        }
        processItemWithDefinition(context, node, item);
    }

    private void processPlanningTable(ProcessDescr processDescr, ProcessBuildContext context, Node node, PlanningTableImpl planningTable) {
        for (ApplicabilityRule ar : planningTable.getOwnedApplicabilityRules()) {
            ar.setCondition(build(context, node, ar.getCondition()));
        }
        Collection<TableItem> tableItems = planningTable.getTableItems();
        for (TableItem tableItem : tableItems) {
            if (tableItem instanceof DiscretionaryItemImpl<?>) {
                DiscretionaryItemImpl<?> di = (DiscretionaryItemImpl<?>) tableItem;
                processItemWithDefinition(context, node, di);
                for (Node child : di.getNodes()) {
                    if (child instanceof PlanItem) {
                        processPlanItem( processDescr, context, child);
                    }
                }
            } else {
                processPlanningTable(processDescr, context, node, (PlanningTableImpl) tableItem);
            }
        }
    }

    private void processItemWithDefinition(ProcessBuildContext context, Node node, ItemWithDefinition<?> item) {
        PlanItemDefinition def = item.getDefinition();
        if (def instanceof TaskDefinition) {
            processParameters(context, node, ((TaskDefinition) def).getInputs());
            processParameters(context, node, ((TaskDefinition) def).getOutputs());
            if (def instanceof TaskDefinitionImpl) {
                for (ParameterMapping pm : ((TaskDefinitionImpl) def).getParameterMappings()) {
                    CaseParameter cp = pm.getSourceParameter();
                    if (cp == null) {
                        cp = pm.getTargetParameter();
                    }
                    NodeImpl nodeImpl = (NodeImpl) node;
                    VariableScope variableScope = (VariableScope) nodeImpl.getContext(VariableScope.VARIABLE_SCOPE);
                    if (variableScope == null) {
                        nodeImpl.setContext(VariableScope.VARIABLE_SCOPE, variableScope = new VariableScope());
                    }
                    Variable sourceVar = new Variable();
                    sourceVar.setName("source");
                    CaseFileItem boundVariable = cp.getBoundVariable();
                    if (boundVariable.isCollection()) {
                        CollectionDataType cdt = (CollectionDataType) boundVariable.getType();
                        sourceVar.setType(new ObjectDataType(cdt.getElementClassName()));
                    } else {
                        sourceVar.setType(boundVariable.getType());
                    }
                    variableScope.getVariables().add(sourceVar);
                    pm.setTransformation(build(context, node, pm.getTransformation()));
                    variableScope.getVariables().remove(sourceVar);
                }
            }
        }
        buildControl(context, node, (PlanItemControlImpl) def.getDefaultControl());
        buildControl(context, node, (PlanItemControlImpl) item.getItemControl());
    }

    protected void buildControl(ProcessBuildContext context, Node node, PlanItemControlImpl itemControl) {
        if (itemControl != null) {
            itemControl.setManualActivationRule(build(context, node, itemControl.getManualActivationRule()));
            itemControl.setRequiredRule(build(context, node, itemControl.getRequiredRule()));
            itemControl.setRepetitionRule(build(context, node, itemControl.getRepetitionRule()));
        }
    }

    protected void processCaseInputParameters(Process process, ProcessBuildContext context) {
        CaseImpl case1 = (CaseImpl) process;
        processParameters(context, case1.getDefaultStart(), case1.getInputParameters());
        processParameters(context, case1.getDefaultStart(), case1.getOutputParameters());
    }

    private void processParameters(ProcessBuildContext context, final Node node, Collection<org.jbpm.cmmn.flow.core.CaseParameter> inputs2) {
        for (CaseParameter cp : inputs2) {
            if (cp.getBindingRefinement() != null) {
                Constraint constraint = cp.getBindingRefinement().getExpression();
                if (constraint != null && !(constraint instanceof ReturnValueConstraintEvaluator) && cp.getBindingRefinement().getParentExpression() == null) {
                    String parentExpression = getParentExpression(cp, constraint);
                    if (parentExpression != null) {
                        Constraint parentConstraint = new ConstraintImpl();
                        parentConstraint.setDialect(constraint.getDialect());
                        parentConstraint.setConstraint(parentExpression);
                        parentConstraint.setDefault(constraint.isDefault());
                        parentConstraint.setPriority(constraint.getPriority());
                        parentConstraint.setType(constraint.getType());
                        parentConstraint.setDialect(constraint.getDialect());
                        cp.getBindingRefinement().setParentExpression(build(context, node, parentConstraint));
                        ActionBuilder builder = ProcessDialectRegistry.getDialect("java").getActionBuilder();
                        DroolsAction action = new DroolsAction();
                        ActionDescr actionDescr = new ActionDescr(buildSetter(cp, parentExpression));
                        NodeImpl nodeImpl = (NodeImpl) node;
                        VariableScope variableScope = (VariableScope) nodeImpl.getContext(VariableScope.VARIABLE_SCOPE);
                        if (variableScope == null) {
                            nodeImpl.setContext(VariableScope.VARIABLE_SCOPE, variableScope = new VariableScope());
                        }
                        Variable sourceVar = new Variable();
                        sourceVar.setName("source");
                        sourceVar.setType(cp.getBoundVariable().getType());
                        variableScope.getVariables().add(sourceVar);
                        builder.build(context, action, actionDescr, nodeImpl);
                        cp.getBindingRefinement().setSetterOnParent(action);
                        variableScope.getVariables().remove(sourceVar);
                    }
                    cp.getBindingRefinement().setExpression(build(context, node, constraint));
                }
            }
        }
    }

    private String buildSetter(CaseParameter cp, String parentExpression) {
        StringBuilder sb = new StringBuilder();
        String[] split = parentExpression.split("\\;");
        for (String string : split) {
            if (string.trim().startsWith("return")) {
                string = string.trim().substring(6);
                CaseFileItemDefinitionType defType = cp.getBoundVariable().getDefinition().getDefinitionType();
                if (defType == CaseFileItemDefinitionType.CMIS_DOCUMENT || defType == CaseFileItemDefinitionType.CMIS_RELATIONSHIP
                        || defType == CaseFileItemDefinitionType.CMIS_FOLDER) {
                    if (cp.getBoundVariable().isCollection()) {
                        sb.append("try{\n");
                        sb.append("  javax.jcr.Value[] values = new javax.jcr.Value[source.size()];\n");
                        sb.append("  int i = 0;\n");
                        sb.append("  for(Object object:source){\n");
                        sb.append("    javax.jcr.Node node=(javax.jcr.Node)object;\n");
                        sb.append("    values[i++]=node.getSession().getValueFactory().createValue(node);\n");
                        sb.append("  }\n");
                        sb.append(string).append(".setProperty(\"").append(cp.getBoundVariable().getName()).append("\", values);");
                        sb.append(" }catch(Exception e){throw new RuntimeException(e);}");
                    } else {
                        sb.append(string).append(".setProperty(\"").append(cp.getBoundVariable().getName()).append("\", source);");
                    }
                } else {
                    sb.append(string).append(".set").append(capitalize(cp.getBoundVariable().getName())).append("(source);");
                }
            } else {
                sb.append(string);
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static String capitalize(String name) {
        if (name == null) {
            return null;
        }
        char[] ca = name.toCharArray();
        if (ca.length == 0) {
            return name;
        } else {
            ca[0] = Character.toUpperCase(ca[0]);
            return new String(ca);
        }
    }

    public static String getParentExpression(CaseParameter cp, Constraint constraint) {
        return getParentExpression(constraint.getConstraint(), cp.getBoundVariable().getName());
    }

    protected static String getParentExpression(String constraintText, String varName) {
        boolean isExpressedOnParentInMvelOrOcl = constraintText.endsWith(varName);
        if (isExpressedOnParentInMvelOrOcl) {
            return constraintText.substring(0, constraintText.length() - varName.length() - 1);
        } else {
            String getter = "get" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1) + "();";
            boolean isExpressedOnParentInJava = constraintText.endsWith(getter);
            if (isExpressedOnParentInJava) {
                return constraintText.substring(0, constraintText.length() - getter.length() - 1) + ";";
            } else {
                int getNodePosition = constraintText.lastIndexOf(".getNode");
                if (getNodePosition > 0) {
                    String getNode = constraintText.substring(getNodePosition);
                    String[] split = getNode.split("\\\"");
                    if (split.length == 3) {
                        String[] path = split[1].split("[\\:\\/]");
                        for (String string : path) {
                            if (string.equals(varName)) {
                                // TODO(ampie): Calculating parentExpression in JCR can have complex path expressions
                                return constraintText.substring(0, getNodePosition) + ";";
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static ReturnValueConstraintEvaluator build(ProcessBuildContext context, Node node, Constraint constraint) {
        if (constraint != null && !(constraint instanceof ReturnValueConstraintEvaluator)) {
            ReturnValueConstraintEvaluator returnValueConstraint = new ReturnValueConstraintEvaluator();
            returnValueConstraint.setDialect(constraint.getDialect());
            returnValueConstraint.setName(constraint.getName());
            returnValueConstraint.setPriority(constraint.getPriority());
            returnValueConstraint.setDefault(constraint.isDefault());
            ReturnValueDescr returnValueDescr = new ReturnValueDescr();
            returnValueDescr.setText(constraint.getConstraint());
            ReturnValueEvaluatorBuilder builder = ProcessDialectRegistry.getDialect(constraint.getDialect()).getReturnValueEvaluatorBuilder();
            builder.build(context, returnValueConstraint, returnValueDescr, (NodeImpl) node);
            constraint = returnValueConstraint;
        }
        return (ReturnValueConstraintEvaluator) constraint;
    }

}
