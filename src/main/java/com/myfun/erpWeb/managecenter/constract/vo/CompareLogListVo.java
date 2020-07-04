package com.myfun.erpWeb.managecenter.constract.vo;

import com.google.gson.JsonObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class CompareLogListVo {
	@ApiModelProperty(value = "旧的信息")
	private JsonObject oldVal;
	@ApiModelProperty(value = "新的信息")
	private JsonObject newVal;

	public JsonObject getOldVal() {
		return oldVal;
	}

	public void setOldVal(JsonObject oldVal) {
		this.oldVal = oldVal;
	}

	public JsonObject getNewVal() {
		return newVal;
	}

	public void setNewVal(JsonObject newVal) {
		this.newVal = newVal;
	}
}
