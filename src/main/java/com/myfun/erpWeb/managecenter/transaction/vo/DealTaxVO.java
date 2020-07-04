package com.myfun.erpWeb.managecenter.transaction.vo;

import com.myfun.repository.erpdb.po.ErpFunDealTaxesFather;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesSub;

import java.util.List;

/**
 * @author guohao
 * @date 2019-03-14 14:26
 */
public class DealTaxVO {
	private List<ErpFunDealTaxesFather> gettaxestypedata;
	private List<ErpFunDealTaxesSub> gettaxesdetaileddata;

	public List<ErpFunDealTaxesFather> getGettaxestypedata() {
		return gettaxestypedata;
	}

	public void setGettaxestypedata(List<ErpFunDealTaxesFather> gettaxestypedata) {
		this.gettaxestypedata = gettaxestypedata;
	}

	public List<ErpFunDealTaxesSub> getGettaxesdetaileddata() {
		return gettaxesdetaileddata;
	}

	public void setGettaxesdetaileddata(List<ErpFunDealTaxesSub> gettaxesdetaileddata) {
		this.gettaxesdetaileddata = gettaxesdetaileddata;
	}
}
