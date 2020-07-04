package com.myfun.erpWeb.houseBidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "查询好房币信息Vo")
public class UserInfoAndAccountInfoDto  implements Serializable {
	@ApiModelProperty("好房币（优惠券加好房币 或者只有好房币）")
	private BigDecimal compHaoFangAmount;
	@ApiModelProperty("购买好房币")
	private BigDecimal compHaoFangBuy;
	@ApiModelProperty("公司资金额度")
	private BigDecimal canUseCompAmout;
	@ApiModelProperty("推广数")
	private Integer compUaExist;
	@ApiModelProperty("精英版好房币（优惠券加好房币 或者只有好房币）")
	private String perHaofangAmount;
	@ApiModelProperty("精英版购买好房币")
	private String perHaofangBuy;
	@ApiModelProperty("精英版好房券")
	private String perHaofangQuan;

	public BigDecimal getCompHaoFangBuy() {
		return compHaoFangBuy;
	}

	public void setCompHaoFangBuy(BigDecimal compHaoFangBuy) {
		this.compHaoFangBuy = compHaoFangBuy;
	}

	public BigDecimal getCompHaoFangAmount() {
		return compHaoFangAmount;
	}

	public void setCompHaoFangAmount(BigDecimal compHaoFangAmount) {
		this.compHaoFangAmount = compHaoFangAmount;
	}



	public BigDecimal getCanUseCompAmout() {
		return canUseCompAmout;
	}

	public void setCanUseCompAmout(BigDecimal canUseCompAmout) {
		this.canUseCompAmout = canUseCompAmout;
	}

	public Integer getCompUaExist() {
		return compUaExist;
	}

	public void setCompUaExist(Integer compUaExist) {
		this.compUaExist = compUaExist;
	}

	public String getPerHaofangAmount() {
		return perHaofangAmount;
	}

	public void setPerHaofangAmount(String perHaofangAmount) {
		this.perHaofangAmount = perHaofangAmount;
	}

	public String getPerHaofangBuy() {
		return perHaofangBuy;
	}

	public void setPerHaofangBuy(String perHaofangBuy) {
		this.perHaofangBuy = perHaofangBuy;
	}

	public String getPerHaofangQuan() {
		return perHaofangQuan;
	}

	public void setPerHaofangQuan(String perHaofangQuan) {
		this.perHaofangQuan = perHaofangQuan;
	}
}
