package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OrganizationDataListParam implements EncryParamIfc {

	@ApiModelProperty("更新时间，如果传了此字段，那么匹配是否有更新的组织，如果有也只返回更新部分的数据，" +
			"如果没传此时间，那就返回所有的数据")
	private String updateTime;
	@ApiModelProperty("城市id")
	private Integer cityId;
	@ApiModelProperty("公司id")
	private Integer compId;
	
	
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
