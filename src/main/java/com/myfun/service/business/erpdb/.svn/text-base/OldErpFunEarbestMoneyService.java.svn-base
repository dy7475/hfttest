package com.myfun.service.business.erpdb;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.transaction.param.updateDealFunEarbestParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateEarbestMoneyParam;
import com.myfun.service.business.erpdb.bean.param.QueryErpEarbestMoneyListParam;

import java.util.List;

public interface OldErpFunEarbestMoneyService extends BaseMapper<ErpFunEarbestMoney, ErpFunEarbestMoney> {
	public PageInfo<ErpFunEarbestMoneyDto> getEarbestMoneyList (QueryErpEarbestMoneyListParam param) throws Exception;
	public List<ErpFunEarbestMoneyDto> getEarbestMoneyListExport (QueryErpEarbestMoneyListParam param) throws Exception;
	public void createDealFunEarbestMoney(CreateOrUpdateEarbestMoneyParam param) throws Exception;
	public void deleteEarbestMoney(BaseMapParam param) throws Exception;
	public void updateEarbestMoneyStatus(BaseMapParam param) throws Exception;
	public ErpFunEarbestMoneyDto getDealFunEarbestMoneyDetail(BaseMapParam param);
	public void updateEarbestMoney(CreateOrUpdateEarbestMoneyParam param, ErpFunEarbestMoney updateEarbestMoney);
	void deleteDealFunEarbestMoney(GeneralParam generalParam, Integer earbestId);

	void updateDealFunEarbestMoney(updateDealFunEarbestParam param, ErpFunEarbestMoney earbestMoney, String currUserName);
}
