package com.myfun.repository.erpdb.dto;

import java.math.BigDecimal;

import com.myfun.repository.erpdb.po.ErpFunSalaryType;

public class ErpFunSalaryTypeDto extends ErpFunSalaryType {
	/**
	 * @author 臧铁
	 * @since 2017年8月28日
	 */
	private static final long serialVersionUID = 1L;
	private Integer houseAddCount;// 房源新增数量
	private Integer custAddCount;// 客源新增数量
	private Integer fankanCount;// 房勘数量
	private Integer daikanCount;// 带看数量
	private BigDecimal perHouseMoney;// 房源新增每笔金额
	private BigDecimal perCustMoney;// 客源新增每笔的金额
	private BigDecimal perFankanMoney;// 房勘每笔的金额
	private BigDecimal perDaikanMoney;// 带看每笔的金额
	private Integer stanrdassessmentTargetId;// 原有标准id
	public Integer getHouseAddCount() {
		return houseAddCount;
	}
	public void setHouseAddCount(Integer houseAddCount) {
		this.houseAddCount = houseAddCount;
	}
	public Integer getCustAddCount() {
		return custAddCount;
	}
	public void setCustAddCount(Integer custAddCount) {
		this.custAddCount = custAddCount;
	}
	public Integer getFankanCount() {
		return fankanCount;
	}
	public void setFankanCount(Integer fankanCount) {
		this.fankanCount = fankanCount;
	}
	public Integer getDaikanCount() {
		return daikanCount;
	}
	public void setDaikanCount(Integer daikanCount) {
		this.daikanCount = daikanCount;
	}
	public BigDecimal getPerHouseMoney() {
		return perHouseMoney;
	}
	public void setPerHouseMoney(BigDecimal perHouseMoney) {
		this.perHouseMoney = perHouseMoney;
	}
	public BigDecimal getPerCustMoney() {
		return perCustMoney;
	}
	public void setPerCustMoney(BigDecimal perCustMoney) {
		this.perCustMoney = perCustMoney;
	}
	public BigDecimal getPerFankanMoney() {
		return perFankanMoney;
	}
	public void setPerFankanMoney(BigDecimal perFankanMoney) {
		this.perFankanMoney = perFankanMoney;
	}
	public BigDecimal getPerDaikanMoney() {
		return perDaikanMoney;
	}
	public void setPerDaikanMoney(BigDecimal perDaikanMoney) {
		this.perDaikanMoney = perDaikanMoney;
	}
	public Integer getStanrdassessmentTargetId() {
		return stanrdassessmentTargetId;
	}
	public void setStanrdassessmentTargetId(Integer stanrdassessmentTargetId) {
		this.stanrdassessmentTargetId = stanrdassessmentTargetId;
	}
}
