package com.myfun.erpWeb.managecenter.transaction.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 宽列表的权证流程 
 */
@ApiModel
public class RuntimeStepVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "主键id")
	private Integer runstepId;
	
	@ApiModelProperty(value = "合同id")
	private Integer dealId;
	
	@ApiModelProperty(value = "步骤排序")
	private Integer stepSeq;
	
	@ApiModelProperty(value = "步骤名称")
	private String stepName;
	
	@ApiModelProperty(value = "指定执行人id")
	private Integer executor;
	
	@ApiModelProperty(value = "指定执行人姓名")
	private String executorName;
	
	@ApiModelProperty(value = "执行人类别")
	private Byte executorType;
	
	@ApiModelProperty(value = "执行状态 1:未处理 2:待处理 3:已处理 4:跳过")
	private Byte runstepStatus;
	
	@ApiModelProperty(value = "执行时间")
	private Date updateTime;
	
	@ApiModelProperty(value = "具体执行人id")
	private Integer updateUser;
	
	@ApiModelProperty(value = "具体执行人姓名")
	private String updateUsername;

	public Integer getRunstepId() {
		return runstepId;
	}

	public void setRunstepId(Integer runstepId) {
		this.runstepId = runstepId;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getStepSeq() {
		return stepSeq;
	}

	public void setStepSeq(Integer stepSeq) {
		this.stepSeq = stepSeq;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public Integer getExecutor() {
		return executor;
	}

	public void setExecutor(Integer executor) {
		this.executor = executor;
	}

	public String getExecutorName() {
		return executorName;
	}

	public void setExecutorName(String executorName) {
		this.executorName = executorName;
	}

	public Byte getExecutorType() {
		return executorType;
	}

	public void setExecutorType(Byte executorType) {
		this.executorType = executorType;
	}

	public Byte getRunstepStatus() {
		return runstepStatus;
	}

	public void setRunstepStatus(Byte runstepStatus) {
		this.runstepStatus = runstepStatus;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateUsername() {
		return updateUsername;
	}

	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername;
	}
}