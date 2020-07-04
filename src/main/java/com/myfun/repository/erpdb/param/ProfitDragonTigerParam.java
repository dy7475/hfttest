package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;

/**
 * 业绩龙虎版参数类
 * @author Administrator
 *
 */
public class ProfitDragonTigerParam extends AbstractEncryParam {
	
	private Integer compId;//公司ID
	private Integer cityId;//城市ID
	private Integer archiveId;//档案Id
	private String groupStr;
	private String queryStr;
	private Integer searchRangeId;//对应搜索条件ID
	private String searchRange;//搜索范围
	private String dimension;//纬度 AREA 大区 REG 片区 DEPT 门店 GROUP 分组 USER 员工dimensi
	private String pfActual;//0=应收 1=实收
	private String startTime;//开始时间
	private String endTime;//结束时间 
	private String dataType;//1=最优 2=最差
	private String dateType;//日期类型，结算日期DEAL_VERIFY_TIME,签约日期 SIGN_DATE
	private String showType;//前端传入的展示类型
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
	
	public Integer getSearchRangeId() {
		return searchRangeId;
	}
	public void setSearchRangeId(Integer searchRangeId) {
		this.searchRangeId = searchRangeId;
	}
	public String getSearchRange() {
		return searchRange;
	}
	public void setSearchRange(String searchRange) {
		this.searchRange = searchRange;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getPfActual() {
		return pfActual;
	}
	public void setPfActual(String pfActual) {
		this.pfActual = pfActual;
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
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
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
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public String getGroupStr() {
		return groupStr;
	}
	public void setGroupStr(String groupStr) {
		this.groupStr = groupStr;
	}
	public String getQueryStr() {
		return queryStr;
	}
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}
	
}
