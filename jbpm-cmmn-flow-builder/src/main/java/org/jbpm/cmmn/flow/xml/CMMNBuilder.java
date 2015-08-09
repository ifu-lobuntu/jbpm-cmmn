package org.jbpm.cmmn.flow.xml;

import org.drools.compiler.builder.impl.KnowledgeBuilderConfigurationImpl;
import org.drools.compiler.builder.impl.KnowledgeBuilderImpl;
import org.jbpm.cmmn.flow.builder.PlanItemBuilder;
import org.jbpm.cmmn.flow.builder.SentryBuilder;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinitionType;
import org.jbpm.cmmn.flow.core.event.CaseFileItemStartTrigger;
import org.jbpm.cmmn.flow.core.event.PlanItemStartTrigger;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.DefaultJoin;
import org.jbpm.cmmn.flow.core.impl.DefaultSplit;
import org.jbpm.cmmn.flow.core.planitem.*;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.cmmn.instance.factory.DelegatingNodeInstanceFactory;
import org.jbpm.cmmn.instance.impl.*;
import org.jbpm.cmmn.marshalling.CaseInstanceMarshaller;
import org.jbpm.marshalling.impl.ProcessMarshallerRegistry;
import org.jbpm.process.builder.ProcessNodeBuilderRegistry;
import org.jbpm.process.instance.ProcessInstanceFactoryRegistry;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.workflow.instance.impl.NodeInstanceFactoryRegistry;
import org.jbpm.workflow.instance.impl.factory.CreateNewNodeFactory;
import org.jbpm.workflow.instance.impl.factory.ReuseNodeFactory;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceConfiguration;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
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
		ProcessNodeBuilderRegistry.INSTANCE.register(UserEventPlanItem.class, new PlanItemBuilder());
		ProcessNodeBuilderRegistry.INSTANCE.register(TimerEventPlanItem.class, new PlanItemBuilder());
		ProcessNodeBuilderRegistry.INSTANCE.register(StagePlanItem.class, new PlanItemBuilder());
		ProcessNodeBuilderRegistry.INSTANCE.register(CaseTaskPlanItem.class, new PlanItemBuilder());
		ProcessNodeBuilderRegistry.INSTANCE.register(MilestonePlanItem.class, new PlanItemBuilder());
		ProcessNodeBuilderRegistry.INSTANCE.register(HumanTaskPlanItem.class, new PlanItemBuilder());
		ProcessNodeBuilderRegistry.INSTANCE.register(SentryImpl.class, new SentryBuilder());
		ProcessInstanceFactoryRegistry.INSTANCE.register(CaseImpl.class, new CaseInstanceFactory());
		CaseInstanceMarshaller m = new CaseInstanceMarshaller();
		ProcessMarshallerRegistry.INSTANCE.register(RuleFlowProcess.RULEFLOW_TYPE, m);
		NodeInstanceFactoryRegistry nodeInstanceFactoryRegistry = NodeInstanceFactoryRegistry.getInstance(null);
		nodeInstanceFactoryRegistry.register(DefaultJoin.class, new ReuseNodeFactory(DefaultJoinInstance.class));
		nodeInstanceFactoryRegistry.register(SentryImpl.class, new ReuseNodeFactory(SentryInstance.class));
		nodeInstanceFactoryRegistry
				.register(PlanItemInstanceFactoryNode.class, new ReuseNodeFactory(PlanItemInstanceFactoryNodeInstance.class));
		nodeInstanceFactoryRegistry.register(AbstractOnPart.class, new ReuseNodeFactory(OnPartInstanceImpl.class));
		nodeInstanceFactoryRegistry.register(CaseFileItemOnPart.class, new ReuseNodeFactory(OnPartInstanceImpl.class));
		nodeInstanceFactoryRegistry.register(CaseFileItemStartTrigger.class, new ReuseNodeFactory(OnPartInstanceImpl.class));
		nodeInstanceFactoryRegistry.register(PlanItemStartTrigger.class, new ReuseNodeFactory(OnPartInstanceImpl.class));
		nodeInstanceFactoryRegistry.register(PlanItemOnPart.class, new ReuseNodeFactory(OnPartInstanceImpl.class));
		nodeInstanceFactoryRegistry.register(StagePlanItem.class, new DelegatingNodeInstanceFactory());
		nodeInstanceFactoryRegistry.register(DefaultSplit.class, new CreateNewNodeFactory(DefaultSplitInstance.class));
		nodeInstanceFactoryRegistry.register(HumanTaskPlanItem.class, new DelegatingNodeInstanceFactory());
		nodeInstanceFactoryRegistry.register(CaseTaskPlanItem.class, new DelegatingNodeInstanceFactory());
		nodeInstanceFactoryRegistry.register(DiscretionaryItemImpl.class, new DelegatingNodeInstanceFactory());
		nodeInstanceFactoryRegistry.register(UserEventPlanItem.class, new DelegatingNodeInstanceFactory());
		nodeInstanceFactoryRegistry.register(TimerEventPlanItem.class, new DelegatingNodeInstanceFactory());
		nodeInstanceFactoryRegistry.register(MilestonePlanItem.class, new DelegatingNodeInstanceFactory());
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
