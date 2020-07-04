package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel
public class DealContractParam extends AbstractEncryParam {
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	@ApiModelProperty(value = "用户类型 1总负责人 2执行人 3签约员工 4创建人")
	private Integer userType;
	@ApiModelProperty(value = "流程类别")
	private Integer modelId;
	@ApiModelProperty(value = "流程状态 1=履行中(在途单) 2=已办结(办结单) 3=未办结")
	private Integer processStatus;
	@ApiModelProperty(value = "排序方式(字段名)")
	private String orderBy;
	@ApiModelProperty(value = "步骤名称")
	private String  stepName;
	@ApiModelProperty(value = "步骤状态")
	private Integer stepStatus;
	@ApiModelProperty(value = "时间类型 SIGN_DATE=签约日期  TIMELIMITDATE=计划日期  UPDATE_TIME=完成日期")
	private String dateType;
	@ApiModelProperty(value = "时间 0=今天 1=明天 2=本周 3=下周 4=已超期")
	private Integer date;
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	@ApiModelProperty(value = "智能搜索")
	private String intelligentSearch;
	@ApiModelProperty(value = "0未分配，1待结算，2已结算 6未结算")
	private Integer dealStatus; // 0,1,2未分配，待结算，已结算
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	
	@ApiModelProperty(value = "排序方式 ASC=升序，DESC=降序")
	private String orderType;
	
	@ApiModelProperty(hidden = true)
	private String dateColumn;
	
	@ApiModelProperty(hidden = true)
	private String dateParam;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;
	
	@ApiModelProperty(hidden = true)
	private String joinStr;
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	
	@ApiModelProperty(hidden = true)
	private List<Integer> repeatDealIds;
	
	
	@ApiModelProperty(value = "权限范围 0=本人 1=本人团队 2=下级所有  (房基地参数)")
    private Integer operLevel;
	
	@ApiModelProperty(value = "用户层级  " ,hidden=true)
	private Integer userLevel;
	
	@ApiModelProperty(value = "组织结构ID ")
	private Integer organizationId;
	
	@ApiModelProperty(hidden=true)
	@DefaultValue(value="false")
	private boolean newOrganization;
	
	public boolean isNewOrganization() {
	
		return newOrganization;
	}

	public void setNewOrganization(boolean newOrganization) {
	
		this.newOrganization = newOrganization;
	}

	public Integer getOrganizationId() {
	
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public List<Integer> getRepeatDealIds() {
		return repeatDealIds;
	}

	public void setRepeatDealIds(List<Integer> repeatDealIds) {
		this.repeatDealIds = repeatDealIds;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public String getJoinStr() {
		return joinStr;
	}

	public void setJoinStr(String joinStr) {
		this.joinStr = joinStr;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getDateColumn() {
		return dateColumn;
	}

	public void setDateColumn(String dateColumn) {
		this.dateColumn = dateColumn;
	}

	public String getDateParam() {
		return dateParam;
	}

	public void setDateParam(String dateParam) {
		this.dateParam = dateParam;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public Integer getStepStatus() {
		return stepStatus;
	}

	public void setStepStatus(Integer stepStatus) {
		this.stepStatus = stepStatus;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
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

	public String getIntelligentSearch() {
		return intelligentSearch;
	}

	public void setIntelligentSearch(String intelligentSearch) {
		this.intelligentSearch = intelligentSearch;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}
}
