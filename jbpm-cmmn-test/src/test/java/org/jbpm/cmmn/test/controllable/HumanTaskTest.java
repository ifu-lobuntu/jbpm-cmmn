package org.jbpm.cmmn.test.controllable;

public class HumanTaskTest extends AbstractControllableLifecycleTest {
	{
		super.isJpa = true;
	}

	public HumanTaskTest() {
	}

	public String getEventGeneratingTaskUser() {
		return "EventGeneratingBuilder";
	}




	public String[] getProcessFileNames() {
		return new String[] { "test/controllable/HumanTaskTests.cmmn" };
	}

	public String getNameOfProcessToStart() {
		return "PlanItemEventTests";
	}

	@Override
	protected String getCaseOwner() {
		return "Spielman";
	}
}
