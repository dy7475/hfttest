package com.myfun.erpWeb.homepage.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class WebAchieveStatisticsSummaryRankParam implements EncryParamIfc {

	@ApiModelProperty(value = "管理范围，1=公司，非必传")
	private  Integer rangeType;
	
	@ApiModelProperty(value = "范围id（如rangeType为1,则rangeId为对应的compId,多个Id,用逗号隔开,网站使用，不需要传）", hidden = true)
	private  String rangeIds;

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	public String getRangeIds() {
		return rangeIds;
	}

	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}
}