package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunProfitTarget;

import java.io.Serializable;
import java.math.BigDecimal;

public class ErpFunProfitTargetDto extends ErpFunProfitTarget implements Serializable {


	private Integer rangeId;
	private BigDecimal profitMoney;
	private Integer rangeType;
	private Integer deptId;

	@Override
	public Integer getDeptId() {
		return deptId;
	}

	@Override
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	public BigDecimal getProfitMoney() {
		return profitMoney;
	}

	public void setProfitMoney(BigDecimal profitMoney) {
		this.profitMoney = profitMoney;
	}

	public Integer getRangeId() {
		return rangeId;
	}

	public void setRangeId(Integer rangeId) {
		this.rangeId = rangeId;
	}
}
