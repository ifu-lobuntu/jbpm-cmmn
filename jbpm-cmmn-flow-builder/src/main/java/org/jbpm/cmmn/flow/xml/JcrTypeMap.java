package org.jbpm.cmmn.flow.xml;

public class JcrTypeMap implements TypeMap {

	@Override
	public String getType(String sourceType) {
		return "javax.jcr.Node";
	}
}
