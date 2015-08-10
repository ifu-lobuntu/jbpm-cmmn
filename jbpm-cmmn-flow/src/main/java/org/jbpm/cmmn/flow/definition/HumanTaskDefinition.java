package org.jbpm.cmmn.flow.definition;

import org.drools.core.process.core.Work;
import org.jbpm.cmmn.flow.core.CaseRole;
import org.jbpm.cmmn.flow.planning.PlanningTableContainer;

public interface HumanTaskDefinition extends TaskDefinition, PlanningTableContainer {
    Work getWork();
    CaseRole getPerformer();
}
