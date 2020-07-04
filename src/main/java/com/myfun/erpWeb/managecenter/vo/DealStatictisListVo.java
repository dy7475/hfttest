package com.myfun.erpWeb.managecenter.vo;

import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "成交统计列表VO")
public class DealStatictisListVo implements Serializable {

	private List<ErpFunDealDto> funDealDtoList;
	private BigDecimal realMoney;
	private BigDecimal totalMoney;

	public List<ErpFunDealDto> getFunDealDtoList() {
		return funDealDtoList;
	}

	public void setFunDealDtoList(List<ErpFunDealDto> funDealDtoList) {
		this.funDealDtoList = funDealDtoList;
	}

	public BigDecimal getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(BigDecimal realMoney) {
		this.realMoney = realMoney;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
}
