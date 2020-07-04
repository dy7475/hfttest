package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class InsertRunTimeStepParam implements EncryParamIfc {

	@ApiModelProperty(value = "合同ID", required = true)
	private Integer dealId;
	@ApiModelProperty(value = "步骤模板Id", required = true)
	private Integer stepId;
	@ApiModelProperty(value = "新插入步骤的序号", required = true)
	private Integer stepSeq;
	@ApiModelProperty(value = "城市Id", hidden = true)
	private Integer cityId;
	@ApiModelProperty(value = "公司ID", hidden = true)
	private Integer compId;
	@ApiModelProperty(value = "门店ID", hidden = true)
	private Integer deptId;
	@ApiModelProperty(value = "员工ID", hidden = true)
	private Integer userId;
	@ApiModelProperty(value = "员工姓名带组织机构", hidden = true)
	private String currentUserName;
	@ApiModelProperty(value = "员工姓名", hidden = true)
	private String userName;
	@ApiModelProperty("时间限制类别1:成交后 2:前置流程完成后")
	private Byte timelimitType;
	@ApiModelProperty("时间限制（转换成小时）")
	private Integer timelimit;
	@ApiModelProperty("执行人类别1 指定执行人 2 指定角色名 3 流程总负责人 4 合同签约人")
	private Byte executorType;
	@ApiModelProperty("指定执行人")
	private Integer executor;
	@ApiModelProperty("指定执行人姓名")
	private String executorName;
	@ApiModelProperty("前置步骤ID")
	private Integer rpevstepId;
	@ApiModelProperty("前置步骤名称")
	private String rpevstepName;

	public String getRpevstepName() {
		return rpevstepName;
	}

	public void setRpevstepName(String rpevstepName) {
		this.rpevstepName = rpevstepName;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	public Integer getStepSeq() {
		return stepSeq;
	}

	public void setStepSeq(Integer stepSeq) {
		this.stepSeq = stepSeq;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Byte getTimelimitType() {
		return timelimitType;
	}

	public void setTimelimitType(Byte timelimitType) {
		this.timelimitType = timelimitType;
	}

	public Integer getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(Integer timelimit) {
		this.timelimit = timelimit;
	}

	public Byte getExecutorType() {
		return executorType;
	}

	public void setExecutorType(Byte executorType) {
		this.executorType = executorType;
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

	public Integer getRpevstepId() {
		return rpevstepId;
	}

	public void setRpevstepId(Integer rpevstepId) {
		this.rpevstepId = rpevstepId;
	}
}
