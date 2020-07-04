package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class DeleteUsersParam implements EncryParamIfc {
	
	@ApiModelProperty(value = "crm调用删除的时候必填,其他不填")
	private Integer cityId;
	@ApiModelProperty(value = "crm调用删除的时候必填,其他不填")
	private Integer compId;
	@ApiModelProperty(value = "待注销的用户ID，都必填")
	private Integer userId;
	@ApiModelProperty(value = "当前登录人")
	private Integer selfUserId;
	
	// 以下是查询后设置的
	@ApiModelProperty(hidden = true)
	private Integer selfProvinceId;
	@ApiModelProperty(hidden = true)
	private Integer compType = 1;
	@ApiModelProperty(hidden = true)
	private Integer isCrmDelete;// 是否是crm调用的（crm调用时，如果不是新营销版，则把数据都移交给总经理）
	@ApiModelProperty(hidden = true)
	private ErpFunUsers selfUser;
	@ApiModelProperty(hidden = true)
	private boolean meiLianFlag; //是否是美联

	@ApiModelProperty(value = "跨城下自己的cityId")
	private Integer selfCityId;
	@ApiModelProperty(value = "跨城下自己的compId")
	private Integer selfCompId;

	private Integer organizationId;
	private String organizationName;
	private String organizationPath;
	private String selfUserName;
	// 默认不切换
	private boolean isSwitchCompLogin = false;

	public boolean isSwitchCompLogin() {
		return isSwitchCompLogin;
	}

	public void setSwitchCompLogin(boolean switchCompLogin) {
		isSwitchCompLogin = switchCompLogin;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationPath() {
		return organizationPath;
	}

	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	public String getSelfUserName() {
		return selfUserName;
	}

	public void setSelfUserName(String selfUserName) {
		this.selfUserName = selfUserName;
	}

	public Integer getSelfUserId() {
		return selfUserId;
	}

	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}

	public Integer getSelfCompId() {
		return selfCompId;
	}

	public void setSelfCompId(Integer selfCompId) {
		this.selfCompId = selfCompId;
	}

	public Integer getSelfCityId() {
		return selfCityId;
	}

	public void setSelfCityId(Integer selfCityId) {
		this.selfCityId = selfCityId;
	}

	public Integer getSelfProvinceId() {
		return selfProvinceId;
	}

	public void setSelfProvinceId(Integer selfProvinceId) {
		this.selfProvinceId = selfProvinceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getCompType() {
		return compType;
	}

	public void setCompType(Integer compType) {
		this.compType = compType;
	}

	public Integer getIsCrmDelete() {
		return isCrmDelete;
	}

	public void setIsCrmDelete(Integer isCrmDelete) {
		this.isCrmDelete = isCrmDelete;
	}

	public ErpFunUsers getSelfUser() {
		return selfUser;
	}

	public void setSelfUser(ErpFunUsers selfUser) {
		this.selfUser = selfUser;
	}

	public boolean isMeiLianFlag() {
		return meiLianFlag;
	}

	public void setMeiLianFlag(boolean meiLianFlag) {
		this.meiLianFlag = meiLianFlag;
	}
	
}
