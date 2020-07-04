package com.myfun.repository.erpdb.dto;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunCountwage;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;

/**
 * 提成计算类型
 * 提成计算区间比例
 * @Package com.myfun.repository.erpdb.dto 
 * @author 陈文超   
 * @date 2019年9月11日 下午5:13:32
 */
public class WageCountTypePackDto {
	
	/**
	 * 提成类型
	 */
	private ErpFunWageTypeNew erpFunWageTypeNew;
	
	/**
	 * 提成比例
	 */
	private List<ErpFunCountwage> countWageTypeList;
	
	/**
	 * 业务提成1=分业务计算 2=合并计算(新增字段)
	 */
	private Byte royaltyType;

	public ErpFunWageTypeNew getErpFunWageTypeNew() {
		return erpFunWageTypeNew;
	}

	public void setErpFunWageTypeNew(ErpFunWageTypeNew erpFunWageTypeNew) {
		this.erpFunWageTypeNew = erpFunWageTypeNew;
	}

	public List<ErpFunCountwage> getCountWageTypeList() {
		return countWageTypeList;
	}

	public void setCountWageTypeList(List<ErpFunCountwage> countWageTypeList) {
		this.countWageTypeList = countWageTypeList;
	}

	public Byte getRoyaltyType() {
		return royaltyType;
	}

	public void setRoyaltyType(Byte royaltyType) {
		this.royaltyType = royaltyType;
	}
}
