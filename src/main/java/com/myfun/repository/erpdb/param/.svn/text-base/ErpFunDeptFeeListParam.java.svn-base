package com.myfun.repository.erpdb.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.erpdb.po.ErpFunDeptFeeList;
import com.myfun.repository.erpdb.po.ErpFunGenerationPaymentClass;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.DaoBaseParam;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Set;

public class ErpFunDeptFeeListParam extends ErpFunDeptFeeList implements EncryParamIfc {

	private String deptIds;
	private String countTimeStr;
	private String deptFeeList;
	private Integer pageOffset;
	private Integer pageRows;
	private Integer timeType;
	private String deptFeeListIds;
	private Set<Integer> deptFeeListIdSet;
	private String startTime;
	private String endTime;
	private String grIds;
	private String deptFeeListJson;
	@ApiModelProperty(hidden = true)
	private Integer openPartner;
	@ApiModelProperty(hidden = true)
	@DefaultValue(value = "false")
	private Boolean isNewOrganization;
	@ApiModelProperty(value = "组织机构ID字符串（多个orgID）")
	private String organizationIds;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Boolean getIsNewOrganization() {
		return isNewOrganization;
	}

	public void setIsNewOrganization(Boolean isNewOrganization) {
		this.isNewOrganization = isNewOrganization;
	}

	public String getOrganizationIds() {
	
		return organizationIds;
	}

	public void setOrganizationIds(String organizationIds) {
	
		this.organizationIds = organizationIds;
	}

	public String getDeptFeeListJson() {
		return deptFeeListJson;
	}

	public void setDeptFeeListJson(String deptFeeListJson) {
		this.deptFeeListJson = deptFeeListJson;
	}

	public String getGrIds() {
		return grIds;
	}

	public void setGrIds(String grIds) {
		this.grIds = grIds;
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

	public Set<Integer> getDeptFeeListIdSet() {
		return deptFeeListIdSet;
	}

	public void setDeptFeeListIdSet(Set<Integer> deptFeeListIdSet) {
		this.deptFeeListIdSet = deptFeeListIdSet;
	}

	public String getDeptFeeListIds() {
		return deptFeeListIds;
	}

	public void setDeptFeeListIds(String deptFeeListIds) {
		this.deptFeeListIds = deptFeeListIds;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public boolean isNeedCount() {
		return getPageOffset() == 1;
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

	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}


	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public String getCountTimeStr() {
		return countTimeStr;
	}

	public void setCountTimeStr(String countTimeStr) {
		this.countTimeStr = countTimeStr;
	}

	public String getDeptFeeList() {
		return deptFeeList;
	}

	public void setDeptFeeList(String deptFeeList) {
		this.deptFeeList = deptFeeList;
	}

	public Integer getOpenPartner() {
		return openPartner;
	}

	public void setOpenPartner(Integer openPartner) {
		this.openPartner = openPartner;
	}
}
