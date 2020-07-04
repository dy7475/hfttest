package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunBuildRule;
import com.myfun.repository.param.EncryParamIfc;


public class ErpFunBuildRuleParam extends ErpFunBuildRule implements EncryParamIfc{
	private Integer saleRegion;
	private String saleCertTime;
	private String multiNum;

	public String getMultiNum() {
		return multiNum;
	}

	public void setMultiNum(String multiNum) {
		this.multiNum = multiNum;
	}

	public String getSaleCertTime() {
		return saleCertTime;
	}

	public void setSaleCertTime(String saleCertTime) {
		this.saleCertTime = saleCertTime;
	}

	public Integer getSaleRegion() {
		return saleRegion;
	}

	public void setSaleRegion(Integer saleRegion) {
		this.saleRegion = saleRegion;
	}
}
