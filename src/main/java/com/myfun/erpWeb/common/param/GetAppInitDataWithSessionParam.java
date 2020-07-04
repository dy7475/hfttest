package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetAppInitDataWithSessionParam implements EncryParamIfc {

	@ApiModelProperty(value = "shareId")
	private Integer shareId;
	@ApiModelProperty(value = "公司编号用,隔开")
	private String compNos;
	@ApiModelProperty(value = "更新时间")
	private String updateDelcompinfoTime;
	@ApiModelProperty(value = "门店Id")
	private Integer deptId;
	@ApiModelProperty(value = "公司Id")
	private Integer compId;
	private Integer delCompId;
	@ApiModelProperty(value = "大区Id")
	private Integer areaId;
	@ApiModelProperty(value = "城市Id")
	private Integer cityId;
	@ApiModelProperty(value = "更新时间")
	private String updateTime;

	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getShareId() {
		return shareId;
	}
	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}
	public String getCompNos() {
		return compNos;
	}
	public void setCompNos(String compNos) {
		this.compNos = compNos;
	}
	public String getUpdateDelcompinfoTime() {
		return updateDelcompinfoTime;
	}
	public void setUpdateDelcompinfoTime(String updateDelcompinfoTime) {
		this.updateDelcompinfoTime = updateDelcompinfoTime;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getDelCompId() {
		return delCompId;
	}
	public void setDelCompId(Integer delCompId) {
		this.delCompId = delCompId;
	}
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
