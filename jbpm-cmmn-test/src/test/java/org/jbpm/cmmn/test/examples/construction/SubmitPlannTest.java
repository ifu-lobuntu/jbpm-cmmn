package org.jbpm.cmmn.test.examples.construction;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.jbpm.cmmn.test.AbstractCmmnCaseTestCase;
import org.junit.Test;

public class SubmitPlannTest extends AbstractCmmnCaseTestCase{

    public SubmitPlannTest() {
        super(true,true,"org.jbpm.persistence.jpa");
    }
    @SuppressWarnings("rawtypes")
    @Override
    protected Class[] getClasses() {
        return new Class[0];
    }
    @Test
    public void testIt() throws Exception{
        String root="/home/ampie/Code/pavanecce/cmmn-examples/construction/src/main/resources/";
        String resource = "org/jbpm/construction/SubmitPlan.cmmn";
        FileUtils.copyFile(new File(root,resource), new File("./src/test/resources/" + resource));
        super.createRuntimeManager(resource);
    }
}