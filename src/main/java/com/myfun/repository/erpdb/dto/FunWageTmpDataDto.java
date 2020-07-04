package com.myfun.repository.erpdb.dto;

import java.math.BigDecimal;

public class FunWageTmpDataDto {

	private Integer userId;
	private BigDecimal amount1;
	private BigDecimal amount2;
	private Integer count1;

	public Integer getCount1() {
		return count1;
	}

	public void setCount1(Integer count1) {
		this.count1 = count1;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}

	public BigDecimal getAmount2() {
		return amount2;
	}

	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}
}
