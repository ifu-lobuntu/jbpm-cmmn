package org.jbpm.cmmn.flow.xml;

import java.util.HashMap;
import java.util.Map;

public class DefaultTypeMap implements TypeMap {
	Map<String, String> types = new HashMap<String, String>();

	@Override
	public String getType(String sourceType) {
		String[] split = sourceType.split("\\#");//TODO this is wrong!
		String result = split[split.length - 1];
		result=result.replace("/", ".").replace("::", ".");
		split=result.split("\\:");//This is right
		result=split[split.length-1];
		return result;
	}

	public void putType(String s, String t) {
		types.put(s, t);
	}

}
