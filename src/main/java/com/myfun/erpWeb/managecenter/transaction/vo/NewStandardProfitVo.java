package com.myfun.erpWeb.managecenter.transaction.vo;

import java.math.BigDecimal;
import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunPerformanceType;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author XIONG CAI
 * @since 2019年8月31日 上午10:53:10
 * Modified XXX XIONG CAI 2019年8月31日
 */
public class NewStandardProfitVo {
	
	@ApiModelProperty(value = "业绩类别")
	private Integer performanceType;
	@ApiModelProperty(value = "总分佣比例")
	private BigDecimal totalProportion;
	@ApiModelProperty(value = "总分佣金额")
	private BigDecimal totalMoney;
	@ApiModelProperty(value = "应收总额")
	private BigDecimal totalReceivableMoney;
	@ApiModelProperty(value = "实收总额")
	private BigDecimal totalProfitMoney;
	@ApiModelProperty(value = "业绩VO")
	private List<ErpFunProfitStandVo> profitListVo;
	@ApiModelProperty(value = "公司分佣比例")
	private BigDecimal compProportion;
	@ApiModelProperty(value = "平台收费应收金额")
	private BigDecimal totalCompReceivableMoney;
	@ApiModelProperty(value = "平台收费实收金额")
	private BigDecimal totalCompProfitMoney;
	
	public Integer getPerformanceType() {
	
		return performanceType;
	}
	public void setPerformanceType(Integer performanceType) {
	
		this.performanceType = performanceType;
	}
	public BigDecimal getTotalProportion() {
	
		return totalProportion;
	}
	public void setTotalProportion(BigDecimal totalProportion) {
	
		this.totalProportion = totalProportion;
	}
	public BigDecimal getTotalReceivableMoney() {
	
		return totalReceivableMoney;
	}
	public void setTotalReceivableMoney(BigDecimal totalReceivableMoney) {
	
		this.totalReceivableMoney = totalReceivableMoney;
	}
	public BigDecimal getTotalProfitMoney() {
	
		return totalProfitMoney;
	}
	public void setTotalProfitMoney(BigDecimal totalProfitMoney) {
	
		this.totalProfitMoney = totalProfitMoney;
	}
	public List<ErpFunProfitStandVo> getProfitListVo() {
	
		return profitListVo;
	}
	public void setProfitListVo(List<ErpFunProfitStandVo> profitListVo) {
	
		this.profitListVo = profitListVo;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public BigDecimal getCompProportion() {
		return compProportion;
	}
	public void setCompProportion(BigDecimal compProportion) {
		this.compProportion = compProportion;
	}
	public BigDecimal getTotalCompReceivableMoney() {
		return totalCompReceivableMoney;
	}
	public void setTotalCompReceivableMoney(BigDecimal totalCompReceivableMoney) {
		this.totalCompReceivableMoney = totalCompReceivableMoney;
	}
	public BigDecimal getTotalCompProfitMoney() {
		return totalCompProfitMoney;
	}
	public void setTotalCompProfitMoney(BigDecimal totalCompProfitMoney) {
		this.totalCompProfitMoney = totalCompProfitMoney;
	}
	
	
}

