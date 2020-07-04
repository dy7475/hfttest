package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "系统操作日志VO")
public class ErpSystemSettingLogsVo implements Serializable {

	@ApiModelProperty("修改前")
	private String oldVal;
	@ApiModelProperty("修改后")
	private String newVal;

	public String getOldVal() {
		return oldVal;
	}

	public void setOldVal(String oldVal) {
		this.oldVal = oldVal;
	}

	public String getNewVal() {
		return newVal;
	}

	public void setNewVal(String newVal) {
		this.newVal = newVal;
	}
}
