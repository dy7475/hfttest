package com.myfun.repository.agencydb.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.usercenter.param.UcenterIncomePayRecordParam;
import com.myfun.repository.support.param.GeneralParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyFunCustDealDto;
import com.myfun.repository.agencydb.po.AgencyFunCustDeal;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunCustDealMapper extends BaseMapper<AgencyFunCustDeal, Integer> {
	/**
	 * 
	 * @param cityId
	 * @param custId
	 * @return
	 */
	int count(@Param("cityId")String cityId, @Param("custId")String custId);
	
	/**
	 * 修改记录
	 * @param agencyFunCustDeal
	 */
	void updateByityIdAndCustId(AgencyFunCustDeal agencyFunCustDeal);

	/**
	 * @TODO 查询我的佣金
	 * @author lcb
	 * @2016-9-5 下午3:02:53
	 */
	Map<String, String> getDistCountBorkerAmmount(Map<String, Object> pMap);

	String getCountCustInfo(Integer archiveId);

	Map<String, Integer> getCountCustPercentInfo(String money);

	List<Map<String, String>> getCountViewMap(@Param("archiveId")Integer archiveId, @Param("startTime")String startTime, @Param("endTime")String endTime);

	List<AgencyFunCustDealDto> getPersonalCommList(Map<String, Object> pMap);

	List<Map<String, String>> getCustDealListForPersonalCommList(Map<String, Object> pMap);


	/**
	 * @TODO 佣金明细
	 * @author lcb
	 * @2016-9-18 下午1:48:27
	 */
	List<Map<String, String>> getCountCustDealOfStatus(Map<String, Object> pMap);

	List<AgencyFunCustDealDto> getCustDealListDetail(Map<String, Object> pMap);

	Map<String, String> daiKanCount(Map<String, Object> pMap);

	Float getNewHouseAllAmount(@Param("type")int type,@Param("param") GeneralParam param);

	Float getNewHouseAmount(@Param("type")int type,@Param("param") GeneralParam param);

    List<Map<String,Object>> getFunCustDealList(@Param("param")UcenterIncomePayRecordParam param);
}