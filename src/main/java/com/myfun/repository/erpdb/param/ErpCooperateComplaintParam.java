package com.myfun.repository.erpdb.param;

import com.myfun.repository.support.param.PageParam;

public class ErpCooperateComplaintParam extends PageParam{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	private String regName;
	private String provinceId;
	private Integer caseType;
	private Integer ccResult;
	private Integer cityId;
	private Integer shardCityId;
	private Integer ccId;
	private String useage;
	private Integer caseId;
	private Integer dealType;
	
	public Integer getDealType() {
		return dealType;
	}
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getCcId() {
		return ccId;
	}
	public void setCcId(Integer ccId) {
		this.ccId = ccId;
	}
	public String getUseage() {
		return useage;
	}
	public void setUseage(String useage) {
		this.useage = useage;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getShardCityId() {
		return shardCityId;
	}
	public void setShardCityId(Integer shardCityId) {
		this.shardCityId = shardCityId;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	public Integer getCcResult() {
		return ccResult;
	}
	public void setCcResult(Integer ccResult) {
		this.ccResult = ccResult;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
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
	
	
}
