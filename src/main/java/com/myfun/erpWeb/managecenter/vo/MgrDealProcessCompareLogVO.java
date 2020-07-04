package com.myfun.erpWeb.managecenter.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2018-12-11 18:23
 */
public class MgrDealProcessCompareLogVO {
	@ApiModelProperty("返回值和以前一样，无具体vo，是从记录里反序列化生成的，，具体联系erp负责人")
	private String newVal;
	@ApiModelProperty("")
	private String oldVal;

	public String getNewVal() {
		return newVal;
	}

	public void setNewVal(String newVal) {
		this.newVal = newVal;
	}

	public String getOldVal() {
		return oldVal;
	}

	public void setOldVal(String oldVal) {
		this.oldVal = oldVal;
	}
}
