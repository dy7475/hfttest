package com.myfun.repository.erpdb.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.myfun.erpWeb.managecenter.financialStatements.param.PaySettlementListParam;
import com.myfun.erpWeb.managecenter.param.DealStatictisListParam;
import com.myfun.erpWeb.managecenter.profit.param.ProfitBaseInfoParam;
import com.myfun.erpWeb.managecenter.profit.vo.ProfitBaseInfoDto;
import com.myfun.erpWeb.managecenter.profit.vo.ProfitDetailVo;
import com.myfun.erpWeb.statisticalAnalysis.param.DealAnalysisParam;
import com.myfun.erpWeb.statisticalAnalysis.param.ProfitAnalyseParam;
import com.myfun.repository.erpdb.dto.ErpFunProfitDto;
import com.myfun.repository.erpdb.dto.ErpProfitMessageFormDto;
import com.myfun.repository.erpdb.mapper.sqlProvider.ErpFunProfitSqlProvider;
import com.myfun.repository.erpdb.param.ErpFunProfitParam;
import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import com.myfun.repository.erpdb.param.ErpProfitMessageFormParam;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import com.myfun.repository.erpdb.po.ErpFunProfitExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunProfitMapper extends BaseMapper<ErpFunProfit, ErpFunProfit> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunProfitExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunProfitExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunProfit> selectByExample(ErpFunProfitExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunProfit record,@Param("example") ErpFunProfitExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunProfit record,@Param("example") ErpFunProfitExample example);

	@SelectProvider(type=ErpFunProfitSqlProvider.class ,method = "getProfitCount")
	void getProfitCount(@Param("shardCityId")Integer cityId,@Param("param") DaoBaseParam param,
			@Param("queryStr")String queryStr);

	List<Map<String, Object>> getCompProfitOffHalfYear(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	List<Map<String, Object>> getCompActualProfitAndPerProfit(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	List<Map<String, Object>> getProfitCountOffUser(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	List<Map<String, Object>> getTotalProfitOffDealAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Map<String, Object>> getProfitDateCount(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Map<String,Object>> getTotalProfiTcountList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);
	
	@SelectProvider(type=ErpFunProfitSqlProvider.class ,method = "getOperationsAndProfitCountOffReport")
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@ResultType(value=Map.class)
	List<Map<String, Object>> getOperationsAndProfitCountOffReport(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);
	String getSalaryTotal(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);
	
	List<Map<String,Object>> getRankInformation(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);
	//求出当前经纪人排名信息
	Map<String,Object> getRankByArchiveId(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);
	//求出当前经纪人前一名排名信息
	Map<String,Object> getRankBeforeByArchiveId(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);

	BigDecimal getTolalRealProfitByDealId(@Param("shardCityId")Integer cityId, @Param("dealId")Integer dealId);

	String getProfitTotalOffRangeList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("rangeColumn") String rangeColumn, @Param("rangeList") List<Integer> rangeList,@Param("startTime")String startTime,@Param("endTime") String endTime);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	String getProfitPerCapitaOffRangeList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("rangeColumn") String rangeColumn, @Param("rangeList") List<Integer> rangeList,
			@Param("startTime")String startTime,@Param("endTime") String endTime);
	
	List<ErpProfitMessageFormDto> getProfitMessageFormList(@Param("shardCityId")Integer cityId, @Param("param")ErpProfitMessageFormParam param);
	
	int updateProfitMessageStatus(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param, @Param("IDs")String [] IDs);

	List<Map<String, Object>> selectProFitList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("param")ErpPerformanceAssessmentCountParam param);

	Integer updateProfitValidFlag(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("param")ErpProfitMessageFormParam param);

	Long selectProFitCount(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("param")ErpPerformanceAssessmentCountParam param);

	List<ErpFunProfitDto> getProfitList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("startTime")Date startTime,
										@Param("manageRangIds") Set<Integer> manageRangIds,@Param("groupRange") Integer groupRange,@Param("moneyCloumn")String moneyCloumn );

	List<Map<String, Object>> getCompProfitOffHalfYearForHomePage(@Param("shardCityId")Integer cityId, @Param("param")ErpFunProfitParam param);
	
	List<Map<String,Object>> getPersonalRank(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("startTime")String startTime, @Param("moneyCloumn")String moneyCloumn );

	List<Map<String,Object>> getThisYearProfitTrend(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
													@Param("realRange")String realRange,@Param("serchRangeReal") String serchRangeReal,
													@Param("serchRangeId")Integer serchRangeId, @Param("dateTime") String dateTime,
													@Param("dimension")String dimension);

	List<Map<String,Object>> getHalfProfitTrend(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("serchRangeId")String serchRangeId,
												@Param("realRange")String realRange, @Param("dateTime")String dateTime);


    List<ProfitDetailVo> getProfitDetailInfoList(@Param("shardCityId")Integer cityId, @Param("param") Map<String,Object> paramMap);

	List<ProfitBaseInfoDto> getProfitBaseInfoList(@Param("shardCityId")Integer cityId, @Param("param")ProfitBaseInfoParam param);

	Map<String,Object> getProfitStatistics(@Param("shardCityId")Integer cityId, @Param("param")ProfitBaseInfoParam param);


	Integer countProfitBaseInfo(@Param("shardCityId")Integer cityId, @Param("param")ProfitBaseInfoParam param);
	
	List<ErpFunProfit> getProfitByMap(@Param("shardCityId") Integer cityId, @Param("param") DealStatictisListParam param, @Param("dealIds") List<Integer> dealId);
	
	Map<String,Object> getProfitData(@Param("shardCityId") Integer cityId,@Param("param") DealStatictisListParam param);
	
	List<ErpFunProfit> getProfitListByDealIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("param") PaySettlementListParam param);

	List<ErpFunProfitDto> getFunProfitDispatchCountChart(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunProfitDto> getFunProfitSourceCountChart(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunProfitDto> getCompTotalProfit(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunProfitDto> getSSProfitAnalyse(@Param("shardCityId") Integer cityId,@Param("param") ProfitAnalyseParam param);

	List<ErpFunProfitDto> getYSProfitAnalyse(@Param("shardCityId") Integer cityId,@Param("param") ProfitAnalyseParam param);

	@UpdateProvider(method ="updateProfitProportion", type=ErpFunProfitSqlProvider.class)
	void updateProfitProportion(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId, @Param("dealId") Integer dealId,@Param("profitPercentRule")
			Integer profitPercentRule,@Param("needFieldName") String needFieldName, @Param("performanceType") int performanceType);

	void updateSetSettleTime( ErpFunProfit funProfit);

	ErpFunProfit getFunProfit(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("profitId") Integer profitId);

	void updatePerformanceBySysPara(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("realPerformance") BigDecimal realPerformance,@Param("needPerformance") BigDecimal needPerformance,@Param("performanceType") String performanceType,@Param("paramValue")String paramValue);

	ErpFunProfitDto getPerformanceDto(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("realPerformance") BigDecimal realPerformance,@Param("needPerformance") BigDecimal needPerformance,@Param("performanceType") String performanceType);

	void updatePerformance(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("realPerformance") BigDecimal realPerformance,@Param("needPerformance") BigDecimal needPerformance,@Param("realcompProfitMoney") BigDecimal realcompProfitMoney,@Param("needcompReceivableMoney") BigDecimal needcompReceivableMoney,@Param("performanceType") String performanceType);

	Integer countProfitByDealId(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId);

	List<ErpFunProfit> getProfitListByDealIdAndCompId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("dealId") Integer dealId,@Param("type") Integer type);

	void updateByDealIdAndCompId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("dealId") Integer dealId,@Param("dealVerifyTime") String dealVerifyTime,@Param("settleFlagChecked") Integer settleFlagChecked);

	List<Map<String,Object>> getDealAnalysis(@Param("shardCityId")Integer cityId,@Param("param") DealAnalysisParam param);

	/**
	 * 将某个人的所有未发放的业绩取消选中
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/1
	 */	
	void updateByArchiveIdAndCompId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("archiveId") Integer archiveId);

	/**
	 *	将指定的业绩选中
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/1
	 */
	void updateProfitSettleFlag(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("archiveId") Integer archiveId,@Param("createDate")String createDate,@Param("profitIds") String[] profitIds);

	List<ErpFunProfitDto> getProfitListByArchiveIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("flag")Byte flag,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("archiveIds") Set<Integer> archiveIds);
	
	/**
	 * 掌通汇总表统计
	 * @author 朱科
	 * @since 2018年8月31日
	 * @return
	 */
	Map<String, Integer> getAppCompProfit(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("rangeIds") Set<Integer> rangeIds, 
			@Param("rangeType") Integer rangeType, @Param("startTime") String startTime, @Param("deptId")  Integer deptId);

	List<ErpFunProfitDto> getSimpleDealData(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("serchRange") String serchRange,@Param("serchRangeId") Integer serchRangeId,@Param("dataType") Integer dataType,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("dateRange") String dateRange);

	List<ErpFunProfit> getProFitListByDealId(@Param("shardCityId")Integer shardCityId,@Param("compId") Integer compId, @Param("dealId")Integer dealId);

	void updateHouseBasePerformanceBySysPara(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("realPerformance") BigDecimal realPerformance,@Param("needPerformance") BigDecimal needPerformance,@Param("performanceType") String performanceType,@Param("paramValue")String paramValue);

	
	/**
	 * 更新指定的业绩数据为null
	 * 如果没有业绩分配人，但是有业绩ID，那么说明是业绩模板或者业绩分配人被移除的情况，需要将原有业绩数据人员置空
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年9月21日 上午11:42:44
	 */
	void updateProfitUserToNull(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("dealId") Integer dealId, @Param("profitIdSet") Set<Integer> profitIds);
	
	/**
	 * 将业绩模板没有分配人的业绩数据置空
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年9月21日 上午11:43:00
	 */
	void updateProfitTypeWithNoUser(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("dealId") Integer dealId);

	void updateDoubleProportion(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("dealId") Integer dealId);
	
	/**
	 * 删除钥匙相关业绩
	 * @param cityId
	 * @param compId
	 * @param userId
	 */
	void deleteFunProfitByKey(@Param("shardCityId")Integer cityId ,@Param("compId") Integer compId, @Param("userId") Integer userId);

	void insertSelectiveNewOrg(@Param("param") ErpFunProfit insertModel,@Param("dbFieldPath") String dbFieldPath,@Param("orgIds") String orgIds);
}