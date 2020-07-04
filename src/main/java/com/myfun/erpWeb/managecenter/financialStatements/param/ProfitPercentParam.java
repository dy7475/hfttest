package com.myfun.erpWeb.managecenter.financialStatements.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProfitPercentParam extends AbstractEncryParam implements EncryParamIfc {
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "搜索范围")
	private String serchRange;//搜索范围
	@ApiModelProperty(value = "开始时间")
	private String startTime;//开始时间
	@ApiModelProperty(value = "结束时间")
	private String endTime;//结束时间
	@ApiModelProperty(value = "时间类型")
	private String dateType;//时间类型  DEAL_VERFIY_TIME SIGN_DATE TRANSFER_DATE
	@ApiModelProperty(value = "展示类型")
	private String showType;//前端传入的展示类型
	@ApiModelProperty(value = "合同类型")
	private String dealType;//合同类型
	@ApiModelProperty(value = "合同编号")
	private String contractNo;//合同编号
	private String[] performanceColumn;
	private String categoryId;
	private Integer serchRangeId;
	private String groupBy;
	private String queryColStr;
	private String whereStr;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	@ApiModelProperty(value = "组织层级ID")
	private Integer defId;
	@ApiModelProperty(value = "用户ID")
	private Integer userId;

	public Integer getSerchRangeId() {
		return serchRangeId;
	}

	public void setSerchRangeId(Integer serchRangeId) {
		this.serchRangeId = serchRangeId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String[] getPerformanceColumn() {
		return performanceColumn;
	}

	public void setPerformanceColumn(String[] performanceColumn) {
		this.performanceColumn = performanceColumn;
	}

	public String getSerchRange() {
		return serchRange;
	}

	public void setSerchRange(String serchRange) {
		this.serchRange = serchRange;
	}

	public String getStartTime() {
		return startTime;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime+" 23:59:59";
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public String getQueryColStr() {
		return queryColStr;
	}

	public void setQueryColStr(String queryColStr) {
		this.queryColStr = queryColStr;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getWhereStr() {
		return whereStr;
	}

	public void setWhereStr(String whereStr) {
		this.whereStr = whereStr;
	}
}
