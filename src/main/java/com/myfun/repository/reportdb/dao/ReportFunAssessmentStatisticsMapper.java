package com.myfun.repository.reportdb.dao;

import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import com.myfun.repository.reportdb.dto.ReportFunAssessmentStatisticsDto;
import com.myfun.repository.reportdb.po.ReportFunAssessmentStatistics;
import com.myfun.repository.reportdb.po.ReportFunAssessmentStatisticsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReportFunAssessmentStatisticsMapper extends BaseMapper<ReportFunAssessmentStatistics, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ReportFunAssessmentStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunAssessmentStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunAssessmentStatistics> selectByExample(ReportFunAssessmentStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunAssessmentStatistics record,
								 @Param("example") ReportFunAssessmentStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunAssessmentStatistics record,
						@Param("example") ReportFunAssessmentStatisticsExample example);

	List<ReportFunAssessmentStatisticsDto> selectAssessmentCountList(@Param("shardCityId") Integer cityId, @Param("param") ErpPerformanceAssessmentCountParam param);

	ReportFunAssessmentStatisticsDto getManagerRangeData(@Param("shardCityId") Integer cityId,@Param("compId")  Integer compId, @Param("rangeType") Integer rangType, @Param("rangeId") Integer rangeId,  @Param("assessmentMonth") String assessmentMonth, @Param("checkBusiness") Byte checkBusiness, @Param("checkType") Integer checkType);

	List<Map<String, Object>> getBeforeDataList(@Param("shardCityId") Integer cityId, @Param("param") ErpPerformanceAssessmentCountParam param);

	Long getPageCount(@Param("shardCityId") Integer cityId, @Param("param") ErpPerformanceAssessmentCountParam param);

	List<Map<String, Object>> getManageAssessmentDataList(@Param("shardCityId") Integer cityId, @Param("param") ErpPerformanceAssessmentCountParam param);

	List<ReportFunAssessmentStatisticsDto> getBaseUserList(@Param("cityId")Integer cityId, @Param("compId")Integer compId, @Param("param")ErpPerformanceAssessmentCountParam param);
}
