package org.jbpm.cmmn.test.casefileitem;

import org.jbpm.cmmn.casefile.jpa.JpaCaseFilePersistence;
import org.junit.Test;

import test.cmmn.ConstructionCase;
import test.cmmn.House;
import test.cmmn.HousePlan;
import test.cmmn.RoofPlan;
import test.cmmn.Wall;
import test.cmmn.WallPlan;

public class JpaPersistentSubscriptionEventTest extends CaseFileItemEventTest {
	{
		super.isJpa = true;
	}

	@Test
	public void testModel() throws Exception {
		createRuntimeManager();
		JpaCaseFilePersistence p = getPersistence();
		p.start();
		ConstructionCase constructionCase = new ConstructionCase("/cases/case1");
		constructionCase.setName("MyConstructionCase");
		this.housePlan = new HousePlan(constructionCase);
		this.house = new House(constructionCase);
		house.setDescription("MyHouse");
		new WallPlan(housePlan);
		new WallPlan(housePlan);
		new Wall(house);
		new Wall(house);
		new Wall(house);
		new RoofPlan(housePlan);
		house.setRoofPlan(housePlan.getRoofPlan());
		p.persist(constructionCase);
		p.commitAndSendCaseFileItemEvents();
		p.start();
		constructionCase = p.find(ConstructionCase.class, constructionCase.getId());
		assertEquals("MyConstructionCase", constructionCase.getName());
		assertEquals("MyHouse", constructionCase.getHouse().getDescription());
		assertNotNull(constructionCase.getHousePlan());
		assertNotNull(constructionCase.getHousePlan().getRoofPlan());
		assertNotNull(constructionCase.getHouse().getRoofPlan());
		assertSame(constructionCase.getHousePlan().getRoofPlan(), constructionCase.getHouse().getRoofPlan());
		assertEquals(3, constructionCase.getHouse().getWalls().size());
		assertEquals(2, constructionCase.getHousePlan().getWallPlans().size());
		p.commitAndSendCaseFileItemEvents();
	}
}
