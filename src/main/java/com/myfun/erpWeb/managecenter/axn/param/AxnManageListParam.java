package com.myfun.erpWeb.managecenter.axn.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AxnManageListParam extends AbstractEncryParam {

	@ApiModelProperty(value = "绑定状态 1=已绑定 0=未绑定")
	private Integer bindFlag;
	
	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	
	@ApiModelProperty(value = "员工id")
	private Integer userId;
	
	@ApiModelProperty(value = "关键字")
	private String keys;
	
	@ApiModelProperty(value = "角色")
	private String userPosition;
	
	@ApiModelProperty(value = "是否是导出，导出就不页 1=是")
	private Byte isExport;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;

	public Integer getBindFlag() {
		return bindFlag;
	}

	public void setBindFlag(Integer bindFlag) {
		this.bindFlag = bindFlag;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public Byte getIsExport() {
		return isExport;
	}

	public void setIsExport(Byte isExport) {
		this.isExport = isExport;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	
}
