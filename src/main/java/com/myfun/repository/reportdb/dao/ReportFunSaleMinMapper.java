package com.myfun.repository.reportdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.openApi.analysis.param.AnalysisForWebParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.HouseCustAddCountDto;
import com.myfun.repository.reportdb.po.ReportFunSaleMin;
import com.myfun.repository.reportdb.po.ReportFunSaleMinExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ReportFunSaleMinMapper extends BaseMapper<ReportFunSaleMin, Long> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ReportFunSaleMinExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunSaleMinExample example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunSaleMin> selectByExample(ReportFunSaleMinExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunSaleMin record,
			@Param("example") ReportFunSaleMinExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunSaleMin record, @Param("example") ReportFunSaleMinExample example);

	/**
	 * 当月新增数据中的出售数据
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param cityId
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param userId
	 * @param compId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String, Object>> getFlowAnalysisCountList(@Param("shardCityId")Integer cityId,@Param("areaId")Integer areaId, 
			@Param("regId")Integer regId, @Param("deptId")Integer deptId,@Param("userId")Integer userId, 
			@Param("compId")Integer compId,@Param("startTime")String startTime,@Param("endTime") String endTime);

	/**
	 * 房源状态统计（有钥匙、有图片、有视频、已房勘、微店、真房源、有VR、预订）
	 * @author 臧铁
	 * @since 2017年7月18日
	 * @param cityId
	 * @param map
	 * @return
	 */
	Map<String, Object> getHouseBottomInfoForStatus(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 委托方式统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForSourceConsign(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 房源级别统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForSourceLevel(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	/**
	 * 装修方式统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForSourceFitment(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	/**
	 * 环域统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForRegionRound(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 片区、版块统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForRegionSection(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	/**
	 * 房源用途统计（住宅、别墅、商铺、写字楼）
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForUseage(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);

	/**
	 * 数据分析首页-房客源数据-各出售房源状态统计
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param cityId
	 * @param compId
	 * @param weekTime 本周星期一
	 * @param monthTime 本月一号
	 * @return
	 */
	Map<String, Object> getHouseCustStatusData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("weekTime") String weekTime, @Param("monthTime")String monthTime,@Param("param") Map<String,Object> map);

	/**
	 * 获取有效出售房源总量
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	Integer countAvailableHouse(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("param") Map<String,Object> map);

	/**
	 * 通过楼盘IDs统计房源数量
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param cityId
	 * @param buildIds
	 * @return
	 */
	List<Map<String,Object>> countByBuildIds(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	/**
	 * 通过商圈IDs统计房源数量
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param cityId
	 * @param sectionIds
	 * @return
	 */
	List<Map<String,Object>> countBySectionIds(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	/**
	 * 获取房客源存量数据统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 */
	List<Map<String,Object>> getStoreDataAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 获取房客源存量数据量
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 */
	Integer getStoreDataCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 获取带看或房勘情况
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param param
	 * @return
	 */
	Map<String, Object> getStoreDataDaiKan(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 获取员工或门店存量排名
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getStoreDataRanking(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 通过价格对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getStoreDataAnalysisByPrice(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 通过面积对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getStoreDataAnalysisByArea(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 通过户型对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getStoreDataAnalysisByRoom(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 通过用途对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getStoreDataAnalysisByUseage(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 房客源存量分析--买卖房客源基本情况
	 * @author 臧铁
	 * @since 2017年7月28日
	 * @param cityId
	 * @param map
	 * @return
	 */
	Map<String, Object> getHouseCustBasicStatus(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 数据分析首页-买卖房价购买力分析房源套数
	 * @author 臧铁
	 * @since 2017年8月2日
	 * @param cityId
	 * @param compId
	 * @param caseWhenSql  经过处理的条件   见DataAnalysisUtil.getCaseWhenSql
	 * @param map 
	 * @return
	 */
	List<Map<String, Object>> getHouseBuyingPowerData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseWhenSql")String caseWhenSql, @Param("param")Map<String, Object> map);

	/**
	 * 获取房客源列表
	 * @author 张宏利
	 * @since 2017年8月7日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getCaseList(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);

	public List<HouseCustAddCountDto> getHouseAddCountData(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	public List<HouseCustAddCountDto> getCustAddCountData(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 掌通汇总表统计
	 * @author 朱科
	 * @since 2018年8月31日
	 * @return
	 */
	Map<String, Integer> getAppHouseCustStatusData(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("rangeIds") Set<Integer> rangeIds, 
			@Param("rangeType") Integer rangeType, @Param("deptId")  Integer deptId, @Param("nowTime") String nowTime, @Param("weekTime") String weekTime, @Param("monthTime") String monthTime);

	List<Map<String,Object>> getCompSaleCountByDate(@Param("param")AnalysisForWebParam param);

    void updatePartnerId(@Param("cityId") Integer cityId, @Param("compId") Integer compId,  @Param("deptId") Integer deptId, @Param("partnerId") Integer partnerId);
    void updateOrgPartnerId(@Param("cityId") Integer cityId, @Param("compId") Integer compId,  @Param("orgPath") String deptId, @Param("partnerId") Integer partnerId);
}