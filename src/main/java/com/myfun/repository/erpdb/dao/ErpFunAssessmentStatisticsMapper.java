package com.myfun.repository.erpdb.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.repository.erpdb.param.ErpProfitMessageFormParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunAssessmentStatistics;
import com.myfun.repository.erpdb.po.ErpFunAssessmentStatisticsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunAssessmentStatisticsMapper extends BaseMapper<ErpFunAssessmentStatistics, ErpFunAssessmentStatistics> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAssessmentStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAssessmentStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAssessmentStatistics> selectByExample(ErpFunAssessmentStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAssessmentStatistics record, @Param("example") ErpFunAssessmentStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAssessmentStatistics record, @Param("example") ErpFunAssessmentStatisticsExample example);

	int updateFxzOrKxzAmount(@Param("shardCityId")Integer shardCityId, @Param("param")Map<String, Object> baseMap, @Param("count")BigDecimal count,@Param("caseType") Integer caseType);

	void initAssessmentStaticsData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("userId") Integer userId, @Param("roleId")String roleId,
								   @Param("assessMentMonth")String assessMentMonth,@Param("roleWageConfigId")Integer roleWageConfigId,@Param("checkType") Integer checkType,
								   @Param("caseType") Integer caseType, @Param("effectiveThisMonth") Integer effectiveThisMonth, @Param("newDeptCount") Integer newDeptCount);

	void initAssessmentStaticsDataNew(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("userId") Integer userId, @Param("roleId")String roleId,
								   @Param("assessMentMonth")String assessMentMonth,@Param("roleWageConfigId")Integer roleWageConfigId,@Param("checkType") Integer checkType,
								   @Param("caseType") Integer caseType, @Param("effectiveThisMonth") Integer effectiveThisMonth, @Param("newDeptCount") Integer newDeptCount);

	void updateDataById(@Param("shardCityId")Integer cityId, @Param("id")Integer id,@Param("fieldName") String fieldName,
						@Param("itemCount")Integer itemCount, @Param("validFlag")Integer validFlag);

	void updateAmountById(@Param("shardCityId")Integer cityId,@Param("totalAmount") BigDecimal totalAmount,@Param("param") ErpProfitMessageFormParam param);

	void updateAssessmentStatistic(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId,
								   @Param("assessMentMonth")String assessMentMonth, @Param("id")Integer id, @Param("userPosition")String userPosition);

	void mergeAssessmentStaticsData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId,
									@Param("assessmentMonth") String assessMentMonth, @Param("roleWageConfigId") Integer roleWageConfigId);

    List<ErpFunAssessmentStatistics> getStatisticsSum(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("assessmentMonth")String assessmentMonth, @Param("userIdSet")Set<Integer> userIdSet, @Param("checkType") Byte checkType);
}