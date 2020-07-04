package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BindHistoryVO implements Serializable{

	@ApiModelProperty(value = "绑定人")
	private String bindUserName;
	
	@ApiModelProperty(value = "绑定A号码时间")
	private String bindATime;
	
	@ApiModelProperty(value = "解绑时间")
	private String unbindTime;

	public String getBindUserName() {
		return bindUserName;
	}

	public void setBindUserName(String bindUserName) {
		this.bindUserName = bindUserName;
	}

	public String getBindATime() {
		return bindATime;
	}

	public void setBindATime(String bindATime) {
		this.bindATime = bindATime;
	}

	public String getUnbindTime() {
		return unbindTime;
	}

	public void setUnbindTime(String unbindTime) {
		this.unbindTime = unbindTime;
	}
	
	
}
