package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.transaction.param.ConvertDepositHouseParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertDepositDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.PayDepositToCommssionParam;
import com.myfun.erpWeb.managecenter.transaction.param.PayDepositToOwnerParam;
import com.myfun.erpWeb.managecenter.transaction.param.RefundDepositParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateDepositDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateDepositStatusParam;
import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.support.param.GeneralParam;

public interface ErpFunDepositService {
	public void updateFunDepositDetail(UpdateDepositDetailParam param);
	public ErpFunDeposit insertDepositDetail(InsertDepositDetailParam param) throws Exception;
	public ErpFunDeposit payDepositToCommssion(PayDepositToCommssionParam param) throws Exception;
	public void updateDepositStatus(UpdateDepositStatusParam param);
	public void convertDepositHouse(ConvertDepositHouseParam param);
	public void refundDeposit(RefundDepositParam param);
	public ErpFunDeposit payDepositToOwner(PayDepositToOwnerParam param);
	public void updateDepositDeal(GeneralParam generalParam, Integer dealId, String contractNo, Integer depositId);
}
