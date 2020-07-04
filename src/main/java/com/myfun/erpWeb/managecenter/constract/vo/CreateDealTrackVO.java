package com.myfun.erpWeb.managecenter.constract.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CreateDealTrackVO {

	@ApiModelProperty(value = "跟进ids，多个以','拼接")
	private String trackIds;

	public String getTrackIds() {
		return trackIds;
	}

	public void setTrackIds(String trackIds) {
		this.trackIds = trackIds;
	}
}
