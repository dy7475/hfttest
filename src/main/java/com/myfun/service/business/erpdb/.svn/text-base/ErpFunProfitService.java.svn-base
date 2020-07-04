package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.transaction.param.ChangeProfitInMobileParam;
import com.myfun.erpWeb.managecenter.transaction.param.DelDealProfitParam;
import com.myfun.erpWeb.managecenter.transaction.param.changeProfitParam;
import com.myfun.repository.erpdb.param.CreateOrUpdateByHandProfitParam;
import com.myfun.repository.erpdb.param.ErpProfitMessageFormParam;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

public interface ErpFunProfitService extends BaseMapper<ErpFunProfit, ErpFunProfit>{

	Integer updatevalidProfit(Integer cityId, Integer compId, ErpProfitMessageFormParam param);

	List<Map<String,Object>> getThisYearProfitTrend(Integer cityId, Integer compId, String serchRangeReal, Integer serchRangeId, String realRange,String dimension);

    List<Map<String,Object>> getHalfProfitTrend(Integer cityId, Integer compId, String serchRangeId, String realRange);

	void createDefaultProfitForDeal(ErpFunDeal funDeal, InsertDealInfoParam param);

	void countProfitStandard(Integer cityId, Integer compId, String archiveIds);

	void updateProfitProportion(Integer cityId,Integer compId, Integer paramValue, Integer dealId);

	/**
	 * 修改业绩
	 * type = 0 合同录入的业绩
	 * type = 1手动录入的业绩
	 * @Package com.myfun.service.business.erpdb 
	 * @author 陈文超   
	 * @date 2019年9月21日 上午11:28:08
	 */
	void changeProfit(GeneralParam generalParam, changeProfitParam param, Integer type);

	void updateByHandProfit(GeneralParam generalParam, CreateOrUpdateByHandProfitParam param);

	Map<String,Object> insertMgrProfit(GeneralParam generalParam, InsertDealInfoParam param) throws Exception;

	void checkedProfitByUserId(Integer cityId, Integer compId, Integer userId,String createDate, String[] profitIds);

	void m4ChangeProfit(GeneralParam generalParam, changeProfitParam param, Integer type, Integer cityId, Integer dealId);

	void delDealProfit(ErpFunProfit erpFunProfit, ErpFunProfit funProfitPO, GeneralParam generalParam, Integer dealId,String currentDeptUserName,String trackContent);

	List<ErpFunProfit> generateNewProfitList(GeneralParam generalParam, ChangeProfitInMobileParam param);

	List<ErpFunProfit> generateNewProfitListWhenDelete(GeneralParam generalParam, DelDealProfitParam param);
}
