package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClass;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClassExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunRewardPunishmentClassMapper extends BaseMapper<ErpFunRewardPunishmentClass, ErpFunRewardPunishmentClass> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRewardPunishmentClassExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRewardPunishmentClassExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRewardPunishmentClass> selectByExample(ErpFunRewardPunishmentClassExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRewardPunishmentClass record,
			@Param("example") ErpFunRewardPunishmentClassExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRewardPunishmentClass record,
			@Param("example") ErpFunRewardPunishmentClassExample example);

    ErpFunRewardPunishmentClass getClassById(@Param("shardCityId") Integer cityId, @Param("classId") Integer rewardPunishmentClass);

	List<ErpFunRewardPunishmentClass> getClassByIds(@Param("shardCityId")Integer cityId,@Param("classIds") Set<Integer> rewardPunishmentClassSet);
}