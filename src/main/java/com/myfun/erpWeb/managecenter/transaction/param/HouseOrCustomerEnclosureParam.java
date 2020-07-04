package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class HouseOrCustomerEnclosureParam implements EncryParamIfc {
	@ApiModelProperty("房客源id")
	private Integer caseId;
	@ApiModelProperty("房客源类型 1,。出售 2.出租 3.求购，4.求租")
	private Integer caseType;
	@ApiModelProperty(hidden=true)
	private Integer cityId;
	@ApiModelProperty(hidden=true)
	private Integer compId;
	
	
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	
	

}
