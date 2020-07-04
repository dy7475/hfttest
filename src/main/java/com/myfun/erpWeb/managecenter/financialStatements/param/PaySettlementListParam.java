package com.myfun.erpWeb.managecenter.financialStatements.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class PaySettlementListParam extends AbstractEncryParam {
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	@ApiModelProperty(value = "数据类型")
	private String dateType;
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	@ApiModelProperty(value = "用户类型")
	private Integer userType;
	@ApiModelProperty(value = "总数")
	private Integer total;

	@ApiModelProperty(hidden = true)
	private String paymentId;
	@ApiModelProperty(hidden = true)
	private String contractNo;
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer userId;

	@ApiModelProperty(hidden = true)
	private Integer areaId;
	@ApiModelProperty(hidden = true)
	private Integer regId;
	@ApiModelProperty(hidden = true)
	private String pfPayer;
	@ApiModelProperty(hidden = true)
	private String auditStatus;
	@ApiModelProperty(hidden = true)
	private String auditUser;
	@ApiModelProperty(hidden = true)
	private String performanceType;
	@ApiModelProperty(hidden = true)
	private String pfActual;
	@ApiModelProperty(hidden = true)
	private List<Integer> paymentIds;
	@ApiModelProperty(hidden = true)
	private String pfTime;
	@ApiModelProperty(hidden = true)
	private List<Integer> dealIds;
	@ApiModelProperty(hidden = true)
	private String orderBy;
	@ApiModelProperty("是否导出  1:导出 其他:不导出(可为空)")
	private Integer isExport;

	@ApiModelProperty(value = "权限范围 0=本人 1=本人团队 2=下级所有  (房基地参数)")
    private Integer operLevel;
	
	@ApiModelProperty(value = "用户层级  " ,hidden=true)
	private Integer userLevel;
	@ApiModelProperty(value = "档案id" ,hidden=true)
	private Integer archiveId;
	
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

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getOperLevel() {
		return operLevel;
	}

	public void setOperLevel(Integer operLevel) {
		this.operLevel = operLevel;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getIsExport() {
		if(isExport == null){
			return 0;
		}
		return isExport;
	}

	public void setIsExport(Integer isExport) {
		this.isExport = isExport;
	}

	public String getDateType() {
		return dateType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<Integer> getPaymentIds() {
		return paymentIds;
	}

	public void setPaymentIds(List<Integer> paymentIds) {
		this.paymentIds = paymentIds;
	}

	public List<Integer> getDealIds() {
		return dealIds;
	}

	public void setDealIds(List<Integer> dealIds) {
		this.dealIds = dealIds;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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

	public String getPfPayer() {
		return pfPayer;
	}

	public void setPfPayer(String pfPayer) {
		this.pfPayer = pfPayer;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public String getPerformanceType() {
		return performanceType;
	}

	public void setPerformanceType(String performanceType) {
		this.performanceType = performanceType;
	}

	public String getPfActual() {
		return pfActual;
	}

	public void setPfActual(String pfActual) {
		this.pfActual = pfActual;
	}




	public String getPfTime() {
		return pfTime;
	}

	public void setPfTime(String pfTime) {
		this.pfTime = pfTime;
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


	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
