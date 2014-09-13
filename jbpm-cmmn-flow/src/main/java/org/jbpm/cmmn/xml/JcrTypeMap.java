package org.jbpm.cmmn.xml;

public class JcrTypeMap implements TypeMap {

	@Override
	public String getType(String sourceType) {
		return "javax.jcr.Node";
	}
}
