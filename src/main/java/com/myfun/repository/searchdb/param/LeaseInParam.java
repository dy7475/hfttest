package com.myfun.repository.searchdb.param;

import com.myfun.repository.support.param.PageParam;

public class LeaseInParam extends PageParam {
	private String leaseStatus;
	private String leaseSiteId;
	private String dateStart;
	private String endDate;
	private Integer siteId;
	private Integer compId;
	private String regName;
	private Integer provinceId;
	private String cityName;
	private Integer cityId;
	private String tableName;
	private String status;
	private String mobilePhone;
	private String keyWords;

	public String getLeaseStatus() {
		return leaseStatus;
	}

	public void setLeaseStatus(String leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	public String getLeaseSiteId() {
		return leaseSiteId;
	}

	public void setLeaseSiteId(String leaseSiteId) {
		this.leaseSiteId = leaseSiteId;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getKeyWords() {
		return keyWords;
	}	

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

}
