package com.myfun.erpWeb.managecenter.transaction.vo;

import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

@ApiModel
public class EarbestDetailVO {
	
	private List<EarbestVO> list;
	@ApiModelProperty("查询对应的这条，list里面不包含此条")
	private EarbestVO detail;
	@ApiModelProperty("余额")
	private BigDecimal balance;

	public List<EarbestVO> getList() {
		return list;
	}

	public void setList(List<EarbestVO> list) {
		this.list = list;
	}

	public EarbestVO getDetail() {
		return detail;
	}

	public void setDetail(EarbestVO detail) {
		this.detail = detail;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	
}
