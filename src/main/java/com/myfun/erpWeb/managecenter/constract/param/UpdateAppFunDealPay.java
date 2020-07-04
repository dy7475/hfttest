package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.erpdb.po.ErpFunDealPaytype;
import com.myfun.repository.param.EncryParamIfc;

import java.util.List;

/**
 * @author guohao
 * @date 2019-03-14 11:20
 */
public class UpdateAppFunDealPay implements EncryParamIfc {
	private List<ErpFunDealPaytype> funDealPaytypeList;

	public List<ErpFunDealPaytype> getFunDealPaytypeList() {
		return funDealPaytypeList;
	}

	public void setFunDealPaytypeList(List<ErpFunDealPaytype> funDealPaytypeList) {
		this.funDealPaytypeList = funDealPaytypeList;
	}
}
