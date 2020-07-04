package com.myfun.erpWeb.managecenter.axn.param;

import java.util.List;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ImportNumberParam implements EncryParamIfc {

	@ApiModelProperty(value = "号池key")
	private String numberPoolKey;
	
	@ApiModelProperty(value = "隐号列表")
	private List<ImportNumber> phones;
	
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;

	public String getNumberPoolKey() {
		return numberPoolKey;
	}

	public void setNumberPoolKey(String numberPoolKey) {
		this.numberPoolKey = numberPoolKey;
	}

	public List<ImportNumber> getPhones() {
		return phones;
	}

	public void setPhones(List<ImportNumber> phones) {
		this.phones = phones;
	}

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
	
}
