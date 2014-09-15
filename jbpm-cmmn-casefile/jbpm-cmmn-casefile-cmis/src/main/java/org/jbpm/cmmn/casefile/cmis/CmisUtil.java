package org.jbpm.cmmn.casefile.cmis;

public class CmisUtil {
	public static RuntimeException convertException(Exception e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}
}
