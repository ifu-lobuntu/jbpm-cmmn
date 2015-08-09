package org.jbpm.cmmn.test;

import org.jbpm.cmmn.instance.CaseInstance;

import test.cmmn.ConstructionCase;
import test.cmmn.House;
import test.cmmn.HousePlan;
import test.cmmn.RoofPlan;
import test.cmmn.RoomPlan;
import test.cmmn.Wall;
import test.cmmn.WallPlan;

public class AbstractConstructionTestCase extends AbstractCmmnCaseTestCase {
	protected HousePlan housePlan;
	protected House house;
	protected CaseInstance caseInstance;

	public AbstractConstructionTestCase() {
		super(true, true, "org.jbpm.persistence.jpa");
	}

	@Override
	protected Class<?>[] getClasses() {
		return new Class<?>[] { ConstructionCase.class, HousePlan.class, House.class, Wall.class, WallPlan.class, RoofPlan.class,
				RoomPlan.class };
	}

}
