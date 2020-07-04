package com.myfun.repository.erpdb.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunProfitDetailParam implements EncryParamIfc {

	protected Integer pageOffset; // 1 第几页
	protected Integer pageRows; // 50 一页多少条

	private Integer compId;
	private Integer areaId;
	private Integer cityId;
	private Integer regId;
	private Integer deptId;
	private Integer grId;
	private Integer userId;
	private Integer isExport = 0;
	private Integer dealStatus;
	private Integer timeType;
	private String timeMonth;

	private Integer dealId;
	private Byte performanceId;
	private String startTime;
	private String endTime;
	
	@ApiModelProperty(hidden = true)
	@DefaultValue(value = "false")
	private Boolean isNewOrganization;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	
	public Boolean getIsNewOrganization() {
		return isNewOrganization;
	}

	public void setIsNewOrganization(Boolean isNewOrganization) {
		this.isNewOrganization = isNewOrganization;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
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

	public Byte getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(Byte performanceId) {
		this.performanceId = performanceId;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIsExport() {
		return isExport;
	}

	public void setIsExport(Integer isExport) {
		this.isExport = isExport;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public String getTimeMonth() {
		return timeMonth;
	}

	public void setTimeMonth(String timeMonth) {
		this.timeMonth = timeMonth;
	}

	public boolean isNeedCount() {
		return getPageOffset() == 1;
	}

	public Integer getOffsetNow() {
		return (getPageOffset()-1)*getPageRows();
	}

	public Integer getPageOffset() {
		if(pageOffset == null || pageOffset <= 0){
			return Const.CURRENT_PAGE;
		}
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Integer getPageRows() {
		if(pageRows == null || pageRows <= 0){
			return Const.PAGE_NUMBER;
		}
		return pageRows;
	}

	public Integer getPageRows(Integer p) {
		if(pageRows == null || pageRows <= 0){
			return p;
		}
		return pageRows;
	}

	public void setPageRows(Integer p) {
		pageRows = p;
	}
}
