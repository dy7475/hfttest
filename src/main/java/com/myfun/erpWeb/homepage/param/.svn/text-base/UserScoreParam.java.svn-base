package com.myfun.erpWeb.homepage.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class UserScoreParam implements EncryParamIfc {
	@NotNull
	@ApiModelProperty(value = "管理范围，1=公司 2=大区 3=片区 4=门店 5=分组 6=个人")
	private Integer rangeType;
	@ApiModelProperty(value = "管理范围对应ID，逗号分隔")
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
