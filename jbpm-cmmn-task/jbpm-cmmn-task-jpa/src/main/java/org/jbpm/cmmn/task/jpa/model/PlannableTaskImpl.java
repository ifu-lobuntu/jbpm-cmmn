package org.jbpm.cmmn.task.jpa.model;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.jbpm.cmmn.task.internal.model.InternalPlannableTask;
import org.jbpm.services.task.impl.model.TaskImpl;

@Entity(name = "PlannableTaskImpl")
@DiscriminatorValue("PlannableTask")
public class PlannableTaskImpl extends TaskImpl implements InternalPlannableTask {

	private static final long serialVersionUID = 11123315412L;
	@Id()
	Long id;
	@Column(name = "discretionary_item_id")
	private String discretionaryItemId;
	@Basic
	private String planItemName;
	@Transient
	Map<String, Object> parameterOverrides;

	public PlannableTaskImpl() {

	}

	public String getDiscretionaryItemId() {
		return discretionaryItemId;
	}

	@Override
	public void setDiscretionaryItemId(String tableItemId) {
		this.discretionaryItemId = tableItemId;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
		if (discretionaryItemId == null) {
			out.writeBoolean(false);
		} else {
			out.writeBoolean(true);
			out.writeUTF(discretionaryItemId);
		}
		if (planItemName == null) {
			out.writeBoolean(false);
		} else {
			out.writeBoolean(true);
			out.writeUTF(discretionaryItemId);
		}
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		super.readExternal(in);
		if (in.readBoolean()) {
			discretionaryItemId = in.readUTF();
		}
		if (in.readBoolean()) {
			planItemName = in.readUTF();
		}
	}

	@Override
	public String getPlanItemName() {
		return planItemName;
	}

	@Override
	public void setPlanItemName(String planItemName) {
		this.planItemName = planItemName;
	}

	@Override
	public Map<String, Object> getParameterOverrides() {
		if (parameterOverrides == null) {
			parameterOverrides = new HashMap<String, Object>();
		}
		return parameterOverrides;
	}

}
