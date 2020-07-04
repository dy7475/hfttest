package com.myfun.repository.reportdb.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.repository.erpdb.dto.ErpFunStatisticTotleDto;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.erpdb.dto.ErpFunStatisticRateDto;
import com.myfun.repository.erpdb.po.ErpFunStatisticTotle;
import com.myfun.repository.reportdb.dto.ReportFunStatisticTotleDto;
import com.myfun.repository.reportdb.po.ReportFunStatisticTotle;
import com.myfun.repository.reportdb.po.ReportFunStatisticTotleExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;

public interface ReportFunStatisticTotleMapper extends BaseMapper<ReportFunStatisticTotle, Long> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ReportFunStatisticTotleExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunStatisticTotleExample example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunStatisticTotle> selectByExample(ReportFunStatisticTotleExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunStatisticTotle record,
			@Param("example") ReportFunStatisticTotleExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunStatisticTotle record,
			@Param("example") ReportFunStatisticTotleExample example);

	/**
	 * 增加工作量统计条数，供JMS消费端调用
	 * @author 张宏利
	 * @since 2016年2月26日
	 * @throws Exception
	 */
	public void addWorkCount(ReportFunStatisticTotle adminRptFunStatisticTotle);
	
	/**
	 * 运营分析-工作量统计
	 * @author 何传强
	 * @since 2017年7月28日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<Map<String,Object>> getWorkCountStatistics(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 运营分析-数据查看统计
	 * @author 张宏利
	 * @since 2017年11月22日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<Map<String,Object>> getWorkCountForDataView(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 获取工作量排名
	 * @author 张宏利
	 * @since 2017年7月31日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> getWorkCountRanking(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 获取工作总量
	 * @author 张宏利
	 * @since 2017年8月1日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public Integer getTotalWorkCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 房客源新增分析-房源新增总量
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @param param
	 * @return
	 */
	public Map<String, Object> getHouseAddTotalData(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 房客源新增分析-客源新增总量
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @param param
	 * @return
	 */
	public Map<String, Object> getCustAddTotalData(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 房客源新增分析-买卖房客源新增量排名
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getHouseCustAddRank(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 工作日志审核时，需要统计某一个员工当天的房勘量，带看量
	 * @param cityId
	 * @param param
	 * @param formatDateTimetoString
	 * @param formatDateTimetoString2
	 * @return
	 */
	public Map<String,Object> countTodayExplrthAndLook(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("userId")Integer userId, @Param("startTime")String startTime, @Param("endTime")String endTime);

	/**
	 * 真房源
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public Map<String, Object> getTrueHouseCountOffMarketing(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> map);

	/**
	 * 查询真房源，带看量
	 * @author 熊刚
	 * @since 2017年7月28日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getTrueHouseDkCount(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	List<Map<String,Object>> getBasicDetails(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 转换率分析报表 - 签单量有合同的
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getSignOperationalDataAnalysisHasDealReport")
	@ResultType(value = Map.class)
	public List<Map<String, Object>> getSignOperationalDataAnalysisHasDealReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 转换率分析报表 - 签单量没有合同的
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getSignOperationalDataAnalysisNoDealReport")
	@ResultType(value = Map.class)
	public List<Map<String, Object>> getSignOperationalDataAnalysisNoDealReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 近一周工作情况统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/6
	 */
	List<ErpFunStatisticTotleDto> getWorkCountList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("userId") Integer userId,@Param("dateTimeStr") String dateTimeStr);

	/**
	 * 首页工作情况报表统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/7
	 */
	List<Map<String,Object>> getUcenterWorkCountReport(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ReportFunStatisticTotleDto> getSalaryWorkCountInfoByUserIds(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("userIds") Integer[] userIds,@Param("startDate") String startDate,@Param("endDate") String endDate);

	//todo
	ReportFunStatisticTotleDto getSalaryWorkCountInfoByUserIds2(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("range") Integer range,@Param("rangeColumn") String rangeColumn,@Param("startDate") String startDate,@Param("endDate") String endDate);

	List<LinkedHashMap<String,Object>> getUcenterWorkCountMap(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
														@Param("rangeType") Integer rangeType, @Param("rangeIds") Set<Integer> rangeIdset,
														@Param("workColumns") List<String> workColumns,
														@Param("startTime") String startTime, @Param("deptId") Integer deptId,
														@Param("endTime")String endTime,@Param("separationConfig")boolean separationConfig, @Param("partnerIdRange") Integer partnerIdRange);

	List<LinkedHashMap<String,Object>> getUcenterWorkCountMapForOrg(@Param("cityId") Integer cityId, @Param("compId") Integer compId,@Param("workColumns") List<String> workColumns,
														@Param("startTime") String startTime,@Param("endTime")String endTime,@Param("separationConfig")boolean separationConfig,
																	@Param("partnerIdRange") Integer partnerIdRange, @Param("whereCause") String whereCause);

	List<Map<String,Object>> getAppUcenterWorkCountRank(@Param("cityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds,
														@Param("workColumn") String workColumn,
														@Param("startTime") String startTime, @Param("endTime") String endTime,@Param("rangeType") Integer rangeType,
														@Param("rangeIds") Set<Integer> rangeIds, @Param("deptId")Integer deptId);
	
	/**
	 * 只给分组的单独用
	 * @author 朱科
	 * @since 2019年2月14日
	 * @return
	 */
	List<Map<String,Object>> getAppUcenterWorkCountRankByGrIds(@Param("cityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds,
			@Param("workColumn") String workColumn,
			@Param("startTime") String startTime, @Param("endTime") String endTime,@Param("rangeType") Integer rangeType,
			@Param("rangeIds") Set<Integer> rangeIds, @Param("deptId")Integer deptId);

	List<Map<String,Object>> getAppUcenterWorkCountRankByType(@Param("cityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds,
			@Param("workColumn") String workColumn,
			@Param("startTime") String startTime, @Param("endTime") String endTime,@Param("rangeType") Integer rangeType,
			@Param("rangeIds") Set<Integer> rangeIds, @Param("deptId")Integer deptId, @Param("lookType")Integer lookType);
	@MapKey("rangeId")
	Map<Integer,Map<String,Integer>> getAppUcenterWorkCountRankByTypeForOrg(@Param("cityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds,
			@Param("workColumn") String workColumn,@Param("whereCause") String whereCause,@Param("groupByColumn") String groupByColumn,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	List<Map<String,Object>> getLookTypeAppUcenterWorkCountRankByGrIds(@Param("cityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds,
			@Param("workColumn") String workColumn,
			@Param("startTime") String startTime, @Param("endTime") String endTime,@Param("rangeType") Integer rangeType,
			@Param("rangeIds") Set<Integer> rangeIds, @Param("deptId")Integer deptId, @Param("lookType")Integer lookType);

	public class ErpFunStatisticTotleSqlProvider{
		
		public static String getOperationalDataAnalysisHouseCustAddCount(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "CREATE_TIME", new String[]{param.getString("startTime"),DateTimeHelper.formatDateTimetoString(param.getString("endTime"),DateTimeHelper.FMT_yyyyMMdd)});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			if("101".equals(caseType)){
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 1, DJ_COUNT, 0)) AS saleAddCount,");
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 3, DJ_COUNT, 0)) AS buyAddCount");
			} else if("102".equals(caseType)) {
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 2, DJ_COUNT, 0)) AS leaseAddCount,");
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 4, DJ_COUNT, 0)) AS rentAddCount");
			}
			sqlBuilder.append(" FROM FUN_STATISTIC_TOTLE  ")
			.append(" WHERE ")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND CITY_ID = #{shardCityId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			sqlBuilder.append(" AND CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND CREATE_TIME <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			
			return sqlBuilder.toString();
		}
		
		public String getOperationalDataAnalysisHouseFkCount(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "CREATE_TIME", new String[]{param.getString("startTime"),DateTimeHelper.formatDateTimetoString(param.getString("endTime"),DateTimeHelper.FMT_yyyyMMdd)});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			if("101".equals(caseType)){
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 1, FK_COUNT, 0)) AS saleFkCount");
			} else if("102".equals(caseType)) {
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 2, FK_COUNT, 0)) AS leaseFkCount");
			}
			sqlBuilder.append(" FROM FUN_STATISTIC_TOTLE  ")
			.append(" WHERE ")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND CITY_ID = #{shardCityId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			sqlBuilder.append(" AND CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND CREATE_TIME <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		public String getOperationalDataAnalysisHouseDkCount(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "CREATE_TIME", new String[]{param.getString("startTime"),DateTimeHelper.formatDateTimetoString(param.getString("endTime"),DateTimeHelper.FMT_yyyyMMdd)});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			if("101".equals(caseType)){
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 1, DK_COUNT, 0)) AS buyDkCount");
			} else if("102".equals(caseType)) {
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 2, DK_COUNT, 0)) AS rentDkCount");
			}
			sqlBuilder.append(" FROM FUN_STATISTIC_TOTLE ")
			.append(" WHERE ")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND CITY_ID = #{shardCityId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			if("101".equals(caseType)){
				sqlBuilder.append(" and CASE_TYPE = 1 ");
			} else if("102".equals(caseType)) {
				sqlBuilder.append(" and CASE_TYPE = 2 ");
			}
			sqlBuilder.append(" AND CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND CREATE_TIME <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		public String getOperationalDataAnalysisHouseCjCount(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "B.SIGN_DATE", new String[]{param.getString("startTime"),DateTimeHelper.formatDateTimetoString(param.getString("endTime"),DateTimeHelper.FMT_yyyyMMdd)});
			String columnName = "saleSignCount";
			if("102".equals(caseType)){
				columnName = "leaseSignCount";
			}
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append(" select C.dateCount,SUM(C.")
			.append(columnName)
			.append(") as ").append(columnName)
			.append(" from (")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			sqlBuilder.append("COUNT(distinct B.DEAL_ID) as ");
			sqlBuilder.append(columnName);
			sqlBuilder.append(" FROM FUN_DEAL　B LEFT JOIN DEAL_USER_RELATIVE C ON B.DEAL_ID = C.DEAL_ID AND B.SIGN_USER_ID = C.USER_ID  AND B.DEAL_AUDIT_STATUS != 3 AND C.RELATE_TYPE =3 ");
			sqlBuilder.append(" where B.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" AND C.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" AND C.REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" AND C.DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" AND C.GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" AND C.ARCHIVE_ID = #{param.archiveId}");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append("AND B.DEAL_TYPE = 101 ");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append("AND B.DEAL_TYPE = 102 ");
			}
			sqlBuilder.append(" AND B.SIGN_DATE >= #{param.startTime}");
			sqlBuilder.append(" AND B.SIGN_DATE <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			sqlBuilder.append(" UNION ALL ");
			sqlBuilder.append(getOperationalDataAnalysisHouseCjNoDealCount(pMap))
			.append(") C group by ").append("C.dateCount");
			return sqlBuilder.toString();
		}
		
		public String getOperationalDataAnalysisHouseCjNoDealCount(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "A.CREATE_TIME", new String[]{param.getString("startTime"),DateTimeHelper.formatDateTimetoString(param.getString("endTime"),DateTimeHelper.FMT_yyyyMMdd)});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append(" SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			if("101".equals(caseType)){
				sqlBuilder.append("sum(iif(A.CASE_TYPE =1 OR A.CASE_TYPE =3,1,0)) as saleSignCount");
			}else if("102".equals(caseType)){
				sqlBuilder.append("sum(iif(A.CASE_TYPE =2 OR A.CASE_TYPE =4,1,0)) as leaseSignCount");
			}
			sqlBuilder.append(" FROM HOUSE_INNERDEAL_ANALYSIS A ");
			sqlBuilder.append(" where A.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" AND A.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" AND A.REG_ID = #{param.serchRangeId} ");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" AND A.DEPT_ID = #{param.serchRangeId} ");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" AND A.GR_ID = #{param.serchRangeId} ");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" AND A.ARCHIVE_ID = #{param.archiveId} ");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append(" AND A.CASE_TYPE IN(1,3)");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append(" AND A.CASE_TYPE IN(2,4)");
			}
			sqlBuilder.append(" AND A.DEAL_ID IS NULL");
			sqlBuilder.append(" AND A.CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND A.CREATE_TIME <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		
		public String getHouseCustAddOperationalDataAnalysisPie(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ");
			if("101".equals(caseType)){
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 1, DJ_COUNT, 0)) AS saleAddCount,");
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 3, DJ_COUNT, 0)) AS buyAddCount");
			} else if("102".equals(caseType)) {
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 2, DJ_COUNT, 0)) AS leaseAddCount,");
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 4, DJ_COUNT, 0)) AS rentAddCount");
			}
			sqlBuilder.append(" FROM FUN_STATISTIC_TOTLE  ")
			.append(" WHERE ")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND CITY_ID = #{shardCityId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append(" AND CASE_TYPE IN(1,3)");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append(" AND CASE_TYPE IN(2,4)");
			}
			sqlBuilder.append(" AND CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND CREATE_TIME <= #{param.endTime}");
			return sqlBuilder.toString();
		}
		public String getTotalDkOperationalDataAnalysisPie(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ");
			if("101".equals(caseType)){
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 1, DK_COUNT, 0)) AS buyDkTotal");
			} else if("102".equals(caseType)) {
				sqlBuilder.append(" SUM (iif(CASE_TYPE = 2, DK_COUNT, 0)) AS rentDkTotal");
			}
			sqlBuilder.append(" FROM FUN_STATISTIC_TOTLE  ")
			.append(" WHERE ")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND CITY_ID = #{shardCityId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append(" AND CASE_TYPE =1");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append(" AND CASE_TYPE =2");
			}
			sqlBuilder.append(" AND CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND CREATE_TIME <= #{param.endTime}");
			return sqlBuilder.toString();
		}
		public String getFkOperationalDataAnalysisPie(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String fkName = "saleFkCount";
			String tableName = "FUN_SALE_MIN";
			String funkanName = "SALE_EXPLRTH";
			if("102".equals(caseType)){
				fkName = "leaseFkCount";
				tableName ="FUN_LEASE_MIN";
				funkanName = "LEASE_EXPLRTH";
			}
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append(" select count(1) as "+fkName+" from "+tableName)
			.append(" WHERE")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND CITY_ID = #{shardCityId} ").append(" AND "+funkanName+" =1 ");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			sqlBuilder.append(" AND CREATION_TIME >= #{param.startTime}")
			.append(" AND CREATION_TIME <= #{param.endTime}");
			return sqlBuilder.toString();
		}
		
		public String getDkOperationalDataAnalysisPie(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String fkName = "buyDkCount";
			String tableName = "FUN_BUY_CUSTOMER_MIN";
			if("102".equals(caseType)){
				fkName = "rentDkCount";
				tableName = "FUN_RENT_CUSTOMER_MIN";
			}
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("")
			.append(" SELECT count(1) as ").append(fkName)
			.append(" FROM ")
			.append( tableName )
			.append(" WHERE")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND HOUSE_LOOK =1 ")
			.append(" AND CITY_ID = #{shardCityId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			sqlBuilder.append(" AND CREATION_TIME >= #{param.startTime}")
			.append(" AND CREATION_TIME <= #{param.endTime}");
			return sqlBuilder.toString();
		}
		
		public String getSignOperationalDataAnalysisPie(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ");
			if("101".equals(caseType)){
				sqlBuilder.append(" SUM(iif(B.SIGN_USER_ID>0,1,0)) as saleSignCount");
			}else if ("102".equals(caseType)){
				sqlBuilder.append(" SUM(iif(B.SIGN_USER_ID>0,1,0)) as leaseSignCount");
			}
			sqlBuilder.append(" FROM FUN_DEAL　B LEFT JOIN DEAL_USER_RELATIVE C ON B.DEAL_ID = C.DEAL_ID  AND B.DEAL_AUDIT_STATUS != 3 AND C.RELATE_TYPE =7")
			.append(" where B.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and C.AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and  C.REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and  C.DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and  C.GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and  C.ARCHIVE_ID = #{param.archiveId}");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append(" AND B.DEAL_TYPE = 101 AND B.DEAL_CUSTOMER_ID>0 ");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append(" AND B.DEAL_TYPE = 102 AND B.DEAL_CUSTOMER_ID>0 ");
			}
			sqlBuilder.append(" AND B.DEAL_ID>0");
			sqlBuilder.append(" AND B.SIGN_DATE >= #{param.startTime}");
			sqlBuilder.append(" AND B.SIGN_DATE <= #{param.endTime}");
			return sqlBuilder.toString();
		}
		
		public String getSignOperationalDataAnalysisNoDealPie(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SELECT ");
			if("101".equals(caseType)){
				sqlBuilder.append("sum(iif(A.CASE_TYPE =3,1,0)) as buySignCount");
			}else if ("102".equals(caseType)){
				sqlBuilder.append("sum(iif(A.CASE_TYPE =4,1,0)) as rentSignCount");
			}
			sqlBuilder.append(" FROM HOUSE_INNERDEAL_ANALYSIS A");
			sqlBuilder.append(" where A.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and A.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and A.REG_ID = #{param.serchRangeId} ");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and A.DEPT_ID = #{param.serchRangeId} ");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and A.GR_ID = #{param.serchRangeId} ");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and A.ARCHIVE_ID = #{param.archiveId} ");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append(" AND A.CASE_TYPE IN(3)");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append(" AND A.CASE_TYPE IN(4)");
			}
			sqlBuilder.append(" AND A.DEAL_ID IS NULL");
			sqlBuilder.append(" AND A.CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND A.CREATE_TIME <= #{param.endTime}");
		
			return sqlBuilder.toString();
		}
		
		public String getHouseCustAddOperationalDataAnalysisReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});

			String serchRange = param.getString("serchRange");
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			sqlBuilder.append(" SUM (iif(CASE_TYPE = 1, DJ_COUNT, 0)) AS saleAddCount,");
			sqlBuilder.append(" SUM (iif(CASE_TYPE = 3, DJ_COUNT, 0)) AS buyAddCount,");
			sqlBuilder.append(" SUM (iif(CASE_TYPE = 2, DJ_COUNT, 0)) AS leaseAddCount,");
			sqlBuilder.append(" SUM (iif(CASE_TYPE = 4, DJ_COUNT, 0)) AS rentAddCount");
			sqlBuilder.append(" FROM FUN_STATISTIC_TOTLE  ")
			.append(" WHERE ")
			.append(" CITY_ID = #{shardCityId} ")
			.append(" AND COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			sqlBuilder.append(" AND CREATE_TIME >= #{param.startTime}")
			.append(" AND CREATE_TIME <= #{param.endTime}");
			sqlBuilder.append(" group by ")
			.append(queryColumn);
			return sqlBuilder.toString();
		}
		public String getFkOperationalDataAnalysisReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			sqlBuilder.append(" SUM (iif(CASE_TYPE = 1, FK_COUNT, 0)) AS saleFkCount,");
			sqlBuilder.append(" SUM (iif(CASE_TYPE = 2, FK_COUNT, 0)) AS leaseFkCount");
			sqlBuilder.append(" FROM FUN_STATISTIC_TOTLE  ")
			.append(" WHERE ")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND CITY_ID = #{shardCityId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			sqlBuilder.append(" AND CREATE_TIME >= #{param.startTime}")
			.append(" AND CREATE_TIME <= #{param.endTime}");
			sqlBuilder.append("group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		public String getDkOperationalDataAnalysisReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			sqlBuilder.append(" SUM (iif(CASE_TYPE = 1, DK_COUNT, 0)) AS buyDkCount,");
			sqlBuilder.append(" SUM (iif(CASE_TYPE = 2, DK_COUNT, 0)) AS rentDkCount");
			sqlBuilder.append(" FROM FUN_STATISTIC_TOTLE ")
			.append(" WHERE ")
			.append(" COMP_ID = #{param.compId}")
			.append(" AND CITY_ID = #{shardCityId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and USER_ID = #{param.serchRangeId}");
			}
			sqlBuilder.append(" AND CREATE_TIME >= #{param.startTime}")
			.append(" AND CREATE_TIME <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		public String getSignOperationalDataAnalysisHasDealReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String serchRange = param.getString("serchRange");
			String caseType = param.getString("caseType");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "B.SIGN_DATE", new String[]{param.getString("startTime"),param.getString("endTime")});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,")
			.append("sum(iif(B.SIGN_USER_ID>0 AND B.DEAL_TYPE = 101,1,0)) as saleSignCount,")
			.append("sum(iif(B.SIGN_USER_ID>0 AND B.DEAL_TYPE = 102,1,0)) as leaseSignCount")
			.append(" FROM FUN_DEAL　B LEFT JOIN DEAL_USER_RELATIVE C ON B.DEAL_ID = C.DEAL_ID AND B.SIGN_USER_ID = C.USER_ID  AND B.DEAL_AUDIT_STATUS != 3 AND C.RELATE_TYPE =3 ")
			.append(" where B.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" AND C.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" AND C.REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" AND C.DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" AND C.GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" AND C.ARCHIVE_ID = #{param.archiveId}");
			}
			if("101".equals(caseType)){
				sqlBuilder.append(" AND B.DEAL_TYPE = 101");
			} else if ("102".equals(caseType)){
				sqlBuilder.append(" AND B.DEAL_TYPE = 102");
			}
			
			sqlBuilder.append(" AND B.SIGN_DATE >= #{param.startTime}");
			sqlBuilder.append(" AND B.SIGN_DATE <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		public String getSignOperationalDataAnalysisNoDealReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "A.CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,")
			.append("sum(iif(A.CASE_TYPE =1 OR A.CASE_TYPE =3,1,0)) as saleSignCount,")
			.append("sum(iif(A.CASE_TYPE =2 OR A.CASE_TYPE =4,1,0)) as leaseSignCount")
			.append(" FROM HOUSE_INNERDEAL_ANALYSIS A")
			.append(" where A.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" AND A.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" AND A.REG_ID = #{param.serchRangeId} ");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" AND A.DEPT_ID = #{param.serchRangeId} ");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" AND A.GR_ID = #{param.serchRangeId} ");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" AND A.ARCHIVE_ID = #{param.archiveId} ");
			}
			sqlBuilder.append(" AND A.DEAL_ID IS NULL");
			sqlBuilder.append(" AND A.CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND A.CREATE_TIME <= #{param.endTime}");
			
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		public String getOperationsAndProfitCountOffReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String dateType = param.getString("dateType");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			if("GROUP".equals(serchRange)){
				serchRange = "GR";
			}
			String dimension = param.getString("dimension");
			String areaFlag = param.getString("areaFlag");
			String queryDimensionColumn = DataAnalysisUtil.getRangeGroupbyStr(dimension, areaFlag, "");
			String dateQueryColumn = DateUtil.getDateDimensionGroupBy(dateType, "CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(" SUM (ZFY_COUNT) AS trueHouseCount,SUM (DK_COUNT) AS dkCount, ")
			.append(dateQueryColumn)
			.append(" AS countDate,")
			.append(queryDimensionColumn)
			.append(" AS range from FUN_STATISTIC_TOTLE ")
			.append(" where ")
			.append(" COMP_ID =#{param.compId}")
			.append(" AND CITY_ID = #{shardCityId}");
			
			if("101".equals(caseType)){
				sqlBuilder.append(" and CASE_TYPE =1");
			}else if ("102".equals(caseType)){
				sqlBuilder.append(" and CASE_TYPE =2");
			}
			if(!"COMP".equals(serchRange)){
				sqlBuilder.append(" and ")
				.append(serchRange).append("_ID = #{param.serchRangeId}");
			}
			sqlBuilder.append(" AND CREATE_TIME >=#{param.startTime}  AND CREATE_TIME<=#{param.endTime}")
			.append(" group by ")
			.append(dateQueryColumn)
			.append(",")
			.append(queryDimensionColumn);
			return sqlBuilder.toString();
		}
	}


	/**
	 * 运营分析与业绩报表
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getOperationsAndProfitCountOffReport")
	@ResultType(value = Map.class)
	public List<Map<String, Object>> getOperationsAndProfitCountOffReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 增加工作量统计条数，供JMS消费端调用
	 * @author 张宏利
	 * @since 2016年2月26日
	 * @throws Exception
	 */
	public void addWorkCount(ErpFunStatisticTotle erpFunStatisticDetail) throws Exception;

	/**
	 * 数据分析-存量数据条件下-出售房源库存分析
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public Map<String, Object> getFlowAnalysisStockDataForSale(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	/**
	 * 数据分析-存量数据条件下-求购房源库存分析
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public Map<String, Object> getFlowAnalysisStockDataForBuy(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	/**
	 * 数据分析-存量数据条件下-出租房源库存分析
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public Map<String, Object> getFlowAnalysisStockDataForLease(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	/**
	 * 数据分析-存量数据条件下-求租房源库存分析
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public Map<String, Object> getFlowAnalysisStockDataForRent(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);

	/**
	 * 查询带看率 --查询时间范围内，新增的客源
	 * @author 何传强
	 * @since 2017年7月24日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<ErpFunStatisticRateDto> getDaiKanRateCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 房勘率
	 * @author 何传强
	 * @since 2017年7月25日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<ErpFunStatisticRateDto> getFunKanRateCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 签单量,签单率(有合同)
	 * @author 何传强
	 * @since 2017年7月25日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<ErpFunStatisticRateDto> getSignRateCountHasDeal(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 签单量,签单率 (无合同)
	 * @author 何传强
	 * @since 2017年7月25日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<ErpFunStatisticRateDto> getSignRateCountNoDeal(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 查询签单量,签单率-报表
	 * @author 何传强
	 * @since 2017年7月27日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<ErpFunStatisticRateDto> getSignRateCountReportNoDeal(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 查询签单量,签单率-报表
	 * @author 何传强
	 * @since 2017年7月27日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<ErpFunStatisticRateDto> getSignRateCountReportHasDeal(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 房勘率-报表
	 * @author 何传强
	 * @since 2017年7月27日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getFunKanRateCountReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 查询带看率 --查询时间范围内，新增的客源-报表
	 * @author 何传强
	 * @since 2017年7月27日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getDaiKanRateCountReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	
	/**
	 * 转换率分析图表 - 带看量排名
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getConversionRatioAnalysisOffDkan(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 带看量对比
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getDkContrastOffRatioAnalysis(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 房勘量对比
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getFkContrastOffRatioAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交对比
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getCjContrastOffRatioAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 带看量总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public Map<String, Object> getTotalDkContrastOffRatioAnalysis(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 房勘量总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public Map<String, Object> getTotalFkContrastOffRatioAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public Map<String, Object> getTotalCjContrastOffRatioAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 转换率分析图表 - 成交总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getOperationalDataAnalysisHouseCustAddCount")
	public List<Map<String, Object>> getOperationalDataAnalysisHouseCustAddCount(@Param("shardCityId")Integer cityId,
			@Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getOperationalDataAnalysisHouseFkCount")
	public List<Map<String, Object>> getOperationalDataAnalysisHouseFkCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getOperationalDataAnalysisHouseDkCount")
	@ResultType(value = Map.class)
	public List<Map<String, Object>> getOperationalDataAnalysisCustDkCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量有合同
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getOperationalDataAnalysisHouseCjCount")
	@ResultType(value = Map.class)
	public List<Map<String, Object>> getOperationalDataAnalysisHouseCjCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量无合同
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getOperationalDataAnalysisHouseCjNoDealCount")
	@ResultType(value = Map.class)
	public List<Map<String, Object>> getOperationalDataAnalysisHouseCjNoDealCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 新增总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getHouseCustAddOperationalDataAnalysisPie")
	@ResultType(value = Map.class)
	public Map<String, Object> getHouseCustAddOperationalDataAnalysisPie(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 房勘总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getFkOperationalDataAnalysisPie")
	@ResultType(value = Map.class)
	public Map<String, Object> getFkOperationalDataAnalysisPie(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 转换率分析图表 - dk总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getDkOperationalDataAnalysisPie")
	@ResultType(value = Map.class)
	public Map<String, Object> getDkOperationalDataAnalysisPie(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析柱状图 - 成交总量有合同的
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getSignOperationalDataAnalysisPie")
	@ResultType(value = Map.class)
	public Map<String, Object> getSignOperationalDataAnalysisDealPie(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 转换率分析柱状图 - 成交总量没有合同的
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getSignOperationalDataAnalysisNoDealPie")
	@ResultType(value = Map.class)
	public Map<String, Object> getSignOperationalDataAnalysisNoDealPie(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getHouseCustAddOperationalDataAnalysisReport")
	public List<Map<String, Object>> getHouseCustAddOperationalDataAnalysisReport(@Param("shardCityId")Integer cityId,
			@Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getFkOperationalDataAnalysisReport")
	public List<Map<String, Object>> getFkOperationalDataAnalysisReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getDkOperationalDataAnalysisReport")
	@ResultType(value = Map.class)
	public List<Map<String, Object>> getDkOperationalDataAnalysisReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 运营分析与业绩报表
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunStatisticTotleSqlProvider.class ,method = "getTotalDkOperationalDataAnalysisPie")
	@ResultType(value = Map.class)
	public Map<String, Object> getTotalDkOperationalDataAnalysisPie(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 有合同成交率-报表
	 * @author 何传强
	 * @since 2017年7月29日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getSignRateCountHasDealReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 无合同成交率-报表
	 * @author 何传强
	 * @since 2017年7月29日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getSignRateCountNoDealReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	public List<Map<String, Object>> getSignDaiKanCountReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	public List<Map<String,Object>> PerformanceMarketingAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	public List<Map<String,Object>> getOperationsAndProfitCountOffChart( @Param("param")Map<String, Object> param);
	/**
	 * 查询工作总量的排名
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTotalWorkCountRanking(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map); 

	List<Map<String,Object>> getStatisticTotle(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> map,@Param("userIdList")List<Integer> userIdList); 
	ErpFunStatisticRateDto getStatistic(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> map); 

	Map<String,Integer> getProfitPerCapitaWorkCountOffRangeList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("rangeColumn") String rangeColumn, @Param("rangeList") List<Integer> rangeList,
			@Param("startTime")String startTime, @Param("endTime")String endTime);
	
	/**
	 * 新版首页工作量统计
	 * 
	 * @author 张宏利
	 * @since 2018年2月5日
	 * @param cityId
	 * @param compId
	 * @param manageRangIds
	 * @return
	 */
	List<Map<String, Object>> getUcenterWorkCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("rangeType") Integer rangeType, @Param("manageRangIds") Set<Integer> manageRangIds,
			@Param("workColumns") Set<String> workColumns,
			@Param("startTime") String startTime);
	
	/**
	 * 新版首页工作量统计排名
	 * 
	 * @author 朱科
	 * @since 2018年4月20日
	 * @param cityId
	 * @param compId
	 * @param manageRangIds
	 * @return
	 */
	List<Map<String, Object>> getUcenterWorkCountRank(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
			@Param("workColumns") Set<String> workColumns,
			@Param("startTime") String startTime, @Param("rangeType")Integer rangeType, @Param("rangeIds") Set<Integer> rangeIds, @Param("deptId") Integer deptId);
	
	/**
	 * 首页管理岗带看排行统计
	 * @author 张宏利
	 * @since 2018年2月7日
	 * @param cityId
	 * @param compId
	 * @param manageLevel
	 * @param manageRangIds
	 * @param startTime
	 * @param houseCust
	 * @return
	 */
	List<Map<String, Object>> getManageDaiKanRank(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
			@Param("manageLevel") Byte manageLevel, @Param("manageRangIds") Set<Integer> manageRangIds,
			@Param("startTime") String startTime, @Param("countColumn") String countColumn);

	List<Map<String,Object>> getModelDataList(@Param("shardCityId")Integer cityId,@Param("param")Map<String,Object> param);


	/**
	 * @author 邓永洪
	 * @since 2018/4/12
	 * @tag 从数据库获取房客源新增数据
	 */
	List<Map<String,Object>> getAddDataList(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> param);

	/**
	 * @author 邓永洪
	 * @since 2018/4/12
	 * @tag 查询当前用户的房客源新增数量
	 */
	List<Map<String,Object>> getCurrentUserDataList(@Param("shardCityId")Integer cityId,  @Param("compId")Integer compId,
													@Param("dateTime") String dateTime,@Param("realRange") String realRange, @Param("rangeId")String rangeId);

	/**
	 * 获取公司员工指定日期范围跑分排名
	 * @author 朱科
	 * @since 2018年7月19日
	 * @return
	 */
	List<ReportFunStatisticTotleDto> getSpecifyWorkCountList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dateTime")String dateTime);
	/**
	 * APP查询门店范围返人均
	 * @author 朱科
	 * @since 2018年8月2日
	 * @return
	 */
	List<LinkedHashMap<String,Integer>> getAppWorkCountAverageStatistic(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
																		@Param("rangeId") Integer rangeId, @Param("rangeType") Integer rangeType,
																		@Param("workColumns") List<String> workColumns, @Param("startTime") String startTime,
																		@Param("deptId")  Integer deptId);
	
	/**
	 * 掌通工作量汇总表
	 * @author 朱科
	 * @since 2018年8月31日
	 * @return
	 */
	Map<String,Object> getAppWorkCountAchieveStatisticsSummaryRank(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("rangeIds") Set<Integer> rangeIds, @Param("rangeType") Integer rangeType,
			@Param("workColumns") List<String> workColumns, @Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("deptId")  Integer deptId,@Param("separationConfig") boolean separationConfig, @Param("partnerIdRange") Integer partnerIdRange);
	Map<String,Object> getAppWorkCountAchieveStatisticsSummaryRankForOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("workColumns") List<String> workColumns, @Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("whereCause") String whereCause,
			@Param("separationConfig") boolean separationConfig, @Param("partnerIdRange") Integer partnerIdRange);

	
	/**
	 * 网站工作量汇总表	兼容网站查询数据，
	 * @author 朱科
	 * @since 2018年8月31日
	 * @return
	 */
	Map<String,Object> getWebWorkCountAchieveStatisticsSummaryRank(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("rangeIds") Set<Integer> rangeIds, @Param("rangeType") Integer rangeType,
			@Param("workColumns") List<String> workColumns, @Param("startTime") String startTime, @Param("deptId")  Integer deptId);
	
	
	/**
	 * 掌通工作量排行版
	 * @author 朱科
	 * @since 2018年9月3日
	 * @return
	 */
	List<Map<String, Object>> getAppWorkCountAchieveStatisticsChooseRank(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("rangeIds") Set<Integer> rangeIds, @Param("rangeType") Integer rangeType, @Param("workColumns") List<String> workColumns,
			@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("deptId") Integer deptId, @Param("lookType") Integer lookType, 
			@Param("assessmentType") Integer assessmentType, @Param("selfDeptId")Integer selfDeptId, @Param("isFjdFlag") boolean isFjdFlag);


	List<Map<String, Object>> getAppWorkCountAchieveStatisticsChooseRankForOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds,
			@Param("workColumns") List<String> workColumns, @Param("groupByColumn")String groupByColumn,
			@Param("whereCause") String whereCause,@Param("assessmentType") Integer assessmentType,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 掌通工作量排行版详情接口
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	Map<String, Integer> getStatisticsRankCountTotal(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("lookType") Integer lookType, @Param("lookTypeId") Integer lookTypeId, @Param("workColumns") List<String> workColumns, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("deptId")  Integer deptId, @Param("selfDeptId")  Integer selfDeptId,
													 @Param("separationConfig") boolean separationConfig, @Param("partnerIdRange") Integer partnerIdRange);
}


