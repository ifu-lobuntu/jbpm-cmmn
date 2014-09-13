package org.jbpm.cmmn.flow.xml;

import org.drools.compiler.builder.impl.KnowledgeBuilderConfigurationImpl;
import org.drools.compiler.builder.impl.KnowledgeBuilderImpl;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceConfiguration;
import org.kie.api.io.ResourceType;
import org.kie.internal.assembler.KieAssemblerService;
import org.kie.internal.assembler.KieAssemblers;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.utils.ServiceRegistryImpl;

public class CMMNBuilder implements KieAssemblerService {
	public static final ResourceType CMMN_RESOURCE_TYPE = ResourceType.addResourceTypeToRegistry("CMMN", "CMMN", "src/main/resources", "cmmn");
	static {
		ServiceRegistryImpl.getInstance().get(KieAssemblers.class).getAssemblers().put(CMMN_RESOURCE_TYPE, new CMMNBuilder());
	}

	@Override
	public Class<?> getServiceInterface() {
		return KieAssemblerService.class;
	}

	@Override
	public ResourceType getResourceType() {
		return CMMN_RESOURCE_TYPE;
	}

	@Override
	public void addResource(KnowledgeBuilder kbuilder, Resource resource, ResourceType type, ResourceConfiguration configuration)
			throws Exception {
		KnowledgeBuilderImpl kb = (KnowledgeBuilderImpl) kbuilder;
		KnowledgeBuilderConfigurationImpl conf = kb.getBuilderConfiguration();
		if (conf.getSemanticModules().getSemanticModule(CMMNSemanticModule.CMMN_URI) == null) {
			conf.addSemanticModule(new CMMNSemanticModule());
		}
		kb.addProcessFromXml(resource);

	}
}
