package com.myfun.erpWeb.managecenter.financialStatements.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FinancialStatementsMonthlyShopReportParam extends AbstractEncryParam {
	@ApiModelProperty(value = "日期类型")
	private String dateType;
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "报表日期")
	private String countDate;
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;
	@ApiModelProperty(value = "片区ID")
	private Integer regId;
	@ApiModelProperty(hidden = true)
	private String buildPaymentIdString;
	@ApiModelProperty(hidden = true)
	private String commission;
	@ApiModelProperty(hidden = true)
	private String nowDateStr;
	@ApiModelProperty(hidden = true)
	private String countDateStart;
	@ApiModelProperty(hidden = true)
	private String countDateEnd;
	@ApiModelProperty(hidden = true)
	private String transfer;
	
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

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getCountDate() {
		return countDate;
	}

	public void setCountDate(String countDate) {
		this.countDate = countDate;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getBuildPaymentIdString() {
		return buildPaymentIdString;
	}

	public void setBuildPaymentIdString(String buildPaymentIdString) {
		this.buildPaymentIdString = buildPaymentIdString;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getNowDateStr() {
		return nowDateStr;
	}

	public void setNowDateStr(String nowDateStr) {
		this.nowDateStr = nowDateStr;
	}

	public String getCountDateStart() {
		return countDateStart;
	}

	public void setCountDateStart(String countDateStart) {
		this.countDateStart = countDateStart;
	}

	public String getCountDateEnd() {
		return countDateEnd;
	}

	public void setCountDateEnd(String countDateEnd) {
		this.countDateEnd = countDateEnd;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}
}
