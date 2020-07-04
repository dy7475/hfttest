package com.myfun.repository.agencydb.param;

import java.io.Serializable;

import com.myfun.repository.support.param.PageParam;

public class AgencyFunCustParam extends PageParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer buildId;
	
	private Integer custStatus;
	
	private String cusMobile;
	
	private String custName;
	
	private String custMobile;
	
	private Integer custId;
	private Integer cityId;
	
	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCusMobile() {
		return cusMobile;
	}

	public void setCusMobile(String cusMobile) {
		this.cusMobile = cusMobile;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Integer getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(Integer custStatus) {
		this.custStatus = custStatus;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

}