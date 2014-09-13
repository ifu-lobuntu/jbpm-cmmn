package org.jbpm.cmmn.instance;

public abstract class CaseEvent {
	public abstract Enum<?> getTransition();

	public abstract Object getValue();
}
