package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateMgrWarrantStepDataParam implements EncryParamIfc {
	
	@ApiModelProperty(value = "合同id")
	private Integer dealId;
	
	@ApiModelProperty(value = "权证内容（备注）")
	private String flowcontent;
	
	@ApiModelProperty(value = "提醒人id")
	private Integer reminderId;
	
	@ApiModelProperty(value = "提醒人姓名")
	private String reminderName;
	
	@ApiModelProperty(value = "实例表主键")
	private Integer runstepId;
	
	@ApiModelProperty(value = "步骤名")
	private String runstepName;
	
	@ApiModelProperty(value = "执行状态 1:未处理 2:待处理 3:已处理 4跳过")
	private Byte runstepStatus;
	
	@ApiModelProperty(value = "到期时间 ")
	private String timelimitdate;
	
	@ApiModelProperty(value = "执行时间")
	private String updateTime;
	
	@ApiModelProperty(value = "具体执行人")
	private Integer updateUser;
	
	@ApiModelProperty(value = "具体执行人姓名")
	private String updateUsername;
	
	@ApiModelProperty(value = "提醒内容")
	private String warmContent;
	
	@ApiModelProperty(value = "提醒任务标记")
	private Byte warmFlag;
	
	@ApiModelProperty(value = "提醒时间")
	private String warnTime;
	
	@ApiModelProperty(value = "提醒人类别 1 指定提醒人 2 指定提醒角色 3 流程总负责人 4 合同签约人")
	private Byte warnType;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getFlowcontent() {
		return flowcontent;
	}

	public void setFlowcontent(String flowcontent) {
		this.flowcontent = flowcontent;
	}

	public Integer getReminderId() {
		return reminderId;
	}

	public void setReminderId(Integer reminderId) {
		this.reminderId = reminderId;
	}

	public String getReminderName() {
		return reminderName;
	}

	public void setReminderName(String reminderName) {
		this.reminderName = reminderName;
	}

	public Integer getRunstepId() {
		return runstepId;
	}

	public void setRunstepId(Integer runstepId) {
		this.runstepId = runstepId;
	}

	public String getRunstepName() {
		return runstepName;
	}

	public void setRunstepName(String runstepName) {
		this.runstepName = runstepName;
	}

	public Byte getRunstepStatus() {
		return runstepStatus;
	}

	public void setRunstepStatus(Byte runstepStatus) {
		this.runstepStatus = runstepStatus;
	}

	public String getTimelimitdate() {
		return timelimitdate;
	}

	public void setTimelimitdate(String timelimitdate) {
		this.timelimitdate = timelimitdate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
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

	public String getWarmContent() {
		return warmContent;
	}

	public void setWarmContent(String warmContent) {
		this.warmContent = warmContent;
	}

	public Byte getWarmFlag() {
		return warmFlag;
	}

	public void setWarmFlag(Byte warmFlag) {
		this.warmFlag = warmFlag;
	}

	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	public Byte getWarnType() {
		return warnType;
	}

	public void setWarnType(Byte warnType) {
		this.warnType = warnType;
	}
	
}
