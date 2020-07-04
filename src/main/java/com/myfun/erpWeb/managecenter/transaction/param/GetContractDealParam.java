package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetContractDealParam extends AbstractEncryParam {
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	@ApiModelProperty(value = "片区ID")
	private Integer regId;
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;
	@ApiModelProperty(value = "买卖或租赁类型 101(买卖)/102(租赁)")
	private Byte dealType;
	@ApiModelProperty(value = "时间")
	private String date;// 时间  数字  0~9  10~....
	@ApiModelProperty(value = "开始时间")
	private String startTime;// 开始时间
	@ApiModelProperty(value = "结束时间")
	private String endTime;// 结束时间
	@ApiModelProperty(value = "时间范围")
	private String dateRange;// 时间  例如 2018-07-10~2018-07-26
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	@ApiModelProperty(value = "成交类型 0:内成交 1：外成交")
	private Integer caseDealType;
	@ApiModelProperty(value = "房客类型 0 全部(默认) 1 房源 2 客源")
	private Integer houseCustType;
	
	@ApiModelProperty(value = "权限范围 0=本人 1=本人团队 2=下级所有  (房基地参数)")
    private Integer operLevel;
	
	@ApiModelProperty(value = "用户层级  " ,hidden=true)
	private Integer userLevel;

	@ApiModelProperty(value = "组织机构ID  ")
	private Integer organizationId;
	@ApiModelProperty(value = "是否新组织架构 ")
	@DefaultValue(value="false")
	private boolean newOrganization;
	
	
	public Integer getOrganizationId() {
	
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}

	public boolean isNewOrganization() {
	
		return newOrganization;
	}

	public void setNewOrganization(boolean newOrganization) {
	
		this.newOrganization = newOrganization;
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

	public Integer getHouseCustType() {
		return houseCustType;
	}

	public void setHouseCustType(Integer houseCustType) {
		this.houseCustType = houseCustType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public Integer getCaseDealType() {
		return caseDealType;
	}

	public void setCaseDealType(Integer caseDealType) {
		this.caseDealType = caseDealType;
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

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public Byte getDealType() {
		return dealType;
	}

	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
}
