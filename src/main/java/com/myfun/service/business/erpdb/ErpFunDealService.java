package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.constract.param.*;
import com.myfun.erpWeb.managecenter.constract.vo.CanSeeFunDealPhotoVo;
import com.myfun.erpWeb.managecenter.deal.param.DealAuditCommonParam;
import com.myfun.erpWeb.managecenter.deal.param.DealBussinessCommonParam;
import com.myfun.erpWeb.managecenter.transaction.param.CounterMgrSettleDealParam;
import com.myfun.erpWeb.managecenter.transaction.param.changeWarrantParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

import java.util.List;
import java.util.Map;

public interface ErpFunDealService extends BaseMapper<ErpFunDeal, ErpFunDeal> {

	//PageInfo<DealBulletDto> getDealBulletList(Integer cityId, DealBulletListParam param);

	void updateByPrimaryKeys(Integer cityId, BaseMapParam paramMap);

	List<ErpFunDeal> getDealListOrderByDealIdDesc(String shardDbName, Integer lastDealId) ;

    Map<String, Object> initiationOfPayments(String financeType, String financeIds, Integer dealId,
											 Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, String deptName);

	void createAgreement(Integer cityId, ErpFunDeal funDeal, String trackContent, Map<String, Object> resultMap, InsertDealInfoParam Param);

	void updateDealShenheInfo(UpdateDealAuditStatusParam param, ErpFunDeal oldDeal);

	void makingDeal(GeneralParam generalParam, Integer dealId);

	void completionProcess(GeneralParam generalParam, Integer dealId, String modelName);

	void updateWarrantsDates(GeneralParam generalParam, ErpFunDeal model);

	void updateDealUser(Integer cityId,Integer compId, Integer dealUserId, String dealUserName, Integer dealId);

	void settlementDeal(DealBussinessCommonParam commonParam);

	Boolean isYouJiaDealByDealId(Integer cityId, Integer dealId, Integer userId, Integer crmCompId);
	
	public void updateFunDealAndCode(ErpFunDeal model,Integer codeUpdateFlag,Integer cityId) throws Exception;
	
	double getDealMoneyByDeal(ErpFunDeal dealPO) throws Exception;
	
	/**
	 * 依据单位获取金额，处理成元每月的价格
	 * @author HeWei
	 * @since 2018年7月19日 下午2:08:55
	 * @param priceUnit
	 * @param tatalMoney
	 * @param tatalArea
	 * @return
	 * Modified XXX HeWei 2018年7月19日
	 */
	public double getLeaseMoneyByMonth(String priceUnit, String tatalMoney, String tatalArea);


	public void updateMgrDealData(ErpFunDeal model, Integer[] repeatAndCodeFlagArr, ErpFunDeal oldModel, GeneralParam generalParam, String deptType, Map<String, Object> resultMap)throws Exception;

	public void saveBrokerage(ErpFunBrokerage leaseBrokerage, ErpFunBrokerage saleBrokerage, Integer cityId);

	public void insertTaxesData(List<TaxesDataOutParamDto> taxesSubList, Integer compId, Integer cityId);

	void updateMgrDealAduitStatus(UpdateDealAuditStatusParam param,GeneralParam generalParam, ErpFunDeal oldDeal, ErpFunDeal deal, List<ErpFunUsers> taskUserList);

	void changeWarrant(Integer cityId, Integer compId, changeWarrantParam param, ErpProcessRuntimeStep model, GeneralParam generalParam, String trackContent);

	void updateProcessFinancStatus(DealBussinessCommonParam param);

	void counterMgrSettleDeal(CounterMgrSettleDealParam param, ErpFunDeal funDeal, GeneralParam generalParam, ErpFunDeal baseDealInfo, List<ErpFunProfit> profitList) throws Exception;

	void updateDealVerifyTime(ErpFunDeal funDeal);

	void updateYouJiaDealAduitStatus(ErpFunDeal oldModel, GeneralParam generalParam, Integer dealId, Byte contentType, String taskSubJect,String updateClassic,String trackContent);

	void updateMgrDealAduitStatusByCounter(DealBussinessCommonParam commonParam);

	void updateDealFinancStatus(ErpFunDeal deal,Integer financStatusId,String financName,Integer dealId,Integer cityId,GeneralParam generalParam);

	int createProcessModel(ErpProcessModel processModel,String stepIds);

	void updateProcessEndTime(ErpFunDeal funDeal);

	/**
	 * @Title 操作相关业务
	 * @Author lcb
	 * @Time 2019/7/2 21:02
	 * @Desc
	 **/
	void doBussiness(DealBussinessCommonParam auditParam) throws Exception;

	void updateDealAduitStatus(DealBussinessCommonParam commonParam);
	void counterMgrSettleDeal(DealBussinessCommonParam commonParam) throws Exception;
	// 修改状态 type:1等待审核 0= 审核失败
	void doUpdateBussinessStatus(DealBussinessCommonParam param, Integer type);

	// 检查下状态
    Integer doCheckBussinessStatus(DealAuditCommonParam param, ErpFunDeal erpFunDeal);
    
    /**
     * 创建合同的跟进信息
     * @param generalParam
     * @param param
     * @return 跟进ids
     */
    String createDealTrack(GeneralParam generalParam, CreateDealTrackParam param);
    
    void createSsqContract(ErpSsqContract erpSsqContract, ErpFunDeal erpFunDeal);

	Integer canSeeFunDealPhoto(CanSeeFunDealPhotoParam param, GeneralParam generalParam);

	void checkCanSettleDeal(Integer cityId, Integer dealId);
	
}
