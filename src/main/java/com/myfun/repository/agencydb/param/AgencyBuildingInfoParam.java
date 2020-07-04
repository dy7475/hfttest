package com.myfun.repository.agencydb.param;

import java.io.Serializable;

import com.myfun.repository.support.param.PageParam;

public class AgencyBuildingInfoParam extends PageParam implements Serializable {

	/**
	 *  学列
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cityId;
	
	private Integer provinceId;
	
	private Integer crmCompId;
	
	private Integer saleStatus;
	
	private String buildName;
	
	private Integer systemFlag;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCrmCompId() {
		return crmCompId;
	}

	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

	public Integer getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Integer getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(Integer systemFlag) {
		this.systemFlag = systemFlag;
	}
	
   
}