package com.myfun.erpWeb.houseBidding.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BuildHouseCountParam extends AbstractEncryParam {
	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}
}
