package com.myfun.erpWeb.managecenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2018-11-13 15:40
 */
public class MeiLianParaParam implements EncryParamIfc {
	@ApiModelProperty("检索关键字")
	private String para;
	@ApiModelProperty("楼盘Id")
	private Integer buildId;
	@ApiModelProperty("用户id")
	private Integer userId;
	@ApiModelProperty("组织Id")
	private Integer organizationId;
	@ApiModelProperty("用途")
	private String houseUseage;

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}
	
}
