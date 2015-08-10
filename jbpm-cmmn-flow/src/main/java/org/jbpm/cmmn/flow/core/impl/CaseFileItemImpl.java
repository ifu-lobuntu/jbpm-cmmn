package org.jbpm.cmmn.flow.core.impl;

import org.jbpm.cmmn.flow.core.CaseFileItem;
import org.jbpm.cmmn.flow.core.CaseFileItemDefinition;
import org.jbpm.process.core.context.variable.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseFileItemImpl extends Variable implements CaseFileItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8248796967737773161L;
	private String id;
	private String definitionRef;
	private CaseFileItemDefinition definition;
	private boolean isCollection;
	private List<CaseFileItem> children = new ArrayList<CaseFileItem>();
	private Map<String, CaseFileItem> targets = new HashMap<String, CaseFileItem>();
	private boolean isUnique = true;
	private boolean isOrdered = false;

	@Override
	public boolean isUnique() {
		return isUnique;
	}

	@Override
	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

	@Override
	public boolean isOrdered() {
		return isOrdered;
	}

	@Override
	public void setOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}

	@Override
	public String getElementId() {
		return id;
	}

	@Override
	public List<CaseFileItem> getChildren() {
		return children;
	}

	@Override
	public Map<String, CaseFileItem> getTargets() {
		return targets;
	}

	@Override
	public void putTarget(String id, CaseFileItem t) {
		targets.put(id, t);
	}

	@Override
	public void addChild(CaseFileItem c) {
		children.add(c);
	}

	@Override
	public void setElementId(String id) {
		this.id = id;
	}

	@Override
	public void setDefinitionRef(String value) {
		this.definitionRef = value;
	}

	@Override
	public String getDefinitionRef() {
		return definitionRef;
	}

	@Override
	public CaseFileItemDefinition getDefinition() {
		return definition;
	}

	@Override
	public void setDefinition(CaseFileItemDefinition definition) {
		this.definition = definition;
	}

	@Override
	public boolean isCollection() {
		return isCollection;
	}

	@Override
	public void setCollection(boolean isCollection) {
		this.isCollection = isCollection;
	}

}
