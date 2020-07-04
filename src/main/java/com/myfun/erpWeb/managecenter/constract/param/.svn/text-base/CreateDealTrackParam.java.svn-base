package com.myfun.erpWeb.managecenter.constract.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CreateDealTrackParam implements EncryParamIfc {

	@ApiModelProperty(value= "合同id", required = true)
	@NotNull
	private Integer dealId;
	
	@ApiModelProperty(value= "权证流程id")
	private Integer runstepId;
	
	@ApiModelProperty(value= "权证流程名称")
	private String runstepName;
	
	@ApiModelProperty(value= "被提醒人id")
	private String warmUser;
	
	@ApiModelProperty(value= "提醒内容")
	private String warmContent;
	
	@ApiModelProperty(value= "跟进内容")
	private String trackContent;
	
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
	
	public String getRunstepName() {
		return runstepName;
	}
	
	public void setRunstepName(String runstepName) {
		this.runstepName = runstepName;
	}
	
	public String getWarmUser() {
		return warmUser;
	}
	
	public void setWarmUser(String warmUser) {
		this.warmUser = warmUser;
	}
	
	public String getWarmContent() {
		return warmContent;
	}
	
	public void setWarmContent(String warmContent) {
		this.warmContent = warmContent;
	}
	
	public String getTrackContent() {
		return trackContent;
	}
	
	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent;
	}
}
