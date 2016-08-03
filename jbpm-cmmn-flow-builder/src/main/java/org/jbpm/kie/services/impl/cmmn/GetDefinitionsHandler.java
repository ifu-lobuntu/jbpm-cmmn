package org.jbpm.kie.services.impl.cmmn;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinition;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.Definitions;
import org.jbpm.cmmn.flow.core.PlanItemContainer;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.definition.CaseTaskDefinition;
import org.jbpm.cmmn.flow.definition.HumanTaskDefinition;
import org.jbpm.cmmn.flow.definition.Stage;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.xml.DefinitionsHandler;
import org.jbpm.compiler.xml.ProcessBuildData;
import org.jbpm.kie.services.impl.bpmn2.UserTaskDefinitionImpl;
import org.kie.api.definition.process.Node;
import org.kie.api.definition.process.Process;
import org.xml.sax.SAXException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetDefinitionsHandler extends DefinitionsHandler {


    @Override
    public Object end(String uri, String localName, ExtensibleXmlParser parser) throws SAXException {
        //We have to do it here because so much linkage is required up front
        Definitions defs = (Definitions) super.end(uri, localName, parser);
        List<Process> processes = ((ProcessBuildData) parser.getData()).getProcesses();
        Map<String, CaseFileItemDefinition> itemDefinitions = (Map<String, CaseFileItemDefinition>) ((ProcessBuildData) parser.getData())
                .getMetaData(CASE_FILE_ITEM_DEFINITIONS);
        for (Process process : processes) {
            CaseImpl cas = (CaseImpl) process;
            // Now dow all the stuff
            cas.getPlanItems();
            processPlanItems(cas);
        }
        return defs;
    }

    protected void processPlanItems(PlanItemContainer pic) {
        for (Node node : pic.getNodes()) {
            if (node instanceof PlanItem) {
                PlanItem<?> pi = (PlanItem<?>) node;
                if (pi.getDefinition() instanceof HumanTaskDefinition) {
                    Map<String, String> inputMappings = new HashMap<String, String>();
                    UserTaskDefinitionImpl utd = new UserTaskDefinitionImpl();
                    for (CaseParameter cp : ((HumanTaskDefinition) pi.getDefinition()).getInputs()) {
                        if (cp.getBindingRefinement() != null && cp.getBindingRefinement().getExpression() != null) {
                            inputMappings.put(cp.getName(), cp.getBindingRefinement().getExpression().getConstraint());
                        } else if (cp.getBoundVariable() != null) {
                            inputMappings.put(cp.getName(), cp.getBoundVariable().getName());
                        }
                    }
                    utd.setTaskInputMappings(inputMappings);
                } else if (pi.getDefinition() instanceof CaseTaskDefinition) {

                } else if (pi.getDefinition() instanceof Stage) {
                    processPlanItems((PlanItemContainer) node);
                }
            }
        }
    }
}
