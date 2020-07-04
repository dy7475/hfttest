package com.myfun.repository.agencydb.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyCooperationRuleDto;
import com.myfun.repository.agencydb.po.AgencyCooperationRule;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyCooperationRuleMapper extends BaseMapper<AgencyCooperationRule, Integer> {

	AgencyCooperationRule selectRuleByBuildId(Map<String, Object> paramMap);
	/**
	 * 查询是否有成交奖励名额
	 * @param bCtyTd
	 * @param buildId
	 * @return
	 */
	AgencyCooperationRuleDto selectDealNumAndDealRewardsNum(@Param("bCtyTd")short bCtyTd, @Param("buildId")Integer buildId);
	
	/**
	 * 将带看括以奖励多少钱，多少个带看具有奖励查询出来先
	 * @param bBityId
	 * @param buildId
	 * @return
	 */
	AgencyCooperationRule selectByCityIdAndBuildId(@Param("bcityId")short bcityId, @Param("buildId")Integer buildId);
	
	AgencyCooperationRule getDistCooperationRuleDetailed(Map<String, Object> pMap);

}