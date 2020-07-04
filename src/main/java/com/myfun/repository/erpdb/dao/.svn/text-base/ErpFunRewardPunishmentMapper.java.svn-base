package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.transaction.param.RewardPunishmentDetailListParam;
import com.myfun.repository.erpdb.dto.ErpFunRewardPunishmentDto;
import com.myfun.repository.erpdb.dto.FunWageTmpDataDto;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentClassParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishment;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunRewardPunishmentMapper extends BaseMapper<ErpFunRewardPunishment, ErpFunRewardPunishment> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRewardPunishmentExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRewardPunishmentExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRewardPunishment> selectByExample(ErpFunRewardPunishmentExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRewardPunishment record,
			@Param("example") ErpFunRewardPunishmentExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRewardPunishment record,
			@Param("example") ErpFunRewardPunishmentExample example);

	List<ErpFunRewardPunishmentDto> getRewardPunishmentList(@Param("shardCityId") Integer cityId, @Param("param") RewardPunishmentDetailListParam param);

	List<Map<String,Object>> summaryRewardPunishmentList(@Param("shardCityId")Integer cityId, @Param("param") ErpFunRewardPunishmentParam erpFunRewardPunishmentClassParam);

	void insertBatch(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("createUid") Integer createUid, @Param("param") ErpFunRewardPunishmentParam erpFunRewardPunishmentParam);

	Long summaryRewardPunishmentCount(@Param("shardCityId")Integer cityId,@Param("param") ErpFunRewardPunishmentParam param);

	Integer auditRewardPunishmentInfo(@Param("param") ErpFunRewardPunishment erpFunRewardPunishment);

	List<FunWageTmpDataDto> getAllUserRewardPuishmentData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userIds") Set<Integer> allUserIdSet, @Param("assmonthSet") Set<String> assmonthSet);

	Long summaryRewardPunishmentCountNewOrg(@Param("shardCityId") Integer cityId, @Param("param") ErpFunRewardPunishmentParam param);

	List<Map<String, Object>> summaryRewardPunishmentListNewOrg(@Param("shardCityId")Integer cityId, @Param("param") ErpFunRewardPunishmentParam param);

	List<ErpFunRewardPunishmentDto> getRewardPunishmentListNewOrg(@Param("shardCityId") Integer cityId, @Param("param") RewardPunishmentDetailListParam param);

	void insertBatchNewOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("createUid") Integer createUid, @Param("param") ErpFunRewardPunishmentParam erpFunRewardPunishmentParam);
}