package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.core.CMMNElement;
import org.jbpm.cmmn.flow.core.impl.CaseImpl;
import org.jbpm.cmmn.flow.planitem.impl.PlanItemImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class IdGenerator {
	private static Logger logger = LoggerFactory.getLogger(IdGenerator.class);
	static ThreadLocal<Set<Long>> ids = new ThreadLocal<Set<Long>>();

	@SuppressWarnings("unchecked")
	public static long next(ExtensibleXmlParser p) {
		Long object = (Long) p.getMetaData().get("HighestId");
		if (object == null) {
			object = 20L;
		}
		object++;
		p.getMetaData().put("HighestId", object);
		return object;

	}
	public static long getIdAsUniqueAsUuid(ExtensibleXmlParser p, CMMNElement e) {
		String elementId = e.getElementId();
		return getIdAsUniqueAsId(p, elementId);
	}

	protected static long getIdAsUniqueAsId(ExtensibleXmlParser p, String elementId) {
		CaseImpl c = (CaseImpl) p.getParent(CaseImpl.class);
		char[] charArray = (c.getCaseKey() + elementId).toCharArray();
		long result = 1;
		int atSignIndex = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '@') {
				atSignIndex = i;
			}
			result = (result * 31) + charArray[i] - i;
		}
		if (charArray.length > atSignIndex + 10) {
			// THis is where the most variation takes place in the emf id
			// Introduce some variation in the calculation
			for (int i = atSignIndex + 2; i < atSignIndex + 10; i++) {
				if (Character.isLowerCase(charArray[i])) {
					result = (result * 31) + Character.toUpperCase(charArray[i]) - i;
				} else {
					result = (result * 31) + Character.toLowerCase(charArray[i]) - i;
				}
			}
		}
		long abs = Math.abs(result);
		Set<Long> idSet = getIdSet();
		if (idSet.contains(abs)) {
			logger.info("duplicate found:" + elementId);
		}
		idSet.add(abs);
		return abs;
	}

    protected static Set<Long> getIdSet() {
        Set<Long> idSet=null;
		if(ids.get()==null){
		    ids.set( new HashSet<Long>());
		}
		idSet=ids.get();
        return idSet;
    }

	public static long getIdAsUniqueAsUuid(ExtensibleXmlParser parser, PlanItemImpl<?> planItem) {
		return getIdAsUniqueAsId(parser, planItem.getElementId());
	}

	public static void reset() {
		getIdSet().clear();
	}
	@Deprecated
    public static String toXmlId(String value) {
        if(value!=null && value.startsWith("#")){
            return value.substring(1);
        }
        return value;
    }
}
