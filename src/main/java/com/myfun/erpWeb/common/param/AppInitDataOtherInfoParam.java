package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppInitDataOtherInfoParam implements EncryParamIfc {
	@ApiModelProperty("更新时间")
	private String updateTime;
	@ApiModelProperty("城市ID")
	private Integer cityId;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
