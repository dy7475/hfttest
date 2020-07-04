package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpHouseInnerdealAnalysis;

import java.math.BigDecimal;

public class ErpHouseInnerdealAnalysisDto extends ErpHouseInnerdealAnalysis {
	//房源成交统计分析参数
	private String monthofyear;//年月
	private BigDecimal count1;
	private BigDecimal count2;
	private BigDecimal count3;
	private BigDecimal count4;
	private BigDecimal count5;
	private BigDecimal count6;
	private BigDecimal count7;

	public String getMonthofyear() {
		return monthofyear;
	}

	public void setMonthofyear(String monthofyear) {
		this.monthofyear = monthofyear;
	}

	public BigDecimal getCount1() {
		return count1;
	}

	public void setCount1(BigDecimal count1) {
		this.count1 = count1;
	}

	public BigDecimal getCount2() {
		return count2;
	}

	public void setCount2(BigDecimal count2) {
		this.count2 = count2;
	}

	public BigDecimal getCount3() {
		return count3;
	}

	public void setCount3(BigDecimal count3) {
		this.count3 = count3;
	}

	public BigDecimal getCount4() {
		return count4;
	}

	public void setCount4(BigDecimal count4) {
		this.count4 = count4;
	}

	public BigDecimal getCount5() {
		return count5;
	}

	public void setCount5(BigDecimal count5) {
		this.count5 = count5;
	}

	public BigDecimal getCount6() {
		return count6;
	}

	public void setCount6(BigDecimal count6) {
		this.count6 = count6;
	}

	public BigDecimal getCount7() {
		return count7;
	}

	public void setCount7(BigDecimal count7) {
		this.count7 = count7;
	}
}
