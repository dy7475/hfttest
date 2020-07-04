package com.myfun.erpWeb.houseBidding;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqHouseBiddPageParam extends AbstractEncryParam {
	/** 楼盘id **/
	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;

	/** 楼盘名称 **/
	@ApiModelProperty(value = "楼盘名称")
	private String buildName;

	/** 出租还是出售 **/
	@ApiModelProperty(value = "出售=1 出租=2")
	private Integer saleLease;
	/** 排序 **/
	@ApiModelProperty(value = "排序方式")
	private String orderby;

	@ApiModelProperty(hidden = true)
	private Integer archiveId;
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Integer getSaleLease() {
		return saleLease;
	}

	public void setSaleLease(Integer saleLease) {
		this.saleLease = saleLease;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
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
}
