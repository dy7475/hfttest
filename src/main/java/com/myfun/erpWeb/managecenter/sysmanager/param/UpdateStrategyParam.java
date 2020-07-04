package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateStrategyParam implements EncryParamIfc {
	@ApiModelProperty(value = "参数json 格式：{\"paramColl\":{\"ADD_INNERAREA\":\"0\",\"ALLOW_CITY_COOPERATE\":\"1\"}}")
	private String paramColl;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	@ApiModelProperty(value = "组织机构ID" ,hidden = true)
	private Integer cityId;
	@ApiModelProperty(value = "操作人useId" ,hidden = true)
	private Integer userId;

	@ApiModelProperty("组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门, 没有分开配置时传0, 其余的时候选什么传什么")
	private Integer organizationBussinessType;

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public String getParamColl() {
		return paramColl;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public void setParamColl(String paramColl) {
		this.paramColl = paramColl;
	}

	public Integer getOrganizationBussinessType() {
		return organizationBussinessType;
	}

	public void setOrganizationBussinessType(Integer organizationBussinessType) {
		this.organizationBussinessType = organizationBussinessType;
	}
}

