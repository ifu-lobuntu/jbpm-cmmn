package org.jbpm.cmmn.test.examples.construction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinitionType;
import org.jbpm.cmmn.flow.xml.DefaultTypeMap;
import org.jbpm.cmmn.flow.xml.DefinitionsHandler;
import org.jbpm.cmmn.flow.xml.TypeMap;
import org.jbpm.cmmn.test.AbstractCmmnCaseTestCase;
import org.junit.AfterClass;
import org.junit.Test;

public class SubmitPlannTest extends AbstractCmmnCaseTestCase {

    public SubmitPlannTest() {
        super(true, true, "org.jbpm.persistence.jpa");
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Class[] getClasses() {
        return new Class[0];
    }

    @Test
    public void testIt() throws Exception {
        String root = "/home/ampie/Code/cmmn-examples/construction/src/main/resources/";
        String resource = "org/jbpm/construction/SubmitPlan.cmmn";
        try {
            FileUtils.copyFile(new File(root, resource), new File("./src/test/resources/" + resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DefinitionsHandler.registerTypeMap(CaseFileItemDefinitionType.UML_CLASS, new TypeMap() {
            @Override
            public String getType(String sourceType) {
                return "java.lang.Object";
            }
        });
        super.createRuntimeManager(resource);
    }

    @AfterClass
    public static void cleanup() {
        DefinitionsHandler.registerTypeMap(CaseFileItemDefinitionType.UML_CLASS, new DefaultTypeMap());
    }
}