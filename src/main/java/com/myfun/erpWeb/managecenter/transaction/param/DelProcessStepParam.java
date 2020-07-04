package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DelProcessStepParam implements EncryParamIfc{
	@ApiModelProperty(value = "合同id")
	private Integer dealId;
	@ApiModelProperty(value = "实例表主键")
	private Integer runstepId;
	@ApiModelProperty(value = "步骤名")
	private String stepName;

	@ApiModelProperty(hidden = true)
	private String currUserName;
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private String userName;
	@ApiModelProperty(hidden = true)
	private Integer deptId;
	@ApiModelProperty(hidden = true)
	private Integer userId;

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getCurrUserName() {
		return currUserName;
	}

	public void setCurrUserName(String currUserName) {
		this.currUserName = currUserName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}



	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getRunstepId() {
		return runstepId;
	}

	public void setRunstepId(Integer runstepId) {
		this.runstepId = runstepId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
