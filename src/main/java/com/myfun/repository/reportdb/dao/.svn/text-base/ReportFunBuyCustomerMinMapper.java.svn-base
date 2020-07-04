package com.myfun.repository.reportdb.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.openApi.analysis.param.AnalysisForWebParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.reportdb.po.ReportFunBuyCustomerMin;
import com.myfun.repository.reportdb.po.ReportFunBuyCustomerMinExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;

public interface ReportFunBuyCustomerMinMapper extends BaseMapper<ReportFunBuyCustomerMin, Long> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ReportFunBuyCustomerMinExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunBuyCustomerMinExample example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunBuyCustomerMin> selectByExample(ReportFunBuyCustomerMinExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunBuyCustomerMin record,
			@Param("example") ReportFunBuyCustomerMinExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunBuyCustomerMin record,
			@Param("example") ReportFunBuyCustomerMinExample example);

	/**
	 * 当月新增数据中的求购客源数据
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
	 * 数据分析首页-房客源数据-各求购客源状态统计
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
	 * 获取有效求购客源总量
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	Integer countAvailableHouse(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("param") Map<String,Object> map);
	
	/**
	 * 数据分析首页-买卖房价购买力分析客源人数
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @param cityId
	 * @param compId
	 * @param caseWhenSql  经过处理的条件   见DataAnalysisUtil.getCaseWhenSql
	 * @param map 
	 * @return
	 */
	List<Map<String, Object>> getHouseBuyingPowerData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("caseWhenSql")String caseWhenSql,@Param("param") Map<String, Object> map);
	
	/**
	 * 获取房客源存量数据统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 */
	List<Map<String, Object>> getStoreDataAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

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
	 * 通过用途对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param param
	 * @return
	 */
	@SelectProvider(method = "getStoreDataAnalysisByUseage", type = ReportFunBuyCustomerMinSqlProvider.class)
	@ResultType(Map.class)
	List<Map<String, Object>> getStoreDataAnalysisByUseage(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 获取存量房源热点商圈的分析
	 * @author 方李骥
	 * @since 2017年8月11日
	 * @param cityId
	 * @param param
	 * @return
	 */
	@SelectProvider(method = "getBuildSupplyDemandComparisonForBuy", type = ReportFunBuyCustomerMinSqlProvider.class)
	@ResultType(Map.class)
	List<Map<String, Object>> getBuildSupplyDemandComparisonForBuy(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	List<Map<String,Object>> getCompBuyCustomerCountByDate(@Param("param")AnalysisForWebParam param);

	class ReportFunBuyCustomerMinSqlProvider {
		public String getStoreDataAnalysisByUseage(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap) pMap.get("param");
			String statusType = param.getString("statusType");
			String useage = param.getString("useage");
			String serchRange = param.getString("serchRange");
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append(" select top 10 count(1) counts,ISNULL(c.SOURCE_ID,0) byName from FUN_BUY_CUSTOMER_MIN a ");
			sqlBuilder.append(" join FUN_CUST_DEMAND_SPLIT_4 b on b.CITY_ID = #{shardCityId} and b.CASE_TYPE=3 AND A.BUY_CUST_ID = b.CASE_ID AND a.CITY_ID = b.CITY_ID");
			sqlBuilder.append(" join FUN_CUST_DEMAND_SPLIT_5 c on c.CITY_ID = #{shardCityId} and c.CASE_TYPE=3 AND A.BUY_CUST_ID = c.CASE_ID AND a.CITY_ID = c.CITY_ID");
			sqlBuilder.append(" where a.COMP_ID=#{param.compId} and a.CITY_ID=#{shardCityId} ");
			sqlBuilder.append(" AND a."+serchRange+"=#{param.serchRangeId}");
			if("1".equals(statusType)){
				sqlBuilder.append(" AND a.BUY_CUST_STATUS IN (1,2,4) ");
			}
			if("1".equals(useage)){
				sqlBuilder.append(" AND b.SOURCE_ID = 1 ");
			}else if("2".equals(useage)){
				sqlBuilder.append(" AND b.SOURCE_ID = 3 ");
			}else if("3".equals(useage)){
				sqlBuilder.append(" AND b.SOURCE_ID = 4 ");
			}
			sqlBuilder.append(" group by ISNULL(c.SOURCE_ID,0) order by count(1) desc");
			return sqlBuilder.toString();
		}
		
		public String getBuildSupplyDemandComparisonForBuy(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap) pMap.get("param");
			String statusType = param.getString("statusType");
			String serchRange = param.getString("serchRange");
			Object sectionIds = param.getObject("sectionIds");
			Set<Object> sectionSet = null;
			if(sectionIds!=null){
				sectionSet = (HashSet)sectionIds;
			}
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append(" select top 4 count(1) sectionCustCount,ISNULL(c.SOURCE_ID,0) as sectionId from FUN_BUY_CUSTOMER_MIN a ");
			sqlBuilder.append(" join FUN_CUST_DEMAND_SPLIT_2 c on c.CITY_ID = #{shardCityId} and c.CASE_TYPE=3 AND A.BUY_CUST_ID = c.CASE_ID");
			sqlBuilder.append(" where a.COMP_ID=#{param.compId} and a.CITY_ID=#{shardCityId} ");
			sqlBuilder.append(" AND a."+serchRange+"=#{param.serchRangeId}");
			if(sectionSet!=null && sectionSet.size()>0){
				int index = 1;
				StringBuilder sectionIdBuilder = new StringBuilder();
				for(Object sectionId:sectionSet){
					if(sectionId!=null){
						if(index<sectionSet.size()){
							sectionIdBuilder.append(sectionId);
							sectionIdBuilder.append(",");
						}else{
							sectionIdBuilder.append(sectionId);
						}
					}else{
						if(index==sectionSet.size()){
							sectionIdBuilder =new StringBuilder(sectionIdBuilder.subSequence(0,sectionIdBuilder.length()));
						}
					}
					index ++;
				}
				sqlBuilder.append(" AND c.SOURCE_ID IN (")
				.append(sectionIdBuilder).append(")");
			}
			if("1".equals(statusType)){
				sqlBuilder.append(" AND a.BUY_CUST_STATUS IN (1,2,4) ");
			}
			sqlBuilder.append(" group by ISNULL(c.SOURCE_ID,0) order by sectionCustCount desc");
			return sqlBuilder.toString();
		}
	}

	/**
	 * 掌通汇总表统计
	 * @author 朱科
	 * @since 2018年8月31日
	 * @return
	 */
	Map<String, Integer> getAppCustStatusData(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("rangeIds") Set<Integer> rangeIds, 
			@Param("rangeType") Integer rangeType, @Param("deptId")  Integer deptId, @Param("nowTime") String nowTime, @Param("weekTime") String weekTime, @Param("monthTime") String monthTime);
}