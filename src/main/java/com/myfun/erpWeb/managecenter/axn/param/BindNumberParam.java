package com.myfun.erpWeb.managecenter.axn.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BindNumberParam implements EncryParamIfc {
	
	@ApiModelProperty(value = "用户id")
	private Integer userId;

	@ApiModelProperty(value = "小号")
	private String bindX;
	
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;
	
	@ApiModelProperty(hidden = true)
	private Integer operateUserId;
	
	@ApiModelProperty(value = "号码（经纪人号码）")
	private String bindA;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBindX() {
		return bindX;
	}

	public void setBindX(String bindX) {
		this.bindX = bindX;
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

	public Integer getOperateUserId() {
		return operateUserId;
	}

	public void setOperateUserId(Integer operateUserId) {
		this.operateUserId = operateUserId;
	}

	public String getBindA() {
		return bindA;
	}

	public void setBindA(String bindA) {
		this.bindA = bindA;
	}
	
}
