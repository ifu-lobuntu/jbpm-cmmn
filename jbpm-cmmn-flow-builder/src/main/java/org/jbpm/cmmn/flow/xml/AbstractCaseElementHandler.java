package org.jbpm.cmmn.flow.xml;

import java.util.HashSet;

import org.drools.core.xml.BaseAbstractHandler;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.core.CaseParameter;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.core.PlanItem;
import org.jbpm.cmmn.flow.core.PlanItemDefinition;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.core.impl.Stage;
import org.jbpm.cmmn.flow.core.planitem.PlanItemInfoImpl;
import org.jbpm.cmmn.flow.core.planitem.SentryImpl;
import org.jbpm.cmmn.flow.core.planning.DiscretionaryItemImpl;
import org.jbpm.cmmn.flow.core.planning.PlanningTableImpl;
import org.jbpm.process.core.context.variable.Variable;

public abstract class AbstractCaseElementHandler extends BaseAbstractHandler implements Handler {

	public AbstractCaseElementHandler() {
		this.validParents = new HashSet<Class<?>>();
		this.validParents.add(CaseImpl.class);
		super.validParents.add(Stage.class);

		this.validPeers = new HashSet<Class<?>>();
		this.validPeers.add(null);
		this.validPeers.add(SentryImpl.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(Variable.class);
		this.validPeers.add(CaseRole.class);
		this.validPeers.add(PlanItemDefinition.class);
		this.validPeers.add(CaseParameter.class);
		this.validPeers.add(PlanItemInfoImpl.class);
		this.validPeers.add(PlanItem.class);
		this.validPeers.add(DiscretionaryItemImpl.class);
		this.validPeers.add(PlanningTableImpl.class);
	}

}
