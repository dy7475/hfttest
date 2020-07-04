package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class updateMgrParameterParam implements EncryParamIfc {
	@ApiModelProperty(value = "参数json 格式：{\"paramColl\":{\"ADD_INNERAREA\":\"0\",\"ALLOW_CITY_COOPERATE\":\"1\"}}")
	private String paramColl;
	@ApiModelProperty(value = "列：每人每天可看房源公盘本组织多少条，该字段就传层级ID，另外的paramValue传多少条")
	private Integer defId;

	@ApiModelProperty("组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门, 没有分开配置时传0, 其余的时候选什么传什么")
	private Integer organizationBussinessType;

	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private String compNo;
	@ApiModelProperty(hidden = true)
	private Integer compType;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty(hidden = true)
	private boolean isPersonalVersion;

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}

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

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	public Integer getCompType() {
		return compType;
	}

	public void setCompType(Integer compType) {
		this.compType = compType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean isPersonalVersion() {
		return isPersonalVersion;
	}

	public void setPersonalVersion(boolean personalVersion) {
		isPersonalVersion = personalVersion;
	}

	public String getParamColl() {
		return paramColl;
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
