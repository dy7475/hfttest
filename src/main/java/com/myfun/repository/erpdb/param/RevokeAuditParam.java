package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class RevokeAuditParam implements EncryParamIfc {
	@ApiModelProperty(value = "审核任务id", required = true)
	@NotNull(message = "请指定审核任务")
	private Integer id;

	@ApiModelProperty(value = "城市ID", required = true)
	@NotNull(message = "城市ID")
	private Integer cityId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
}
