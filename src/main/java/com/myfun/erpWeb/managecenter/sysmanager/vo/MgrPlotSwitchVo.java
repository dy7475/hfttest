package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MgrPlotSwitchVo  {
	@ApiModelProperty(value = "策略参数开关，1=开启；0=关闭")
	private Integer plotswitch;

	public Integer getPlotswitch() {
		return plotswitch;
	}

	public void setPlotswitch(Integer plotswitch) {
		this.plotswitch = plotswitch;
	}
}
