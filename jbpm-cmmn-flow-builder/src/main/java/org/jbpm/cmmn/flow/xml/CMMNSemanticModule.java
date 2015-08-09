package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.DefaultSemanticModule;
import org.jbpm.cmmn.flow.core.planitem.SentryImpl;

public class CMMNSemanticModule extends DefaultSemanticModule {
	public static final String CMMN_URI = "http://www.omg.org/spec/CMMN/20131201/MODEL";
	public CMMNSemanticModule(String uri) {
		super(uri);
		super.addHandler("case", new CaseHandler());
		super.addHandler("definitions", new DefinitionsHandler());
		super.addHandler("caseFileItem", new CaseFileItemHandler());
		super.addHandler("caseFileItemDefinition", new CaseFileItemDefinitionHandler());
		SentryHandler sentryHandler = new SentryHandler();
		super.addHandler("sentry", sentryHandler);
		super.addHandler("caseRoles", new RoleHandler());
		super.addHandler("input", new CaseParameterHandler());
		super.addHandler("output", new CaseParameterHandler());
		super.addHandler("inputs", new CaseParameterHandler());
		super.addHandler("outputs", new CaseParameterHandler());
		super.addHandler("planItem", new PlanItemHandler());
		super.addHandler("planItemDefinition", new PlanItemDefinitionHandler());
		super.addHandler("parameterMapping", new ParameterMappingHandler());
		super.addHandler("planItemOnPart", new PlanItemOnPartHandler());
		super.addHandler("planItemStartTrigger", new PlanItemOnPartHandler());
		super.addHandler("caseFileItemOnPart", new CaseFileItemOnPartHandler());
		super.addHandler("caseFileItemStartTrigger", new CaseFileItemOnPartHandler());
		super.addHandler("defaultControl", new PlanItemControlHandler());
		super.addHandler("itemControl", new PlanItemControlHandler());
		super.addHandler("planningTable", new PlanningTableHandler());
		super.addHandler("tableItem", new TableItemHandler());
		super.addHandler("applicabilityRule", new ApplicabilityRuleHandler());
		this.handlersByClass.put(SentryImpl.class, sentryHandler);
	}
	public CMMNSemanticModule() {
		this(CMMN_URI);
	}

}
