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

public class PlannableTaskSummaryImpl implements InternalPlannableTaskSummary {

	private static final long serialVersionUID = 11123315412L;
	private Long id;
	private InternalTaskSummary taskSummary;
	private String discretionaryItemId;
	private String planItemName;

	public PlannableTaskSummaryImpl() {
	}

	public PlannableTaskSummaryImpl(InternalTaskSummary task,
			String discretionaryItemId, String planItemName) {
		this.taskSummary=task;
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

	public Long getId() {
		return taskSummary.getId();
	}

	public Long getProcessInstanceId() {
		return taskSummary.getProcessInstanceId();
	}

	public String getName() {
		return taskSummary.getName();
	}

	public String getSubject() {
		return taskSummary.getSubject();
	}

	public String getDescription() {
		return taskSummary.getDescription();
	}

	public Status getStatus() {
		return taskSummary.getStatus();
	}

	public Integer getPriority() {
		return taskSummary.getPriority();
	}

	public Boolean isSkipable() {
		return taskSummary.isSkipable();
	}

	public User getActualOwner() {
		return taskSummary.getActualOwner();
	}

	public User getCreatedBy() {
		return taskSummary.getCreatedBy();
	}

	public Date getCreatedOn() {
		return taskSummary.getCreatedOn();
	}

	public Date getActivationTime() {
		return taskSummary.getActivationTime();
	}

	public Date getExpirationTime() {
		return taskSummary.getExpirationTime();
	}

	public String getProcessId() {
		return taskSummary.getProcessId();
	}

	public Integer getProcessSessionId() {
		return taskSummary.getProcessSessionId();
	}

	public List<String> getPotentialOwners() {
		return taskSummary.getPotentialOwners();
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(id);
		out.writeUTF(discretionaryItemId);
		out.writeUTF(planItemName);
		taskSummary.writeExternal(out);
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		id = in.readLong();
		discretionaryItemId = in.readUTF();
		planItemName = in.readUTF();
		taskSummary = new TaskSummaryImpl();
		taskSummary.readExternal(in);
	}

	public void setId(long id) {
		taskSummary.setId(id);
	}

	public void setProcessInstanceId(long processInstanceId) {
		taskSummary.setProcessInstanceId(processInstanceId);
	}

	public void setName(String name) {
		taskSummary.setName(name);
	}

	public void setSubject(String subject) {
		taskSummary.setSubject(subject);
	}

	public void setDescription(String description) {
		taskSummary.setDescription(description);
	}

	public void setStatus(Status status) {
		taskSummary.setStatus(status);
	}

	public void setPriority(int priority) {
		taskSummary.setPriority(priority);
	}

	public void setSkipable(boolean skipable) {
		taskSummary.setSkipable(skipable);
	}

	public void setActualOwner(User actualOwner) {
		taskSummary.setActualOwner(actualOwner);
	}

	public void setCreatedBy(User createdBy) {
		taskSummary.setCreatedBy(createdBy);
	}

	public void setCreatedOn(Date createdOn) {
		taskSummary.setCreatedOn(createdOn);
	}

	public void setActivationTime(Date activationTime) {
		taskSummary.setActivationTime(activationTime);
	}

	public void setExpirationTime(Date expirationTime) {
		taskSummary.setExpirationTime(expirationTime);
	}

	public void setProcessId(String processId) {
		taskSummary.setProcessId(processId);
	}

	public void setProcessSessionId(int processSessionId) {
		taskSummary.setProcessSessionId(processSessionId);
	}

	public SubTasksStrategy getSubTaskStrategy() {
		return taskSummary.getSubTaskStrategy();
	}

	public void setSubTaskStrategy(SubTasksStrategy subTaskStrategy) {
		taskSummary.setSubTaskStrategy(subTaskStrategy);
	}

	public Long getParentId() {
		return taskSummary.getParentId();
	}

	public void setParentId(long parentId) {
		taskSummary.setParentId(parentId);
	}

	public void setPotentialOwners(List<String> potentialOwners) {
		taskSummary.setPotentialOwners(potentialOwners);
	}

	@Override
	public Boolean isQuickTaskSummary() {
		return taskSummary.isQuickTaskSummary();
	}

	@Override
	public String getStatusId() {
		return taskSummary.getStatusId();
	}

	@Override
	public String getActualOwnerId() {
		return taskSummary.getActualOwnerId();
	}

	@Override
	public String getCreatedById() {
		return taskSummary.getCreatedById();
	}

	@Override
	public String getDeploymentId() {
		return taskSummary.getDeploymentId();
	}

}
