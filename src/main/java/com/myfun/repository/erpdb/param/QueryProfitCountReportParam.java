package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class QueryProfitCountReportParam extends AbstractEncryParam implements DaoBaseParam{
	//{"CLIENTKEY":"433c510a2005ca43ed4a1b1d1bfcf24b","DATA_TYPE":"","DATE_TYPE":"SIGN_DATE","DIMENSION":"AREA","END_TIME":"2017-02-08","PAGE_OFFSET":"1","PAGE_ROWS":"50","PF_ACTUAL":"1","SERCH_RANGE":"COMP","SHOW_TYPE":"TABLE","START_TIME":"2017-02-01"}
	/**
	 * 时间类型
	 */
	private String dateType;
	
	/**
	 * 维度 AREA=大区 REG=片区 DEPT=门店 GROUP=分组 USER=员工
	 */
	private String dimension;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 结束时间
	 */
	private String endTime;
	
	/**
	 * 1=实收 0=应收
	 */
	private String pfActual;
	
	/**
	 * 查询范围 COMP=公司  AREA=大区 REG=片区 DEPT=门店 GROUP=分组 USER=员工
	 */
	private String serchRange;
	/**
	 * 查询范围Id
	 */
	private String serchRangeId;
	
	/**
	 * 图表类型 TABLE=报表 CHART=图表
	 */
	private String showType;
	
	/**
	 * 公司ID
	 */
	private Integer compId;
	/**
	 * 城市ID
	 */
	private Integer cityId;
	/**
	 * 
	 */
	private String areaFlag;

	
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getAreaFlag() {
		return areaFlag;
	}

	public void setAreaFlag(String areaFlag) {
		this.areaFlag = areaFlag;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
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

	public String getPfActual() {
		return pfActual;
	}

	public void setPfActual(String pfActual) {
		this.pfActual = pfActual;
	}

	public String getSerchRange() {
		return serchRange;
	}

	public void setSerchRange(String serchRange) {
		this.serchRange = serchRange;
	}

	public String getSerchRangeId() {
		return serchRangeId;
	}

	public void setSerchRangeId(String serchRangeId) {
		this.serchRangeId = serchRangeId;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}
	
	
	
}
