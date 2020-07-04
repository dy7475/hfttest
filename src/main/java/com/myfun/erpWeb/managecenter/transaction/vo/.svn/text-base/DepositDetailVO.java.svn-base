package com.myfun.erpWeb.managecenter.transaction.vo;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DepositDetailVO {
	
	private List<DepositVO> list;
	@ApiModelProperty("查询对应的这条，list里面不包含此条")
	private DepositVO detail;
	@ApiModelProperty("余额")
	private BigDecimal balance;
	
	public List<DepositVO> getList() {
		return list;
	}
	public void setList(List<DepositVO> list) {
		this.list = list;
	}
	public DepositVO getDetail() {
		return detail;
	}
	public void setDetail(DepositVO detail) {
		this.detail = detail;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	
}
