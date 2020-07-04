package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunStatisticTotle;

public class ErpFunStatisticTotleDto extends ErpFunStatisticTotle {
	/**
	 * @author 熊刚
	 * @since 2017年7月21日
	 */
	private static final long serialVersionUID = 1L;
	String houseDjCount;// 房源新增量
	String custDjCount;// 租赁新增量
	String fkHouseCount;// 房勘套数
	String dkCustCount;// 带看套数
	String saleCjCount;// 出售成交量
	String leaseCjCount;// 租成交量
	String dateCount;// 日统计
	String monthCount;// 月统计
	String weekTime;// 周统计
	String houseFkCount;// 出售房勘
	String custFkCount;// 租赁房勘
	String houseDkCount;// 出售带看
	String custDkCount;// 出租带看
	Integer trueHouseCount;

	String coreTime;
	Integer totalScore;

	public String getCoreTime() {
		return coreTime;
	}

	public void setCoreTime(String coreTime) {
		this.coreTime = coreTime;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getTrueHouseCount() {
		return trueHouseCount;
	}

	public void setTrueHouseCount(Integer trueHouseCount) {
		this.trueHouseCount = trueHouseCount;
	}

	public String getWeekTime() {
		return weekTime;
	}

	public void setWeekTime(String weekTime) {
		this.weekTime = weekTime;
	}

	public String getSaleCjCount() {
		return saleCjCount;
	}

	public void setSaleCjCount(String saleCjCount) {
		this.saleCjCount = saleCjCount;
	}

	public String getLeaseCjCount() {
		return leaseCjCount;
	}

	public void setLeaseCjCount(String leaseCjCount) {
		this.leaseCjCount = leaseCjCount;
	}

	public String getMonthCount() {
		return monthCount;
	}

	public void setMonthCount(String monthCount) {
		this.monthCount = monthCount;
	}

	public String getHouseFkCount() {
		return houseFkCount;
	}

	public void setHouseFkCount(String houseFkCount) {
		this.houseFkCount = houseFkCount;
	}

	public String getCustFkCount() {
		return custFkCount;
	}

	public void setCustFkCount(String custFkCount) {
		this.custFkCount = custFkCount;
	}

	public String getHouseDkCount() {
		return houseDkCount;
	}

	public void setHouseDkCount(String houseDkCount) {
		this.houseDkCount = houseDkCount;
	}

	public String getCustDkCount() {
		return custDkCount;
	}

	public void setCustDkCount(String custDkCount) {
		this.custDkCount = custDkCount;
	}

	public String getDateCount() {
		return dateCount;
	}

	public void setDateCount(String dateCount) {
		this.dateCount = dateCount;
	}

	public String getHouseDjCount() {
		return houseDjCount;
	}

	public void setHouseDjCount(String houseDjCount) {
		this.houseDjCount = houseDjCount;
	}

	public String getCustDjCount() {
		return custDjCount;
	}

	public void setCustDjCount(String custDjCount) {
		this.custDjCount = custDjCount;
	}

	public String getFkHouseCount() {
		return fkHouseCount;
	}

	public void setFkHouseCount(String fkHouseCount) {
		this.fkHouseCount = fkHouseCount;
	}

	public String getDkCustCount() {
		return dkCustCount;
	}

	public void setDkCustCount(String dkCustCount) {
		this.dkCustCount = dkCustCount;
	}

	public ErpFunStatisticTotleDto() {
		super();
	}

}
