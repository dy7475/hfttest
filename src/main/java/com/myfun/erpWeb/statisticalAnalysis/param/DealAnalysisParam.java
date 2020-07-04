package com.myfun.erpWeb.statisticalAnalysis.param;

import com.myfun.repository.param.AbstractEncryParam;

public class DealAnalysisParam extends AbstractEncryParam {
	private Integer caseType;  // 房源类型  101=买卖 102=租赁
	private Integer showType;  //报表=1
	private String dateType;  // 日期类型 SIGN_DATE=签约时间 DEAL_VERIFY_TIME=结算时间TRANSFER_DATE=过户日期
	private String dimension; // 纬度 PRICE=价格 AREA=面积 USEAGE=用途 REG=行政区
	private String endTime; // 结束时间
	private String startTime;// 开始时间
	private String serchRange; // 范围 AREA 大区 REG 片区 DEPT 门店 GROUP 分组 USER 员工
	private Integer buildReg; // 行政区
	private String serchRangeId; // 范围ID
	private String sectionIds; // 板块ids

	private String [] sectionIdArr;
	private Integer archiveId;
	private Integer compId;
	private String tableName;
	private String orderBy;
	private String groupBy;
	private String columns;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public String[] getSectionIdArr() {
		return sectionIdArr;
	}

	public void setSectionIdArr(String[] sectionIdArr) {
		this.sectionIdArr = sectionIdArr;
	}

	public Integer getShowType() {
		return showType;
	}

	public void setShowType(Integer showType) {
		this.showType = showType;
	}

	public Integer getBuildReg() {
		return buildReg;
	}

	public void setBuildReg(Integer buildReg) {
		this.buildReg = buildReg;
	}

	public String getSerchRangeId() {
		return serchRangeId;
	}

	public void setSerchRangeId(String serchRangeId) {
		this.serchRangeId = serchRangeId;
	}

	public String getSectionIds() {
		return sectionIds;
	}

	public void setSectionIds(String sectionIds) {
		this.sectionIds = sectionIds;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getCaseType() {
		return caseType;
	}

	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}
