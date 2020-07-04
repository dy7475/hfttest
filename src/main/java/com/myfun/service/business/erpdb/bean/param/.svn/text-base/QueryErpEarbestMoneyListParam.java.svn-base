package com.myfun.service.business.erpdb.bean.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class QueryErpEarbestMoneyListParam extends AbstractEncryParam implements DaoBaseParam{
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	@ApiModelProperty(value = "部门ID")
	private Integer deptId;
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	@ApiModelProperty(value = "楼盘ID")
	private String buildId;
	@ApiModelProperty(value = "审核状态：0未审核，1已审核，不指定查所有")
	private Byte status;
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	@ApiModelProperty(value = "编号")
	private String receiptNo;
	@ApiModelProperty(value = "查询人类型   CREATE 登记人 RECEIPT 收款人 AUDIT 审核人 ")
	private String userType;
	@ApiModelProperty(value = "时间类型：CREATE_TIME创建时间，CONFIRM_TIME审核时间，UPDATE_TIME更新时间，")
	private String dateType;
	@ApiModelProperty(value = "大区ID")
	private String areaId;
	@ApiModelProperty(value = "片区ID")
	private String regId;
	@ApiModelProperty(hidden = true)
	private String isExport;
	@ApiModelProperty(hidden = true)
	private String orderBy;
	@ApiModelProperty(hidden = true)
	private String buildName;
	@ApiModelProperty(value = "楼盘ID")
	private String[] buildIds;
	@ApiModelProperty(value = "客户名")
	private String custName;
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	@ApiModelProperty(value = "成交状态：0未成交，1已成交，不指定查所有")
	private Integer dealStatus;
	@ApiModelProperty(value = "权限范围 0=本人 1=本人团队 2=下级所有")
	private Integer operLevel;

	@ApiModelProperty(value = "类型0=收定金1=转房源2=代付3=客户转拥4=退款 5=作废，6.业主转拥金，7.转定金 多个逗号隔开")
	private String types;
	@ApiModelProperty(hidden = true)
	private Integer createUserId;
	@ApiModelProperty(hidden = true)
	private Integer confirmUserId;
	@ApiModelProperty(hidden = true)
	private Integer receiptUserId;
	@ApiModelProperty(hidden = true)
	private Integer userLevel;
	@ApiModelProperty(hidden = true)
	@DefaultValue(value = "false")
	private Boolean isNewOrganization;
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

	private List<Integer> typeList;


	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String[] getBuildIds() {
		return buildIds;
	}
	public void setBuildIds(String[] buildIds) {
		this.buildIds = buildIds;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getBuildId() {
		return buildId;
	}
	public void setBuildId(String buildId) {
		this.buildId = buildId;
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
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getIsExport() {
		return isExport;
	}
	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}


	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public List<Integer> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Integer> typeList) {
		this.typeList = typeList;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getConfirmUserId() {
		return confirmUserId;
	}

	public void setConfirmUserId(Integer confirmUserId) {
		this.confirmUserId = confirmUserId;
	}

	public Integer getReceiptUserId() {
		return receiptUserId;
	}

	public void setReceiptUserId(Integer receiptUserId) {
		this.receiptUserId = receiptUserId;
	}


}
