package com.myfun.erpWeb.managecenter.profit.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 移动端我的中我的战绩提成合计数据
 * @Package com.myfun.erpWeb.managecenter.profit.param 
 * @author 陈文超   
 * @date 2019年8月28日 下午8:46:42
 */
@ApiModel
public class ProfitSumIncomeVo implements Serializable {
	
	@ApiModelProperty("个人提成的合计")
	private BigDecimal sumIncome;
	
	@ApiModelProperty("直接培育业绩提成金额的合计")
	private BigDecimal sumDirectIncome;
	
	@ApiModelProperty("间接培育业绩提成的合计")
	private BigDecimal sumIndirectIncome;
	
	@ApiModelProperty("精英指数排名-总业绩的排名-包含直接和传承培育的业绩")
	private Integer profitRanking;
	
	@ApiModelProperty("个人 + 直接 + 间接培育业绩的合计")
	private BigDecimal sumAllProfit;
	
	@ApiModelProperty("角色的升降情况：持平0、升级1、降级2")
	private Byte levelChange;

	public BigDecimal getSumIncome() {
		return sumIncome;
	}

	public void setSumIncome(BigDecimal sumIncome) {
		this.sumIncome = sumIncome;
	}

	public BigDecimal getSumDirectIncome() {
		return sumDirectIncome;
	}

	public void setSumDirectIncome(BigDecimal sumDirectIncome) {
		this.sumDirectIncome = sumDirectIncome;
	}

	public BigDecimal getSumIndirectIncome() {
		return sumIndirectIncome;
	}

	public void setSumIndirectIncome(BigDecimal sumIndirectIncome) {
		this.sumIndirectIncome = sumIndirectIncome;
	}

	public Integer getProfitRanking() {
		return profitRanking;
	}

	public void setProfitRanking(Integer profitRanking) {
		this.profitRanking = profitRanking;
	}

	public BigDecimal getSumAllProfit() {
		return sumAllProfit;
	}

	public void setSumAllProfit(BigDecimal sumAllProfit) {
		this.sumAllProfit = sumAllProfit;
	}

	public Byte getLevelChange() {
		return levelChange;
	}

	public void setLevelChange(Byte levelChange) {
		this.levelChange = levelChange;
	}
}
