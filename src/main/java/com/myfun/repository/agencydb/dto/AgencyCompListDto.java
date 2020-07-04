package com.myfun.repository.agencydb.dto;

import java.io.Serializable;

public class AgencyCompListDto implements Serializable{

	/**
	 * 公司列表
	 */
	private static final long serialVersionUID = 1L;

	private String compNo;
	private Integer buildId;
	private Integer cityId;
	private String compName;
	private String cityName;
	private Integer bCityId;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getbCityId() {
		return bCityId;
	}
	public void setbCityId(Integer bCityId) {
		this.bCityId = bCityId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public Integer getBuildId() {
		return buildId;
	}
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
}
