package com.myfun.erpWeb.managecenter.buildData.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MgrUserViewRightParam implements EncryParamIfc {

	@ApiModelProperty(value = "楼盘ID")
	private Integer buildId;

	@ApiModelProperty(value = "商圈ID")
	private Integer sectionId;

	@ApiModelProperty(value = "被分配人ID")
	private Integer byUserId;

	@ApiModelProperty(value = "状态 已暂停0  进行中1 已过期2 ")
	private Byte status;

	@ApiModelProperty(value = "开始时间")
	private String startTime;

	@ApiModelProperty(value = "结束时间")
	private String endTime;

	@ApiModelProperty(value = "用户Id",hidden = true)
	private Integer userId;

	@ApiModelProperty(value = "门店Id",hidden = true)
	private Integer deptId;

	@ApiModelProperty("页码")
	private  Integer pageOffset = 1; // 1 第几页

	@ApiModelProperty("每页显示数量")
	private  Integer pageRows = 50; // 50 一页多少条




	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public Integer getByUserId() {
		return byUserId;
	}

	public void setByUserId(Integer byUserId) {
		this.byUserId = byUserId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Integer getPageRows() {
		return pageRows;
	}

	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
}
