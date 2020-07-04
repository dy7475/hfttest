package com.myfun.repository.erpdb.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel
public class QueryDealPfActualParam extends AbstractEncryParam{
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "收款用户ID")
	private Integer currentUserId;
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	@ApiModelProperty(value = "审核状态")
	private Integer auditStatus;
	@ApiModelProperty(value = "买卖、租赁合同编号分开判重")
	private Integer auditUser;
	@ApiModelProperty(value = "排序")
	private String orderBy;
	@ApiModelProperty(value = "应收还是实收（0应收1实收）")
	private String pfActual;
	@ApiModelProperty(value = "支付方（房源，客源）")
	private String pfPayer;
	@ApiModelProperty(value = "财务款项ID")
	private String paymentId;
	@ApiModelProperty(value = "员工类型（SIGN_USER_ID签约人，AUDIT_USER审核人）")
	private String userType;
	@ApiModelProperty(value = "员工ID")
	private Integer userId;
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;
	@ApiModelProperty(value = "片区ID")
	private Integer regId;
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	@ApiModelProperty(value = "流程状态（0：未履行 1：履行中 2：已办结 3：未办结）")
	private Integer processStatus;
	@ApiModelProperty(value = "付款时间")
	private String pfTime;
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	@ApiModelProperty(value = "时间类型（AUDIT_DATE审核时间，SIGN_DATE签约日期，结算时间DEAL_VERFIY_TIME,应收日期PF_TIME,办结日期PROCESS_END_TIME）")
	private String dateType;
	@ApiModelProperty(value = "买卖、租赁合同编号分开判重")
	private String isExport;
	@ApiModelProperty(value = "智能检索")
	private String intelligentSearch;
	@ApiModelProperty(value = "业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融")
	private String performanceType;
	@ApiModelProperty(value = "财务款项IDS")
	private Object[] paymentIds;
	@ApiModelProperty(value = "合同IDS")
	private List<Integer> dealIds;
	@ApiModelProperty(value = "合同数量")
	private Integer dealSize;

	@ApiModelProperty(value = "权限范围 0=本人 1=下级所有 2=本人团队  [仅只有房基地才用]")
	private Integer operLevel;
	@ApiModelProperty(value = "用户成级" ,hidden=true)
	private Integer userLevel;
	
	@ApiModelProperty(hidden = true)
	@DefaultValue(value = "false")
	private Boolean isNewOrganization;
	@ApiModelProperty(value = "组织机构ID   (全公司：0)")
	private Integer organizationId;
	@ApiModelProperty(value = "组织架构改版使用，查询拓展字段",hidden = true)
	private String rangeColumn;
	@ApiModelProperty(value = "组织架构改版使用，查询拓展字段",hidden = true)
	private Integer rangeId;

	public Boolean getNewOrganization() {
		return isNewOrganization;
	}

	public void setNewOrganization(Boolean newOrganization) {
		isNewOrganization = newOrganization;
	}

	public Integer getRangeId() {
		return rangeId;
	}

	public void setRangeId(Integer rangeId) {
		this.rangeId = rangeId;
	}

	public String getRangeColumn() {
		return rangeColumn;
	}

	public void setRangeColumn(String rangeColumn) {
		this.rangeColumn = rangeColumn;
	}

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

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	 

	public Integer getOperLevel() {
		return operLevel;
	}

	public void setOperLevel(Integer operLevel) {
		this.operLevel = operLevel;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(Integer auditUser) {
		this.auditUser = auditUser;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getPfActual() {
		return pfActual;
	}

	public void setPfActual(String pfActual) {
		this.pfActual = pfActual;
	}

	public String getPfPayer() {
		return pfPayer;
	}

	public void setPfPayer(String pfPayer) {
		this.pfPayer = pfPayer;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}

	public String getPfTime() {
		return pfTime;
	}

	public void setPfTime(String pfTime) {
		this.pfTime = pfTime;
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

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getIsExport() {
		return isExport;
	}

	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}

	public String getIntelligentSearch() {
		return intelligentSearch;
	}

	public void setIntelligentSearch(String intelligentSearch) {
		this.intelligentSearch = intelligentSearch;
	}

	public String getPerformanceType() {
		return performanceType;
	}

	public void setPerformanceType(String performanceType) {
		this.performanceType = performanceType;
	}

	public Object[] getPaymentIds() {
		return paymentIds;
	}

	public void setPaymentIds(Object[] paymentIds) {
		this.paymentIds = paymentIds;
	}

	public List<Integer> getDealIds() {
		return dealIds;
	}

	public void setDealIds(List<Integer> dealIds) {
		this.dealIds = dealIds;
	}

	public Integer getDealSize() {
		return dealSize;
	}

	public void setDealSize(Integer dealSize) {
		this.dealSize = dealSize;
	}
}
