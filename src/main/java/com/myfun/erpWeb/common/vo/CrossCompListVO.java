package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月24日
 */
public class CrossCompListVO {

	@ApiModelProperty("公司id")
	private Integer compId;
	@ApiModelProperty("公司名")
	private String compName;
	@ApiModelProperty("城市id")
	private Integer cityId;
	@ApiModelProperty("城市名")
	private String cityName;
	
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public String getCompName() {
	
		return compName;
	}
	public void setCompName(String compName) {
	
		this.compName = compName;
	}
	public Integer getCityId() {
	
		return cityId;
	}
	public void setCityId(Integer cityId) {
	
		this.cityId = cityId;
	}
	public String getCityName() {
	
		return cityName;
	}
	public void setCityName(String cityName) {
	
		this.cityName = cityName;
	}
	
	
}

