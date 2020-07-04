package com.myfun.service.business.erpdb;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.transaction.param.CancelAuditParam;
import com.myfun.erpWeb.managecenter.transaction.param.CancellationParam;
import com.myfun.erpWeb.managecenter.transaction.param.RefundMoneyParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestHouseParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestToBrokerageParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestToProprietorParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransToDepositParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateEarbestStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.updateDealFunEarbestParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateEarbestMoneyParam;
import com.myfun.service.business.erpdb.bean.param.QueryErpEarbestMoneyListParam;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

public interface ErpFunEarbestMoneyService extends BaseMapper<ErpFunEarbestMoney, ErpFunEarbestMoney>{
	public PageInfo<ErpFunEarbestMoneyDto> getEarbestMoneyList (QueryErpEarbestMoneyListParam param) throws Exception;
	public List<ErpFunEarbestMoneyDto> getEarbestMoneyListExport (QueryErpEarbestMoneyListParam param) throws Exception;
	public void createDealFunEarbestMoney(CreateOrUpdateEarbestMoneyParam param) throws Exception;
	public void deleteEarbestMoney(BaseMapParam param) throws Exception;
	public void updateEarbestMoneyStatus(UpdateEarbestStatusParam param) throws Exception;
	public ErpFunEarbestMoneyDto getDealFunEarbestMoneyDetail(BaseMapParam param);
	public void updateEarbestMoney(CreateOrUpdateEarbestMoneyParam param, ErpFunEarbestMoney updateEarbestMoney);
	void deleteDealFunEarbestMoney(GeneralParam generalParam, Integer earbestId);

	void updateDealFunEarbestMoney(updateDealFunEarbestParam param, ErpFunEarbestMoney earbestMoney, String currUserName);

	void transEarnestHouse(TransEarnestHouseParam param) throws Exception;

	void cancelAudit(CancelAuditParam record);

	void transToDeposit(TransToDepositParam param);

	void cancellationEarnest(CancellationParam param);

    void transEarnestToBroker(TransEarnestToBrokerageParam param) throws  Exception;

    void transEarnestToProprietor(TransEarnestToProprietorParam param) throws InvocationTargetException, IllegalAccessException;

    void refundEarnestHouse(RefundMoneyParam param) throws InvocationTargetException, IllegalAccessException;

	void updateEarnestDeal(GeneralParam generalParam, Integer dealId, String contractNo,Integer earbestId);
}
