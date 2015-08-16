package org.jbpm.cmmn.test.container;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.core.process.core.datatype.impl.type.StringDataType;
import org.jbpm.bpmn2.xml.XmlBPMNProcessDumper;
import org.jbpm.cmmn.common.WorkItemParameters;
import org.jbpm.cmmn.instance.CaseInstance;
import org.jbpm.cmmn.instance.impl.util.PlanItemInstanceContainerUtil;
import org.jbpm.cmmn.test.AbstractConstructionTestCase;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.ruleflow.instance.RuleFlowProcessInstance;
import org.jbpm.workflow.core.node.Join;
import org.jbpm.workflow.instance.NodeInstanceContainer;
import org.jbpm.workflow.instance.node.CompositeNodeInstance;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.NodeInstance;
import org.kie.api.task.model.TaskSummary;

import test.cmmn.ConstructionCase;
import test.cmmn.House;
import test.cmmn.HousePlan;

public class CompletionTest extends AbstractConstructionTestCase {
	{
		super.isJpa=true;
	}
	public CompletionTest() {
	}
	@Test
	public void testVariablesInCompositeNode() throws Exception {

		RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("org.jbpm.HelloWorld");

		factory.name("HelloWorldProcess")
				.version("1.0")
				.packageName("org.jbpm")
				.variable("OuterVar", new StringDataType())
				.startNode(1).name("Start").done()
				.humanTaskNode(2).name("ThehumanTask").done()
				.boundaryEventNode(3).name("TheEvent").attachedTo(2).eventType("Message", "TheEvent").eventType("TheEvent").cancelActivity(false).done()
				.compositeNode(4).name("SubProcess")
				.variable("InnerVar",new StringDataType())
				.startNode(41).name("InnerStart").done()
				.actionNode(42).name("Action")
				.action("java", "System.out.println(\"Hello World\");").done()
				.eventNode(43).name("InnerEvent").eventType("InnerEvent").done()
				.endNode(44).name("InnerEnd").done()
				.connection(41, 42)
				.connection(42, 43)
				.connection(43, 44)
				.done()
				.joinNode(5).name("Join").type(Join.TYPE_OR).done()
				.endNode(6).name("End").done()
				.connection(1, 2)
				.connection(3, 4)
				.connection(4, 5)
				.connection(2,5)
				.connection(5, 6);

		RuleFlowProcess process = factory.validate().getProcess();
		String bpmn = XmlBPMNProcessDumper.INSTANCE.dump(process);
//		System.out.println(bpmn);
		createRuntimeManager("org/jbpm/Test.bpmn");
		KieSession ksession = getRuntimeEngine().getKieSession();
		RuleFlowProcessInstance pi = (RuleFlowProcessInstance) ksession.startProcess("org.jbpm.HelloWorld");
		ksession.signalEvent("Message-_jbpm-unique-1-TheEvent", 1,pi.getId());
		ksession.signalEvent("Message-_jbpm-unique-1-TheEvent", 1, pi.getId());
		ksession.signalEvent("Message-_jbpm-unique-1-TheEvent", 1, pi.getId());
		String padding="";
		getPersistence().start();
		Collection<NodeInstance> nodeInstances = (pi=(RuleFlowProcessInstance)ksession.getProcessInstance(pi.getId())).getNodeInstances();
		for (NodeInstance nodeInstance : nodeInstances) {
			if(nodeInstance instanceof CompositeNodeInstance){
				nodeInstance.setVariable("InnerVar", "InnerVar" + nodeInstance.getId());
			}
		}
		System.out.println(pi.getVariable("InnerVar"));
		printNodeInstances(padding, nodeInstances);
		getPersistence().commit();
	}
	private void printNodeInstances(String padding, Collection<NodeInstance> nodeInstances) {
		for (NodeInstance nodeInstance : nodeInstances) {
			System.out.println(padding + nodeInstance.getId() +"["  + nodeInstance.getNode().getName() + "] = " + nodeInstance.getVariable("InnerVar"));
			if(nodeInstance instanceof NodeInstanceContainer){
				printNodeInstances(padding+"    " , ((NodeInstanceContainer) nodeInstance).getNodeInstances());
			}
		}
	}

	@Test
	public void testAfterOccurrenceOfMilestone() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		// *****WHEN

		triggerStartOfMilestone();
		// *****THEN

		assertNodeTriggered(caseInstance.getId(), "TheMilestonePlanItem");
		assertNodeTriggered(caseInstance.getId(), "TheTask");
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		assertFalse(PlanItemInstanceContainerUtil.canComplete( caseInstance));
		getPersistence().commit();
	}

	@Test
	public void testAfterCompletionOfTask() throws Exception {
		// *****GIVEN
		givenThatTheTestCaseIsStarted();
		triggerStartOfMilestone();
		List<TaskSummary> tasks = getRuntimeEngine().getTaskService().getTasksAssignedAsPotentialOwner("Builder", "en-UK");
		assertEquals(1, tasks.size());
		// *****WHEN
		getRuntimeEngine().getTaskService().start(tasks.get(0).getId(), "Builder");
		getRuntimeEngine().getTaskService().complete(tasks.get(0).getId(), "Builder", new HashMap<String, Object>());
		// *****THEN
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		assertTrue(PlanItemInstanceContainerUtil.canComplete(caseInstance));
		getPersistence().commit();
	}

	@Test
	public void testAfterStartOfCaseInstance() throws Exception {
		// *****GIVEN
		// *****WHEN
		givenThatTheTestCaseIsStarted();

		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		assertFalse(PlanItemInstanceContainerUtil.canComplete( caseInstance));
		getPersistence().commit();
		// *****THEN

	}

	protected void givenThatTheTestCaseIsStarted() {
		createRuntimeManager("test/container/CompletionTests.cmmn");
		Map<String, Object> params = new HashMap<String, Object>();
		getPersistence().start();

		ConstructionCase cc = new ConstructionCase("/cases/case1");
		housePlan = new HousePlan(cc);
		house = new House(cc);
		getPersistence().persist(cc);
		getPersistence().commit();
		params.put("housePlan", housePlan);
		params.put("house", house);
		params.put(WorkItemParameters.INITIATOR, "Spielman");
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().startProcess("CompletionTests", params);
		getPersistence().commit();
		assertProcessInstanceActive(caseInstance.getId(), getRuntimeEngine().getKieSession());
		assertNodeTriggered(caseInstance.getId(), "defaultSplit");
		getPersistence().start();
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "onTheUserEventOccurPartId");
		assertNodeActive(caseInstance.getId(), getRuntimeEngine().getKieSession(), "onTheMilestoneOccurPartId");
		getPersistence().commit();
	}

	private void triggerStartOfMilestone() throws Exception {
		getPersistence().start();
		caseInstance = (CaseInstance) getRuntimeEngine().getKieSession().getProcessInstance(caseInstance.getId());
		caseInstance.signalEvent("TheUserEvent", new Object());
		getPersistence().commit();
	}

}
