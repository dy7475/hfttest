package com.myfun.repository.reportdb.dao;

import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import com.myfun.repository.reportdb.po.ReportFunWageDetail1;
import com.myfun.repository.reportdb.po.ReportFunWageDetail1Example;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReportFunWageDetail1Mapper extends BaseMapper<ReportFunWageDetail1, Long> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ReportFunWageDetail1Example example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunWageDetail1Example example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunWageDetail1> selectByExample(ReportFunWageDetail1Example example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunWageDetail1 record,
			@Param("example") ReportFunWageDetail1Example example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunWageDetail1 record,
			@Param("example") ReportFunWageDetail1Example example);

	List<ReportFunWageDetail1> selectBuyData(@Param("shardCityId")Integer cityId, @Param("param")ErpPerformanceAssessmentCountParam param);
	Map<String, Object> selectBuyDataCount(@Param("shardCityId")Integer cityId, @Param("param")ErpPerformanceAssessmentCountParam param);

	Integer updateCountById(@Param("shardCityId")Integer cityId, @Param("param")ErpPerformanceAssessmentCountParam param);
}