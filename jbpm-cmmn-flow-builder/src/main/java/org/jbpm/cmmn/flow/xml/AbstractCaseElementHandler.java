package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.Case;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.definition.PlanItemDefinition;
import org.jbpm.cmmn.flow.definition.Stage;
import org.jbpm.cmmn.flow.planitem.PlanItem;
import org.jbpm.cmmn.flow.planitem.Sentry;
import org.jbpm.cmmn.flow.planning.DiscretionaryItem;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.process.core.context.variable.Variable;

import java.util.HashSet;

public abstract class AbstractCaseElementHandler extends BaseAbstractHandler implements Handler {

	public AbstractCaseElementHandler() {
		this.validParents = new HashSet<Class<?>>();
		this.validParents.add(Case.class);
		super.validParents.add(Stage.class);

		this.validPeers = new HashSet<Class<?>>();
		this.validPeers.add(null);
		this.validPeers.add(Sentry.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(Variable.class);
		this.validPeers.add(CaseRole.class);
		this.validPeers.add(PlanItemDefinition.class);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(DiscretionaryItem.class);
		this.validPeers.add(PlanningTable.class);
	}

}
