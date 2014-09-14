package org.jbpm.cmmn.task.jpa.query;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import java.util.List;

import org.jbpm.cmmn.task.internal.model.InternalPlannableTaskSummary;
import org.jbpm.cmmn.task.jpa.model.PlannableTaskImpl;
import org.jbpm.services.task.query.TaskSummaryImpl;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.User;
import org.kie.internal.task.api.model.InternalTaskSummary;
import org.kie.internal.task.api.model.SubTasksStrategy;

public class PlannableTaskSummaryImpl extends TaskSummaryImpl implements InternalPlannableTaskSummary {

	private static final long serialVersionUID = 11123315412L;
	private String discretionaryItemId;
	private String planItemName;

	public PlannableTaskSummaryImpl() {
	}

	public PlannableTaskSummaryImpl(long id, String name, String description, Status status, int priority, String actualOwner,
			String createdBy, Date createdOn, Date activationTime, Date expirationTime, String processId, long processInstanceId,
			long parentId, String deploymentId) {
		super(id, name, description, status, priority, actualOwner, createdBy, createdOn, activationTime, expirationTime, processId, processInstanceId,
				parentId, deploymentId);
	}
	public PlannableTaskSummaryImpl(long id, String name, String description, Status status, int priority, String actualOwner,
			String createdBy, Date createdOn, Date activationTime, Date expirationTime, String processId, long processInstanceId,
			long parentId, String deploymentId, String discretionaryItemId, String planItemName) {
		super(id, name, description, status, priority, actualOwner, createdBy, createdOn, activationTime, expirationTime, processId, processInstanceId,
				parentId, deploymentId);
		this.discretionaryItemId=discretionaryItemId;
		this.planItemName=planItemName;
	}

	public PlannableTaskSummaryImpl(long id, String name, String subject, String description, Status status, int priority, boolean skipable,
			User actualOwner, User createdBy, Date createdOn, Date activationTime, Date expirationTime, String processId, int processSessionId,
			long processInstanceId, String deploymentId, SubTasksStrategy subTaskStrategy, long parentId) {
		super(id, name, subject, description, status, priority, skipable, actualOwner, createdBy, createdOn, activationTime, expirationTime, processId,
				processSessionId, processInstanceId, deploymentId, subTaskStrategy, parentId);
	}
	

	public PlannableTaskSummaryImpl(InternalTaskSummary task,
			String discretionaryItemId, String planItemName) {
		this.discretionaryItemId=discretionaryItemId;
		this.planItemName=planItemName;
	}
	/**
	 * @deprecated introduce a "transformer" method
	 * @param task
	 */
	public PlannableTaskSummaryImpl(PlannableTaskImpl task) {
		this(new TaskSummaryImpl(task.getId(), task.getName(),
				task.getDescription(), task.getTaskData().getStatus(),
				task.getPriority(),
				(task.getTaskData().getActualOwner() != null) ? task
						.getTaskData().getActualOwner().getId() : "", (task
						.getTaskData().getCreatedBy() != null) ? task
						.getTaskData().getCreatedBy().getId() : "", task
						.getTaskData().getCreatedOn(), task.getTaskData()
						.getActivationTime(), task.getTaskData()
						.getExpirationTime(),
				task.getTaskData().getProcessId(), task.getTaskData()
						.getProcessInstanceId(), task.getTaskData()
						.getParentId(), task.getTaskData().getDeploymentId()),task.getDiscretionaryItemId(),
		task.getPlanItemName());
	}

	public String getDiscretionaryItemId() {
		return discretionaryItemId;
	}

	public void setDiscretionaryItemId(String tableItemId) {
		this.discretionaryItemId = tableItemId;
	}

	@Override
	public String getPlanItemName() {
		return planItemName;
	}

	@Override
	public void setPlanItemName(String name) {
		this.planItemName = name;
	}
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(discretionaryItemId);
		out.writeUTF(planItemName);
		super.writeExternal(out);
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		discretionaryItemId = in.readUTF();
		planItemName = in.readUTF();
		super.readExternal(in);
	}

}
