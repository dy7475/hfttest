package com.myfun.erpWeb.managecenter.axn.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BatchUnBindNumberParam implements EncryParamIfc {

	@ApiModelProperty(value = "解绑的小号，多个用逗号隔开")
	private String bindXs;
	
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;
	
	@ApiModelProperty(hidden = true)
	private Integer operateUserId;

	public String getBindXs() {
		return bindXs;
	}

	public void setBindXs(String bindXs) {
		this.bindXs = bindXs;
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
	
}
