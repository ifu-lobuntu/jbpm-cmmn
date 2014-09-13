package org.jbpm.cmmn.flow.builder;

import org.drools.compiler.lang.descr.ProcessDescr;
import org.jbpm.cmmn.flow.core.planitem.SentryImpl;
import org.jbpm.process.builder.ProcessBuildContext;
import org.jbpm.process.builder.ProcessNodeBuilder;
import org.kie.api.definition.process.Node;
import org.kie.api.definition.process.Process;

public class SentryBuilder implements ProcessNodeBuilder {

	@Override
	public void build(Process process, ProcessDescr processDescr, ProcessBuildContext context, Node node) {
		SentryImpl sentry = (SentryImpl) node;
		sentry.setCondition(PlanItemBuilder.build(context, node, sentry.getCondition()));
	}

}
