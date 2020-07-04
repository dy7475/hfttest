package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.transaction.param.FinaDataOfReceivableParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.erpdb.po.ErpProcessModel;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ErpProcessFinanceService extends BaseMapper<ErpProcessFinanc, ErpProcessFinanc> {
	void createDefaultFinancForDeal(InsertDealInfoParam param, ErpFunDeal funDeal);

	void finaDataReceived(List<ErpProcessFinanc> paramList, GeneralParam generalParam);

	String insertOrUpdateFinacList(GeneralParam generalParam, FinaDataOfReceivableParam param);
	
	public Boolean chackCommission(Integer cityId, Integer compId,Byte dealType, BigDecimal sellDealMoney, BigDecimal rentDealMoney, Byte rentPriceUnit,BigDecimal area,
			BigDecimal sellOwnerCommsion, BigDecimal buyCustomerCommsion);
	
	public void updateNeedandRealIncomeOffDeal(Integer cityId,Integer compId,Integer dealId);
}
