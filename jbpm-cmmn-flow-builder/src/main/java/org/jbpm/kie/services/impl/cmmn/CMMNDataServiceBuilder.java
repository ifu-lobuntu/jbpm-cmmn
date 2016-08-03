package org.jbpm.kie.services.impl.cmmn;

import org.drools.compiler.builder.impl.KnowledgeBuilderConfigurationImpl;
import org.drools.compiler.builder.impl.KnowledgeBuilderImpl;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinitionType;
import org.jbpm.cmmn.flow.xml.*;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceConfiguration;
import org.kie.api.io.ResourceType;
import org.kie.internal.assembler.KieAssemblers;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.utils.ServiceRegistryImpl;

public class CMMNDataServiceBuilder extends CMMNBuilder {

    public CMMNDataServiceBuilder() {

    }

    @Override
    public void addResource(KnowledgeBuilder kbuilder, Resource resource, ResourceType type, ResourceConfiguration configuration) throws Exception {
        super.addResource(kbuilder, resource, type, configuration);
        KnowledgeBuilderImpl kb = (KnowledgeBuilderImpl) kbuilder;
        KnowledgeBuilderConfigurationImpl conf = kb.getBuilderConfiguration();
        if (!(conf.getSemanticModules().getSemanticModule(CMMNDataServiceSemanticModule.CMMN_URI) instanceof CMMNDataServiceSemanticModule)) {
            conf.addSemanticModule(new CMMNDataServiceSemanticModule());
        }
        kb.addProcessFromXml(resource);
    }
    public static void registerBuilder(){
        ServiceRegistryImpl.getInstance().get(KieAssemblers.class).getAssemblers().put(CMMN_RESOURCE_TYPE, new CMMNDataServiceBuilder());
    }
}
