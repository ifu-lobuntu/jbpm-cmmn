package org.jbpm.cmmn.test;

import org.jbpm.cmmn.instance.CaseInstance;

import test.cmmn.House;
import test.cmmn.HousePlan;

public class AbstractConstructionTestCase extends AbstractCmmnCaseTestCase {
	protected HousePlan housePlan;
	protected House house;
	protected CaseInstance caseInstance;

	public AbstractConstructionTestCase() {
		super("org.jbpm.persistence.jpa");
	}


}
