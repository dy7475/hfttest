package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunWage;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Title 薪资参数
 * @Author lcb
 * @Date 2018/1/24
 * @Param
 **/
public class ErpFunWageParam extends ErpFunWage implements EncryParamIfc {
	@ApiModelProperty("结算月")
	private String assessmentMonth;
	@ApiModelProperty("角色ID")
	private String roleId;
	@ApiModelProperty("第几页")
	protected Integer pageOffset; // 1 第几页
	@ApiModelProperty("一页多少条")
	protected Integer pageRows; // 50 一页多少条
	@ApiModelProperty("")
	private Integer areaId;
	@ApiModelProperty("")
	private Integer cityId;
	@ApiModelProperty("")
	private Integer regId;
	@ApiModelProperty("")
	private Integer deptId;
	@ApiModelProperty("")
	private Integer grId;
	@ApiModelProperty("")
	private Integer userId;
	@ApiModelProperty("")
	private Integer checkType;
	@ApiModelProperty("")
	private Integer isExport = 0;

	@ApiModelProperty("")
	private Integer timeType;
	@ApiModelProperty("")
	private Integer dealStatus;
	@ApiModelProperty("")
	private String queryMonth;
	@ApiModelProperty("")
	private Integer profitType;
	@ApiModelProperty("")
	private Integer archiveId;
	@ApiModelProperty("")
	private String userIds;
	@ApiModelProperty("")
	private Integer sourceDeptId;


	public Integer getSourceDeptId() {
		return sourceDeptId;
	}

	public void setSourceDeptId(Integer sourceDeptId) {
		this.sourceDeptId = sourceDeptId;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public String getQueryMonth() {
		return queryMonth;
	}

	public void setQueryMonth(String queryMonth) {
		this.queryMonth = queryMonth;
	}

	@Override
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	@Override
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
	}

	@Override
	public Integer getDeptId() {
		return deptId;
	}

	@Override
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Override
	public Integer getUserId() {
		return userId;
	}

	@Override
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProfitType() {
		return profitType;
	}

	public void setProfitType(Integer profitType) {
		this.profitType = profitType;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	// 空是全部  1个人 2管理
	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public Integer getIsExport() {
		return isExport;
	}

	public void setIsExport(Integer isExport) {
		this.isExport = isExport;
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

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
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
