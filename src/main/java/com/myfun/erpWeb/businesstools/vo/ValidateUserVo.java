package com.myfun.erpWeb.businesstools.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "验证用户是否有效和扣费等逻辑VO")
public class ValidateUserVo   implements Serializable {
	@ApiModelProperty("是否有效")
	private Integer playFlag;
	@ApiModelProperty("扣费")
	private BigDecimal couponAmount;

	public Integer getPlayFlag() {
		return playFlag;
	}

	public void setPlayFlag(Integer playFlag) {
		this.playFlag = playFlag;
	}

	public BigDecimal getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
}
