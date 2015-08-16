package org.jbpm.cmmn.flow.xml;

import org.drools.compiler.builder.impl.KnowledgeBuilderConfigurationImpl;
import org.drools.compiler.builder.impl.KnowledgeBuilderImpl;
import org.jbpm.cmmn.flow.builder.PlanItemBuilder;
import org.jbpm.cmmn.flow.builder.SentryBuilder;
import org.jbpm.cmmn.flow.common.impl.AbstractStandardEventNode;
import org.jbpm.cmmn.flow.common.impl.PlanItemInstanceFactoryNodeImpl;
import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinitionType;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.DefaultJoin;
import org.jbpm.cmmn.flow.core.impl.DefaultSplit;
import org.jbpm.cmmn.flow.definition.impl.CaseFileItemStartTriggerImpl;
import org.jbpm.cmmn.flow.definition.impl.PlanItemStartTriggerImpl;
import org.jbpm.cmmn.flow.planitem.impl.CaseFileItemOnPartImpl;
import org.jbpm.cmmn.flow.planitem.impl.PlanItemImpl;
import org.jbpm.cmmn.flow.planitem.impl.PlanItemOnPartImpl;
import org.jbpm.cmmn.flow.planitem.impl.SentryImpl;
import org.jbpm.cmmn.flow.planning.impl.DiscretionaryItemImpl;
import org.jbpm.cmmn.instance.factory.DelegatingNodeInstanceFactory;
import org.jbpm.cmmn.instance.impl.*;
import org.jbpm.cmmn.marshalling.CaseInstanceMarshaller;
import org.jbpm.marshalling.impl.ProcessMarshallerRegistry;
import org.jbpm.process.builder.ProcessNodeBuilderRegistry;
import org.jbpm.process.instance.ProcessInstanceFactoryRegistry;
import org.jbpm.workflow.instance.impl.NodeInstanceFactoryRegistry;
import org.jbpm.workflow.instance.impl.factory.CreateNewNodeFactory;
import org.jbpm.workflow.instance.impl.factory.ReuseNodeFactory;
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
		DefinitionsHandler.registerTypeMap(CaseFileItemDefinitionType.UML_CLASS, new DefaultTypeMap());
		DefinitionsHandler.registerTypeMap(CaseFileItemDefinitionType.CMIS_DOCUMENT, new JcrTypeMap());
		DefinitionsHandler.registerTypeMap(CaseFileItemDefinitionType.CMIS_FOLDER, new JcrTypeMap());
		DefinitionsHandler.registerTypeMap(CaseFileItemDefinitionType.CMIS_RELATIONSHIP, new JcrTypeMap());
		ProcessNodeBuilderRegistry.INSTANCE.register(PlanItemImpl.class, new PlanItemBuilder());
		ProcessNodeBuilderRegistry.INSTANCE.register(SentryImpl.class, new SentryBuilder());
		ProcessInstanceFactoryRegistry.INSTANCE.register(CaseImpl.class, new CaseInstanceFactory());
		CaseInstanceMarshaller m = new CaseInstanceMarshaller();
		ProcessMarshallerRegistry.INSTANCE.register(Case.CASE_TYPE, m);
		NodeInstanceFactoryRegistry nodeInstanceFactoryRegistry = NodeInstanceFactoryRegistry.getInstance(null);
		nodeInstanceFactoryRegistry.register(DefaultJoin.class, new ReuseNodeFactory(DefaultJoinInstance.class));
		nodeInstanceFactoryRegistry.register(SentryImpl.class, new ReuseNodeFactory(SentryInstance.class));
		nodeInstanceFactoryRegistry
				.register(PlanItemInstanceFactoryNodeImpl.class, new ReuseNodeFactory(PlanItemInstanceFactoryNodeInstance.class));
		nodeInstanceFactoryRegistry.register(AbstractStandardEventNode.class, new ReuseNodeFactory(StandardEventNodeInstance.class));
		nodeInstanceFactoryRegistry.register(CaseFileItemOnPartImpl.class, new ReuseNodeFactory(StandardEventNodeInstance.class));
		nodeInstanceFactoryRegistry.register(CaseFileItemStartTriggerImpl.class, new ReuseNodeFactory(StandardEventNodeInstance.class));
		nodeInstanceFactoryRegistry.register(PlanItemStartTriggerImpl.class, new ReuseNodeFactory(StandardEventNodeInstance.class));
		nodeInstanceFactoryRegistry.register(PlanItemOnPartImpl.class, new ReuseNodeFactory(StandardEventNodeInstance.class));
		nodeInstanceFactoryRegistry.register(PlanItemImpl.class, new DelegatingNodeInstanceFactory());
		nodeInstanceFactoryRegistry.register(DefaultSplit.class, new CreateNewNodeFactory(DefaultSplitInstance.class));
		nodeInstanceFactoryRegistry.register(DiscretionaryItemImpl.class, new DelegatingNodeInstanceFactory());
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
