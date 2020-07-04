package com.myfun.repository.reportdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.reportdb.po.ReportFunStatisticDetail1;
import com.myfun.repository.reportdb.po.ReportFunStatisticDetail1Example;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ReportFunStatisticDetail1Mapper extends BaseMapper<ReportFunStatisticDetail1, Long> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ReportFunStatisticDetail1Example example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunStatisticDetail1Example example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunStatisticDetail1> selectByExample(ReportFunStatisticDetail1Example example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunStatisticDetail1 record,
			@Param("example") ReportFunStatisticDetail1Example example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunStatisticDetail1 record,
			@Param("example") ReportFunStatisticDetail1Example example);

	/**
	 * 获取IP拨号跟进列表
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getWorkCountTrackIdList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 获取跟进各房客源类型的条数
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getWorkCountCountsForTrack(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 获取未跟进各房客源类型的条数
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getWorkCountCountsForNotTrack(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 获取工作量各房客源类型条数
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getWorkCountCounts(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 获取工作量各维度的条数
	 * @author 张宏利
	 * @since 2017年8月7日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getDetailCountList(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);

	/**
	 * 数据分析-新增数据条件下-出售房源库存分析
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public Map<String, Object> getFlowAnalysisStockData(@Param("param")Map<String, Object> map);
	
	/**
	 * 获取符合条件的列表
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getHouseCustFlowAnalysisCountList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	public int count(ReportFunStatisticDetail1 reportFunStatisticDetail1);
	
	void insertToDetail(ReportFunStatisticDetail1 reportFunStatisticDetail1);

	Map<String, Object> getFlowAnalysisStockDataOffDecrement(Map<String, Object> map);

	List<Map<String, Object>> getNeedRepairHouseCustFlowAnalysisCountList( @Param("param")Map<String, Object> map);

	List<Map<String, Object>> getNeedRepairHouseCustFlowAnalysisTrackList( @Param("param")Map<String, Object> map);
	
	List<Map<String, Object>> getCaseIdList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 获取未跟进房源ID列表
	 * @author 张宏利
	 * @since 2018年1月9日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getNotTrackCaseIdList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 责任楼盘
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getDeptDutyBuildStatistic(Map<String, Object> map);
	
	/**
	 * 责任楼盘
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTotalDutyBuildStatistic(Map<String, Object> map);
	
	/**
	 * 掌通排行榜点击进入详情
	 * @author 朱科
	 * @since 2018年10月15日
	 * @return
	 */
	List<ReportFunStatisticDetail1> getAppAchieveMonthStatisticsRankDetailHouseAdd(@Param("compId")Integer compId, @Param("partnerIds") List<Integer> partnerIds,@Param("assessmentMonth")String assessmentMonth, @Param("endTime")String endTime, @Param("lookType")Integer lookType, @Param("lookTypeId")Integer lookTypeId, @Param("statisticType")Integer statisticType, @Param("caseType")Integer caseType, @Param("selfDeptId")Integer selfDeptId, @Param("deptId")Integer deptId);


	List<ReportFunStatisticDetail1> getAppAchieveMonthStatisticsRankDetailHouseAddForOrg(@Param("cityId") Integer cityId,@Param("compId")Integer compId, @Param("partnerIds") List<Integer> partnerIds,@Param("assessmentMonth")String assessmentMonth, @Param("endTime")String endTime,
																				   @Param("statisticType")Integer statisticType, @Param("caseType")Integer caseType, @Param("whereCause") String whereCause);

	/**
	 * 掌通汇总表统计内成交量
	 * @author 朱科
	 * @since 2018年11月22日
	 * @return
	 */
	Map<String, Integer> getAppInnerData(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("rangeIds") Set<Integer> rangeIds, 
			@Param("rangeType") Integer rangeType, @Param("deptId")  Integer deptId, @Param("nowTime") String nowTime, @Param("weekTime") String weekTime, @Param("monthTime") String monthTime, @Param("statisticType")Integer statisticType, @Param("caseType")Integer caseType , @Param("caseStatus")Byte caseStatus);

    List<String> selectAllNeedUpdateTableName();

	void updatePartnerId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("partnerId") Integer newPartnerId, @Param("tables") List<String> tables);

	List<Map<String, Object>> selectSctsCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

}
